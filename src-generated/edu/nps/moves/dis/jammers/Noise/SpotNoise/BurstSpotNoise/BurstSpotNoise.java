package edu.nps.moves.dis.jammers.Noise.SpotNoise.BurstSpotNoise;

import edu.nps.moves.dis.*;
import edu.nps.moves.dis.enumerations.*;

/**
 * SISO-REF-010-v25, 2018-08-29
 *
 * Jamming technique uid: 284
 */
public class BurstSpotNoise extends JammingTechnique
{
    public BurstSpotNoise()
    {
        setKind((byte)1); // Noise
        setCategory((byte)75); // Spot Noise
        setSubCategory((byte)15); // Burst Spot Noise
    }
}
