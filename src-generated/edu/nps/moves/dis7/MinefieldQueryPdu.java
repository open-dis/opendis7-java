/**
 * Copyright (c) 2008-2019, MOVES Institute, Naval Postgraduate School. All rights reserved.
 * This work is licensed under the BSD open source license, available at https://www.movesinstitute.org/licenses/bsd.html
 */

package edu.nps.moves.dis7;

import java.util.*;
import java.io.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * 5.10.3 Contains information about the requesting entity and the region and mine types of interest to the requesting entity.
 * IEEE Std 1278.1-2012, IEEE Standard for Distributed Interactive Simulation—Application Protocols
 */
public class MinefieldQueryPdu extends MinefieldFamilyPdu implements Serializable
{
   /** Minefield ID */
   protected MinefieldIdentifier  minefieldID = new MinefieldIdentifier(); 

   /** EID of entity making the request */
   protected EntityID  requestingEntityID = new EntityID(); 

   /** request ID */
   protected byte  requestID;

   /** Number of perimeter points for the minefield */
   protected byte  numberOfPerimeterPoints;

   protected byte  padding;

   /** Number of sensor types */
   protected byte  numberOfSensorTypes;

   /** data filter, 32 boolean fields */
   protected DataFilterRecord  dataFilter = new DataFilterRecord(); 

   /** Entity type of mine being requested */
   protected EntityType  requestedMineType = new EntityType(); 

   /** perimeter points of request */
   protected List< Vector2Float > requestedPerimeterPoints = new ArrayList< Vector2Float >();
 
   /** Sensor types, each 16 bits long */
   protected List< MinefieldSensorType > sensorTypes = new ArrayList< MinefieldSensorType >();
 

/** Constructor */
 public MinefieldQueryPdu()
 {
    setPduType( DISPDUType.MINEFIELD_QUERY );
 }

/** Returns the size of this serialized object in bytes*/
public int getMarshalledSize()
{
   int marshalSize = 0; 

   marshalSize = super.getMarshalledSize();
   marshalSize += minefieldID.getMarshalledSize();
   marshalSize += requestingEntityID.getMarshalledSize();
   marshalSize += 1;  // requestID
   marshalSize += 1;  // numberOfPerimeterPoints
   marshalSize += 1;  // padding
   marshalSize += 1;  // numberOfSensorTypes
   marshalSize += dataFilter.getMarshalledSize();
   marshalSize += requestedMineType.getMarshalledSize();
   for(int idx=0; idx < requestedPerimeterPoints.size(); idx++)
   {
        Vector2Float listElement = requestedPerimeterPoints.get(idx);
        marshalSize += listElement.getMarshalledSize();
   }
   for(int idx=0; idx < sensorTypes.size(); idx++)
   {
        MinefieldSensorType listElement = sensorTypes.get(idx);
        marshalSize += listElement.getMarshalledSize();
   }

   return marshalSize;
}


/** Setter for {@link MinefieldQueryPdu#minefieldID}*/
public MinefieldQueryPdu setMinefieldID(MinefieldIdentifier pMinefieldID)
{
    minefieldID = pMinefieldID;
    return this;
}

/** Getter for {@link MinefieldQueryPdu#minefieldID}*/
public MinefieldIdentifier getMinefieldID()
{
    return minefieldID; 
}

/** Setter for {@link MinefieldQueryPdu#requestingEntityID}*/
public MinefieldQueryPdu setRequestingEntityID(EntityID pRequestingEntityID)
{
    requestingEntityID = pRequestingEntityID;
    return this;
}

/** Getter for {@link MinefieldQueryPdu#requestingEntityID}*/
public EntityID getRequestingEntityID()
{
    return requestingEntityID; 
}

/** Setter for {@link MinefieldQueryPdu#requestID}*/
public MinefieldQueryPdu setRequestID(byte pRequestID)
{
    requestID = pRequestID;
    return this;
}

/** Getter for {@link MinefieldQueryPdu#requestID}*/
public byte getRequestID()
{
    return requestID; 
}

/** Setter for {@link MinefieldQueryPdu#padding}*/
public MinefieldQueryPdu setPadding(byte pPadding)
{
    padding = pPadding;
    return this;
}

/** Getter for {@link MinefieldQueryPdu#padding}*/
public byte getPadding()
{
    return padding; 
}

/** Setter for {@link MinefieldQueryPdu#dataFilter}*/
public MinefieldQueryPdu setDataFilter(DataFilterRecord pDataFilter)
{
    dataFilter = pDataFilter;
    return this;
}

/** Getter for {@link MinefieldQueryPdu#dataFilter}*/
public DataFilterRecord getDataFilter()
{
    return dataFilter; 
}

/** Setter for {@link MinefieldQueryPdu#requestedMineType}*/
public MinefieldQueryPdu setRequestedMineType(EntityType pRequestedMineType)
{
    requestedMineType = pRequestedMineType;
    return this;
}

/** Getter for {@link MinefieldQueryPdu#requestedMineType}*/
public EntityType getRequestedMineType()
{
    return requestedMineType; 
}

/** Setter for {@link MinefieldQueryPdu#requestedPerimeterPoints}*/
public MinefieldQueryPdu setRequestedPerimeterPoints(List<Vector2Float> pRequestedPerimeterPoints)
{
    requestedPerimeterPoints = pRequestedPerimeterPoints;
    return this;
}

/** Getter for {@link MinefieldQueryPdu#requestedPerimeterPoints}*/
public List<Vector2Float> getRequestedPerimeterPoints()
{
    return requestedPerimeterPoints; 
}

/** Setter for {@link MinefieldQueryPdu#sensorTypes}*/
public MinefieldQueryPdu setSensorTypes(List<MinefieldSensorType> pSensorTypes)
{
    sensorTypes = pSensorTypes;
    return this;
}

/** Getter for {@link MinefieldQueryPdu#sensorTypes}*/
public List<MinefieldSensorType> getSensorTypes()
{
    return sensorTypes; 
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
       minefieldID.marshal(dos);
       requestingEntityID.marshal(dos);
       dos.writeByte( (byte)requestID);
       dos.writeByte( (byte)requestedPerimeterPoints.size());
       dos.writeByte( (byte)padding);
       dos.writeByte( (byte)sensorTypes.size());
       dataFilter.marshal(dos);
       requestedMineType.marshal(dos);

       for(int idx = 0; idx < requestedPerimeterPoints.size(); idx++)
       {
            Vector2Float aVector2Float = requestedPerimeterPoints.get(idx);
            aVector2Float.marshal(dos);
       }


       for(int idx = 0; idx < sensorTypes.size(); idx++)
       {
            MinefieldSensorType aMinefieldSensorType = sensorTypes.get(idx);
            aMinefieldSensorType.marshal(dos);
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
        uPosition += minefieldID.unmarshal(dis);
        uPosition += requestingEntityID.unmarshal(dis);
        requestID = (byte)dis.readUnsignedByte();
        uPosition += 1;
        numberOfPerimeterPoints = (byte)dis.readUnsignedByte();
        uPosition += 1;
        padding = (byte)dis.readUnsignedByte();
        uPosition += 1;
        numberOfSensorTypes = (byte)dis.readUnsignedByte();
        uPosition += 1;
        uPosition += dataFilter.unmarshal(dis);
        uPosition += requestedMineType.unmarshal(dis);
        for(int idx = 0; idx < numberOfPerimeterPoints; idx++)
        {
            Vector2Float anX = new Vector2Float();
            uPosition += anX.unmarshal(dis);
            requestedPerimeterPoints.add(anX);
        }

        for(int idx = 0; idx < numberOfSensorTypes; idx++)
        {
            MinefieldSensorType anX = new MinefieldSensorType();
            uPosition += anX.unmarshal(dis);
            sensorTypes.add(anX);
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
   minefieldID.marshal(buff);
   requestingEntityID.marshal(buff);
   buff.put( (byte)requestID);
   buff.put( (byte)requestedPerimeterPoints.size());
   buff.put( (byte)padding);
   buff.put( (byte)sensorTypes.size());
   dataFilter.marshal(buff);
   requestedMineType.marshal(buff);

   for(int idx = 0; idx < requestedPerimeterPoints.size(); idx++)
   {
        Vector2Float aVector2Float = (Vector2Float)requestedPerimeterPoints.get(idx);
        aVector2Float.marshal(buff);
   }


   for(int idx = 0; idx < sensorTypes.size(); idx++)
   {
        MinefieldSensorType aMinefieldSensorType = (MinefieldSensorType)sensorTypes.get(idx);
        aMinefieldSensorType.marshal(buff);
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

    minefieldID.unmarshal(buff);
    requestingEntityID.unmarshal(buff);
    requestID = (byte)(buff.get() & 0xFF);
    numberOfPerimeterPoints = (byte)(buff.get() & 0xFF);
    padding = (byte)(buff.get() & 0xFF);
    numberOfSensorTypes = (byte)(buff.get() & 0xFF);
    dataFilter.unmarshal(buff);
    requestedMineType.unmarshal(buff);
    for(int idx = 0; idx < numberOfPerimeterPoints; idx++)
    {
    Vector2Float anX = new Vector2Float();
    anX.unmarshal(buff);
    requestedPerimeterPoints.add(anX);
    }

    for(int idx = 0; idx < numberOfSensorTypes; idx++)
    {
    MinefieldSensorType anX = new MinefieldSensorType();
    anX.unmarshal(buff);
    sensorTypes.add(anX);
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

     final MinefieldQueryPdu rhs = (MinefieldQueryPdu)obj;

     if( ! (minefieldID.equals( rhs.minefieldID) )) ivarsEqual = false;
     if( ! (requestingEntityID.equals( rhs.requestingEntityID) )) ivarsEqual = false;
     if( ! (requestID == rhs.requestID)) ivarsEqual = false;
     if( ! (padding == rhs.padding)) ivarsEqual = false;
     if( ! (dataFilter.equals( rhs.dataFilter) )) ivarsEqual = false;
     if( ! (requestedMineType.equals( rhs.requestedMineType) )) ivarsEqual = false;

     for(int idx = 0; idx < requestedPerimeterPoints.size(); idx++)
        if( ! ( requestedPerimeterPoints.get(idx).equals(rhs.requestedPerimeterPoints.get(idx)))) ivarsEqual = false;


     for(int idx = 0; idx < sensorTypes.size(); idx++)
        if( ! ( sensorTypes.get(idx).equals(rhs.sensorTypes.get(idx)))) ivarsEqual = false;

    return ivarsEqual && super.equalsImpl(rhs);
 }

 @Override
 public String toString()
 {
    StringBuilder sb = new StringBuilder();
    sb.append(getClass().getSimpleName()+":\n");

    sb.append(" minefieldID: ").append(minefieldID).append("\n");
    sb.append(" requestingEntityID: ").append(requestingEntityID).append("\n");
    sb.append(" requestID: ").append(requestID).append("\n");
    sb.append(" padding: ").append(padding).append("\n");
    sb.append(" dataFilter: ").append(dataFilter).append("\n");
    sb.append(" requestedMineType: ").append(requestedMineType).append("\n");
    sb.append(" requestedPerimeterPoints: ").append("\n");
    requestedPerimeterPoints.forEach(r->{ sb.append(r.getClass().getSimpleName()).append(": ").append(r).append("\n");});
    sb.append(" sensorTypes: ").append("\n");
    sensorTypes.forEach(r->{ sb.append(r.getClass().getSimpleName()).append(": ").append(r).append("\n");});

   return sb.toString();
 }
} // end of class
