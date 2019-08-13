/**
 * Copyright (c) 2008-2019, MOVES Institute, Naval Postgraduate School. All rights reserved.
 * This work is licensed under the BSD open source license, available at https://www.movesinstitute.org/licenses/bsd.html
 */

package edu.nps.moves.dis7;

import java.util.*;
import java.io.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * 5.9.3.1 The IsGroupOf PDU shall communicate information about the individual states of a group of entities, including state information that is necessary for the receiving simulation applications to represent the issuing group of entities in the simulation applications’ own simulation.
 * IEEE Std 1278.1-2012, IEEE Standard for Distributed Interactive Simulation—Application Protocols
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
    setPduType( DISPDUType.ISGROUPOF );
 }

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


public IsGroupOfPdu setGroupEntityID(EntityID pGroupEntityID)
{
    groupEntityID = pGroupEntityID;
    return this;
}

public EntityID getGroupEntityID()
{
    return groupEntityID; 
}

public IsGroupOfPdu setGroupedEntityCategory(IsGroupOfGroupedEntityCategory pGroupedEntityCategory)
{
    groupedEntityCategory = pGroupedEntityCategory;
    return this;
}

public IsGroupOfGroupedEntityCategory getGroupedEntityCategory()
{
    return groupedEntityCategory; 
}

public IsGroupOfPdu setPad(int pPad)
{
    pad = pPad;
    return this;
}

public int getPad()
{
    return pad; 
}

public IsGroupOfPdu setLatitude(double pLatitude)
{
    latitude = pLatitude;
    return this;
}

public double getLatitude()
{
    return latitude; 
}

public IsGroupOfPdu setLongitude(double pLongitude)
{
    longitude = pLongitude;
    return this;
}

public double getLongitude()
{
    return longitude; 
}

public IsGroupOfPdu setGroupedEntityDescriptions(List<VariableDatum> pGroupedEntityDescriptions)
{
    groupedEntityDescriptions = pGroupedEntityDescriptions;
    return this;
}

public List<VariableDatum> getGroupedEntityDescriptions()
{
    return groupedEntityDescriptions; 
}

/**
 * Serializes an object to a DataOutputStream.
 * @see java.io.DataOutputStream
 * @param dos The DataOutputStream
 */
public void marshal(DataOutputStream dos)
{
    super.marshal(dos);
    try 
    {
       groupEntityID.marshal(dos);
       groupedEntityCategory.marshal(dos);
       dos.writeByte( (byte)groupedEntityDescriptions.size());
       dos.writeInt( (int)pad);
       dos.writeDouble( (double)latitude);
       dos.writeDouble( (double)longitude);

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
 * Unserializes an object from a DataInputStream.
 * @see java.io.DataInputStream
 * @param dis The DataInputStream
 * @return marshalled size
 */
public int unmarshal(DataInputStream dis)
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
   super.marshal(buff);
   groupEntityID.marshal(buff);
   groupedEntityCategory.marshal(buff);
   buff.put( (byte)groupedEntityDescriptions.size());
   buff.putInt( (int)pad);
   buff.putDouble( (double)latitude);
   buff.putDouble( (double)longitude);

   for(int idx = 0; idx < groupedEntityDescriptions.size(); idx++)
   {
        VariableDatum aVariableDatum = (VariableDatum)groupedEntityDescriptions.get(idx);
        aVariableDatum.marshal(buff);
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
    super.unmarshal(buff);

    groupEntityID.unmarshal(buff);
    groupedEntityCategory = IsGroupOfGroupedEntityCategory.unmarshalEnum(buff);
    numberOfGroupedEntities = (byte)(buff.get() & 0xFF);
    pad = buff.getInt();
    latitude = buff.getDouble();
    longitude = buff.getDouble();
    for(int idx = 0; idx < numberOfGroupedEntities; idx++)
    {
    VariableDatum anX = new VariableDatum();
    anX.unmarshal(buff);
    groupedEntityDescriptions.add(anX);
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

@Override
 public boolean equalsImpl(Object obj)
 {
     boolean ivarsEqual = true;

    if(!(obj instanceof IsGroupOfPdu))
        return false;

     final IsGroupOfPdu rhs = (IsGroupOfPdu)obj;

     if( ! (groupEntityID.equals( rhs.groupEntityID) )) ivarsEqual = false;
     if( ! (groupedEntityCategory == rhs.groupedEntityCategory)) ivarsEqual = false;
     if( ! (numberOfGroupedEntities == rhs.numberOfGroupedEntities)) ivarsEqual = false;
     if( ! (pad == rhs.pad)) ivarsEqual = false;
     if( ! (latitude == rhs.latitude)) ivarsEqual = false;
     if( ! (longitude == rhs.longitude)) ivarsEqual = false;

     for(int idx = 0; idx < groupedEntityDescriptions.size(); idx++)
        if( ! ( groupedEntityDescriptions.get(idx).equals(rhs.groupedEntityDescriptions.get(idx)))) ivarsEqual = false;

    return ivarsEqual && super.equalsImpl(rhs);
 }
} // end of class
