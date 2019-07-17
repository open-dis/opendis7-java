package edu.nps.moves.dis;

import java.util.*;
import java.io.*;
import edu.nps.moves.dis.enumerations.*;


/**
 *  Information about underwater acoustic emmissions. This requires manual cleanup.  The beam data records should ALL be a the finish, rather than attached to each emitter system. Section 7.6.4. UNFINISHED
 *
 * Copyright (c) 2008-2019, MOVES Institute, Naval Postgraduate School. All rights reserved.
 * This work is licensed under the BSD open source license, available at https://www.movesinstitute.org/licenses/bsd.html
 *
 * @author DMcG
 */
public class UnderwaterAcousticPdu extends DistributedEmissionsFamilyPdu implements Serializable
{
   /** ID of the entity that is the source of the emission */
   protected EntityID  emittingEntityID = new EntityID(); 

   /** ID of event */
   protected EventIdentifier  eventID = new EventIdentifier(); 

   /** This field shall be used to indicate whether the data in the UA PDU represent a state update or data that have changed since issuance of the last UA PDU uid 143 */
   protected UAStateChangeUpdateIndicator stateChangeIndicator = UAStateChangeUpdateIndicator.values()[0];

   /** padding */
   protected byte  pad;

   /** This field indicates which database record (or file) shall be used in the definition of passive signature (unintentional) emissions of the entity. The indicated database record (or  file) shall define all noise generated as a function of propulsion plant configurations and associated  auxiliaries. uid 148 */
   protected UAPassiveParameterIndex passiveParameterIndex = UAPassiveParameterIndex.values()[0];

   /** This field shall specify the entity propulsion plant configuration. This field is used to determine the passive signature characteristics of an entity. */
   protected byte  propulsionPlantConfiguration;

   /**  This field shall represent the number of shafts on a platform */
   protected byte  numberOfShafts;

   /** This field shall indicate the number of APAs described in the current UA PDU */
   protected byte  numberOfAPAs;

   /** This field shall specify the number of UA emitter systems being described in the current UA PDU */
   protected byte  numberOfUAEmitterSystems;

   /** shaft RPM values. */
   protected List< ShaftRPM > shaftRPMs = new ArrayList< ShaftRPM >();
 
   /** additional passive activities */
   protected List< APA > apaData = new ArrayList< APA >();
 
   protected List< UAEmitter > emitterSystems = new ArrayList< UAEmitter >();
 

/** Constructor */
 public UnderwaterAcousticPdu()
 {
    setPduType( DISPDUType.UNDERWATER_ACOUSTIC );
 }

public int getMarshalledSize()
{
   int marshalSize = 0; 

   marshalSize = super.getMarshalledSize();
   marshalSize += emittingEntityID.getMarshalledSize();
   marshalSize += eventID.getMarshalledSize();
   marshalSize += stateChangeIndicator.getMarshalledSize();
   marshalSize += 1;  // pad
   marshalSize += passiveParameterIndex.getMarshalledSize();
   marshalSize += 1;  // propulsionPlantConfiguration
   marshalSize += 1;  // numberOfShafts
   marshalSize += 1;  // numberOfAPAs
   marshalSize += 1;  // numberOfUAEmitterSystems
   for(int idx=0; idx < shaftRPMs.size(); idx++)
   {
        ShaftRPM listElement = shaftRPMs.get(idx);
        marshalSize += listElement.getMarshalledSize();
   }
   for(int idx=0; idx < apaData.size(); idx++)
   {
        APA listElement = apaData.get(idx);
        marshalSize += listElement.getMarshalledSize();
   }
   for(int idx=0; idx < emitterSystems.size(); idx++)
   {
        UAEmitter listElement = emitterSystems.get(idx);
        marshalSize += listElement.getMarshalledSize();
   }

   return marshalSize;
}


public UnderwaterAcousticPdu setEmittingEntityID(EntityID pEmittingEntityID)
{
    emittingEntityID = pEmittingEntityID;
    return this;
}

public EntityID getEmittingEntityID()
{
    return emittingEntityID; 
}

public UnderwaterAcousticPdu setEventID(EventIdentifier pEventID)
{
    eventID = pEventID;
    return this;
}

public EventIdentifier getEventID()
{
    return eventID; 
}

public UnderwaterAcousticPdu setStateChangeIndicator(UAStateChangeUpdateIndicator pStateChangeIndicator)
{
    stateChangeIndicator = pStateChangeIndicator;
    return this;
}

public UAStateChangeUpdateIndicator getStateChangeIndicator()
{
    return stateChangeIndicator; 
}

public UnderwaterAcousticPdu setPad(byte pPad)
{
    pad = pPad;
    return this;
}

public byte getPad()
{
    return pad; 
}

public UnderwaterAcousticPdu setPassiveParameterIndex(UAPassiveParameterIndex pPassiveParameterIndex)
{
    passiveParameterIndex = pPassiveParameterIndex;
    return this;
}

public UAPassiveParameterIndex getPassiveParameterIndex()
{
    return passiveParameterIndex; 
}

public UnderwaterAcousticPdu setPropulsionPlantConfiguration(byte pPropulsionPlantConfiguration)
{
    propulsionPlantConfiguration = pPropulsionPlantConfiguration;
    return this;
}

public byte getPropulsionPlantConfiguration()
{
    return propulsionPlantConfiguration; 
}

public UnderwaterAcousticPdu setShaftRPMs(List<ShaftRPM> pShaftRPMs)
{
    shaftRPMs = pShaftRPMs;
    return this;
}

public List<ShaftRPM> getShaftRPMs()
{
    return shaftRPMs; 
}

public UnderwaterAcousticPdu setApaData(List<APA> pApaData)
{
    apaData = pApaData;
    return this;
}

public List<APA> getApaData()
{
    return apaData; 
}

public UnderwaterAcousticPdu setEmitterSystems(List<UAEmitter> pEmitterSystems)
{
    emitterSystems = pEmitterSystems;
    return this;
}

public List<UAEmitter> getEmitterSystems()
{
    return emitterSystems; 
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
       emittingEntityID.marshal(dos);
       eventID.marshal(dos);
       stateChangeIndicator.marshal(dos);
       dos.writeByte( (byte)pad);
       passiveParameterIndex.marshal(dos);
       dos.writeByte( (byte)propulsionPlantConfiguration);
       dos.writeByte( (byte)shaftRPMs.size());
       dos.writeByte( (byte)apaData.size());
       dos.writeByte( (byte)emitterSystems.size());

       for(int idx = 0; idx < shaftRPMs.size(); idx++)
       {
            ShaftRPM aShaftRPM = shaftRPMs.get(idx);
            aShaftRPM.marshal(dos);
       }


       for(int idx = 0; idx < apaData.size(); idx++)
       {
            APA aAPA = apaData.get(idx);
            aAPA.marshal(dos);
       }


       for(int idx = 0; idx < emitterSystems.size(); idx++)
       {
            UAEmitter aUAEmitter = emitterSystems.get(idx);
            aUAEmitter.marshal(dos);
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
        uPosition += emittingEntityID.unmarshal(dis);
        uPosition += eventID.unmarshal(dis);
        stateChangeIndicator = UAStateChangeUpdateIndicator.unmarshalEnum(dis);
        uPosition += stateChangeIndicator.getMarshalledSize();
        pad = (byte)dis.readUnsignedByte();
        uPosition += 1;
        passiveParameterIndex = UAPassiveParameterIndex.unmarshalEnum(dis);
        uPosition += passiveParameterIndex.getMarshalledSize();
        propulsionPlantConfiguration = (byte)dis.readUnsignedByte();
        uPosition += 1;
        numberOfShafts = (byte)dis.readUnsignedByte();
        uPosition += 1;
        numberOfAPAs = (byte)dis.readUnsignedByte();
        uPosition += 1;
        numberOfUAEmitterSystems = (byte)dis.readUnsignedByte();
        uPosition += 1;
        for(int idx = 0; idx < numberOfShafts; idx++)
        {
            ShaftRPM anX = new ShaftRPM();
            uPosition += anX.unmarshal(dis);
            shaftRPMs.add(anX);
        }

        for(int idx = 0; idx < numberOfAPAs; idx++)
        {
            APA anX = new APA();
            uPosition += anX.unmarshal(dis);
            apaData.add(anX);
        }

        for(int idx = 0; idx < numberOfUAEmitterSystems; idx++)
        {
            UAEmitter anX = new UAEmitter();
            uPosition += anX.unmarshal(dis);
            emitterSystems.add(anX);
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
   emittingEntityID.marshal(buff);
   eventID.marshal(buff);
   stateChangeIndicator.marshal(buff);
   buff.put( (byte)pad);
   passiveParameterIndex.marshal(buff);
   buff.put( (byte)propulsionPlantConfiguration);
   buff.put( (byte)shaftRPMs.size());
   buff.put( (byte)apaData.size());
   buff.put( (byte)emitterSystems.size());

   for(int idx = 0; idx < shaftRPMs.size(); idx++)
   {
        ShaftRPM aShaftRPM = (ShaftRPM)shaftRPMs.get(idx);
        aShaftRPM.marshal(buff);
   }


   for(int idx = 0; idx < apaData.size(); idx++)
   {
        APA aAPA = (APA)apaData.get(idx);
        aAPA.marshal(buff);
   }


   for(int idx = 0; idx < emitterSystems.size(); idx++)
   {
        UAEmitter aUAEmitter = (UAEmitter)emitterSystems.get(idx);
        aUAEmitter.marshal(buff);
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

    emittingEntityID.unmarshal(buff);
    eventID.unmarshal(buff);
    stateChangeIndicator = UAStateChangeUpdateIndicator.unmarshalEnum(buff);
    pad = (byte)(buff.get() & 0xFF);
    passiveParameterIndex = UAPassiveParameterIndex.unmarshalEnum(buff);
    propulsionPlantConfiguration = (byte)(buff.get() & 0xFF);
    numberOfShafts = (byte)(buff.get() & 0xFF);
    numberOfAPAs = (byte)(buff.get() & 0xFF);
    numberOfUAEmitterSystems = (byte)(buff.get() & 0xFF);
    for(int idx = 0; idx < numberOfShafts; idx++)
    {
    ShaftRPM anX = new ShaftRPM();
    anX.unmarshal(buff);
    shaftRPMs.add(anX);
    }

    for(int idx = 0; idx < numberOfAPAs; idx++)
    {
    APA anX = new APA();
    anX.unmarshal(buff);
    apaData.add(anX);
    }

    for(int idx = 0; idx < numberOfUAEmitterSystems; idx++)
    {
    UAEmitter anX = new UAEmitter();
    anX.unmarshal(buff);
    emitterSystems.add(anX);
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

    if(!(obj instanceof UnderwaterAcousticPdu))
        return false;

     final UnderwaterAcousticPdu rhs = (UnderwaterAcousticPdu)obj;

     if( ! (emittingEntityID.equals( rhs.emittingEntityID) )) ivarsEqual = false;
     if( ! (eventID.equals( rhs.eventID) )) ivarsEqual = false;
     if( ! (stateChangeIndicator == rhs.stateChangeIndicator)) ivarsEqual = false;
     if( ! (pad == rhs.pad)) ivarsEqual = false;
     if( ! (passiveParameterIndex == rhs.passiveParameterIndex)) ivarsEqual = false;
     if( ! (propulsionPlantConfiguration == rhs.propulsionPlantConfiguration)) ivarsEqual = false;
     if( ! (numberOfShafts == rhs.numberOfShafts)) ivarsEqual = false;
     if( ! (numberOfAPAs == rhs.numberOfAPAs)) ivarsEqual = false;
     if( ! (numberOfUAEmitterSystems == rhs.numberOfUAEmitterSystems)) ivarsEqual = false;

     for(int idx = 0; idx < shaftRPMs.size(); idx++)
        if( ! ( shaftRPMs.get(idx).equals(rhs.shaftRPMs.get(idx)))) ivarsEqual = false;


     for(int idx = 0; idx < apaData.size(); idx++)
        if( ! ( apaData.get(idx).equals(rhs.apaData.get(idx)))) ivarsEqual = false;


     for(int idx = 0; idx < emitterSystems.size(); idx++)
        if( ! ( emitterSystems.get(idx).equals(rhs.emitterSystems.get(idx)))) ivarsEqual = false;

    return ivarsEqual && super.equalsImpl(rhs);
 }
} // end of class
