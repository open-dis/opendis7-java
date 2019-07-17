package edu.nps.moves.dis.enumerations;

import edu.nps.moves.dis.*;

/**
 * Generated from XML, SISO-REF-010-v25, 2018-08-29<br>
 * UID 240 marshal size 16<br>
 * Object State-Modification-Point Object
 */
public class ObjectStateModificationPointObject extends DisBitSet 
{
  /**
   * Describes whether the point object location has been modified since the last update number
   */
  public static Bits IS_LOCATION_MODIFIED = new Bits(0, 1);
  /**
   * Describes whether the point object orientation has been modified since the last update number
   */
  public static Bits IS_ORIENTATION_MODIFIED = new Bits(1, 1);

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

  public ObjectStateModificationPointObject()
  {
    super(16); // length from bitfield element
  }

  public ObjectStateModificationPointObject(Bits wh, int i)
  {
    this();
    set(wh,i);
  }

  public ObjectStateModificationPointObject set(Bits wh, int val)
  {
    //if((val & ~wh.inputmask) != 0)
    //  throw new EnumNotFoundException("bad bits passed to "+getClass().getSimpleName()+", field "+wh.name() + " cannot be "+val);

    setbits(wh.position,wh.length,val);
    return this;
  }
/*
  public ObjectStateModificationPointObject set(Bits wh, Object val) throws Exception
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
  public ObjectStateModificationPointObject set(int start, int length, int val)
  {
      setbits(start,length,val);
      return this;
  }
}
