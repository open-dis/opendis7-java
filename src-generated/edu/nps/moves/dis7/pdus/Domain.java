/**
 * Copyright (c) 2008-2021, MOVES Institute, Naval Postgraduate School (NPS). All rights reserved.
 * This work is provided under a BSD open-source license, see project license.html and license.txt
 */
package edu.nps.moves.dis7.pdus;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.lang.reflect.InvocationTargetException;

import edu.nps.moves.dis7.enumerations.*;

/**
 * Which domain does this PDU belong to:
 * An example approximating a Java enum "superclass". Can't use an interface, because we need the two
 * static methods, which can't go into an interface
 * @see AircraftPresentDomain
 * @see AnimalLifeformGroupSizeRangeEnumerationforallDomains
 * @see MunitionDomain
 * @see PlatformDomain
 * @see SupplyDomain
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
     * @param d a PlatformDomain
     * @return an Domain instance based on a PlatformDomain enum
     */
  public static Domain inst(PlatformDomain d)
  {
    return _inst(d);
  }  //  uid 8

    /**
     *
     * @param d a MunitionDomain
     * @return an Domain instance based on a MunitionDomain enum
     */
    public static Domain inst(MunitionDomain d)
  {
    return _inst(d);
  }  //  uid 14

    /**
     *
     * @param d a SupplyDomain
     * @return an Domain instance based on a SupplyDomain enum
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
    catch (NoSuchMethodException ex)
    {
        System.out.flush(); // ensure contiguous console outputs
        System.err.println("Can't find methods in " + c.getSimpleName());
        System.err.flush(); // ensure contiguous console outputs
    }
  }

    /**
     *
     * @return value
     */
    public int getValue()
  {
    return (Integer) invoke(getValue, null);
  }

    /**
     *
     * @return description
     */
    public String getDescription()
  {
    return (String) invoke(getDescription, null);
  }

  /**
   * Returns size of this serialized (marshalled) object in bytes
   * @see <a href="https://en.wikipedia.org/wiki/Marshalling_(computer_science)" target="_blank">https://en.wikipedia.org/wiki/Marshalling_(computer_science)</a>
   * @return serialized size in bytes
   */
    public int getMarshalledSize()
    {
      return (Integer) invoke(mSize, null);
    }

    /**
     *
     * @param dos DataOutputStream
     */
    public void marshal(DataOutputStream dos)
  {
    invoke(marshalDos, new Object[]{dos});
  }

    /**
     *
     * @param byteBuffer The ByteBuffer at the position to begin writing
     */
    public void marshal(ByteBuffer byteBuffer)
  {
    invoke(marshalBuff, new Object[]{byteBuffer});
  }

    /**
     * Deserializes an object from a DataInputStream.
     * @param dis DataInputStream
     * @see java.io.DataInputStream
     * @see <a href="https://en.wikipedia.org/wiki/Marshalling_(computer_science)" target="_blank">https://en.wikipedia.org/wiki/Marshalling_(computer_science)</a>
     * @return marshalled serialized size in bytes
     */
    public int unmarshal(DataInputStream dis)
  {
    Object o = invoke(unmarshalDis, new Object[]{dis});
    enumInst = o;
    init();
    return getMarshalledSize();
  }

    /**
     * Deserializes an object from a ByteBuffer.
     * @see <a href="https://en.wikipedia.org/wiki/Marshalling_(computer_science)" target="_blank">https://en.wikipedia.org/wiki/Marshalling_(computer_science)</a>
     * @param byteBuffer The ByteBuffer at the position to begin writing
     * @return marshalled serialized size in bytes
     */
    public int unmarshal(ByteBuffer byteBuffer)
  {
    Object o = invoke(unmarshalBuff, new Object[]{byteBuffer});
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
