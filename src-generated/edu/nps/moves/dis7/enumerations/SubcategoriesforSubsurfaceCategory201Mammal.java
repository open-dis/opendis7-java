package edu.nps.moves.dis7.enumerations;

import java.nio.ByteBuffer;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import edu.nps.moves.dis7.*;

/**
 * Generated from XML, SISO-REF-010-v25, 2018-08-29<br>
 * UID 121 marshal size 8<br>
 * Subcategories for Subsurface Category 201 - Mammal
 */
public enum SubcategoriesforSubsurfaceCategory201Mammal implements SubCategory
{
    /** Whale, 1-49 Whale */
    WHALE (1, "Whale"),
    /** Beaked Whale */
    BEAKED_WHALE (2, "Beaked Whale"),
    /** Beluga Whale */
    BELUGA_WHALE (3, "Beluga Whale"),
    /** Blue Whale */
    BLUE_WHALE (4, "Blue Whale"),
    /** Bottlenose Whale */
    BOTTLENOSE_WHALE (5, "Bottlenose Whale"),
    /** Northern Bottlenose Whale */
    NORTHERN_BOTTLENOSE_WHALE (6, "Northern Bottlenose Whale"),
    /** Southern Bottlenose Whale */
    SOUTHERN_BOTTLENOSE_WHALE (7, "Southern Bottlenose Whale"),
    /** Bowhead Whale */
    BOWHEAD_WHALE (8, "Bowhead Whale"),
    /** Bryde's Whale */
    BRYDES_WHALE (9, "Bryde's Whale"),
    /** Dwarf Sperm Whale */
    DWARF_SPERM_WHALE (10, "Dwarf Sperm Whale"),
    /** Finback Whale */
    FINBACK_WHALE (11, "Finback Whale"),
    /** Gray Whale */
    GRAY_WHALE (12, "Gray Whale"),
    /** Humpback Whale */
    HUMPBACK_WHALE (13, "Humpback Whale"),
    /** Long-Finned Pilot Whale */
    LONG_FINNED_PILOT_WHALE (14, "Long-Finned Pilot Whale"),
    /** Minke Whale */
    MINKE_WHALE (15, "Minke Whale"),
    /** Northern Minke Whale */
    NORTHERN_MINKE_WHALE (16, "Northern Minke Whale"),
    /** Southern Minke Whale */
    SOUTHERN_MINKE_WHALE (17, "Southern Minke Whale"),
    /** Narwhal Whale */
    NARWHAL_WHALE (18, "Narwhal Whale"),
    /** Orca Whale */
    ORCA_WHALE (19, "Orca Whale"),
    /** Pygmy Sperm Whale */
    PYGMY_SPERM_WHALE (20, "Pygmy Sperm Whale"),
    /** Right Whale */
    RIGHT_WHALE (21, "Right Whale"),
    /** North Atlantic Right Whale */
    NORTH_ATLANTIC_RIGHT_WHALE (22, "North Atlantic Right Whale"),
    /** North Pacific Right Whale */
    NORTH_PACIFIC_RIGHT_WHALE (23, "North Pacific Right Whale"),
    /** Southern Right Whale */
    SOUTHERN_RIGHT_WHALE (24, "Southern Right Whale"),
    /** Sei Whale */
    SEI_WHALE (25, "Sei Whale"),
    /** Short-Finned Pilot Whale */
    SHORT_FINNED_PILOT_WHALE (26, "Short-Finned Pilot Whale"),
    /** Sperm Whale */
    SPERM_WHALE (27, "Sperm Whale"),
    /** Dolphin, 50-99 Dolphin */
    DOLPHIN (50, "Dolphin"),
    /** Bottlenose Dolphin */
    BOTTLENOSE_DOLPHIN (51, "Bottlenose Dolphin"),
    /** Bottlenose Indo-Pacific Dolphin */
    BOTTLENOSE_INDO_PACIFIC_DOLPHIN (52, "Bottlenose Indo-Pacific Dolphin"),
    /** Bottlenose Burrunan Dolphin */
    BOTTLENOSE_BURRUNAN_DOLPHIN (53, "Bottlenose Burrunan Dolphin"),
    /** Atlantic Spotted Dolphin */
    ATLANTIC_SPOTTED_DOLPHIN (54, "Atlantic Spotted Dolphin"),
    /** Australian Snubfin Dolphin */
    AUSTRALIAN_SNUBFIN_DOLPHIN (55, "Australian Snubfin Dolphin"),
    /** Chilean Black Dolphin */
    CHILEAN_BLACK_DOLPHIN (56, "Chilean Black Dolphin"),
    /** Chinese White Dolphin */
    CHINESE_WHITE_DOLPHIN (57, "Chinese White Dolphin"),
    /** Clymene Dolphin */
    CLYMENE_DOLPHIN (58, "Clymene Dolphin"),
    /** Porpoise, 100-119 Porpoise */
    PORPOISE (100, "Porpoise"),
    /** Harbour Porpoise */
    HARBOUR_PORPOISE (101, "Harbour Porpoise"),
    /** Californian Porpoise */
    CALIFORNIAN_PORPOISE (102, "Californian Porpoise"),
    /** Dall's Porpoise */
    DALLS_PORPOISE (103, "Dall's Porpoise"),
    /** Burmeister's Porpoise */
    BURMEISTERS_PORPOISE (104, "Burmeister's Porpoise"),
    /** Seal, 120-129 Seal */
    SEAL (120, "Seal"),
    /** Bearded Seal */
    BEARDED_SEAL (121, "Bearded Seal"),
    /** Harbor Seal */
    HARBOR_SEAL (122, "Harbor Seal"),
    /** Fur Seal */
    FUR_SEAL (123, "Fur Seal"),
    /** Weddell Seal */
    WEDDELL_SEAL (124, "Weddell Seal"),
    /** Elephant Seal */
    ELEPHANT_SEAL (125, "Elephant Seal"),
    /** Sea Lion, 130-139 Sea Lion */
    SEA_LION (130, "Sea Lion"),
    /** Australian Sea Lion */
    AUSTRALIAN_SEA_LION (131, "Australian Sea Lion"),
    /** California Sea Lion */
    CALIFORNIA_SEA_LION (132, "California Sea Lion"),
    /** Walrus, 140-149 Walrus */
    WALRUS (140, "Walrus"),
    /** Atlantic Walrus */
    ATLANTIC_WALRUS (141, "Atlantic Walrus"),
    /** Pacific Walrus */
    PACIFIC_WALRUS (142, "Pacific Walrus"),
    /** Otter, 150-159 Otter */
    OTTER (150, "Otter"),
    /** Sea Otter */
    SEA_OTTER (151, "Sea Otter"),
    /** Manatee, 160-164 Manatee */
    MANATEE (160, "Manatee"),
    /** Florida Manatee */
    FLORIDA_MANATEE (161, "Florida Manatee"),
    /** Dugongs */
    DUGONGS (162, "Dugongs"),
    /** Polar Bear, 200-255 Other Mammals */
    POLAR_BEAR (200, "Polar Bear");

    private int value;
    private final String description;

    SubcategoriesforSubsurfaceCategory201Mammal(int value, String description)
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

    public static SubcategoriesforSubsurfaceCategory201Mammal getEnumForValue(int i)
    {
       for(SubcategoriesforSubsurfaceCategory201Mammal val: SubcategoriesforSubsurfaceCategory201Mammal.values()) {
          if(val.getValue()==i)
              return val;
       }
       System.err.println("No enumeration found for value " + i + " of enumeration SubcategoriesforSubsurfaceCategory201Mammal");
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

    public static SubcategoriesforSubsurfaceCategory201Mammal unmarshalEnum (DataInputStream dis) throws Exception
    {
       /* try {
            value = dis.readUnsignedByte();
        }
        catch(IOException ex) {
            showError(ex);
        } */
        
        return getEnumForValue((int)dis.readByte());
    } 

    public static SubcategoriesforSubsurfaceCategory201Mammal unmarshalEnum(ByteBuffer buff) throws Exception
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
    
    @Override
    public String toString()
    {
        return "SubcategoriesforSubsurfaceCategory201Mammal: " + name() + ": " + getValue(); 
    }
}
