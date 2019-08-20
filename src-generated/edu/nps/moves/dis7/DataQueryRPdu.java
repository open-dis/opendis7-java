/**
 * Copyright (c) 2008-2019, MOVES Institute, Naval Postgraduate School. All rights reserved.
 * This work is licensed under the BSD open source license, available at https://www.movesinstitute.org/licenses/bsd.html
 */

package edu.nps.moves.dis7;

import java.util.*;
import java.io.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * 5.12.4.9 Serves the same function as the Data Query PDU but with the addition of reliability service levels
 * IEEE Std 1278.1-2012, IEEE Standard for Distributed Interactive Simulation—Application Protocols
 */
public class DataQueryRPdu extends SimulationManagementWithReliabilityFamilyPdu implements Serializable
{
   /** level of reliability service used for this transaction uid 74 */
   protected RequiredReliabilityService requiredReliabilityService = RequiredReliabilityService.values()[0];

   /** padding */
   protected byte  pad1;

   /** padding */
   protected short  pad2;

   /** request ID */
   protected int  requestID;

   /** time interval between issuing data query PDUs */
   protected int  timeInterval;

   /** Fixed datum record count */
   protected int  numberOfFixedDatumRecords;

   /** variable datum record count */
   protected int  numberOfVariableDatumRecords;

   /** Fixed datum records */
   protected List< FixedDatum > fixedDatumRecords = new ArrayList< FixedDatum >();
 
   /** Variable datum records */
   protected List< VariableDatum > variableDatumRecords = new ArrayList< VariableDatum >();
 

/** Constructor */
 public DataQueryRPdu()
 {
    setPduType( DISPDUType.DATA_QUERY_RELIABLE );
 }

/** Returns the size of this serialized object in bytes*/
public int getMarshalledSize()
{
   int marshalSize = 0; 

   marshalSize = super.getMarshalledSize();
   marshalSize += requiredReliabilityService.getMarshalledSize();
   marshalSize += 1;  // pad1
   marshalSize += 2;  // pad2
   marshalSize += 4;  // requestID
   marshalSize += 4;  // timeInterval
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


/** Setter for {@link DataQueryRPdu#requiredReliabilityService}*/
public DataQueryRPdu setRequiredReliabilityService(RequiredReliabilityService pRequiredReliabilityService)
{
    requiredReliabilityService = pRequiredReliabilityService;
    return this;
}

/** Getter for {@link DataQueryRPdu#requiredReliabilityService}*/
public RequiredReliabilityService getRequiredReliabilityService()
{
    return requiredReliabilityService; 
}

/** Setter for {@link DataQueryRPdu#pad1}*/
public DataQueryRPdu setPad1(byte pPad1)
{
    pad1 = pPad1;
    return this;
}

/** Getter for {@link DataQueryRPdu#pad1}*/
public byte getPad1()
{
    return pad1; 
}

/** Setter for {@link DataQueryRPdu#pad2}*/
public DataQueryRPdu setPad2(short pPad2)
{
    pad2 = pPad2;
    return this;
}

/** Getter for {@link DataQueryRPdu#pad2}*/
public short getPad2()
{
    return pad2; 
}

/** Setter for {@link DataQueryRPdu#requestID}*/
public DataQueryRPdu setRequestID(int pRequestID)
{
    requestID = pRequestID;
    return this;
}

/** Getter for {@link DataQueryRPdu#requestID}*/
public int getRequestID()
{
    return requestID; 
}

/** Setter for {@link DataQueryRPdu#timeInterval}*/
public DataQueryRPdu setTimeInterval(int pTimeInterval)
{
    timeInterval = pTimeInterval;
    return this;
}

/** Getter for {@link DataQueryRPdu#timeInterval}*/
public int getTimeInterval()
{
    return timeInterval; 
}

/** Setter for {@link DataQueryRPdu#fixedDatumRecords}*/
public DataQueryRPdu setFixedDatumRecords(List<FixedDatum> pFixedDatumRecords)
{
    fixedDatumRecords = pFixedDatumRecords;
    return this;
}

/** Getter for {@link DataQueryRPdu#fixedDatumRecords}*/
public List<FixedDatum> getFixedDatumRecords()
{
    return fixedDatumRecords; 
}

/** Setter for {@link DataQueryRPdu#variableDatumRecords}*/
public DataQueryRPdu setVariableDatumRecords(List<VariableDatum> pVariableDatumRecords)
{
    variableDatumRecords = pVariableDatumRecords;
    return this;
}

/** Getter for {@link DataQueryRPdu#variableDatumRecords}*/
public List<VariableDatum> getVariableDatumRecords()
{
    return variableDatumRecords; 
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
       requiredReliabilityService.marshal(dos);
       dos.writeByte( (byte)pad1);
       dos.writeShort( (short)pad2);
       dos.writeInt( (int)requestID);
       dos.writeInt( (int)timeInterval);
       dos.writeInt( (int)fixedDatumRecords.size());
       dos.writeInt( (int)variableDatumRecords.size());

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
        requiredReliabilityService = RequiredReliabilityService.unmarshalEnum(dis);
        uPosition += requiredReliabilityService.getMarshalledSize();
        pad1 = (byte)dis.readUnsignedByte();
        uPosition += 1;
        pad2 = (short)dis.readUnsignedShort();
        uPosition += 2;
        requestID = dis.readInt();
        uPosition += 4;
        timeInterval = dis.readInt();
        uPosition += 4;
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
   requiredReliabilityService.marshal(buff);
   buff.put( (byte)pad1);
   buff.putShort( (short)pad2);
   buff.putInt( (int)requestID);
   buff.putInt( (int)timeInterval);
   buff.putInt( (int)fixedDatumRecords.size());
   buff.putInt( (int)variableDatumRecords.size());

   for(int idx = 0; idx < fixedDatumRecords.size(); idx++)
   {
        FixedDatum aFixedDatum = (FixedDatum)fixedDatumRecords.get(idx);
        aFixedDatum.marshal(buff);
   }


   for(int idx = 0; idx < variableDatumRecords.size(); idx++)
   {
        VariableDatum aVariableDatum = (VariableDatum)variableDatumRecords.get(idx);
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

    requiredReliabilityService = RequiredReliabilityService.unmarshalEnum(buff);
    pad1 = (byte)(buff.get() & 0xFF);
    pad2 = (short)(buff.getShort() & 0xFFFF);
    requestID = buff.getInt();
    timeInterval = buff.getInt();
    numberOfFixedDatumRecords = buff.getInt();
    numberOfVariableDatumRecords = buff.getInt();
    for(int idx = 0; idx < numberOfFixedDatumRecords; idx++)
    {
    FixedDatum anX = new FixedDatum();
    anX.unmarshal(buff);
    fixedDatumRecords.add(anX);
    }

    for(int idx = 0; idx < numberOfVariableDatumRecords; idx++)
    {
    VariableDatum anX = new VariableDatum();
    anX.unmarshal(buff);
    variableDatumRecords.add(anX);
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

    if(!(obj instanceof DataQueryRPdu))
        return false;

     final DataQueryRPdu rhs = (DataQueryRPdu)obj;

     if( ! (requiredReliabilityService == rhs.requiredReliabilityService)) ivarsEqual = false;
     if( ! (pad1 == rhs.pad1)) ivarsEqual = false;
     if( ! (pad2 == rhs.pad2)) ivarsEqual = false;
     if( ! (requestID == rhs.requestID)) ivarsEqual = false;
     if( ! (timeInterval == rhs.timeInterval)) ivarsEqual = false;
     if( ! (numberOfFixedDatumRecords == rhs.numberOfFixedDatumRecords)) ivarsEqual = false;
     if( ! (numberOfVariableDatumRecords == rhs.numberOfVariableDatumRecords)) ivarsEqual = false;

     for(int idx = 0; idx < fixedDatumRecords.size(); idx++)
        if( ! ( fixedDatumRecords.get(idx).equals(rhs.fixedDatumRecords.get(idx)))) ivarsEqual = false;


     for(int idx = 0; idx < variableDatumRecords.size(); idx++)
        if( ! ( variableDatumRecords.get(idx).equals(rhs.variableDatumRecords.get(idx)))) ivarsEqual = false;

    return ivarsEqual && super.equalsImpl(rhs);
 }
} // end of class
