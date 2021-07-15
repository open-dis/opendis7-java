package edu.nps.moves.dis7.jammers.DeceptionandNoise.GateStealerandNoise.NoiseandRGPO;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28 (2020-05-07)
 *
 * Jamming technique uid: 284
 */
public class NoiseandRGPO extends JammingTechnique
{
    /** Default constructor */
    public NoiseandRGPO()
    {
        setKind((byte)3); // Deception and Noise
        setCategory((byte)25); // Gate Stealer and Noise
        setSubCategory((byte)5); // Noise and RGPO
    }
}
