/*
Copyright (c) 1995-2026 held by the author(s).  All rights reserved.

Redistribution and use in source and binary forms, with or without
modification, are permitted provided that the following conditions
are met:

    * Redistributions of source code must retain the above copyright
      notice, this list of conditions and the following disclaimer.
    * Redistributions in binary form must reproduce the above copyright
      notice, this list of conditions and the following disclaimer
      in the documentation and/or other materials provided with the
      distribution.
    * Neither the names of the Naval Postgraduate School (NPS)
      Modeling Virtual Environments and Simulation (MOVES) Institute
      https://www.nps.edu and https://www.nps.edu/web/moves
      nor the names of its contributors may be used to endorse or
      promote products derived from this software without specific
      prior written permission.

THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
"AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT
LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS
FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE
COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT,
INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING,
BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT
LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN
ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
POSSIBILITY OF SUCH DAMAGE.
*/
// TODO move into opendis7 distribution tree in package edu.nps.moves.dis7.utilities.stream;

package edu.nps.moves.dis7.examples;

import edu.nps.moves.dis7.entities.swe.platform.surface._001Poseidon;
import edu.nps.moves.dis7.enumerations.DisPduType;
import edu.nps.moves.dis7.enumerations.ForceID;
import edu.nps.moves.dis7.pdus.EntityID;
import edu.nps.moves.dis7.pdus.EntityStatePdu;
import edu.nps.moves.dis7.pdus.EulerAngles;
import edu.nps.moves.dis7.pdus.Pdu;
import edu.nps.moves.dis7.pdus.Vector3Double;
import edu.nps.moves.dis7.utilities.DisTime;
import edu.nps.moves.dis7.utilities.PduFactory;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Create a track from DIS ESPDUs
 * @author brutzman@nps.edu
 */
public class PduTrack
{   
    private String          descriptor = new String();
    private ArrayList<Pdu>  pduList = new ArrayList<>();
    private EntityStatePdu  initialEspdu;
    private EntityStatePdu  latestEspdu;
    private Vector3Double   initialLocation;
    private Vector3Double   latestLocation;
    
    /** waypoint timelineList in seconds */
    private ArrayList<Float>          timelineList = new ArrayList<>();
    private ArrayList<Vector3Double> waypointsList = new ArrayList<>();
    private ArrayList<EulerAngles> eulerAnglesList = new ArrayList<>();
    
    private String                             author = new String();
    private String                 x3dModelIdentifier = new String();
    private String                 x3dModelName       = "PduTrackInterpolation.x3d";
    private float             defaultWaypointInterval = -1;
    private float                     durationSeconds = -1;
    private String                   x3dTimeSensorDEF = new String();
    private String         x3dPositionInterpolatorDEF = new String();
    private String      x3dOrientationInterpolatorDEF = new String();
    private boolean      addLineBreaksWithinKeyValues = false;
    /** what kind of timestamp is being used */
    public    DisTime.TimestampStyle timestampStyle        = DisTime.TimestampStyle.IEEE_ABSOLUTE;
    /** direct access to pduFactory for creating new PDU instances */
    protected PduFactory             pduFactory            = new PduFactory(timestampStyle);
    private   LocalDateTime          recordingStart;
    private   LocalDateTime          recordingStop;
    private   String                 todaysDateString      = new String();
    
    /** direct access to byteArrayOutputStream */
    protected ByteArrayOutputStream  byteArrayOutputStream = new ByteArrayOutputStream();
    /** direct access to DataOutputStream */
    protected DataOutputStream       dataOutputStream      = new DataOutputStream(byteArrayOutputStream);
    private   String TRACE_PREFIX = "[" + (PduTrack.class.getSimpleName()) + "] ";
    
    /**
     * Constructor for PduTrack
     */
    public PduTrack()
    {
        // initialization code here
        
        // https://docs.oracle.com/javase/tutorial/datetime/TOC.html
        // https://docs.oracle.com/en/java/javase/18/docs/api/java.base/java/time/package-summary.html
        // https://stackoverflow.com/questions/5175728/how-to-get-the-current-date-time-in-java/5175900 (scroll down to java.time)
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d MMMM yyyy");
        todaysDateString = LocalDate.now().format(formatter);
//      System.out.println(TRACE_PREFIX + "today=" + todayString);
    }
    
    /**
     * Set timestampStyle used by PduFactory
     * @param newTimestampStyle new value to set
     */
    public PduTrack(DisTime.TimestampStyle newTimestampStyle)
    {
        timestampStyle = newTimestampStyle;
        DisTime.setTimestampStyle(newTimestampStyle);
        // automatic super invocation: return PduTrack();
    }
    
    /**
     * Get simple descriptor (such as parent class name) for this SimulationManager, used in trace statements
     * @return simple descriptor name
     */
    public String getDescriptor() 
    {
        return descriptor;
    }
    /**
     * Set new simple descriptor (such as parent class name) for this SimulationManager, used in trace statements
     * @param newDescriptor simple descriptor name for this interface
     * @return same object to permit progressive setters */
    public PduTrack setDescriptor(String newDescriptor) 
    {
        if (newDescriptor != null)
            this.descriptor = newDescriptor.trim();
        TRACE_PREFIX = "[" + (PduTrack.class.getSimpleName() + " " + descriptor) + "] ";
        return this;
    }
    /**
     * Get timestampStyle used by PduFactory
     * @return current timestampStyle
     */
    public DisTime.TimestampStyle getTimestampStyle()
    {
        return timestampStyle;
    }
    /**
     * Set timestampStyle used by PduFactory
     * @param newTimestampStyle the timestampStyle to set
     * @return same object to permit progressive setters 
     */
    public PduTrack setTimestampStyle(DisTime.TimestampStyle newTimestampStyle) 
    {
        this.timestampStyle = newTimestampStyle;
        DisTime.setTimestampStyle(newTimestampStyle);
        return this;
    }

    /**
     * Determine initial location, reset to (0 0 0) if not found
     * @return current initialLocation
     */
    public Vector3Double getInitialLocation() {
        if (initialLocation == null)
        {
            System.out.println (TRACE_PREFIX + "getInitialLocation() not found, isTrackEmpty()=" + isTrackEmpty() + ", returning 0 0 0");
            return new Vector3Double();
        }
        return initialLocation;
    }
    /**
     * Determine current location, reset to (0 0 0) if not found
     * @return current latestLocation
     */
    public Vector3Double getLatestLocation() {
        if (latestLocation == null)
        {
            System.out.println (TRACE_PREFIX + "getLatestLocation() not found, isTrackEmpty()=" + isTrackEmpty() + ", returning 0 0 0");
            return new Vector3Double();
        }
        return latestLocation;
    }
    /**
     * Get individual Pdu from pduList, index must not exceed existing pduList size
     * @param index for pdu of interest
     * @return pdu of interest
     */
    public Pdu getPdu(int index) throws IndexOutOfBoundsException
    {
        if ((index >= pduList.size()) || (index < 0))
        {
            System.out.println (TRACE_PREFIX + "getPdu(" + index + ") out of bounds, pduList.size()=" + pduList.size());
            // then throw exception
        }
        return pduList.get(index);
    }
    /**
     * get current pduList
     * @return current pduList
     */
    public ArrayList<Pdu> getPduList() {
        return pduList;
    }
    /**
     * get current waypointsList
     * @return current waypointsList
     */
    public ArrayList<Vector3Double> getWaypointsList() {
        return waypointsList;
    }
    /**
     * current eulerAnglesList
     * @return current eulerAnglesList
     */
    public ArrayList<EulerAngles> getEulerAnglesList() {
        return eulerAnglesList;
    }
    /**
     * Time in seconds corresponding to each PDU
     * @return current timelineList
     */
    public ArrayList<Float> getTimelineList() {
        return timelineList;
    }
    /**
     * Add PDU, typically ESPDU
     * @param newPdu new Pdu to add, typically ESPDU
     * @return same object to permit progressive setters
     */
    public PduTrack addPdu(Pdu newPdu)
    {
        if (newPdu.getPduType() == DisPduType.ENTITY_STATE)
        {
////          EntityStatePdu deepCopyEspdu = new EntityStatePdu();
//            EntityStatePdu deepCopyEspdu = pduFactory.makeEntityStatePdu();
//            deepCopyEspdu.setTimestamp        (((EntityStatePdu)newPdu).getTimestamp());
//            deepCopyEspdu.setMarking          (((EntityStatePdu)newPdu).getMarking());
//            deepCopyEspdu.setEntityID         (((EntityStatePdu)newPdu).getEntityID());
//            deepCopyEspdu.setForceId          (((EntityStatePdu)newPdu).getForceId());
//            deepCopyEspdu.setEntityType       (((EntityStatePdu)newPdu).getEntityType());
//            deepCopyEspdu.setEntityLocation   (((EntityStatePdu)newPdu).getEntityLocation());
//            deepCopyEspdu.setEntityOrientation(((EntityStatePdu)newPdu).getEntityOrientation());
            
            EntityStatePdu deepCopyEspdu = ((EntityStatePdu)newPdu).copy();
            pduList.add(deepCopyEspdu);
//          alternative trials:
//          pduList.add(((EntityStatePdu)newPdu).copyDataOutputStream());
//          pduList.add(((EntityStatePdu)newPdu).copy());
            
            if (initialLocation == null)
            {
                initialEspdu    = deepCopyEspdu; // must save object since pduList might contain more than ESPDUs
                initialLocation = deepCopyEspdu.getEntityLocation();
            }
            latestEspdu         = deepCopyEspdu; // must save object since pduList might contain more than ESPDUs
            latestLocation      = deepCopyEspdu.getEntityLocation();
        }
        else pduList.add(newPdu); // TODO copy() - careful, must be a new object and not a reference
        return this;
    }
    /**
     * clear all PDUs
     * @return same object to permit progressive setters
     */
    public PduTrack clearPduLists()
    {
           getPduList().clear();
          waypointsList.clear();
        eulerAnglesList.clear();
           timelineList.clear();
           initialEspdu = null;
            latestEspdu = null;
        initialLocation = null;
         latestLocation = null;
        return this;
    }
    
    private String normalizeNameToken(String candidateDEF)
    {
        return candidateDEF.replace(" ", "").replace("-", "")
                           .replace("(", "").replace(")", "")
                           .replace("[", "").replace("])", "");
    }

    /**
     * Provide DEF value if not defined by program
     * @return current x3dTimeSensorDEF
     */
    public String getX3dTimeSensorDEF() {
        if    (x3dTimeSensorDEF.isEmpty())
               x3dTimeSensorDEF = normalizeNameToken(getDescriptor()) + "Clock";
        return x3dTimeSensorDEF;
    }

    /**
     * Set DEF value for X3D node
     * @param x3dTimeSensorDEF the x3dTimeSensorDEF to set
     */
    public void setX3dTimeSensorDEF(String x3dTimeSensorDEF) {
        this.x3dTimeSensorDEF = normalizeNameToken(x3dTimeSensorDEF);
    }

    /**
     * Provide DEF value if not defined by program
     * @return current x3dPositionInterpolatorDEF
     */
    public String getX3dPositionInterpolatorDEF() {
        if    (x3dPositionInterpolatorDEF.isEmpty())
               x3dPositionInterpolatorDEF = normalizeNameToken(getDescriptor()) + "Positions";
        return x3dPositionInterpolatorDEF;
    }

    /**
     * Set DEF value for X3D node
     * @param x3dPositionInterpolatorDEF the x3dPositionInterpolatorDEF to set
     */
    public void setX3dPositionInterpolatorDEF(String x3dPositionInterpolatorDEF) {
        this.x3dPositionInterpolatorDEF = normalizeNameToken(x3dPositionInterpolatorDEF);
    }

    /**
     * Provide DEF value if not defined by program
     * @return current x3dOrientationInterpolatorDEF
     */
    public String getX3dOrientationInterpolatorDEF() {
        if    (x3dOrientationInterpolatorDEF.isEmpty())
               x3dOrientationInterpolatorDEF = normalizeNameToken(getDescriptor()) + "Orientations";
        return x3dOrientationInterpolatorDEF;
    }

    /**
     * Set DEF value for X3D node
     * @param x3dOrientationInterpolatorDEF the x3dOrientationInterpolatorDEF to set
     */
    public void setX3dOrientationInterpolatorDEF(String x3dOrientationInterpolatorDEF) {
        this.x3dOrientationInterpolatorDEF = normalizeNameToken(x3dOrientationInterpolatorDEF);
    }

    /**
     * Sort all PDUs by timestamp
     * @see <a href="https://stackoverflow.com/questions/16252269/how-to-sort-an-arraylist" target="_blank">StackOverflow: How to sort an ArrayList?</a>
     * @see <a href="https://docs.oracle.com/en/java/javase/18/docs/api/java.base/java/util/doc-files/coll-overview.html" target="_blank">Collections Framework Overview</a>
     * @return same object to permit progressive setters
     */
    public PduTrack sortPdus()
    {
        Collections.sort(pduList, new Comparator<Pdu>() {
            @Override
            public int compare(Pdu lhs, Pdu rhs)
            {
                // -1 less than, 1 greater than, 0 equal
                if      (lhs.occursBefore(rhs))
                         return -1;
                else if (lhs.occursSameTime(rhs))
                         return 0;
                else     return 1;
            }
        });
        return this;
    }
    /**
     * Reverse order of PDU list
     * @see <a href="https://stackoverflow.com/questions/10766492/what-is-the-simplest-way-to-reverse-an-arraylist" target="_blank">StackOverflow: What is the Simplest Way to Reverse an ArrayList?</a>
     * @see <a href="https://docs.oracle.com/en/java/javase/18/docs/api/java.base/java/util/doc-files/coll-overview.html" target="_blank">Collections Framework Overview</a>
     * @return same object to permit progressive setters
     */
    public PduTrack reversePdus()
    {
        Collections.reverse(pduList);
        return this;
    }

    /**
     * Determine whether any ESPDUs have been received by this track
     * @return whether track is empty
     */
    public boolean isTrackEmpty()
    {
        return (getEspduCount() == 0);
    }
    /**
     * Count ESPDUs in pduList
     * @return number of ESPDUs in pduList
     */
    public int getEspduCount()
    {
        int counter = 0;
        for (Pdu nextPdu : getPduList())
        {
            if (nextPdu.getPduType() == DisPduType.ENTITY_STATE)
               counter += 1;
        }
        return counter;
    }
    /**
     * Compute track duration in timestamp ticks
     * @return duration in timestamp ticks between initial and final ESPDU timestamps in waypointList
     */
    public int getTotalDurationTicks()
    {
        int    initialTime = -1;
        int      finalTime = -1;
        int  durationTicks = -1; // used if pduList is empty
        
        // must skip through pduList since non-ESPDU PDUs may be present
        for (Pdu nextPdu : getPduList())
        {
            if (nextPdu.getPduType() == DisPduType.ENTITY_STATE)
            {
                if (initialTime == -1)
                    initialTime = nextPdu.getTimestamp();
                finalTime = nextPdu.getTimestamp();
            }
        }
        if ((initialTime >= 0) && (finalTime >= 0))
             durationTicks = (finalTime - initialTime);
        if (getPduList().isEmpty())
        {
            System.out.println(TRACE_PREFIX + "getTrackDuration() computed illegal duration=" + durationTicks + " due to empty pdu list");
        }
        else if ((durationTicks <= 0) && (defaultWaypointInterval <= 0))
        {
            System.out.println(TRACE_PREFIX + "getTrackDuration() computed illegal duration=" + durationTicks + " due to illegal pdu list");
        }
        return durationTicks;
    }
    /**
     * Compute track duration in seconds
     * @return duration in seconds between initial and final ESPDU timestamps in waypointList
     */
    public float getTotalDurationSeconds()
    {
        if (defaultWaypointInterval > 0)
        {
            return getEspduCount() * defaultWaypointInterval;
        }
        else if (getTotalDurationTicks() < 0)
               durationSeconds = getTotalDurationTicks() * 1.0f; // TODO convert
        return durationSeconds;
    }
    /**
     * Create waypoints and angles using all ESPDU points, with no linear regression or array reduction.
     * @return same object to permit progressive setters
     */
    public PduTrack createRawWaypoints()
    {
        // https://stackoverflow.com/questions/6536094/java-arraylist-copy
        
           timelineList.clear();
          waypointsList.clear();
        eulerAnglesList.clear();
        float clock = 0.0f;
        for (int i = 0; i < pduList.size(); i++)
        {
            Pdu nextPdu = pduList.get(i);
            if (nextPdu.getPduType() == DisPduType.ENTITY_STATE)
            {
                EntityStatePdu espdu = (EntityStatePdu)nextPdu;
                if (defaultWaypointInterval > 0)
                {
                    timelineList.add(clock);
                    clock += defaultWaypointInterval;
                }
                else
                {
                    timelineList.add(espdu.getTimestamp() * 1.0f); // TODO convert
                }
                   waypointsList.add(espdu.getEntityLocation());
                 eulerAnglesList.add(espdu.getEntityOrientation());
            }
        }
        return this;
    }
    /** 
     * Utility method to create TimeSensor
     * @return TimeSensor string in XML format
     */
    public String createX3dTimeSensorString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append("    <TimeSensor");
        sb.append(" DEF='").append(getX3dTimeSensorDEF()).append("'");
        sb.append(" cycleInterval='").append(String.valueOf(getTotalDurationSeconds())).append("'");
        sb.append(" loop='true'");
        sb.append("/>").append("\n");
        
        return sb.toString();
    }
    /**
     * Create PositionInterpolator from Pdu list
     * @return X3D PositionInterpolator as string
     */
    public String createX3dPositionInterpolatorString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append("    <PositionInterpolator");
        sb.append(" DEF='").append(getX3dPositionInterpolatorDEF()).append("'");
        sb.append(" key='");
        for (int i = 0; i < timelineList.size(); i++)
        {
            float nextDuration = timelineList.get(i) * 1.0f; // TODO convert
            sb.append(String.valueOf(nextDuration));
            if (i < timelineList.size() - 1)
                sb.append(" ");
        }
        sb.append("'");
        sb.append(" keyValue='");
        for (int i = 0; i < waypointsList.size(); i++)
        {
            if (hasAddLineBreaksWithinKeyValues())
                sb.append("\n");
            Vector3Double nextPosition = waypointsList.get(i);
            sb.append(String.valueOf(nextPosition.getX())).append(" ")
              .append(String.valueOf(nextPosition.getY())).append(" ")
              .append(String.valueOf(nextPosition.getZ()));
            if (i < waypointsList.size() - 1)
                sb.append(",");
        }
        sb.append("'");
        sb.append("/>").append("\n");
        
        return sb.toString();
    }
    /**
     * Create OrientationInterpolator from Pdu list
     * TODO preliminary support only includes horizontal rotation.
     * @return X3D OrientationInterpolator as string
     */
    public String createX3dOrientationInterpolatorString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append("    <OrientationInterpolator");
        sb.append(" DEF='").append(getX3dOrientationInterpolatorDEF()).append("'");
        sb.append(" key='");
        for (int i = 0; i < timelineList.size(); i++)
        {
            float nextDuration = timelineList.get(i) * 1.0f; // TODO convert
            sb.append(String.valueOf(nextDuration));
            if (i < timelineList.size() - 1)
                sb.append(" ");
        }
        sb.append("'");
        sb.append(" keyValue='");
        for (int i = 0; i < eulerAnglesList.size(); i++)
        {
            if (hasAddLineBreaksWithinKeyValues())
                sb.append("\n");
            EulerAngles nextEulerAngle = new EulerAngles();
            float axisX = 0.0f;
            float axisY = 1.0f;
            float axisZ = 0.0f;
            float angle = 0.0f; // radians
            
            nextEulerAngle = eulerAnglesList.get(i);
            angle = nextEulerAngle.getTheta();
            
            sb.append(String.valueOf(axisX)).append(" ")
              .append(String.valueOf(axisY)).append(" ")
              .append(String.valueOf(axisZ)).append(" ")
              .append(String.valueOf(angle));
            if (i < eulerAnglesList.size() - 1)
                sb.append(",");
        }
        sb.append("'");
        sb.append("/>").append("\n");
        
        return sb.toString();
    }

    /**
     * Get name of author used as creator of X3D model
     * @return current author
     */
    public String getAuthor() {
        return author;
    }

    /**
     * Set name of author used as creator of X3D model
     * @param author the author to set
     */
    public void setAuthor(String author) {
        if  (author == null)
             author = new String();
        author = author.trim();
        this.author = author;
    }

    /**
     * Get name of online url identifier for X3D model
     * @return current x3dModelIdentifier
     */
    public String getX3dModelIdentifier() {
        return x3dModelIdentifier;
    }

    /**
     * Set name of online url identifier for X3D model
     * @param x3dModelIdentifier the x3dModelIdentifier to set
     */
    public void setX3dModelIdentifier(String x3dModelIdentifier) {
        if  (x3dModelIdentifier == null)
             x3dModelIdentifier = new String();
        x3dModelIdentifier = x3dModelIdentifier.trim();
        if (!x3dModelIdentifier.startsWith("http://") && !x3dModelIdentifier.startsWith("https://"))
            System.out.println(TRACE_PREFIX + "warning, identifier typically begins with https:// or http://");
        else this.x3dModelIdentifier = x3dModelIdentifier;
    }

    /**
     * File name for X3D model production
     * @return current x3dModelName
     */
    public String getX3dModelName() {
        return x3dModelName;
    }
    /**
     * File name for X3D model production
     * @param x3dModelName the x3dModelName to set
     */
    public void setX3dModelName(String x3dModelName) {
        if  (x3dModelName == null)
             x3dModelName = new String();
        x3dModelName = x3dModelName.trim();
        this.x3dModelName = x3dModelName;
    }

    /**
     * Verbose (but more readable) output of numeric arrays in X3D model
     * @return current addLineBreaksWithinKeyValues
     */
    public boolean hasAddLineBreaksWithinKeyValues() {
        return addLineBreaksWithinKeyValues;
    }

    /**
     * Verbose (but more readable) output of numeric arrays in X3D model
     * @param addLineBreaksWithinKeyValues the addLineBreaksWithinKeyValues to set
     */
    public void setAddLineBreaksWithinKeyValues(boolean addLineBreaksWithinKeyValues) {
        this.addLineBreaksWithinKeyValues = addLineBreaksWithinKeyValues;
    }
    /**
     * Create full X3D interpolator model from Pdu list, assembling sections of scene graph
     * @return X3D model as string
     */
    public String createX3dModel()
    {
        StringBuilder sb = new StringBuilder();
        sb.append(createX3dModelHeaderString());
        sb.append(createX3dTimeSensorString());
        sb.append(createX3dPositionInterpolatorString());
        sb.append(createX3dOrientationInterpolatorString());
        sb.append(createX3dRoutesGeometryFooterString());
        return sb.toString();
    }
    /**
     * Create PositionInterpolator from Pdu list
     * @return X3D PositionInterpolator as string
     */
    public String createX3dModelHeaderString()
    {        
        StringBuilder sb = new StringBuilder();
        
        sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>").append("\n");
        sb.append("<!DOCTYPE X3D PUBLIC \"ISO//Web3D//DTD X3D 4.0//EN\" \"https://www.web3d.org/specifications/x3d-4.0.dtd\">").append("\n");
        sb.append("<X3D profile='Interchange' version='4.0' xmlns:xsd='http://www.w3.org/2001/XMLSchema-instance' xsd:noNamespaceSchemaLocation='https://www.web3d.org/specifications/x3d-4.0.xsd'>").append("\n");
        sb.append("  <head>").append("\n");
        if (!getX3dModelName().isEmpty())
            sb.append("    <meta content='").append(getX3dModelName()).append("' name='title'/>").append("\n");
        sb.append("    <meta content='Conversion of ESPDU track into X3D animation interpolators and LineSet.' name='description'/>").append("\n");
        
        sb.append("    <meta content='1 January 2022' name='created'/>").append("\n");
        sb.append("    <meta content='").append(todaysDateString).append("' name='modified'/>").append("\n");
        if (!getAuthor().isEmpty())
            sb.append("    <meta content='").append(getAuthor()).append("' name='creator'/>").append("\n");
        if (!getX3dModelIdentifier().isEmpty())
            sb.append("    <meta content='").append(getX3dModelIdentifier()).append("' name='identifier'/>").append("\n");
        
        sb.append("    <meta content='PduTrack utility, opendis7-java Library https://github.com/open-dis/opendis7-java' name='generator'/>").append("\n");
        sb.append("    <meta content='NPS MOVES MV3500 Networked Graphics https://gitlab.nps.edu/Savage/NetworkedGraphicsMV3500' name='reference'/>").append("\n");
        sb.append("    <meta content='X3D Resources https://www.web3d.org/x3d/content/examples/X3dResources.html' name='reference'/>").append("\n");
        sb.append("    <meta content='X3D Scene Authoring Hints https://www.web3d.org/x3d/content/examples/X3dSceneAuthoringHints.html' name='reference'/>").append("\n");
        sb.append("    <meta content='X3D Tooltips https://www.web3d.org/x3d/tooltips/X3dTooltips.html' name='reference'/>").append("\n");
        sb.append("    <meta content='X3D Validator https://savage.nps.edu/X3dValidator' name='reference'/>").append("\n");
        sb.append("    <meta content='Open source https://raw.githubusercontent.com/open-dis/opendis7-java/master/license.html' name='license'/>").append("\n");
        sb.append("  </head>").append("\n");
        sb.append("  <Scene>").append("\n");
        sb.append("    <WorldInfo title='PduTrackInterpolation.x3d'/>").append("\n");

        return sb.toString(); 
    }
    /**
     * Create X3D ROUTEs and footer to connect TimeSensor to interpolators
     * @return X3D PositionInterpolator as string
     */
    public String createX3dRoutesGeometryFooterString()
    {
        StringBuilder sb = new StringBuilder();
        
        sb.append("    <ROUTE fromField='fraction_changed' fromNode='")
          .append(getX3dTimeSensorDEF())
          .append("' toField='set_fraction' toNode='")
          .append(getX3dPositionInterpolatorDEF())
          .append("'/>").append("\n");
        sb.append("    <ROUTE fromField='fraction_changed' fromNode='")
          .append(getX3dTimeSensorDEF())
          .append("' toField='set_fraction' toNode='")
          .append(getX3dOrientationInterpolatorDEF())
          .append("'/>").append("\n");
        
        sb.append("    <Shape>").append("\n");
        sb.append("      <Appearance DEF='TrackAppearance'>").append("\n");
        sb.append("        <Material emissiveColor='0.2 0.8 0.8'/>").append("\n");
        sb.append("      </Appearance>").append("\n");
        sb.append("      <LineSet vertexCount='").append(waypointsList.size()).append("'>").append("\n");
        sb.append("        <Coordinate point='");
        for (int i = 0; i < waypointsList.size(); i++)
        {
            if (hasAddLineBreaksWithinKeyValues())
                sb.append("\n");
            Vector3Double nextPosition = waypointsList.get(i);
            sb.append(String.valueOf(nextPosition.getX())).append(" ")
              .append(String.valueOf(nextPosition.getY())).append(" ")
              .append(String.valueOf(nextPosition.getZ()));
            if (i < waypointsList.size() - 1)
                sb.append(",");
        }
        sb.append("'/>").append("\n");
        sb.append("      </LineSet>").append("\n");
        sb.append("    </Shape>").append("\n");
        sb.append("    <Transform DEF='AnimationTransform'>").append("\n");
        sb.append("      <Transform rotation='0 0 1 1.57'>").append("\n");
        sb.append("        <Shape>").append("\n");
        sb.append("          <Appearance USE='TrackAppearance'/>").append("\n");
        sb.append("          <Cone bottomRadius='0.5'/>").append("\n");
        sb.append("        </Shape>").append("\n");
        sb.append("      </Transform>").append("\n");
        sb.append("    </Transform>").append("\n");
        sb.append("    <ROUTE fromField='value_changed' fromNode='")
          .append(getX3dPositionInterpolatorDEF())
          .append("' toField='translation' toNode='AnimationTransform'/>").append("\n");
        sb.append("    <ROUTE fromField='value_changed' fromNode='")
          .append(getX3dOrientationInterpolatorDEF())
          .append("' toField='rotation' toNode='AnimationTransform'/>").append("\n");
        
        sb.append("  </Scene>").append("\n");
        sb.append("</X3D>").append("\n");
        
        return sb.toString();
    }

    /**
     * get defaultWaypointInterval
     * @return current wayPointInterval
     */
    public float getDefaultWaypointInterval() {
        return defaultWaypointInterval;
    }

    /**
     * Set uniform waypoint interval (currently for testing)
     * @param newWaypointInterval the wayPointInterval to set, in seconds, must be greater than zero
     * @return same object to permit progressive setters */
    public PduTrack setDefaultWaypointInterval(float newWaypointInterval) {
        if (newWaypointInterval > 0.0)
            this.defaultWaypointInterval = newWaypointInterval;
        else 
        {
            System.out.println(TRACE_PREFIX + "error in setWaypointInterval(newWaypointInterval=" + newWaypointInterval + ") must be greater than zero");
            return this;
        }
            
        float clock = 0.0f;
        if (!timelineList.isEmpty())
        {   
            ArrayList<Float> newTimelineList = new ArrayList<>();
            for (int i = 0; i < getEspduCount(); i++)
            {
                newTimelineList.add(clock);
                clock += defaultWaypointInterval;
            }
            timelineList = newTimelineList; // TO Array copy?
        }
        return this;
    }
    /** whether or not to insert commas between hex values */
    private boolean insertCommas = true;
    /**
     * determine whether comma insertion is turned on
     * @return whether or not to insert commas between hex values
     */
    public boolean hasInsertCommas() {
        return insertCommas;
    }
    /**
     * set whether comma insertion is turned on
     * @param insertCommas the insertCommas value to set
     */
    public void setInsertCommas(boolean insertCommas) {
        this.insertCommas = insertCommas;
    }
    /**
     * Convert byte array to hex string
     * @param bytes input data
     * @param insertCommas whether to insert commas between hex values
     * @return hex string
     */
    public String bytesToHex(byte[] bytes, boolean insertCommas)
    {
        this.setInsertCommas(insertCommas);
        return bytesToHex(bytes);
    }
    /**
     * Convert byte array to hex string
     * @param bytes input data
     * @see <a href="https://stackoverflow.com/questions/9655181/how-to-convert-a-byte-array-to-a-hex-string-in-java" target="_blank">https://stackoverflow.com/questions/9655181/how-to-convert-a-byte-array-to-a-hex-string-in-java</a>
     * @return hex string
     */
    public static String bytesToHex(byte[] bytes)
    {
        boolean insertCommas = true;
        final char[] HEX_ARRAY = "0123456789ABCDEF".toCharArray();
        char[] hexChars = new char[bytes.length * 2];
        StringBuilder sb = new StringBuilder();
        for (int j = 0; j < bytes.length; j++) {
            int v = bytes[j] & 0xFF;
            hexChars[j * 2]     = HEX_ARRAY[v >>> 4];
            hexChars[j * 2 + 1] = HEX_ARRAY[v & 0x0F];
//          if (!(hexChars[j * 2] == '0')) // omit leading zero
            sb.append(hexChars[j * 2]);
            sb.append(hexChars[j * 2 + 1]);
            if (insertCommas && (j < bytes.length - 1))
                sb.append(", ");
        }
        return sb.toString();
    }
    /**
     * Report current PDU information to console
     * @param anEspdu EntityStatePdu of interest
     * @return same object to permit progressive setters
     */
    public PduTrack reportPdu(EntityStatePdu anEspdu)
    {
        System.out.println (
                String.format("%s", anEspdu.getMarkingString().trim()) + ", " +
                DisTime.convertToString(anEspdu.getTimestamp()) + " (" +
                String.format("%08d", anEspdu.getTimestamp()) + "), " + 
                "EntityID=(" + 
                anEspdu.getEntityID().getSiteID() + ", " +
                anEspdu.getEntityID().getApplicationID() + ", " + 
                anEspdu.getEntityID().getEntityID() + "), " +
                "location=(" + 
                String.format("%4.1f", anEspdu.getEntityLocation().getX()) + ", " +
                String.format("%4.1f", anEspdu.getEntityLocation().getY()) + ", " + 
                String.format("%4.1f", anEspdu.getEntityLocation().getZ()) + ")"
//              + " " + espdu_1.getEntityLinearVelocity().toString()
        );
        return this;
    }
    
    /** Flush all buffers to reduce console scrambling while threaded
     */
    protected void flushBuffers()
    {
        try
        {
                 dataOutputStream.flush(); 
            byteArrayOutputStream.flush();
            byteArrayOutputStream.reset();
            System.err.flush(); 
            System.out.flush();
        }
        catch (IOException ioe)
        {
            System.out.println(TRACE_PREFIX + "flushBuffers() IOException: " + ioe.getMessage());
        }
    }
    
    /** Self test to check basic operation, invoked by main()
     */
    @SuppressWarnings("SleepWhileInLoop")
    public void selfTest()
    {
        final int TOTAL_PDUS = 5;
        System.out.println(TRACE_PREFIX + "selfTest() start...");
      
        PduTrack pduTrack = new PduTrack();
        pduTrack.setDescriptor("PduTrack Self Test");
        pduTrack.setAuthor("Don Brutzman");
        pduTrack.setX3dModelIdentifier("https://gitlab.nps.edu/Savage/NetworkedGraphicsMV3500/-/blob/master/examples/src/OpenDis7Examples/PduTrackInterpolation.x3d");
        pduTrack.setDefaultWaypointInterval(1.0f); // experimentation with timestamp values

        DisTime.setEpochLvcNow();
        recordingStart = LocalDateTime.now();
        Instant epoch = DisTime.getEpochLvc();
        System.out.println(TRACE_PREFIX + "DisTime.hasEpochLvc()=" + DisTime.hasEpochLvc() + 
                                         ", DisTime.getEpochLvc()=" + epoch + 
                                         ", Instant.now()=" + Instant.now());
        
        EntityID entityID_123 = new EntityID();
        entityID_123.setSiteID(1).setApplicationID(2).setEntityID(3); // made-up example ID;
        // TODO someday, use enumerations; is there a unique site triplet for MOVES Institute?

        for (int i = 0; i < TOTAL_PDUS; i++) // create espdus and add each to track pduList
        {
//          EntityStatePdu espdu = new EntityStatePdu();
            EntityStatePdu espdu = pduFactory.makeEntityStatePdu(); // TODO check Pdu.Type
            espdu.setTimestamp(DisTime.getCurrentDisTimestamp()); // chooses appropriate version
            espdu.setMarking("ESPDU " + i);
            espdu.setEntityLocation(i, i, i);
            espdu.setEntityOrientation(0, (float)(45.0 * Math.PI / 180.0), 0);
            espdu.setEntityID(entityID_123);
            espdu.setForceId(ForceID.FRIENDLY);
            espdu.setEntityType(new _001Poseidon()); // note import statement above
            pduTrack.addPdu(espdu); // create copy
            reportPdu(espdu);
            try
            {
                Thread.sleep(100l);
            }
            catch (InterruptedException ie)
            {
                System.out.println(TRACE_PREFIX + "exceptional sleep dulay when generating ESPDUs: " + ie.getMessage());
            }
        }
//        System.out.println(TRACE_PREFIX + "reversePdus() then sortPdus() to test track operations");
//        pduTrack.reversePdus(); // test
//        pduTrack.sortPdus();    // restore
        pduTrack.createRawWaypoints(); // copies all ESPDU points to waypoints
        
        System.out.println(TRACE_PREFIX + "getEspduCount()="              + pduTrack.getEspduCount());
        System.out.println(TRACE_PREFIX + "getDefaultWaypointInterval()=" + pduTrack.getDefaultWaypointInterval());
        System.out.println(TRACE_PREFIX + "getTotalDurationSeconds()="    + pduTrack.getTotalDurationSeconds());
        
        System.out.println("=================================");
        System.out.println("PduTrack pduList marshalling checks");
        System.out.println("= = = = = = = = = = = = = = = = =");
        try
        {
//          int BYTE_BUFFER_SIZE = 400; // TODO what is expected max buffer size?
            for (int i = 0; i < TOTAL_PDUS; i++)
            {
                Pdu pdu = pduTrack.getPduList().get(i);
                if (!(pdu instanceof EntityStatePdu))
                    continue; // skip remainder of this loop
                EntityStatePdu espdu = (EntityStatePdu) pdu;
                System.out.println("espdu from pduTrack pduList");
                reportPdu(espdu);
                byte[] byteArray = espdu.marshal().array(); // can also use ByteBuffer
                System.out.println("espdu.marshal() byteArray:                              " + bytesToHex(byteArray));
                flushBuffers();
                
                ByteBuffer byteBuffer = ByteBuffer.allocate(byteArray.length);
                espdu.marshal(byteBuffer);
                System.out.println("espdu.marshal(byteBuffer):                              " + bytesToHex(byteBuffer.array()));
                flushBuffers();
                
                espdu.marshal(dataOutputStream);
                byte[] byteArrayDOS = byteArrayOutputStream.toByteArray();
                System.out.println("espdu.marshal(dataOutputStream):                        " + bytesToHex(byteArrayDOS));
                flushBuffers();

                System.out.println(); // - - - - - - - - - - - - - - - - -
                
                System.out.println("espdu.copyByteBuffer()");
                reportPdu(espdu.copyByteBuffer());
                byte[] byteArrayCopy = espdu.copyByteBuffer().marshal().array(); // can also use ByteBuffer
                System.out.println("espdu.copyByteBuffer().marshal() byteArray:             " + bytesToHex(byteArrayCopy));
                flushBuffers();
                
                ByteBuffer byteBufferCopy = ByteBuffer.allocate(byteArray.length); // TODO is there a better way to reset?
                espdu.copyByteBuffer().marshal(byteBufferCopy);
                System.out.println("espdu.copyByteBuffer().marshal(byteBufferCopy):         " + bytesToHex(byteBufferCopy.array()));
                flushBuffers();
                
                espdu.copyByteBuffer().marshal(dataOutputStream);
                byte[] byteArrayDosCopy = byteArrayOutputStream.toByteArray();
                System.out.println("espdu.copyByteBuffer().marshal(dataOutputStream):       " + bytesToHex(byteArrayDosCopy));
                flushBuffers();

                System.out.println(); // - - - - - - - - - - - - - - - - -
                
                System.out.println("espdu.copyDataOutputStream()");
                reportPdu(espdu.copyDataOutputStream());
                byte[] byteArrayCopyDOS = espdu.copyDataOutputStream().marshal().array(); // can also use ByteBuffer
                System.out.println("espdu.copyDataOutputStream().marshal() byteArray:       " + bytesToHex(byteArrayCopyDOS));
                flushBuffers();
                
                ByteBuffer byteBufferCopyDOS = ByteBuffer.allocate(byteArray.length); // TODO is there a better way to reset?
                espdu.copyDataOutputStream().marshal(byteBufferCopyDOS);
                System.out.println("espdu.copyDataOutputStream().marshal(byteBufferCopy):   " + bytesToHex(byteBufferCopyDOS.array()));
                flushBuffers();
                
                espdu.copyDataOutputStream().marshal(dataOutputStream);
                byte[] byteArrayDosCopy2 = byteArrayOutputStream.toByteArray();
                System.out.println("espdu.copyDataOutputStream().marshal(dataOutputStream): " + bytesToHex(byteArrayDosCopy2));
                flushBuffers();
                System.out.println();
                
                System.out.println("= = = = = = = = = = = = = = = = =");
            }
        }
        catch(Exception e)
        {
            System.out.println(TRACE_PREFIX + "Marshalling test exception: " + e.getMessage());
        }
        System.out.println("=================================");
        pduTrack.setAddLineBreaksWithinKeyValues(true);
        System.out.println(pduTrack.createX3dModel()); // 
        System.out.println("=================================");

        recordingStop = LocalDateTime.now();
        System.out.println(TRACE_PREFIX + "selfTest() complete.");
    }
    
    /**
     * Main method for testing.
     * @see <a href="https://docs.oracle.com/javase/tutorial/getStarted/application/index.html" target="_blank">Java Tutorials: A Closer Look at the "Hello World!" Application</a>
     * @param args [address, port, descriptor] command-line arguments are an array of optional String parameters that are passed from execution environment during invocation
     */
    public static void main(String[] args)
    {
        System.out.println("*** PduTrack.main() self test started...");
          
        PduTrack pduTrack = new PduTrack();
        
        pduTrack.setDescriptor("main() self test");
        
        pduTrack.selfTest();
        
        System.out.println("*** PduTrack.main() self test complete.");
    }

}
