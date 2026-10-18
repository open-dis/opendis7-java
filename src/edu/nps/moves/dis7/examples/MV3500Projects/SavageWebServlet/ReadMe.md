## Apache XML-RPC demo of performing a URL lookup

With the ant target "runLocallDemo" a Servlet will start and listen for a\
search query from a client. The handler for the search query is the\
SavageSearch class with a single mock look up method "search." This handler is\
registered via the "org.apache.xmlrpc.webserver.XmlRpcServlet.proerties" file\
with a single entry "SavageSearch=SavageSearch" key/value pair.

The client then launches making a connection to\
URL: http://localhost:8080/SavageSearch. A search query of (Savage, Harrier)\
is made with the Servlet which tasks the handler to perform the lookup with\
results:

Result 1 is [Ljava.lang.String; https://savage.nps.edu/Savage/AircraftFixedWing/AV8B-Harrier-UnitedStates/AV8bHarrier.x3d\
Result 2 is [Ljava.lang.String; https://savage.nps.edu/Savage/AircraftFixedWing/AV8B-Harrier-UnitedStates/TranslatedAv8bHarrier.x3d

Before launching the "runLocallDemo" ant target, open up wireshark and\
configure for packet capture on the loopback adapter.

Now launch and look for two packet captures of protocol: HTTP/XML where you can\
then select and expand the entries to view the actual XML methodCall contents.

Since the local RPC Server is still listening for requests, it will have to be\
forced to stop. You may see a benign output such as the following:

BUILD STOPPED (total time: 19 seconds)\
Java Result: 2147483647

# Deploying to a local Tomcat Server
This demo expects apache-tomcat-9.0.95. Point to that directory in the\
build.properties file for the "catalina.base" property

Manager roles need to be defined in ${catalina.base}/config/tomcat-users.xml so\
that the Catalina deploy/undeploy ant tasks work smoothly. Define as\
follows:

&lt;role rolename="manager-gui"/&gt;\
&lt;user username="tomcat" password="tomcat" roles="manager-script"/&gt;

Then, run the ant target "deployRunDemo"

Server log outputs can be viewed at ${catalina.base}/logs/catalina.out and in\
the /logs directory. Look for "xmlrcp.log.0" to see similar logging output.

To undeploy the web app and stop the local Tomcat server, run "undeployRpcDemo"
