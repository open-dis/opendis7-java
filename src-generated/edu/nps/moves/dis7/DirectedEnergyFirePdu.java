/**
 * Copyright (c) 2008-2019, MOVES Institute, Naval Postgraduate School. All rights reserved.
 * This work is provided under a BSD open-source license, see project license.html and license.txt
 */

package edu.nps.moves.dis7;

import java.util.*;
import java.io.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * 7.3.4 Used to communicate the firing of a directed energy weapon.
 * IEEE Std 1278.1-2012, IEEE Standard for Distributed Interactive Simulation—Application Protocols
 */
public class DirectedEnergyFirePdu extends WarfareFamilyPdu implements Serializable
{
   /** ID of the entity that shot */
   protected EntityID  firingEntityID = new EntityID(); 

   protected EventIdentifier  eventID = new EventIdentifier(); 

   /** Field shall identify the munition type enumeration for the DE weapon beam, Section 7.3.4  */
   protected EntityType  munitionType = new EntityType(); 

   /** Field shall indicate the simulation time at start of the shot, Section 7.3.4  */
   protected ClockTime  shotStartTime = new ClockTime(); 

   /** Field shall indicate the current cumulative duration of the shot, Section 7.3.4  */
   protected float  commulativeShotTime;

   /** Field shall identify the location of the DE weapon aperture/emitter, Section 7.3.4  */
   protected Vector3Float  apertureEmitterLocation = new Vector3Float(); 

   /** Field shall identify the beam diameter at the aperture/emitter, Section 7.3.4  */
   protected float  apertureDiameter;

   /** Field shall identify the emissions wavelength in units of meters, Section 7.3.4  */
   protected float  wavelength;

   protected int  pad1;

   protected float  pulseRepititionFrequency;

   /** field shall identify the pulse width emissions in units of seconds, Section 7.3.4 */
   protected float  pulseWidth;

   /** 16bit Boolean field shall contain various flags to indicate status information needed to process a DE, Section 7.3.4  uid 313 */
   protected DEFireFlags flags = new DEFireFlags();

   /** Field shall identify the pulse shape and shall be represented as an 8-bit enumeration, Section 7.3.4  uid 312 */
   protected DEFirePulseShape pulseShape = DEFirePulseShape.values()[0];

   protected byte  pad2;

   protected int  pad3;

   protected short  pad4;

   /** Field shall specify the number of DE records, Section 7.3.4  */
   protected short  numberOfDERecords;

   /** Fields shall contain one or more DE records, records shall conform to the variable record format (Section6.2.82), Section 7.3.4 */
   protected List< StandardVariableSpecification > dERecords = new ArrayList< StandardVariableSpecification >();
 

/** Constructor */
 public DirectedEnergyFirePdu()
 {
    setPduType( DISPDUType.DIRECTED_ENERGY_FIRE );
 }

/** Returns the size of this serialized object in bytes*/
public int getMarshalledSize()
{
   int marshalSize = 0; 

   marshalSize = super.getMarshalledSize();
   marshalSize += firingEntityID.getMarshalledSize();
   marshalSize += eventID.getMarshalledSize();
   marshalSize += munitionType.getMarshalledSize();
   marshalSize += shotStartTime.getMarshalledSize();
   marshalSize += 4;  // commulativeShotTime
   marshalSize += apertureEmitterLocation.getMarshalledSize();
   marshalSize += 4;  // apertureDiameter
   marshalSize += 4;  // wavelength
   marshalSize += 4;  // pad1
   marshalSize += 4;  // pulseRepititionFrequency
   marshalSize += 4;  // pulseWidth
   marshalSize += flags.getMarshalledSize();
   marshalSize += pulseShape.getMarshalledSize();
   marshalSize += 1;  // pad2
   marshalSize += 4;  // pad3
   marshalSize += 2;  // pad4
   marshalSize += 2;  // numberOfDERecords
   for(int idx=0; idx < dERecords.size(); idx++)
   {
        StandardVariableSpecification listElement = dERecords.get(idx);
        marshalSize += listElement.getMarshalledSize();
   }

   return marshalSize;
}


/** Setter for {@link DirectedEnergyFirePdu#firingEntityID}*/
public DirectedEnergyFirePdu setFiringEntityID(EntityID pFiringEntityID)
{
    firingEntityID = pFiringEntityID;
    return this;
}

/** Getter for {@link DirectedEnergyFirePdu#firingEntityID}*/
public EntityID getFiringEntityID()
{
    return firingEntityID; 
}

/** Setter for {@link DirectedEnergyFirePdu#eventID}*/
public DirectedEnergyFirePdu setEventID(EventIdentifier pEventID)
{
    eventID = pEventID;
    return this;
}

/** Getter for {@link DirectedEnergyFirePdu#eventID}*/
public EventIdentifier getEventID()
{
    return eventID; 
}

/** Setter for {@link DirectedEnergyFirePdu#munitionType}*/
public DirectedEnergyFirePdu setMunitionType(EntityType pMunitionType)
{
    munitionType = pMunitionType;
    return this;
}

/** Getter for {@link DirectedEnergyFirePdu#munitionType}*/
public EntityType getMunitionType()
{
    return munitionType; 
}

/** Setter for {@link DirectedEnergyFirePdu#shotStartTime}*/
public DirectedEnergyFirePdu setShotStartTime(ClockTime pShotStartTime)
{
    shotStartTime = pShotStartTime;
    return this;
}

/** Getter for {@link DirectedEnergyFirePdu#shotStartTime}*/
public ClockTime getShotStartTime()
{
    return shotStartTime; 
}

/** Setter for {@link DirectedEnergyFirePdu#commulativeShotTime}*/
public DirectedEnergyFirePdu setCommulativeShotTime(float pCommulativeShotTime)
{
    commulativeShotTime = pCommulativeShotTime;
    return this;
}

/** Getter for {@link DirectedEnergyFirePdu#commulativeShotTime}*/
public float getCommulativeShotTime()
{
    return commulativeShotTime; 
}

/** Setter for {@link DirectedEnergyFirePdu#apertureEmitterLocation}*/
public DirectedEnergyFirePdu setApertureEmitterLocation(Vector3Float pApertureEmitterLocation)
{
    apertureEmitterLocation = pApertureEmitterLocation;
    return this;
}

/** Getter for {@link DirectedEnergyFirePdu#apertureEmitterLocation}*/
public Vector3Float getApertureEmitterLocation()
{
    return apertureEmitterLocation; 
}

/** Setter for {@link DirectedEnergyFirePdu#apertureDiameter}*/
public DirectedEnergyFirePdu setApertureDiameter(float pApertureDiameter)
{
    apertureDiameter = pApertureDiameter;
    return this;
}

/** Getter for {@link DirectedEnergyFirePdu#apertureDiameter}*/
public float getApertureDiameter()
{
    return apertureDiameter; 
}

/** Setter for {@link DirectedEnergyFirePdu#wavelength}*/
public DirectedEnergyFirePdu setWavelength(float pWavelength)
{
    wavelength = pWavelength;
    return this;
}

/** Getter for {@link DirectedEnergyFirePdu#wavelength}*/
public float getWavelength()
{
    return wavelength; 
}

/** Setter for {@link DirectedEnergyFirePdu#pad1}*/
public DirectedEnergyFirePdu setPad1(int pPad1)
{
    pad1 = pPad1;
    return this;
}

/** Getter for {@link DirectedEnergyFirePdu#pad1}*/
public int getPad1()
{
    return pad1; 
}

/** Setter for {@link DirectedEnergyFirePdu#pulseRepititionFrequency}*/
public DirectedEnergyFirePdu setPulseRepititionFrequency(float pPulseRepititionFrequency)
{
    pulseRepititionFrequency = pPulseRepititionFrequency;
    return this;
}

/** Getter for {@link DirectedEnergyFirePdu#pulseRepititionFrequency}*/
public float getPulseRepititionFrequency()
{
    return pulseRepititionFrequency; 
}

/** Setter for {@link DirectedEnergyFirePdu#pulseWidth}*/
public DirectedEnergyFirePdu setPulseWidth(float pPulseWidth)
{
    pulseWidth = pPulseWidth;
    return this;
}

/** Getter for {@link DirectedEnergyFirePdu#pulseWidth}*/
public float getPulseWidth()
{
    return pulseWidth; 
}

/** Setter for {@link DirectedEnergyFirePdu#flags}*/
public DirectedEnergyFirePdu setFlags(DEFireFlags pFlags)
{
    flags = pFlags;
    return this;
}

/** Setter for {@link DirectedEnergyFirePdu#flags}*/
public DEFireFlags getFlags()
{
    return flags; 
}

/** Setter for {@link DirectedEnergyFirePdu#pulseShape}*/
public DirectedEnergyFirePdu setPulseShape(DEFirePulseShape pPulseShape)
{
    pulseShape = pPulseShape;
    return this;
}

/** Getter for {@link DirectedEnergyFirePdu#pulseShape}*/
public DEFirePulseShape getPulseShape()
{
    return pulseShape; 
}

/** Setter for {@link DirectedEnergyFirePdu#pad2}*/
public DirectedEnergyFirePdu setPad2(byte pPad2)
{
    pad2 = pPad2;
    return this;
}

/** Getter for {@link DirectedEnergyFirePdu#pad2}*/
public byte getPad2()
{
    return pad2; 
}

/** Setter for {@link DirectedEnergyFirePdu#pad3}*/
public DirectedEnergyFirePdu setPad3(int pPad3)
{
    pad3 = pPad3;
    return this;
}

/** Getter for {@link DirectedEnergyFirePdu#pad3}*/
public int getPad3()
{
    return pad3; 
}

/** Setter for {@link DirectedEnergyFirePdu#pad4}*/
public DirectedEnergyFirePdu setPad4(short pPad4)
{
    pad4 = pPad4;
    return this;
}

/** Getter for {@link DirectedEnergyFirePdu#pad4}*/
public short getPad4()
{
    return pad4; 
}

/** Setter for {@link DirectedEnergyFirePdu#dERecords}*/
public DirectedEnergyFirePdu setDERecords(List<StandardVariableSpecification> pDERecords)
{
    dERecords = pDERecords;
    return this;
}

/** Getter for {@link DirectedEnergyFirePdu#dERecords}*/
public List<StandardVariableSpecification> getDERecords()
{
    return dERecords; 
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
       firingEntityID.marshal(dos);
       eventID.marshal(dos);
       munitionType.marshal(dos);
       shotStartTime.marshal(dos);
       dos.writeFloat( (float)commulativeShotTime);
       apertureEmitterLocation.marshal(dos);
       dos.writeFloat( (float)apertureDiameter);
       dos.writeFloat( (float)wavelength);
       dos.writeInt( (int)pad1);
       dos.writeFloat( (float)pulseRepititionFrequency);
       dos.writeFloat( (float)pulseWidth);
       flags.marshal(dos);
       pulseShape.marshal(dos);
       dos.writeByte( (byte)pad2);
       dos.writeInt( (int)pad3);
       dos.writeShort( (short)pad4);
       dos.writeShort( (short)dERecords.size());

       for(int idx = 0; idx < dERecords.size(); idx++)
       {
            StandardVariableSpecification aStandardVariableSpecification = dERecords.get(idx);
            aStandardVariableSpecification.marshal(dos);
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
        uPosition += firingEntityID.unmarshal(dis);
        uPosition += eventID.unmarshal(dis);
        uPosition += munitionType.unmarshal(dis);
        uPosition += shotStartTime.unmarshal(dis);
        commulativeShotTime = dis.readFloat();
        uPosition += 4;
        uPosition += apertureEmitterLocation.unmarshal(dis);
        apertureDiameter = dis.readFloat();
        uPosition += 4;
        wavelength = dis.readFloat();
        uPosition += 4;
        pad1 = dis.readInt();
        uPosition += 4;
        pulseRepititionFrequency = dis.readFloat();
        uPosition += 4;
        pulseWidth = dis.readFloat();
        uPosition += 4;
        uPosition += flags.unmarshal(dis);
        pulseShape = DEFirePulseShape.unmarshalEnum(dis);
        uPosition += pulseShape.getMarshalledSize();
        pad2 = (byte)dis.readUnsignedByte();
        uPosition += 1;
        pad3 = dis.readInt();
        uPosition += 4;
        pad4 = (short)dis.readUnsignedShort();
        uPosition += 2;
        numberOfDERecords = (short)dis.readUnsignedShort();
        uPosition += 2;
        for(int idx = 0; idx < numberOfDERecords; idx++)
        {
            StandardVariableSpecification anX = new StandardVariableSpecification();
            uPosition += anX.unmarshal(dis);
            dERecords.add(anX);
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
   firingEntityID.marshal(buff);
   eventID.marshal(buff);
   munitionType.marshal(buff);
   shotStartTime.marshal(buff);
   buff.putFloat( (float)commulativeShotTime);
   apertureEmitterLocation.marshal(buff);
   buff.putFloat( (float)apertureDiameter);
   buff.putFloat( (float)wavelength);
   buff.putInt( (int)pad1);
   buff.putFloat( (float)pulseRepititionFrequency);
   buff.putFloat( (float)pulseWidth);
   flags.marshal(buff);
   pulseShape.marshal(buff);
   buff.put( (byte)pad2);
   buff.putInt( (int)pad3);
   buff.putShort( (short)pad4);
   buff.putShort( (short)dERecords.size());

   for(int idx = 0; idx < dERecords.size(); idx++)
   {
        StandardVariableSpecification aStandardVariableSpecification = (StandardVariableSpecification)dERecords.get(idx);
        aStandardVariableSpecification.marshal(buff);
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

    firingEntityID.unmarshal(buff);
    eventID.unmarshal(buff);
    munitionType.unmarshal(buff);
    shotStartTime.unmarshal(buff);
    commulativeShotTime = buff.getFloat();
    apertureEmitterLocation.unmarshal(buff);
    apertureDiameter = buff.getFloat();
    wavelength = buff.getFloat();
    pad1 = buff.getInt();
    pulseRepititionFrequency = buff.getFloat();
    pulseWidth = buff.getFloat();
    flags.unmarshal(buff);
    pulseShape = DEFirePulseShape.unmarshalEnum(buff);
    pad2 = (byte)(buff.get() & 0xFF);
    pad3 = buff.getInt();
    pad4 = (short)(buff.getShort() & 0xFFFF);
    numberOfDERecords = (short)(buff.getShort() & 0xFFFF);
    for(int idx = 0; idx < numberOfDERecords; idx++)
    {
    StandardVariableSpecification anX = new StandardVariableSpecification();
    anX.unmarshal(buff);
    dERecords.add(anX);
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

     final DirectedEnergyFirePdu rhs = (DirectedEnergyFirePdu)obj;

     if( ! (firingEntityID.equals( rhs.firingEntityID) )) ivarsEqual = false;
     if( ! (eventID.equals( rhs.eventID) )) ivarsEqual = false;
     if( ! (munitionType.equals( rhs.munitionType) )) ivarsEqual = false;
     if( ! (shotStartTime.equals( rhs.shotStartTime) )) ivarsEqual = false;
     if( ! (commulativeShotTime == rhs.commulativeShotTime)) ivarsEqual = false;
     if( ! (apertureEmitterLocation.equals( rhs.apertureEmitterLocation) )) ivarsEqual = false;
     if( ! (apertureDiameter == rhs.apertureDiameter)) ivarsEqual = false;
     if( ! (wavelength == rhs.wavelength)) ivarsEqual = false;
     if( ! (pad1 == rhs.pad1)) ivarsEqual = false;
     if( ! (pulseRepititionFrequency == rhs.pulseRepititionFrequency)) ivarsEqual = false;
     if( ! (pulseWidth == rhs.pulseWidth)) ivarsEqual = false;
     if( ! (flags.equals( rhs.flags) )) ivarsEqual = false;
     if( ! (pulseShape == rhs.pulseShape)) ivarsEqual = false;
     if( ! (pad2 == rhs.pad2)) ivarsEqual = false;
     if( ! (pad3 == rhs.pad3)) ivarsEqual = false;
     if( ! (pad4 == rhs.pad4)) ivarsEqual = false;

     for(int idx = 0; idx < dERecords.size(); idx++)
        if( ! ( dERecords.get(idx).equals(rhs.dERecords.get(idx)))) ivarsEqual = false;

    return ivarsEqual && super.equalsImpl(rhs);
 }

 @Override
 public String toString()
 {
    StringBuilder sb = new StringBuilder();
    sb.append(getClass().getSimpleName()+":\n");

    sb.append(" firingEntityID: ").append(firingEntityID).append("\n");
    sb.append(" eventID: ").append(eventID).append("\n");
    sb.append(" munitionType: ").append(munitionType).append("\n");
    sb.append(" shotStartTime: ").append(shotStartTime).append("\n");
    sb.append(" commulativeShotTime: ").append(commulativeShotTime).append("\n");
    sb.append(" apertureEmitterLocation: ").append(apertureEmitterLocation).append("\n");
    sb.append(" apertureDiameter: ").append(apertureDiameter).append("\n");
    sb.append(" wavelength: ").append(wavelength).append("\n");
    sb.append(" pad1: ").append(pad1).append("\n");
    sb.append(" pulseRepititionFrequency: ").append(pulseRepititionFrequency).append("\n");
    sb.append(" pulseWidth: ").append(pulseWidth).append("\n");
    sb.append(" flags: ").append(flags).append("\n");
    sb.append(" pulseShape: ").append(pulseShape).append("\n");
    sb.append(" pad2: ").append(pad2).append("\n");
    sb.append(" pad3: ").append(pad3).append("\n");
    sb.append(" pad4: ").append(pad4).append("\n");
    sb.append(" dERecords: ").append("\n");
    dERecords.forEach(r->{ sb.append(r.getClass().getSimpleName()).append(": ").append(r).append("\n");});

   return sb.toString();
 }
} // end of class
