/**
 * Copyright (c) 2008-2019, MOVES Institute, Naval Postgraduate School. All rights reserved.
 * This work is licensed under the BSD open source license, available at https://www.movesinstitute.org/licenses/bsd.html
 */

package edu.nps.moves.dis7;

import java.util.*;
import java.io.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * Basic operational data for IFF. Section 6.2.39
 * IEEE Std 1278.1-2012, IEEE Standard for Distributed Interactive Simulation—Application Protocols
 */
public class FundamentalOperationalData extends Object implements Serializable
{
   /** system status, IEEE DIS 7 defined */
   protected byte  systemStatus;

   /** data field 1 */
   protected byte  dataField1;

   /** eight boolean fields */
   protected byte  informationLayers;

   /** enumeration */
   protected byte  dataField2;

   /** parameter, enumeration */
   protected short  parameter1;

   /** parameter, enumeration */
   protected short  parameter2;

   /** parameter, enumeration */
   protected short  parameter3;

   /** parameter, enumeration */
   protected short  parameter4;

   /** parameter, enumeration */
   protected short  parameter5;

   /** parameter, enumeration */
   protected short  parameter6;


/** Constructor */
 public FundamentalOperationalData()
 {
 }

/** Returns the size of this serialized object in bytes*/
public int getMarshalledSize()
{
   int marshalSize = 0; 

   marshalSize += 1;  // systemStatus
   marshalSize += 1;  // dataField1
   marshalSize += 1;  // informationLayers
   marshalSize += 1;  // dataField2
   marshalSize += 2;  // parameter1
   marshalSize += 2;  // parameter2
   marshalSize += 2;  // parameter3
   marshalSize += 2;  // parameter4
   marshalSize += 2;  // parameter5
   marshalSize += 2;  // parameter6

   return marshalSize;
}


/** Setter for {@link FundamentalOperationalData#systemStatus}*/
public FundamentalOperationalData setSystemStatus(byte pSystemStatus)
{
    systemStatus = pSystemStatus;
    return this;
}

/** Getter for {@link FundamentalOperationalData#systemStatus}*/
public byte getSystemStatus()
{
    return systemStatus; 
}

/** Setter for {@link FundamentalOperationalData#dataField1}*/
public FundamentalOperationalData setDataField1(byte pDataField1)
{
    dataField1 = pDataField1;
    return this;
}

/** Getter for {@link FundamentalOperationalData#dataField1}*/
public byte getDataField1()
{
    return dataField1; 
}

/** Setter for {@link FundamentalOperationalData#informationLayers}*/
public FundamentalOperationalData setInformationLayers(byte pInformationLayers)
{
    informationLayers = pInformationLayers;
    return this;
}

/** Getter for {@link FundamentalOperationalData#informationLayers}*/
public byte getInformationLayers()
{
    return informationLayers; 
}

/** Setter for {@link FundamentalOperationalData#dataField2}*/
public FundamentalOperationalData setDataField2(byte pDataField2)
{
    dataField2 = pDataField2;
    return this;
}

/** Getter for {@link FundamentalOperationalData#dataField2}*/
public byte getDataField2()
{
    return dataField2; 
}

/** Setter for {@link FundamentalOperationalData#parameter1}*/
public FundamentalOperationalData setParameter1(short pParameter1)
{
    parameter1 = pParameter1;
    return this;
}

/** Getter for {@link FundamentalOperationalData#parameter1}*/
public short getParameter1()
{
    return parameter1; 
}

/** Setter for {@link FundamentalOperationalData#parameter2}*/
public FundamentalOperationalData setParameter2(short pParameter2)
{
    parameter2 = pParameter2;
    return this;
}

/** Getter for {@link FundamentalOperationalData#parameter2}*/
public short getParameter2()
{
    return parameter2; 
}

/** Setter for {@link FundamentalOperationalData#parameter3}*/
public FundamentalOperationalData setParameter3(short pParameter3)
{
    parameter3 = pParameter3;
    return this;
}

/** Getter for {@link FundamentalOperationalData#parameter3}*/
public short getParameter3()
{
    return parameter3; 
}

/** Setter for {@link FundamentalOperationalData#parameter4}*/
public FundamentalOperationalData setParameter4(short pParameter4)
{
    parameter4 = pParameter4;
    return this;
}

/** Getter for {@link FundamentalOperationalData#parameter4}*/
public short getParameter4()
{
    return parameter4; 
}

/** Setter for {@link FundamentalOperationalData#parameter5}*/
public FundamentalOperationalData setParameter5(short pParameter5)
{
    parameter5 = pParameter5;
    return this;
}

/** Getter for {@link FundamentalOperationalData#parameter5}*/
public short getParameter5()
{
    return parameter5; 
}

/** Setter for {@link FundamentalOperationalData#parameter6}*/
public FundamentalOperationalData setParameter6(short pParameter6)
{
    parameter6 = pParameter6;
    return this;
}

/** Getter for {@link FundamentalOperationalData#parameter6}*/
public short getParameter6()
{
    return parameter6; 
}

/**
 * Serializes an object to a DataOutputStream.
 * @see java.io.DataOutputStream
 * @param dos The DataOutputStream
 */
public void marshal(DataOutputStream dos) throws Exception
{
    try 
    {
       dos.writeByte( (byte)systemStatus);
       dos.writeByte( (byte)dataField1);
       dos.writeByte( (byte)informationLayers);
       dos.writeByte( (byte)dataField2);
       dos.writeShort( (short)parameter1);
       dos.writeShort( (short)parameter2);
       dos.writeShort( (short)parameter3);
       dos.writeShort( (short)parameter4);
       dos.writeShort( (short)parameter5);
       dos.writeShort( (short)parameter6);
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
    try 
    {
        systemStatus = (byte)dis.readUnsignedByte();
        uPosition += 1;
        dataField1 = (byte)dis.readUnsignedByte();
        uPosition += 1;
        informationLayers = (byte)dis.readUnsignedByte();
        uPosition += 1;
        dataField2 = (byte)dis.readUnsignedByte();
        uPosition += 1;
        parameter1 = (short)dis.readUnsignedShort();
        uPosition += 2;
        parameter2 = (short)dis.readUnsignedShort();
        uPosition += 2;
        parameter3 = (short)dis.readUnsignedShort();
        uPosition += 2;
        parameter4 = (short)dis.readUnsignedShort();
        uPosition += 2;
        parameter5 = (short)dis.readUnsignedShort();
        uPosition += 2;
        parameter6 = (short)dis.readUnsignedShort();
        uPosition += 2;
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
   buff.put( (byte)systemStatus);
   buff.put( (byte)dataField1);
   buff.put( (byte)informationLayers);
   buff.put( (byte)dataField2);
   buff.putShort( (short)parameter1);
   buff.putShort( (short)parameter2);
   buff.putShort( (short)parameter3);
   buff.putShort( (short)parameter4);
   buff.putShort( (short)parameter5);
   buff.putShort( (short)parameter6);
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
    systemStatus = (byte)(buff.get() & 0xFF);
    dataField1 = (byte)(buff.get() & 0xFF);
    informationLayers = (byte)(buff.get() & 0xFF);
    dataField2 = (byte)(buff.get() & 0xFF);
    parameter1 = (short)(buff.getShort() & 0xFFFF);
    parameter2 = (short)(buff.getShort() & 0xFFFF);
    parameter3 = (short)(buff.getShort() & 0xFFFF);
    parameter4 = (short)(buff.getShort() & 0xFFFF);
    parameter5 = (short)(buff.getShort() & 0xFFFF);
    parameter6 = (short)(buff.getShort() & 0xFFFF);
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

 /**
  * Compare all fields that contribute to the state, ignoring
  * transient and static fields, for <code>this</code> and the supplied object
  * @param obj the object to compare to
  * @return true if the objects are equal, false otherwise.
  */
 public boolean equalsImpl(Object obj)
 {
     boolean ivarsEqual = true;

     final FundamentalOperationalData rhs = (FundamentalOperationalData)obj;

     if( ! (systemStatus == rhs.systemStatus)) ivarsEqual = false;
     if( ! (dataField1 == rhs.dataField1)) ivarsEqual = false;
     if( ! (informationLayers == rhs.informationLayers)) ivarsEqual = false;
     if( ! (dataField2 == rhs.dataField2)) ivarsEqual = false;
     if( ! (parameter1 == rhs.parameter1)) ivarsEqual = false;
     if( ! (parameter2 == rhs.parameter2)) ivarsEqual = false;
     if( ! (parameter3 == rhs.parameter3)) ivarsEqual = false;
     if( ! (parameter4 == rhs.parameter4)) ivarsEqual = false;
     if( ! (parameter5 == rhs.parameter5)) ivarsEqual = false;
     if( ! (parameter6 == rhs.parameter6)) ivarsEqual = false;
    return ivarsEqual;
 }

 @Override
 public String toString()
 {
    StringBuilder sb = new StringBuilder();
    sb.append(getClass().getSimpleName()+":\n");

    sb.append(" systemStatus: ").append(systemStatus).append("\n");
    sb.append(" dataField1: ").append(dataField1).append("\n");
    sb.append(" informationLayers: ").append(informationLayers).append("\n");
    sb.append(" dataField2: ").append(dataField2).append("\n");
    sb.append(" parameter1: ").append(parameter1).append("\n");
    sb.append(" parameter2: ").append(parameter2).append("\n");
    sb.append(" parameter3: ").append(parameter3).append("\n");
    sb.append(" parameter4: ").append(parameter4).append("\n");
    sb.append(" parameter5: ").append(parameter5).append("\n");
    sb.append(" parameter6: ").append(parameter6).append("\n");

   return sb.toString();
 }
} // end of class
