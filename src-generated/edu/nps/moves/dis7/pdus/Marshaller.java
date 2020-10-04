/**
 * Copyright (c) 2008-2020, MOVES Institute, Naval Postgraduate School (NPS). All rights reserved.
 * This work is provided under a BSD open-source license, see project license.html and license.txt
 */

package edu.nps.moves.dis7.pdus;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.nio.ByteBuffer;

/**
 * Marshaller.java created on Apr 22, 2019 
 * MOVES Institute, Naval Postgraduate School (NPS), Monterey California USA https://www.nps.edu
 */
public interface Marshaller
{
  /**
   * Returns size of this serialized (marshalled) object in bytes
   * See <a href="https://en.wikipedia.org/wiki/Marshalling_(computer_science)" target="_blank">https://en.wikipedia.org/wiki/Marshalling_(computer_science)</a>
   * @return serialized size in bytes
   */
    int getMarshalledSize();
    
    /**
     * 
     * @param dos the output stream to marshal to
     * @throws Exception error during marshaling
     */
    void marshal(DataOutputStream dos) throws Exception;
    
    /**
     * 
     * @param dis the input stream to unmarshal from
     * @return the size of the marshalled PDU in bytes
     * @throws Exception error during unmarshalling
     */
    int unmarshal(DataInputStream dis) throws Exception;

    /**
     * Packs a Pdu into the ByteBuffer.
     * @throws Exception error during marshaling
     * @see java.nio.ByteBuffer
     * @param byteBuffer The ByteBuffer at the position to begin writing
     */
    void marshal(ByteBuffer byteBuffer) throws Exception;
    
    /**
     * Unpacks a Pdu from the underlying data.
     * @return the size of the PDU
     * @throws Exception error during unmarshalling
     * @see java.nio.ByteBuffer
     * @param byteBuffer The ByteBuffer at the position to begin reading
     */
    int unmarshal(ByteBuffer byteBuffer) throws Exception;
}
