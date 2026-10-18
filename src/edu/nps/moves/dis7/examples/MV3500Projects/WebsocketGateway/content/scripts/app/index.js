/* global google, dis */

var map;
var websocket;

/** A likely map location */
var montereyLocation = new google.maps.LatLng(36.595, -121.877);

/** Marker for the entity represented by this web browser's location */
var ourMarker;

/** current location of the device running this browser, as defined by geolocation api */
var browserPosition;

/** Hash table Used to keep track of all entities in the world */
var allEntities = {};

/** EntityStatePdu for the entity represented by this page. This is
 *  periodically sent as a heartbeat, so others can find us. 
 */
var espdu = new dis.EntityStatePdu();
console.log(JSON.stringify(espdu));

/** Used to convert DIS earth-centered coordinates to lat/lon/alt */
var conversion = new dis.CoordinateConversion();

/** benchmarking */
var messageCount = 0;
var startTime = new Date();

// Set the  initialize function to run on page load
google.maps.event.addDomListener(window, 'load', initialize);

/**
 * Initialize the map and websocket
 * 
 * @returns {undefined}
 */
function initialize()
{
    // Initialize the PDU that represents this web browser page. The
    // geolocation API is used to place this entity whereever the web
    // browser happens to be located. For example, if the computer running
    // this web browser page is in Orlando, the icon will drop in Orlando.

    // Entity ID
    espdu.entityID.site = 42;
    espdu.entityID.application = 17;
    espdu.entityID.entity = Math.round(Math.random() * 16000); // Unique (ish) ID

    // What type of entity this is--in this case a dismounted infantry guy
    espdu.entityType.entityKind = 3;   // life form
    espdu.entityType.domain = 1;       // land
    espdu.entityType.country = 225;    // US
    espdu.entityType.cat = 1;          // dismounted infantry
    espdu.entityType.subcategory = 17; // Mini-14! A-Team roolz!
    espdu.entityType.specific = 1;     // number of people

    espdu.timestamp = 1;               // Timestamp is bogus--should fix this. Just needs to be incremented at a miminim

    // Use the geolocation API to find the current location
    // Firefox keeps asking every time this is called, and you can't
    // get in fast enough to choose the "always allow" function. 
    window.setInterval(getLocation, 5000);
    // Send our state periodically 
    window.setInterval(heartbeat, 1000);
    // periodically prune entities that we haven't heard from lately
    window.setInterval(prune, 60000);

    // The region of the map that's visible, and where it's centered.
    var mapOptions =
            {
                center: montereyLocation,
                zoom: 14,
                mapTypeId: google.maps.MapTypeId.ROADMAP
            };
    map = new google.maps.Map(document.getElementById("map-canvas"), mapOptions);

    // Compatiability checks--not all web browsers support Websockets.
    // note that the host portion of the URL (localhost here) MUST
    // be changed to a DNS name or IP to reach it from off-host. The
    // existing localhost is just there for development purposes.
    if (window.WebSocket)
        websocket = new WebSocket("ws://localhost:8282");//, "nve");
    else if (window.MozWebSocket)
        websocket = new MozWebSocket("ws://localhost:8282");//, "nve");
    else
        alert("This web browser does not support web sockets");

    // Set the format we want to use to receive binary messages
    websocket.binaryType = 'arraybuffer';

    // Attach functions to the the web socket for various events
    websocket.onopen = function (evt) {
        console.log("Opened websocket");
    };//console.log("websocket onopen");};
    websocket.onclose = function (evt) {
        console.log("websocket close", evt.data);
    };
    websocket.onerror = function (evt) {
        console.log("websocket error", evt.data);
    };

    /** Handle the messages sent from the server to us here. We receive binary
     * DIS from the server over the web socket.
     * @param {event} evt The receive event object. Contains the binary data to decode
     */
    websocket.onmessage = function (evt)
    {
        // Factory object for creating new PDUs from binary data
        var pduFactory = new dis.PduFactory();

        // InputStream is modeled on a Java input stream. Pass it binary data,
        // and we will read through it, while input stream maintains a current
        // place marker
        //console.log(evt.data);
        //var inputStream = new dis.InputStream(evt.data);

        var disMessage = pduFactory.createPdu(evt.data);

        // You can trap the various types of PDU here, and
        // probably call a specific function to handle each
        // type of message
        switch (disMessage.pduType)
        {
            case 1:
                console.log("ESPDU");
                break;

                // We don't actually do any logic with these yet
            case 2:
                console.log("FirePdu");
                return;
            default:
                return;
        }

        // The ESPDU message sent by the server. Note that we do not attempt
        // to determine the type of PDU sent by the server; they're all ESPDUs,
        // or should be.
        //var disMessage = new dis.EntityStatePdu();
        //console.log(evt.data);
        //var disMessage = eval(evt.data);
        //console.log(disMessage);

        // Non-ESPDUs will fail here; that's slow, but OK. You can
        // filter out all but ESPDUs on the server side if you like,
        // or do a test on this side (before decoding) to make sure
        // the incoming message is an ESDPU, the only type we handle.
        //disMessage.initFromBinaryDIS(inputStream);

        // Some instrumentation for performance. This is useful if hooked
        // up to an AIS feed, for example.

        messageCount++;
        if (messageCount % 10000 === 0)
        {
            var timeNow = new Date();
            var difference = timeNow.getTime() - startTime.getTime();
            console.log("Packets per second for 10K packets: ", 10000 / difference * 1000);
            startTime = new Date();
            console.log(JSON.stringify(disMessage));
        }

        // Retrieve the entity ID from the DIS message, convert it to a JSON
        // string, and then use that as a sleazy key into a "hash table" consisting
        // of object attributes.

        var entityID = disMessage.entityID;
        var eidString = JSON.stringify(entityID);

        // Convert from DIS global coordinates to latitude/longtitude
        var latLonAlt = conversion.convertDisToLatLongInDegrees(disMessage.entityLocation);

        // We have an attribute on this object named the JSON text string, with a
        // value of the marker data. Look that up.
        var theMarker = allEntities[eidString];

        // If it's not found, that means it's the first time we've heard of it. Create
        // a new one.
        if (theMarker === undefined)
        {
            theMarker = {};

            var contentString = "<b>Entity ID:</b>" + JSON.stringify(disMessage.entityID) + "<br>";
            contentString = contentString + "<b>Entity Type:</b>" + JSON.stringify(disMessage.entityType) + "<br>";
            var infowindow = new google.maps.InfoWindow({content: contentString});

            var newEntityLocation = new google.maps.LatLng(latLonAlt.latitude, latLonAlt.longitude);
            // The marker (with the default icon) is automatically added 
            // to the map when created
            var marker = new google.maps.Marker({
                map: map,
                draggable: true,
                animation: google.maps.Animation.DROP,
                position: newEntityLocation,
                title: "DIS Entity from Network"
                        //icon:image
            });

            // add a function to be called when the user clicks on the icon 
            google.maps.event.addListener(marker, 'click', function ()
            {
                infowindow.open(map, marker);
            });

            theMarker.marker = marker;

            //console.log("new theMarker:", theMarker);
            allEntities[eidString] = theMarker;
        }

        // The marker for the entity has either just been added, or recognized as already
        // existing. In either event, update it's position on the map.
        // Update the marker position
        theMarker.marker.setPosition(new google.maps.LatLng(latLonAlt.latitude, latLonAlt.longitude));
        theMarker.lastEspdu = disMessage;
        theMarker.lastHeardFrom = new Date();

    }; // end of onmessage

}

/** 
 * Removes icons that we haven't heard from in some amount of time
 */
function prune()
{
    var TIMEOUT = 120000; // 2 min
    var now = new Date();

    for (var anEntity in allEntities)
    {
        var entityInfo = allEntities[anEntity];
        if (now.getTime() - entityInfo.lastHeardFrom.getTime() > TIMEOUT)
        {
            var markerInfo = allEntities[anEntity];
            markerInfo.marker.setMap(null);
            delete allEntities[anEntity];
        }
    }
}

/**
 * Called periodicaly to send out an update of our position. Uses the
 * browser geolocation routines to set the PDUs location, which is useful
 * for mobile devices. If we have no local position fix, do not send out
 * an update.
 */
function heartbeat()
{
    // We don't have a current position; sending an update is sort of pointless
    if (browserPosition === undefined)
        return;

    //console.log("heartbeat type pdu:", espdu.pduType);
    var conversion = new dis.CoordinateConversion();
    latLonAlt = {};
    latLonAlt.lat = browserPosition.coords.latitude;
    latLonAlt.lon = browserPosition.coords.longitude;
    latLonAlt.alt = 0.0;

    // bump timestamp
    espdu.timestamp++;

    // Set location and wiggle the marker icon a bit
    var disCoordinates = conversion.getXYZfromLatLonAltDegrees(latLonAlt);
    espdu.entityLocation.x = disCoordinates.x + Math.round(Math.random() * 7);
    espdu.entityLocation.y = disCoordinates.y + Math.round(Math.random() * 7);
    espdu.entityLocation.z = disCoordinates.z + Math.round(Math.random() * 7);

    // Marshal out the PDU that represents the local browser's position
    // to the IEEE DIS binary format. We allocate a big buffer to write,
    // and if the actual data occupies less than that, trim to fit.
    var dataBuffer = new ArrayBuffer(1000); // typically 144 bytes, make it bigger for safety
    var outputStream = new dis.OutputStream(dataBuffer);
    espdu.encodeToBinaryDIS(outputStream);

    // Trim to fit
    var trimmedData = dataBuffer.slice(0, outputStream.currentPosition);
    
    var readyState = websocket.readyState;
    if (readyState === 1) // 1 == OPEN
        websocket.send(trimmedData);

    // Create or update our marker position
    var ourLocation = new google.maps.LatLng(latLonAlt.latitude, latLonAlt.longitude);
    if (ourMarker === undefined)
    {
        ourMarker = new google.maps.Marker({
            map: map,
            draggable: true,
            animation: google.maps.Animation.DROP,
            position: ourLocation,
            title: "DIS Local Entity",
            icon: "http://maps.google.com/mapfiles/ms/icons/green-dot.png"
        });

        // Set up an infowindow that will be opened when the user clicks the green (self) icon
        var contentString = "<b>Entity ID:</b>" + JSON.stringify(espdu.entityID) + "<br>";
        contentString = contentString + "<b>Entity Type:</b>" + JSON.stringify(espdu.entityType) + "<br>";
        var infowindow = new google.maps.InfoWindow({content: contentString});
        google.maps.event.addListener(ourMarker, 'click', function ()
        {
            infowindow.open(map, ourMarker);
        });
    } // end of creating new marker

    // Update the marker position
    ourMarker.setPosition(new google.maps.LatLng(browserPosition.coords.latitude, browserPosition.coords.longitude));

}

/** Standard browser geolocation code to get the location of the device
 * that this web page is running on
 */
function getLocation()
{
    //console.log("geolocation called");
    if (navigator.geolocation)
    {
        // Works via callback to function passed in
        navigator.geolocation.getCurrentPosition(showPosition);
        //console.log("callback registered");
    } else
    {
        console.log("Geolocation not supported by this browser");
    }
}

/** Callback function. Gets the location as the browser knows it. */
function showPosition(position, error)
{
    browserPosition = position;
    //console.log("Latitude:", position.coords.latitude , "Longitude: " + position.coords.longitude); 
}

