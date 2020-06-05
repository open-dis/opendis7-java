/**
 * Copyright (c) 2008-2020, MOVES Institute, Naval Postgraduate School (NPS). All rights reserved.
 * This work is provided under a BSD open-source license, see project license.html and license.txt
 */

package edu.nps.moves.dis7;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Arrays;

/**
 * Align.java created on Jul 15, 2019
 * A class with methods to marshal and unmarshal variable length padding
 *
 * @author Mike Bailey, jmbailey@nps.edu
 * @version $Id$
 */
public class Align
{
  static public int to16bits(ByteBuffer buff)
  {
      int pad = (2 - buff.position() % 2) % 2;
      Arrays.stream(new int[pad]).forEach(x->buff.put((byte)0));
      return pad;
  }
  
  static public int to16bits(DataOutputStream dos)
  {
      int pad = (2 - dos.size() % 2) % 2;
      Arrays.stream(new int[pad]).forEach(x->dosWrite(dos));
      return pad;
  }
  
  static public int to32bits(ByteBuffer buff)
  {
      int pad = (4 - buff.position() % 4) % 4;
      Arrays.stream(new int[pad]).forEach(x->buff.put((byte)0));
      return pad;
  }
  
  static public int to32bits(DataOutputStream dos)
  {
      int pad = (4 - dos.size() % 4) % 4;
      Arrays.stream(new int[pad]).forEach(x->dosWrite(dos));
      return pad;
  }
  
  static public int to64bits(ByteBuffer buff)
  {
      int pad = (8 - buff.position() % 8) % 8;
      Arrays.stream(new int[pad]).forEach(x->buff.put((byte)0));
      return pad;
  }
  
  static public int to64bits(DataOutputStream dos)
  {
      int pad = (8 - dos.size() % 8) % 8;
      Arrays.stream(new int[pad]).forEach(x->dosWrite(dos));
      return pad;
  }
  
  /********* Unmarshaling **************/
  static public int from16bits(ByteBuffer buff)
  {
      int pad = (2 - buff.position() % 2) % 2;
      Arrays.stream(new int[pad]).forEach(x->buff.get());
      return pad;
  }
  
  static public int from16bits(int position, DataInputStream dis)
  {
      int pad = (2 - position % 2) % 2;
      Arrays.stream(new int[pad]).forEach(x->disRead(dis));
      return pad;
  }
  
  static public int from32bits(ByteBuffer buff)
  {
      int pad = (4 - buff.position() % 4) % 4;
      Arrays.stream(new int[pad]).forEach(x->buff.get());
      return pad;
  }
  
  static public int from32bits(int position, DataInputStream dis)
  {
      int pad = (4 - position % 4) % 4;
      Arrays.stream(new int[pad]).forEach(x->disRead(dis));
      return pad;
  }
  
  static public int from64bits(ByteBuffer buff)
  {
      int pad = (8 - buff.position() % 8) % 8;
      Arrays.stream(new int[pad]).forEach(x->buff.get());
      return pad;
  }
  
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
