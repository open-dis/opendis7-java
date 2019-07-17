package edu.nps.moves.dis.enumerations;

import edu.nps.moves.dis.*;

/**
 * Generated from XML, SISO-REF-010-v25, 2018-08-29<br>
 * UID 249 marshal size 8<br>
 * Environmental Process-Environment Status
 */
public class EnvironmentalProcessEnvironmentStatus extends DisBitSet 
{
  /**
   * Indicates that the current update shall be the last update for the specified process
   */
  public static Bits IS_LAST = new Bits(0, 1);
  /**
   * Describes whether the environmental process is active or not
   */
  public static Bits IS_ACTIVE = new Bits(1, 1);

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

  public EnvironmentalProcessEnvironmentStatus()
  {
    super(8); // length from bitfield element
  }

  public EnvironmentalProcessEnvironmentStatus(Bits wh, int i)
  {
    this();
    set(wh,i);
  }

  public EnvironmentalProcessEnvironmentStatus set(Bits wh, int val)
  {
    //if((val & ~wh.inputmask) != 0)
    //  throw new EnumNotFoundException("bad bits passed to "+getClass().getSimpleName()+", field "+wh.name() + " cannot be "+val);

    setbits(wh.position,wh.length,val);
    return this;
  }
/*
  public EnvironmentalProcessEnvironmentStatus set(Bits wh, Object val) throws Exception
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
  public EnvironmentalProcessEnvironmentStatus set(int start, int length, int val)
  {
      setbits(start,length,val);
      return this;
  }
}
