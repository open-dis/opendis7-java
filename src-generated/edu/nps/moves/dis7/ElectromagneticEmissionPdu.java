/**
 * Copyright (c) 2008-2019, MOVES Institute, Naval Postgraduate School. All rights reserved.
 * This work is licensed under the BSD open source license, available at https://www.movesinstitute.org/licenses/bsd.html
 */

package edu.nps.moves.dis7;

import java.util.*;
import java.io.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * 7.6.2 Communicate active electromagnetic emissions, including radar and radar-related electronic warfare (e.g., jamming). Exceptions include IFF interrogations and replies, navigation aids, voice, beacon and data radio communications, directed energy weapons, and laser ranging and designation systems, which are handled by other PDUs. Section 5.3.7.1.
 * IEEE Std 1278.1-2012, IEEE Standard for Distributed Interactive Simulation—Application Protocols
 */
public class ElectromagneticEmissionPdu extends DistributedEmissionsFamilyPdu implements Serializable
{
   /** ID of the entity emitting */
   protected EntityID  emittingEntityID = new EntityID(); 

   /** ID of event */
   protected EventIdentifier  eventID = new EventIdentifier(); 

   /** This field shall be used to indicate if the data in the PDU represents a state update or just data that has changed since issuance of the last Electromagnetic Emission PDU [relative to the identified entity and emission system(s)]. uid 77 */
   protected ElectromagneticEmissionStateUpdateIndicator stateUpdateIndicator = ElectromagneticEmissionStateUpdateIndicator.values()[0];

   /** This field shall specify the number of emission systems being described in the current PDU. */
   protected byte  numberOfSystems;

   /** padding */
   protected short  paddingForEmissionsPdu;

   /** Electronic emmissions systems */
   protected List< ElectronicEmitter > systems = new ArrayList< ElectronicEmitter >();
 

/** Constructor */
 public ElectromagneticEmissionPdu()
 {
    setPduType( DISPDUType.ELECTROMAGNETIC_EMISSION );
    setPaddingForEmissionsPdu( (short)0 );
 }

/** Returns the size of this serialized object in bytes*/
public int getMarshalledSize()
{
   int marshalSize = 0; 

   marshalSize = super.getMarshalledSize();
   marshalSize += emittingEntityID.getMarshalledSize();
   marshalSize += eventID.getMarshalledSize();
   marshalSize += stateUpdateIndicator.getMarshalledSize();
   marshalSize += 1;  // numberOfSystems
   marshalSize += 2;  // paddingForEmissionsPdu
   for(int idx=0; idx < systems.size(); idx++)
   {
        ElectronicEmitter listElement = systems.get(idx);
        marshalSize += listElement.getMarshalledSize();
   }

   return marshalSize;
}


/** Setter for {@link ElectromagneticEmissionPdu#emittingEntityID}*/
public ElectromagneticEmissionPdu setEmittingEntityID(EntityID pEmittingEntityID)
{
    emittingEntityID = pEmittingEntityID;
    return this;
}

/** Getter for {@link ElectromagneticEmissionPdu#emittingEntityID}*/
public EntityID getEmittingEntityID()
{
    return emittingEntityID; 
}

/** Setter for {@link ElectromagneticEmissionPdu#eventID}*/
public ElectromagneticEmissionPdu setEventID(EventIdentifier pEventID)
{
    eventID = pEventID;
    return this;
}

/** Getter for {@link ElectromagneticEmissionPdu#eventID}*/
public EventIdentifier getEventID()
{
    return eventID; 
}

/** Setter for {@link ElectromagneticEmissionPdu#stateUpdateIndicator}*/
public ElectromagneticEmissionPdu setStateUpdateIndicator(ElectromagneticEmissionStateUpdateIndicator pStateUpdateIndicator)
{
    stateUpdateIndicator = pStateUpdateIndicator;
    return this;
}

/** Getter for {@link ElectromagneticEmissionPdu#stateUpdateIndicator}*/
public ElectromagneticEmissionStateUpdateIndicator getStateUpdateIndicator()
{
    return stateUpdateIndicator; 
}

/** Setter for {@link ElectromagneticEmissionPdu#paddingForEmissionsPdu}*/
public ElectromagneticEmissionPdu setPaddingForEmissionsPdu(short pPaddingForEmissionsPdu)
{
    paddingForEmissionsPdu = pPaddingForEmissionsPdu;
    return this;
}

/** Getter for {@link ElectromagneticEmissionPdu#paddingForEmissionsPdu}*/
public short getPaddingForEmissionsPdu()
{
    return paddingForEmissionsPdu; 
}

/** Setter for {@link ElectromagneticEmissionPdu#systems}*/
public ElectromagneticEmissionPdu setSystems(List<ElectronicEmitter> pSystems)
{
    systems = pSystems;
    return this;
}

/** Getter for {@link ElectromagneticEmissionPdu#systems}*/
public List<ElectronicEmitter> getSystems()
{
    return systems; 
}

/**
 * Serializes an object to a DataOutputStream.
 * @see java.io.DataOutputStream
 * @param dos The DataOutputStream
 */
public void marshal(DataOutputStream dos) throws Exception
{
    super.marshal(dos);
    try 
    {
       emittingEntityID.marshal(dos);
       eventID.marshal(dos);
       stateUpdateIndicator.marshal(dos);
       dos.writeByte( (byte)systems.size());
       dos.writeShort( (short)paddingForEmissionsPdu);

       for(int idx = 0; idx < systems.size(); idx++)
       {
            ElectronicEmitter aElectronicEmitter = systems.get(idx);
            aElectronicEmitter.marshal(dos);
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
public int unmarshal(DataInputStream dis) throws Exception
{
    int uPosition = 0;
    uPosition += super.unmarshal(dis);

    try 
    {
        uPosition += emittingEntityID.unmarshal(dis);
        uPosition += eventID.unmarshal(dis);
        stateUpdateIndicator = ElectromagneticEmissionStateUpdateIndicator.unmarshalEnum(dis);
        uPosition += stateUpdateIndicator.getMarshalledSize();
        numberOfSystems = (byte)dis.readUnsignedByte();
        uPosition += 1;
        paddingForEmissionsPdu = (short)dis.readUnsignedShort();
        uPosition += 2;
        for(int idx = 0; idx < numberOfSystems; idx++)
        {
            ElectronicEmitter anX = new ElectronicEmitter();
            uPosition += anX.unmarshal(dis);
            systems.add(anX);
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
   emittingEntityID.marshal(buff);
   eventID.marshal(buff);
   stateUpdateIndicator.marshal(buff);
   buff.put( (byte)systems.size());
   buff.putShort( (short)paddingForEmissionsPdu);

   for(int idx = 0; idx < systems.size(); idx++)
   {
        ElectronicEmitter aElectronicEmitter = (ElectronicEmitter)systems.get(idx);
        aElectronicEmitter.marshal(buff);
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

    emittingEntityID.unmarshal(buff);
    eventID.unmarshal(buff);
    stateUpdateIndicator = ElectromagneticEmissionStateUpdateIndicator.unmarshalEnum(buff);
    numberOfSystems = (byte)(buff.get() & 0xFF);
    paddingForEmissionsPdu = (short)(buff.getShort() & 0xFFFF);
    for(int idx = 0; idx < numberOfSystems; idx++)
    {
    ElectronicEmitter anX = new ElectronicEmitter();
    anX.unmarshal(buff);
    systems.add(anX);
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

     final ElectromagneticEmissionPdu rhs = (ElectromagneticEmissionPdu)obj;

     if( ! (emittingEntityID.equals( rhs.emittingEntityID) )) ivarsEqual = false;
     if( ! (eventID.equals( rhs.eventID) )) ivarsEqual = false;
     if( ! (stateUpdateIndicator == rhs.stateUpdateIndicator)) ivarsEqual = false;
     if( ! (paddingForEmissionsPdu == rhs.paddingForEmissionsPdu)) ivarsEqual = false;

     for(int idx = 0; idx < systems.size(); idx++)
        if( ! ( systems.get(idx).equals(rhs.systems.get(idx)))) ivarsEqual = false;

    return ivarsEqual && super.equalsImpl(rhs);
 }

 @Override
 public String toString()
 {
    StringBuilder sb = new StringBuilder();
    sb.append(getClass().getSimpleName()+":\n");

    sb.append(" emittingEntityID: ").append(emittingEntityID).append("\n");
    sb.append(" eventID: ").append(eventID).append("\n");
    sb.append(" stateUpdateIndicator: ").append(stateUpdateIndicator).append("\n");
    sb.append(" paddingForEmissionsPdu: ").append(paddingForEmissionsPdu).append("\n");
    sb.append(" systems: ").append("\n");
    systems.forEach(r->{ sb.append(r.getClass().getSimpleName()).append(": ").append(r).append("\n");});

   return sb.toString();
 }
} // end of class
