/**
 * Copyright (c) 2008-2019, MOVES Institute, Naval Postgraduate School. All rights reserved.
 * This work is licensed under the BSD open source license, available at https://www.movesinstitute.org/licenses/bsd.html
 */

package edu.nps.moves.dis7;

import java.util.*;
import java.io.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * 5.8.7 Communicates the state of a particular intercom device, request an action of another intercom device, or respond to an action request.
 * IEEE Std 1278.1-2012, IEEE Standard for Distributed Interactive Simulation—Application Protocols
 */
public class IntercomControlPdu extends RadioCommunicationsFamilyPdu implements Serializable
{
   /** control type uid 180 */
   protected IntercomControlControlType controlType = IntercomControlControlType.values()[0];

   /** control type */
   protected byte  communicationsChannelType;

   /** Source entity ID, this can also be ObjectIdentifier or UnattachedIdentifier */
   protected EntityID  sourceEntityID = new EntityID(); 

   /** The specific intercom device being simulated within an entity. */
   protected short  sourceIntercomNumber;

   /** Line number to which the intercom control refers */
   protected byte  sourceLineID;

   /** priority of this message relative to transmissons from other intercom devices */
   protected byte  transmitPriority;

   /** current transmit state of the line uid 183 */
   protected IntercomControlTransmitLineState transmitLineState = IntercomControlTransmitLineState.values()[0];

   /** detailed type requested. uid 182 */
   protected IntercomControlCommand command = IntercomControlCommand.values()[0];

   /** eid of the entity that has created this intercom channel, same comments as sourceEntityId */
   protected EntityID  masterIntercomReferenceID = new EntityID(); 

   /** specific intercom device that has created this intercom channel */
   protected short  masterIntercomNumber;

   protected short  masterChannelID;

   /** number of intercom parameters */
   protected int  intercomParametersLength;

   protected List< IntercomCommunicationsParameters > intercomParameters = new ArrayList< IntercomCommunicationsParameters >();
 

/** Constructor */
 public IntercomControlPdu()
 {
    setPduType( DISPDUType.INTERCOM_CONTROL );
 }

public int getMarshalledSize()
{
   int marshalSize = 0; 

   marshalSize = super.getMarshalledSize();
   marshalSize += controlType.getMarshalledSize();
   marshalSize += 1;  // communicationsChannelType
   marshalSize += sourceEntityID.getMarshalledSize();
   marshalSize += 2;  // sourceIntercomNumber
   marshalSize += 1;  // sourceLineID
   marshalSize += 1;  // transmitPriority
   marshalSize += transmitLineState.getMarshalledSize();
   marshalSize += command.getMarshalledSize();
   marshalSize += masterIntercomReferenceID.getMarshalledSize();
   marshalSize += 2;  // masterIntercomNumber
   marshalSize += 2;  // masterChannelID
   marshalSize += 4;  // intercomParametersLength
   for(int idx=0; idx < intercomParameters.size(); idx++)
   {
        IntercomCommunicationsParameters listElement = intercomParameters.get(idx);
        marshalSize += listElement.getMarshalledSize();
   }

   return marshalSize;
}


public IntercomControlPdu setControlType(IntercomControlControlType pControlType)
{
    controlType = pControlType;
    return this;
}

public IntercomControlControlType getControlType()
{
    return controlType; 
}

public IntercomControlPdu setCommunicationsChannelType(byte pCommunicationsChannelType)
{
    communicationsChannelType = pCommunicationsChannelType;
    return this;
}

public byte getCommunicationsChannelType()
{
    return communicationsChannelType; 
}

public IntercomControlPdu setSourceEntityID(EntityID pSourceEntityID)
{
    sourceEntityID = pSourceEntityID;
    return this;
}

public EntityID getSourceEntityID()
{
    return sourceEntityID; 
}

public IntercomControlPdu setSourceIntercomNumber(short pSourceIntercomNumber)
{
    sourceIntercomNumber = pSourceIntercomNumber;
    return this;
}

public short getSourceIntercomNumber()
{
    return sourceIntercomNumber; 
}

public IntercomControlPdu setSourceLineID(byte pSourceLineID)
{
    sourceLineID = pSourceLineID;
    return this;
}

public byte getSourceLineID()
{
    return sourceLineID; 
}

public IntercomControlPdu setTransmitPriority(byte pTransmitPriority)
{
    transmitPriority = pTransmitPriority;
    return this;
}

public byte getTransmitPriority()
{
    return transmitPriority; 
}

public IntercomControlPdu setTransmitLineState(IntercomControlTransmitLineState pTransmitLineState)
{
    transmitLineState = pTransmitLineState;
    return this;
}

public IntercomControlTransmitLineState getTransmitLineState()
{
    return transmitLineState; 
}

public IntercomControlPdu setCommand(IntercomControlCommand pCommand)
{
    command = pCommand;
    return this;
}

public IntercomControlCommand getCommand()
{
    return command; 
}

public IntercomControlPdu setMasterIntercomReferenceID(EntityID pMasterIntercomReferenceID)
{
    masterIntercomReferenceID = pMasterIntercomReferenceID;
    return this;
}

public EntityID getMasterIntercomReferenceID()
{
    return masterIntercomReferenceID; 
}

public IntercomControlPdu setMasterIntercomNumber(short pMasterIntercomNumber)
{
    masterIntercomNumber = pMasterIntercomNumber;
    return this;
}

public short getMasterIntercomNumber()
{
    return masterIntercomNumber; 
}

public IntercomControlPdu setMasterChannelID(short pMasterChannelID)
{
    masterChannelID = pMasterChannelID;
    return this;
}

public short getMasterChannelID()
{
    return masterChannelID; 
}

public IntercomControlPdu setIntercomParameters(List<IntercomCommunicationsParameters> pIntercomParameters)
{
    intercomParameters = pIntercomParameters;
    return this;
}

public List<IntercomCommunicationsParameters> getIntercomParameters()
{
    return intercomParameters; 
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
       controlType.marshal(dos);
       dos.writeByte( (byte)communicationsChannelType);
       sourceEntityID.marshal(dos);
       dos.writeShort( (short)sourceIntercomNumber);
       dos.writeByte( (byte)sourceLineID);
       dos.writeByte( (byte)transmitPriority);
       transmitLineState.marshal(dos);
       command.marshal(dos);
       masterIntercomReferenceID.marshal(dos);
       dos.writeShort( (short)masterIntercomNumber);
       dos.writeShort( (short)masterChannelID);
       dos.writeInt( (int)intercomParameters.size());

       for(int idx = 0; idx < intercomParameters.size(); idx++)
       {
            IntercomCommunicationsParameters aIntercomCommunicationsParameters = intercomParameters.get(idx);
            aIntercomCommunicationsParameters.marshal(dos);
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
    uPosition += super.unmarshal(dis);

    try 
    {
        controlType = IntercomControlControlType.unmarshalEnum(dis);
        uPosition += controlType.getMarshalledSize();
        communicationsChannelType = (byte)dis.readUnsignedByte();
        uPosition += 1;
        uPosition += sourceEntityID.unmarshal(dis);
        sourceIntercomNumber = (short)dis.readUnsignedShort();
        uPosition += 2;
        sourceLineID = (byte)dis.readUnsignedByte();
        uPosition += 1;
        transmitPriority = (byte)dis.readUnsignedByte();
        uPosition += 1;
        transmitLineState = IntercomControlTransmitLineState.unmarshalEnum(dis);
        uPosition += transmitLineState.getMarshalledSize();
        command = IntercomControlCommand.unmarshalEnum(dis);
        uPosition += command.getMarshalledSize();
        uPosition += masterIntercomReferenceID.unmarshal(dis);
        masterIntercomNumber = (short)dis.readUnsignedShort();
        uPosition += 2;
        masterChannelID = (short)dis.readUnsignedShort();
        uPosition += 2;
        intercomParametersLength = dis.readInt();
        uPosition += 4;
        for(int idx = 0; idx < intercomParametersLength; idx++)
        {
            IntercomCommunicationsParameters anX = new IntercomCommunicationsParameters();
            uPosition += anX.unmarshal(dis);
            intercomParameters.add(anX);
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
   super.marshal(buff);
   controlType.marshal(buff);
   buff.put( (byte)communicationsChannelType);
   sourceEntityID.marshal(buff);
   buff.putShort( (short)sourceIntercomNumber);
   buff.put( (byte)sourceLineID);
   buff.put( (byte)transmitPriority);
   transmitLineState.marshal(buff);
   command.marshal(buff);
   masterIntercomReferenceID.marshal(buff);
   buff.putShort( (short)masterIntercomNumber);
   buff.putShort( (short)masterChannelID);
   buff.putInt( (int)intercomParameters.size());

   for(int idx = 0; idx < intercomParameters.size(); idx++)
   {
        IntercomCommunicationsParameters aIntercomCommunicationsParameters = (IntercomCommunicationsParameters)intercomParameters.get(idx);
        aIntercomCommunicationsParameters.marshal(buff);
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
    super.unmarshal(buff);

    controlType = IntercomControlControlType.unmarshalEnum(buff);
    communicationsChannelType = (byte)(buff.get() & 0xFF);
    sourceEntityID.unmarshal(buff);
    sourceIntercomNumber = (short)(buff.getShort() & 0xFFFF);
    sourceLineID = (byte)(buff.get() & 0xFF);
    transmitPriority = (byte)(buff.get() & 0xFF);
    transmitLineState = IntercomControlTransmitLineState.unmarshalEnum(buff);
    command = IntercomControlCommand.unmarshalEnum(buff);
    masterIntercomReferenceID.unmarshal(buff);
    masterIntercomNumber = (short)(buff.getShort() & 0xFFFF);
    masterChannelID = (short)(buff.getShort() & 0xFFFF);
    intercomParametersLength = buff.getInt();
    for(int idx = 0; idx < intercomParametersLength; idx++)
    {
    IntercomCommunicationsParameters anX = new IntercomCommunicationsParameters();
    anX.unmarshal(buff);
    intercomParameters.add(anX);
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

@Override
 public boolean equalsImpl(Object obj)
 {
     boolean ivarsEqual = true;

    if(!(obj instanceof IntercomControlPdu))
        return false;

     final IntercomControlPdu rhs = (IntercomControlPdu)obj;

     if( ! (controlType == rhs.controlType)) ivarsEqual = false;
     if( ! (communicationsChannelType == rhs.communicationsChannelType)) ivarsEqual = false;
     if( ! (sourceEntityID.equals( rhs.sourceEntityID) )) ivarsEqual = false;
     if( ! (sourceIntercomNumber == rhs.sourceIntercomNumber)) ivarsEqual = false;
     if( ! (sourceLineID == rhs.sourceLineID)) ivarsEqual = false;
     if( ! (transmitPriority == rhs.transmitPriority)) ivarsEqual = false;
     if( ! (transmitLineState == rhs.transmitLineState)) ivarsEqual = false;
     if( ! (command == rhs.command)) ivarsEqual = false;
     if( ! (masterIntercomReferenceID.equals( rhs.masterIntercomReferenceID) )) ivarsEqual = false;
     if( ! (masterIntercomNumber == rhs.masterIntercomNumber)) ivarsEqual = false;
     if( ! (masterChannelID == rhs.masterChannelID)) ivarsEqual = false;
     if( ! (intercomParametersLength == rhs.intercomParametersLength)) ivarsEqual = false;

     for(int idx = 0; idx < intercomParameters.size(); idx++)
        if( ! ( intercomParameters.get(idx).equals(rhs.intercomParameters.get(idx)))) ivarsEqual = false;

    return ivarsEqual && super.equalsImpl(rhs);
 }
} // end of class
