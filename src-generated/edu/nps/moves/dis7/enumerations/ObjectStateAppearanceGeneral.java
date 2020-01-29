package edu.nps.moves.dis7.enumerations;

import edu.nps.moves.dis7.*;

/**
 * Generated from XML, SISO-REF-010-v25, 2018-08-29<br>
 * UID 229 marshal size 16<br>
 * Object State Appearance-General
 */
public class ObjectStateAppearanceGeneral extends DisBitSet 
{
  /**
   * 8-bit unsigned integer indicating the percent completion of the object (0..100)
   */
  public static Bits PERCENT_COMPLETE = new Bits(0, 8);
  /**
   * Describes the damaged appearance, Use {@link AppearanceObjectGeneralDamage} values for this field
   */
  public static Bits DAMAGE = new Bits(8, 2, AppearanceObjectGeneralDamage.class);
  /**
   * Describes whether the object was predistributed, Use {@link AppearanceObjectGeneralPredistributed} values for this field
   */
  public static Bits PREDISTRIBUTED = new Bits(10, 1, AppearanceObjectGeneralPredistributed.class);
  /**
   * Describes the state of the object, Use {@link AppearanceEntityorObjectState} values for this field
   */
  public static Bits STATE = new Bits(11, 1, AppearanceEntityorObjectState.class);
  /**
   * Describes whether or not there is a smoke plume
   */
  public static Bits IS_SMOKING = new Bits(12, 1);
  /**
   * Describes whether the object is burning and flames are visible
   */
  public static Bits IS_FLAMING = new Bits(13, 1);
  /**
   * Describes whether the object has or contains an IED, Use {@link AppearanceObjectGeneralIEDPresent} values for this field
   */
  public static Bits IED_PRESENT = new Bits(14, 2, AppearanceObjectGeneralIEDPresent.class);

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

  public ObjectStateAppearanceGeneral()
  {
    super(16); // length from bitfield element
  }

  public ObjectStateAppearanceGeneral(Bits wh, int i)
  {
    this();
    set(wh,i);
  }

  public ObjectStateAppearanceGeneral set(Bits wh, int val)
  {
    //if((val & ~wh.inputmask) != 0)
    //  throw new EnumNotFoundException("bad bits passed to "+getClass().getSimpleName()+", field "+wh.name() + " cannot be "+val);

    setbits(wh.position,wh.length,val);
    return this;
  }
/*
  public ObjectStateAppearanceGeneral set(Bits wh, Object val) throws Exception
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
  public ObjectStateAppearanceGeneral set(int start, int length, int val)
  {
      setbits(start,length,val);
      return this;
  }
  
  @Override
  public String toString()
  {
      return "ObjectStateAppearanceGeneral: " + super.toString();
  }
}
