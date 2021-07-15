package edu.nps.moves.dis7.enumerations;

import edu.nps.moves.dis7.pdus.*;

/**
 * Generated from XML, <br>
 * UID 236 marshal size 16<br>
 * LinearObjectAppearanceExhaustsmoke
 */
public class LinearObjectAppearanceExhaustSmoke extends DisBitSet 
{
  /**
   * 8-bit unsigned integer indicating the percent opacity of the smoke (0..100)
   */
  public static Bits OPACITYPERCENT = new Bits(0, 8);
  /**
   * Describes whether or not the smoke is attached to the vehicle
   */
  public static Bits SMOKEISATTACHED = new Bits(8, 1);
  /**
   * Describes the chemical content of the smoke, Use {@link AppearanceObjectSpecificChemicalType} values for this field
   */
  public static Bits CHEMICALTYPE = new Bits(9, 2, AppearanceObjectSpecificChemicalType.class);

  /** Internal class */
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

  /** Default constructor */
  public LinearObjectAppearanceExhaustSmoke()
  {
    super(16); // length from bitfield element
  }

  /** Default constructor with parameters
   * @param wh Bits custom data structure
   * @param value bits of interest  */
  public LinearObjectAppearanceExhaustSmoke(Bits wh, int value)
  {
    this();
    set(wh,value);
  }

  /** Accessor method to set value
   * @param wh Bits custom data structure
   * @param value bits of interest
   * @return this object */
  public LinearObjectAppearanceExhaustSmoke set(Bits wh, int value)
  {
    //if((value & ~wh.inputmask) != 0)
    //  throw new EnumNotFoundException("bad bits passed to "+getClass().getSimpleName()+", field "+wh.name() + " cannot be "+value);

    setbits(wh.position,wh.length,value);
    return this;
  }
/*
  public LinearObjectAppearanceExhaustSmoke set(Bits wh, Object val) throws Exception
  {
    if(val.getClass() != wh.cls)
      throw new EnumNotFoundException("bad enum passed to "+getClass().getSimpleName()+", field "+wh.name() + " cannot be "+val.getClass().getSimpleName());;
    Method getValueMethod = wh.cls.getMethod("getValue",null);
    int bits = (int)getValueMethod.invoke(val, (Object[])null);
    setbits(wh.position,wh.length,bits);
    return this;
  }
*/
  /** Some bitfields are defined without specific bits enumerated
   * @param start initial position in bit array
   * @param length number of bits
   * @param value bits of interest
   * @return this object */
  public LinearObjectAppearanceExhaustSmoke set(int start, int length, int value)
  {
      setbits(start,length,value);
      return this;
  }

  /** Provide string representation
   * @return string representation */
  @Override
  public String toString()
  {
      return "LinearObjectAppearanceExhaustSmoke: " + super.toString();
  }
}
