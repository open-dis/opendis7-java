package edu.nps.moves.dis7.jammers.Noise.SpotNoise;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 *
 * Jamming technique uid: 284
 */
public class SpotNoise extends JammingTechnique
{
    public SpotNoise()
    {
        setKind((byte)1); // Noise
        setCategory((byte)75); // Spot Noise
    }
}
