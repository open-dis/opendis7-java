package edu.nps.moves.dis;

import java.util.*;
import java.io.*;
import edu.nps.moves.dis.enumerations.*;


/**
 * Specifies the character set used inthe first byte, followed by 11 characters of text data. Section 6.29
 *
 * Copyright (c) 2008-2019, MOVES Institute, Naval Postgraduate School. All rights reserved.
 * This work is licensed under the BSD open source license, available at https://www.movesinstitute.org/licenses/bsd.html
 *
 * @author DMcG
 */
public class EntityMarking extends Object implements Serializable
{
   /** The character set uid 45 */
   protected EntityMarkingCharacterSet characterSet = EntityMarkingCharacterSet.values()[0];

   /** The characters */
   protected byte[]  characters = new byte[11]; 


/** Constructor */
 public EntityMarking()
 {
 }

public int getMarshalledSize()
{
   int marshalSize = 0; 

   marshalSize += characterSet.getMarshalledSize();
   marshalSize += characters.length * 1;

   return marshalSize;
}


public EntityMarking setCharacterSet(EntityMarkingCharacterSet pCharacterSet)
{
    characterSet = pCharacterSet;
    return this;
}

public EntityMarkingCharacterSet getCharacterSet()
{
    return characterSet; 
}

public EntityMarking setCharacters(byte[] pCharacters)
{
    characters = Arrays.copyOf(pCharacters, characters.length);
    return this;
}

public byte[] getCharacters()
{
    return characters; 
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
       characterSet.marshal(dos);

       for(int idx = 0; idx < characters.length; idx++)
           dos.writeByte(characters[idx]);

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
        characterSet = EntityMarkingCharacterSet.unmarshalEnum(dis);
        uPosition += characterSet.getMarshalledSize();
        for(int idx = 0; idx < characters.length; idx++)
            characters[idx] = dis.readByte(); // mike check
        uPosition += characters.length; // todo, multiply by prim size mike
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
   characterSet.marshal(buff);

   for(int idx = 0; idx < characters.length; idx++)
       buff.put((byte)characters[idx]);

}

/**
 * Unpacks a Pdu from the underlying data.
 * @throws java.nio.BufferUnderflowException if buff is too small
 * @see java.nio.ByteBuffer
 * @param buff The ByteBuffer at the position to begin reading
 */
public int unmarshal(java.nio.ByteBuffer buff) throws Exception
{
    characterSet = EntityMarkingCharacterSet.unmarshalEnum(buff);
    for(int idx = 0; idx < characters.length; idx++)
        characters[idx] = buff.get();
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

    if(!(obj instanceof EntityMarking))
        return false;

     final EntityMarking rhs = (EntityMarking)obj;

     if( ! (characterSet == rhs.characterSet)) ivarsEqual = false;

     for(int idx = 0; idx < 11; idx++)
     {
          if(!(characters[idx] == rhs.characters[idx])) ivarsEqual = false;
     }

    return ivarsEqual;
 }
} // end of class
