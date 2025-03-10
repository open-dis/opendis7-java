/**
 * Copyright (c) 2008-2023, MOVES Institute, Naval Postgraduate School (NPS). All rights reserved.
 * This work is provided under a BSD-style open-source license, see project
 * <a href="https://savage.nps.edu/opendis7-java/license.html" target="_blank">license.html</a> and <a href="https://savage.nps.edu/opendis7-java/license.txt" target="_blank">license.txt</a>
 */
// header autogenerated using string template dis7javalicense.txt

// autogenerated using string template disenumpart1withfootnote.txt

package edu.nps.moves.dis7.enumerations;

import java.nio.ByteBuffer;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import edu.nps.moves.dis7.pdus.*;

/**
 * This <code>enum</code> type is generated from XML,
 *  UID 277, marshal size 8;
 * PlatformAirCivilianFixedWingAircraftSubcategories has 8 enumerations total.
 * Subcategories for Air Platform Categories 84-88. Subcategory values have the type of engine in the 10's digit and the number of engines in the 1's digit.
 * @see <a href="https://docs.oracle.com/javase/tutorial/java/javaOO/enum.html">Java Tutorials: Enum Types</a>
 * @see java.lang.Enum
 */
public enum PlatformAirCivilianFixedWingAircraftSubcategories implements SubCategory
{

    // autogenerated using string template disenumfootnotecomment.txt

    /** Single Piston Engine */
    // autogenerated using string template disenumpart2.txt
    SINGLE_PISTON_ENGINE (11, "Single Piston Engine"),
    // autogenerated using string template disenumfootnotecomment.txt

    /** Twin Piston Engine */
    // autogenerated using string template disenumpart2.txt
    TWIN_PISTON_ENGINE (12, "Twin Piston Engine"),
    // autogenerated using string template disenumfootnotecomment.txt

    /** Single Engine Turboprop */
    // autogenerated using string template disenumpart2.txt
    SINGLE_ENGINE_TURBOPROP (21, "Single Engine Turboprop"),
    // autogenerated using string template disenumfootnotecomment.txt

    /** Twin Engine Turboprop */
    // autogenerated using string template disenumpart2.txt
    TWIN_ENGINE_TURBOPROP (22, "Twin Engine Turboprop"),
    // autogenerated using string template disenumfootnotecomment.txt

    /** Four Engine Turboprop */
    // autogenerated using string template disenumpart2.txt
    FOUR_ENGINE_TURBOPROP (24, "Four Engine Turboprop"),
    // autogenerated using string template disenumfootnotecomment.txt

    /** Twin Jet */
    // autogenerated using string template disenumpart2.txt
    TWIN_JET (32, "Twin Jet"),
    // autogenerated using string template disenumfootnotecomment.txt

    /** Tri Jet */
    // autogenerated using string template disenumpart2.txt
    TRI_JET (33, "Tri Jet"),
    // autogenerated using string template disenumfootnotecomment.txt

    /** Four Engine Jet */
    // autogenerated using string template disenumpart2.txt
    FOUR_ENGINE_JET (34, "Four Engine Jet");

    // autogenerated using string template disenumpart25.txt

    private int value;
    private final String description;

    /** Constructor */
    PlatformAirCivilianFixedWingAircraftSubcategories(int value, String description)
    {
        this.value = value;
        this.description = description;
    }
    /** Provide enumeration value
      * @return integer value */
    public int getValue()
    {
        return value;
    }

    /** Provide enumeration description
     * @return description
     */
    public String getDescription()
    {
        return description;
    }

    /** bit width for this enumeration
     * @return number of bits wide
     */
    public static int getEnumBitWidth()
    {
      return 8;
    }

    /** 
     * Provide enumeration for a given value
     * @param value integer value of interest
     * @return enumeration corresponding to numeric value
     */
    public static PlatformAirCivilianFixedWingAircraftSubcategories getEnumForValue(int value)
    {
       for (PlatformAirCivilianFixedWingAircraftSubcategories nextEnum : PlatformAirCivilianFixedWingAircraftSubcategories.values())
       {
          if (nextEnum.getValue() == value)
              return nextEnum;
       }
       System.out.flush(); // ensure contiguous console outputs
       System.err.println("No corresponding enumeration found for value " + value + " of enum PlatformAirCivilianFixedWingAircraftSubcategories");
       System.err.flush(); // ensure contiguous console outputs
       return null;
    }

    // autogenerated using string template disenumpart3_8.txt

    private boolean TRACE = false;

    /** Set tracing on/off for this object 
     * @param value whether tracing is on or off */
    public void setTRACE (boolean value)
    {
        TRACE = value;
    }

    /** Whether tracing is on or off for this object
     * @return whether tracing is on or off */
    public boolean getTRACE ()
    {
        return TRACE;
    }

    /** Marshal value to DataOutputStream
     * @see <a href="https://en.wikipedia.org/wiki/Marshalling_(computer_science)" target="_blank">https://en.wikipedia.org/wiki/Marshalling_(computer_science)</a>
     * @param dos DataOutputStream for output
     * @throws IOException input-output error */
    public void marshal(DataOutputStream dos) throws IOException
    {
        dos.writeByte(getValue());
    }
    
    /** Marshal value to ByteBuffer
     * @see <a href="https://en.wikipedia.org/wiki/Marshalling_(computer_science)" target="_blank">https://en.wikipedia.org/wiki/Marshalling_(computer_science)</a>
     * @param byteBuffer ByteBuffer for output
     * @throws IOException input-output error */
    public void marshal(ByteBuffer byteBuffer) throws Exception
    {
        byteBuffer.put((byte)getValue());
    }

    /** Unmarshal value to DataInputStream
     * @see <a href="https://en.wikipedia.org/wiki/Marshalling_(computer_science)" target="_blank">https://en.wikipedia.org/wiki/Marshalling_(computer_science)</a>
     * @param dis DataInputStream for input
     * @throws Exception unmarshalling input-output error
     * @return enumeration of interest */
    public static PlatformAirCivilianFixedWingAircraftSubcategories unmarshalEnum (DataInputStream dis) throws Exception
    {
       /* try {
            value = dis.readUnsignedByte();
        }
        catch(IOException ex) {
            showError(ex);
        } */
        
        return getEnumForValue(dis.readByte());
    } 

    /** Unmarshal enumeration value to ByteBuffer
     * @see <a href="https://en.wikipedia.org/wiki/Marshalling_(computer_science)" target="_blank">https://en.wikipedia.org/wiki/Marshalling_(computer_science)</a>
     * @param byteBuffer ByteBuffer for input
     * @throws Exception unmarshalling input-output error
     * @return enumeration of interest */
    public static PlatformAirCivilianFixedWingAircraftSubcategories unmarshalEnum(ByteBuffer byteBuffer) throws Exception
    {
        /*
        try {
            value = (int)byteBuffer.get();
        }
        catch(Exception ex) {
            showError(ex);
        }
        */
        return getEnumForValue(byteBuffer.get());
    }

  /**
   * Returns size of this serialized (marshalled) object in bytes
   * @see <a href="https://en.wikipedia.org/wiki/Marshalling_(computer_science)" target="_blank">https://en.wikipedia.org/wiki/Marshalling_(computer_science)</a>
   * @return serialized size in bytes
   */
    public int getMarshalledSize()
    {
        return 1; // 8 bits
    }
  /**
   * Provide name
   * @return  name
   */
    public String getName()
    {
        return name();
    }

    
  /**
   * Provide simple identifier
   * @return class name, value and name
   */
    @Override
    public String toString()
    {
        String padding = new String();
        if (this.getClass().getName().endsWith("DisPduType") && (getValue() < 10))
            padding = "0"; // leading zero for column spacing
        String result = this.getClass().getSimpleName() + " " + padding + getValue() + " " + name();
        if (getTRACE())
            System.out.println ("*** enum " + this.getClass().getSimpleName() + " name=" + name() + ", value=" + getValue() + "; " +
               result); // debug diagnostic
        return result;
    }
}
