package edu.nps.moves.dis7.enumerations;

import edu.nps.moves.dis7.pdus.*;

/**
 * Generated from XML, <br>
 * UID 232 marshal size 16<br>
 * PointObjectAppearanceAirGroundBurst
 */
public class PointObjectAppearanceAirGroundBurst extends DisBitSet 
{
  /**
   * 8-bit unsigned integer indicating the percent opacity of the smoke (0..100)
   */
  public static Bits OPACITYPERCENT = new Bits(0, 8);
  /**
   * 8-bit unsigned integer indicating the radius in meters of the cylinder which approximates an individual burst
   */
  public static Bits SIZE = new Bits(8, 8);
  /**
   * 8-bit unsigned integer indicating the height in meters of the cylinder which approximates an individual burst
   */
  public static Bits HEIGHT = new Bits(16, 8);
  /**
   * 6-bit unsigned integer indicating the number of bursts in the instance of tactical smoke
   */
  public static Bits NUMBEROFBURSTS = new Bits(24, 6);
  /**
   * Describes the chemical content of the smoke, Use {@link AppearanceObjectSpecificChemicalType} values for this field
   */
  public static Bits CHEMICALTYPE = new Bits(30, 2, AppearanceObjectSpecificChemicalType.class);

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
  public PointObjectAppearanceAirGroundBurst()
  {
    super(16); // length from bitfield element
  }

  /** Default constructor with parameters
   * @param wh Bits custom data structure
   * @param value bits of interest  */
  public PointObjectAppearanceAirGroundBurst(Bits wh, int value)
  {
    this();
    set(wh,value);
  }

  /** Accessor method to set value
   * @param wh Bits custom data structure
   * @param value bits of interest
   * @return this object */
  public PointObjectAppearanceAirGroundBurst set(Bits wh, int value)
  {
    //if((value & ~wh.inputmask) != 0)
    //  throw new EnumNotFoundException("bad bits passed to "+getClass().getSimpleName()+", field "+wh.name() + " cannot be "+value);

    setbits(wh.position,wh.length,value);
    return this;
  }
/*
  public PointObjectAppearanceAirGroundBurst set(Bits wh, Object val) throws Exception
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
  public PointObjectAppearanceAirGroundBurst set(int start, int length, int value)
  {
      setbits(start,length,value);
      return this;
  }

  /** Provide string representation
   * @return string representation */
  @Override
  public String toString()
  {
      return "PointObjectAppearanceAirGroundBurst: " + super.toString();
  }
}
