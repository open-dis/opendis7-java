package edu.nps.moves.dis7.enumerations;

import edu.nps.moves.dis7.*;

/**
 * Generated from XML, SISO-REF-010-v28, 2020-05-07<br>
 * UID 202 marshal size 8<br>
 * MinefieldDataPaintScheme
 */
public class MinefieldDataPaintScheme extends DisBitSet 
{
  /**
   * Identifies the algae build-up on the mine, Use {@link MinefieldPaintSchemeAlgae} values for this field
   */
  public static Bits ALGAE = new Bits(0, 2, MinefieldPaintSchemeAlgae.class);
  /**
   * Identifies the paint scheme of the mine, Use {@link MinefieldPaintSchemePaintScheme} values for this field
   */
  public static Bits PAINTSCHEME = new Bits(2, 6, MinefieldPaintSchemePaintScheme.class);

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

  public MinefieldDataPaintScheme()
  {
    super(8); // length from bitfield element
  }

  public MinefieldDataPaintScheme(Bits wh, int i)
  {
    this();
    set(wh,i);
  }

  public MinefieldDataPaintScheme set(Bits wh, int val)
  {
    //if((val & ~wh.inputmask) != 0)
    //  throw new EnumNotFoundException("bad bits passed to "+getClass().getSimpleName()+", field "+wh.name() + " cannot be "+val);

    setbits(wh.position,wh.length,val);
    return this;
  }
/*
  public MinefieldDataPaintScheme set(Bits wh, Object val) throws Exception
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
  public MinefieldDataPaintScheme set(int start, int length, int val)
  {
      setbits(start,length,val);
      return this;
  }
  
  @Override
  public String toString()
  {
      return "MinefieldDataPaintScheme: " + super.toString();
  }
}
