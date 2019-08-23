/**
 * Copyright (c) 2008-2019, MOVES Institute, Naval Postgraduate School. All rights reserved.
 * This work is licensed under the BSD open source license, available at https://www.movesinstitute.org/licenses/bsd.html
 */

package edu.nps.moves.dis7;

import java.util.*;
import java.io.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * 5.5.5 Communicate information associated with one entity requesting a service from another.
 * IEEE Std 1278.1-2012, IEEE Standard for Distributed Interactive Simulation—Application Protocols
 */
public class ServiceRequestPdu extends LogisticsFamilyPdu implements Serializable
{
   /** Entity that is requesting service (see 6.2.28), Section 7.4.2 */
   protected EntityID  requestingEntityID = new EntityID(); 

   /** Entity that is providing the service (see 6.2.28), Section 7.4.2 */
   protected EntityID  servicingEntityID = new EntityID(); 

   /** Type of service requested, Section 7.4.2 uid 63 */
   protected ServiceRequestServiceTypeRequested serviceTypeRequested = ServiceRequestServiceTypeRequested.values()[0];

   /** How many requested, Section 7.4.2 */
   protected byte  numberOfSupplyTypes;

   protected short  padding1 = (short)0;

   protected List< SupplyQuantity > supplies = new ArrayList< SupplyQuantity >();
 

/** Constructor */
 public ServiceRequestPdu()
 {
    setPduType( DISPDUType.SERVICE_REQUEST );
 }

/** Returns the size of this serialized object in bytes*/
public int getMarshalledSize()
{
   int marshalSize = 0; 

   marshalSize = super.getMarshalledSize();
   marshalSize += requestingEntityID.getMarshalledSize();
   marshalSize += servicingEntityID.getMarshalledSize();
   marshalSize += serviceTypeRequested.getMarshalledSize();
   marshalSize += 1;  // numberOfSupplyTypes
   marshalSize += 2;  // padding1
   for(int idx=0; idx < supplies.size(); idx++)
   {
        SupplyQuantity listElement = supplies.get(idx);
        marshalSize += listElement.getMarshalledSize();
   }

   return marshalSize;
}


/** Setter for {@link ServiceRequestPdu#requestingEntityID}*/
public ServiceRequestPdu setRequestingEntityID(EntityID pRequestingEntityID)
{
    requestingEntityID = pRequestingEntityID;
    return this;
}

/** Getter for {@link ServiceRequestPdu#requestingEntityID}*/
public EntityID getRequestingEntityID()
{
    return requestingEntityID; 
}

/** Setter for {@link ServiceRequestPdu#servicingEntityID}*/
public ServiceRequestPdu setServicingEntityID(EntityID pServicingEntityID)
{
    servicingEntityID = pServicingEntityID;
    return this;
}

/** Getter for {@link ServiceRequestPdu#servicingEntityID}*/
public EntityID getServicingEntityID()
{
    return servicingEntityID; 
}

/** Setter for {@link ServiceRequestPdu#serviceTypeRequested}*/
public ServiceRequestPdu setServiceTypeRequested(ServiceRequestServiceTypeRequested pServiceTypeRequested)
{
    serviceTypeRequested = pServiceTypeRequested;
    return this;
}

/** Getter for {@link ServiceRequestPdu#serviceTypeRequested}*/
public ServiceRequestServiceTypeRequested getServiceTypeRequested()
{
    return serviceTypeRequested; 
}

/** Setter for {@link ServiceRequestPdu#padding1}*/
public ServiceRequestPdu setPadding1(short pPadding1)
{
    padding1 = pPadding1;
    return this;
}

/** Getter for {@link ServiceRequestPdu#padding1}*/
public short getPadding1()
{
    return padding1; 
}

/** Setter for {@link ServiceRequestPdu#supplies}*/
public ServiceRequestPdu setSupplies(List<SupplyQuantity> pSupplies)
{
    supplies = pSupplies;
    return this;
}

/** Getter for {@link ServiceRequestPdu#supplies}*/
public List<SupplyQuantity> getSupplies()
{
    return supplies; 
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
       requestingEntityID.marshal(dos);
       servicingEntityID.marshal(dos);
       serviceTypeRequested.marshal(dos);
       dos.writeByte( (byte)supplies.size());
       dos.writeShort( (short)padding1);

       for(int idx = 0; idx < supplies.size(); idx++)
       {
            SupplyQuantity aSupplyQuantity = supplies.get(idx);
            aSupplyQuantity.marshal(dos);
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
        uPosition += requestingEntityID.unmarshal(dis);
        uPosition += servicingEntityID.unmarshal(dis);
        serviceTypeRequested = ServiceRequestServiceTypeRequested.unmarshalEnum(dis);
        uPosition += serviceTypeRequested.getMarshalledSize();
        numberOfSupplyTypes = (byte)dis.readUnsignedByte();
        uPosition += 1;
        padding1 = (short)dis.readUnsignedShort();
        uPosition += 2;
        for(int idx = 0; idx < numberOfSupplyTypes; idx++)
        {
            SupplyQuantity anX = new SupplyQuantity();
            uPosition += anX.unmarshal(dis);
            supplies.add(anX);
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
   requestingEntityID.marshal(buff);
   servicingEntityID.marshal(buff);
   serviceTypeRequested.marshal(buff);
   buff.put( (byte)supplies.size());
   buff.putShort( (short)padding1);

   for(int idx = 0; idx < supplies.size(); idx++)
   {
        SupplyQuantity aSupplyQuantity = (SupplyQuantity)supplies.get(idx);
        aSupplyQuantity.marshal(buff);
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

    requestingEntityID.unmarshal(buff);
    servicingEntityID.unmarshal(buff);
    serviceTypeRequested = ServiceRequestServiceTypeRequested.unmarshalEnum(buff);
    numberOfSupplyTypes = (byte)(buff.get() & 0xFF);
    padding1 = (short)(buff.getShort() & 0xFFFF);
    for(int idx = 0; idx < numberOfSupplyTypes; idx++)
    {
    SupplyQuantity anX = new SupplyQuantity();
    anX.unmarshal(buff);
    supplies.add(anX);
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

    if(getClass() != obj.getClass())
        return false;

    return equalsImpl(obj);
 }

@Override
 public boolean equalsImpl(Object obj)
 {
     boolean ivarsEqual = true;

     final ServiceRequestPdu rhs = (ServiceRequestPdu)obj;

     if( ! (requestingEntityID.equals( rhs.requestingEntityID) )) ivarsEqual = false;
     if( ! (servicingEntityID.equals( rhs.servicingEntityID) )) ivarsEqual = false;
     if( ! (serviceTypeRequested == rhs.serviceTypeRequested)) ivarsEqual = false;
     if( ! (padding1 == rhs.padding1)) ivarsEqual = false;

     for(int idx = 0; idx < supplies.size(); idx++)
        if( ! ( supplies.get(idx).equals(rhs.supplies.get(idx)))) ivarsEqual = false;

    return ivarsEqual && super.equalsImpl(rhs);
 }
} // end of class
