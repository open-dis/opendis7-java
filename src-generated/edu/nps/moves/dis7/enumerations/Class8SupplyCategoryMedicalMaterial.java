package edu.nps.moves.dis7.enumerations;

import java.nio.ByteBuffer;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import edu.nps.moves.dis7.*;

/**
 * Generated from XML, SISO-REF-010-v25, 2018-08-29<br>
 * UID 608 marshal size 8<br>
 * Class 8 Supply Category - Medical Material
 */
public enum Class8SupplyCategoryMedicalMaterial implements Category
{
    /** Other */
    OTHER (1, "Other"),
    /** A - Medical Materiel */
    A_MEDICAL_MATERIEL (2, "A - Medical Materiel"),
    /** B - Blood / Fluids */
    B_BLOOD_FLUIDS (3, "B - Blood / Fluids");

    private int value;
    private final String description;

    Class8SupplyCategoryMedicalMaterial(int value, String description)
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
      return 8;
    }

    public static Class8SupplyCategoryMedicalMaterial getEnumForValue(int i)
    {
       for(Class8SupplyCategoryMedicalMaterial val: Class8SupplyCategoryMedicalMaterial.values()) {
          if(val.getValue()==i)
              return val;
       }
       System.err.println("No enumeration found for value " + i + " of enumeration Class8SupplyCategoryMedicalMaterial");
       return null;
    }


    public void marshal(DataOutputStream dos) throws IOException
    {
        dos.writeByte(getValue());
    }
    
    public void marshal(ByteBuffer buff) throws Exception
    {
        buff.put((byte)getValue());
    }

    public static Class8SupplyCategoryMedicalMaterial unmarshalEnum (DataInputStream dis) throws Exception
    {
       /* try {
            value = dis.readUnsignedByte();
        }
        catch(IOException ex) {
            showError(ex);
        } */
        
        return getEnumForValue(dis.readByte());
    } 

    public static Class8SupplyCategoryMedicalMaterial unmarshalEnum(ByteBuffer buff) throws Exception
    {
        /*
        try {
            value = (int)buff.get();
        }
        catch(Exception ex) {
            showError(ex);
        }
        */
        return getEnumForValue(buff.get());
    }

    public int getMarshalledSize()
    {
        return 1; // 8 bits
    }
    
    @Override
    public String toString()
    {
        return "Class8SupplyCategoryMedicalMaterial: " + name() + ": " + getValue(); 
    }
}
