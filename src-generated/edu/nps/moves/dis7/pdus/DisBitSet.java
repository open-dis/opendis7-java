/**
 * Copyright (c) 2008-2020, MOVES Institute, Naval Postgraduate School (NPS). All rights reserved.
 * This work is provided under a BSD open-source license, see project license.html and license.txt
 */

package edu.nps.moves.dis7.pdus;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.BitSet;

/**
  * This class is backed by a Java library class, {@link java.util.BitSet}.  That class exports its
  * byte array contents in little-endian order (least significant byte first).  The DIS spec requires
  * the opposite, which is the default for "network byte order".
*/
public abstract class DisBitSet extends BitSet implements Marshaller
{
    private final int bitLength;
    private final int byteLength;

    public DisBitSet(int len)
    {
        super(len); // length from bitfield element
        bitLength = len;
        byteLength = (bitLength + Byte.SIZE - 1) / Byte.SIZE;
    }

    protected static int calculateMask(int position, int length)
    {
        int result = 0;
        for (int i = position; i < position + length; i++) {
            result |= (1 << i);
        }
        return result;
    }

    protected static int calculateMask(int length)
    {
        int ret = 0;
        for (int i = 0; i < length; i++) {
            ret |= 1 << i;
        }
        return ret;
    }

    protected void setbits(int pos, int len, int val)
    {
        try {
            for (int i = pos, j = 0; i < pos + len; i++, j++) {
                boolean isset = (val & (1 << j)) != 0;
                set(i, i + 1, isset); // BitSet class
            }
        }
        catch (Throwable t) {
            showError(t);
        }
    }

  /**
   * Returns size of this serialized (marshalled) object in bytes
   * See <a href="https://en.wikipedia.org/wiki/Marshalling_(computer_science)" target="_blank">https://en.wikipedia.org/wiki/Marshalling_(computer_science)</a>
   * @return serialized size in bytes
   */
    @Override
    public int getMarshalledSize()
    {
        return byteLength;
    }

    @Override
    public void marshal(DataOutputStream dos)
    {
        try {
            dos.write(marshallCommon());
        }
        catch (IOException ex) {
            System.out.println(ex.getClass().getSimpleName() + ": " + ex.getMessage());
        }
    }

    @Override
    public void marshal(ByteBuffer byteBuffer)
    {
        byteBuffer.put(marshallCommon());
    }

    public byte[] marshallCommon()
    {
        byte[] byteArray = toByteArray();
        // BitSet does not return an array equal in size to that passed to the constructor--it may be smaller.
        // This will put 0's at the end
        if (byteArray.length < byteLength)
            byteArray = Arrays.copyOf(byteArray, byteLength);

        return reverse(byteArray); // BitSet will return Little-Endian array, network byte order requires reverse
    }

    /**
     * Deserializes an object from a DataInputStream.
     * @param dis DataInputStream
     * @see java.io.DataInputStream
     * See <a href="https://en.wikipedia.org/wiki/Marshalling_(computer_science)" target="_blank">https://en.wikipedia.org/wiki/Marshalling_(computer_science)</a>
     * @return marshalled serialized size in bytes
     */
    @Override
    public int unmarshal(DataInputStream dis)
    {
        try {
            byte[] ba = new byte[byteLength];
            dis.readFully(ba);
            unmarshalCommon(ba);
        }
        catch (IOException ex) {
            showError(ex);
        }
        return getMarshalledSize();
    }

    @Override
    public int unmarshal(ByteBuffer byteBuffer)
    {
        byte[] ba = new byte[byteLength];
        byteBuffer.get(ba);
        unmarshalCommon(ba);
        
        return getMarshalledSize();
    }

    private void unmarshalCommon(byte[] ba)
    {
        reverse(ba); // big endian to little

        int bitnum = 0;
        for (int i = 0; i < ba.length; i++) {
            for (int j = 0; j < Byte.SIZE; j++) {
                set(bitnum++, isBitSet(ba[i], j));
            }
        }
    }

    private boolean isBitSet(byte b, int bit)
    {
        return (b & (1 << bit)) != 0;
    }

    private byte[] reverse(byte[] ba)
    {
        int len = ba.length;
        for (int i = 0; i < len / 2; i++) {
            byte b = ba[i];
            ba[i] = ba[len - 1 - i];
            ba[len - 1 - i] = b;
        }
        return ba;
    }

    private void showError(Throwable ex)
    {
        System.err.println(ex.getClass().getSimpleName() + ": " + ex.getMessage());
    }
}
