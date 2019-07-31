/**
 * Copyright (c) 2008-2019, MOVES Institute, Naval Postgraduate School. All rights reserved.
 * This work is licensed under the BSD open source license, available at https://www.movesinstitute.org/licenses/bsd.html
 */

package edu.nps.moves.dis;

import java.util.*;
import java.io.*;
import edu.nps.moves.dis.enumerations.*;

/**
 * 6.2.48.2
 * IEEE Std 1278.1-2012, IEEE Standard for Distributed Interactive Simulation—Application Protocols
 */
public class IOCommsNodeRecord extends IORecord implements Serializable
{
   /**  uid 66 */
   protected VariableRecordTypes recordType = VariableRecordTypes.IO_COMMUNICATIONS_NODE;

   protected short  recordLength;

   /**  uid 294 */
   protected IOCommsNodeRecordCommsNodeType commsNodeType = IOCommsNodeRecordCommsNodeType.values()[0];

   protected byte  padding;

   protected CommunicationsNodeID  commsNodeId = new CommunicationsNodeID(); 


/** Constructor */
 public IOCommsNodeRecord()
 {
 }

public int getMarshalledSize()
{
   int marshalSize = 0; 

   marshalSize = super.getMarshalledSize();
   marshalSize += recordType.getMarshalledSize();
   marshalSize += 2;  // recordLength
   marshalSize += commsNodeType.getMarshalledSize();
   marshalSize += 1;  // padding
   marshalSize += commsNodeId.getMarshalledSize();

   return marshalSize;
}


public IOCommsNodeRecord setRecordType(VariableRecordTypes pRecordType)
{
    recordType = pRecordType;
    return this;
}

public VariableRecordTypes getRecordType()
{
    return recordType; 
}

public IOCommsNodeRecord setRecordLength(short pRecordLength)
{
    recordLength = pRecordLength;
    return this;
}

public short getRecordLength()
{
    return recordLength; 
}

public IOCommsNodeRecord setCommsNodeType(IOCommsNodeRecordCommsNodeType pCommsNodeType)
{
    commsNodeType = pCommsNodeType;
    return this;
}

public IOCommsNodeRecordCommsNodeType getCommsNodeType()
{
    return commsNodeType; 
}

public IOCommsNodeRecord setPadding(byte pPadding)
{
    padding = pPadding;
    return this;
}

public byte getPadding()
{
    return padding; 
}

public IOCommsNodeRecord setCommsNodeId(CommunicationsNodeID pCommsNodeId)
{
    commsNodeId = pCommsNodeId;
    return this;
}

public CommunicationsNodeID getCommsNodeId()
{
    return commsNodeId; 
}

/**
 * Serializes an object to a DataOutputStream.
 * @see java.io.DataOutputStream
 * @param dos The DataOutputStream
 */
public void marshal(DataOutputStream dos)
{
    super.marshal(dos);
    try 
    {
       recordType.marshal(dos);
       dos.writeShort( (short)recordLength);
       commsNodeType.marshal(dos);
       dos.writeByte( (byte)padding);
       commsNodeId.marshal(dos);
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
    uPosition += super.unmarshal(dis);

    try 
    {
        recordType = VariableRecordTypes.unmarshalEnum(dis);
        uPosition += recordType.getMarshalledSize();
        recordLength = (short)dis.readUnsignedShort();
        uPosition += 2;
        commsNodeType = IOCommsNodeRecordCommsNodeType.unmarshalEnum(dis);
        uPosition += commsNodeType.getMarshalledSize();
        padding = (byte)dis.readUnsignedByte();
        uPosition += 1;
        uPosition += commsNodeId.unmarshal(dis);
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
   super.marshal(buff);
   recordType.marshal(buff);
   buff.putShort( (short)recordLength);
   commsNodeType.marshal(buff);
   buff.put( (byte)padding);
   commsNodeId.marshal(buff);
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
    super.unmarshal(buff);

    recordType = VariableRecordTypes.unmarshalEnum(buff);
    recordLength = (short)(buff.getShort() & 0xFFFF);
    commsNodeType = IOCommsNodeRecordCommsNodeType.unmarshalEnum(buff);
    padding = (byte)(buff.get() & 0xFF);
    commsNodeId.unmarshal(buff);
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

@Override
 public boolean equalsImpl(Object obj)
 {
     boolean ivarsEqual = true;

    if(!(obj instanceof IOCommsNodeRecord))
        return false;

     final IOCommsNodeRecord rhs = (IOCommsNodeRecord)obj;

     if( ! (recordType == rhs.recordType)) ivarsEqual = false;
     if( ! (recordLength == rhs.recordLength)) ivarsEqual = false;
     if( ! (commsNodeType == rhs.commsNodeType)) ivarsEqual = false;
     if( ! (padding == rhs.padding)) ivarsEqual = false;
     if( ! (commsNodeId.equals( rhs.commsNodeId) )) ivarsEqual = false;
    return ivarsEqual && super.equalsImpl(rhs);
 }
} // end of class
