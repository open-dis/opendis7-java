package edu.nps.moves.dis7.enumerations;

import edu.nps.moves.dis7.*;

/**
 * Generated from XML, SISO-REF-010-v25, 2018-08-29<br>
 * UID 450 marshal size 32<br>
 * Land Platform Capabilities
 */
public class LandPlatformCapabilities extends DisBitSet implements EntityCapabilities
{
  /**
   * Describes whether the entity is able to supply some type of ammunition in response to an appropriate service request
   */
  public static Bits AMMUNITION_SUPPLY = new Bits(0, 1);
  /**
   * Describes whether the entity is able to supply some type of fuel in response to an appropriate service request
   */
  public static Bits FUEL_SUPPLY = new Bits(1, 1);
  /**
   * Describes whether the entity is able to provide recovery (e.g., towing) services in response to an appropriate service request
   */
  public static Bits RECOVERY = new Bits(2, 1);
  /**
   * Describes whether the entity is able to supply certain repair services in response to an appropriate service request
   */
  public static Bits REPAIR = new Bits(3, 1);
  /**
   * This entry is reserved for backward compatibility and may not be reused
   */
  public static Bits RESERVED = new Bits(4, 1);
  /**
   * The Entity is able to be carried as a sling load payload.  The extended appearance record (if available) will identify if it is currently sling loaded and entity association and/or entity offset records (if available) will provide additional sling load details (such as carrier).
   */
  public static Bits SLING_LOADABLE = new Bits(6, 1);
  /**
   * The Entity is an IED or contains an IED.  The extended appearance record (if available) will identify how well hidden the IED is on the Entity.  An Attached Part (if applicable, for instance a jury-rigged munition does not apply here) will identify the IED explicitly.
   */
  public static Bits IED_PRESENCE_INDICATOR = new Bits(7, 1);
  /**
   * The Entity (normally a virtual manned module) can be task organized into an existing mixed mode unit (where mixed mode is intended to comprise a combination of computer-generated forces and virtual or even live forces).
   */
  public static Bits TASK_ORGANIZABLE = new Bits(8, 1);

  public static class Bits
  {
    private int position;
    private int length;
    private int inputmask;
    private Class cls;

    private Bits(int position) {
      this(position,1, null);
    }
    
    private Bits(int position, Class cls) {
      this(position,1, cls);
    }

    private Bits(int position, int length ) {
      this(position,length,null);
    }

    private Bits(int position, int length, Class cls) {
      this.position = position;
      this.length = length;
      this.cls = cls;
      inputmask = calculateMask(length);
    }
  }

  public LandPlatformCapabilities()
  {
    super(32); // length from bitfield element
  }

  public LandPlatformCapabilities(Bits wh, int i)
  {
    this();
    set(wh,i);
  }

  public LandPlatformCapabilities set(Bits wh, int val)
  {
    //if((val & ~wh.inputmask) != 0)
    //  throw new EnumNotFoundException("bad bits passed to "+getClass().getSimpleName()+", field "+wh.name() + " cannot be "+val);

    setbits(wh.position,wh.length,val);
    return this;
  }
/*
  public LandPlatformCapabilities set(Bits wh, Object val) throws Exception
  {
    if(val.getClass() != wh.cls)
      throw new EnumNotFoundException("bad enum passed to "+getClass().getSimpleName()+", field "+wh.name() + " cannot be "+val.getClass().getSimpleName());;
    Method getValueMethod = wh.cls.getMethod("getValue",null);
    int bits = (int)getValueMethod.invoke(val, (Object[])null);
    setbits(wh.position,wh.length,bits);
    return this;
  }
*/
  // Some bitfields are defined without specific bits enumerated 
  public LandPlatformCapabilities set(int start, int length, int val)
  {
      setbits(start,length,val);
      return this;
  }
  
  @Override
  public String toString()
  {
      return "LandPlatformCapabilities: " + super.toString();
  }
}
