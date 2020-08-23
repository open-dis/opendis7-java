package edu.nps.moves.dis7.enumerations;

import java.nio.ByteBuffer;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import edu.nps.moves.dis7.*;

/**
 * Generated from XML, SISO-REF-010-v28, 2020-05-07<br>
 * UID 321 marshal size 8<br>
 * ____________________________________
 */
public enum EntityAssociationGroupMemberType 
{
    /** Not Part of a Group */
    NOT_PART_OF_A_GROUP (0, "Not Part of a Group"),
    /** Group Leader */
    GROUP_LEADER (1, "Group Leader"),
    /** Group Member */
    GROUP_MEMBER (2, "Group Member"),
    /** Formation Leader */
    FORMATION_LEADER (3, "Formation Leader"),
    /** Formation Member */
    FORMATION_MEMBER (4, "Formation Member"),
    /** Convoy Leader */
    CONVOY_LEADER (5, "Convoy Leader"),
    /** Convoy Member */
    CONVOY_MEMBER (6, "Convoy Member");

    private int value;
    private final String description;

    EntityAssociationGroupMemberType(int value, String description)
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

    public static EntityAssociationGroupMemberType getEnumForValue(int i)
    {
       for(EntityAssociationGroupMemberType val: EntityAssociationGroupMemberType.values()) {
          if(val.getValue()==i)
              return val;
       }
       System.err.println("No enumeration found for value " + i + " of enumeration EntityAssociationGroupMemberType");
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

    public static EntityAssociationGroupMemberType unmarshalEnum (DataInputStream dis) throws Exception
    {
       /* try {
            value = dis.readUnsignedByte();
        }
        catch(IOException ex) {
            showError(ex);
        } */
        
        return getEnumForValue(dis.readByte());
    } 

    public static EntityAssociationGroupMemberType unmarshalEnum(ByteBuffer buff) throws Exception
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

    /** Returns the size of this serialized object in bytes
     *@return size in bytes*/  
    public int getMarshalledSize()
    {
        return 1; // 8 bits
    }
    
    @Override
    public String toString()
    {
        return "EntityAssociationGroupMemberType: " + name() + ": " + getValue(); 
    }
}
