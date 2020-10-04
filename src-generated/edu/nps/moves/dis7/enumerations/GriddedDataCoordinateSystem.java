package edu.nps.moves.dis7.enumerations;

import java.nio.ByteBuffer;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import edu.nps.moves.dis7.pdus.*;

/**
 * Generated from XML, SISO-REF-010-v28, 2020-05-07<br>
 * UID 244 marshal size 16<br>
 * GriddedDataCoordinateSystem
 */
public enum GriddedDataCoordinateSystem 
{
    /** Right handed Cartesian (local topographic projection: east, north, up) */
    RIGHT_HANDED_CARTESIAN_LOCAL_TOPOGRAPHIC_PROJECTION_EAST_NORTH_UP (0, "Right handed Cartesian (local topographic projection: east, north, up)"),
    /** Left handed Cartesian (local topographic projection: east, north, down) */
    LEFT_HANDED_CARTESIAN_LOCAL_TOPOGRAPHIC_PROJECTION_EAST_NORTH_DOWN (1, "Left handed Cartesian (local topographic projection: east, north, down)"),
    /** Latitude, Longitude, Height */
    LATITUDE_LONGITUDE_HEIGHT (2, "Latitude, Longitude, Height"),
    /** Latitude, Longitude, Depth */
    LATITUDE_LONGITUDE_DEPTH (3, "Latitude, Longitude, Depth");

    private int value;
    private final String description;

    GriddedDataCoordinateSystem(int value, String description)
    {
        this.value = value;
        this.description = description;
    }

    public int getValue()
    {
        return value;
    }

    public String getDescription()
    {
        return description;
    }
    
    public static int getEnumBitWidth()
    {
      return 16;
    }

    public static GriddedDataCoordinateSystem getEnumForValue(int i)
    {
       for(GriddedDataCoordinateSystem val: GriddedDataCoordinateSystem.values()) {
          if(val.getValue()==i)
              return val;
       }
       System.err.println("No enumeration found for value " + i + " of enumeration GriddedDataCoordinateSystem");
       return null;
    }

 
   public void marshal(DataOutputStream dos) throws IOException
    {
        dos.writeShort(getValue());
    }

    public void marshal(ByteBuffer byteBuffer) throws Exception
    {
        byteBuffer.putShort((short)getValue());
    }

    public static GriddedDataCoordinateSystem unmarshalEnum (DataInputStream dis) throws Exception
    {
        return getEnumForValue(dis.readUnsignedShort());
    } 

    public static GriddedDataCoordinateSystem unmarshalEnum (ByteBuffer byteBuffer) throws Exception
    {
        return getEnumForValue(byteBuffer.getShort());
    }   

  /**
   * Returns size of this serialized (marshalled) object in bytes
   * See <a href="https://en.wikipedia.org/wiki/Marshalling_(computer_science)" target="_blank">https://en.wikipedia.org/wiki/Marshalling_(computer_science)</a>
   * @return serialized size in bytes
   */
    public int getMarshalledSize()
    {
        return 2; // 16 bits
    }
    
  /**
   * Provide simple identifier
   * @return ID number and name
   */
    @Override
    public String toString()
    {
        return "GriddedDataCoordinateSystem " + getValue() + " " + name(); 
    }
}
