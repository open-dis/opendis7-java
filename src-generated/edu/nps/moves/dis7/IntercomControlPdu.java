/**
 * Copyright (c) 2008-2020, MOVES Institute, Naval Postgraduate School (NPS). All rights reserved.
 * This work is provided under a BSD open-source license, see project license.html and license.txt
 */

package edu.nps.moves.dis7;

import java.util.*;
import java.io.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * 5.8.7 Communicates the state of a particular intercom device, request an action of another intercom device, or respond to an action request.
 * IEEE Std 1278.1-2012, IEEE Standard for Distributed Interactive Simulation - Application Protocols
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

  /**
   * Returns size of this serialized object in bytes
   * @return size in bytes
   */
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


/** Setter for {@link IntercomControlPdu#controlType}*/
public IntercomControlPdu setControlType(IntercomControlControlType pControlType)
{
    controlType = pControlType;
    return this;
}

/** Getter for {@link IntercomControlPdu#controlType}*/
public IntercomControlControlType getControlType()
{
    return controlType; 
}

/** Setter for {@link IntercomControlPdu#communicationsChannelType}*/
public IntercomControlPdu setCommunicationsChannelType(byte pCommunicationsChannelType)
{
    communicationsChannelType = pCommunicationsChannelType;
    return this;
}

/** Getter for {@link IntercomControlPdu#communicationsChannelType}*/
public byte getCommunicationsChannelType()
{
    return communicationsChannelType; 
}

/** Setter for {@link IntercomControlPdu#sourceEntityID}*/
public IntercomControlPdu setSourceEntityID(EntityID pSourceEntityID)
{
    sourceEntityID = pSourceEntityID;
    return this;
}

/** Getter for {@link IntercomControlPdu#sourceEntityID}*/
public EntityID getSourceEntityID()
{
    return sourceEntityID; 
}

/** Setter for {@link IntercomControlPdu#sourceIntercomNumber}*/
public IntercomControlPdu setSourceIntercomNumber(short pSourceIntercomNumber)
{
    sourceIntercomNumber = pSourceIntercomNumber;
    return this;
}

/** Getter for {@link IntercomControlPdu#sourceIntercomNumber}*/
public short getSourceIntercomNumber()
{
    return sourceIntercomNumber; 
}

/** Setter for {@link IntercomControlPdu#sourceLineID}*/
public IntercomControlPdu setSourceLineID(byte pSourceLineID)
{
    sourceLineID = pSourceLineID;
    return this;
}

/** Getter for {@link IntercomControlPdu#sourceLineID}*/
public byte getSourceLineID()
{
    return sourceLineID; 
}

/** Setter for {@link IntercomControlPdu#transmitPriority}*/
public IntercomControlPdu setTransmitPriority(byte pTransmitPriority)
{
    transmitPriority = pTransmitPriority;
    return this;
}

/** Getter for {@link IntercomControlPdu#transmitPriority}*/
public byte getTransmitPriority()
{
    return transmitPriority; 
}

/** Setter for {@link IntercomControlPdu#transmitLineState}*/
public IntercomControlPdu setTransmitLineState(IntercomControlTransmitLineState pTransmitLineState)
{
    transmitLineState = pTransmitLineState;
    return this;
}

/** Getter for {@link IntercomControlPdu#transmitLineState}*/
public IntercomControlTransmitLineState getTransmitLineState()
{
    return transmitLineState; 
}

/** Setter for {@link IntercomControlPdu#command}*/
public IntercomControlPdu setCommand(IntercomControlCommand pCommand)
{
    command = pCommand;
    return this;
}

/** Getter for {@link IntercomControlPdu#command}*/
public IntercomControlCommand getCommand()
{
    return command; 
}

/** Setter for {@link IntercomControlPdu#masterIntercomReferenceID}*/
public IntercomControlPdu setMasterIntercomReferenceID(EntityID pMasterIntercomReferenceID)
{
    masterIntercomReferenceID = pMasterIntercomReferenceID;
    return this;
}

/** Getter for {@link IntercomControlPdu#masterIntercomReferenceID}*/
public EntityID getMasterIntercomReferenceID()
{
    return masterIntercomReferenceID; 
}

/** Setter for {@link IntercomControlPdu#masterIntercomNumber}*/
public IntercomControlPdu setMasterIntercomNumber(short pMasterIntercomNumber)
{
    masterIntercomNumber = pMasterIntercomNumber;
    return this;
}

/** Getter for {@link IntercomControlPdu#masterIntercomNumber}*/
public short getMasterIntercomNumber()
{
    return masterIntercomNumber; 
}

/** Setter for {@link IntercomControlPdu#masterChannelID}*/
public IntercomControlPdu setMasterChannelID(short pMasterChannelID)
{
    masterChannelID = pMasterChannelID;
    return this;
}

/** Getter for {@link IntercomControlPdu#masterChannelID}*/
public short getMasterChannelID()
{
    return masterChannelID; 
}

/** Setter for {@link IntercomControlPdu#intercomParameters}*/
public IntercomControlPdu setIntercomParameters(List<IntercomCommunicationsParameters> pIntercomParameters)
{
    intercomParameters = pIntercomParameters;
    return this;
}

/** Getter for {@link IntercomControlPdu#intercomParameters}*/
public List<IntercomCommunicationsParameters> getIntercomParameters()
{
    return intercomParameters; 
}

/**
 * Serializes an object to a DataOutputStream.
 * @throws java.lang.Exception if something goes wrong
 * @see java.io.DataOutputStream
 * @param dos the OutputStream
 */
public void marshal(DataOutputStream dos) throws Exception
{
    super.marshal(dos);
    try 
    {
       controlType.marshal(dos);
       dos.writeByte(communicationsChannelType);
       sourceEntityID.marshal(dos);
       dos.writeShort(sourceIntercomNumber);
       dos.writeByte(sourceLineID);
       dos.writeByte(transmitPriority);
       transmitLineState.marshal(dos);
       command.marshal(dos);
       masterIntercomReferenceID.marshal(dos);
       dos.writeShort(masterIntercomNumber);
       dos.writeShort(masterChannelID);
       dos.writeInt(intercomParameters.size());

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
 * Deserializes an object from a DataInputStream.
 * @throws java.lang.Exception if something goes wrong
 * @see java.io.DataInputStream
 * @param dis the InputStream
 * @return unmarshalled size
 */
public int unmarshal(DataInputStream dis) throws Exception
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
      System.err.println(e); 
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
        IntercomCommunicationsParameters aIntercomCommunicationsParameters = intercomParameters.get(idx);
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
  * Override of default equals method.  Calls equalsImpl() for content comparison.
  */
@Override
 public boolean equals(Object obj)
 {
    if(this == obj)
      return true;

    if(obj == null)
       return false;

    if(!getClass().isAssignableFrom(obj.getClass())) //if(getClass() != obj.getClass())
        return false;

    return equalsImpl(obj);
 }

@Override
 public boolean equalsImpl(Object obj)
 {
     boolean ivarsEqual = true;

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

     for(int idx = 0; idx < intercomParameters.size(); idx++)
        if( ! ( intercomParameters.get(idx).equals(rhs.intercomParameters.get(idx)))) ivarsEqual = false;

    return ivarsEqual && super.equalsImpl(rhs);
 }

 @Override
 public String toString()
 {
    StringBuilder sb = new StringBuilder();
    sb.append(getClass().getSimpleName()).append(":\n");

    sb.append(" controlType: ").append(controlType).append("\n");
    sb.append(" communicationsChannelType: ").append(communicationsChannelType).append("\n");
    sb.append(" sourceEntityID: ").append(sourceEntityID).append("\n");
    sb.append(" sourceIntercomNumber: ").append(sourceIntercomNumber).append("\n");
    sb.append(" sourceLineID: ").append(sourceLineID).append("\n");
    sb.append(" transmitPriority: ").append(transmitPriority).append("\n");
    sb.append(" transmitLineState: ").append(transmitLineState).append("\n");
    sb.append(" command: ").append(command).append("\n");
    sb.append(" masterIntercomReferenceID: ").append(masterIntercomReferenceID).append("\n");
    sb.append(" masterIntercomNumber: ").append(masterIntercomNumber).append("\n");
    sb.append(" masterChannelID: ").append(masterChannelID).append("\n");
    sb.append(" intercomParameters: ").append("\n");
    intercomParameters.forEach(r->{ sb.append(r.getClass().getSimpleName()).append(": ").append(r).append("\n");});

   return sb.toString();
 }
} // end of class
