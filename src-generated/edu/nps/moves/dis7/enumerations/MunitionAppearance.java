package edu.nps.moves.dis7.enumerations;

import edu.nps.moves.dis7.*;

/**
 * Generated from XML, SISO-REF-010-v25, 2018-08-29<br>
 * UID 36 marshal size 32<br>
 * Munition Appearance
 */
public class MunitionAppearance extends DisBitSet 
{
  /**
   * Describes the damaged appearance, Use {@link AppearanceDamage} values for this field
   */
  public static Bits DAMAGE = new Bits(3, 2, AppearanceDamage.class);
  /**
   * Describes whether or not smoke or vapor is emanating from the entity
   */
  public static Bits IS_SMOKE_VAPOR_EMANATING = new Bits(5, 1);
  /**
   * Describes whether or not the engine is emitting smoke
   */
  public static Bits IS_ENGINE_EMITTING_SMOKE = new Bits(6, 1);
  /**
   * Describes the size of the vapor trail, Use {@link AppearanceTrailingEffects} values for this field
   */
  public static Bits VAPOR_TRAIL_SIZE = new Bits(7, 2, AppearanceTrailingEffects.class);
  /**
   * Describes whether the entity is burning and flames are visible
   */
  public static Bits IS_FLAMING = new Bits(15, 1);
  /**
   * Describes whether or not the guided munition's launch flash is present
   */
  public static Bits LAUNCH_FLASH_PRESENT = new Bits(16, 1);
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
   * Describes the status of the cover or shroud, Use {@link CoverShroudStatus} values for this field
   */
  public static Bits COVER_SHROUD_STATUS = new Bits(24, 2, CoverShroudStatus.class);
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

  public MunitionAppearance()
  {
    super(32); // length from bitfield element
  }

  public MunitionAppearance(Bits wh, int i)
  {
    this();
    set(wh,i);
  }

  public MunitionAppearance set(Bits wh, int val)
  {
    //if((val & ~wh.inputmask) != 0)
    //  throw new EnumNotFoundException("bad bits passed to "+getClass().getSimpleName()+", field "+wh.name() + " cannot be "+val);

    setbits(wh.position,wh.length,val);
    return this;
  }
/*
  public MunitionAppearance set(Bits wh, Object val) throws Exception
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
  public MunitionAppearance set(int start, int length, int val)
  {
      setbits(start,length,val);
      return this;
  }
}