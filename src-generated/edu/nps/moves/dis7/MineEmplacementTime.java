/**
 * Copyright (c) 2008-2020, MOVES Institute, Naval Postgraduate School (NPS). All rights reserved.
 * This work is provided under a BSD open-source license, see project license.html and license.txt
 */

package edu.nps.moves.dis7;

import java.util.*;
import java.io.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * IEEE Std 1278.1-2012, IEEE Standard for Distributed Interactive Simulation - Application Protocols
 */
public class MineEmplacementTime extends Object implements Serializable
{
   protected int  hour;

   protected int  timePastTheHour;


/** Constructor */
 public MineEmplacementTime()
 {
 }

  /**
   * Returns size of this serialized object in bytes
   * @return size in bytes
   */
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
 * @throws java.lang.Exception if something goes wrong
 * @see java.io.DataOutputStream
 * @param dos the OutputStream
 */
public void marshal(DataOutputStream dos) throws Exception
{
    try 
    {
       dos.writeInt(hour);
       dos.writeInt(timePastTheHour);
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
 * @param dis the InputStream
 * @return unmarshalled size
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
      System.err.println(e); 
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

     final MineEmplacementTime rhs = (MineEmplacementTime)obj;

     if( ! (hour == rhs.hour)) ivarsEqual = false;
     if( ! (timePastTheHour == rhs.timePastTheHour)) ivarsEqual = false;
    return ivarsEqual;
 }

 @Override
 public String toString()
 {
    StringBuilder sb = new StringBuilder();
    sb.append(getClass().getSimpleName()).append(":\n");

    sb.append(" hour: ").append(hour).append("\n");
    sb.append(" timePastTheHour: ").append(timePastTheHour).append("\n");

   return sb.toString();
 }
} // end of class
