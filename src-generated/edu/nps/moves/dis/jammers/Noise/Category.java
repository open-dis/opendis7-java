package edu.nps.moves.dis.jammers.Noise;

import java.nio.ByteBuffer;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import edu.nps.moves.dis.*;

/* marshal size 8 bits*/
public enum Category implements edu.nps.moves.dis.JammerCategory
{
    AMPLITUDEMODULATIONAMNOISE (5, "Amplitude Modulation (AM) Noise"),
    BARRAGENOISE (10, "Barrage Noise"),
    BISTATICCLUTTER (15, "Bistatic Clutter"),
    COMB (20, "Comb"),
    COOPERATIVEBLINKEDNOISECBN (25, "Cooperative Blinked Noise (CBN)"),
    DOPPLERNOISE (30, "Doppler Noise"),
    FREQUENCYMODULATIONFMBYNOISE (35, "Frequency Modulation (FM) by Noise"),
    IMPULSENOISE (40, "Impulse Noise"),
    PARTIALBAND (45, "Partial Band"),
    PSEUDORANDOMAM (50, "Pseudorandom AM"),
    PULSENOISE (55, "Pulse Noise"),
    QUASI_NOISEAKAPSEUDORANDOM (60, "Quasi-Noise (aka Pseudorandom)"),
    RANGEBINMASKINGRBMAKACOVERPULSE (65, "Range Bin Masking (RBM) (aka Cover Pulse)"),
    REPEATERNOISE (70, "Repeater Noise"),
    SPOTNOISE (75, "Spot Noise"),
    SWEPTNOISEAKASWEPTSPOTNOISE_SWEEP (80, "Swept Noise (aka Swept Spot Noise, Sweep)"),
    VELOCITYBINMASKINGVBM (85, "Velocity Bin Masking (VBM)");

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
