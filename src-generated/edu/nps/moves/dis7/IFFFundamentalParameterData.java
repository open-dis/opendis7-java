/**
 * Copyright (c) 2008-2019, MOVES Institute, Naval Postgraduate School. All rights reserved.
 * This work is licensed under the BSD open source license, available at https://www.movesinstitute.org/licenses/bsd.html
 */

package edu.nps.moves.dis7;

import java.util.*;
import java.io.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * Fundamental IFF atc data. Section 6.2.45
 * IEEE Std 1278.1-2012, IEEE Standard for Distributed Interactive Simulation—Application Protocols
 */
public class IFFFundamentalParameterData extends Object implements Serializable
{
   /** ERP */
   protected float  erp;

   /** frequency */
   protected float  frequency;

   /** pgrf */
   protected float  pgrf;

   /** Pulse width */
   protected float  pulseWidth;

   /** Burst length */
   protected int  burstLength;

   /** Applicable modes enumeration uid 339 */
   protected IFFApplicableModes applicableModes = IFFApplicableModes.values()[0];

   /** System-specific data */
   protected byte[]  systemSpecificData = new byte[3]; 


/** Constructor */
 public IFFFundamentalParameterData()
 {
 }

public int getMarshalledSize()
{
   int marshalSize = 0; 

   marshalSize += 4;  // erp
   marshalSize += 4;  // frequency
   marshalSize += 4;  // pgrf
   marshalSize += 4;  // pulseWidth
   marshalSize += 4;  // burstLength
   marshalSize += applicableModes.getMarshalledSize();
   marshalSize += systemSpecificData.length * 1;

   return marshalSize;
}


public IFFFundamentalParameterData setErp(float pErp)
{
    erp = pErp;
    return this;
}

public float getErp()
{
    return erp; 
}

public IFFFundamentalParameterData setFrequency(float pFrequency)
{
    frequency = pFrequency;
    return this;
}

public float getFrequency()
{
    return frequency; 
}

public IFFFundamentalParameterData setPgrf(float pPgrf)
{
    pgrf = pPgrf;
    return this;
}

public float getPgrf()
{
    return pgrf; 
}

public IFFFundamentalParameterData setPulseWidth(float pPulseWidth)
{
    pulseWidth = pPulseWidth;
    return this;
}

public float getPulseWidth()
{
    return pulseWidth; 
}

public IFFFundamentalParameterData setBurstLength(int pBurstLength)
{
    burstLength = pBurstLength;
    return this;
}

public int getBurstLength()
{
    return burstLength; 
}

public IFFFundamentalParameterData setApplicableModes(IFFApplicableModes pApplicableModes)
{
    applicableModes = pApplicableModes;
    return this;
}

public IFFApplicableModes getApplicableModes()
{
    return applicableModes; 
}

public IFFFundamentalParameterData setSystemSpecificData(byte[] pSystemSpecificData)
{
    systemSpecificData = pSystemSpecificData;
    return this;
}

public byte[] getSystemSpecificData()
{
    return systemSpecificData; 
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
       dos.writeFloat( (float)erp);
       dos.writeFloat( (float)frequency);
       dos.writeFloat( (float)pgrf);
       dos.writeFloat( (float)pulseWidth);
       dos.writeInt( (int)burstLength);
       applicableModes.marshal(dos);

       for(int idx = 0; idx < systemSpecificData.length; idx++)
           dos.writeByte(systemSpecificData[idx]);

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
        erp = dis.readFloat();
        uPosition += 4;
        frequency = dis.readFloat();
        uPosition += 4;
        pgrf = dis.readFloat();
        uPosition += 4;
        pulseWidth = dis.readFloat();
        uPosition += 4;
        burstLength = dis.readInt();
        uPosition += 4;
        applicableModes = IFFApplicableModes.unmarshalEnum(dis);
        uPosition += applicableModes.getMarshalledSize();
        for(int idx = 0; idx < systemSpecificData.length; idx++)
            systemSpecificData[idx] = dis.readByte(); // mike check
        uPosition += systemSpecificData.length; // todo, multiply by prim size mike
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
   buff.putFloat( (float)erp);
   buff.putFloat( (float)frequency);
   buff.putFloat( (float)pgrf);
   buff.putFloat( (float)pulseWidth);
   buff.putInt( (int)burstLength);
   applicableModes.marshal(buff);

   for(int idx = 0; idx < systemSpecificData.length; idx++)
       buff.put((byte)systemSpecificData[idx]);

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
    erp = buff.getFloat();
    frequency = buff.getFloat();
    pgrf = buff.getFloat();
    pulseWidth = buff.getFloat();
    burstLength = buff.getInt();
    applicableModes = IFFApplicableModes.unmarshalEnum(buff);
    for(int idx = 0; idx < systemSpecificData.length; idx++)
        systemSpecificData[idx] = buff.get();
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

    if(!(obj instanceof IFFFundamentalParameterData))
        return false;

     final IFFFundamentalParameterData rhs = (IFFFundamentalParameterData)obj;

     if( ! (erp == rhs.erp)) ivarsEqual = false;
     if( ! (frequency == rhs.frequency)) ivarsEqual = false;
     if( ! (pgrf == rhs.pgrf)) ivarsEqual = false;
     if( ! (pulseWidth == rhs.pulseWidth)) ivarsEqual = false;
     if( ! (burstLength == rhs.burstLength)) ivarsEqual = false;
     if( ! (applicableModes == rhs.applicableModes)) ivarsEqual = false;

     for(int idx = 0; idx < 3; idx++)
     {
          if(!(systemSpecificData[idx] == rhs.systemSpecificData[idx])) ivarsEqual = false;
     }

    return ivarsEqual;
 }
} // end of class
