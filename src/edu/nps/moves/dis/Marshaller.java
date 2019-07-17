package edu.nps.moves.dis;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.nio.ByteBuffer;

/**
 * Marshaller.java created on Apr 22, 2019 MOVES Institute Naval Postgraduate School, Monterey, CA, USA www.nps.edu
 *
 * @author Mike Bailey, jmbailey@nps.edu
 * @version $Id$
 */
public interface Marshaller
{
    public int getMarshalledSize();
    
    public void marshal(DataOutputStream dos);
    public int unmarshal(DataInputStream dis);

    /**
     * Packs a Pdu into the ByteBuffer.
     * @see java.nio.ByteBuffer
     * @param buff The ByteBuffer at the position to begin writing
     */
    public void marshal(ByteBuffer buff);
    
    /**
     * Unpacks a Pdu from the underlying data.
     * @see java.nio.ByteBuffer
     * @param buff The ByteBuffer at the position to begin reading
     */
    public int unmarshal(ByteBuffer buff);
}
