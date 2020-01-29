package edu.nps.moves.dis7.enumerations;

import edu.nps.moves.dis7.*;

/**
 * Generated from XML, SISO-REF-010-v25, 2018-08-29<br>
 * UID 480 marshal size 32<br>
 * Non-Human Life Forms Appearance
 */
public class NonHumanLifeFormsAppearance extends DisBitSet 
{
  /**
   * Describes the visual appearance of the severity of any injury, Use {@link AppearanceLifeformHealth} values for this field
   */
  public static Bits HEALTH = new Bits(3, 2, AppearanceLifeformHealth.class);
  /**
   * Describes whether the entity is frozen and should not be dead reckoned
   */
  public static Bits IS_FROZEN = new Bits(21, 1);
  /**
   * Describes whether or not the life form is mounted/hoisted on another platform, such as a troop transport or helicopter hoist
   */
  public static Bits MOUNTED_HOISTED_STATUS = new Bits(22, 1);
  /**
   * Describes whether the entity is active or deactivated, Use {@link AppearanceEntityorObjectState} values for this field
   */
  public static Bits STATE = new Bits(23, 1, AppearanceEntityorObjectState.class);

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

  public NonHumanLifeFormsAppearance()
  {
    super(32); // length from bitfield element
  }

  public NonHumanLifeFormsAppearance(Bits wh, int i)
  {
    this();
    set(wh,i);
  }

  public NonHumanLifeFormsAppearance set(Bits wh, int val)
  {
    //if((val & ~wh.inputmask) != 0)
    //  throw new EnumNotFoundException("bad bits passed to "+getClass().getSimpleName()+", field "+wh.name() + " cannot be "+val);

    setbits(wh.position,wh.length,val);
    return this;
  }
/*
  public NonHumanLifeFormsAppearance set(Bits wh, Object val) throws Exception
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
  public NonHumanLifeFormsAppearance set(int start, int length, int val)
  {
      setbits(start,length,val);
      return this;
  }
  
  @Override
  public String toString()
  {
      return "NonHumanLifeFormsAppearance: " + super.toString();
  }
}
