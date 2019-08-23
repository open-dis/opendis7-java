/**
 * Copyright (c) 2008-2019, MOVES Institute, Naval Postgraduate School. All rights reserved.
 * This work is licensed under the BSD open source license, available at https://www.movesinstitute.org/licenses/bsd.html
 */

package edu.nps.moves.dis7;

import java.util.*;
import java.io.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * Information about the type of modulation used for radio transmission. 6.2.59 
 * IEEE Std 1278.1-2012, IEEE Standard for Distributed Interactive Simulation—Application Protocols
 */
public class ModulationType extends Object implements Serializable
{
   /** This field shall indicate the spread spectrum technique or combination of spread spectrum techniques in use. Bit field. 0=freq hopping, 1=psuedo noise, time hopping=2, reamining bits unused */
   protected short  spreadSpectrum;

   /** the major classification of the modulation type.  UID 155 */
   protected TransmitterMajorModulation majorModulation = TransmitterMajorModulation.values()[0];

   /** provide certain detailed information depending upon the major modulation type, uid 156-162 */
   protected short  detail;

   /** the radio system associated with this Transmitter PDU and shall be used as the basis to interpret other fields whose values depend on a specific radio system. uid =163 */
   protected TransmitterModulationTypeSystem radioSystem = TransmitterModulationTypeSystem.values()[0];


/** Constructor */
 public ModulationType()
 {
 }

/** Returns the size of this serialized object in bytes*/
public int getMarshalledSize()
{
   int marshalSize = 0; 

   marshalSize += 2;  // spreadSpectrum
   marshalSize += majorModulation.getMarshalledSize();
   marshalSize += 2;  // detail
   marshalSize += radioSystem.getMarshalledSize();

   return marshalSize;
}


/** Setter for {@link ModulationType#spreadSpectrum}*/
public ModulationType setSpreadSpectrum(short pSpreadSpectrum)
{
    spreadSpectrum = pSpreadSpectrum;
    return this;
}

/** Getter for {@link ModulationType#spreadSpectrum}*/
public short getSpreadSpectrum()
{
    return spreadSpectrum; 
}

/** Setter for {@link ModulationType#majorModulation}*/
public ModulationType setMajorModulation(TransmitterMajorModulation pMajorModulation)
{
    majorModulation = pMajorModulation;
    return this;
}

/** Getter for {@link ModulationType#majorModulation}*/
public TransmitterMajorModulation getMajorModulation()
{
    return majorModulation; 
}

/** Setter for {@link ModulationType#detail}*/
public ModulationType setDetail(short pDetail)
{
    detail = pDetail;
    return this;
}

/** Getter for {@link ModulationType#detail}*/
public short getDetail()
{
    return detail; 
}

/** Setter for {@link ModulationType#radioSystem}*/
public ModulationType setRadioSystem(TransmitterModulationTypeSystem pRadioSystem)
{
    radioSystem = pRadioSystem;
    return this;
}

/** Getter for {@link ModulationType#radioSystem}*/
public TransmitterModulationTypeSystem getRadioSystem()
{
    return radioSystem; 
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
       dos.writeShort( (short)spreadSpectrum);
       majorModulation.marshal(dos);
       dos.writeShort( (short)detail);
       radioSystem.marshal(dos);
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
        spreadSpectrum = (short)dis.readUnsignedShort();
        uPosition += 2;
        majorModulation = TransmitterMajorModulation.unmarshalEnum(dis);
        uPosition += majorModulation.getMarshalledSize();
        detail = (short)dis.readUnsignedShort();
        uPosition += 2;
        radioSystem = TransmitterModulationTypeSystem.unmarshalEnum(dis);
        uPosition += radioSystem.getMarshalledSize();
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
   buff.putShort( (short)spreadSpectrum);
   majorModulation.marshal(buff);
   buff.putShort( (short)detail);
   radioSystem.marshal(buff);
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
    spreadSpectrum = (short)(buff.getShort() & 0xFFFF);
    majorModulation = TransmitterMajorModulation.unmarshalEnum(buff);
    detail = (short)(buff.getShort() & 0xFFFF);
    radioSystem = TransmitterModulationTypeSystem.unmarshalEnum(buff);
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

 /**
  * Compare all fields that contribute to the state, ignoring
  * transient and static fields, for <code>this</code> and the supplied object
  * @param obj the object to compare to
  * @return true if the objects are equal, false otherwise.
  */
 public boolean equalsImpl(Object obj)
 {
     boolean ivarsEqual = true;

     final ModulationType rhs = (ModulationType)obj;

     if( ! (spreadSpectrum == rhs.spreadSpectrum)) ivarsEqual = false;
     if( ! (majorModulation == rhs.majorModulation)) ivarsEqual = false;
     if( ! (detail == rhs.detail)) ivarsEqual = false;
     if( ! (radioSystem == rhs.radioSystem)) ivarsEqual = false;
    return ivarsEqual;
 }
} // end of class
