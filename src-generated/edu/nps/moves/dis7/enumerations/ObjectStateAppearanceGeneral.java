package edu.nps.moves.dis7.enumerations;

import edu.nps.moves.dis7.pdus.*;

/**
 * Generated from XML, <br>
 * UID 229 marshal size 16<br>
 * ObjectStateAppearanceGeneral
 */
public class ObjectStateAppearanceGeneral extends DisBitSet 
{
  /**
   * 8-bit unsigned integer indicating the percent completion of the object (0..100)
   */
  public static Bits PERCENTCOMPLETE = new Bits(0, 8);
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
  public static Bits ISSMOKING = new Bits(12, 1);
  /**
   * Describes whether the object is burning and flames are visible
   */
  public static Bits ISFLAMING = new Bits(13, 1);
  /**
   * Describes whether the object has or contains an IED, Use {@link AppearanceObjectGeneralIEDPresent} values for this field
   */
  public static Bits IEDPRESENT = new Bits(14, 2, AppearanceObjectGeneralIEDPresent.class);

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
  public ObjectStateAppearanceGeneral()
  {
    super(16); // length from bitfield element
  }

  /** Default constructor with parameters
   * @param wh Bits custom data structure
   * @param value bits of interest  */
  public ObjectStateAppearanceGeneral(Bits wh, int value)
  {
    this();
    set(wh,value);
  }

  /** Accessor method to set value
   * @param wh Bits custom data structure
   * @param value bits of interest
   * @return this object */
  public ObjectStateAppearanceGeneral set(Bits wh, int value)
  {
    //if((value & ~wh.inputmask) != 0)
    //  throw new EnumNotFoundException("bad bits passed to "+getClass().getSimpleName()+", field "+wh.name() + " cannot be "+value);

    setbits(wh.position,wh.length,value);
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
  /** Some bitfields are defined without specific bits enumerated
   * @param start initial position in bit array
   * @param length number of bits
   * @param value bits of interest
   * @return this object */
  public ObjectStateAppearanceGeneral set(int start, int length, int value)
  {
      setbits(start,length,value);
      return this;
  }

  /** Provide string representation
   * @return string representation */
  @Override
  public String toString()
  {
      return "ObjectStateAppearanceGeneral: " + super.toString();
  }
}
