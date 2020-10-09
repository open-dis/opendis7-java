package edu.nps.moves.dis7.jammers.DeceptionandNoise.GateStealerandNoise.NoiseandVGPO.LowLevelNoiseandVGPO;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 *
 * Jamming technique uid: 284
 */
public class LowLevelNoiseandVGPO extends JammingTechnique
{
    public LowLevelNoiseandVGPO()
    {
        setKind((byte)3); // Deception and Noise
        setCategory((byte)25); // Gate Stealer and Noise
        setSubCategory((byte)10); // Noise and VGPO
        setSpecific((byte)5); // Low Level Noise and VGPO
    }
}
