/**
 * Copyright (c) 2008-2020, MOVES Institute, Naval Postgraduate School (NPS). All rights reserved.
 * This work is provided under a BSD open-source license, see project license.html and license.txt
 */

package edu.nps.moves.dis7.pdus;

import java.util.*;
import java.io.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 *  7.5.7 A request from an SM to a managed entity to perform a specified action. See 5.6.5.7
 * IEEE Std 1278.1-2012, IEEE Standard for Distributed Interactive Simulation - Application Protocols
 */
public class ActionRequestPdu extends SimulationManagementFamilyPdu implements Serializable
{
   /** identifies the request being made by the simulation manager */
   protected int  requestID;

   /** identifies the particular action being requested(see Section 7 of SISO-REF-010). uid 71 */
   protected ActionRequestActionID actionID = ActionRequestActionID.values()[0];

   /** Number of fixed datum records */
   protected int  numberOfFixedDatumRecords;

   /** Number of variable datum records, handled automatically by marshaller at run time (and not modifiable by end-user programmers) */
   protected int  numberOfVariableDatumRecords;

   /** variable length list of fixed datums */
   protected List< FixedDatum > fixedDatums = new ArrayList< FixedDatum >();
 
   /** variable length list of variable length datums */
   protected List< VariableDatum > variableDatums = new ArrayList< VariableDatum >();
 

/** Constructor */
 public ActionRequestPdu()
 {
    setPduType( DISPDUType.ACTION_REQUEST );
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
   marshalSize += actionID.getMarshalledSize();
   marshalSize += 4;  // numberOfFixedDatumRecords
   marshalSize += 4;  // numberOfVariableDatumRecords
   for(int idx=0; idx < fixedDatums.size(); idx++)
   {
        FixedDatum listElement = fixedDatums.get(idx);
        marshalSize += listElement.getMarshalledSize();
   }
   for(int idx=0; idx < variableDatums.size(); idx++)
   {
        VariableDatum listElement = variableDatums.get(idx);
        marshalSize += listElement.getMarshalledSize();
   }

   return marshalSize;
}


/** Setter for {@link ActionRequestPdu#requestID}
  * @param pRequestID new value of interest
  * @return same object to permit progressive setters */
public ActionRequestPdu setRequestID(int pRequestID)
{
    requestID = pRequestID;
    return this;
}

/** Getter for {@link ActionRequestPdu#requestID}
  * @return value of interest */
public int getRequestID()
{
    return requestID; 
}

/** Setter for {@link ActionRequestPdu#actionID}
  * @param pActionID new value of interest
  * @return same object to permit progressive setters */
public ActionRequestPdu setActionID(ActionRequestActionID pActionID)
{
    actionID = pActionID;
    return this;
}

/** Getter for {@link ActionRequestPdu#actionID}
  * @return value of interest */
public ActionRequestActionID getActionID()
{
    return actionID; 
}

/** Setter for {@link ActionRequestPdu#fixedDatums}
  * @param pFixedDatums new value of interest
  * @return same object to permit progressive setters */
public ActionRequestPdu setFixedDatums(List<FixedDatum> pFixedDatums)
{
    fixedDatums = pFixedDatums;
    return this;
}

/** Getter for {@link ActionRequestPdu#fixedDatums}
  * @return value of interest */
public List<FixedDatum> getFixedDatums()
{
    return fixedDatums; 
}

/** Setter for {@link ActionRequestPdu#variableDatums}
  * @param pVariableDatums new value of interest
  * @return same object to permit progressive setters */
public ActionRequestPdu setVariableDatums(List<VariableDatum> pVariableDatums)
{
    variableDatums = pVariableDatums;
    return this;
}

/** Getter for {@link ActionRequestPdu#variableDatums}
  * @return value of interest */
public List<VariableDatum> getVariableDatums()
{
    return variableDatums; 
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
       actionID.marshal(dos);
       dos.writeInt(fixedDatums.size());
       dos.writeInt(variableDatums.size());

       for(int idx = 0; idx < fixedDatums.size(); idx++)
       {
            FixedDatum aFixedDatum = fixedDatums.get(idx);
            aFixedDatum.marshal(dos);
       }


       for(int idx = 0; idx < variableDatums.size(); idx++)
       {
            VariableDatum aVariableDatum = variableDatums.get(idx);
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
        actionID = ActionRequestActionID.unmarshalEnum(dis);
        uPosition += actionID.getMarshalledSize();
        numberOfFixedDatumRecords = dis.readInt();
        uPosition += 4;
        numberOfVariableDatumRecords = dis.readInt();
        uPosition += 4;
        for(int idx = 0; idx < numberOfFixedDatumRecords; idx++)
        {
            FixedDatum anX = new FixedDatum();
            uPosition += anX.unmarshal(dis);
            fixedDatums.add(anX);
        }

        for(int idx = 0; idx < numberOfVariableDatumRecords; idx++)
        {
            VariableDatum anX = new VariableDatum();
            uPosition += anX.unmarshal(dis);
            variableDatums.add(anX);
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
   actionID.marshal(byteBuffer);
   byteBuffer.putInt( (int)fixedDatums.size());
   byteBuffer.putInt( (int)variableDatums.size());

   for(int idx = 0; idx < fixedDatums.size(); idx++)
   {
        FixedDatum aFixedDatum = fixedDatums.get(idx);
        aFixedDatum.marshal(byteBuffer);
   }


   for(int idx = 0; idx < variableDatums.size(); idx++)
   {
        VariableDatum aVariableDatum = variableDatums.get(idx);
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
    actionID = ActionRequestActionID.unmarshalEnum(byteBuffer);
    numberOfFixedDatumRecords = byteBuffer.getInt();
    numberOfVariableDatumRecords = byteBuffer.getInt();
    for(int idx = 0; idx < numberOfFixedDatumRecords; idx++)
    {
    FixedDatum anX = new FixedDatum();
    anX.unmarshal(byteBuffer);
    fixedDatums.add(anX);
    }

    for(int idx = 0; idx < numberOfVariableDatumRecords; idx++)
    {
    VariableDatum anX = new VariableDatum();
    anX.unmarshal(byteBuffer);
    variableDatums.add(anX);
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

     final ActionRequestPdu rhs = (ActionRequestPdu)obj;

     if( ! (requestID == rhs.requestID)) ivarsEqual = false;
     if( ! (actionID == rhs.actionID)) ivarsEqual = false;

     for(int idx = 0; idx < fixedDatums.size(); idx++)
        if( ! ( fixedDatums.get(idx).equals(rhs.fixedDatums.get(idx)))) ivarsEqual = false;


     for(int idx = 0; idx < variableDatums.size(); idx++)
        if( ! ( variableDatums.get(idx).equals(rhs.variableDatums.get(idx)))) ivarsEqual = false;

    return ivarsEqual && super.equalsImpl(rhs);
 }

 @Override
 public String toString()
 {
    StringBuilder sb = new StringBuilder();
    sb.append(getClass().getSimpleName()).append(":\n");

    sb.append(" requestID: ").append(requestID).append("\n");
    sb.append(" actionID: ").append(actionID).append("\n");
    sb.append(" fixedDatums: ").append("\n");
    fixedDatums.forEach(r->{ sb.append(r.getClass().getSimpleName()).append(": ").append(r).append("\n");});
    sb.append(" variableDatums: ").append("\n");
    variableDatums.forEach(r->{ sb.append(r.getClass().getSimpleName()).append(": ").append(r).append("\n");});

   return sb.toString();
 }
} // end of class
