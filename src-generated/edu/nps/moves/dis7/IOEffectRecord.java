/**
 * Copyright (c) 2008-2019, MOVES Institute, Naval Postgraduate School. All rights reserved.
 * This work is licensed under the BSD open source license, available at https://www.movesinstitute.org/licenses/bsd.html
 */

package edu.nps.moves.dis7;

import java.util.*;
import java.io.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * 6.2.48.3
 * IEEE Std 1278.1-2012, IEEE Standard for Distributed Interactive Simulation—Application Protocols
 */
public class IOEffectRecord extends IORecord implements Serializable
{
   /**  uid 66 */
   protected VariableRecordTypes recordType = VariableRecordTypes.IO_EFFECT;

   protected short  recordLength;

   /**  uid 290 */
   protected IOEffectsRecordIOStatus ioStatus = IOEffectsRecordIOStatus.values()[0];

   /**  uid 291 */
   protected IOEffectsRecordIOLinkType ioLinkType = IOEffectsRecordIOLinkType.values()[0];

   /**  uid 292 */
   protected IOEffectsRecordIOEffect ioEffect = IOEffectsRecordIOEffect.values()[0];

   protected byte  ioEffectDutyCycle;

   protected short  ioEffectDuration;

   /**  uid 293 */
   protected IOEffectsRecordIOProcess ioProcess = IOEffectsRecordIOProcess.values()[0];

   protected short  padding;


/** Constructor */
 public IOEffectRecord()
 {
 }

/** Returns the size of this serialized object in bytes*/
public int getMarshalledSize()
{
   int marshalSize = 0; 

   marshalSize = super.getMarshalledSize();
   marshalSize += recordType.getMarshalledSize();
   marshalSize += 2;  // recordLength
   marshalSize += ioStatus.getMarshalledSize();
   marshalSize += ioLinkType.getMarshalledSize();
   marshalSize += ioEffect.getMarshalledSize();
   marshalSize += 1;  // ioEffectDutyCycle
   marshalSize += 2;  // ioEffectDuration
   marshalSize += ioProcess.getMarshalledSize();
   marshalSize += 2;  // padding

   return marshalSize;
}


/** Setter for {@link IOEffectRecord#recordType}*/
public IOEffectRecord setRecordType(VariableRecordTypes pRecordType)
{
    recordType = pRecordType;
    return this;
}

/** Getter for {@link IOEffectRecord#recordType}*/
public VariableRecordTypes getRecordType()
{
    return recordType; 
}

/** Setter for {@link IOEffectRecord#recordLength}*/
public IOEffectRecord setRecordLength(short pRecordLength)
{
    recordLength = pRecordLength;
    return this;
}

/** Getter for {@link IOEffectRecord#recordLength}*/
public short getRecordLength()
{
    return recordLength; 
}

/** Setter for {@link IOEffectRecord#ioStatus}*/
public IOEffectRecord setIoStatus(IOEffectsRecordIOStatus pIoStatus)
{
    ioStatus = pIoStatus;
    return this;
}

/** Getter for {@link IOEffectRecord#ioStatus}*/
public IOEffectsRecordIOStatus getIoStatus()
{
    return ioStatus; 
}

/** Setter for {@link IOEffectRecord#ioLinkType}*/
public IOEffectRecord setIoLinkType(IOEffectsRecordIOLinkType pIoLinkType)
{
    ioLinkType = pIoLinkType;
    return this;
}

/** Getter for {@link IOEffectRecord#ioLinkType}*/
public IOEffectsRecordIOLinkType getIoLinkType()
{
    return ioLinkType; 
}

/** Setter for {@link IOEffectRecord#ioEffect}*/
public IOEffectRecord setIoEffect(IOEffectsRecordIOEffect pIoEffect)
{
    ioEffect = pIoEffect;
    return this;
}

/** Getter for {@link IOEffectRecord#ioEffect}*/
public IOEffectsRecordIOEffect getIoEffect()
{
    return ioEffect; 
}

/** Setter for {@link IOEffectRecord#ioEffectDutyCycle}*/
public IOEffectRecord setIoEffectDutyCycle(byte pIoEffectDutyCycle)
{
    ioEffectDutyCycle = pIoEffectDutyCycle;
    return this;
}

/** Getter for {@link IOEffectRecord#ioEffectDutyCycle}*/
public byte getIoEffectDutyCycle()
{
    return ioEffectDutyCycle; 
}

/** Setter for {@link IOEffectRecord#ioEffectDuration}*/
public IOEffectRecord setIoEffectDuration(short pIoEffectDuration)
{
    ioEffectDuration = pIoEffectDuration;
    return this;
}

/** Getter for {@link IOEffectRecord#ioEffectDuration}*/
public short getIoEffectDuration()
{
    return ioEffectDuration; 
}

/** Setter for {@link IOEffectRecord#ioProcess}*/
public IOEffectRecord setIoProcess(IOEffectsRecordIOProcess pIoProcess)
{
    ioProcess = pIoProcess;
    return this;
}

/** Getter for {@link IOEffectRecord#ioProcess}*/
public IOEffectsRecordIOProcess getIoProcess()
{
    return ioProcess; 
}

/** Setter for {@link IOEffectRecord#padding}*/
public IOEffectRecord setPadding(short pPadding)
{
    padding = pPadding;
    return this;
}

/** Getter for {@link IOEffectRecord#padding}*/
public short getPadding()
{
    return padding; 
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
       ioStatus.marshal(dos);
       ioLinkType.marshal(dos);
       ioEffect.marshal(dos);
       dos.writeByte( (byte)ioEffectDutyCycle);
       dos.writeShort( (short)ioEffectDuration);
       ioProcess.marshal(dos);
       dos.writeShort( (short)padding);
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
        ioStatus = IOEffectsRecordIOStatus.unmarshalEnum(dis);
        uPosition += ioStatus.getMarshalledSize();
        ioLinkType = IOEffectsRecordIOLinkType.unmarshalEnum(dis);
        uPosition += ioLinkType.getMarshalledSize();
        ioEffect = IOEffectsRecordIOEffect.unmarshalEnum(dis);
        uPosition += ioEffect.getMarshalledSize();
        ioEffectDutyCycle = (byte)dis.readUnsignedByte();
        uPosition += 1;
        ioEffectDuration = (short)dis.readUnsignedShort();
        uPosition += 2;
        ioProcess = IOEffectsRecordIOProcess.unmarshalEnum(dis);
        uPosition += ioProcess.getMarshalledSize();
        padding = (short)dis.readUnsignedShort();
        uPosition += 2;
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
   ioStatus.marshal(buff);
   ioLinkType.marshal(buff);
   ioEffect.marshal(buff);
   buff.put( (byte)ioEffectDutyCycle);
   buff.putShort( (short)ioEffectDuration);
   ioProcess.marshal(buff);
   buff.putShort( (short)padding);
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
    ioStatus = IOEffectsRecordIOStatus.unmarshalEnum(buff);
    ioLinkType = IOEffectsRecordIOLinkType.unmarshalEnum(buff);
    ioEffect = IOEffectsRecordIOEffect.unmarshalEnum(buff);
    ioEffectDutyCycle = (byte)(buff.get() & 0xFF);
    ioEffectDuration = (short)(buff.getShort() & 0xFFFF);
    ioProcess = IOEffectsRecordIOProcess.unmarshalEnum(buff);
    padding = (short)(buff.getShort() & 0xFFFF);
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

    if(!(obj instanceof IOEffectRecord))
        return false;

     final IOEffectRecord rhs = (IOEffectRecord)obj;

     if( ! (recordType == rhs.recordType)) ivarsEqual = false;
     if( ! (recordLength == rhs.recordLength)) ivarsEqual = false;
     if( ! (ioStatus == rhs.ioStatus)) ivarsEqual = false;
     if( ! (ioLinkType == rhs.ioLinkType)) ivarsEqual = false;
     if( ! (ioEffect == rhs.ioEffect)) ivarsEqual = false;
     if( ! (ioEffectDutyCycle == rhs.ioEffectDutyCycle)) ivarsEqual = false;
     if( ! (ioEffectDuration == rhs.ioEffectDuration)) ivarsEqual = false;
     if( ! (ioProcess == rhs.ioProcess)) ivarsEqual = false;
     if( ! (padding == rhs.padding)) ivarsEqual = false;
    return ivarsEqual && super.equalsImpl(rhs);
 }
} // end of class
