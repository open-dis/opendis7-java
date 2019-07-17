package edu.nps.moves.dis.jammers.DeceptionandNoise;

import java.nio.ByteBuffer;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import edu.nps.moves.dis.*;

/* marshal size 8 bits*/
public enum Category implements edu.nps.moves.dis.JammerCategory
{
    ANGLEANDNOISE (5, "Angle and Noise"),
    ANGLEANDFMBYNOISE (10, "Angle and FM by Noise"),
    ANGLEANDPSEUDORANDOMAM (15, "Angle and Pseudorandom AM"),
    ANGLEANDSPOT (20, "Angle and Spot"),
    GATESTEALERANDNOISE (25, "Gate Stealer and Noise"),
    FALSETARGETDECEPTIONANDSWEPTNOISE (30, "False Target Deception and Swept Noise");

    private byte value;
    private final String description;

    Category(int value, String description)
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
    
    public static Category getEnumerationForValue(int i)
    {
       for(Category val: values()) {
          if(val.getValue()==i)
              return val;
       }
       System.err.println("No enumeration found for value " + i + " of enumeration Category");
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
