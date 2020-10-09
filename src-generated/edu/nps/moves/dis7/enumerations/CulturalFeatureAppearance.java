package edu.nps.moves.dis7.enumerations;

import edu.nps.moves.dis7.pdus.*;

/**
 * Generated from XML, SISO-REF-010-v28, 2020-05-07<br>
 * UID 39 marshal size 32<br>
 * CulturalFeatureAppearance
 */
public class CulturalFeatureAppearance extends DisBitSet 
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
   * Describes whether the entity is burning and flames are visible
   */
  public static Bits ISFLAMING = new Bits(15, 1);
  /**
   * Describes whether the entity is frozen and should not be dead reckoned
   */
  public static Bits ISFROZEN = new Bits(21, 1);
  /**
   * Describes whether the internal heat is on or off
   */
  public static Bits INTERNALHEATON = new Bits(22, 1);
  /**
   * Describes whether the entity is active or deactivated, Use {@link AppearanceEntityorObjectState} values for this field
   */
  public static Bits STATE = new Bits(23, 1, AppearanceEntityorObjectState.class);
  /**
   * Describes whether the exterior lights are on or off
   */
  public static Bits EXTERIORLIGHTSON = new Bits(28, 1);
  /**
   * Describes whether the interior lights are on or off
   */
  public static Bits INTERIORLIGHTSON = new Bits(29, 1);
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

  public CulturalFeatureAppearance()
  {
    super(32); // length from bitfield element
  }

  public CulturalFeatureAppearance(Bits wh, int i)
  {
    this();
    set(wh,i);
  }

  public CulturalFeatureAppearance set(Bits wh, int val)
  {
    //if((val & ~wh.inputmask) != 0)
    //  throw new EnumNotFoundException("bad bits passed to "+getClass().getSimpleName()+", field "+wh.name() + " cannot be "+val);

    setbits(wh.position,wh.length,val);
    return this;
  }
/*
  public CulturalFeatureAppearance set(Bits wh, Object val) throws Exception
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
  public CulturalFeatureAppearance set(int start, int length, int val)
  {
      setbits(start,length,val);
      return this;
  }
  
  @Override
  public String toString()
  {
      return "CulturalFeatureAppearance: " + super.toString();
  }
}
