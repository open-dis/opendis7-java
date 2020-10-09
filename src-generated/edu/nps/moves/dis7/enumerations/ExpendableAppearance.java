package edu.nps.moves.dis7.enumerations;

import edu.nps.moves.dis7.pdus.*;

/**
 * Generated from XML, SISO-REF-010-v28, 2020-05-07<br>
 * UID 42 marshal size 32<br>
 * ExpendableAppearance
 */
public class ExpendableAppearance extends DisBitSet 
{
  /**
   * Describes the damaged appearance, Use {@link AppearanceDamage} values for this field
   */
  public static Bits DAMAGE = new Bits(3, 2, AppearanceDamage.class);
  /**
   * Describes whether or not smoke is emanating from the entity
   */
  public static Bits ISSMOKEEMANATING = new Bits(5, 1);
  /**
   * Describes the status of a flares parachute, Use {@link Parachute} values for this field
   */
  public static Bits PARACHUTESTATUS = new Bits(7, 2, Parachute.class);
  /**
   * Describes the color of a flares light output or the color of smoke emanating from a smoke expendable, Use {@link FlareSmokeColor} values for this field
   */
  public static Bits FLARESMOKECOLOR = new Bits(9, 3, FlareSmokeColor.class);
  /**
   * Describes whether the entity is burning and flames are visible
   */
  public static Bits ISFLAMING = new Bits(15, 1);
  /**
   * Describes whether or not launch flash is present
   */
  public static Bits LAUNCHFLASHPRESENT = new Bits(16, 1);
  /**
   * Describes the status of a flare or smoke expendable, Use {@link FlareSmokeStatus} values for this field
   */
  public static Bits FLARESMOKESTATUS = new Bits(17, 2, FlareSmokeStatus.class);
  /**
   * Describes whether the entity is frozen and should not be dead reckoned
   */
  public static Bits ISFROZEN = new Bits(21, 1);
  /**
   * Describes whether the power plant is on or off
   */
  public static Bits POWERPLANTON = new Bits(22, 1);
  /**
   * Describes whether the entity is active or deactivated, Use {@link AppearanceEntityorObjectState} values for this field
   */
  public static Bits STATE = new Bits(23, 1, AppearanceEntityorObjectState.class);
  /**
   * Describes the status of spot chaff, Use {@link SpotChaffStatus} values for this field
   */
  public static Bits SPOTCHAFFSTATUS = new Bits(24, 2, SpotChaffStatus.class);
  /**
   * Describes whether or not the entity is masked or cloaked
   */
  public static Bits MASKEDCLOAKED = new Bits(31, 1);

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

  public ExpendableAppearance()
  {
    super(32); // length from bitfield element
  }

  public ExpendableAppearance(Bits wh, int i)
  {
    this();
    set(wh,i);
  }

  public ExpendableAppearance set(Bits wh, int val)
  {
    //if((val & ~wh.inputmask) != 0)
    //  throw new EnumNotFoundException("bad bits passed to "+getClass().getSimpleName()+", field "+wh.name() + " cannot be "+val);

    setbits(wh.position,wh.length,val);
    return this;
  }
/*
  public ExpendableAppearance set(Bits wh, Object val) throws Exception
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
  public ExpendableAppearance set(int start, int length, int val)
  {
      setbits(start,length,val);
      return this;
  }
  
  @Override
  public String toString()
  {
      return "ExpendableAppearance: " + super.toString();
  }
}
