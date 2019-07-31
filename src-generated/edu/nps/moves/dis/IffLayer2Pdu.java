/**
 * Copyright (c) 2008-2019, MOVES Institute, Naval Postgraduate School. All rights reserved.
 * This work is licensed under the BSD open source license, available at https://www.movesinstitute.org/licenses/bsd.html
 */

package edu.nps.moves.dis;

import java.util.*;
import java.io.*;
import edu.nps.moves.dis.enumerations.*;

/**
 * Section 5.3.7.4.2 When present, layer 2 should follow layer 1 and have the following fields. This requires manual cleanup.            the beamData attribute semantics are used in multiple ways. UNFINSISHED
 * IEEE Std 1278.1-2012, IEEE Standard for Distributed Interactive Simulation—Application Protocols
 */
public class IffLayer2Pdu extends IffPdu implements Serializable
{
   /** layer header */
   protected LayerHeader  layerHeader = new LayerHeader(); 

   /** beam data */
   protected BeamData  beamData = new BeamData(); 

   protected byte  secondaryOpParameter1;

   protected byte  secondaryOpParameter2;

   protected short  numberOfParameters;

   /** variable length list of fundamental parameters. */
   protected List< IFFFundamentalParameterData > fundamentalIffParameters = new ArrayList< IFFFundamentalParameterData >();
 

/** Constructor */
 public IffLayer2Pdu()
 {
 }

public int getMarshalledSize()
{
   int marshalSize = 0; 

   marshalSize = super.getMarshalledSize();
   marshalSize += layerHeader.getMarshalledSize();
   marshalSize += beamData.getMarshalledSize();
   marshalSize += 1;  // secondaryOpParameter1
   marshalSize += 1;  // secondaryOpParameter2
   marshalSize += 2;  // numberOfParameters
   for(int idx=0; idx < fundamentalIffParameters.size(); idx++)
   {
        IFFFundamentalParameterData listElement = fundamentalIffParameters.get(idx);
        marshalSize += listElement.getMarshalledSize();
   }

   return marshalSize;
}


public IffLayer2Pdu setLayerHeader(LayerHeader pLayerHeader)
{
    layerHeader = pLayerHeader;
    return this;
}

public LayerHeader getLayerHeader()
{
    return layerHeader; 
}

public IffLayer2Pdu setBeamData(BeamData pBeamData)
{
    beamData = pBeamData;
    return this;
}

public BeamData getBeamData()
{
    return beamData; 
}

public IffLayer2Pdu setSecondaryOpParameter1(byte pSecondaryOpParameter1)
{
    secondaryOpParameter1 = pSecondaryOpParameter1;
    return this;
}

public byte getSecondaryOpParameter1()
{
    return secondaryOpParameter1; 
}

public IffLayer2Pdu setSecondaryOpParameter2(byte pSecondaryOpParameter2)
{
    secondaryOpParameter2 = pSecondaryOpParameter2;
    return this;
}

public byte getSecondaryOpParameter2()
{
    return secondaryOpParameter2; 
}

public IffLayer2Pdu setFundamentalIffParameters(List<IFFFundamentalParameterData> pFundamentalIffParameters)
{
    fundamentalIffParameters = pFundamentalIffParameters;
    return this;
}

public List<IFFFundamentalParameterData> getFundamentalIffParameters()
{
    return fundamentalIffParameters; 
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
       layerHeader.marshal(dos);
       beamData.marshal(dos);
       dos.writeByte( (byte)secondaryOpParameter1);
       dos.writeByte( (byte)secondaryOpParameter2);
       dos.writeShort( (short)fundamentalIffParameters.size());

       for(int idx = 0; idx < fundamentalIffParameters.size(); idx++)
       {
            IFFFundamentalParameterData aIFFFundamentalParameterData = fundamentalIffParameters.get(idx);
            aIFFFundamentalParameterData.marshal(dos);
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
            fundamentalIffParameters.add(anX);
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
   layerHeader.marshal(buff);
   beamData.marshal(buff);
   buff.put( (byte)secondaryOpParameter1);
   buff.put( (byte)secondaryOpParameter2);
   buff.putShort( (short)fundamentalIffParameters.size());

   for(int idx = 0; idx < fundamentalIffParameters.size(); idx++)
   {
        IFFFundamentalParameterData aIFFFundamentalParameterData = (IFFFundamentalParameterData)fundamentalIffParameters.get(idx);
        aIFFFundamentalParameterData.marshal(buff);
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

    layerHeader.unmarshal(buff);
    beamData.unmarshal(buff);
    secondaryOpParameter1 = (byte)(buff.get() & 0xFF);
    secondaryOpParameter2 = (byte)(buff.get() & 0xFF);
    numberOfParameters = (short)(buff.getShort() & 0xFFFF);
    for(int idx = 0; idx < numberOfParameters; idx++)
    {
    IFFFundamentalParameterData anX = new IFFFundamentalParameterData();
    anX.unmarshal(buff);
    fundamentalIffParameters.add(anX);
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

    if(!(obj instanceof IffLayer2Pdu))
        return false;

     final IffLayer2Pdu rhs = (IffLayer2Pdu)obj;

     if( ! (layerHeader.equals( rhs.layerHeader) )) ivarsEqual = false;
     if( ! (beamData.equals( rhs.beamData) )) ivarsEqual = false;
     if( ! (secondaryOpParameter1 == rhs.secondaryOpParameter1)) ivarsEqual = false;
     if( ! (secondaryOpParameter2 == rhs.secondaryOpParameter2)) ivarsEqual = false;
     if( ! (numberOfParameters == rhs.numberOfParameters)) ivarsEqual = false;

     for(int idx = 0; idx < fundamentalIffParameters.size(); idx++)
        if( ! ( fundamentalIffParameters.get(idx).equals(rhs.fundamentalIffParameters.get(idx)))) ivarsEqual = false;

    return ivarsEqual && super.equalsImpl(rhs);
 }
} // end of class
