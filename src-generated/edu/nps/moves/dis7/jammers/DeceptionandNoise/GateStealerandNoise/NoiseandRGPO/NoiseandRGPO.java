package edu.nps.moves.dis7.jammers.DeceptionandNoise.GateStealerandNoise.NoiseandRGPO;

import edu.nps.moves.dis7.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v25, 2018-08-29
 *
 * Jamming technique uid: 284
 */
public class NoiseandRGPO extends JammingTechnique
{
    public NoiseandRGPO()
    {
        setKind((byte)3); // Deception and Noise
        setCategory((byte)25); // Gate Stealer and Noise
        setSubCategory((byte)5); // Noise and RGPO
    }
}
