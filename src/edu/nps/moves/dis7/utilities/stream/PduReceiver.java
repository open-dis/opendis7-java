/**
 * Copyright (c) 2008-2020, MOVES Institute, Naval Postgraduate School (NPS). All rights reserved.
 * This work is provided under a BSD open-source license, see project license.html and license.txt
 */
package edu.nps.moves.dis7.utilities.stream;

/** An interface for capturing PDU raw data for file logging
 * 
 * @author Mike Bailey, jmbailey@nps.edu
 */
public interface PduReceiver
{
  /** Receives a PDU and writes its raw contents to an output file for later
   * playback and inspection.
   * 
   * @param buff the array containing raw PDU data
   * @param len the length of the buffer
   */
  void receivePdu(byte[] buff, int len);
}
