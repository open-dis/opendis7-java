package edu.nps.moves.dis.jammers.Noise.PulseNoise;

import edu.nps.moves.dis.*;
import edu.nps.moves.dis.enumerations.*;

/**
 * SISO-REF-010-v25, 2018-08-29
 *
 * Jamming technique uid: 284
 */
public class PulseNoise extends JammingTechnique
{
    public PulseNoise()
    {
        setKind((byte)1); // Noise
        setCategory((byte)55); // Pulse Noise
    }
}
