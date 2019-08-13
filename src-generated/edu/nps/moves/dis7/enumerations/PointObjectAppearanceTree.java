package edu.nps.moves.dis7.enumerations;

import edu.nps.moves.dis7.*;

/**
 * Generated from XML, SISO-REF-010-v25, 2018-08-29<br>
 * UID 487 marshal size 32<br>
 * Point Object Appearance-Tree
 */
public class PointObjectAppearanceTree extends DisBitSet 
{
  /**
   * Indicates the visually represented season, Use {@link Season} values for this field
   */
  public static Bits SEASON = new Bits(0, 2, Season.class);
  /**
   * Indicates the leaf coverage, Use {@link LeafCoverage} values for this field
   */
  public static Bits LEAF_COVERAGE = new Bits(2, 2, LeafCoverage.class);

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

  public PointObjectAppearanceTree()
  {
    super(32); // length from bitfield element
  }

  public PointObjectAppearanceTree(Bits wh, int i)
  {
    this();
    set(wh,i);
  }

  public PointObjectAppearanceTree set(Bits wh, int val)
  {
    //if((val & ~wh.inputmask) != 0)
    //  throw new EnumNotFoundException("bad bits passed to "+getClass().getSimpleName()+", field "+wh.name() + " cannot be "+val);

    setbits(wh.position,wh.length,val);
    return this;
  }
/*
  public PointObjectAppearanceTree set(Bits wh, Object val) throws Exception
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
  public PointObjectAppearanceTree set(int start, int length, int val)
  {
      setbits(start,length,val);
      return this;
  }
}
