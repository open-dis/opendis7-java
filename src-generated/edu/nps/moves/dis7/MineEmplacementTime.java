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
public class MineEmplacementTime extends Object implements Serializable
{
   protected int  hour;

   protected int  timePastTheHour;


/** Constructor */
 public MineEmplacementTime()
 {
 }

/** Returns the size of this serialized object in bytes*/
public int getMarshalledSize()
{
   int marshalSize = 0; 

   marshalSize += 4;  // hour
   marshalSize += 4;  // timePastTheHour

   return marshalSize;
}


/** Setter for {@link MineEmplacementTime#hour}*/
public MineEmplacementTime setHour(int pHour)
{
    hour = pHour;
    return this;
}

/** Getter for {@link MineEmplacementTime#hour}*/
public int getHour()
{
    return hour; 
}

/** Setter for {@link MineEmplacementTime#timePastTheHour}*/
public MineEmplacementTime setTimePastTheHour(int pTimePastTheHour)
{
    timePastTheHour = pTimePastTheHour;
    return this;
}

/** Getter for {@link MineEmplacementTime#timePastTheHour}*/
public int getTimePastTheHour()
{
    return timePastTheHour; 
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
       dos.writeInt( (int)hour);
       dos.writeInt( (int)timePastTheHour);
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
        hour = dis.readInt();
        uPosition += 4;
        timePastTheHour = dis.readInt();
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
   buff.putInt( (int)hour);
   buff.putInt( (int)timePastTheHour);
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
    hour = buff.getInt();
    timePastTheHour = buff.getInt();
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

     final MineEmplacementTime rhs = (MineEmplacementTime)obj;

     if( ! (hour == rhs.hour)) ivarsEqual = false;
     if( ! (timePastTheHour == rhs.timePastTheHour)) ivarsEqual = false;
    return ivarsEqual;
 }
} // end of class
