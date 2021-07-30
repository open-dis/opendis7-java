/**
 * Copyright (c) 2008-2021, MOVES Institute, Naval Postgraduate School (NPS). All rights reserved.
 * This work is provided under a BSD open-source license, see project license.html and license.txt
 */

package edu.nps.moves.dis7.pdus;

import java.util.*;
import java.io.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * 5.9.3.1 The IsGroupOf PDU shall communicate information about the individual states of a group of entities, including state information that is necessary for the receiving simulation applications to represent the issuing group of entities in the simulation applications’ own simulation.
 * IEEE Std 1278.1-2012, IEEE Standard for Distributed Interactive Simulation - Application Protocols
 */
public class IsGroupOfPdu extends EntityManagementFamilyPdu implements Serializable
{
   /** ID of aggregated entities */
   protected EntityID  groupEntityID = new EntityID(); 

   /** type of entities constituting the group uid 213 */
   protected IsGroupOfGroupedEntityCategory groupedEntityCategory = IsGroupOfGroupedEntityCategory.values()[0];

   /** Number of individual entities constituting the group */
   protected byte  numberOfGroupedEntities;

   /** padding */
   protected int  pad;

   /** latitude */
   protected double  latitude;

   /** longitude */
   protected double  longitude;

   /** GED records about each individual entity in the group. Bad specing--the Group Entity Descriptions are not described. */
   protected List< VariableDatum > groupedEntityDescriptions = new ArrayList< VariableDatum >();
 

/** Constructor */
 public IsGroupOfPdu()
 {
    setPduType( DisPduType.ISGROUPOF );
 }

  /**
   * Returns size of this serialized (marshalled) object in bytes
   * @see <a href="https://en.wikipedia.org/wiki/Marshalling_(computer_science)" target="_blank">https://en.wikipedia.org/wiki/Marshalling_(computer_science)</a>
   * @return serialized size in bytes
   */
public int getMarshalledSize()
{
   int marshalSize = 0; 

   marshalSize = super.getMarshalledSize();
   marshalSize += groupEntityID.getMarshalledSize();
   marshalSize += groupedEntityCategory.getMarshalledSize();
   marshalSize += 1;  // numberOfGroupedEntities
   marshalSize += 4;  // pad
   marshalSize += 8;  // latitude
   marshalSize += 8;  // longitude
   for(int idx=0; idx < groupedEntityDescriptions.size(); idx++)
   {
        VariableDatum listElement = groupedEntityDescriptions.get(idx);
        marshalSize += listElement.getMarshalledSize();
   }

   return marshalSize;
}


/** Setter for {@link IsGroupOfPdu#groupEntityID}
  * @param pGroupEntityID new value of interest
  * @return same object to permit progressive setters */
public IsGroupOfPdu setGroupEntityID(EntityID pGroupEntityID)
{
    groupEntityID = pGroupEntityID;
    return this;
}

/** Getter for {@link IsGroupOfPdu#groupEntityID}
  * @return value of interest */
public EntityID getGroupEntityID()
{
    return groupEntityID; 
}

/** Setter for {@link IsGroupOfPdu#groupedEntityCategory}
  * @param pGroupedEntityCategory new value of interest
  * @return same object to permit progressive setters */
public IsGroupOfPdu setGroupedEntityCategory(IsGroupOfGroupedEntityCategory pGroupedEntityCategory)
{
    groupedEntityCategory = pGroupedEntityCategory;
    return this;
}

/** Getter for {@link IsGroupOfPdu#groupedEntityCategory}
  * @return value of interest */
public IsGroupOfGroupedEntityCategory getGroupedEntityCategory()
{
    return groupedEntityCategory; 
}

/** Setter for {@link IsGroupOfPdu#pad}
  * @param pPad new value of interest
  * @return same object to permit progressive setters */
public IsGroupOfPdu setPad(int pPad)
{
    pad = pPad;
    return this;
}

/** Getter for {@link IsGroupOfPdu#pad}
  * @return value of interest */
public int getPad()
{
    return pad; 
}

/** Setter for {@link IsGroupOfPdu#latitude}
  * @param pLatitude new value of interest
  * @return same object to permit progressive setters */
public IsGroupOfPdu setLatitude(double pLatitude)
{
    latitude = pLatitude;
    return this;
}

/** Getter for {@link IsGroupOfPdu#latitude}
  * @return value of interest */
public double getLatitude()
{
    return latitude; 
}

/** Setter for {@link IsGroupOfPdu#longitude}
  * @param pLongitude new value of interest
  * @return same object to permit progressive setters */
public IsGroupOfPdu setLongitude(double pLongitude)
{
    longitude = pLongitude;
    return this;
}

/** Getter for {@link IsGroupOfPdu#longitude}
  * @return value of interest */
public double getLongitude()
{
    return longitude; 
}

/** Setter for {@link IsGroupOfPdu#groupedEntityDescriptions}
  * @param pGroupedEntityDescriptions new value of interest
  * @return same object to permit progressive setters */
public IsGroupOfPdu setGroupedEntityDescriptions(List<VariableDatum> pGroupedEntityDescriptions)
{
    groupedEntityDescriptions = pGroupedEntityDescriptions;
    return this;
}

/** Getter for {@link IsGroupOfPdu#groupedEntityDescriptions}
  * @return value of interest */
public List<VariableDatum> getGroupedEntityDescriptions()
{
    return groupedEntityDescriptions; 
}

/**
 * Serializes an object to a DataOutputStream.
 * @throws java.lang.Exception if something goes wrong
 * @see java.io.DataOutputStream
 * @param dos the OutputStream
 */
public void marshal(DataOutputStream dos) throws Exception
{
    super.marshal(dos);
    try 
    {
       groupEntityID.marshal(dos);
       groupedEntityCategory.marshal(dos);
       dos.writeByte(groupedEntityDescriptions.size());
       dos.writeInt(pad);
       dos.writeDouble(latitude);
       dos.writeDouble(longitude);

       for(int idx = 0; idx < groupedEntityDescriptions.size(); idx++)
       {
            VariableDatum aVariableDatum = groupedEntityDescriptions.get(idx);
            aVariableDatum.marshal(dos);
       }

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
 * @see <a href="https://en.wikipedia.org/wiki/Marshalling_(computer_science)" target="_blank">https://en.wikipedia.org/wiki/Marshalling_(computer_science)</a>
 * @param dis the InputStream
 * @return marshalled serialized size in bytes
 */
public int unmarshal(DataInputStream dis) throws Exception
{
    int uPosition = 0;
    uPosition += super.unmarshal(dis);

    try 
    {
        uPosition += groupEntityID.unmarshal(dis);
        groupedEntityCategory = IsGroupOfGroupedEntityCategory.unmarshalEnum(dis);
        uPosition += groupedEntityCategory.getMarshalledSize();
        numberOfGroupedEntities = (byte)dis.readUnsignedByte();
        uPosition += 1;
        pad = dis.readInt();
        uPosition += 4;
        latitude = dis.readDouble();
        uPosition += 4;
        longitude = dis.readDouble();
        uPosition += 4;
        for(int idx = 0; idx < numberOfGroupedEntities; idx++)
        {
            VariableDatum anX = new VariableDatum();
            uPosition += anX.unmarshal(dis);
            groupedEntityDescriptions.add(anX);
        }

    }
    catch(Exception e)
    { 
      System.err.println(e); 
    }
    return getMarshalledSize();
}

/**
 * Packs an object into the ByteBuffer.
 * @throws java.nio.BufferOverflowException if byteBuffer is too small
 * @throws java.nio.ReadOnlyBufferException if byteBuffer is read only
 * @see java.nio.ByteBuffer
 * @param byteBuffer The ByteBuffer at the position to begin writing
 * @throws Exception ByteBuffer-generated exception
 */
public void marshal(java.nio.ByteBuffer byteBuffer) throws Exception
{
   super.marshal(byteBuffer);
   groupEntityID.marshal(byteBuffer);
   groupedEntityCategory.marshal(byteBuffer);
   byteBuffer.put( (byte)groupedEntityDescriptions.size());
   byteBuffer.putInt( (int)pad);
   byteBuffer.putDouble( (double)latitude);
   byteBuffer.putDouble( (double)longitude);

   for(int idx = 0; idx < groupedEntityDescriptions.size(); idx++)
   {
        VariableDatum aVariableDatum = groupedEntityDescriptions.get(idx);
        aVariableDatum.marshal(byteBuffer);
   }

}

/**
 * Unpacks a Pdu from the underlying data.
 * @throws java.nio.BufferUnderflowException if byteBuffer is too small
 * @see java.nio.ByteBuffer
 * @see <a href="https://en.wikipedia.org/wiki/Marshalling_(computer_science)" target="_blank">https://en.wikipedia.org/wiki/Marshalling_(computer_science)</a>
 * @param byteBuffer The ByteBuffer at the position to begin reading
 * @return marshalled serialized size in bytes
 * @throws Exception ByteBuffer-generated exception
 */
public int unmarshal(java.nio.ByteBuffer byteBuffer) throws Exception
{
    super.unmarshal(byteBuffer);

    groupEntityID.unmarshal(byteBuffer);
    groupedEntityCategory = IsGroupOfGroupedEntityCategory.unmarshalEnum(byteBuffer);
    numberOfGroupedEntities = (byte)(byteBuffer.get() & 0xFF);
    pad = byteBuffer.getInt();
    latitude = byteBuffer.getDouble();
    longitude = byteBuffer.getDouble();
    for(int idx = 0; idx < numberOfGroupedEntities; idx++)
    {
    VariableDatum anX = new VariableDatum();
    anX.unmarshal(byteBuffer);
    groupedEntityDescriptions.add(anX);
    }

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

@Override
 public boolean equalsImpl(Object obj)
 {
     boolean ivarsEqual = true;

     final IsGroupOfPdu rhs = (IsGroupOfPdu)obj;

     if( ! (groupEntityID.equals( rhs.groupEntityID) )) ivarsEqual = false;
     if( ! (groupedEntityCategory == rhs.groupedEntityCategory)) ivarsEqual = false;
     if( ! (pad == rhs.pad)) ivarsEqual = false;
     if( ! (latitude == rhs.latitude)) ivarsEqual = false;
     if( ! (longitude == rhs.longitude)) ivarsEqual = false;

     for(int idx = 0; idx < groupedEntityDescriptions.size(); idx++)
        if( ! ( groupedEntityDescriptions.get(idx).equals(rhs.groupedEntityDescriptions.get(idx)))) ivarsEqual = false;

    return ivarsEqual && super.equalsImpl(rhs);
 }

 @Override
 public String toString()
 {
    StringBuilder sb = new StringBuilder();
    sb.append(getClass().getSimpleName()).append(":\n");

    sb.append(" groupEntityID: ").append(groupEntityID).append("\n");
    sb.append(" groupedEntityCategory: ").append(groupedEntityCategory).append("\n");
    sb.append(" pad: ").append(pad).append("\n");
    sb.append(" latitude: ").append(latitude).append("\n");
    sb.append(" longitude: ").append(longitude).append("\n");
    sb.append(" groupedEntityDescriptions: ").append("\n");
    groupedEntityDescriptions.forEach(r->{ sb.append(r.getClass().getSimpleName()).append(": ").append(r).append("\n");});

   return sb.toString();
 }
} // end of class
