package edu.nps.moves.dis7.enumerations;

import java.nio.ByteBuffer;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import edu.nps.moves.dis7.*;

/**
 * Generated from XML, SISO-REF-010-v28, 2020-05-07<br>
 * UID 463 marshal size 8<br>
 * Color<br>
 * The color values 1 to 15 are defined in the HTML 3.0 specification; color values 20 to 159 are defined in the SVG 1.0 specification
 */
public enum Color 
{

    /** Not Specified */
    NOT_SPECIFIED (0, "Not Specified"),
    /** White VGA */
    WHITE_VGA (1, "White VGA"),
    /** Red VGA */
    RED_VGA (2, "Red VGA"),
    /** Yellow VGA */
    YELLOW_VGA (3, "Yellow VGA"),
    /** Lime VGA */
    LIME_VGA (4, "Lime VGA"),
    /** Cyan VGA */
    CYAN_VGA (5, "Cyan VGA"),
    /** Blue VGA */
    BLUE_VGA (6, "Blue VGA"),
    /** Magenta VGA */
    MAGENTA_VGA (7, "Magenta VGA"),
    /** Grey VGA */
    GREY_VGA (8, "Grey VGA"),
    /** Silver VGA */
    SILVER_VGA (9, "Silver VGA"),
    /** Maroon VGA */
    MAROON_VGA (10, "Maroon VGA"),
    /** Olive VGA */
    OLIVE_VGA (11, "Olive VGA"),
    /** Green VGA */
    GREEN_VGA (12, "Green VGA"),
    /** Teal VGA */
    TEAL_VGA (13, "Teal VGA"),
    /** Navy VGA */
    NAVY_VGA (14, "Navy VGA"),
    /** Purple VGA */
    PURPLE_VGA (15, "Purple VGA"),
    /** Reserved */
    RESERVED (16, "Reserved"),
    /** Reserved */
    RESERVED_2 (17, "Reserved"),
    /** Reserved */
    RESERVED_3 (18, "Reserved"),
    /** Reserved */
    RESERVED_4 (19, "Reserved"),
    /** Black */
    BLACK (20, "Black"),
    /** Navy */
    NAVY (21, "Navy"),
    /** Dark Blue */
    DARK_BLUE (22, "Dark Blue"),
    /** Medium Blue */
    MEDIUM_BLUE (23, "Medium Blue"),
    /** Blue */
    BLUE (24, "Blue"),
    /** Dark Green */
    DARK_GREEN (25, "Dark Green"),
    /** Green */
    GREEN (26, "Green"),
    /** Teal */
    TEAL (27, "Teal"),
    /** Dark Cyan */
    DARK_CYAN (28, "Dark Cyan"),
    /** Deep Sky Blue */
    DEEP_SKY_BLUE (29, "Deep Sky Blue"),
    /** Dark Turquoise */
    DARK_TURQUOISE (30, "Dark Turquoise"),
    /** Medium Spring Green */
    MEDIUM_SPRING_GREEN (31, "Medium Spring Green"),
    /** Lime */
    LIME (32, "Lime"),
    /** Spring Green */
    SPRING_GREEN (33, "Spring Green"),
    /** Cyan */
    CYAN (34, "Cyan"),
    /** Midnight Blue */
    MIDNIGHT_BLUE (35, "Midnight Blue"),
    /** Dodger Blue */
    DODGER_BLUE (36, "Dodger Blue"),
    /** Light Sea Green */
    LIGHT_SEA_GREEN (37, "Light Sea Green"),
    /** Forest Green */
    FOREST_GREEN (38, "Forest Green"),
    /** Sea Green */
    SEA_GREEN (39, "Sea Green"),
    /** Dark Slate Gray */
    DARK_SLATE_GRAY (40, "Dark Slate Gray"),
    /** Lime Green */
    LIME_GREEN (41, "Lime Green"),
    /** Medium Sea Green */
    MEDIUM_SEA_GREEN (42, "Medium Sea Green"),
    /** Turquoise */
    TURQUOISE (43, "Turquoise"),
    /** Royal Blue */
    ROYAL_BLUE (44, "Royal Blue"),
    /** Steel Blue */
    STEEL_BLUE (45, "Steel Blue"),
    /** Dark Slate Blue */
    DARK_SLATE_BLUE (46, "Dark Slate Blue"),
    /** Medium Turquoise */
    MEDIUM_TURQUOISE (47, "Medium Turquoise"),
    /** Indigo */
    INDIGO (48, "Indigo"),
    /** Dark Olive Green */
    DARK_OLIVE_GREEN (49, "Dark Olive Green"),
    /** Cadet Blue */
    CADET_BLUE (50, "Cadet Blue"),
    /** Cornflower Blue */
    CORNFLOWER_BLUE (51, "Cornflower Blue"),
    /** Medium Aquamarine */
    MEDIUM_AQUAMARINE (52, "Medium Aquamarine"),
    /** Dim Gray */
    DIM_GRAY (53, "Dim Gray"),
    /** Slate Blue */
    SLATE_BLUE (54, "Slate Blue"),
    /** Olive Drab */
    OLIVE_DRAB (55, "Olive Drab"),
    /** Slate Gray */
    SLATE_GRAY (56, "Slate Gray"),
    /** Light Slate Gray */
    LIGHT_SLATE_GRAY (57, "Light Slate Gray"),
    /** Medium Slate Blue */
    MEDIUM_SLATE_BLUE (58, "Medium Slate Blue"),
    /** Lawn Green */
    LAWN_GREEN (59, "Lawn Green"),
    /** Chartreuse */
    CHARTREUSE (60, "Chartreuse"),
    /** Aquamarine */
    AQUAMARINE (61, "Aquamarine"),
    /** Maroon */
    MAROON (62, "Maroon"),
    /** Purple */
    PURPLE (63, "Purple"),
    /** Olive */
    OLIVE (64, "Olive"),
    /** Gray */
    GRAY (65, "Gray"),
    /** Grey */
    GREY (66, "Grey"),
    /** Sky Blue */
    SKY_BLUE (67, "Sky Blue"),
    /** Light Sky Blue */
    LIGHT_SKY_BLUE (68, "Light Sky Blue"),
    /** Blue Violet */
    BLUE_VIOLET (69, "Blue Violet"),
    /** Dark Red */
    DARK_RED (70, "Dark Red"),
    /** Dark Magenta */
    DARK_MAGENTA (71, "Dark Magenta"),
    /** Saddle Brown */
    SADDLE_BROWN (72, "Saddle Brown"),
    /** Dark Sea Green */
    DARK_SEA_GREEN (73, "Dark Sea Green"),
    /** Light Green */
    LIGHT_GREEN (74, "Light Green"),
    /** Medium Purple */
    MEDIUM_PURPLE (75, "Medium Purple"),
    /** Dark Violet */
    DARK_VIOLET (76, "Dark Violet"),
    /** Pale Green */
    PALE_GREEN (77, "Pale Green"),
    /** Dark Orchid */
    DARK_ORCHID (78, "Dark Orchid"),
    /** Yellow Green */
    YELLOW_GREEN (79, "Yellow Green"),
    /** Sienna */
    SIENNA (80, "Sienna"),
    /** Brown */
    BROWN (81, "Brown"),
    /** Dark Gray */
    DARK_GRAY (82, "Dark Gray"),
    /** Light Blue */
    LIGHT_BLUE (83, "Light Blue"),
    /** Green Yellow */
    GREEN_YELLOW (84, "Green Yellow"),
    /** Pale Turquoise */
    PALE_TURQUOISE (85, "Pale Turquoise"),
    /** Light Steel Blue */
    LIGHT_STEEL_BLUE (86, "Light Steel Blue"),
    /** Powder Blue */
    POWDER_BLUE (87, "Powder Blue"),
    /** Fire Brick */
    FIRE_BRICK (88, "Fire Brick"),
    /** Dark Golden Rod */
    DARK_GOLDEN_ROD (89, "Dark Golden Rod"),
    /** Medium Orchid */
    MEDIUM_ORCHID (90, "Medium Orchid"),
    /** Rosy Brown */
    ROSY_BROWN (91, "Rosy Brown"),
    /** Dark Khaki */
    DARK_KHAKI (92, "Dark Khaki"),
    /** Silver */
    SILVER (93, "Silver"),
    /** Medium Violet Red */
    MEDIUM_VIOLET_RED (94, "Medium Violet Red"),
    /** Indian Red */
    INDIAN_RED (95, "Indian Red"),
    /** Peru */
    PERU (96, "Peru"),
    /** Chocolate */
    CHOCOLATE (97, "Chocolate"),
    /** Tan */
    TAN (98, "Tan"),
    /** Light Gray */
    LIGHT_GRAY (99, "Light Gray"),
    /** Pale Violet Red */
    PALE_VIOLET_RED (100, "Pale Violet Red"),
    /** Thistle */
    THISTLE (101, "Thistle"),
    /** Orchid */
    ORCHID (102, "Orchid"),
    /** Golden Rod */
    GOLDEN_ROD (103, "Golden Rod"),
    /** Crimson */
    CRIMSON (104, "Crimson"),
    /** Gainsboro */
    GAINSBORO (105, "Gainsboro"),
    /** Plum */
    PLUM (106, "Plum"),
    /** Burly Wood */
    BURLY_WOOD (107, "Burly Wood"),
    /** Light Cyan */
    LIGHT_CYAN (108, "Light Cyan"),
    /** Lavender */
    LAVENDER (109, "Lavender"),
    /** Dark Salmon */
    DARK_SALMON (110, "Dark Salmon"),
    /** Violet */
    VIOLET (111, "Violet"),
    /** Pale Golden Rod */
    PALE_GOLDEN_ROD (112, "Pale Golden Rod"),
    /** Light Coral */
    LIGHT_CORAL (113, "Light Coral"),
    /** Khaki */
    KHAKI (114, "Khaki"),
    /** Alice Blue */
    ALICE_BLUE (115, "Alice Blue"),
    /** Honey Dew */
    HONEY_DEW (116, "Honey Dew"),
    /** Azure */
    AZURE (117, "Azure"),
    /** Sandy Brown */
    SANDY_BROWN (118, "Sandy Brown"),
    /** Wheat */
    WHEAT (119, "Wheat"),
    /** Beige */
    BEIGE (120, "Beige"),
    /** White Smoke */
    WHITE_SMOKE (121, "White Smoke"),
    /** Mint Cream */
    MINT_CREAM (122, "Mint Cream"),
    /** Ghost White */
    GHOST_WHITE (123, "Ghost White"),
    /** Salmon */
    SALMON (124, "Salmon"),
    /** Antique White */
    ANTIQUE_WHITE (125, "Antique White"),
    /** Linen */
    LINEN (126, "Linen"),
    /** Light Golden Rod Yellow */
    LIGHT_GOLDEN_ROD_YELLOW (127, "Light Golden Rod Yellow"),
    /** Old Lace */
    OLD_LACE (128, "Old Lace"),
    /** Red */
    RED (129, "Red"),
    /** Fuchsia */
    FUCHSIA (130, "Fuchsia"),
    /** Magenta */
    MAGENTA (131, "Magenta"),
    /** Deep Pink */
    DEEP_PINK (132, "Deep Pink"),
    /** Orange Red */
    ORANGE_RED (133, "Orange Red"),
    /** Tomato */
    TOMATO (134, "Tomato"),
    /** Hot Pink */
    HOT_PINK (135, "Hot Pink"),
    /** Coral */
    CORAL (136, "Coral"),
    /** Dark Orange */
    DARK_ORANGE (137, "Dark Orange"),
    /** Light Salmon */
    LIGHT_SALMON (138, "Light Salmon"),
    /** Orange */
    ORANGE (139, "Orange"),
    /** Light Pink */
    LIGHT_PINK (140, "Light Pink"),
    /** Pink */
    PINK (141, "Pink"),
    /** Gold */
    GOLD (142, "Gold"),
    /** Peach Puff */
    PEACH_PUFF (143, "Peach Puff"),
    /** Navajo White */
    NAVAJO_WHITE (144, "Navajo White"),
    /** Moccasin */
    MOCCASIN (145, "Moccasin"),
    /** Bisque */
    BISQUE (146, "Bisque"),
    /** Misty Rose */
    MISTY_ROSE (147, "Misty Rose"),
    /** Blanched Almond */
    BLANCHED_ALMOND (148, "Blanched Almond"),
    /** Papaya Whip */
    PAPAYA_WHIP (149, "Papaya Whip"),
    /** Lavender Blush */
    LAVENDER_BLUSH (150, "Lavender Blush"),
    /** Sea Shell */
    SEA_SHELL (151, "Sea Shell"),
    /** Cornsilk */
    CORNSILK (152, "Cornsilk"),
    /** Lemon Chiffon */
    LEMON_CHIFFON (153, "Lemon Chiffon"),
    /** Floral White */
    FLORAL_WHITE (154, "Floral White"),
    /** Snow */
    SNOW (155, "Snow"),
    /** Yellow */
    YELLOW (156, "Yellow"),
    /** Light Yellow */
    LIGHT_YELLOW (157, "Light Yellow"),
    /** Ivory */
    IVORY (158, "Ivory"),
    /** White */
    WHITE (159, "White");

    private int value;
    private final String description;

    Color(int value, String description)
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

    public static Color getEnumForValue(int i)
    {
       for(Color val: Color.values()) {
          if(val.getValue()==i)
              return val;
       }
       System.err.println("No enumeration found for value " + i + " of enumeration Color");
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

    public static Color unmarshalEnum (DataInputStream dis) throws Exception
    {
       /* try {
            value = dis.readUnsignedByte();
        }
        catch(IOException ex) {
            showError(ex);
        } */
        
        return getEnumForValue(dis.readByte());
    } 

    public static Color unmarshalEnum(ByteBuffer buff) throws Exception
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
        return "Color: " + name() + ": " + getValue(); 
    }
}
