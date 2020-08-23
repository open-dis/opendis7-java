package edu.nps.moves.dis7.enumerations;

import edu.nps.moves.dis7.*;

/**
 * Generated from XML, SISO-REF-010-v28, 2020-05-07<br>
 * UID 149 marshal size 16<br>
 * _________________________________
 */
public class UAPropulsionPlantConfiguration extends DisBitSet 
{
  /**
   * Describes the configuration of the power plant, Use {@link UAPropulsionPlantConfigurationConfiguration} values for this field
   */
  public static Bits undef = new Bits(0, 7, UAPropulsionPlantConfigurationConfiguration.class);
  /**
   * Describes whether the hull-mounted masker is on or off
   */
  public static Bits undef_2 = new Bits(7, 1);

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

  public UAPropulsionPlantConfiguration()
  {
    super(16); // length from bitfield element
  }

  public UAPropulsionPlantConfiguration(Bits wh, int i)
  {
    this();
    set(wh,i);
  }

  public UAPropulsionPlantConfiguration set(Bits wh, int val)
  {
    //if((val & ~wh.inputmask) != 0)
    //  throw new EnumNotFoundException("bad bits passed to "+getClass().getSimpleName()+", field "+wh.name() + " cannot be "+val);

    setbits(wh.position,wh.length,val);
    return this;
  }
/*
  public UAPropulsionPlantConfiguration set(Bits wh, Object val) throws Exception
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
  public UAPropulsionPlantConfiguration set(int start, int length, int val)
  {
      setbits(start,length,val);
      return this;
  }
  
  @Override
  public String toString()
  {
      return "UAPropulsionPlantConfiguration: " + super.toString();
  }
}
