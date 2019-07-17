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
    /**
     * @return the size in bytes of the serialized object
     */
    public int getMarshalledSize();
    
    /**
     * Serializes an object into a DataOutputStream.
     * @param dos the DataOutputStream to write
     * @see java.io.DataOutputStream
     */
    public void marshal(DataOutputStream dos);
    
    /**
     * Unserializes an object from a DataInputStream
     * @param dis the DataInputStream to read
     * @see java.io.DataInputStream
     * @return number of bytes unmarshalled
     */
    public int unmarshal(DataInputStream dis);

    /**
     * Serializes an object into a ByteBuffer.
     * @param buff The ByteBuffer at the position to begin writing
     * @see java.nio.ByteBuffer
     */
    public void marshal(ByteBuffer buff);
    
    /**
     * Unserializes an object from a ByteBuffer
     * @param buff The ByteBuffer at the position to begin reading
     * @see java.nio.ByteBuffer
     * @return unmarshalled size
     */
    public int unmarshal(ByteBuffer buff);
}
