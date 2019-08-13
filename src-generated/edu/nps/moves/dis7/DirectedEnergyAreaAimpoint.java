/**
 * Copyright (c) 2008-2019, MOVES Institute, Naval Postgraduate School. All rights reserved.
 * This work is licensed under the BSD open source license, available at https://www.movesinstitute.org/licenses/bsd.html
 */

package edu.nps.moves.dis7;

import java.util.*;
import java.io.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * DE Precision Aimpoint Record. Section 6.2.20.2
 * IEEE Std 1278.1-2012, IEEE Standard for Distributed Interactive Simulation—Application Protocols
 */
public class DirectedEnergyAreaAimpoint extends Object implements Serializable
{
   /** Type of Record enumeration */
   protected int  recordType = (int)4001;

   /** Length of Record */
   protected short  recordLength;

   /** Padding */
   protected short  padding = (short)0;

   /** Number of beam antenna pattern records */
   protected short  beamAntennaPatternRecordCount = (short)0;

   /** Number of DE target energy depositon records */
   protected short  directedEnergyTargetEnergyDepositionRecordCount = (short)0;

   /** list of beam antenna records. See 6.2.9.2 */
   protected List< BeamAntennaPattern > beamAntennaParameterList = new ArrayList< BeamAntennaPattern >();
 
   /** list of DE target deposition records. See 6.2.21.4 */
   protected List< DirectedEnergyTargetEnergyDeposition > directedEnergyTargetEnergyDepositionRecordList = new ArrayList< DirectedEnergyTargetEnergyDeposition >();
 
   private byte[] padding2 = new byte[0]; // pad to 64-bit boundary


/** Constructor */
 public DirectedEnergyAreaAimpoint()
 {
 }

public int getMarshalledSize()
{
   int marshalSize = 0; 

   marshalSize += 4;  // recordType
   marshalSize += 2;  // recordLength
   marshalSize += 2;  // padding
   marshalSize += 2;  // beamAntennaPatternRecordCount
   marshalSize += 2;  // directedEnergyTargetEnergyDepositionRecordCount
   for(int idx=0; idx < beamAntennaParameterList.size(); idx++)
   {
        BeamAntennaPattern listElement = beamAntennaParameterList.get(idx);
        marshalSize += listElement.getMarshalledSize();
   }
   for(int idx=0; idx < directedEnergyTargetEnergyDepositionRecordList.size(); idx++)
   {
        DirectedEnergyTargetEnergyDeposition listElement = directedEnergyTargetEnergyDepositionRecordList.get(idx);
        marshalSize += listElement.getMarshalledSize();
   }
   marshalSize += padding2.length;

   return marshalSize;
}


public DirectedEnergyAreaAimpoint setRecordType(int pRecordType)
{
    recordType = pRecordType;
    return this;
}

public int getRecordType()
{
    return recordType; 
}

public DirectedEnergyAreaAimpoint setRecordLength(short pRecordLength)
{
    recordLength = pRecordLength;
    return this;
}

public short getRecordLength()
{
    return recordLength; 
}

public DirectedEnergyAreaAimpoint setPadding(short pPadding)
{
    padding = pPadding;
    return this;
}

public short getPadding()
{
    return padding; 
}

public DirectedEnergyAreaAimpoint setBeamAntennaParameterList(List<BeamAntennaPattern> pBeamAntennaParameterList)
{
    beamAntennaParameterList = pBeamAntennaParameterList;
    return this;
}

public List<BeamAntennaPattern> getBeamAntennaParameterList()
{
    return beamAntennaParameterList; 
}

public DirectedEnergyAreaAimpoint setDirectedEnergyTargetEnergyDepositionRecordList(List<DirectedEnergyTargetEnergyDeposition> pDirectedEnergyTargetEnergyDepositionRecordList)
{
    directedEnergyTargetEnergyDepositionRecordList = pDirectedEnergyTargetEnergyDepositionRecordList;
    return this;
}

public List<DirectedEnergyTargetEnergyDeposition> getDirectedEnergyTargetEnergyDepositionRecordList()
{
    return directedEnergyTargetEnergyDepositionRecordList; 
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
       dos.writeInt( (int)recordType);
       dos.writeShort( (short)recordLength);
       dos.writeShort( (short)padding);
       dos.writeShort( (short)beamAntennaParameterList.size());
       dos.writeShort( (short)directedEnergyTargetEnergyDepositionRecordList.size());

       for(int idx = 0; idx < beamAntennaParameterList.size(); idx++)
       {
            BeamAntennaPattern aBeamAntennaPattern = beamAntennaParameterList.get(idx);
            aBeamAntennaPattern.marshal(dos);
       }


       for(int idx = 0; idx < directedEnergyTargetEnergyDepositionRecordList.size(); idx++)
       {
            DirectedEnergyTargetEnergyDeposition aDirectedEnergyTargetEnergyDeposition = directedEnergyTargetEnergyDepositionRecordList.get(idx);
            aDirectedEnergyTargetEnergyDeposition.marshal(dos);
       }

       padding2 = new byte[Align.to64bits(dos)];
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
        recordType = dis.readInt();
        uPosition += 4;
        recordLength = (short)dis.readUnsignedShort();
        uPosition += 2;
        padding = (short)dis.readUnsignedShort();
        uPosition += 2;
        beamAntennaPatternRecordCount = (short)dis.readUnsignedShort();
        uPosition += 2;
        directedEnergyTargetEnergyDepositionRecordCount = (short)dis.readUnsignedShort();
        uPosition += 2;
        for(int idx = 0; idx < beamAntennaPatternRecordCount; idx++)
        {
            BeamAntennaPattern anX = new BeamAntennaPattern();
            uPosition += anX.unmarshal(dis);
            beamAntennaParameterList.add(anX);
        }

        for(int idx = 0; idx < directedEnergyTargetEnergyDepositionRecordCount; idx++)
        {
            DirectedEnergyTargetEnergyDeposition anX = new DirectedEnergyTargetEnergyDeposition();
            uPosition += anX.unmarshal(dis);
            directedEnergyTargetEnergyDepositionRecordList.add(anX);
        }

        padding2 = new byte[Align.from64bits(uPosition,dis)];
        uPosition += padding2.length;
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
   buff.putInt( (int)recordType);
   buff.putShort( (short)recordLength);
   buff.putShort( (short)padding);
   buff.putShort( (short)beamAntennaParameterList.size());
   buff.putShort( (short)directedEnergyTargetEnergyDepositionRecordList.size());

   for(int idx = 0; idx < beamAntennaParameterList.size(); idx++)
   {
        BeamAntennaPattern aBeamAntennaPattern = (BeamAntennaPattern)beamAntennaParameterList.get(idx);
        aBeamAntennaPattern.marshal(buff);
   }


   for(int idx = 0; idx < directedEnergyTargetEnergyDepositionRecordList.size(); idx++)
   {
        DirectedEnergyTargetEnergyDeposition aDirectedEnergyTargetEnergyDeposition = (DirectedEnergyTargetEnergyDeposition)directedEnergyTargetEnergyDepositionRecordList.get(idx);
        aDirectedEnergyTargetEnergyDeposition.marshal(buff);
   }

   padding2 = new byte[Align.to64bits(buff)];
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
    recordType = buff.getInt();
    recordLength = (short)(buff.getShort() & 0xFFFF);
    padding = (short)(buff.getShort() & 0xFFFF);
    beamAntennaPatternRecordCount = (short)(buff.getShort() & 0xFFFF);
    directedEnergyTargetEnergyDepositionRecordCount = (short)(buff.getShort() & 0xFFFF);
    for(int idx = 0; idx < beamAntennaPatternRecordCount; idx++)
    {
    BeamAntennaPattern anX = new BeamAntennaPattern();
    anX.unmarshal(buff);
    beamAntennaParameterList.add(anX);
    }

    for(int idx = 0; idx < directedEnergyTargetEnergyDepositionRecordCount; idx++)
    {
    DirectedEnergyTargetEnergyDeposition anX = new DirectedEnergyTargetEnergyDeposition();
    anX.unmarshal(buff);
    directedEnergyTargetEnergyDepositionRecordList.add(anX);
    }

    padding2 = new byte[Align.from64bits(buff)];
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

    if(!(obj instanceof DirectedEnergyAreaAimpoint))
        return false;

     final DirectedEnergyAreaAimpoint rhs = (DirectedEnergyAreaAimpoint)obj;

     if( ! (recordType == rhs.recordType)) ivarsEqual = false;
     if( ! (recordLength == rhs.recordLength)) ivarsEqual = false;
     if( ! (padding == rhs.padding)) ivarsEqual = false;
     if( ! (beamAntennaPatternRecordCount == rhs.beamAntennaPatternRecordCount)) ivarsEqual = false;
     if( ! (directedEnergyTargetEnergyDepositionRecordCount == rhs.directedEnergyTargetEnergyDepositionRecordCount)) ivarsEqual = false;

     for(int idx = 0; idx < beamAntennaParameterList.size(); idx++)
        if( ! ( beamAntennaParameterList.get(idx).equals(rhs.beamAntennaParameterList.get(idx)))) ivarsEqual = false;


     for(int idx = 0; idx < directedEnergyTargetEnergyDepositionRecordList.size(); idx++)
        if( ! ( directedEnergyTargetEnergyDepositionRecordList.get(idx).equals(rhs.directedEnergyTargetEnergyDepositionRecordList.get(idx)))) ivarsEqual = false;

    return ivarsEqual;
 }
} // end of class
