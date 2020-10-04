package edu.nps.moves.dis7.enumerations;

import edu.nps.moves.dis7.pdus.*;

/**
 * Generated from XML, SISO-REF-010-v28, 2020-05-07<br>
 * UID 235 marshal size 16<br>
 * LinearObjectAppearanceTankDitchandConcertinaWire
 */
public class LinearObjectAppearanceTankDitchAndConcertinaWire extends DisBitSet 
{
  /**
   * Describes the breached appearance of the object, Use {@link AppearanceLinearObjectTankDitchBreach} values for this field
   */
  public static Bits BREACHSTATE = new Bits(0, 2, AppearanceLinearObjectTankDitchBreach.class);
  /**
   * 8-bit unsigned integer indicating the fixed length in meters of a breached segment
   */
  public static Bits BREACHLENGTH = new Bits(16, 8);
  /**
   * 8-bit record where each bit indicates whether its associated segment is breached or not, such that bit 0 of the record is the first segment
   */
  public static Bits BREACHLOCATION = new Bits(24, 8);

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

  public LinearObjectAppearanceTankDitchAndConcertinaWire()
  {
    super(16); // length from bitfield element
  }

  public LinearObjectAppearanceTankDitchAndConcertinaWire(Bits wh, int i)
  {
    this();
    set(wh,i);
  }

  public LinearObjectAppearanceTankDitchAndConcertinaWire set(Bits wh, int val)
  {
    //if((val & ~wh.inputmask) != 0)
    //  throw new EnumNotFoundException("bad bits passed to "+getClass().getSimpleName()+", field "+wh.name() + " cannot be "+val);

    setbits(wh.position,wh.length,val);
    return this;
  }
/*
  public LinearObjectAppearanceTankDitchAndConcertinaWire set(Bits wh, Object val) throws Exception
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
  public LinearObjectAppearanceTankDitchAndConcertinaWire set(int start, int length, int val)
  {
      setbits(start,length,val);
      return this;
  }
  
  @Override
  public String toString()
  {
      return "LinearObjectAppearanceTankDitchAndConcertinaWire: " + super.toString();
  }
}
