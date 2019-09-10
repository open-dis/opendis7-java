/**
 * Copyright (c) 2008-2019, MOVES Institute, Naval Postgraduate School. All rights reserved.
 * This work is licensed under the BSD open source license, available at https://www.movesinstitute.org/licenses/bsd.html
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
    public int getMarshalledSize();
    
    public void marshal(DataOutputStream dos) throws Exception;
    public int unmarshal(DataInputStream dis) throws Exception;

    /**
     * Packs a Pdu into the ByteBuffer.
     * @see java.nio.ByteBuffer
     * @param buff The ByteBuffer at the position to begin writing
     */
    public void marshal(ByteBuffer buff) throws Exception;
    
    /**
     * Unpacks a Pdu from the underlying data.
     * @see java.nio.ByteBuffer
     * @param buff The ByteBuffer at the position to begin reading
     */
    public int unmarshal(ByteBuffer buff) throws Exception;
}
