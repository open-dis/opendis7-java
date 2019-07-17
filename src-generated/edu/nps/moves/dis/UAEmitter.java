package edu.nps.moves.dis;

import java.util.*;
import java.io.*;
import edu.nps.moves.dis.enumerations.*;


/**
 */
public class UAEmitter extends Object implements Serializable
{
   /**  this field shall specify the length of this emitter system's data in 32-bit words. */
   protected byte  systemDataLength;

   /** the number of beams being described in the current PDU for the emitter system being described. */
   protected byte  numberOfBeams;

   protected short  padding;

   protected AcousticEmitter  acousticEmitter = new AcousticEmitter(); 

   /** the location of the antenna beam source with respect to the emitting entity's coordinate system. This location shall be the origin of the emitter coordinate system that shall have the same orientation as the entity coordinate system. This field shall be represented by an Entity Coordinate Vector record see 6.2.95  */
   protected Vector3Float  location = new Vector3Float(); 

   /** Electronic emission beams */
   protected List< UABeam > beams = new ArrayList< UABeam >();
 

/** Constructor */
 public UAEmitter()
 {
 }

public int getMarshalledSize()
{
   int marshalSize = 0; 

   marshalSize += 1;  // systemDataLength
   marshalSize += 1;  // numberOfBeams
   marshalSize += 2;  // padding
   marshalSize += acousticEmitter.getMarshalledSize();
   marshalSize += location.getMarshalledSize();
   for(int idx=0; idx < beams.size(); idx++)
   {
        UABeam listElement = beams.get(idx);
        marshalSize += listElement.getMarshalledSize();
   }

   return marshalSize;
}


public UAEmitter setSystemDataLength(byte pSystemDataLength)
{
    systemDataLength = pSystemDataLength;
    return this;
}

public byte getSystemDataLength()
{
    return systemDataLength; 
}

public UAEmitter setPadding(short pPadding)
{
    padding = pPadding;
    return this;
}

public short getPadding()
{
    return padding; 
}

public UAEmitter setAcousticEmitter(AcousticEmitter pAcousticEmitter)
{
    acousticEmitter = pAcousticEmitter;
    return this;
}

public AcousticEmitter getAcousticEmitter()
{
    return acousticEmitter; 
}

public UAEmitter setLocation(Vector3Float pLocation)
{
    location = pLocation;
    return this;
}

public Vector3Float getLocation()
{
    return location; 
}

public UAEmitter setBeams(List<UABeam> pBeams)
{
    beams = pBeams;
    return this;
}

public List<UABeam> getBeams()
{
    return beams; 
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
       dos.writeByte( (byte)systemDataLength);
       dos.writeByte( (byte)beams.size());
       dos.writeShort( (short)padding);
       acousticEmitter.marshal(dos);
       location.marshal(dos);

       for(int idx = 0; idx < beams.size(); idx++)
       {
            UABeam aUABeam = beams.get(idx);
            aUABeam.marshal(dos);
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
 */
public int unmarshal(DataInputStream dis)
{
    int uPosition = 0;
    try 
    {
        systemDataLength = (byte)dis.readUnsignedByte();
        uPosition += 1;
        numberOfBeams = (byte)dis.readUnsignedByte();
        uPosition += 1;
        padding = (short)dis.readUnsignedShort();
        uPosition += 2;
        uPosition += acousticEmitter.unmarshal(dis);
        uPosition += location.unmarshal(dis);
        for(int idx = 0; idx < numberOfBeams; idx++)
        {
            UABeam anX = new UABeam();
            uPosition += anX.unmarshal(dis);
            beams.add(anX);
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
 */
public void marshal(java.nio.ByteBuffer buff) throws Exception
{
   buff.put( (byte)systemDataLength);
   buff.put( (byte)beams.size());
   buff.putShort( (short)padding);
   acousticEmitter.marshal(buff);
   location.marshal(buff);

   for(int idx = 0; idx < beams.size(); idx++)
   {
        UABeam aUABeam = (UABeam)beams.get(idx);
        aUABeam.marshal(buff);
   }

}

/**
 * Unpacks a Pdu from the underlying data.
 * @throws java.nio.BufferUnderflowException if buff is too small
 * @see java.nio.ByteBuffer
 * @param buff The ByteBuffer at the position to begin reading
 */
public int unmarshal(java.nio.ByteBuffer buff) throws Exception
{
    systemDataLength = (byte)(buff.get() & 0xFF);
    numberOfBeams = (byte)(buff.get() & 0xFF);
    padding = (short)(buff.getShort() & 0xFFFF);
    acousticEmitter.unmarshal(buff);
    location.unmarshal(buff);
    for(int idx = 0; idx < numberOfBeams; idx++)
    {
    UABeam anX = new UABeam();
    anX.unmarshal(buff);
    beams.add(anX);
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

 /**
  * Compare all fields that contribute to the state, ignoring
  * transient and static fields, for <code>this</code> and the supplied object
  * @param obj the object to compare to
  * @return true if the objects are equal, false otherwise.
  */
 public boolean equalsImpl(Object obj)
 {
     boolean ivarsEqual = true;

    if(!(obj instanceof UAEmitter))
        return false;

     final UAEmitter rhs = (UAEmitter)obj;

     if( ! (systemDataLength == rhs.systemDataLength)) ivarsEqual = false;
     if( ! (numberOfBeams == rhs.numberOfBeams)) ivarsEqual = false;
     if( ! (padding == rhs.padding)) ivarsEqual = false;
     if( ! (acousticEmitter.equals( rhs.acousticEmitter) )) ivarsEqual = false;
     if( ! (location.equals( rhs.location) )) ivarsEqual = false;

     for(int idx = 0; idx < beams.size(); idx++)
        if( ! ( beams.get(idx).equals(rhs.beams.get(idx)))) ivarsEqual = false;

    return ivarsEqual;
 }
} // end of class
