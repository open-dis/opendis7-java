/**
 * Copyright (c) 2008-2019, MOVES Institute, Naval Postgraduate School. All rights reserved.
 * This work is licensed under the BSD open source license, available at https://www.movesinstitute.org/licenses/bsd.html
 */

package edu.nps.moves.dis7;

import java.util.*;
import java.io.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * 7.2.6. Information about individual attributes for a particular entity, other object, or event may be communicated using an Attribute PDU. The Attribute PDU shall not be used to exchange data available in any other PDU except where explicitly mentioned in the PDU issuance instructions within this standard.. See 5.3.6.
 * IEEE Std 1278.1-2012, IEEE Standard for Distributed Interactive Simulation—Application Protocols
 */
public class AttributePdu extends EntityInformationFamilyPdu implements Serializable
{
   /** This field shall identify the simulation issuing the Attribute PDU. It shall be represented by a Simulation Address record (see 6.2.79). */
   protected SimulationAddress  originatingSimulationAddress = new SimulationAddress(); 

   /** Padding */
   protected int  padding1;

   /** Padding */
   protected short  padding2;

   /** This field shall represent the type of the PDU that is being extended or updated, if applicable. It shall be represented by an 8-bit enumeration. uid 4 */
   protected DISPDUType attributeRecordPduType = DISPDUType.values()[0];

   /** This field shall indicate the Protocol Version associated with the Attribute Record PDU Type. It shall be represented by an 8-bit enumeration. uid 5 */
   protected DISProtocolFamily attributeRecordProtocolVersion = DISProtocolFamily.values()[0];

   /** This field shall contain the Attribute record type of the Attribute records in the PDU if they all have the same Attribute record type. It shall be represented by a 32-bit enumeration. uid 66 */
   protected VariableRecordType masterAttributeRecordType = VariableRecordType.values()[0];

   /** This field shall identify the action code applicable to this Attribute PDU. The Action Code shall apply to all Attribute records contained in the PDU. It shall be represented by an 8-bit enumeration. uid 295 */
   protected DISAttributeActionCode actionCode = DISAttributeActionCode.values()[0];

   /** Padding */
   protected byte  padding3;

   /** This field shall specify the number of Attribute Record Sets that make up the remainder of the PDU. It shall be represented by a 16-bit unsigned integer. */
   protected short  numberAttributeRecordSet;

   protected List< AttributeRecordSet > attributeRecordSets = new ArrayList< AttributeRecordSet >();
 

/** Constructor */
 public AttributePdu()
 {
    setPduType( DISPDUType.ATTRIBUTE );
 }

/** Returns the size of this serialized object in bytes*/
public int getMarshalledSize()
{
   int marshalSize = 0; 

   marshalSize = super.getMarshalledSize();
   marshalSize += originatingSimulationAddress.getMarshalledSize();
   marshalSize += 4;  // padding1
   marshalSize += 2;  // padding2
   marshalSize += attributeRecordPduType.getMarshalledSize();
   marshalSize += attributeRecordProtocolVersion.getMarshalledSize();
   marshalSize += masterAttributeRecordType.getMarshalledSize();
   marshalSize += actionCode.getMarshalledSize();
   marshalSize += 1;  // padding3
   marshalSize += 2;  // numberAttributeRecordSet
   for(int idx=0; idx < attributeRecordSets.size(); idx++)
   {
        AttributeRecordSet listElement = attributeRecordSets.get(idx);
        marshalSize += listElement.getMarshalledSize();
   }

   return marshalSize;
}


/** Setter for {@link AttributePdu#originatingSimulationAddress}*/
public AttributePdu setOriginatingSimulationAddress(SimulationAddress pOriginatingSimulationAddress)
{
    originatingSimulationAddress = pOriginatingSimulationAddress;
    return this;
}

/** Getter for {@link AttributePdu#originatingSimulationAddress}*/
public SimulationAddress getOriginatingSimulationAddress()
{
    return originatingSimulationAddress; 
}

/** Setter for {@link AttributePdu#padding1}*/
public AttributePdu setPadding1(int pPadding1)
{
    padding1 = pPadding1;
    return this;
}

/** Getter for {@link AttributePdu#padding1}*/
public int getPadding1()
{
    return padding1; 
}

/** Setter for {@link AttributePdu#padding2}*/
public AttributePdu setPadding2(short pPadding2)
{
    padding2 = pPadding2;
    return this;
}

/** Getter for {@link AttributePdu#padding2}*/
public short getPadding2()
{
    return padding2; 
}

/** Setter for {@link AttributePdu#attributeRecordPduType}*/
public AttributePdu setAttributeRecordPduType(DISPDUType pAttributeRecordPduType)
{
    attributeRecordPduType = pAttributeRecordPduType;
    return this;
}

/** Getter for {@link AttributePdu#attributeRecordPduType}*/
public DISPDUType getAttributeRecordPduType()
{
    return attributeRecordPduType; 
}

/** Setter for {@link AttributePdu#attributeRecordProtocolVersion}*/
public AttributePdu setAttributeRecordProtocolVersion(DISProtocolFamily pAttributeRecordProtocolVersion)
{
    attributeRecordProtocolVersion = pAttributeRecordProtocolVersion;
    return this;
}

/** Getter for {@link AttributePdu#attributeRecordProtocolVersion}*/
public DISProtocolFamily getAttributeRecordProtocolVersion()
{
    return attributeRecordProtocolVersion; 
}

/** Setter for {@link AttributePdu#masterAttributeRecordType}*/
public AttributePdu setMasterAttributeRecordType(VariableRecordType pMasterAttributeRecordType)
{
    masterAttributeRecordType = pMasterAttributeRecordType;
    return this;
}

/** Getter for {@link AttributePdu#masterAttributeRecordType}*/
public VariableRecordType getMasterAttributeRecordType()
{
    return masterAttributeRecordType; 
}

/** Setter for {@link AttributePdu#actionCode}*/
public AttributePdu setActionCode(DISAttributeActionCode pActionCode)
{
    actionCode = pActionCode;
    return this;
}

/** Getter for {@link AttributePdu#actionCode}*/
public DISAttributeActionCode getActionCode()
{
    return actionCode; 
}

/** Setter for {@link AttributePdu#padding3}*/
public AttributePdu setPadding3(byte pPadding3)
{
    padding3 = pPadding3;
    return this;
}

/** Getter for {@link AttributePdu#padding3}*/
public byte getPadding3()
{
    return padding3; 
}

/** Setter for {@link AttributePdu#attributeRecordSets}*/
public AttributePdu setAttributeRecordSets(List<AttributeRecordSet> pAttributeRecordSets)
{
    attributeRecordSets = pAttributeRecordSets;
    return this;
}

/** Getter for {@link AttributePdu#attributeRecordSets}*/
public List<AttributeRecordSet> getAttributeRecordSets()
{
    return attributeRecordSets; 
}

/**
 * Serializes an object to a DataOutputStream.
 * @see java.io.DataOutputStream
 * @param dos The DataOutputStream
 */
public void marshal(DataOutputStream dos) throws Exception
{
    super.marshal(dos);
    try 
    {
       originatingSimulationAddress.marshal(dos);
       dos.writeInt( (int)padding1);
       dos.writeShort( (short)padding2);
       attributeRecordPduType.marshal(dos);
       attributeRecordProtocolVersion.marshal(dos);
       masterAttributeRecordType.marshal(dos);
       actionCode.marshal(dos);
       dos.writeByte( (byte)padding3);
       dos.writeShort( (short)attributeRecordSets.size());

       for(int idx = 0; idx < attributeRecordSets.size(); idx++)
       {
            AttributeRecordSet aAttributeRecordSet = attributeRecordSets.get(idx);
            aAttributeRecordSet.marshal(dos);
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
public int unmarshal(DataInputStream dis) throws Exception
{
    int uPosition = 0;
    uPosition += super.unmarshal(dis);

    try 
    {
        uPosition += originatingSimulationAddress.unmarshal(dis);
        padding1 = dis.readInt();
        uPosition += 4;
        padding2 = dis.readShort();
        uPosition += 4;
        attributeRecordPduType = DISPDUType.unmarshalEnum(dis);
        uPosition += attributeRecordPduType.getMarshalledSize();
        attributeRecordProtocolVersion = DISProtocolFamily.unmarshalEnum(dis);
        uPosition += attributeRecordProtocolVersion.getMarshalledSize();
        masterAttributeRecordType = VariableRecordType.unmarshalEnum(dis);
        uPosition += masterAttributeRecordType.getMarshalledSize();
        actionCode = DISAttributeActionCode.unmarshalEnum(dis);
        uPosition += actionCode.getMarshalledSize();
        padding3 = (byte)dis.readUnsignedByte();
        uPosition += 1;
        numberAttributeRecordSet = (short)dis.readUnsignedShort();
        uPosition += 2;
        for(int idx = 0; idx < numberAttributeRecordSet; idx++)
        {
            AttributeRecordSet anX = new AttributeRecordSet();
            uPosition += anX.unmarshal(dis);
            attributeRecordSets.add(anX);
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
   originatingSimulationAddress.marshal(buff);
   buff.putInt( (int)padding1);
   buff.putShort( (short)padding2);
   attributeRecordPduType.marshal(buff);
   attributeRecordProtocolVersion.marshal(buff);
   masterAttributeRecordType.marshal(buff);
   actionCode.marshal(buff);
   buff.put( (byte)padding3);
   buff.putShort( (short)attributeRecordSets.size());

   for(int idx = 0; idx < attributeRecordSets.size(); idx++)
   {
        AttributeRecordSet aAttributeRecordSet = (AttributeRecordSet)attributeRecordSets.get(idx);
        aAttributeRecordSet.marshal(buff);
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

    originatingSimulationAddress.unmarshal(buff);
    padding1 = buff.getInt();
    padding2 = buff.getShort();
    attributeRecordPduType = DISPDUType.unmarshalEnum(buff);
    attributeRecordProtocolVersion = DISProtocolFamily.unmarshalEnum(buff);
    masterAttributeRecordType = VariableRecordType.unmarshalEnum(buff);
    actionCode = DISAttributeActionCode.unmarshalEnum(buff);
    padding3 = (byte)(buff.get() & 0xFF);
    numberAttributeRecordSet = (short)(buff.getShort() & 0xFFFF);
    for(int idx = 0; idx < numberAttributeRecordSet; idx++)
    {
    AttributeRecordSet anX = new AttributeRecordSet();
    anX.unmarshal(buff);
    attributeRecordSets.add(anX);
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

     final AttributePdu rhs = (AttributePdu)obj;

     if( ! (originatingSimulationAddress.equals( rhs.originatingSimulationAddress) )) ivarsEqual = false;
     if( ! (padding1 == rhs.padding1)) ivarsEqual = false;
     if( ! (padding2 == rhs.padding2)) ivarsEqual = false;
     if( ! (attributeRecordPduType == rhs.attributeRecordPduType)) ivarsEqual = false;
     if( ! (attributeRecordProtocolVersion == rhs.attributeRecordProtocolVersion)) ivarsEqual = false;
     if( ! (masterAttributeRecordType == rhs.masterAttributeRecordType)) ivarsEqual = false;
     if( ! (actionCode == rhs.actionCode)) ivarsEqual = false;
     if( ! (padding3 == rhs.padding3)) ivarsEqual = false;

     for(int idx = 0; idx < attributeRecordSets.size(); idx++)
        if( ! ( attributeRecordSets.get(idx).equals(rhs.attributeRecordSets.get(idx)))) ivarsEqual = false;

    return ivarsEqual && super.equalsImpl(rhs);
 }

 @Override
 public String toString()
 {
    StringBuilder sb = new StringBuilder();
    sb.append(getClass().getSimpleName()+":\n");

    sb.append(" originatingSimulationAddress: ").append(originatingSimulationAddress).append("\n");
    sb.append(" padding1: ").append(padding1).append("\n");
    sb.append(" padding2: ").append(padding2).append("\n");
    sb.append(" attributeRecordPduType: ").append(attributeRecordPduType).append("\n");
    sb.append(" attributeRecordProtocolVersion: ").append(attributeRecordProtocolVersion).append("\n");
    sb.append(" masterAttributeRecordType: ").append(masterAttributeRecordType).append("\n");
    sb.append(" actionCode: ").append(actionCode).append("\n");
    sb.append(" padding3: ").append(padding3).append("\n");
    sb.append(" attributeRecordSets: ").append("\n");
    attributeRecordSets.forEach(r->{ sb.append(r.getClass().getSimpleName()).append(": ").append(r).append("\n");});

   return sb.toString();
 }
} // end of class
