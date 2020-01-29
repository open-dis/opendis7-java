package edu.nps.moves.dis7.enumerations;

import edu.nps.moves.dis7.*;

/**
 * Generated from XML, SISO-REF-010-v25, 2018-08-29<br>
 * UID 38 marshal size 32<br>
 * Environmental Appearance
 */
public class EnvironmentalAppearance extends DisBitSet 
{
  /**
   * Describes the density, Use {@link AppearanceEnvironmentalDensity} values for this field
   */
  public static Bits DENSITY = new Bits(16, 4, AppearanceEnvironmentalDensity.class);
  /**
   * Describes whether the entity is frozen and should not be dead reckoned
   */
  public static Bits IS_FROZEN = new Bits(21, 1);
  /**
   * Describes whether the entity is active or deactivated, Use {@link AppearanceEntityorObjectState} values for this field
   */
  public static Bits STATE = new Bits(23, 1, AppearanceEntityorObjectState.class);
  /**
   * Describes whether or not the entity is masked or cloaked
   */
  public static Bits MASKED_CLOAKED = new Bits(31, 1);

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

  public EnvironmentalAppearance()
  {
    super(32); // length from bitfield element
  }

  public EnvironmentalAppearance(Bits wh, int i)
  {
    this();
    set(wh,i);
  }

  public EnvironmentalAppearance set(Bits wh, int val)
  {
    //if((val & ~wh.inputmask) != 0)
    //  throw new EnumNotFoundException("bad bits passed to "+getClass().getSimpleName()+", field "+wh.name() + " cannot be "+val);

    setbits(wh.position,wh.length,val);
    return this;
  }
/*
  public EnvironmentalAppearance set(Bits wh, Object val) throws Exception
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
  public EnvironmentalAppearance set(int start, int length, int val)
  {
      setbits(start,length,val);
      return this;
  }
  
  @Override
  public String toString()
  {
      return "EnvironmentalAppearance: " + super.toString();
  }
}
