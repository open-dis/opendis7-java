/**
 * Copyright (c) 2008-2020, MOVES Institute, Naval Postgraduate School (NPS). All rights reserved.
 * This work is provided under a BSD open-source license, see project license.html and license.txt
 */

package edu.nps.moves.dis7.pdus;

import java.util.*;
import java.io.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * Section 5.3.7.4.2 When present, layer 2 should follow layer 1 and have the following fields. This requires manual cleanup.            the beamData attribute semantics are used in multiple ways. UNFINSISHED
 * IEEE Std 1278.1-2012, IEEE Standard for Distributed Interactive Simulation - Application Protocols
 */
public class IFFLayer2Pdu extends IFFPdu implements Serializable
{
   /** layer header */
   protected LayerHeader  layerHeader = new LayerHeader(); 

   /** beam data */
   protected BeamData  beamData = new BeamData(); 

   protected byte  secondaryOpParameter1;

   protected byte  secondaryOpParameter2;

   protected short  numberOfParameters;

   /** variable length list of fundamental parameters. */
   protected List< IFFFundamentalParameterData > fundamentalIFFParameters = new ArrayList< IFFFundamentalParameterData >();
 

/** Constructor */
 public IFFLayer2Pdu()
 {
 }

  /**
   * Returns size of this serialized (marshalled) object in bytes
   * See <a href="https://en.wikipedia.org/wiki/Marshalling_(computer_science)" target="_blank">https://en.wikipedia.org/wiki/Marshalling_(computer_science)</a>
   * @return serialized size in bytes
   */
public int getMarshalledSize()
{
   int marshalSize = 0; 

   marshalSize = super.getMarshalledSize();
   marshalSize += layerHeader.getMarshalledSize();
   marshalSize += beamData.getMarshalledSize();
   marshalSize += 1;  // secondaryOpParameter1
   marshalSize += 1;  // secondaryOpParameter2
   marshalSize += 2;  // numberOfParameters
   for(int idx=0; idx < fundamentalIFFParameters.size(); idx++)
   {
        IFFFundamentalParameterData listElement = fundamentalIFFParameters.get(idx);
        marshalSize += listElement.getMarshalledSize();
   }

   return marshalSize;
}


/** Setter for {@link IFFLayer2Pdu#layerHeader}
  * @param pLayerHeader new value of interest
  * @return same object to permit progressive setters */
public IFFLayer2Pdu setLayerHeader(LayerHeader pLayerHeader)
{
    layerHeader = pLayerHeader;
    return this;
}

/** Getter for {@link IFFLayer2Pdu#layerHeader}
  * @return value of interest */
public LayerHeader getLayerHeader()
{
    return layerHeader; 
}

/** Setter for {@link IFFLayer2Pdu#beamData}
  * @param pBeamData new value of interest
  * @return same object to permit progressive setters */
public IFFLayer2Pdu setBeamData(BeamData pBeamData)
{
    beamData = pBeamData;
    return this;
}

/** Getter for {@link IFFLayer2Pdu#beamData}
  * @return value of interest */
public BeamData getBeamData()
{
    return beamData; 
}

/** Setter for {@link IFFLayer2Pdu#secondaryOpParameter1}
  * @param pSecondaryOpParameter1 new value of interest
  * @return same object to permit progressive setters */
public IFFLayer2Pdu setSecondaryOpParameter1(byte pSecondaryOpParameter1)
{
    secondaryOpParameter1 = pSecondaryOpParameter1;
    return this;
}
/** Utility setter for {@link IFFLayer2Pdu#secondaryOpParameter1}
  * @param pSecondaryOpParameter1 new value of interest
  * @return same object to permit progressive setters */
public IFFLayer2Pdu setSecondaryOpParameter1(int pSecondaryOpParameter1){
    secondaryOpParameter1 = (byte) pSecondaryOpParameter1;
    return this;
}

/** Getter for {@link IFFLayer2Pdu#secondaryOpParameter1}
  * @return value of interest */
public byte getSecondaryOpParameter1()
{
    return secondaryOpParameter1; 
}

/** Setter for {@link IFFLayer2Pdu#secondaryOpParameter2}
  * @param pSecondaryOpParameter2 new value of interest
  * @return same object to permit progressive setters */
public IFFLayer2Pdu setSecondaryOpParameter2(byte pSecondaryOpParameter2)
{
    secondaryOpParameter2 = pSecondaryOpParameter2;
    return this;
}
/** Utility setter for {@link IFFLayer2Pdu#secondaryOpParameter2}
  * @param pSecondaryOpParameter2 new value of interest
  * @return same object to permit progressive setters */
public IFFLayer2Pdu setSecondaryOpParameter2(int pSecondaryOpParameter2){
    secondaryOpParameter2 = (byte) pSecondaryOpParameter2;
    return this;
}

/** Getter for {@link IFFLayer2Pdu#secondaryOpParameter2}
  * @return value of interest */
public byte getSecondaryOpParameter2()
{
    return secondaryOpParameter2; 
}

/** Setter for {@link IFFLayer2Pdu#fundamentalIFFParameters}
  * @param pFundamentalIFFParameters new value of interest
  * @return same object to permit progressive setters */
public IFFLayer2Pdu setFundamentalIFFParameters(List<IFFFundamentalParameterData> pFundamentalIFFParameters)
{
    fundamentalIFFParameters = pFundamentalIFFParameters;
    return this;
}

/** Getter for {@link IFFLayer2Pdu#fundamentalIFFParameters}
  * @return value of interest */
public List<IFFFundamentalParameterData> getFundamentalIFFParameters()
{
    return fundamentalIFFParameters; 
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
       layerHeader.marshal(dos);
       beamData.marshal(dos);
       dos.writeByte(secondaryOpParameter1);
       dos.writeByte(secondaryOpParameter2);
       dos.writeShort(fundamentalIFFParameters.size());

       for(int idx = 0; idx < fundamentalIFFParameters.size(); idx++)
       {
            IFFFundamentalParameterData aIFFFundamentalParameterData = fundamentalIFFParameters.get(idx);
            aIFFFundamentalParameterData.marshal(dos);
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
 * See <a href="https://en.wikipedia.org/wiki/Marshalling_(computer_science)" target="_blank">https://en.wikipedia.org/wiki/Marshalling_(computer_science)</a>
 * @param dis the InputStream
 * @return marshalled serialized size in bytes
 */
public int unmarshal(DataInputStream dis) throws Exception
{
    int uPosition = 0;
    uPosition += super.unmarshal(dis);

    try 
    {
        uPosition += layerHeader.unmarshal(dis);
        uPosition += beamData.unmarshal(dis);
        secondaryOpParameter1 = (byte)dis.readUnsignedByte();
        uPosition += 1;
        secondaryOpParameter2 = (byte)dis.readUnsignedByte();
        uPosition += 1;
        numberOfParameters = (short)dis.readUnsignedShort();
        uPosition += 2;
        for(int idx = 0; idx < numberOfParameters; idx++)
        {
            IFFFundamentalParameterData anX = new IFFFundamentalParameterData();
            uPosition += anX.unmarshal(dis);
            fundamentalIFFParameters.add(anX);
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
   layerHeader.marshal(byteBuffer);
   beamData.marshal(byteBuffer);
   byteBuffer.put( (byte)secondaryOpParameter1);
   byteBuffer.put( (byte)secondaryOpParameter2);
   byteBuffer.putShort( (short)fundamentalIFFParameters.size());

   for(int idx = 0; idx < fundamentalIFFParameters.size(); idx++)
   {
        IFFFundamentalParameterData aIFFFundamentalParameterData = fundamentalIFFParameters.get(idx);
        aIFFFundamentalParameterData.marshal(byteBuffer);
   }

}

/**
 * Unpacks a Pdu from the underlying data.
 * @throws java.nio.BufferUnderflowException if byteBuffer is too small
 * @see java.nio.ByteBuffer
 * See <a href="https://en.wikipedia.org/wiki/Marshalling_(computer_science)" target="_blank">https://en.wikipedia.org/wiki/Marshalling_(computer_science)</a>
 * @param byteBuffer The ByteBuffer at the position to begin reading
 * @return marshalled serialized size in bytes
 * @throws Exception ByteBuffer-generated exception
 */
public int unmarshal(java.nio.ByteBuffer byteBuffer) throws Exception
{
    super.unmarshal(byteBuffer);

    layerHeader.unmarshal(byteBuffer);
    beamData.unmarshal(byteBuffer);
    secondaryOpParameter1 = (byte)(byteBuffer.get() & 0xFF);
    secondaryOpParameter2 = (byte)(byteBuffer.get() & 0xFF);
    numberOfParameters = (short)(byteBuffer.getShort() & 0xFFFF);
    for(int idx = 0; idx < numberOfParameters; idx++)
    {
    IFFFundamentalParameterData anX = new IFFFundamentalParameterData();
    anX.unmarshal(byteBuffer);
    fundamentalIFFParameters.add(anX);
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

     final IFFLayer2Pdu rhs = (IFFLayer2Pdu)obj;

     if( ! (layerHeader.equals( rhs.layerHeader) )) ivarsEqual = false;
     if( ! (beamData.equals( rhs.beamData) )) ivarsEqual = false;
     if( ! (secondaryOpParameter1 == rhs.secondaryOpParameter1)) ivarsEqual = false;
     if( ! (secondaryOpParameter2 == rhs.secondaryOpParameter2)) ivarsEqual = false;

     for(int idx = 0; idx < fundamentalIFFParameters.size(); idx++)
        if( ! ( fundamentalIFFParameters.get(idx).equals(rhs.fundamentalIFFParameters.get(idx)))) ivarsEqual = false;

    return ivarsEqual && super.equalsImpl(rhs);
 }

 @Override
 public String toString()
 {
    StringBuilder sb = new StringBuilder();
    sb.append(getClass().getSimpleName()).append(":\n");

    sb.append(" layerHeader: ").append(layerHeader).append("\n");
    sb.append(" beamData: ").append(beamData).append("\n");
    sb.append(" secondaryOpParameter1: ").append(secondaryOpParameter1).append("\n");
    sb.append(" secondaryOpParameter2: ").append(secondaryOpParameter2).append("\n");
    sb.append(" fundamentalIFFParameters: ").append("\n");
    fundamentalIFFParameters.forEach(r->{ sb.append(r.getClass().getSimpleName()).append(": ").append(r).append("\n");});

   return sb.toString();
 }
} // end of class
