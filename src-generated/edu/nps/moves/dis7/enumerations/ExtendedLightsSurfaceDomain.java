// autogenerated using string template disbitset1.txt

package edu.nps.moves.dis7.enumerations;

import edu.nps.moves.dis7.pdus.*;

/**
 * Generated from XML,
 *  UID 550, marshal size 32,
 * ExtendedLightsSurfaceDomain
 */
public class ExtendedLightsSurfaceDomain extends DisBitSet 
{

  // autogenerated using string template disbitsetcommentxref.txt
  /**
   * (bit position 0, length=3) Describes the intensity (brightness) of the lights,  use {@link SpecialLightsIntensity} values for this field
   */
  // autogenerated using string template disbitset16.txt
  public static Bits LIGHTINTENSITY = new Bits(0, 3, SpecialLightsIntensity.class);

  // autogenerated using string template disbitsetcommentxref.txt
  /**
   * (bit position 3, length=2) Describes the current flight deck status light color,  use {@link DeckStatusLightColor} values for this field
   */
  // autogenerated using string template disbitset16.txt
  public static Bits DECKSTATUSLIGHTCOLOR = new Bits(3, 2, DeckStatusLightColor.class);

  // autogenerated using string template disbitsetcomment.txt
  /**
   * (bit position 5, boolean) Describes whether the flight deck floodlights are on or off
   */
  // autogenerated using string template disbitset15.txt
  public static Bits FLIGHTDECKFLOODLIGHTSON = new Bits(5, 1);

  // autogenerated using string template disbitsetcomment.txt
  /**
   * (bit position 6, boolean) Describes whether the flight deck beacons are on or off
   */
  // autogenerated using string template disbitset15.txt
  public static Bits FLIGHTDECKBEACONSON = new Bits(6, 1);

  // autogenerated using string template disbitsetcomment.txt
  /**
   * (bit position 7, boolean) Describes whether the flight deck spotlights are on or off
   */
  // autogenerated using string template disbitset15.txt
  public static Bits FLIGHTDECKSPOTLIGHTSON = new Bits(7, 1);

  // autogenerated using string template disbitsetcomment.txt
  /**
   * (bit position 8, boolean) Describes whether the flight deck edge lights are on or off
   */
  // autogenerated using string template disbitset15.txt
  public static Bits FLIGHTDECKEDGELIGHTSON = new Bits(8, 1);

  // autogenerated using string template disbitsetcomment.txt
  /**
   * (bit position 9, boolean) Describes whether the lineup lights are on or off
   */
  // autogenerated using string template disbitset15.txt
  public static Bits LINEUPLIGHTSON = new Bits(9, 1);

  // autogenerated using string template disbitsetcomment.txt
  /**
   * (bit position 10, boolean) Describes whether the vertical dropline lights are on or off
   */
  // autogenerated using string template disbitset15.txt
  public static Bits VERTICALDROPLINELIGHTSON = new Bits(10, 1);

  // autogenerated using string template disbitsetcomment.txt
  /**
   * (bit position 11, boolean) Describes whether the wave-off lights are on or off
   */
  // autogenerated using string template disbitset15.txt
  public static Bits WAVEOFFLIGHTSON = new Bits(11, 1);

  // autogenerated using string template disbitsetcomment.txt
  /**
   * (bit position 12, boolean) Describes whether the stabilized glideslope indicator light is on or off
   */
  // autogenerated using string template disbitset15.txt
  public static Bits STABILIZEDGLIDESLOPEINDICATORLIGHTON = new Bits(12, 1);
  // autogenerated using string template disbitset2.txt
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
  public ExtendedLightsSurfaceDomain()
  {
    super(32); // length from bitfield element
  }

  /** Default constructor with parameters
   * @param wh Bits custom data structure
   * @param value bits of interest  */
  public ExtendedLightsSurfaceDomain(Bits wh, int value)
  {
    this();
    set(wh,value);
  }

  /** Accessor method to set value
   * @param wh Bits custom data structure
   * @param value bits of interest
   * @return this object */
  public ExtendedLightsSurfaceDomain set(Bits wh, int value)
  {
    //if((value & ~wh.inputmask) != 0)
    //  throw new EnumNotFoundException("bad bits passed to "+getClass().getSimpleName()+", field "+wh.name() + " cannot be "+value);

    setbits(wh.position,wh.length,value);
    return this;
  }
/*
  public ExtendedLightsSurfaceDomain set(Bits wh, Object val) throws Exception
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
  public ExtendedLightsSurfaceDomain set(int start, int length, int value)
  {
      setbits(start,length,value);
      return this;
  }

  /** Provide string representation
   * @return string representation */
  @Override
  public String toString()
  {
      return "ExtendedLightsSurfaceDomain: " + super.toString();
  }
}