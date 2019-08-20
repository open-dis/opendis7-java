/**
 * Copyright (c) 2008-2019, MOVES Institute, Naval Postgraduate School. All rights reserved.
 * This work is licensed under the BSD open source license, available at https://www.movesinstitute.org/licenses/bsd.html
 */

package edu.nps.moves.dis7;

import java.util.*;
import java.io.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * IEEE Std 1278.1-2012, IEEE Standard for Distributed Interactive Simulation—Application Protocols
 */
public class ShaftRPM extends Object implements Serializable
{
   protected short  currentRPM;

   protected short  orderedRPM;

   protected int  RPMrateOfChange;


/** Constructor */
 public ShaftRPM()
 {
 }

/** Returns the size of this serialized object in bytes*/
public int getMarshalledSize()
{
   int marshalSize = 0; 

   marshalSize += 2;  // currentRPM
   marshalSize += 2;  // orderedRPM
   marshalSize += 4;  // RPMrateOfChange

   return marshalSize;
}


/** Setter for {@link ShaftRPM#currentRPM}*/
public ShaftRPM setCurrentRPM(short pCurrentRPM)
{
    currentRPM = pCurrentRPM;
    return this;
}

/** Getter for {@link ShaftRPM#currentRPM}*/
public short getCurrentRPM()
{
    return currentRPM; 
}

/** Setter for {@link ShaftRPM#orderedRPM}*/
public ShaftRPM setOrderedRPM(short pOrderedRPM)
{
    orderedRPM = pOrderedRPM;
    return this;
}

/** Getter for {@link ShaftRPM#orderedRPM}*/
public short getOrderedRPM()
{
    return orderedRPM; 
}

/** Setter for {@link ShaftRPM#RPMrateOfChange}*/
public ShaftRPM setRPMrateOfChange(int pRPMrateOfChange)
{
    RPMrateOfChange = pRPMrateOfChange;
    return this;
}

/** Getter for {@link ShaftRPM#RPMrateOfChange}*/
public int getRPMrateOfChange()
{
    return RPMrateOfChange; 
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
       dos.writeShort( (short)currentRPM);
       dos.writeShort( (short)orderedRPM);
       dos.writeInt( (int)RPMrateOfChange);
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
        currentRPM = (short)dis.readUnsignedShort();
        uPosition += 2;
        orderedRPM = (short)dis.readUnsignedShort();
        uPosition += 2;
        RPMrateOfChange = dis.readInt();
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
   buff.putShort( (short)currentRPM);
   buff.putShort( (short)orderedRPM);
   buff.putInt( (int)RPMrateOfChange);
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
    currentRPM = (short)(buff.getShort() & 0xFFFF);
    orderedRPM = (short)(buff.getShort() & 0xFFFF);
    RPMrateOfChange = buff.getInt();
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

    if(!(obj instanceof ShaftRPM))
        return false;

     final ShaftRPM rhs = (ShaftRPM)obj;

     if( ! (currentRPM == rhs.currentRPM)) ivarsEqual = false;
     if( ! (orderedRPM == rhs.orderedRPM)) ivarsEqual = false;
     if( ! (RPMrateOfChange == rhs.RPMrateOfChange)) ivarsEqual = false;
    return ivarsEqual;
 }
} // end of class
