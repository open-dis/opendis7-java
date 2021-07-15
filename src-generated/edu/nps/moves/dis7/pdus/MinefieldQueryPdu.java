/**
 * Copyright (c) 2008-2021, MOVES Institute, Naval Postgraduate School (NPS). All rights reserved.
 * This work is provided under a BSD open-source license, see project license.html and license.txt
 */

package edu.nps.moves.dis7.pdus;

import java.util.*;
import java.io.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * 5.10.3 Contains information about the requesting entity and the region and mine types of interest to the requesting entity.
 * IEEE Std 1278.1-2012, IEEE Standard for Distributed Interactive Simulation - Application Protocols
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

   /** padding is an undescribed parameter... */
   protected byte  padding;

   /** Number of sensor types */
   protected byte  numberOfSensorTypes;

   /** data filter, 32 boolean fields */
   protected DataFilterRecord  dataFilter = new DataFilterRecord(); 

   /** Entity type of mine being requested */
   protected EntityType  requestedMineType = new EntityType(); 

   /** perimeter points of request */
   protected List< Vector2Float > requestedPerimeterPoints = new ArrayList< Vector2Float >();
 
   /** Sensor types, each 16-bits long */
   protected List< MinefieldSensorType > sensorTypes = new ArrayList< MinefieldSensorType >();
 

/** Constructor */
 public MinefieldQueryPdu()
 {
    setPduType( DISPDUType.MINEFIELD_QUERY );
 }

  /**
   * Returns size of this serialized (marshalled) object in bytes
   * @see <a href="https://en.wikipedia.org/wiki/Marshalling_(computer_science)" target="_blank">https://en.wikipedia.org/wiki/Marshalling_(computer_science)</a>
   * @return serialized size in bytes
   */
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


/** Setter for {@link MinefieldQueryPdu#minefieldID}
  * @param pMinefieldID new value of interest
  * @return same object to permit progressive setters */
public MinefieldQueryPdu setMinefieldID(MinefieldIdentifier pMinefieldID)
{
    minefieldID = pMinefieldID;
    return this;
}

/** Getter for {@link MinefieldQueryPdu#minefieldID}
  * @return value of interest */
public MinefieldIdentifier getMinefieldID()
{
    return minefieldID; 
}

/** Setter for {@link MinefieldQueryPdu#requestingEntityID}
  * @param pRequestingEntityID new value of interest
  * @return same object to permit progressive setters */
public MinefieldQueryPdu setRequestingEntityID(EntityID pRequestingEntityID)
{
    requestingEntityID = pRequestingEntityID;
    return this;
}

/** Getter for {@link MinefieldQueryPdu#requestingEntityID}
  * @return value of interest */
public EntityID getRequestingEntityID()
{
    return requestingEntityID; 
}

/** Setter for {@link MinefieldQueryPdu#requestID}
  * @param pRequestID new value of interest
  * @return same object to permit progressive setters */
public MinefieldQueryPdu setRequestID(byte pRequestID)
{
    requestID = pRequestID;
    return this;
}
/** Utility setter for {@link MinefieldQueryPdu#requestID}
  * @param pRequestID new value of interest
  * @return same object to permit progressive setters */
public MinefieldQueryPdu setRequestID(int pRequestID){
    requestID = (byte) pRequestID;
    return this;
}

/** Getter for {@link MinefieldQueryPdu#requestID}
  * @return value of interest */
public byte getRequestID()
{
    return requestID; 
}

/** Setter for {@link MinefieldQueryPdu#padding}
  * @param pPadding new value of interest
  * @return same object to permit progressive setters */
public MinefieldQueryPdu setPadding(byte pPadding)
{
    padding = pPadding;
    return this;
}
/** Utility setter for {@link MinefieldQueryPdu#padding}
  * @param pPadding new value of interest
  * @return same object to permit progressive setters */
public MinefieldQueryPdu setPadding(int pPadding){
    padding = (byte) pPadding;
    return this;
}

/** Getter for {@link MinefieldQueryPdu#padding}
  * @return value of interest */
public byte getPadding()
{
    return padding; 
}

/** Setter for {@link MinefieldQueryPdu#dataFilter}
  * @param pDataFilter new value of interest
  * @return same object to permit progressive setters */
public MinefieldQueryPdu setDataFilter(DataFilterRecord pDataFilter)
{
    dataFilter = pDataFilter;
    return this;
}

/** Getter for {@link MinefieldQueryPdu#dataFilter}
  * @return value of interest */
public DataFilterRecord getDataFilter()
{
    return dataFilter; 
}

/** Setter for {@link MinefieldQueryPdu#requestedMineType}
  * @param pRequestedMineType new value of interest
  * @return same object to permit progressive setters */
public MinefieldQueryPdu setRequestedMineType(EntityType pRequestedMineType)
{
    requestedMineType = pRequestedMineType;
    return this;
}

/** Getter for {@link MinefieldQueryPdu#requestedMineType}
  * @return value of interest */
public EntityType getRequestedMineType()
{
    return requestedMineType; 
}

/** Setter for {@link MinefieldQueryPdu#requestedPerimeterPoints}
  * @param pRequestedPerimeterPoints new value of interest
  * @return same object to permit progressive setters */
public MinefieldQueryPdu setRequestedPerimeterPoints(List<Vector2Float> pRequestedPerimeterPoints)
{
    requestedPerimeterPoints = pRequestedPerimeterPoints;
    return this;
}

/** Getter for {@link MinefieldQueryPdu#requestedPerimeterPoints}
  * @return value of interest */
public List<Vector2Float> getRequestedPerimeterPoints()
{
    return requestedPerimeterPoints; 
}

/** Setter for {@link MinefieldQueryPdu#sensorTypes}
  * @param pSensorTypes new value of interest
  * @return same object to permit progressive setters */
public MinefieldQueryPdu setSensorTypes(List<MinefieldSensorType> pSensorTypes)
{
    sensorTypes = pSensorTypes;
    return this;
}

/** Getter for {@link MinefieldQueryPdu#sensorTypes}
  * @return value of interest */
public List<MinefieldSensorType> getSensorTypes()
{
    return sensorTypes; 
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
       minefieldID.marshal(dos);
       requestingEntityID.marshal(dos);
       dos.writeByte(requestID);
       dos.writeByte(requestedPerimeterPoints.size());
       dos.writeByte(padding);
       dos.writeByte(sensorTypes.size());
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
 * Deserializes an object from a DataInputStream.
 * @throws java.lang.Exception if something goes wrong
 * @see java.io.DataInputStream
 * @see <a href="https://en.wikipedia.org/wiki/Marshalling_(computer_science)" target="_blank">https://en.wikipedia.org/wiki/Marshalling_(computer_science)</a>
 * @param dis the InputStream
 * @return marshalled serialized size in bytes
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
      System.err.println(e); 
    }
    return getMarshalledSize();
}

/**
 * Packs an object into the ByteBuffer.
 * @throws java.nio.BufferOverflowException if byteBuffer is too small
 * @throws java.nio.ReadOnlyBufferException if byteBuffer is read only
 * @see java.nio.ByteBuffer
 * @param byteBuffer The ByteBuffer at the position to begin writing
 * @throws Exception ByteBuffer-generated exception
 */
public void marshal(java.nio.ByteBuffer byteBuffer) throws Exception
{
   super.marshal(byteBuffer);
   minefieldID.marshal(byteBuffer);
   requestingEntityID.marshal(byteBuffer);
   byteBuffer.put( (byte)requestID);
   byteBuffer.put( (byte)requestedPerimeterPoints.size());
   byteBuffer.put( (byte)padding);
   byteBuffer.put( (byte)sensorTypes.size());
   dataFilter.marshal(byteBuffer);
   requestedMineType.marshal(byteBuffer);

   for(int idx = 0; idx < requestedPerimeterPoints.size(); idx++)
   {
        Vector2Float aVector2Float = requestedPerimeterPoints.get(idx);
        aVector2Float.marshal(byteBuffer);
   }


   for(int idx = 0; idx < sensorTypes.size(); idx++)
   {
        MinefieldSensorType aMinefieldSensorType = sensorTypes.get(idx);
        aMinefieldSensorType.marshal(byteBuffer);
   }

}

/**
 * Unpacks a Pdu from the underlying data.
 * @throws java.nio.BufferUnderflowException if byteBuffer is too small
 * @see java.nio.ByteBuffer
 * @see <a href="https://en.wikipedia.org/wiki/Marshalling_(computer_science)" target="_blank">https://en.wikipedia.org/wiki/Marshalling_(computer_science)</a>
 * @param byteBuffer The ByteBuffer at the position to begin reading
 * @return marshalled serialized size in bytes
 * @throws Exception ByteBuffer-generated exception
 */
public int unmarshal(java.nio.ByteBuffer byteBuffer) throws Exception
{
    super.unmarshal(byteBuffer);

    minefieldID.unmarshal(byteBuffer);
    requestingEntityID.unmarshal(byteBuffer);
    requestID = (byte)(byteBuffer.get() & 0xFF);
    numberOfPerimeterPoints = (byte)(byteBuffer.get() & 0xFF);
    padding = (byte)(byteBuffer.get() & 0xFF);
    numberOfSensorTypes = (byte)(byteBuffer.get() & 0xFF);
    dataFilter.unmarshal(byteBuffer);
    requestedMineType.unmarshal(byteBuffer);
    for(int idx = 0; idx < numberOfPerimeterPoints; idx++)
    {
    Vector2Float anX = new Vector2Float();
    anX.unmarshal(byteBuffer);
    requestedPerimeterPoints.add(anX);
    }

    for(int idx = 0; idx < numberOfSensorTypes; idx++)
    {
    MinefieldSensorType anX = new MinefieldSensorType();
    anX.unmarshal(byteBuffer);
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
    sb.append(getClass().getSimpleName()).append(":\n");

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
