/**
 * Copyright (c) 2008-2019, MOVES Institute, Naval Postgraduate School. All rights reserved.
 * This work is licensed under the BSD open source license, available at https://www.movesinstitute.org/licenses/bsd.html
 */

package edu.nps.moves.dis7;

import java.util.*;
import java.io.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * The ID of the IFF emitting system. Section 6.2.87
 * IEEE Std 1278.1-2012, IEEE Standard for Distributed Interactive Simulation—Application Protocols
 */
public class SystemIdentifier extends Object implements Serializable
{
   /** general type of emitting system, an enumeration uid 82 */
   protected IFFSystemType systemType = IFFSystemType.values()[0];

   /** named type of system, an enumeration uid 83 */
   protected IFFSystemName systemName = IFFSystemName.values()[0];

   /** mode of operation for the system, an enumeration uid 84 */
   protected IFFSystemMode systemMode = IFFSystemMode.values()[0];

   /** status of this PDU, see section 6.2.15 */
   protected ChangeOptions  changeOptions = new ChangeOptions(); 


/** Constructor */
 public SystemIdentifier()
 {
 }

public int getMarshalledSize()
{
   int marshalSize = 0; 

   marshalSize += systemType.getMarshalledSize();
   marshalSize += systemName.getMarshalledSize();
   marshalSize += systemMode.getMarshalledSize();
   marshalSize += changeOptions.getMarshalledSize();

   return marshalSize;
}


public SystemIdentifier setSystemType(IFFSystemType pSystemType)
{
    systemType = pSystemType;
    return this;
}

public IFFSystemType getSystemType()
{
    return systemType; 
}

public SystemIdentifier setSystemName(IFFSystemName pSystemName)
{
    systemName = pSystemName;
    return this;
}

public IFFSystemName getSystemName()
{
    return systemName; 
}

public SystemIdentifier setSystemMode(IFFSystemMode pSystemMode)
{
    systemMode = pSystemMode;
    return this;
}

public IFFSystemMode getSystemMode()
{
    return systemMode; 
}

public SystemIdentifier setChangeOptions(ChangeOptions pChangeOptions)
{
    changeOptions = pChangeOptions;
    return this;
}

public ChangeOptions getChangeOptions()
{
    return changeOptions; 
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
       systemType.marshal(dos);
       systemName.marshal(dos);
       systemMode.marshal(dos);
       changeOptions.marshal(dos);
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
        systemType = IFFSystemType.unmarshalEnum(dis);
        uPosition += systemType.getMarshalledSize();
        systemName = IFFSystemName.unmarshalEnum(dis);
        uPosition += systemName.getMarshalledSize();
        systemMode = IFFSystemMode.unmarshalEnum(dis);
        uPosition += systemMode.getMarshalledSize();
        uPosition += changeOptions.unmarshal(dis);
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
   systemType.marshal(buff);
   systemName.marshal(buff);
   systemMode.marshal(buff);
   changeOptions.marshal(buff);
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
    systemType = IFFSystemType.unmarshalEnum(buff);
    systemName = IFFSystemName.unmarshalEnum(buff);
    systemMode = IFFSystemMode.unmarshalEnum(buff);
    changeOptions.unmarshal(buff);
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

    if(!(obj instanceof SystemIdentifier))
        return false;

     final SystemIdentifier rhs = (SystemIdentifier)obj;

     if( ! (systemType == rhs.systemType)) ivarsEqual = false;
     if( ! (systemName == rhs.systemName)) ivarsEqual = false;
     if( ! (systemMode == rhs.systemMode)) ivarsEqual = false;
     if( ! (changeOptions.equals( rhs.changeOptions) )) ivarsEqual = false;
    return ivarsEqual;
 }
} // end of class
