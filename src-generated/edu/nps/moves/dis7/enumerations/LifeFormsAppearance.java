package edu.nps.moves.dis7.enumerations;

import edu.nps.moves.dis7.*;

/**
 * Generated from XML, SISO-REF-010-v28, 2020-05-07<br>
 * UID 37 marshal size 32<br>
 * _____________________
 */
public class LifeFormsAppearance extends DisBitSet 
{
  /**
   * Describes the visual paint design, Use {@link AppearancePaintScheme} values for this field
   */
  public static Bits undef = new Bits(0, 1, AppearancePaintScheme.class);
  /**
   * Describes the visual appearance of the severity of any injury, Use {@link AppearanceLifeformHealth} values for this field
   */
  public static Bits undef_2 = new Bits(3, 2, AppearanceLifeformHealth.class);
  /**
   * Describes the manner and degree to which the life form is complying, Use {@link AppearanceLifeFormComplianceStatus} values for this field
   */
  public static Bits undef_3 = new Bits(5, 4, AppearanceLifeFormComplianceStatus.class);
  /**
   * Describes whether signal smoke is being used or not
   */
  public static Bits undef_4 = new Bits(11, 1);
  /**
   * Describes whether flash lights are on or off
   */
  public static Bits undef_5 = new Bits(12, 1);
  /**
   * Describes whether a signal mirror is being used or not
   */
  public static Bits undef_6 = new Bits(13, 1);
  /**
   * Describes whether an IR strobe is on or off
   */
  public static Bits undef_7 = new Bits(14, 1);
  /**
   * Describes whether an IR illuminator (flare) is on or off
   */
  public static Bits undef_8 = new Bits(15, 1);
  /**
   * Describes the posture (position) of the life form, Use {@link AppearanceLifeFormPosture} values for this field
   */
  public static Bits undef_9 = new Bits(16, 4, AppearanceLifeFormPosture.class);
  /**
   * Describes whether the entity is frozen and should not be dead reckoned
   */
  public static Bits undef_10 = new Bits(21, 1);
  /**
   * Describes whether or not the life form is mounted/hoisted on another platform, such as a troop transport or helicopter hoist
   */
  public static Bits undef_11 = new Bits(22, 1);
  /**
   * Describes whether the entity is active or deactivated, Use {@link AppearanceEntityorObjectState} values for this field
   */
  public static Bits undef_12 = new Bits(23, 1, AppearanceEntityorObjectState.class);
  /**
   * Describes the position of the life forms primary weapon/implement, Use {@link AppearanceLifeFormWeaponImplement} values for this field
   */
  public static Bits undef_13 = new Bits(24, 2, AppearanceLifeFormWeaponImplement.class);
  /**
   * Describes the position of the life forms secondary weapon/implement, Use {@link AppearanceLifeFormWeaponImplement} values for this field
   */
  public static Bits undef_14 = new Bits(26, 2, AppearanceLifeFormWeaponImplement.class);
  /**
   * Describes the camouflage color, Use {@link AppearanceCamouflageType} values for this field
   */
  public static Bits undef_15 = new Bits(28, 2, AppearanceCamouflageType.class);
  /**
   * Describes whether or not the life form is in a prepared concealed position, Use {@link AppearanceConcealedPosition} values for this field
   */
  public static Bits undef_16 = new Bits(30, 1, AppearanceConcealedPosition.class);
  /**
   * Describes whether or not the life form uses concealment during movement, Use {@link AppearanceConcealedMovement} values for this field
   */
  public static Bits undef_17 = new Bits(31, 1, AppearanceConcealedMovement.class);

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

  public LifeFormsAppearance()
  {
    super(32); // length from bitfield element
  }

  public LifeFormsAppearance(Bits wh, int i)
  {
    this();
    set(wh,i);
  }

  public LifeFormsAppearance set(Bits wh, int val)
  {
    //if((val & ~wh.inputmask) != 0)
    //  throw new EnumNotFoundException("bad bits passed to "+getClass().getSimpleName()+", field "+wh.name() + " cannot be "+val);

    setbits(wh.position,wh.length,val);
    return this;
  }
/*
  public LifeFormsAppearance set(Bits wh, Object val) throws Exception
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
  public LifeFormsAppearance set(int start, int length, int val)
  {
      setbits(start,length,val);
      return this;
  }
  
  @Override
  public String toString()
  {
      return "LifeFormsAppearance: " + super.toString();
  }
}
