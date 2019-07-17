package edu.nps.moves.dis;

import java.util.*;
import java.io.*;
import edu.nps.moves.dis.enumerations.*;


/**
 */
public class SimulationManagementWithReliabilityFamilyPdu extends PduBase implements Serializable
{
   /** IDs the simulation or entity, either a simulation or an entity. Either 6.2.80 or 6.2.28 */
   protected SimulationIdentifier  originatingID = new SimulationIdentifier(); 

   /** simulation, all simulations, a special ID, or an entity. See 5.6.5 and 5.12.4 */
   protected SimulationIdentifier  receivingID = new SimulationIdentifier(); 


/** Constructor */
 public SimulationManagementWithReliabilityFamilyPdu()
 {
    setProtocolFamily( DISProtocolFamily.SIMULATION_MANAGEMENT_WITH_RELIABILITY );
 }

public int getMarshalledSize()
{
   int marshalSize = 0; 

   marshalSize = super.getMarshalledSize();
   marshalSize += originatingID.getMarshalledSize();
   marshalSize += receivingID.getMarshalledSize();

   return marshalSize;
}


public SimulationManagementWithReliabilityFamilyPdu setOriginatingID(SimulationIdentifier pOriginatingID)
{
    originatingID = pOriginatingID;
    return this;
}

public SimulationIdentifier getOriginatingID()
{
    return originatingID; 
}

public SimulationManagementWithReliabilityFamilyPdu setReceivingID(SimulationIdentifier pReceivingID)
{
    receivingID = pReceivingID;
    return this;
}

public SimulationIdentifier getReceivingID()
{
    return receivingID; 
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
       originatingID.marshal(dos);
       receivingID.marshal(dos);
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
 */
public int unmarshal(DataInputStream dis)
{
    int uPosition = 0;
    uPosition += super.unmarshal(dis);

    try 
    {
        uPosition += originatingID.unmarshal(dis);
        uPosition += receivingID.unmarshal(dis);
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
 */
public void marshal(java.nio.ByteBuffer buff) throws Exception
{
   super.marshal(buff);
   originatingID.marshal(buff);
   receivingID.marshal(buff);
}

/**
 * Unpacks a Pdu from the underlying data.
 * @throws java.nio.BufferUnderflowException if buff is too small
 * @see java.nio.ByteBuffer
 * @param buff The ByteBuffer at the position to begin reading
 */
public int unmarshal(java.nio.ByteBuffer buff) throws Exception
{
    super.unmarshal(buff);

    originatingID.unmarshal(buff);
    receivingID.unmarshal(buff);
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

    if(!(obj instanceof SimulationManagementWithReliabilityFamilyPdu))
        return false;

     final SimulationManagementWithReliabilityFamilyPdu rhs = (SimulationManagementWithReliabilityFamilyPdu)obj;

     if( ! (originatingID.equals( rhs.originatingID) )) ivarsEqual = false;
     if( ! (receivingID.equals( rhs.receivingID) )) ivarsEqual = false;
    return ivarsEqual && super.equalsImpl(rhs);
 }
} // end of class
