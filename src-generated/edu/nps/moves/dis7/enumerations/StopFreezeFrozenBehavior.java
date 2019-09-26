package edu.nps.moves.dis7.enumerations;

import edu.nps.moves.dis7.*;

/**
 * Generated from XML, SISO-REF-010-v25, 2018-08-29<br>
 * UID 68 marshal size 8<br>
 * Stop/Freeze-Frozen Behavior
 */
public class StopFreezeFrozenBehavior extends DisBitSet 
{
  /**
   * Describes whether a simulation application should run the internal simulation clock or not
   */
  public static Bits RUN_SIMULATION_CLOCK = new Bits(0, 1);
  /**
   * Describes whether a simulation application should transmit updates and interactions or not
   */
  public static Bits TRANSMIT_UPDATES = new Bits(1, 1);
  /**
   * Describes whether a simulation application should update simulation models of other entities via received updates or interactions
   */
  public static Bits PROCESS_UPDATES = new Bits(2, 1);

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

  public StopFreezeFrozenBehavior()
  {
    super(8); // length from bitfield element
  }

  public StopFreezeFrozenBehavior(Bits wh, int i)
  {
    this();
    set(wh,i);
  }

  public StopFreezeFrozenBehavior set(Bits wh, int val)
  {
    //if((val & ~wh.inputmask) != 0)
    //  throw new EnumNotFoundException("bad bits passed to "+getClass().getSimpleName()+", field "+wh.name() + " cannot be "+val);

    setbits(wh.position,wh.length,val);
    return this;
  }
/*
  public StopFreezeFrozenBehavior set(Bits wh, Object val) throws Exception
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
  public StopFreezeFrozenBehavior set(int start, int length, int val)
  {
      setbits(start,length,val);
      return this;
  }
  
  @Override
  public String toString()
  {
      return "StopFreezeFrozenBehavior: " + super.toString();
  }
}
