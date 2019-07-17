/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.nps.moves.dis;

/**
 * EnumNotFoundException.java created on Apr 15, 2019
 * MOVES Institute Naval Postgraduate School, Monterey, CA, USA www.nps.edu
 *
 * @author Mike Bailey, jmbailey@nps.edu
 * @version $Id$
 */
public class EnumNotFoundException extends Exception
{
  public EnumNotFoundException (String s)
  {
      super(s);
  }
}
