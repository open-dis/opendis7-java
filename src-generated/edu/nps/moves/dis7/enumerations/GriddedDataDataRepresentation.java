package edu.nps.moves.dis7.enumerations;

import java.nio.ByteBuffer;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import edu.nps.moves.dis7.*;

/**
 * Generated from XML, SISO-REF-010-v28, 2020-05-07<br>
 * UID 247 marshal size 16<br>
 * ________________________________
 */
public enum GriddedDataDataRepresentation 
{
    /** Type 0 */
    TYPE_0 (0, "Type 0"),
    /** Type 1 */
    TYPE_1 (1, "Type 1"),
    /** Type 2 */
    TYPE_2 (2, "Type 2");

    private int value;
    private final String description;

    GriddedDataDataRepresentation(int value, String description)
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

    public static GriddedDataDataRepresentation getEnumForValue(int i)
    {
       for(GriddedDataDataRepresentation val: GriddedDataDataRepresentation.values()) {
          if(val.getValue()==i)
              return val;
       }
       System.err.println("No enumeration found for value " + i + " of enumeration GriddedDataDataRepresentation");
       return null;
    }


    public void marshal(DataOutputStream dos) throws IOException
    {
        dos.writeShort(getValue());
    }

    public void marshal(ByteBuffer buff) throws Exception
    {
        buff.putShort((short)getValue());
    }

    public static GriddedDataDataRepresentation unmarshalEnum (DataInputStream dis) throws Exception
    {
        return getEnumForValue(dis.readUnsignedShort());
    } 

    public static GriddedDataDataRepresentation unmarshalEnum (ByteBuffer buff) throws Exception
    {
        return getEnumForValue(buff.getShort());
    }   

  /**
   * Returns size of this serialized object in bytes
   * @return size in bytes
   */
    public int getMarshalledSize()
    {
        return 2; // 16 bits
    }
    
    @Override
    public String toString()
    {
        return "GriddedDataDataRepresentation: " + name() + ": " + getValue(); 
    }
}
