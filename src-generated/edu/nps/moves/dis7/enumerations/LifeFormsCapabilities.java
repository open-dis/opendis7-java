package edu.nps.moves.dis7.enumerations;

import edu.nps.moves.dis7.*;

/**
 * Generated from XML, SISO-REF-010-v25, 2018-08-29<br>
 * UID 456 marshal size 32<br>
 * Life Forms Capabilities
 */
public class LifeFormsCapabilities extends DisBitSet implements EntityCapabilities
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

  public LifeFormsCapabilities()
  {
    super(32); // length from bitfield element
  }

  public LifeFormsCapabilities(Bits wh, int i)
  {
    this();
    set(wh,i);
  }

  public LifeFormsCapabilities set(Bits wh, int val)
  {
    //if((val & ~wh.inputmask) != 0)
    //  throw new EnumNotFoundException("bad bits passed to "+getClass().getSimpleName()+", field "+wh.name() + " cannot be "+val);

    setbits(wh.position,wh.length,val);
    return this;
  }
/*
  public LifeFormsCapabilities set(Bits wh, Object val) throws Exception
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
  public LifeFormsCapabilities set(int start, int length, int val)
  {
      setbits(start,length,val);
      return this;
  }
  
  @Override
  public String toString()
  {
      return "LifeFormsCapabilities: " + super.toString();
  }
}
