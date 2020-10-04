package edu.nps.moves.dis7.jammers.DeceptionandNoise.GateStealerandNoise.NoiseandRGPO.LowLevelNoiseandRGPO;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 *
 * Jamming technique uid: 284
 */
public class LowLevelNoiseandRGPO extends JammingTechnique
{
    public LowLevelNoiseandRGPO()
    {
        setKind((byte)3); // Deception and Noise
        setCategory((byte)25); // Gate Stealer and Noise
        setSubCategory((byte)5); // Noise and RGPO
        setSpecific((byte)5); // Low Level Noise and RGPO
    }
}
