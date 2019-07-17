package edu.nps.moves.dis.jammers.Deception.AngleandGateStealer;

import java.nio.ByteBuffer;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import edu.nps.moves.dis.*;

/* marshal size 8 bits*/
public enum SubCategory implements edu.nps.moves.dis.JammerSubCategory
{
    CROSS_POLARIZATIONANDRANGEGATEPULL_OFFRGPO (5, "Cross-Polarization and Range Gate Pull-Off (RGPO)"),
    CROSS_POLARIZATIONANDVELOCITYGATEPULL_OFFVGPO (10, "Cross-Polarization and Velocity Gate Pull-Off (VGPO)"),
    CROSS_POLARIZATION_RGPOANDVGPO (15, "Cross-Polarization, RGPO and VGPO"),
    INVERSEGAINANDRGPO (20, "Inverse Gain and RGPO"),
    INVERSEGAINANDRGPOANDVGPO (25, "Inverse Gain and RGPO and VGPO"),
    INVERSEGAINANDVGPO (30, "Inverse Gain and VGPO"),
    RGPOANDSSW (35, "RGPO and SSW"),
    SSWANDVGPO (40, "SSW and VGPO");

    private byte value;
    private final String description;

    SubCategory(int value, String description)
    {
        this.value = (byte)value;
        this.description = description;
    }

    public byte getValue()
    {
        return value;
    }

    public String getDescription()
    {
        return description;
    }
    
    public static SubCategory getEnumerationForValue(int i)
    {
       for(SubCategory val: values()) {
          if(val.getValue()==i)
              return val;
       }
       System.err.println("No enumeration found for value " + i + " of enumeration SubCategory");
       return null;
    }

    @Override
    public void marshal(DataOutputStream dos)
    {
        try {
            dos.writeByte(getValue());
        }
        catch(IOException ex) {
            System.err.println(ex.getClass().getSimpleName()+": "+ex.getMessage());
        }
    }
    
    @Override
    public int unmarshal(DataInputStream dis)
    {
        try {
            value = dis.readByte();
        }
        catch(IOException ex) {
            showError(ex);
        }
        return 1;
    } 

    @Override
    public void marshal(ByteBuffer buff)
    {
        try {
            buff.put(getValue());
        }
       catch(Exception ex) {
            showError(ex);
        }
    }

    @Override
    public int unmarshal(ByteBuffer buff)
    {
        try {
            value = buff.get();
        }
        catch(Exception ex) {
            showError(ex);
        }
        return 1;
    }

    @Override
    public int getMarshalledSize()
    {
        return 1; // 8 bits
    }

    private void showError(Exception ex)
    {
        System.err.println(ex.getClass().getSimpleName()+": "+ex.getMessage());
    }
}
