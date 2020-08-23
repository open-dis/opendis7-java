package edu.nps.moves.dis7.enumerations;

import edu.nps.moves.dis7.*;

/**
 * Generated from XML, SISO-REF-010-v28, 2020-05-07<br>
 * UID 32 marshal size 32<br>
 * _______________________
 */
public class AirPlatformAppearance extends DisBitSet 
{
  /**
   * Describes the visual paint design, Use {@link AppearancePaintScheme} values for this field
   */
  public static Bits undef = new Bits(0, 1, AppearancePaintScheme.class);
  /**
   * Describes whether it is capable of moving on its own power
   */
  public static Bits undef_2 = new Bits(1, 1);
  /**
   * Describes whether air platform lighting is in covert or overt mode, Use {@link AppearanceNVGMode} values for this field
   */
  public static Bits undef_3 = new Bits(2, 1, AppearanceNVGMode.class);
  /**
   * Describes the damaged appearance, Use {@link AppearanceDamage} values for this field
   */
  public static Bits undef_4 = new Bits(3, 2, AppearanceDamage.class);
  /**
   * Describes whether or not smoke is emanating from the entity
   */
  public static Bits undef_5 = new Bits(5, 1);
  /**
   * Describes whether or not the engine is emitting smoke
   */
  public static Bits undef_6 = new Bits(6, 1);
  /**
   * Describes the size of the contrails or ionization trailing effects, Use {@link AppearanceTrailingEffects} values for this field
   */
  public static Bits undef_7 = new Bits(7, 2, AppearanceTrailingEffects.class);
  /**
   * Describes the state of the canopy/troop door, Use {@link AppearanceCanopy} values for this field
   */
  public static Bits undef_8 = new Bits(9, 3, AppearanceCanopy.class);
  /**
   * Describes whether landing lights are on or off
   */
  public static Bits undef_9 = new Bits(12, 1);
  /**
   * Describes whether navigation lights are on or off
   */
  public static Bits undef_10 = new Bits(13, 1);
  /**
   * Describes whether Anti-Collision lights are on or off
   */
  public static Bits undef_11 = new Bits(14, 1);
  /**
   * Describes whether the entity is burning and flames are visible
   */
  public static Bits undef_12 = new Bits(15, 1);
  /**
   * Describes if the air platform is in afterburner
   */
  public static Bits undef_13 = new Bits(16, 1);
  /**
   * Describes whether the lower Anti-Collision light is on or off
   */
  public static Bits undef_14 = new Bits(17, 1);
  /**
   * Describes whether the upper Anti-Collision light is on or off
   */
  public static Bits undef_15 = new Bits(18, 1);
  /**
   * Describes the day/night status of the Anti-Collision lights, Use {@link AppearanceAntiCollisionDayNight} values for this field
   */
  public static Bits undef_16 = new Bits(19, 1, AppearanceAntiCollisionDayNight.class);
  /**
   * Indicates whether any air platform lights are blinking or not
   */
  public static Bits undef_17 = new Bits(20, 1);
  /**
   * Describes whether the entity is frozen and should not be dead reckoned
   */
  public static Bits undef_18 = new Bits(21, 1);
  /**
   * Describes whether the power plant is on or off
   */
  public static Bits undef_19 = new Bits(22, 1);
  /**
   * Describes whether the entity is active or deactivated, Use {@link AppearanceEntityorObjectState} values for this field
   */
  public static Bits undef_20 = new Bits(23, 1, AppearanceEntityorObjectState.class);
  /**
   * Describes whether formation lights are on or off
   */
  public static Bits undef_21 = new Bits(24, 1);
  /**
   * Describes whether the landing gear is wholly retracted or extended
   */
  public static Bits undef_22 = new Bits(25, 1);
  /**
   * Describes whether the cargo doors (main door) are closed or open
   */
  public static Bits undef_23 = new Bits(26, 1);
  /**
   * Describes the brightness of the navigation/position lights, Use {@link AppearanceNavigationPositionBrightness} values for this field
   */
  public static Bits undef_24 = new Bits(27, 1, AppearanceNavigationPositionBrightness.class);
  /**
   * Describes whether spot/search light #1 is on or off
   */
  public static Bits undef_25 = new Bits(28, 1);
  /**
   * Describes whether interior lights are on or off
   */
  public static Bits undef_26 = new Bits(29, 1);
  /**
   * Describes whether the air platform has engaged reverse thrust
   */
  public static Bits undef_27 = new Bits(30, 1);
  /**
   * Describes whether the air platform has weight on its main landing gear
   */
  public static Bits undef_28 = new Bits(31, 1);

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

  public AirPlatformAppearance()
  {
    super(32); // length from bitfield element
  }

  public AirPlatformAppearance(Bits wh, int i)
  {
    this();
    set(wh,i);
  }

  public AirPlatformAppearance set(Bits wh, int val)
  {
    //if((val & ~wh.inputmask) != 0)
    //  throw new EnumNotFoundException("bad bits passed to "+getClass().getSimpleName()+", field "+wh.name() + " cannot be "+val);

    setbits(wh.position,wh.length,val);
    return this;
  }
/*
  public AirPlatformAppearance set(Bits wh, Object val) throws Exception
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
  public AirPlatformAppearance set(int start, int length, int val)
  {
      setbits(start,length,val);
      return this;
  }
  
  @Override
  public String toString()
  {
      return "AirPlatformAppearance: " + super.toString();
  }
}
