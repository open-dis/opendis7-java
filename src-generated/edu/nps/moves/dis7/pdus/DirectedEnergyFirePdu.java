/**
 * Copyright (c) 2008-2023, MOVES Institute, Naval Postgraduate School (NPS). All rights reserved.
 * This work is provided under a BSD-style open-source license, see project
 * <a href="https://savage.nps.edu/opendis7-java/license.html" target="_blank">license.html</a> and <a href="https://savage.nps.edu/opendis7-java/license.txt" target="_blank">license.txt</a>
 */
// header autogenerated using string template dis7javalicense.txt



package edu.nps.moves.dis7.pdus;

import java.util.*;
import java.io.*;
import edu.nps.moves.dis7.enumerations.*;
import java.nio.ByteBuffer;

/**
 * 7.3.4 Used to communicate the firing of a directed energy weapon.
 * @see <a href="https://ieeexplore.ieee.org/document/6387564" target="_blank">IEEE Std 1278.1-2012, IEEE Standard for Distributed Interactive Simulation - Application Protocols</a> 
 */
public class DirectedEnergyFirePdu extends WarfareFamilyPdu implements Serializable
{

   /** The name of this PDU type */
   public static final String NAME = "DirectedEnergyFirePdu";
   
   /** ID of the entity that shot */
   protected EntityID  firingEntityID = new EntityID(); 

   /** eventID is an undescribed parameter... */
   protected EventIdentifier  eventID = new EventIdentifier(); 

   /** Field shall identify the munition type enumeration for the DE weapon beam, Section 7.3.4  */
   protected EntityType  munitionType = new EntityType(); 

   /** Field shall indicate the simulation time at start of the shot, Section 7.3.4  */
   protected ClockTime  shotStartTime = new ClockTime(); 

   /** Field shall indicate the current cumulative duration of the shot, Section 7.3.4  */
   protected float commulativeShotTime;

   /** Field shall identify the location of the DE weapon aperture/emitter, Section 7.3.4  */
   protected Vector3Float  apertureEmitterLocation = new Vector3Float(); 

   /** Field shall identify the beam diameter at the aperture/emitter, Section 7.3.4  */
   protected float apertureDiameter;

   /** Field shall identify the emissions wavelength in units of meters, Section 7.3.4  */
   protected float wavelength;

   /** pad1 is an undescribed parameter... */
   protected int pad1;

   /** pulseRepititionFrequency is an undescribed parameter... */
   protected float pulseRepititionFrequency;

   /** field shall identify the pulse width emissions in units of seconds, Section 7.3.4 */
   protected float pulseWidth;

   /** 16bit Boolean field shall contain various flags to indicate status information needed to process a DE, Section 7.3.4  uid 313 */
   protected DEFireFlags flags = new DEFireFlags();

   /** Field shall identify the pulse shape and shall be represented as an 8-bit enumeration, Section 7.3.4  uid 312 */
   protected DEFirePulseShape pulseShape = DEFirePulseShape.values()[0];

   /** pad2 is an undescribed parameter... */
   protected byte pad2;

   /** pad3 is an undescribed parameter... */
   protected int pad3;

   /** pad4 is an undescribed parameter... */
   protected short pad4;

   /** Field shall specify the number of DE records, Section 7.3.4  */
   protected short numberOfDERecords;

   /** Fields shall contain one or more DE records, records shall conform to the variable record format (Section6.2.82), Section 7.3.4 */
   protected List< StandardVariableSpecification > dERecords = new ArrayList<>();
 

/** Constructor creates and configures a new instance object */
 public DirectedEnergyFirePdu()
 {
    setPduType( DisPduType.DIRECTED_ENERGY_FIRE );
 }
/** copy method creates a deep copy of current object using preferred marshalling method
 * @return deep copy of PDU */
 public synchronized DirectedEnergyFirePdu copy()
 {
     return copyDataOutputStream();
 }
/** Creates a "deep copy" of current object using ByteBuffer methods.
 * @return deep copy of PDU */
 public synchronized DirectedEnergyFirePdu copyByteBuffer()
 {
     DirectedEnergyFirePdu newCopy = new DirectedEnergyFirePdu();
     ByteBuffer byteBuffer = ByteBuffer.allocate(400);
     try
     {
         this.marshal(byteBuffer);      // working
         newCopy.unmarshal(byteBuffer); // not working
     }
     catch (Exception e)
     {
         System.err.println("DirectedEnergyFirePdu deep copy() marshall/unmarshall ByteBuffer exception " + e.getMessage());
         e.printStackTrace(System.err);
         System.exit(-1); // TODO: Abruptly ending VM not a good practice
     }
     return newCopy;
 }

/** byteArrayOutputStream (baos) is used for marshal/unmarshal serialization
   * @see copyDataOutputStream() */
protected ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
/** dataOutputStream (dos) is used for marshal/unmarshal serialization
   * @see copyDataOutputStream() */
protected DataOutputStream      dataOutputStream      = new DataOutputStream(byteArrayOutputStream);

/** copy method creates a deep copy of current object using DataOutputStream methods.
 * @return deep copy of PDU */
 public synchronized DirectedEnergyFirePdu copyDataOutputStream()
 {
     DirectedEnergyFirePdu newCopy = new DirectedEnergyFirePdu();
     try
     {
         this.marshal(dataOutputStream);
         byte[] byteArrayDOS = byteArrayOutputStream.toByteArray();
         newCopy.unmarshal(ByteBuffer.wrap(byteArrayDOS));
     }
     catch (Exception e)
     {
         System.err.println("DirectedEnergyFirePdu deep copy() marshall/unmarshall DataOutputStream exception " + e.getMessage());
         e.printStackTrace(System.err);
         System.exit(-1); // TODO: Abruptly ending VM not a good practice
     }
        try
        {
                 dataOutputStream.flush();
            byteArrayOutputStream.flush();
            byteArrayOutputStream.reset();
        }
        catch (IOException ioe)
        {
            System.err.println("DirectedEnergyFirePdu copyDataOutputStream() flush IOException: " + ioe.getMessage());
        }
     return newCopy;
 }

  /**
   * Returns size of this serialized (marshalled) object in bytes
   * @see <a href="https://en.wikipedia.org/wiki/Marshalling_(computer_science)" target="_blank">https://en.wikipedia.org/wiki/Marshalling_(computer_science)</a>
   * @return serialized size in bytes
   */
@Override
public synchronized int getMarshalledSize()
{
   int marshalSize = 0; 

   marshalSize = super.getMarshalledSize();
   if (firingEntityID != null)
       marshalSize += firingEntityID.getMarshalledSize();
   if (eventID != null)
       marshalSize += eventID.getMarshalledSize();
   if (munitionType != null)
       marshalSize += munitionType.getMarshalledSize();
   if (shotStartTime != null)
       marshalSize += shotStartTime.getMarshalledSize();
   marshalSize += 4;  // commulativeShotTime
   if (apertureEmitterLocation != null)
       marshalSize += apertureEmitterLocation.getMarshalledSize();
   marshalSize += 4;  // apertureDiameter
   marshalSize += 4;  // wavelength
   marshalSize += 4;  // pad1
   marshalSize += 4;  // pulseRepititionFrequency
   marshalSize += 4;  // pulseWidth
   if (flags != null)
       marshalSize += flags.getMarshalledSize();
   if (pulseShape != null)
       marshalSize += pulseShape.getMarshalledSize();
   marshalSize += 1;  // pad2
   marshalSize += 4;  // pad3
   marshalSize += 2;  // pad4
   marshalSize += 2;  // numberOfDERecords
   if (dERecords != null)
       for (int idx=0; idx < dERecords.size(); idx++)
       {
            StandardVariableSpecification listElement = dERecords.get(idx);
            marshalSize += listElement.getMarshalledSize();
       }

   return marshalSize;
}


/** Setter for {@link DirectedEnergyFirePdu#firingEntityID}
  * @param pFiringEntityID new value of interest
  * @return same object to permit progressive setters */
public synchronized DirectedEnergyFirePdu setFiringEntityID(EntityID pFiringEntityID)
{
    firingEntityID = pFiringEntityID;
    return this;
}
/** Getter for {@link DirectedEnergyFirePdu#firingEntityID}
  * @return value of interest */
public EntityID getFiringEntityID()
{
    return firingEntityID;
}


/** Setter for {@link DirectedEnergyFirePdu#eventID}
  * @param pEventID new value of interest
  * @return same object to permit progressive setters */
public synchronized DirectedEnergyFirePdu setEventID(EventIdentifier pEventID)
{
    eventID = pEventID;
    return this;
}
/** Getter for {@link DirectedEnergyFirePdu#eventID}
  * @return value of interest */
public EventIdentifier getEventID()
{
    return eventID;
}


/** Setter for {@link DirectedEnergyFirePdu#munitionType}
  * @param pMunitionType new value of interest
  * @return same object to permit progressive setters */
public synchronized DirectedEnergyFirePdu setMunitionType(EntityType pMunitionType)
{
    munitionType = pMunitionType;
    return this;
}
/** Getter for {@link DirectedEnergyFirePdu#munitionType}
  * @return value of interest */
public EntityType getMunitionType()
{
    return munitionType;
}


/** Setter for {@link DirectedEnergyFirePdu#shotStartTime}
  * @param pShotStartTime new value of interest
  * @return same object to permit progressive setters */
public synchronized DirectedEnergyFirePdu setShotStartTime(ClockTime pShotStartTime)
{
    shotStartTime = pShotStartTime;
    return this;
}
/** Getter for {@link DirectedEnergyFirePdu#shotStartTime}
  * @return value of interest */
public ClockTime getShotStartTime()
{
    return shotStartTime;
}


/** Setter for {@link DirectedEnergyFirePdu#commulativeShotTime}
  * @param pCommulativeShotTime new value of interest
  * @return same object to permit progressive setters */
public synchronized DirectedEnergyFirePdu setCommulativeShotTime(float pCommulativeShotTime)
{
    commulativeShotTime = pCommulativeShotTime;
    return this;
}
/** Getter for {@link DirectedEnergyFirePdu#commulativeShotTime}
  * @return value of interest */
public float getCommulativeShotTime()
{
    return commulativeShotTime; 
}

/** Setter for {@link DirectedEnergyFirePdu#apertureEmitterLocation}
  * @param pApertureEmitterLocation new value of interest
  * @return same object to permit progressive setters */
public synchronized DirectedEnergyFirePdu setApertureEmitterLocation(Vector3Float pApertureEmitterLocation)
{
    apertureEmitterLocation = pApertureEmitterLocation;
    return this;
}
/** Getter for {@link DirectedEnergyFirePdu#apertureEmitterLocation}
  * @return value of interest */
public Vector3Float getApertureEmitterLocation()
{
    return apertureEmitterLocation;
}


/** Setter for {@link DirectedEnergyFirePdu#apertureDiameter}
  * @param pApertureDiameter new value of interest
  * @return same object to permit progressive setters */
public synchronized DirectedEnergyFirePdu setApertureDiameter(float pApertureDiameter)
{
    apertureDiameter = pApertureDiameter;
    return this;
}
/** Getter for {@link DirectedEnergyFirePdu#apertureDiameter}
  * @return value of interest */
public float getApertureDiameter()
{
    return apertureDiameter; 
}

/** Setter for {@link DirectedEnergyFirePdu#wavelength}
  * @param pWavelength new value of interest
  * @return same object to permit progressive setters */
public synchronized DirectedEnergyFirePdu setWavelength(float pWavelength)
{
    wavelength = pWavelength;
    return this;
}
/** Getter for {@link DirectedEnergyFirePdu#wavelength}
  * @return value of interest */
public float getWavelength()
{
    return wavelength; 
}

/** Setter for {@link DirectedEnergyFirePdu#pad1}
  * @param pPad1 new value of interest
  * @return same object to permit progressive setters */
public synchronized DirectedEnergyFirePdu setPad1(int pPad1)
{
    pad1 = pPad1;
    return this;
}
/** Getter for {@link DirectedEnergyFirePdu#pad1}
  * @return value of interest */
public int getPad1()
{
    return pad1; 
}

/** Setter for {@link DirectedEnergyFirePdu#pulseRepititionFrequency}
  * @param pPulseRepititionFrequency new value of interest
  * @return same object to permit progressive setters */
public synchronized DirectedEnergyFirePdu setPulseRepititionFrequency(float pPulseRepititionFrequency)
{
    pulseRepititionFrequency = pPulseRepititionFrequency;
    return this;
}
/** Getter for {@link DirectedEnergyFirePdu#pulseRepititionFrequency}
  * @return value of interest */
public float getPulseRepititionFrequency()
{
    return pulseRepititionFrequency; 
}

/** Setter for {@link DirectedEnergyFirePdu#pulseWidth}
  * @param pPulseWidth new value of interest
  * @return same object to permit progressive setters */
public synchronized DirectedEnergyFirePdu setPulseWidth(float pPulseWidth)
{
    pulseWidth = pPulseWidth;
    return this;
}
/** Getter for {@link DirectedEnergyFirePdu#pulseWidth}
  * @return value of interest */
public float getPulseWidth()
{
    return pulseWidth; 
}

/** Setter for {@link DirectedEnergyFirePdu#flags}
  * @param pFlags new value of interest
  * @return same object to permit progressive setters */
public synchronized DirectedEnergyFirePdu setFlags(DEFireFlags pFlags)
{
    flags = pFlags;
    return this;
}
/** Getter for {@link DirectedEnergyFirePdu#flags}
  * @return value of interest */
public DEFireFlags getFlags()
{
    return flags; 
}

/** Setter for {@link DirectedEnergyFirePdu#pulseShape}
  * @param pPulseShape new value of interest
  * @return same object to permit progressive setters */
public synchronized DirectedEnergyFirePdu setPulseShape(DEFirePulseShape pPulseShape)
{
    pulseShape = pPulseShape;
    return this;
}
/** Getter for {@link DirectedEnergyFirePdu#pulseShape}
  * @return value of interest */
public DEFirePulseShape getPulseShape()
{
    return pulseShape; 
}

/** Setter for {@link DirectedEnergyFirePdu#pad2}
  * @param pPad2 new value of interest
  * @return same object to permit progressive setters */
public synchronized DirectedEnergyFirePdu setPad2(byte pPad2)
{
    pad2 = pPad2;
    return this;
}
/** Utility setter for {@link DirectedEnergyFirePdu#pad2}
  * @param pPad2 new value of interest
  * @return same object to permit progressive setters */
public synchronized DirectedEnergyFirePdu setPad2(int pPad2){
    pad2 = (byte) pPad2;
    return this;
}
/** Getter for {@link DirectedEnergyFirePdu#pad2}
  * @return value of interest */
public byte getPad2()
{
    return pad2; 
}

/** Setter for {@link DirectedEnergyFirePdu#pad3}
  * @param pPad3 new value of interest
  * @return same object to permit progressive setters */
public synchronized DirectedEnergyFirePdu setPad3(int pPad3)
{
    pad3 = pPad3;
    return this;
}
/** Getter for {@link DirectedEnergyFirePdu#pad3}
  * @return value of interest */
public int getPad3()
{
    return pad3; 
}

/** Setter for {@link DirectedEnergyFirePdu#pad4}
  * @param pPad4 new value of interest
  * @return same object to permit progressive setters */
public synchronized DirectedEnergyFirePdu setPad4(short pPad4)
{
    pad4 = pPad4;
    return this;
}
/** Utility setter for {@link DirectedEnergyFirePdu#pad4}
  * @param pPad4 new value of interest
  * @return same object to permit progressive setters */
public synchronized DirectedEnergyFirePdu setPad4(int pPad4){
    pad4 = (short) pPad4;
    return this;
}
/** Getter for {@link DirectedEnergyFirePdu#pad4}
  * @return value of interest */
public short getPad4()
{
    return pad4; 
}

/** Setter for {@link DirectedEnergyFirePdu#dERecords}
  * @param pDERecords new value of interest
  * @return same object to permit progressive setters */
public synchronized DirectedEnergyFirePdu setDERecords(List<StandardVariableSpecification> pDERecords)
{
    dERecords = pDERecords;
    return this;
}
/** Getter for {@link DirectedEnergyFirePdu#dERecords}
  * @return value of interest */
public List<StandardVariableSpecification> getDERecords()
{
    return dERecords; 
}

/**
 * Serializes an object to a DataOutputStream.
 * @throws java.lang.Exception if something goes wrong
 * @see java.io.DataOutputStream
 * @param dos the OutputStream
 */
@Override
public synchronized void marshal(DataOutputStream dos) throws Exception
{
    super.marshal(dos);
    try 
    {
       firingEntityID.marshal(dos);
       eventID.marshal(dos);
       munitionType.marshal(dos);
       shotStartTime.marshal(dos);
       dos.writeFloat(commulativeShotTime);
       apertureEmitterLocation.marshal(dos);
       dos.writeFloat(apertureDiameter);
       dos.writeFloat(wavelength);
       dos.writeInt(pad1);
       dos.writeFloat(pulseRepititionFrequency);
       dos.writeFloat(pulseWidth);
       flags.marshal(dos);
       pulseShape.marshal(dos);
       dos.writeByte(pad2);
       dos.writeInt(pad3);
       dos.writeShort(pad4);
       dos.writeShort(dERecords.size());

       for (int idx = 0; idx < dERecords.size(); idx++)
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
 * Deserializes an object from a DataInputStream.
 * @throws java.lang.Exception if something goes wrong
 * @see java.io.DataInputStream
 * @see <a href="https://en.wikipedia.org/wiki/Marshalling_(computer_science)" target="_blank">https://en.wikipedia.org/wiki/Marshalling_(computer_science)</a>
 * @param dis the InputStream
 * @return marshalled serialized size in bytes
 */
@Override
public synchronized int unmarshal(DataInputStream dis) throws Exception
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
        for (int idx = 0; idx < numberOfDERecords; idx++)
        {
            StandardVariableSpecification anX = new StandardVariableSpecification();
            uPosition += anX.unmarshal(dis);
            dERecords.add(anX);
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
@Override
public synchronized void marshal(java.nio.ByteBuffer byteBuffer) throws Exception
{
   super.marshal(byteBuffer);
   firingEntityID.marshal(byteBuffer);
   eventID.marshal(byteBuffer);
   munitionType.marshal(byteBuffer);
   shotStartTime.marshal(byteBuffer);
   byteBuffer.putFloat( (float)commulativeShotTime);
   apertureEmitterLocation.marshal(byteBuffer);
   byteBuffer.putFloat( (float)apertureDiameter);
   byteBuffer.putFloat( (float)wavelength);
   byteBuffer.putInt( (int)pad1);
   byteBuffer.putFloat( (float)pulseRepititionFrequency);
   byteBuffer.putFloat( (float)pulseWidth);
   flags.marshal(byteBuffer);
   pulseShape.marshal(byteBuffer);
   byteBuffer.put( (byte)pad2);
   byteBuffer.putInt( (int)pad3);
   byteBuffer.putShort( (short)pad4);
   byteBuffer.putShort( (short)dERecords.size());

   for (int idx = 0; idx < dERecords.size(); idx++)
   {
        StandardVariableSpecification aStandardVariableSpecification = dERecords.get(idx);
        aStandardVariableSpecification.marshal(byteBuffer);
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
@Override
public synchronized int unmarshal(java.nio.ByteBuffer byteBuffer) throws Exception
{
    super.unmarshal(byteBuffer);

    try
    {
        // attribute firingEntityID marked as not serialized
        firingEntityID.unmarshal(byteBuffer);
        // attribute eventID marked as not serialized
        eventID.unmarshal(byteBuffer);
        // attribute munitionType marked as not serialized
        munitionType.unmarshal(byteBuffer);
        // attribute shotStartTime marked as not serialized
        shotStartTime.unmarshal(byteBuffer);
        // attribute commulativeShotTime marked as not serialized
        commulativeShotTime = byteBuffer.getFloat();
        // attribute apertureEmitterLocation marked as not serialized
        apertureEmitterLocation.unmarshal(byteBuffer);
        // attribute apertureDiameter marked as not serialized
        apertureDiameter = byteBuffer.getFloat();
        // attribute wavelength marked as not serialized
        wavelength = byteBuffer.getFloat();
        // attribute pad1 marked as not serialized
        pad1 = byteBuffer.getInt();
        // attribute pulseRepititionFrequency marked as not serialized
        pulseRepititionFrequency = byteBuffer.getFloat();
        // attribute pulseWidth marked as not serialized
        pulseWidth = byteBuffer.getFloat();
        // attribute flags marked as not serialized
        flags.unmarshal(byteBuffer);
        // attribute pulseShape marked as not serialized
        pulseShape = DEFirePulseShape.unmarshalEnum(byteBuffer);
        // attribute pad2 marked as not serialized
        pad2 = (byte)(byteBuffer.get() & 0xFF);
        // attribute pad3 marked as not serialized
        pad3 = byteBuffer.getInt();
        // attribute pad4 marked as not serialized
        pad4 = (short)(byteBuffer.getShort() & 0xFFFF);
        // attribute numberOfDERecords marked as not serialized
        numberOfDERecords = (short)(byteBuffer.getShort() & 0xFFFF);
        // attribute dERecords marked as not serialized
        for (int idx = 0; idx < numberOfDERecords; idx++)
        {
        StandardVariableSpecification anX = new StandardVariableSpecification();
        anX.unmarshal(byteBuffer);
        dERecords.add(anX);
        }

    }
    catch (java.nio.BufferUnderflowException bue)
    {
        System.err.println("*** buffer underflow error while unmarshalling " + this.getClass().getName());
    }
    return getMarshalledSize();
}

 /*
  * Override of default equals method.  Calls equalsImpl() for content comparison.
  */
@Override
 public synchronized boolean equals(Object obj)
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
 public synchronized boolean equalsImpl(Object obj)
 {
     final DirectedEnergyFirePdu rhs = (DirectedEnergyFirePdu)obj;

     if( ! Objects.equals(firingEntityID, rhs.firingEntityID) ) return false;
     if( ! Objects.equals(eventID, rhs.eventID) ) return false;
     if( ! Objects.equals(munitionType, rhs.munitionType) ) return false;
     if( ! Objects.equals(shotStartTime, rhs.shotStartTime) ) return false;
     if( ! (commulativeShotTime == rhs.commulativeShotTime)) return false;
     if( ! Objects.equals(apertureEmitterLocation, rhs.apertureEmitterLocation) ) return false;
     if( ! (apertureDiameter == rhs.apertureDiameter)) return false;
     if( ! (wavelength == rhs.wavelength)) return false;
     if( ! (pad1 == rhs.pad1)) return false;
     if( ! (pulseRepititionFrequency == rhs.pulseRepititionFrequency)) return false;
     if( ! (pulseWidth == rhs.pulseWidth)) return false;
     if( ! Objects.equals(flags, rhs.flags) ) return false;
     if( ! (pulseShape == rhs.pulseShape)) return false;
     if( ! (pad2 == rhs.pad2)) return false;
     if( ! (pad3 == rhs.pad3)) return false;
     if( ! (pad4 == rhs.pad4)) return false;
     if( ! Objects.equals(dERecords, rhs.dERecords) ) return false;
    return super.equalsImpl(rhs);
 }

 @Override
 public synchronized String toString()
 {
    StringBuilder sb  = new StringBuilder();
    StringBuilder sb2 = new StringBuilder();
    sb.append(getClass().getSimpleName());
    sb.append(" firingEntityID:").append(firingEntityID); // writeOneToString
    sb.append(" eventID:").append(eventID); // writeOneToString
    sb.append(" munitionType:").append(munitionType); // writeOneToString
    sb.append(" shotStartTime:").append(shotStartTime); // writeOneToString
    sb.append(" commulativeShotTime:").append(commulativeShotTime); // writeOneToString
    sb.append(" apertureEmitterLocation:").append(apertureEmitterLocation); // writeOneToString
    sb.append(" apertureDiameter:").append(apertureDiameter); // writeOneToString
    sb.append(" wavelength:").append(wavelength); // writeOneToString
    sb.append(" pad1:").append(pad1); // writeOneToString
    sb.append(" pulseRepititionFrequency:").append(pulseRepititionFrequency); // writeOneToString
    sb.append(" pulseWidth:").append(pulseWidth); // writeOneToString
    sb.append(" flags:").append(flags); // writeOneToString
    sb.append(" pulseShape:").append(pulseShape); // writeOneToString
    sb.append(" pad2:").append(pad2); // writeOneToString
    sb.append(" pad3:").append(pad3); // writeOneToString
    sb.append(" pad4:").append(pad4); // writeOneToString
    sb.append(" dERecords: ");
    dERecords.forEach(r->{ sb2.append(" ").append(r);}); // writeList
    sb.append(sb2.toString().trim());
    // https://stackoverflow.com/questions/2242471/clearing-a-string-buffer-builder-after-loop
    sb2.setLength(0); // reset

   return sb.toString();
 }

 @Override
 public int hashCode()
 {
	 return Objects.hash(this.firingEntityID,
	                     this.eventID,
	                     this.munitionType,
	                     this.shotStartTime,
	                     this.commulativeShotTime,
	                     this.apertureEmitterLocation,
	                     this.apertureDiameter,
	                     this.wavelength,
	                     this.pad1,
	                     this.pulseRepititionFrequency,
	                     this.pulseWidth,
	                     this.flags,
	                     this.pulseShape,
	                     this.pad2,
	                     this.pad3,
	                     this.pad4,
	                     this.numberOfDERecords,
	                     this.dERecords);
 }
} // end of DirectedEnergyFirePdu
