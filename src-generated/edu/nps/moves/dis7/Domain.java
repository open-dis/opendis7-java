/**
 * Copyright (c) 2008-2019, MOVES Institute, Naval Postgraduate School. All rights reserved.
 * This work is licensed under the BSD open source license, available at https://www.movesinstitute.org/licenses/bsd.html
 */

package edu.nps.moves.dis7;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.lang.reflect.InvocationTargetException;

import edu.nps.moves.dis7.enumerations.*;

/**
 * An example approximating a Java enum "superclass".  Can't use an interface, because we need the two
 * static methods, which can't go into an interface
 */
public class Domain
{
  private Domain() { }

  private Object enumInst;

  private Method mSize;
  private Method marshalBuff;
  private Method marshalDos;
  private Method unmarshalBuff;
  private Method unmarshalDis;
  private Method getValue;
  private Method getDescription;
  
  //@formatter:off
 

  public static Domain inst(PlatformDomain d) { return _inst(d); }  //  uid 8

  public static Domain inst(MunitionDomain d) { return _inst(d); }  //  uid 14

  public static Domain inst(SupplyDomain d) { return _inst(d); }  //  uid 600

  //@formatter:on

  private static Domain _inst(Object o)
  {
    Domain d = new Domain();
    d.enumInst = o;
    d.init();
    return d;
  }
  private void init()
  {
    Class c = enumInst.getClass();
    try {
      //@formatter:off
      marshalBuff =   c.getDeclaredMethod("marshal",       new Class[]{ByteBuffer.class});
      marshalDos =    c.getDeclaredMethod("marshal",       new Class[]{DataOutputStream.class});
      unmarshalBuff = c.getDeclaredMethod("unmarshalEnum", new Class[]{ByteBuffer.class});
      unmarshalDis =  c.getDeclaredMethod("unmarshalEnum", new Class[]{DataInputStream.class});
      mSize =         c.getDeclaredMethod("getMarshalledSize", (Class[]) null);
      getValue =      c.getDeclaredMethod("getValue",          (Class[]) null);
      getDescription =c.getDeclaredMethod("getDescription",    (Class[]) null);
      //@formatter:on
    }
    catch (NoSuchMethodException ex) {
      System.err.println("Can't find methods in "+c.getSimpleName());
    } 
  }
  public int getValue()
  {
    return (Integer) invoke(getValue, (Object[]) null);
  }

  public String getDescription()
  {
    return (String) invoke(getDescription, (Object[]) null);
  }

  public int getMarshalledSize()
  {
    return (Integer) invoke(mSize, (Object[]) null);
  }

  public void marshal(DataOutputStream dos)
  {
    invoke(marshalDos, new Object[]{dos});
  }

  public void marshal(ByteBuffer buff)
  {
    invoke(marshalBuff, new Object[]{buff});
  }

  public int unmarshal(DataInputStream dis)
  {
    Object o = invoke(unmarshalDis, new Object[]{dis});
    enumInst = o;
    init();
    return getMarshalledSize();
  }

  public int unmarshal(ByteBuffer buff)
  {
    Object o = invoke(unmarshalBuff, new Object[]{buff});
    enumInst = o;
    init();
    return getMarshalledSize();
  }

  private Object invoke(Method m, Object[] oa)
  {
    try {
      return m.invoke(enumInst, oa);
    }
    catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
      throw new RuntimeException("bad " + m.getName());
    }
  }

  @Override
  public String toString()
  {
    return getDescription();
  }
}

