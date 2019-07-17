package edu.nps.moves.dis.jammers.Deception.Angle;

import java.nio.ByteBuffer;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import edu.nps.moves.dis.*;

/* marshal size 8 bits*/
public enum SubCategory implements edu.nps.moves.dis.JammerSubCategory
{
    ANGLEGATEWALK_OFF (5, "Angle Gate Walk-Off"),
    COOPERATIVEANGLECAJ (10, "Cooperative Angle (CAJ)"),
    CROSS_EYE (15, "Cross-Eye"),
    CROSS_POLARIZATION (20, "Cross-Polarization"),
    DELTA (25, "Delta"),
    INVERSEGAINAKAINVERSEAMPLITUDE (30, "Inverse Gain (aka Inverse Amplitude)"),
    SEA_BOUNCED (35, "Sea-Bounced"),
    SWEPTSQUAREWAVESSW (40, "Swept Square Wave (SSW)"),
    TERRAINBOUNCE (45, "Terrain Bounce");

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
