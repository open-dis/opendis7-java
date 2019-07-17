package edu.nps.moves.dis.jammers.Deception;

import java.nio.ByteBuffer;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import edu.nps.moves.dis.*;

/* marshal size 8 bits*/
public enum Category implements edu.nps.moves.dis.JammerCategory
{
    ANALYZER (5, "Analyzer"),
    ANGLE (10, "Angle"),
    ANGLEANDGATESTEALER (15, "Angle and Gate Stealer"),
    ANGLEANDFALSETARGET (20, "Angle and False Target"),
    ANGLEANDRANDOMRANGEPROGRAMSRANRAP (25, "Angle and Random Range Programs (RANRAP)"),
    ANGLEANDVELOCITY (30, "Angle and Velocity"),
    AUTOMATICGAINCONTROLAGC (35, "Automatic Gain Control (AGC)"),
    AGCANDGATESTEALER (40, "AGC and Gate Stealer"),
    COLINEAR (45, "Colinear"),
    CONSTANTFALSEALARMRATE (50, "Constant False Alarm Rate"),
    DOUBLECROSS (55, "Double Cross"),
    DOWNLINK (60, "Down Link"),
    FALSETARGET (65, "False Target"),
    FIGUREEIGHT (70, "Figure Eight"),
    GATESTEALER (75, "Gate Stealer"),
    GATESTEALERANDREPEATER (80, "Gate Stealer and Repeater"),
    GLINTENHANCE (85, "Glint Enhance"),
    IMAGEFREQUENCY (90, "Image Frequency"),
    JITTEREDPULSEREPETITIONFREQUENCY (95, "Jittered Pulse Repetition Frequency"),
    JITTEREDPULSEWIDTH (100, "Jittered Pulse Width"),
    PSEUDORANDOMNOISEPRN (105, "Pseudorandom Noise (PRN)"),
    PULSE (110, "Pulse"),
    PULSECOMPRESSIONDECEPTION (115, "Pulse Compression Deception"),
    RANDOMRANGEPROGRAMSRANRAP (120, "Random Range Programs (RANRAP)"),
    REFRACTION (125, "Refraction"),
    REPEATER (130, "Repeater"),
    SCINTILLATION (135, "Scintillation"),
    SERRODYNE (140, "Serrodyne"),
    VELOCITY (145, "Velocity");

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
