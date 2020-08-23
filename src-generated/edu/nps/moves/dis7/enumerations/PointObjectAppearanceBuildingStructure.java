package edu.nps.moves.dis7.enumerations;

import edu.nps.moves.dis7.*;

/**
 * Generated from XML, SISO-REF-010-v28, 2020-05-07<br>
 * UID 230 marshal size 16<br>
 * __________________________________________
 */
public class PointObjectAppearanceBuildingStructure extends DisBitSet 
{
  /**
   * Describes the color of the building or structure, Use {@link Color} values for this field
   */
  public static Bits undef = new Bits(0, 8, Color.class);
  /**
   * Describes the visual paint design, Use {@link BuildingPaintScheme} values for this field
   */
  public static Bits undef_2 = new Bits(8, 8, BuildingPaintScheme.class);
  /**
   * Describes whether the aperture (e.g., tent) is open or closed
   */
  public static Bits undef_3 = new Bits(16, 1);

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

  public PointObjectAppearanceBuildingStructure()
  {
    super(16); // length from bitfield element
  }

  public PointObjectAppearanceBuildingStructure(Bits wh, int i)
  {
    this();
    set(wh,i);
  }

  public PointObjectAppearanceBuildingStructure set(Bits wh, int val)
  {
    //if((val & ~wh.inputmask) != 0)
    //  throw new EnumNotFoundException("bad bits passed to "+getClass().getSimpleName()+", field "+wh.name() + " cannot be "+val);

    setbits(wh.position,wh.length,val);
    return this;
  }
/*
  public PointObjectAppearanceBuildingStructure set(Bits wh, Object val) throws Exception
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
  public PointObjectAppearanceBuildingStructure set(int start, int length, int val)
  {
      setbits(start,length,val);
      return this;
  }
  
  @Override
  public String toString()
  {
      return "PointObjectAppearanceBuildingStructure: " + super.toString();
  }
}
