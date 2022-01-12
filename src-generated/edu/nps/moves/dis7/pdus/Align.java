/**
 * Copyright (c) 2008-2022, MOVES Institute, Naval Postgraduate School (NPS). All rights reserved.
 * This work is provided under a BSD open-source license, see project license.html and license.txt
 */

package edu.nps.moves.dis7.pdus;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Arrays;

/**
 * Align is a class with methods to marshal and unmarshal variable length padding.
 *
 * @author Mike Bailey, jmbailey@nps.edu
 * @version $Id$
 */
public class Align
{
  /** Align bits to byteBuffer
   * @param byteBuffer output
   * @return padded integer
  */
  static public int to16bits(ByteBuffer byteBuffer)
  {
      int pad = (2 - byteBuffer.position() % 2) % 2;
      Arrays.stream(new int[pad]).forEach(x->byteBuffer.put((byte)0));
      return pad;
  }

  /** Align bits to DataOutputStream
   * @param dos DataOutputStream output
   * @return padded integer
  */
  static public int to16bits(DataOutputStream dos)
  {
      int pad = (2 - dos.size() % 2) % 2;
      Arrays.stream(new int[pad]).forEach(x->dosWrite(dos));
      return pad;
  }

  /** Align bits to byteBuffer
   * @param byteBuffer output
   * @return padded integer
  */
  static public int to32bits(ByteBuffer byteBuffer)
  {
      int pad = (4 - byteBuffer.position() % 4) % 4;
      Arrays.stream(new int[pad]).forEach(x->byteBuffer.put((byte)0));
      return pad;
  }

  /** Align bits to DataOutputStream
   * @param dos DataOutputStream output
   * @return padded integer
  */
  static public int to32bits(DataOutputStream dos)
  {
      int pad = (4 - dos.size() % 4) % 4;
      Arrays.stream(new int[pad]).forEach(x->dosWrite(dos));
      return pad;
  }

  /** Align bits to byteBuffer
   * @param byteBuffer output
   * @return padded integer
  */
  static public int to64bits(ByteBuffer byteBuffer)
  {
      int pad = (8 - byteBuffer.position() % 8) % 8;
      Arrays.stream(new int[pad]).forEach(x->byteBuffer.put((byte)0));
      return pad;
  }

  /** Align bits to DataOutputStream
   * @param dos DataOutputStream output
   * @return padded integer
  */
  static public int to64bits(DataOutputStream dos)
  {
      int pad = (8 - dos.size() % 8) % 8;
      Arrays.stream(new int[pad]).forEach(x->dosWrite(dos));
      return pad;
  }
  
  /* ******** Unmarshaling ************* */
  /** Align bits from byteBuffer
   * @param byteBuffer input
   * @return padded integer
  */
  static public int from16bits(ByteBuffer byteBuffer)
  {
      int pad = (2 - byteBuffer.position() % 2) % 2;
      Arrays.stream(new int[pad]).forEach(x->byteBuffer.get());
      return pad;
  }
  
  /** Align bits from DataInputStream
   * @param position starting position for input
   * @param dis input DataInputStream
   * @return padded integer
  */
  static public int from16bits(int position, DataInputStream dis)
  {
      int pad = (2 - position % 2) % 2;
      Arrays.stream(new int[pad]).forEach(x->disRead(dis));
      return pad;
  }
  
  /** Align bits from byteBuffer
   * @param byteBuffer input
   * @return padded integer
  */
  static public int from32bits(ByteBuffer byteBuffer)
  {
      int pad = (4 - byteBuffer.position() % 4) % 4;
      Arrays.stream(new int[pad]).forEach(x->byteBuffer.get());
      return pad;
  }
  
  /** Align bits from DataInputStream
   * @param position starting position for input
   * @param dis input DataInputStream
   * @return padded integer
  */
  static public int from32bits(int position, DataInputStream dis)
  {
      int pad = (4 - position % 4) % 4;
      Arrays.stream(new int[pad]).forEach(x->disRead(dis));
      return pad;
  }
  
  /** Align bits from byteBuffer
   * @param byteBuffer input
   * @return padded integer
  */
  static public int from64bits(ByteBuffer byteBuffer)
  {
      int pad = (8 - byteBuffer.position() % 8) % 8;
      Arrays.stream(new int[pad]).forEach(x->byteBuffer.get());
      return pad;
  }
  
  /** Align bits from DataInputStream
   * @param position starting position for input
   * @param dis input DataInputStream
   * @return padded integer
  */
  static public int from64bits(int position, DataInputStream dis)
  {
      int pad = (8 - position % 8) % 8;
      Arrays.stream(new int[pad]).forEach(x->disRead(dis));
      return pad;
  }

  static private void disRead(DataInputStream dis)
  {
      try {
          dis.read();
      }
      catch(IOException ex) {
          ex.printStackTrace(System.err);
          throw new RuntimeException("IOException ex: "+ex.getLocalizedMessage());
      }
  }
  
  static private void dosWrite(DataOutputStream dos)
  {
     try {
          dos.writeByte(0);
      }
      catch(IOException ex) {
          ex.printStackTrace(System.err);
          throw new RuntimeException("IOException ex: "+ex.getLocalizedMessage());
      }
      
  }
}
