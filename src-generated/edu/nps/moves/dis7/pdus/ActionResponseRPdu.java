/**
 * Copyright (c) 2008-2020, MOVES Institute, Naval Postgraduate School (NPS). All rights reserved.
 * This work is provided under a BSD open-source license, see project license.html and license.txt
 */

package edu.nps.moves.dis7.pdus;

import java.util.*;
import java.io.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * 5.12.4.8 Serves the same function as the Action Response PDU (see 5.6.5.8.1) but is used to acknowledge the receipt of an Action Request-R PDU.
 * IEEE Std 1278.1-2012, IEEE Standard for Distributed Interactive Simulation - Application Protocols
 */
public class ActionResponseRPdu extends SimulationManagementWithReliabilityFamilyPdu implements Serializable
{
   /** request ID */
   protected int  requestID;

   /** status of response uid 72 */
   protected ActionResponseRequestStatus responseStatus = ActionResponseRequestStatus.values()[0];

   /** Fixed datum record count */
   protected int  numberOfFixedDatumRecords;

   /** variable datum record count */
   protected int  numberOfVariableDatumRecords;

   /** Fixed datum records */
   protected List< FixedDatum > fixedDatumRecords = new ArrayList< FixedDatum >();
 
   /** Variable datum records */
   protected List< VariableDatum > variableDatumRecords = new ArrayList< VariableDatum >();
 

/** Constructor */
 public ActionResponseRPdu()
 {
    setPduType( DISPDUType.ACTION_RESPONSE_RELIABLE );
 }

  /**
   * Returns size of this serialized (marshalled) object in bytes
   * See <a href="https://en.wikipedia.org/wiki/Marshalling_(computer_science)" target="_blank">https://en.wikipedia.org/wiki/Marshalling_(computer_science)</a>
   * @return serialized size in bytes
   */
public int getMarshalledSize()
{
   int marshalSize = 0; 

   marshalSize = super.getMarshalledSize();
   marshalSize += 4;  // requestID
   marshalSize += responseStatus.getMarshalledSize();
   marshalSize += 4;  // numberOfFixedDatumRecords
   marshalSize += 4;  // numberOfVariableDatumRecords
   for(int idx=0; idx < fixedDatumRecords.size(); idx++)
   {
        FixedDatum listElement = fixedDatumRecords.get(idx);
        marshalSize += listElement.getMarshalledSize();
   }
   for(int idx=0; idx < variableDatumRecords.size(); idx++)
   {
        VariableDatum listElement = variableDatumRecords.get(idx);
        marshalSize += listElement.getMarshalledSize();
   }

   return marshalSize;
}


/** Setter for {@link ActionResponseRPdu#requestID}
  * @param pRequestID new value of interest
  * @return same object to permit progressive setters */
public ActionResponseRPdu setRequestID(int pRequestID)
{
    requestID = pRequestID;
    return this;
}

/** Getter for {@link ActionResponseRPdu#requestID}
  * @return value of interest */
public int getRequestID()
{
    return requestID; 
}

/** Setter for {@link ActionResponseRPdu#responseStatus}
  * @param pResponseStatus new value of interest
  * @return same object to permit progressive setters */
public ActionResponseRPdu setResponseStatus(ActionResponseRequestStatus pResponseStatus)
{
    responseStatus = pResponseStatus;
    return this;
}

/** Getter for {@link ActionResponseRPdu#responseStatus}
  * @return value of interest */
public ActionResponseRequestStatus getResponseStatus()
{
    return responseStatus; 
}

/** Setter for {@link ActionResponseRPdu#fixedDatumRecords}
  * @param pFixedDatumRecords new value of interest
  * @return same object to permit progressive setters */
public ActionResponseRPdu setFixedDatumRecords(List<FixedDatum> pFixedDatumRecords)
{
    fixedDatumRecords = pFixedDatumRecords;
    return this;
}

/** Getter for {@link ActionResponseRPdu#fixedDatumRecords}
  * @return value of interest */
public List<FixedDatum> getFixedDatumRecords()
{
    return fixedDatumRecords; 
}

/** Setter for {@link ActionResponseRPdu#variableDatumRecords}
  * @param pVariableDatumRecords new value of interest
  * @return same object to permit progressive setters */
public ActionResponseRPdu setVariableDatumRecords(List<VariableDatum> pVariableDatumRecords)
{
    variableDatumRecords = pVariableDatumRecords;
    return this;
}

/** Getter for {@link ActionResponseRPdu#variableDatumRecords}
  * @return value of interest */
public List<VariableDatum> getVariableDatumRecords()
{
    return variableDatumRecords; 
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
       dos.writeInt(requestID);
       responseStatus.marshal(dos);
       dos.writeInt(fixedDatumRecords.size());
       dos.writeInt(variableDatumRecords.size());

       for(int idx = 0; idx < fixedDatumRecords.size(); idx++)
       {
            FixedDatum aFixedDatum = fixedDatumRecords.get(idx);
            aFixedDatum.marshal(dos);
       }


       for(int idx = 0; idx < variableDatumRecords.size(); idx++)
       {
            VariableDatum aVariableDatum = variableDatumRecords.get(idx);
            aVariableDatum.marshal(dos);
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
 * See <a href="https://en.wikipedia.org/wiki/Marshalling_(computer_science)" target="_blank">https://en.wikipedia.org/wiki/Marshalling_(computer_science)</a>
 * @param dis the InputStream
 * @return marshalled serialized size in bytes
 */
public int unmarshal(DataInputStream dis) throws Exception
{
    int uPosition = 0;
    uPosition += super.unmarshal(dis);

    try 
    {
        requestID = dis.readInt();
        uPosition += 4;
        responseStatus = ActionResponseRequestStatus.unmarshalEnum(dis);
        uPosition += responseStatus.getMarshalledSize();
        numberOfFixedDatumRecords = dis.readInt();
        uPosition += 4;
        numberOfVariableDatumRecords = dis.readInt();
        uPosition += 4;
        for(int idx = 0; idx < numberOfFixedDatumRecords; idx++)
        {
            FixedDatum anX = new FixedDatum();
            uPosition += anX.unmarshal(dis);
            fixedDatumRecords.add(anX);
        }

        for(int idx = 0; idx < numberOfVariableDatumRecords; idx++)
        {
            VariableDatum anX = new VariableDatum();
            uPosition += anX.unmarshal(dis);
            variableDatumRecords.add(anX);
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
   byteBuffer.putInt( (int)requestID);
   responseStatus.marshal(byteBuffer);
   byteBuffer.putInt( (int)fixedDatumRecords.size());
   byteBuffer.putInt( (int)variableDatumRecords.size());

   for(int idx = 0; idx < fixedDatumRecords.size(); idx++)
   {
        FixedDatum aFixedDatum = fixedDatumRecords.get(idx);
        aFixedDatum.marshal(byteBuffer);
   }


   for(int idx = 0; idx < variableDatumRecords.size(); idx++)
   {
        VariableDatum aVariableDatum = variableDatumRecords.get(idx);
        aVariableDatum.marshal(byteBuffer);
   }

}

/**
 * Unpacks a Pdu from the underlying data.
 * @throws java.nio.BufferUnderflowException if byteBuffer is too small
 * @see java.nio.ByteBuffer
 * See <a href="https://en.wikipedia.org/wiki/Marshalling_(computer_science)" target="_blank">https://en.wikipedia.org/wiki/Marshalling_(computer_science)</a>
 * @param byteBuffer The ByteBuffer at the position to begin reading
 * @return marshalled serialized size in bytes
 * @throws Exception ByteBuffer-generated exception
 */
public int unmarshal(java.nio.ByteBuffer byteBuffer) throws Exception
{
    super.unmarshal(byteBuffer);

    requestID = byteBuffer.getInt();
    responseStatus = ActionResponseRequestStatus.unmarshalEnum(byteBuffer);
    numberOfFixedDatumRecords = byteBuffer.getInt();
    numberOfVariableDatumRecords = byteBuffer.getInt();
    for(int idx = 0; idx < numberOfFixedDatumRecords; idx++)
    {
    FixedDatum anX = new FixedDatum();
    anX.unmarshal(byteBuffer);
    fixedDatumRecords.add(anX);
    }

    for(int idx = 0; idx < numberOfVariableDatumRecords; idx++)
    {
    VariableDatum anX = new VariableDatum();
    anX.unmarshal(byteBuffer);
    variableDatumRecords.add(anX);
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

     final ActionResponseRPdu rhs = (ActionResponseRPdu)obj;

     if( ! (requestID == rhs.requestID)) ivarsEqual = false;
     if( ! (responseStatus == rhs.responseStatus)) ivarsEqual = false;

     for(int idx = 0; idx < fixedDatumRecords.size(); idx++)
        if( ! ( fixedDatumRecords.get(idx).equals(rhs.fixedDatumRecords.get(idx)))) ivarsEqual = false;


     for(int idx = 0; idx < variableDatumRecords.size(); idx++)
        if( ! ( variableDatumRecords.get(idx).equals(rhs.variableDatumRecords.get(idx)))) ivarsEqual = false;

    return ivarsEqual && super.equalsImpl(rhs);
 }

 @Override
 public String toString()
 {
    StringBuilder sb = new StringBuilder();
    sb.append(getClass().getSimpleName()).append(":\n");

    sb.append(" requestID: ").append(requestID).append("\n");
    sb.append(" responseStatus: ").append(responseStatus).append("\n");
    sb.append(" fixedDatumRecords: ").append("\n");
    fixedDatumRecords.forEach(r->{ sb.append(r.getClass().getSimpleName()).append(": ").append(r).append("\n");});
    sb.append(" variableDatumRecords: ").append("\n");
    variableDatumRecords.forEach(r->{ sb.append(r.getClass().getSimpleName()).append(": ").append(r).append("\n");});

   return sb.toString();
 }
} // end of class
