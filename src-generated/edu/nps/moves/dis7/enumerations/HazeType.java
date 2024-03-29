/**
 * Copyright (c) 2008-2023, MOVES Institute, Naval Postgraduate School (NPS). All rights reserved.
 * This work is provided under a BSD-style open-source license, see project
 * <a href="https://savage.nps.edu/opendis7-java/license.html" target="_blank">license.html</a> and <a href="https://savage.nps.edu/opendis7-java/license.txt" target="_blank">license.txt</a>
 */
// header autogenerated using string template dis7javalicense.txt

// autogenerated using string template disenumpart1.txt

package edu.nps.moves.dis7.enumerations;

import java.nio.ByteBuffer;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import edu.nps.moves.dis7.pdus.*;

/**
 * This <code>enum</code> type is generated from XML,
 *  UID 662,
 * marshal size 8;
 * HazeType has 18 enumerations total.
 * @see <a href="https://docs.oracle.com/javase/tutorial/java/javaOO/enum.html">Java Tutorials: Enum Types</a>
 * @see java.lang.Enum
 */
public enum HazeType 
{
    // autogenerated using string template disenumfootnotecomment.txt

    /** No Haze */
    // autogenerated using string template disenumpart2.txt
    NO_HAZE (0, "No Haze"),
    // autogenerated using string template disenumfootnotecomment.txt

    /** Other Haze */
    // autogenerated using string template disenumpart2.txt
    OTHER_HAZE (1, "Other Haze"),
    // autogenerated using string template disenumfootnotecomment.txt

    /** Rurual Haze */
    // autogenerated using string template disenumpart2.txt
    RURUAL_HAZE (2, "Rurual Haze"),
    // autogenerated using string template disenumfootnotecomment.txt

    /** Maritime Haze */
    // autogenerated using string template disenumpart2.txt
    MARITIME_HAZE (3, "Maritime Haze"),
    // autogenerated using string template disenumfootnotecomment.txt

    /** Urban Haze */
    // autogenerated using string template disenumpart2.txt
    URBAN_HAZE (4, "Urban Haze"),
    // autogenerated using string template disenumfootnotecomment.txt

    /** Tropospheric Haze */
    // autogenerated using string template disenumpart2.txt
    TROPOSPHERIC_HAZE (5, "Tropospheric Haze"),
    // autogenerated using string template disenumfootnotecomment.txt

    /** Advective Fog Haze */
    // autogenerated using string template disenumpart2.txt
    ADVECTIVE_FOG_HAZE (6, "Advective Fog Haze"),
    // autogenerated using string template disenumfootnotecomment.txt

    /** Radiative Fog Haze */
    // autogenerated using string template disenumpart2.txt
    RADIATIVE_FOG_HAZE (7, "Radiative Fog Haze"),
    // autogenerated using string template disenumfootnotecomment.txt

    /** Desert Haze */
    // autogenerated using string template disenumpart2.txt
    DESERT_HAZE (8, "Desert Haze"),
    // autogenerated using string template disenumfootnotecomment.txt

    /** Desert Summer Haze */
    // autogenerated using string template disenumpart2.txt
    DESERT_SUMMER_HAZE (9, "Desert Summer Haze"),
    // autogenerated using string template disenumfootnotecomment.txt

    /** Desert Winter Haze */
    // autogenerated using string template disenumpart2.txt
    DESERT_WINTER_HAZE (10, "Desert Winter Haze"),
    // autogenerated using string template disenumfootnotecomment.txt

    /** Temperate Summer Day */
    // autogenerated using string template disenumpart2.txt
    TEMPERATE_SUMMER_DAY (11, "Temperate Summer Day"),
    // autogenerated using string template disenumfootnotecomment.txt

    /** Temperate Summer Night */
    // autogenerated using string template disenumpart2.txt
    TEMPERATE_SUMMER_NIGHT (12, "Temperate Summer Night"),
    // autogenerated using string template disenumfootnotecomment.txt

    /** Temperate Winter */
    // autogenerated using string template disenumpart2.txt
    TEMPERATE_WINTER (13, "Temperate Winter"),
    // autogenerated using string template disenumfootnotecomment.txt

    /** Dust Storm Haze */
    // autogenerated using string template disenumpart2.txt
    DUST_STORM_HAZE (14, "Dust Storm Haze"),
    // autogenerated using string template disenumfootnotecomment.txt

    /** Snow Haze */
    // autogenerated using string template disenumpart2.txt
    SNOW_HAZE (15, "Snow Haze"),
    // autogenerated using string template disenumfootnotecomment.txt

    /** Blowing Snow Haze */
    // autogenerated using string template disenumpart2.txt
    BLOWING_SNOW_HAZE (16, "Blowing Snow Haze"),
    // autogenerated using string template disenumfootnotecomment.txt

    /** Fog and Snow Haze */
    // autogenerated using string template disenumpart2.txt
    FOG_AND_SNOW_HAZE (17, "Fog and Snow Haze");

    // autogenerated using string template disenumpart25.txt

    private int value;
    private final String description;

    /** Constructor */
    HazeType(int value, String description)
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
    public static HazeType getEnumForValue(int value)
    {
       for (HazeType nextEnum : HazeType.values())
       {
          if (nextEnum.getValue() == value)
              return nextEnum;
       }
       System.out.flush(); // ensure contiguous console outputs
       System.err.println("No corresponding enumeration found for value " + value + " of enum HazeType");
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
    public static HazeType unmarshalEnum (DataInputStream dis) throws Exception
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
    public static HazeType unmarshalEnum(ByteBuffer byteBuffer) throws Exception
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
