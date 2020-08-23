/**
 * Copyright (c) 2008-2020, MOVES Institute, Naval Postgraduate School (NPS). All rights reserved.
 * This work is provided under a BSD open-source license, see project license.html and license.txt
 */

package edu.nps.moves.dis7;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.nio.ByteBuffer;

/**
 * Marshaller.java created on Apr 22, 2019 MOVES Institute Naval Postgraduate School, Monterey, CA, USA www.nps.edu
 */
public interface Marshaller
{
    /**
     * 
     * @return size in bytes of a value from a stream
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
     * @return the size of the PDU
     * @throws Exception error during unmarshalling
     */
    int unmarshal(DataInputStream dis) throws Exception;

    /**
     * Packs a Pdu into the ByteBuffer.
     * @throws Exception error during marshaling
     * @see java.nio.ByteBuffer
     * @param buff The ByteBuffer at the position to begin writing
     */
    void marshal(ByteBuffer buff) throws Exception;
    
    /**
     * Unpacks a Pdu from the underlying data.
     * @return the size of the PDU
     * @throws Exception error during unmarshalling
     * @see java.nio.ByteBuffer
     * @param buff The ByteBuffer at the position to begin reading
     */
    int unmarshal(ByteBuffer buff) throws Exception;
}
