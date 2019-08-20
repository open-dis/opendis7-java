/**
 * Copyright (c) 2008-2019, MOVES Institute, Naval Postgraduate School. All rights reserved.
 * This work is licensed under the BSD open source license, available at https://www.movesinstitute.org/licenses/bsd.html
 */

package edu.nps.moves.dis7;

import java.util.*;
import java.io.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * 7.5.11 Information issued in response to a Data Query PDU or Set Data PDU. Section 5.6.5.11
 * IEEE Std 1278.1-2012, IEEE Standard for Distributed Interactive Simulation—Application Protocols
 */
public class DataPdu extends SimulationManagementFamilyPdu implements Serializable
{
   /** ID of request */
   protected int  requestID;

   /** padding */
   protected int  padding1 = (int)0;

   /** Number of fixed datum records */
   protected int  numberOfFixedDatumRecords;

   /** Number of variable datum records */
   protected int  numberOfVariableDatumRecords;

   /** variable length list of fixed datums */
   protected List< FixedDatum > fixedDatums = new ArrayList< FixedDatum >();
 
   /** variable length list of variable length datums */
   protected List< VariableDatum > variableDatums = new ArrayList< VariableDatum >();
 

/** Constructor */
 public DataPdu()
 {
    setPduType( DISPDUType.DATA );
 }

/** Returns the size of this serialized object in bytes*/
public int getMarshalledSize()
{
   int marshalSize = 0; 

   marshalSize = super.getMarshalledSize();
   marshalSize += 4;  // requestID
   marshalSize += 4;  // padding1
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


/** Setter for {@link DataPdu#requestID}*/
public DataPdu setRequestID(int pRequestID)
{
    requestID = pRequestID;
    return this;
}

/** Getter for {@link DataPdu#requestID}*/
public int getRequestID()
{
    return requestID; 
}

/** Setter for {@link DataPdu#padding1}*/
public DataPdu setPadding1(int pPadding1)
{
    padding1 = pPadding1;
    return this;
}

/** Getter for {@link DataPdu#padding1}*/
public int getPadding1()
{
    return padding1; 
}

/** Setter for {@link DataPdu#fixedDatums}*/
public DataPdu setFixedDatums(List<FixedDatum> pFixedDatums)
{
    fixedDatums = pFixedDatums;
    return this;
}

/** Getter for {@link DataPdu#fixedDatums}*/
public List<FixedDatum> getFixedDatums()
{
    return fixedDatums; 
}

/** Setter for {@link DataPdu#variableDatums}*/
public DataPdu setVariableDatums(List<VariableDatum> pVariableDatums)
{
    variableDatums = pVariableDatums;
    return this;
}

/** Getter for {@link DataPdu#variableDatums}*/
public List<VariableDatum> getVariableDatums()
{
    return variableDatums; 
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
       dos.writeInt( (int)requestID);
       dos.writeInt( (int)padding1);
       dos.writeInt( (int)fixedDatums.size());
       dos.writeInt( (int)variableDatums.size());

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
        requestID = dis.readInt();
        uPosition += 4;
        padding1 = dis.readInt();
        uPosition += 4;
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
   buff.putInt( (int)requestID);
   buff.putInt( (int)padding1);
   buff.putInt( (int)fixedDatums.size());
   buff.putInt( (int)variableDatums.size());

   for(int idx = 0; idx < fixedDatums.size(); idx++)
   {
        FixedDatum aFixedDatum = (FixedDatum)fixedDatums.get(idx);
        aFixedDatum.marshal(buff);
   }


   for(int idx = 0; idx < variableDatums.size(); idx++)
   {
        VariableDatum aVariableDatum = (VariableDatum)variableDatums.get(idx);
        aVariableDatum.marshal(buff);
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

    requestID = buff.getInt();
    padding1 = buff.getInt();
    numberOfFixedDatumRecords = buff.getInt();
    numberOfVariableDatumRecords = buff.getInt();
    for(int idx = 0; idx < numberOfFixedDatumRecords; idx++)
    {
    FixedDatum anX = new FixedDatum();
    anX.unmarshal(buff);
    fixedDatums.add(anX);
    }

    for(int idx = 0; idx < numberOfVariableDatumRecords; idx++)
    {
    VariableDatum anX = new VariableDatum();
    anX.unmarshal(buff);
    variableDatums.add(anX);
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

    if(!(obj instanceof DataPdu))
        return false;

     final DataPdu rhs = (DataPdu)obj;

     if( ! (requestID == rhs.requestID)) ivarsEqual = false;
     if( ! (padding1 == rhs.padding1)) ivarsEqual = false;
     if( ! (numberOfFixedDatumRecords == rhs.numberOfFixedDatumRecords)) ivarsEqual = false;
     if( ! (numberOfVariableDatumRecords == rhs.numberOfVariableDatumRecords)) ivarsEqual = false;

     for(int idx = 0; idx < fixedDatums.size(); idx++)
        if( ! ( fixedDatums.get(idx).equals(rhs.fixedDatums.get(idx)))) ivarsEqual = false;


     for(int idx = 0; idx < variableDatums.size(); idx++)
        if( ! ( variableDatums.get(idx).equals(rhs.variableDatums.get(idx)))) ivarsEqual = false;

    return ivarsEqual && super.equalsImpl(rhs);
 }
} // end of class
