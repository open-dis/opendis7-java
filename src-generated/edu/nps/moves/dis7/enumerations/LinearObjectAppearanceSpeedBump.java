package edu.nps.moves.dis7.enumerations;

import edu.nps.moves.dis7.*;

/**
 * Generated from XML, SISO-REF-010-v25, 2018-08-29<br>
 * UID 489 marshal size 32<br>
 * Linear Object Appearance-Speed Bump
 */
public class LinearObjectAppearanceSpeedBump extends DisBitSet 
{
  /**
   * 8-bit enumeration indicating the color, Use {@link Color} values for this field
   */
  public static Bits COLOR = new Bits(0, 8, Color.class);
  /**
   * 4-bit unsigned integer indicating 16 levels of contrast (low to high) distinguishing variation of object from surrounding surface
   */
  public static Bits CONTRAST = new Bits(16, 4);
  /**
   * 4-bit enumeration indicating the type of material, Use {@link Material} values for this field
   */
  public static Bits MATERIAL = new Bits(20, 4, Material.class);

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

  public LinearObjectAppearanceSpeedBump()
  {
    super(32); // length from bitfield element
  }

  public LinearObjectAppearanceSpeedBump(Bits wh, int i)
  {
    this();
    set(wh,i);
  }

  public LinearObjectAppearanceSpeedBump set(Bits wh, int val)
  {
    //if((val & ~wh.inputmask) != 0)
    //  throw new EnumNotFoundException("bad bits passed to "+getClass().getSimpleName()+", field "+wh.name() + " cannot be "+val);

    setbits(wh.position,wh.length,val);
    return this;
  }
/*
  public LinearObjectAppearanceSpeedBump set(Bits wh, Object val) throws Exception
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
  public LinearObjectAppearanceSpeedBump set(int start, int length, int val)
  {
      setbits(start,length,val);
      return this;
  }
  
  @Override
  public String toString()
  {
      return "LinearObjectAppearanceSpeedBump: " + super.toString();
  }
}
