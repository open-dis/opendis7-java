/**
 * Copyright (c) 2008-2021, MOVES Institute, Naval Postgraduate School (NPS). All rights reserved.
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
    /** size parameter */
    private final int  bitLength;
    /** size parameter */
    private final int byteLength;

    /**
     * Constructor
     * @param length number of bits
     */
    public DisBitSet(int length)
    {
        super(length); // length from bitfield element
        bitLength = length;
        byteLength = (bitLength + Byte.SIZE - 1) / Byte.SIZE;
    }

    /**
     * Calculate bit mask
     * @param position in this DisBitSet
     * @param length number of bits
     * @return bit mask
     */
    protected static int calculateMask(int position, int length)
    {
        int result = 0;
        for (int i = position; i < position + length; i++) {
            result |= (1 << i);
        }
        return result;
    }

    /**
     * Calculate bit mask
     * @param length number of bits
     * @return bit mask
     */
    protected static int calculateMask(int length)
    {
        int ret = 0;
        for (int i = 0; i < length; i++) {
            ret |= 1 << i;
        }
        return ret;
    }

    /**
     * Accessor method to set bits
     * @param position in this DisBitSet
     * @param length number of bits
     * @param value value of bits to set
     */
    protected void setbits(int position, int length, int value)
    {
        try {
            for (int i = position, j = 0; i < position + length; i++, j++) {
                boolean isset = (value & (1 << j)) != 0;
                set(i, i + 1, isset); // BitSet class
            }
        }
        catch (Throwable t) {
            showError(t);
        }
    }

  /**
   * Returns size of this serialized (marshalled) object in bytes
   * @see <a href="https://en.wikipedia.org/wiki/Marshalling_(computer_science)" target="_blank">https://en.wikipedia.org/wiki/Marshalling_(computer_science)</a>
   * @return serialized size in bytes
   */
    @Override
    public int getMarshalledSize()
    {
        return byteLength;
    }

    /** Marshal value to DataOutputStream
     * @see <a href="https://en.wikipedia.org/wiki/Marshalling_(computer_science)" target="_blank">https://en.wikipedia.org/wiki/Marshalling_(computer_science)</a>
     * @param dos DataOutputStream for output */
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

    /** Marshal value to ByteBuffer
     * @see <a href="https://en.wikipedia.org/wiki/Marshalling_(computer_science)" target="_blank">https://en.wikipedia.org/wiki/Marshalling_(computer_science)</a>
     * @param byteBuffer ByteBuffer for output */
    @Override
    public void marshal(ByteBuffer byteBuffer)
    {
        byteBuffer.put(marshallCommon());
    }

    /** Marshal value to ByteBuffer
     * @see <a href="https://en.wikipedia.org/wiki/Marshalling_(computer_science)" target="_blank">https://en.wikipedia.org/wiki/Marshalling_(computer_science)</a>
     * @see <a href="https://en.wikipedia.org/wiki/Endianness" target="_blank">https://en.wikipedia.org/wiki/Endianness</a>
     * @return Little-Endian byte array, network byte order requires reverse */
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
     * @see <a href="https://en.wikipedia.org/wiki/Marshalling_(computer_science)" target="_blank">https://en.wikipedia.org/wiki/Marshalling_(computer_science)</a>
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

    /**
     * Deserializes an object from a ByteBuffer.
     * @param byteBuffer input
     * @see <a href="https://en.wikipedia.org/wiki/Marshalling_(computer_science)" target="_blank">https://en.wikipedia.org/wiki/Marshalling_(computer_science)</a>
     * @return marshalled serialized size in bytes
     */
    @Override
    public int unmarshal(ByteBuffer byteBuffer)
    {
        byte[] ba = new byte[byteLength];
        byteBuffer.get(ba);
        unmarshalCommon(ba);
        
        return getMarshalledSize();
    }

    /** Deserializes an object from a byte array
     * @see <a href="https://en.wikipedia.org/wiki/Marshalling_(computer_science)" target="_blank">https://en.wikipedia.org/wiki/Marshalling_(computer_science)</a>
     * @see <a href="https://en.wikipedia.org/wiki/Endianness" target="_blank">https://en.wikipedia.org/wiki/Endianness</a>
     * @param ba byte array of interest */
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
        System.out.flush(); // ensure contiguous console outputs
        System.err.println(ex.getClass().getSimpleName() + ": " + ex.getMessage());
        System.err.flush(); // ensure contiguous console outputs
    }
}
