package edu.nps.moves.dis.enumerations;

import edu.nps.moves.dis.*;

/**
 * Generated from XML, SISO-REF-010-v25, 2018-08-29<br>
 * UID 192 marshal size 16<br>
 * Minefield Data-Fusing
 */
public class MinefieldDataFusing extends DisBitSet 
{
  /**
   * Identifies the type of the primary fuse, Use {@link MinefieldFusingFuseType} values for this field
   */
  public static Bits PRIMARY = new Bits(0, 7, MinefieldFusingFuseType.class);
  /**
   * Identifies the type of the secondary fuse, Use {@link MinefieldFusingFuseType} values for this field
   */
  public static Bits SECONDARY = new Bits(7, 7, MinefieldFusingFuseType.class);
  /**
   * Describes whether the mine has an Anti-Handling device
   */
  public static Bits HAS_ANTI_HANDLING_DEVICE = new Bits(14, 1);

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

  public MinefieldDataFusing()
  {
    super(16); // length from bitfield element
  }

  public MinefieldDataFusing(Bits wh, int i)
  {
    this();
    set(wh,i);
  }

  public MinefieldDataFusing set(Bits wh, int val)
  {
    //if((val & ~wh.inputmask) != 0)
    //  throw new EnumNotFoundException("bad bits passed to "+getClass().getSimpleName()+", field "+wh.name() + " cannot be "+val);

    setbits(wh.position,wh.length,val);
    return this;
  }
/*
  public MinefieldDataFusing set(Bits wh, Object val) throws Exception
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
  public MinefieldDataFusing set(int start, int length, int val)
  {
      setbits(start,length,val);
      return this;
  }
}
