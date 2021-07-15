package edu.nps.moves.dis7.jammers.Noise.PulseNoise;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28 (2020-05-07)
 *
 * Jamming technique uid: 284
 */
public class PulseNoise extends JammingTechnique
{
    /** Default constructor */
    public PulseNoise()
    {
        setKind((byte)1); // Noise
        setCategory((byte)55); // Pulse Noise
    }
}
