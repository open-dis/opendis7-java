package edu.nps.moves.dis7.enumerations;

import edu.nps.moves.dis7.*;

/**
 * Generated from XML, SISO-REF-010-v25, 2018-08-29<br>
 * UID 485 marshal size 32<br>
 * Point Object Appearance-Disturbed Earth / Road
 */
public class PointObjectAppearanceDisturbedEarthRoad extends DisBitSet 
{
  /**
   * 8-bit unsigned integer indicating the diameter in decimeters
   */
  public static Bits DIAMETER = new Bits(0, 8);
  /**
   * 8-bit unsigned integer indicating the height in centimeters
   */
  public static Bits HEIGHT = new Bits(8, 8);
  /**
   * 4-bit unsigned integer indicating 16 levels of contrast (low to high) distinguishing variation of object from surrounding surface
   */
  public static Bits CONTRAST = new Bits(16, 4);

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

  public PointObjectAppearanceDisturbedEarthRoad()
  {
    super(32); // length from bitfield element
  }

  public PointObjectAppearanceDisturbedEarthRoad(Bits wh, int i)
  {
    this();
    set(wh,i);
  }

  public PointObjectAppearanceDisturbedEarthRoad set(Bits wh, int val)
  {
    //if((val & ~wh.inputmask) != 0)
    //  throw new EnumNotFoundException("bad bits passed to "+getClass().getSimpleName()+", field "+wh.name() + " cannot be "+val);

    setbits(wh.position,wh.length,val);
    return this;
  }
/*
  public PointObjectAppearanceDisturbedEarthRoad set(Bits wh, Object val) throws Exception
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
  public PointObjectAppearanceDisturbedEarthRoad set(int start, int length, int val)
  {
      setbits(start,length,val);
      return this;
  }
  
  @Override
  public String toString()
  {
      return "PointObjectAppearanceDisturbedEarthRoad: " + super.toString();
  }
}
