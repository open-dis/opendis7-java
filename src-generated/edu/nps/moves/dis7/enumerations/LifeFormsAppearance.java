package edu.nps.moves.dis7.enumerations;

import edu.nps.moves.dis7.pdus.*;

/**
 * Generated from XML, <br>
 * UID 37 marshal size 32<br>
 * LifeFormsAppearance
 */
public class LifeFormsAppearance extends DisBitSet 
{
  /**
   * Describes the visual paint design, Use {@link AppearancePaintScheme} values for this field
   */
  public static Bits PAINTSCHEME = new Bits(0, 1, AppearancePaintScheme.class);
  /**
   * Describes the visual appearance of the severity of any injury, Use {@link AppearanceLifeformHealth} values for this field
   */
  public static Bits HEALTH = new Bits(3, 2, AppearanceLifeformHealth.class);
  /**
   * Describes the manner and degree to which the life form is complying, Use {@link AppearanceLifeFormComplianceStatus} values for this field
   */
  public static Bits COMPLIANCESTATUS = new Bits(5, 4, AppearanceLifeFormComplianceStatus.class);
  /**
   * Describes whether signal smoke is being used or not
   */
  public static Bits SIGNALSMOKEINUSE = new Bits(11, 1);
  /**
   * Describes whether flash lights are on or off
   */
  public static Bits FLASHLIGHTSON = new Bits(12, 1);
  /**
   * Describes whether a signal mirror is being used or not
   */
  public static Bits SIGNALMIRRORINUSE = new Bits(13, 1);
  /**
   * Describes whether an IR strobe is on or off
   */
  public static Bits IRSTROBEON = new Bits(14, 1);
  /**
   * Describes whether an IR illuminator (flare) is on or off
   */
  public static Bits IRILLUMINATORON = new Bits(15, 1);
  /**
   * Describes the posture (position) of the life form, Use {@link AppearanceLifeFormPosture} values for this field
   */
  public static Bits LIFEFORMPOSTURE = new Bits(16, 4, AppearanceLifeFormPosture.class);
  /**
   * Describes whether the entity is frozen and should not be dead reckoned
   */
  public static Bits ISFROZEN = new Bits(21, 1);
  /**
   * Describes whether or not the life form is mounted/hoisted on another platform, such as a troop transport or helicopter hoist
   */
  public static Bits MOUNTEDHOISTEDSTATUS = new Bits(22, 1);
  /**
   * Describes whether the entity is active or deactivated, Use {@link AppearanceEntityorObjectState} values for this field
   */
  public static Bits STATE = new Bits(23, 1, AppearanceEntityorObjectState.class);
  /**
   * Describes the position of the life forms primary weapon/implement, Use {@link AppearanceLifeFormWeaponImplement} values for this field
   */
  public static Bits WEAPONIMPLEMENT1 = new Bits(24, 2, AppearanceLifeFormWeaponImplement.class);
  /**
   * Describes the position of the life forms secondary weapon/implement, Use {@link AppearanceLifeFormWeaponImplement} values for this field
   */
  public static Bits WEAPONIMPLEMENT2 = new Bits(26, 2, AppearanceLifeFormWeaponImplement.class);
  /**
   * Describes the camouflage color, Use {@link AppearanceCamouflageType} values for this field
   */
  public static Bits CAMOUFLAGETYPE = new Bits(28, 2, AppearanceCamouflageType.class);
  /**
   * Describes whether or not the life form is in a prepared concealed position, Use {@link AppearanceConcealedPosition} values for this field
   */
  public static Bits CONCEALEDSTATIONARY = new Bits(30, 1, AppearanceConcealedPosition.class);
  /**
   * Describes whether or not the life form uses concealment during movement, Use {@link AppearanceConcealedMovement} values for this field
   */
  public static Bits CONCEALEDMOVEMENT = new Bits(31, 1, AppearanceConcealedMovement.class);

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
  public LifeFormsAppearance()
  {
    super(32); // length from bitfield element
  }

  /** Default constructor with parameters
   * @param wh Bits custom data structure
   * @param value bits of interest  */
  public LifeFormsAppearance(Bits wh, int value)
  {
    this();
    set(wh,value);
  }

  /** Accessor method to set value
   * @param wh Bits custom data structure
   * @param value bits of interest
   * @return this object */
  public LifeFormsAppearance set(Bits wh, int value)
  {
    //if((value & ~wh.inputmask) != 0)
    //  throw new EnumNotFoundException("bad bits passed to "+getClass().getSimpleName()+", field "+wh.name() + " cannot be "+value);

    setbits(wh.position,wh.length,value);
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
  /** Some bitfields are defined without specific bits enumerated
   * @param start initial position in bit array
   * @param length number of bits
   * @param value bits of interest
   * @return this object */
  public LifeFormsAppearance set(int start, int length, int value)
  {
      setbits(start,length,value);
      return this;
  }

  /** Provide string representation
   * @return string representation */
  @Override
  public String toString()
  {
      return "LifeFormsAppearance: " + super.toString();
  }
}
