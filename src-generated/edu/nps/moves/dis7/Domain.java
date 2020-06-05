/**
 * Copyright (c) 2008-2020, MOVES Institute, Naval Postgraduate School (NPS). All rights reserved.
 * This work is provided under a BSD open-source license, see project license.html and license.txt
 */
package edu.nps.moves.dis7;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.lang.reflect.InvocationTargetException;

import edu.nps.moves.dis7.enumerations.*;

/**
 * An example approximating a Java enum "superclass". Can't use an interface, because we need the two
 * static methods, which can't go into an interface
 */
public class Domain
{
  private Domain()
  {
  }

  private Object enumInst;

  private Method mSize;
  private Method marshalBuff;
  private Method marshalDos;
  private Method unmarshalBuff;
  private Method unmarshalDis;
  private Method getValue;
  private Method getDescription;

  //@formatter:off

    /**
     *
     * @param d
     * @return
     */
  public static Domain inst(PlatformDomain d)
  {
    return _inst(d);
  }  //  uid 8

    /**
     *
     * @param d
     * @return
     */
    public static Domain inst(MunitionDomain d)
  {
    return _inst(d);
  }  //  uid 14

    /**
     *
     * @param d
     * @return
     */
    public static Domain inst(SupplyDomain d)
  {
    return _inst(d);
  }  //  uid 600

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
    Class<?> c = enumInst.getClass();
    try {
      //@formatter:off
      marshalBuff = c.getDeclaredMethod("marshal", new Class[]{ByteBuffer.class});
      marshalDos = c.getDeclaredMethod("marshal", new Class[]{DataOutputStream.class});
      unmarshalBuff = c.getDeclaredMethod("unmarshalEnum", new Class[]{ByteBuffer.class});
      unmarshalDis = c.getDeclaredMethod("unmarshalEnum", new Class[]{DataInputStream.class});
      mSize = c.getDeclaredMethod("getMarshalledSize", (Class[]) null);
      getValue = c.getDeclaredMethod("getValue", (Class[]) null);
      getDescription = c.getDeclaredMethod("getDescription", (Class[]) null);
      //@formatter:on
    }
    catch (NoSuchMethodException ex) {
      System.err.println("Can't find methods in " + c.getSimpleName());
    }
  }

    /**
     *
     * @return
     */
    public int getValue()
  {
    return (Integer) invoke(getValue, null);
  }

    /**
     *
     * @return
     */
    public String getDescription()
  {
    return (String) invoke(getDescription, null);
  }

    /**
     *
     * @return
     */
    public int getMarshalledSize()
  {
    return (Integer) invoke(mSize, null);
  }

    /**
     *
     * @param dos
     */
    public void marshal(DataOutputStream dos)
  {
    invoke(marshalDos, new Object[]{dos});
  }

    /**
     *
     * @param buff
     */
    public void marshal(ByteBuffer buff)
  {
    invoke(marshalBuff, new Object[]{buff});
  }

    /**
     *
     * @param dis
     * @return
     */
    public int unmarshal(DataInputStream dis)
  {
    Object o = invoke(unmarshalDis, new Object[]{dis});
    enumInst = o;
    init();
    return getMarshalledSize();
  }

    /**
     *
     * @param buff
     * @return
     */
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

  /*
   * Override of default equals method.  Calls equalsImpl() for content comparison.
   */
  @Override
  public boolean equals(Object obj)
  {
    if (this == obj)
      return true;

    if (obj == null)
      return false;

    if (getClass() != obj.getClass())
      return false;

    return equalsImpl(obj);
  }

  /**
   * Compare all fields that contribute to the state, ignoring
   * transient and static fields, for <code>this</code> and the supplied object
   *
   * @param obj the object to compare to
   * @return true if the objects are equal, false otherwise.
   */
  public boolean equalsImpl(Object obj)
  {
    final Domain rhs = (Domain) obj;
    return enumInst.equals(rhs.enumInst);
  }
}
