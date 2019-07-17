package edu.nps.moves.dis;

import java.util.*;
import java.io.*;
import edu.nps.moves.dis.enumerations.*;


/**
 */
public class AttributeRecordSet extends Object implements Serializable
{
   protected EntityID  entityId = new EntityID(); 

   protected short  numberOfAttributeRecords;

   protected List< Attribute > attributeRecords = new ArrayList< Attribute >();
 

/** Constructor */
 public AttributeRecordSet()
 {
 }

public int getMarshalledSize()
{
   int marshalSize = 0; 

   marshalSize += entityId.getMarshalledSize();
   marshalSize += 2;  // numberOfAttributeRecords
   for(int idx=0; idx < attributeRecords.size(); idx++)
   {
        Attribute listElement = attributeRecords.get(idx);
        marshalSize += listElement.getMarshalledSize();
   }

   return marshalSize;
}


public AttributeRecordSet setEntityId(EntityID pEntityId)
{
    entityId = pEntityId;
    return this;
}

public EntityID getEntityId()
{
    return entityId; 
}

public AttributeRecordSet setAttributeRecords(List<Attribute> pAttributeRecords)
{
    attributeRecords = pAttributeRecords;
    return this;
}

public List<Attribute> getAttributeRecords()
{
    return attributeRecords; 
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
       entityId.marshal(dos);
       dos.writeShort( (short)attributeRecords.size());

       for(int idx = 0; idx < attributeRecords.size(); idx++)
       {
            Attribute aAttribute = attributeRecords.get(idx);
            aAttribute.marshal(dos);
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
 * @return marshalled size
 */
public int unmarshal(DataInputStream dis)
{
    int uPosition = 0;
    try 
    {
        uPosition += entityId.unmarshal(dis);
        numberOfAttributeRecords = (short)dis.readUnsignedShort();
        uPosition += 2;
        for(int idx = 0; idx < numberOfAttributeRecords; idx++)
        {
            Attribute anX = new Attribute();
            uPosition += anX.unmarshal(dis);
            attributeRecords.add(anX);
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
 * @throws Exception ByteBuffer-generated exception
 */
public void marshal(java.nio.ByteBuffer buff) throws Exception
{
   entityId.marshal(buff);
   buff.putShort( (short)attributeRecords.size());

   for(int idx = 0; idx < attributeRecords.size(); idx++)
   {
        Attribute aAttribute = (Attribute)attributeRecords.get(idx);
        aAttribute.marshal(buff);
   }

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
    entityId.unmarshal(buff);
    numberOfAttributeRecords = (short)(buff.getShort() & 0xFFFF);
    for(int idx = 0; idx < numberOfAttributeRecords; idx++)
    {
    Attribute anX = new Attribute();
    anX.unmarshal(buff);
    attributeRecords.add(anX);
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

    if(!(obj instanceof AttributeRecordSet))
        return false;

     final AttributeRecordSet rhs = (AttributeRecordSet)obj;

     if( ! (entityId.equals( rhs.entityId) )) ivarsEqual = false;
     if( ! (numberOfAttributeRecords == rhs.numberOfAttributeRecords)) ivarsEqual = false;

     for(int idx = 0; idx < attributeRecords.size(); idx++)
        if( ! ( attributeRecords.get(idx).equals(rhs.attributeRecords.get(idx)))) ivarsEqual = false;

    return ivarsEqual;
 }
} // end of class
