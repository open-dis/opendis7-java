package edu.nps.moves.dis.enumerations;

import java.nio.ByteBuffer;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import edu.nps.moves.dis.*;

/**
 * Generated from XML, SISO-REF-010-v25, 2018-08-29<br>
 * UID 12 marshal size 8<br>
 * Platform-Subsurface Category
 */
public enum PlatformSubsurfaceCategory implements Category
{
    /** Other */
    OTHER (0, "Other"),
    /** SSBN (Nuclear Ballistic Missile) */
    SSBN_NUCLEAR_BALLISTIC_MISSILE (1, "SSBN (Nuclear Ballistic Missile)"),
    /** SSGN (Nuclear Guided Missile) */
    SSGN_NUCLEAR_GUIDED_MISSILE (2, "SSGN (Nuclear Guided Missile)"),
    /** SSN (Nuclear Attack - Torpedo) */
    SSN_NUCLEAR_ATTACK_TORPEDO (3, "SSN (Nuclear Attack - Torpedo)"),
    /** SSG (Conventional Guided Missile) */
    SSG_CONVENTIONAL_GUIDED_MISSILE (4, "SSG (Conventional Guided Missile)"),
    /** SS (Conventional Attack - Torpedo, Patrol) */
    SS_CONVENTIONAL_ATTACK_TORPEDO_PATROL (5, "SS (Conventional Attack - Torpedo, Patrol)"),
    /** SSAN (Nuclear Auxiliary) */
    SSAN_NUCLEAR_AUXILIARY (6, "SSAN (Nuclear Auxiliary)"),
    /** SSA (Conventional Auxiliary) */
    SSA_CONVENTIONAL_AUXILIARY (7, "SSA (Conventional Auxiliary)"),
    /** Unmanned Underwater Vehicle (UUV) */
    UNMANNED_UNDERWATER_VEHICLE_UUV (8, "Unmanned Underwater Vehicle (UUV)"),
    /** SSB (Submarine Ballistic, Ballistic Missile Submarine) */
    SSB_SUBMARINE_BALLISTIC_BALLISTIC_MISSILE_SUBMARINE (9, "SSB (Submarine Ballistic, Ballistic Missile Submarine)"),
    /** SSC (Coastal Submarine, over 150 tons) */
    SSC_COASTAL_SUBMARINE_OVER_150_TONS (10, "SSC (Coastal Submarine, over 150 tons)"),
    /** SSP (Attack Submarine - Diesel Air-Independent Propulsion) */
    SSP_ATTACK_SUBMARINE_DIESEL_AIR_INDEPENDENT_PROPULSION (11, "SSP (Attack Submarine - Diesel Air-Independent Propulsion)"),
    /** SSM (Midget Submarine, under 150 tons) */
    SSM_MIDGET_SUBMARINE_UNDER_150_TONS (12, "SSM (Midget Submarine, under 150 tons)"),
    /** SSNR (Special Attack Submarine) */
    SSNR_SPECIAL_ATTACK_SUBMARINE (13, "SSNR (Special Attack Submarine)"),
    /** SST (Training Submarine) */
    SST_TRAINING_SUBMARINE (14, "SST (Training Submarine)"),
    /** AGSS (Auxiliary Submarine) */
    AGSS_AUXILIARY_SUBMARINE (15, "AGSS (Auxiliary Submarine)"),
    /** Semi-Submersible Boats */
    SEMI_SUBMERSIBLE_BOATS (16, "Semi-Submersible Boats"),
    /** Civilian Submarines */
    CIVILIAN_SUBMARINES (80, "Civilian Submarines"),
    /** Civilian Submersibles */
    CIVILIAN_SUBMERSIBLES (81, "Civilian Submersibles"),
    /** Civilian Semi-Submersible Boats */
    CIVILIAN_SEMI_SUBMERSIBLE_BOATS (82, "Civilian Semi-Submersible Boats");

    private int value;
    private final String description;

    PlatformSubsurfaceCategory(int value, String description)
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

    public static PlatformSubsurfaceCategory getEnumForValue(int i)
    {
       for(PlatformSubsurfaceCategory val: PlatformSubsurfaceCategory.values()) {
          if(val.getValue()==i)
              return val;
       }
       System.err.println("No enumeration found for value " + i + " of enumeration PlatformSubsurfaceCategory");
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

    public static PlatformSubsurfaceCategory unmarshalEnum (DataInputStream dis) throws Exception
    {
       /* try {
            value = dis.readUnsignedByte();
        }
        catch(IOException ex) {
            showError(ex);
        } */
        
        return getEnumForValue((int)dis.readByte());
    } 

    public static PlatformSubsurfaceCategory unmarshalEnum(ByteBuffer buff) throws Exception
    {
        /*
        try {
            value = (int)buff.get();
        }
        catch(Exception ex) {
            showError(ex);
        }
        */
        return getEnumForValue((int)buff.get());
    }

    public int getMarshalledSize()
    {
        return 1; // 8 bits
    }
}
