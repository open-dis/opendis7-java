/**
 * Copyright (c) 2008-2019, MOVES Institute, Naval Postgraduate School. All rights reserved.
 * This work is licensed under the BSD open source license, available at https://www.movesinstitute.org/licenses/bsd.html
 */

package edu.nps.moves.dis7;

import java.util.*;
import java.io.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * 9.4.4 Communicate information about an entity’s articulated and attached parts.
 * IEEE Std 1278.1-2012, IEEE Standard for Distributed Interactive Simulation—Application Protocols
 */
public class ArticulatedPartsPdu extends LiveEntityFamilyPdu implements Serializable
{
   protected EntityID  liveEntityId = new EntityID(); 

   protected byte  numberOfParameterRecords;

   protected List< VariableParameter > variableParameters = new ArrayList< VariableParameter >();
 

/** Constructor */
 public ArticulatedPartsPdu()
 {
    setPduType( DISPDUType.ARTICULATED_PARTS );
 }

/** Returns the size of this serialized object in bytes*/
public int getMarshalledSize()
{
   int marshalSize = 0; 

   marshalSize = super.getMarshalledSize();
   marshalSize += liveEntityId.getMarshalledSize();
   marshalSize += 1;  // numberOfParameterRecords
   for(int idx=0; idx < variableParameters.size(); idx++)
   {
        VariableParameter listElement = variableParameters.get(idx);
        marshalSize += listElement.getMarshalledSize();
   }

   return marshalSize;
}


/** Setter for {@link ArticulatedPartsPdu#liveEntityId}*/
public ArticulatedPartsPdu setLiveEntityId(EntityID pLiveEntityId)
{
    liveEntityId = pLiveEntityId;
    return this;
}

/** Getter for {@link ArticulatedPartsPdu#liveEntityId}*/
public EntityID getLiveEntityId()
{
    return liveEntityId; 
}

/** Setter for {@link ArticulatedPartsPdu#variableParameters}*/
public ArticulatedPartsPdu setVariableParameters(List<VariableParameter> pVariableParameters)
{
    variableParameters = pVariableParameters;
    return this;
}

/** Getter for {@link ArticulatedPartsPdu#variableParameters}*/
public List<VariableParameter> getVariableParameters()
{
    return variableParameters; 
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
       liveEntityId.marshal(dos);
       dos.writeByte( (byte)variableParameters.size());

       for(int idx = 0; idx < variableParameters.size(); idx++)
       {
            VariableParameter aVariableParameter = variableParameters.get(idx);
            aVariableParameter.marshal(dos);
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
        uPosition += liveEntityId.unmarshal(dis);
        numberOfParameterRecords = (byte)dis.readUnsignedByte();
        uPosition += 1;
        for(int idx = 0; idx < numberOfParameterRecords; idx++)
        {
            VariableParameter anX = new VariableParameter();
            uPosition += anX.unmarshal(dis);
            variableParameters.add(anX);
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
   liveEntityId.marshal(buff);
   buff.put( (byte)variableParameters.size());

   for(int idx = 0; idx < variableParameters.size(); idx++)
   {
        VariableParameter aVariableParameter = (VariableParameter)variableParameters.get(idx);
        aVariableParameter.marshal(buff);
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

    liveEntityId.unmarshal(buff);
    numberOfParameterRecords = (byte)(buff.get() & 0xFF);
    for(int idx = 0; idx < numberOfParameterRecords; idx++)
    {
    VariableParameter anX = new VariableParameter();
    anX.unmarshal(buff);
    variableParameters.add(anX);
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

    if(getClass() != obj.getClass())
        return false;

    return equalsImpl(obj);
 }

@Override
 public boolean equalsImpl(Object obj)
 {
     boolean ivarsEqual = true;

     final ArticulatedPartsPdu rhs = (ArticulatedPartsPdu)obj;

     if( ! (liveEntityId.equals( rhs.liveEntityId) )) ivarsEqual = false;

     for(int idx = 0; idx < variableParameters.size(); idx++)
        if( ! ( variableParameters.get(idx).equals(rhs.variableParameters.get(idx)))) ivarsEqual = false;

    return ivarsEqual && super.equalsImpl(rhs);
 }
} // end of class
