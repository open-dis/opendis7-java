package edu.nps.moves.dis;

import java.util.*;
import java.io.*;
import edu.nps.moves.dis.enumerations.*;


/**
 * Contains electromagnetic emmission regeneration parameters that are variable throught a scenario. Section 6.2.22.
 *
 * Copyright (c) 2008-2019, MOVES Institute, Naval Postgraduate School. All rights reserved.
 * This work is licensed under the BSD open source license, available at https://www.movesinstitute.org/licenses/bsd.html
 *
 * @author DMcG
 */
public class EEFundamentalParameterData extends Object implements Serializable
{
   /** center frequency of the emission in hertz. */
   protected float  frequency;

   /** Bandwidth of the frequencies corresponding to the fequency field. */
   protected float  frequencyRange;

   /** Effective radiated power for the emission in DdBm. For a radar noise jammer, indicates the peak of the transmitted power. */
   protected float  effectiveRadiatedPower;

   /** Average repetition frequency of the emission in hertz. */
   protected float  pulseRepetitionFrequency;

   /** Average pulse width  of the emission in microseconds. */
   protected float  pulseWidth;


/** Constructor */
 public EEFundamentalParameterData()
 {
 }

public int getMarshalledSize()
{
   int marshalSize = 0; 

   marshalSize += 4;  // frequency
   marshalSize += 4;  // frequencyRange
   marshalSize += 4;  // effectiveRadiatedPower
   marshalSize += 4;  // pulseRepetitionFrequency
   marshalSize += 4;  // pulseWidth

   return marshalSize;
}


public EEFundamentalParameterData setFrequency(float pFrequency)
{
    frequency = pFrequency;
    return this;
}

public float getFrequency()
{
    return frequency; 
}

public EEFundamentalParameterData setFrequencyRange(float pFrequencyRange)
{
    frequencyRange = pFrequencyRange;
    return this;
}

public float getFrequencyRange()
{
    return frequencyRange; 
}

public EEFundamentalParameterData setEffectiveRadiatedPower(float pEffectiveRadiatedPower)
{
    effectiveRadiatedPower = pEffectiveRadiatedPower;
    return this;
}

public float getEffectiveRadiatedPower()
{
    return effectiveRadiatedPower; 
}

public EEFundamentalParameterData setPulseRepetitionFrequency(float pPulseRepetitionFrequency)
{
    pulseRepetitionFrequency = pPulseRepetitionFrequency;
    return this;
}

public float getPulseRepetitionFrequency()
{
    return pulseRepetitionFrequency; 
}

public EEFundamentalParameterData setPulseWidth(float pPulseWidth)
{
    pulseWidth = pPulseWidth;
    return this;
}

public float getPulseWidth()
{
    return pulseWidth; 
}

/**
 * Serializes an object to a DataOutputStream.
 * @see java.io.DataOutputStream
 * @param dos The DataOutputStream
 */
public void marshal(DataOutputStream dos)
{
    try 
    {
       dos.writeFloat( (float)frequency);
       dos.writeFloat( (float)frequencyRange);
       dos.writeFloat( (float)effectiveRadiatedPower);
       dos.writeFloat( (float)pulseRepetitionFrequency);
       dos.writeFloat( (float)pulseWidth);
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
    try 
    {
        frequency = dis.readFloat();
        uPosition += 4;
        frequencyRange = dis.readFloat();
        uPosition += 4;
        effectiveRadiatedPower = dis.readFloat();
        uPosition += 4;
        pulseRepetitionFrequency = dis.readFloat();
        uPosition += 4;
        pulseWidth = dis.readFloat();
        uPosition += 4;
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
   buff.putFloat( (float)frequency);
   buff.putFloat( (float)frequencyRange);
   buff.putFloat( (float)effectiveRadiatedPower);
   buff.putFloat( (float)pulseRepetitionFrequency);
   buff.putFloat( (float)pulseWidth);
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
    frequency = buff.getFloat();
    frequencyRange = buff.getFloat();
    effectiveRadiatedPower = buff.getFloat();
    pulseRepetitionFrequency = buff.getFloat();
    pulseWidth = buff.getFloat();
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

 /**
  * Compare all fields that contribute to the state, ignoring
  * transient and static fields, for <code>this</code> and the supplied object
  * @param obj the object to compare to
  * @return true if the objects are equal, false otherwise.
  */
 public boolean equalsImpl(Object obj)
 {
     boolean ivarsEqual = true;

    if(!(obj instanceof EEFundamentalParameterData))
        return false;

     final EEFundamentalParameterData rhs = (EEFundamentalParameterData)obj;

     if( ! (frequency == rhs.frequency)) ivarsEqual = false;
     if( ! (frequencyRange == rhs.frequencyRange)) ivarsEqual = false;
     if( ! (effectiveRadiatedPower == rhs.effectiveRadiatedPower)) ivarsEqual = false;
     if( ! (pulseRepetitionFrequency == rhs.pulseRepetitionFrequency)) ivarsEqual = false;
     if( ! (pulseWidth == rhs.pulseWidth)) ivarsEqual = false;
    return ivarsEqual;
 }
} // end of class
