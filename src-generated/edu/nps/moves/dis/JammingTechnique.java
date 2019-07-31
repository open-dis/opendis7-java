/**
 * Copyright (c) 2008-2019, MOVES Institute, Naval Postgraduate School. All rights reserved.
 * This work is licensed under the BSD open source license, available at https://www.movesinstitute.org/licenses/bsd.html
 */

package edu.nps.moves.dis;

import java.util.*;
import java.io.*;
import edu.nps.moves.dis.enumerations.*;

/**
 * Jamming technique. Section 6.2.49, uid 284
 * IEEE Std 1278.1-2012, IEEE Standard for Distributed Interactive Simulation—Application Protocols
 */
public class JammingTechnique extends Object implements Serializable
{
   protected JammerKind  kind =  edu.nps.moves.dis.jammers.JammerKind.DECEPTIONANDNOISE; 

   protected JammerCategory  category =  edu.nps.moves.dis.jammers.DeceptionandNoise.Category.GATESTEALERANDNOISE; 

   protected JammerSubCategory  subcategory =  edu.nps.moves.dis.jammers.DeceptionandNoise.GateStealerandNoise.SubCategory.NOISEANDVGPO; 

   protected JammerSpecific  specific =  edu.nps.moves.dis.jammers.DeceptionandNoise.GateStealerandNoise.NoiseandVGPO.Specific.LOWLEVELNOISEANDVGPO; 


/** Constructor */
 public JammingTechnique()
 {
 }

public int getMarshalledSize()
{
   int marshalSize = 0; 

   marshalSize += kind.getMarshalledSize();
   marshalSize += category.getMarshalledSize();
   marshalSize += subcategory.getMarshalledSize();
   marshalSize += specific.getMarshalledSize();

   return marshalSize;
}


public JammingTechnique setKind(JammerKind pKind)
{
    kind = pKind;
    return this;
}

public JammerKind getKind()
{
    return kind; 
}

public JammingTechnique setCategory(JammerCategory pCategory)
{
    category = pCategory;
    return this;
}

public JammerCategory getCategory()
{
    return category; 
}

public JammingTechnique setSubcategory(JammerSubCategory pSubcategory)
{
    subcategory = pSubcategory;
    return this;
}

public JammerSubCategory getSubcategory()
{
    return subcategory; 
}

public JammingTechnique setSpecific(JammerSpecific pSpecific)
{
    specific = pSpecific;
    return this;
}

public JammerSpecific getSpecific()
{
    return specific; 
}

/**
 * Serializes an object to a DataOutputStream.
 * @see java.io.DataOutputStream
 * @param dos The DataOutputStream
 */
public void marshal(DataOutputStream dos)
{
    try 
    {
       kind.marshal(dos);
       category.marshal(dos);
       subcategory.marshal(dos);
       specific.marshal(dos);
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
    try 
    {
        uPosition += kind.unmarshal(dis);
        uPosition += category.unmarshal(dis);
        uPosition += subcategory.unmarshal(dis);
        uPosition += specific.unmarshal(dis);
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
   kind.marshal(buff);
   category.marshal(buff);
   subcategory.marshal(buff);
   specific.marshal(buff);
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
    kind.unmarshal(buff);
    category.unmarshal(buff);
    subcategory.unmarshal(buff);
    specific.unmarshal(buff);
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

 /**
  * Compare all fields that contribute to the state, ignoring
  * transient and static fields, for <code>this</code> and the supplied object
  * @param obj the object to compare to
  * @return true if the objects are equal, false otherwise.
  */
 public boolean equalsImpl(Object obj)
 {
     boolean ivarsEqual = true;

    if(!(obj instanceof JammingTechnique))
        return false;

     final JammingTechnique rhs = (JammingTechnique)obj;

     if( ! (kind.equals( rhs.kind) )) ivarsEqual = false;
     if( ! (category.equals( rhs.category) )) ivarsEqual = false;
     if( ! (subcategory.equals( rhs.subcategory) )) ivarsEqual = false;
     if( ! (specific.equals( rhs.specific) )) ivarsEqual = false;
    return ivarsEqual;
 }
} // end of class
