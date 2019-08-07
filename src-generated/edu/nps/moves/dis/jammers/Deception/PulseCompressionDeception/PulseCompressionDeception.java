package edu.nps.moves.dis.jammers.Deception.PulseCompressionDeception;

import edu.nps.moves.dis.*;
import edu.nps.moves.dis.enumerations.*;

/**
 * SISO-REF-010-v25, 2018-08-29
 *
 * Jamming technique uid: 284
 */
public class PulseCompressionDeception extends JammingTechnique
{
    public PulseCompressionDeception()
    {
        setKind((byte)2); // Deception
        setCategory((byte)115); // Pulse Compression Deception
    }
}
