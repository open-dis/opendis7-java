package edu.nps.moves.dis7.enumerations;

import edu.nps.moves.dis7.*;

/**
 * Generated from XML, SISO-REF-010-v25, 2018-08-29<br>
 * UID 317 marshal size 8<br>
 * DE Damage Description-Component Visual Damage Status
 */
public class DEDamageDescriptionComponentVisualDamageStatus extends DisBitSet 
{
  /**
   * Describes presence of fire at the damage site
   */
  public static Bits IS_FIRE_PRESENT = new Bits(0, 1);
  /**
   * Describes presence of smoke emanating from the damage site, Use {@link ComponentVisualDamageStatusSmoke} values for this field
   */
  public static Bits SMOKE = new Bits(1, 2, ComponentVisualDamageStatusSmoke.class);
  /**
   * Describes general surface appearance at the damage site, Use {@link ComponentVisualDamageStatusSurfaceDamage} values for this field
   */
  public static Bits SURFACE_DAMAGE = new Bits(3, 2, ComponentVisualDamageStatusSurfaceDamage.class);

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

  public DEDamageDescriptionComponentVisualDamageStatus()
  {
    super(8); // length from bitfield element
  }

  public DEDamageDescriptionComponentVisualDamageStatus(Bits wh, int i)
  {
    this();
    set(wh,i);
  }

  public DEDamageDescriptionComponentVisualDamageStatus set(Bits wh, int val)
  {
    //if((val & ~wh.inputmask) != 0)
    //  throw new EnumNotFoundException("bad bits passed to "+getClass().getSimpleName()+", field "+wh.name() + " cannot be "+val);

    setbits(wh.position,wh.length,val);
    return this;
  }
/*
  public DEDamageDescriptionComponentVisualDamageStatus set(Bits wh, Object val) throws Exception
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
  public DEDamageDescriptionComponentVisualDamageStatus set(int start, int length, int val)
  {
      setbits(start,length,val);
      return this;
  }
  
  @Override
  public String toString()
  {
      return "DEDamageDescriptionComponentVisualDamageStatus: " + super.toString();
  }
}
