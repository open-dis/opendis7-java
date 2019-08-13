package edu.nps.moves.dis7.enumerations;

import edu.nps.moves.dis7.*;

/**
 * Generated from XML, SISO-REF-010-v25, 2018-08-29<br>
 * UID 31 marshal size 32<br>
 * Land Platform Appearance
 */
public class LandPlatformAppearance extends DisBitSet 
{
  /**
   * Describes the visual paint design, Use {@link AppearancePaintScheme} values for this field
   */
  public static Bits PAINT_SCHEME = new Bits(0, 1, AppearancePaintScheme.class);
  /**
   * Describes whether it is capable of moving on its own power
   */
  public static Bits MOBILITY_KILLED = new Bits(1, 1);
  /**
   * Describes whether it can fire weapons
   */
  public static Bits FIRE_POWER_KILLED = new Bits(2, 1);
  /**
   * Describes the damaged appearance, Use {@link AppearanceDamage} values for this field
   */
  public static Bits DAMAGE = new Bits(3, 2, AppearanceDamage.class);
  /**
   * Describes whether or not smoke is emanating from the entity
   */
  public static Bits IS_SMOKE_EMANATING = new Bits(5, 1);
  /**
   * Describes whether or not the engine is emitting smoke
   */
  public static Bits IS_ENGINE_EMITTING_SMOKE = new Bits(6, 1);
  /**
   * Describes the size of the dust cloud trailing effect, Use {@link AppearanceTrailingEffects} values for this field
   */
  public static Bits TRAILING_DUST_CLOUD = new Bits(7, 2, AppearanceTrailingEffects.class);
  /**
   * Describes whether the primary hatch is open or closed and whether someone is visible, Use {@link AppearanceHatch} values for this field
   */
  public static Bits PRIMARY_HATCH = new Bits(9, 3, AppearanceHatch.class);
  /**
   * Describes whether head lights are on or off
   */
  public static Bits HEAD_LIGHTS_ON = new Bits(12, 1);
  /**
   * Describes whether tail lights are on or off
   */
  public static Bits TAIL_LIGHTS_ON = new Bits(13, 1);
  /**
   * Describes whether brake lights are on or off
   */
  public static Bits BRAKE_LIGHTS_ON = new Bits(14, 1);
  /**
   * Describes whether the entity is burning and flames are visible
   */
  public static Bits IS_FLAMING = new Bits(15, 1);
  /**
   * Describes the status of the mechanism required for the platform to be operational, such as the elevated status of the primary launcher, Use {@link AppearanceLauncherOperational} values for this field
   */
  public static Bits LAUNCHER_OPERATIONAL = new Bits(16, 1, AppearanceLauncherOperational.class);
  /**
   * Describes the camouflage color, Use {@link AppearanceCamouflageType} values for this field
   */
  public static Bits CAMOUFLAGE_TYPE = new Bits(17, 2, AppearanceCamouflageType.class);
  /**
   * Describes the type of concealment, Use {@link AppearanceConcealedPosition} values for this field
   */
  public static Bits CONCEALED_POSITION = new Bits(19, 1, AppearanceConcealedPosition.class);
  /**
   * Describes whether the entity is frozen and should not be dead reckoned
   */
  public static Bits IS_FROZEN = new Bits(21, 1);
  /**
   * Describes whether the power plant is on or off
   */
  public static Bits POWER_PLANT_ON = new Bits(22, 1);
  /**
   * Describes whether the entity is active or deactivated, Use {@link AppearanceEntityorObjectState} values for this field
   */
  public static Bits STATE = new Bits(23, 1, AppearanceEntityorObjectState.class);
  /**
   * Describes whether or not the tent is extended
   */
  public static Bits TENT_EXTENDED = new Bits(24, 1);
  /**
   * Describes whether or not the ramp is extended
   */
  public static Bits RAMP_EXTENDED = new Bits(25, 1);
  /**
   * Describes whether blackout lights are on or off
   */
  public static Bits BLACKOUT_LIGHTS_ON = new Bits(26, 1);
  /**
   * Describes whether blackout brake lights are on or off
   */
  public static Bits BLACKOUT_BRAKE_LIGHTS_ON = new Bits(27, 1);
  /**
   * Describes whether spot/search light #1 is on or off
   */
  public static Bits SPOT_SEARCH_LIGHT_1_ON = new Bits(28, 1);
  /**
   * Describes whether interior lights (forward) are on or off
   */
  public static Bits INTERIOR_LIGHTS_FORWARD_ON = new Bits(29, 1);
  /**
   * Describes whether or not the vehicle occupants have surrendered
   */
  public static Bits OCCUPANTS_SURRENDERED = new Bits(30, 1);
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

  public LandPlatformAppearance()
  {
    super(32); // length from bitfield element
  }

  public LandPlatformAppearance(Bits wh, int i)
  {
    this();
    set(wh,i);
  }

  public LandPlatformAppearance set(Bits wh, int val)
  {
    //if((val & ~wh.inputmask) != 0)
    //  throw new EnumNotFoundException("bad bits passed to "+getClass().getSimpleName()+", field "+wh.name() + " cannot be "+val);

    setbits(wh.position,wh.length,val);
    return this;
  }
/*
  public LandPlatformAppearance set(Bits wh, Object val) throws Exception
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
  public LandPlatformAppearance set(int start, int length, int val)
  {
      setbits(start,length,val);
      return this;
  }
}
