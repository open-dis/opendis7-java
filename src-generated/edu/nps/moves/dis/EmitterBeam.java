/**
 * Copyright (c) 2008-2019, MOVES Institute, Naval Postgraduate School. All rights reserved.
 * This work is licensed under the BSD open source license, available at https://www.movesinstitute.org/licenses/bsd.html
 */

package edu.nps.moves.dis;

import java.util.*;
import java.io.*;
import edu.nps.moves.dis.enumerations.*;

/**
 * IEEE Std 1278.1-2012, IEEE Standard for Distributed Interactive Simulation—Application Protocols
 */
public class EmitterBeam extends Object implements Serializable
{
   protected byte  beamDataLength;

   protected byte  beamNumber;

   protected short  beamParameterIndex;

   protected EEFundamentalParameterData  fundamentalParameterData = new EEFundamentalParameterData(); 

   protected BeamData  beamData = new BeamData(); 

   /**  uid 78 */
   protected ElectromagneticEmissionBeamFunction beamFunction = ElectromagneticEmissionBeamFunction.values()[0];

   protected byte  numberOfTargets;

   /**  uid 79 */
   protected HighDensityTrackJam highDensityTrackJam = HighDensityTrackJam.values()[0];

   protected BeamStatus  beamStatus = new BeamStatus(); 

   protected JammingTechnique  jammingTechnique = new JammingTechnique(); 

   protected List< TrackJamData > trackJamData = new ArrayList< TrackJamData >();
 

/** Constructor */
 public EmitterBeam()
 {
 }

public int getMarshalledSize()
{
   int marshalSize = 0; 

   marshalSize += 1;  // beamDataLength
   marshalSize += 1;  // beamNumber
   marshalSize += 2;  // beamParameterIndex
   marshalSize += fundamentalParameterData.getMarshalledSize();
   marshalSize += beamData.getMarshalledSize();
   marshalSize += beamFunction.getMarshalledSize();
   marshalSize += 1;  // numberOfTargets
   marshalSize += highDensityTrackJam.getMarshalledSize();
   marshalSize += beamStatus.getMarshalledSize();
   marshalSize += jammingTechnique.getMarshalledSize();
   for(int idx=0; idx < trackJamData.size(); idx++)
   {
        TrackJamData listElement = trackJamData.get(idx);
        marshalSize += listElement.getMarshalledSize();
   }

   return marshalSize;
}


public EmitterBeam setBeamDataLength(byte pBeamDataLength)
{
    beamDataLength = pBeamDataLength;
    return this;
}

public byte getBeamDataLength()
{
    return beamDataLength; 
}

public EmitterBeam setBeamNumber(byte pBeamNumber)
{
    beamNumber = pBeamNumber;
    return this;
}

public byte getBeamNumber()
{
    return beamNumber; 
}

public EmitterBeam setBeamParameterIndex(short pBeamParameterIndex)
{
    beamParameterIndex = pBeamParameterIndex;
    return this;
}

public short getBeamParameterIndex()
{
    return beamParameterIndex; 
}

public EmitterBeam setFundamentalParameterData(EEFundamentalParameterData pFundamentalParameterData)
{
    fundamentalParameterData = pFundamentalParameterData;
    return this;
}

public EEFundamentalParameterData getFundamentalParameterData()
{
    return fundamentalParameterData; 
}

public EmitterBeam setBeamData(BeamData pBeamData)
{
    beamData = pBeamData;
    return this;
}

public BeamData getBeamData()
{
    return beamData; 
}

public EmitterBeam setBeamFunction(ElectromagneticEmissionBeamFunction pBeamFunction)
{
    beamFunction = pBeamFunction;
    return this;
}

public ElectromagneticEmissionBeamFunction getBeamFunction()
{
    return beamFunction; 
}

public EmitterBeam setHighDensityTrackJam(HighDensityTrackJam pHighDensityTrackJam)
{
    highDensityTrackJam = pHighDensityTrackJam;
    return this;
}

public HighDensityTrackJam getHighDensityTrackJam()
{
    return highDensityTrackJam; 
}

public EmitterBeam setBeamStatus(BeamStatus pBeamStatus)
{
    beamStatus = pBeamStatus;
    return this;
}

public BeamStatus getBeamStatus()
{
    return beamStatus; 
}

public EmitterBeam setJammingTechnique(JammingTechnique pJammingTechnique)
{
    jammingTechnique = pJammingTechnique;
    return this;
}

public JammingTechnique getJammingTechnique()
{
    return jammingTechnique; 
}

public EmitterBeam setTrackJamData(List<TrackJamData> pTrackJamData)
{
    trackJamData = pTrackJamData;
    return this;
}

public List<TrackJamData> getTrackJamData()
{
    return trackJamData; 
}

/**
 * Serializes an object to a DataOutputStream.
 * @see java.io.DataOutputStream
 * @param dos The DataOutputStream
 */
public void marshal(DataOutputStream dos)
{
    try 
    {
       dos.writeByte( (byte)beamDataLength);
       dos.writeByte( (byte)beamNumber);
       dos.writeShort( (short)beamParameterIndex);
       fundamentalParameterData.marshal(dos);
       beamData.marshal(dos);
       beamFunction.marshal(dos);
       dos.writeByte( (byte)trackJamData.size());
       highDensityTrackJam.marshal(dos);
       beamStatus.marshal(dos);
       jammingTechnique.marshal(dos);

       for(int idx = 0; idx < trackJamData.size(); idx++)
       {
            TrackJamData aTrackJamData = trackJamData.get(idx);
            aTrackJamData.marshal(dos);
       }

    }
    catch(Exception e)
    {
      System.err.println(e);
    }
}

/**
 * Unserializes an object from a DataInputStream.
 * @see java.io.DataInputStream
 * @param dis The DataInputStream
 * @return marshalled size
 */
public int unmarshal(DataInputStream dis)
{
    int uPosition = 0;
    try 
    {
        beamDataLength = (byte)dis.readUnsignedByte();
        uPosition += 1;
        beamNumber = (byte)dis.readUnsignedByte();
        uPosition += 1;
        beamParameterIndex = (short)dis.readUnsignedShort();
        uPosition += 2;
        uPosition += fundamentalParameterData.unmarshal(dis);
        uPosition += beamData.unmarshal(dis);
        beamFunction = ElectromagneticEmissionBeamFunction.unmarshalEnum(dis);
        uPosition += beamFunction.getMarshalledSize();
        numberOfTargets = (byte)dis.readUnsignedByte();
        uPosition += 1;
        highDensityTrackJam = HighDensityTrackJam.unmarshalEnum(dis);
        uPosition += highDensityTrackJam.getMarshalledSize();
        uPosition += beamStatus.unmarshal(dis);
        uPosition += jammingTechnique.unmarshal(dis);
        for(int idx = 0; idx < numberOfTargets; idx++)
        {
            TrackJamData anX = new TrackJamData();
            uPosition += anX.unmarshal(dis);
            trackJamData.add(anX);
        }

    }
    catch(Exception e)
    { 
      System.out.println(e); 
    }
    return getMarshalledSize();
}

/**
 * Packs an object into the ByteBuffer.
 * @throws java.nio.BufferOverflowException if buff is too small
 * @throws java.nio.ReadOnlyBufferException if buff is read only
 * @see java.nio.ByteBuffer
 * @param buff The ByteBuffer at the position to begin writing
 * @throws Exception ByteBuffer-generated exception
 */
public void marshal(java.nio.ByteBuffer buff) throws Exception
{
   buff.put( (byte)beamDataLength);
   buff.put( (byte)beamNumber);
   buff.putShort( (short)beamParameterIndex);
   fundamentalParameterData.marshal(buff);
   beamData.marshal(buff);
   beamFunction.marshal(buff);
   buff.put( (byte)trackJamData.size());
   highDensityTrackJam.marshal(buff);
   beamStatus.marshal(buff);
   jammingTechnique.marshal(buff);

   for(int idx = 0; idx < trackJamData.size(); idx++)
   {
        TrackJamData aTrackJamData = (TrackJamData)trackJamData.get(idx);
        aTrackJamData.marshal(buff);
   }

}

/**
 * Unpacks a Pdu from the underlying data.
 * @throws java.nio.BufferUnderflowException if buff is too small
 * @see java.nio.ByteBuffer
 * @param buff The ByteBuffer at the position to begin reading
 * @return marshalled size
 * @throws Exception ByteBuffer-generated exception
 */
public int unmarshal(java.nio.ByteBuffer buff) throws Exception
{
    beamDataLength = (byte)(buff.get() & 0xFF);
    beamNumber = (byte)(buff.get() & 0xFF);
    beamParameterIndex = (short)(buff.getShort() & 0xFFFF);
    fundamentalParameterData.unmarshal(buff);
    beamData.unmarshal(buff);
    beamFunction = ElectromagneticEmissionBeamFunction.unmarshalEnum(buff);
    numberOfTargets = (byte)(buff.get() & 0xFF);
    highDensityTrackJam = HighDensityTrackJam.unmarshalEnum(buff);
    beamStatus.unmarshal(buff);
    jammingTechnique.unmarshal(buff);
    for(int idx = 0; idx < numberOfTargets; idx++)
    {
    TrackJamData anX = new TrackJamData();
    anX.unmarshal(buff);
    trackJamData.add(anX);
    }

    return getMarshalledSize();
}

 /*
  * The equals method doesn't always work--mostly it works only on classes that consist only of primitives. Be careful.
  */
@Override
 public boolean equals(Object obj)
 {
    if(this == obj)
      return true;

    if(obj == null)
       return false;

    if(getClass() != obj.getClass())
        return false;

    return equalsImpl(obj);
 }

 /**
  * Compare all fields that contribute to the state, ignoring
  * transient and static fields, for <code>this</code> and the supplied object
  * @param obj the object to compare to
  * @return true if the objects are equal, false otherwise.
  */
 public boolean equalsImpl(Object obj)
 {
     boolean ivarsEqual = true;

    if(!(obj instanceof EmitterBeam))
        return false;

     final EmitterBeam rhs = (EmitterBeam)obj;

     if( ! (beamDataLength == rhs.beamDataLength)) ivarsEqual = false;
     if( ! (beamNumber == rhs.beamNumber)) ivarsEqual = false;
     if( ! (beamParameterIndex == rhs.beamParameterIndex)) ivarsEqual = false;
     if( ! (fundamentalParameterData.equals( rhs.fundamentalParameterData) )) ivarsEqual = false;
     if( ! (beamData.equals( rhs.beamData) )) ivarsEqual = false;
     if( ! (beamFunction == rhs.beamFunction)) ivarsEqual = false;
     if( ! (numberOfTargets == rhs.numberOfTargets)) ivarsEqual = false;
     if( ! (highDensityTrackJam == rhs.highDensityTrackJam)) ivarsEqual = false;
     if( ! (beamStatus.equals( rhs.beamStatus) )) ivarsEqual = false;
     if( ! (jammingTechnique.equals( rhs.jammingTechnique) )) ivarsEqual = false;

     for(int idx = 0; idx < trackJamData.size(); idx++)
        if( ! ( trackJamData.get(idx).equals(rhs.trackJamData.get(idx)))) ivarsEqual = false;

    return ivarsEqual;
 }
} // end of class
