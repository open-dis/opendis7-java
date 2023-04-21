/**
 * Copyright (c) 2008-2023, MOVES Institute, Naval Postgraduate School (NPS). All rights reserved.
 * This work is provided under a BSD open-source license, see project license.html and license.txt
 */

package edu.nps.moves.dis7.pdus;

/**
 * EnumNotFoundException indicates that the enumeration of interest was not found
 */
public class EnumNotFoundException extends Exception
{

    /**
     * Constructor
     * @param s exception information of interest
     */
    public EnumNotFoundException (String s)
  {
      super(s);
  }
}
