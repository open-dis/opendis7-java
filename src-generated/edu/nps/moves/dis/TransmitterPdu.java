/**
 * Copyright (c) 2008-2019, MOVES Institute, Naval Postgraduate School. All rights reserved.
 * This work is licensed under the BSD open source license, available at https://www.movesinstitute.org/licenses/bsd.html
 */

package edu.nps.moves.dis;

import java.util.*;
import java.io.*;
import edu.nps.moves.dis.enumerations.*;

/**
 * 5.8.3 Communicates the state of a particular radio transmitter or simple intercom.
 * IEEE Std 1278.1-2012, IEEE Standard for Distributed Interactive Simulation—Application Protocols
 */
public class TransmitterPdu extends RadioCommunicationsFamilyPdu implements Serializable
{
   protected RadioCommsHeader  header = new RadioCommsHeader(); 

   /** particular radio within an entity */
   protected short  radioNumber;

   /** Type of radio */
   protected RadioType  radioEntityType = new RadioType(); 

   /** transmit state uid 164 */
   protected TransmitterTransmitState transmitState = TransmitterTransmitState.values()[0];

   /** input source uid 165 */
   protected TransmitterInputSource inputSource = TransmitterInputSource.values()[0];

   /** count field */
   protected short  variableTransmitterParameterCount;

   /** Location of antenna */
   protected Vector3Double  antennaLocation = new Vector3Double(); 

   /** relative location of antenna */
   protected Vector3Float  relativeAntennaLocation = new Vector3Float(); 

   /** antenna pattern type uid 167 */
   protected TransmitterAntennaPatternType antennaPatternType = TransmitterAntennaPatternType.values()[0];

   /** atenna pattern length */
   protected short  antennaPatternCount;

   /** frequency */
   protected long  frequency;

   /** transmit frequency Bandwidth */
   protected float  transmitFrequencyBandwidth;

   /** transmission power */
   protected float  power;

   /** modulation */
   protected ModulationType  modulationType = new ModulationType(); 

   /** crypto system enumeration uid 166 */
   protected TransmitterCryptoSystem cryptoSystem = TransmitterCryptoSystem.values()[0];

   /** crypto system key identifer */
   protected short  cryptoKeyId;

   /** how many modulation parameters we have */
   protected byte  modulationParameterCount;

   protected byte  padding1 = (byte)0;

   protected short  padding2 = (short)0;

   /** variable length list of modulation parameters */
   protected List< ModulationParameters > modulationParametersList = new ArrayList< ModulationParameters >();
 
   /** variable length list of antenna pattern records */
   protected List< VariableTransmitterParameters > antennaPatternList = new ArrayList< VariableTransmitterParameters >();
 

/** Constructor */
 public TransmitterPdu()
 {
    setPduType( DISPDUType.TRANSMITTER );
 }

public int getMarshalledSize()
{
   int marshalSize = 0; 

   marshalSize = super.getMarshalledSize();
   marshalSize += header.getMarshalledSize();
   marshalSize += 2;  // radioNumber
   marshalSize += radioEntityType.getMarshalledSize();
   marshalSize += transmitState.getMarshalledSize();
   marshalSize += inputSource.getMarshalledSize();
   marshalSize += 2;  // variableTransmitterParameterCount
   marshalSize += antennaLocation.getMarshalledSize();
   marshalSize += relativeAntennaLocation.getMarshalledSize();
   marshalSize += antennaPatternType.getMarshalledSize();
   marshalSize += 2;  // antennaPatternCount
   marshalSize += 8;  // frequency
   marshalSize += 4;  // transmitFrequencyBandwidth
   marshalSize += 4;  // power
   marshalSize += modulationType.getMarshalledSize();
   marshalSize += cryptoSystem.getMarshalledSize();
   marshalSize += 2;  // cryptoKeyId
   marshalSize += 1;  // modulationParameterCount
   marshalSize += 1;  // padding1
   marshalSize += 2;  // padding2
   for(int idx=0; idx < modulationParametersList.size(); idx++)
   {
        ModulationParameters listElement = modulationParametersList.get(idx);
        marshalSize += listElement.getMarshalledSize();
   }
   for(int idx=0; idx < antennaPatternList.size(); idx++)
   {
        VariableTransmitterParameters listElement = antennaPatternList.get(idx);
        marshalSize += listElement.getMarshalledSize();
   }

   return marshalSize;
}


public TransmitterPdu setHeader(RadioCommsHeader pHeader)
{
    header = pHeader;
    return this;
}

public RadioCommsHeader getHeader()
{
    return header; 
}

public TransmitterPdu setRadioNumber(short pRadioNumber)
{
    radioNumber = pRadioNumber;
    return this;
}

public short getRadioNumber()
{
    return radioNumber; 
}

public TransmitterPdu setRadioEntityType(RadioType pRadioEntityType)
{
    radioEntityType = pRadioEntityType;
    return this;
}

public RadioType getRadioEntityType()
{
    return radioEntityType; 
}

public TransmitterPdu setTransmitState(TransmitterTransmitState pTransmitState)
{
    transmitState = pTransmitState;
    return this;
}

public TransmitterTransmitState getTransmitState()
{
    return transmitState; 
}

public TransmitterPdu setInputSource(TransmitterInputSource pInputSource)
{
    inputSource = pInputSource;
    return this;
}

public TransmitterInputSource getInputSource()
{
    return inputSource; 
}

public TransmitterPdu setVariableTransmitterParameterCount(short pVariableTransmitterParameterCount)
{
    variableTransmitterParameterCount = pVariableTransmitterParameterCount;
    return this;
}

public short getVariableTransmitterParameterCount()
{
    return variableTransmitterParameterCount; 
}

public TransmitterPdu setAntennaLocation(Vector3Double pAntennaLocation)
{
    antennaLocation = pAntennaLocation;
    return this;
}

public Vector3Double getAntennaLocation()
{
    return antennaLocation; 
}

public TransmitterPdu setRelativeAntennaLocation(Vector3Float pRelativeAntennaLocation)
{
    relativeAntennaLocation = pRelativeAntennaLocation;
    return this;
}

public Vector3Float getRelativeAntennaLocation()
{
    return relativeAntennaLocation; 
}

public TransmitterPdu setAntennaPatternType(TransmitterAntennaPatternType pAntennaPatternType)
{
    antennaPatternType = pAntennaPatternType;
    return this;
}

public TransmitterAntennaPatternType getAntennaPatternType()
{
    return antennaPatternType; 
}

public TransmitterPdu setFrequency(long pFrequency)
{
    frequency = pFrequency;
    return this;
}

public long getFrequency()
{
    return frequency; 
}

public TransmitterPdu setTransmitFrequencyBandwidth(float pTransmitFrequencyBandwidth)
{
    transmitFrequencyBandwidth = pTransmitFrequencyBandwidth;
    return this;
}

public float getTransmitFrequencyBandwidth()
{
    return transmitFrequencyBandwidth; 
}

public TransmitterPdu setPower(float pPower)
{
    power = pPower;
    return this;
}

public float getPower()
{
    return power; 
}

public TransmitterPdu setModulationType(ModulationType pModulationType)
{
    modulationType = pModulationType;
    return this;
}

public ModulationType getModulationType()
{
    return modulationType; 
}

public TransmitterPdu setCryptoSystem(TransmitterCryptoSystem pCryptoSystem)
{
    cryptoSystem = pCryptoSystem;
    return this;
}

public TransmitterCryptoSystem getCryptoSystem()
{
    return cryptoSystem; 
}

public TransmitterPdu setCryptoKeyId(short pCryptoKeyId)
{
    cryptoKeyId = pCryptoKeyId;
    return this;
}

public short getCryptoKeyId()
{
    return cryptoKeyId; 
}

public TransmitterPdu setPadding1(byte pPadding1)
{
    padding1 = pPadding1;
    return this;
}

public byte getPadding1()
{
    return padding1; 
}

public TransmitterPdu setPadding2(short pPadding2)
{
    padding2 = pPadding2;
    return this;
}

public short getPadding2()
{
    return padding2; 
}

public TransmitterPdu setModulationParametersList(List<ModulationParameters> pModulationParametersList)
{
    modulationParametersList = pModulationParametersList;
    return this;
}

public List<ModulationParameters> getModulationParametersList()
{
    return modulationParametersList; 
}

public TransmitterPdu setAntennaPatternList(List<VariableTransmitterParameters> pAntennaPatternList)
{
    antennaPatternList = pAntennaPatternList;
    return this;
}

public List<VariableTransmitterParameters> getAntennaPatternList()
{
    return antennaPatternList; 
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
       header.marshal(dos);
       dos.writeShort( (short)radioNumber);
       radioEntityType.marshal(dos);
       transmitState.marshal(dos);
       inputSource.marshal(dos);
       dos.writeShort( (short)variableTransmitterParameterCount);
       antennaLocation.marshal(dos);
       relativeAntennaLocation.marshal(dos);
       antennaPatternType.marshal(dos);
       dos.writeShort( (short)antennaPatternList.size());
       dos.writeLong( (long)frequency);
       dos.writeFloat( (float)transmitFrequencyBandwidth);
       dos.writeFloat( (float)power);
       modulationType.marshal(dos);
       cryptoSystem.marshal(dos);
       dos.writeShort( (short)cryptoKeyId);
       dos.writeByte( (byte)modulationParametersList.size());
       dos.writeByte( (byte)padding1);
       dos.writeShort( (short)padding2);

       for(int idx = 0; idx < modulationParametersList.size(); idx++)
       {
            ModulationParameters aModulationParameters = modulationParametersList.get(idx);
            aModulationParameters.marshal(dos);
       }


       for(int idx = 0; idx < antennaPatternList.size(); idx++)
       {
            VariableTransmitterParameters aVariableTransmitterParameters = antennaPatternList.get(idx);
            aVariableTransmitterParameters.marshal(dos);
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
        uPosition += header.unmarshal(dis);
        radioNumber = (short)dis.readUnsignedShort();
        uPosition += 2;
        uPosition += radioEntityType.unmarshal(dis);
        transmitState = TransmitterTransmitState.unmarshalEnum(dis);
        uPosition += transmitState.getMarshalledSize();
        inputSource = TransmitterInputSource.unmarshalEnum(dis);
        uPosition += inputSource.getMarshalledSize();
        variableTransmitterParameterCount = (short)dis.readUnsignedShort();
        uPosition += 2;
        uPosition += antennaLocation.unmarshal(dis);
        uPosition += relativeAntennaLocation.unmarshal(dis);
        antennaPatternType = TransmitterAntennaPatternType.unmarshalEnum(dis);
        uPosition += antennaPatternType.getMarshalledSize();
        antennaPatternCount = (short)dis.readUnsignedShort();
        uPosition += 2;
        frequency = dis.readLong();
        uPosition += 4;
        transmitFrequencyBandwidth = dis.readFloat();
        uPosition += 4;
        power = dis.readFloat();
        uPosition += 4;
        uPosition += modulationType.unmarshal(dis);
        cryptoSystem = TransmitterCryptoSystem.unmarshalEnum(dis);
        uPosition += cryptoSystem.getMarshalledSize();
        cryptoKeyId = (short)dis.readUnsignedShort();
        uPosition += 2;
        modulationParameterCount = (byte)dis.readUnsignedByte();
        uPosition += 1;
        padding1 = (byte)dis.readUnsignedByte();
        uPosition += 1;
        padding2 = (short)dis.readUnsignedShort();
        uPosition += 2;
        for(int idx = 0; idx < modulationParameterCount; idx++)
        {
            ModulationParameters anX = new ModulationParameters();
            uPosition += anX.unmarshal(dis);
            modulationParametersList.add(anX);
        }

        for(int idx = 0; idx < antennaPatternCount; idx++)
        {
            VariableTransmitterParameters anX = new VariableTransmitterParameters();
            uPosition += anX.unmarshal(dis);
            antennaPatternList.add(anX);
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
   header.marshal(buff);
   buff.putShort( (short)radioNumber);
   radioEntityType.marshal(buff);
   transmitState.marshal(buff);
   inputSource.marshal(buff);
   buff.putShort( (short)variableTransmitterParameterCount);
   antennaLocation.marshal(buff);
   relativeAntennaLocation.marshal(buff);
   antennaPatternType.marshal(buff);
   buff.putShort( (short)antennaPatternList.size());
   buff.putLong( (long)frequency);
   buff.putFloat( (float)transmitFrequencyBandwidth);
   buff.putFloat( (float)power);
   modulationType.marshal(buff);
   cryptoSystem.marshal(buff);
   buff.putShort( (short)cryptoKeyId);
   buff.put( (byte)modulationParametersList.size());
   buff.put( (byte)padding1);
   buff.putShort( (short)padding2);

   for(int idx = 0; idx < modulationParametersList.size(); idx++)
   {
        ModulationParameters aModulationParameters = (ModulationParameters)modulationParametersList.get(idx);
        aModulationParameters.marshal(buff);
   }


   for(int idx = 0; idx < antennaPatternList.size(); idx++)
   {
        VariableTransmitterParameters aVariableTransmitterParameters = (VariableTransmitterParameters)antennaPatternList.get(idx);
        aVariableTransmitterParameters.marshal(buff);
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

    header.unmarshal(buff);
    radioNumber = (short)(buff.getShort() & 0xFFFF);
    radioEntityType.unmarshal(buff);
    transmitState = TransmitterTransmitState.unmarshalEnum(buff);
    inputSource = TransmitterInputSource.unmarshalEnum(buff);
    variableTransmitterParameterCount = (short)(buff.getShort() & 0xFFFF);
    antennaLocation.unmarshal(buff);
    relativeAntennaLocation.unmarshal(buff);
    antennaPatternType = TransmitterAntennaPatternType.unmarshalEnum(buff);
    antennaPatternCount = (short)(buff.getShort() & 0xFFFF);
    frequency = buff.getLong();
    transmitFrequencyBandwidth = buff.getFloat();
    power = buff.getFloat();
    modulationType.unmarshal(buff);
    cryptoSystem = TransmitterCryptoSystem.unmarshalEnum(buff);
    cryptoKeyId = (short)(buff.getShort() & 0xFFFF);
    modulationParameterCount = (byte)(buff.get() & 0xFF);
    padding1 = (byte)(buff.get() & 0xFF);
    padding2 = (short)(buff.getShort() & 0xFFFF);
    for(int idx = 0; idx < modulationParameterCount; idx++)
    {
    ModulationParameters anX = new ModulationParameters();
    anX.unmarshal(buff);
    modulationParametersList.add(anX);
    }

    for(int idx = 0; idx < antennaPatternCount; idx++)
    {
    VariableTransmitterParameters anX = new VariableTransmitterParameters();
    anX.unmarshal(buff);
    antennaPatternList.add(anX);
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

    if(!(obj instanceof TransmitterPdu))
        return false;

     final TransmitterPdu rhs = (TransmitterPdu)obj;

     if( ! (header.equals( rhs.header) )) ivarsEqual = false;
     if( ! (radioNumber == rhs.radioNumber)) ivarsEqual = false;
     if( ! (radioEntityType.equals( rhs.radioEntityType) )) ivarsEqual = false;
     if( ! (transmitState == rhs.transmitState)) ivarsEqual = false;
     if( ! (inputSource == rhs.inputSource)) ivarsEqual = false;
     if( ! (variableTransmitterParameterCount == rhs.variableTransmitterParameterCount)) ivarsEqual = false;
     if( ! (antennaLocation.equals( rhs.antennaLocation) )) ivarsEqual = false;
     if( ! (relativeAntennaLocation.equals( rhs.relativeAntennaLocation) )) ivarsEqual = false;
     if( ! (antennaPatternType == rhs.antennaPatternType)) ivarsEqual = false;
     if( ! (antennaPatternCount == rhs.antennaPatternCount)) ivarsEqual = false;
     if( ! (frequency == rhs.frequency)) ivarsEqual = false;
     if( ! (transmitFrequencyBandwidth == rhs.transmitFrequencyBandwidth)) ivarsEqual = false;
     if( ! (power == rhs.power)) ivarsEqual = false;
     if( ! (modulationType.equals( rhs.modulationType) )) ivarsEqual = false;
     if( ! (cryptoSystem == rhs.cryptoSystem)) ivarsEqual = false;
     if( ! (cryptoKeyId == rhs.cryptoKeyId)) ivarsEqual = false;
     if( ! (modulationParameterCount == rhs.modulationParameterCount)) ivarsEqual = false;
     if( ! (padding1 == rhs.padding1)) ivarsEqual = false;
     if( ! (padding2 == rhs.padding2)) ivarsEqual = false;

     for(int idx = 0; idx < modulationParametersList.size(); idx++)
        if( ! ( modulationParametersList.get(idx).equals(rhs.modulationParametersList.get(idx)))) ivarsEqual = false;


     for(int idx = 0; idx < antennaPatternList.size(); idx++)
        if( ! ( antennaPatternList.get(idx).equals(rhs.antennaPatternList.get(idx)))) ivarsEqual = false;

    return ivarsEqual && super.equalsImpl(rhs);
 }
} // end of class
