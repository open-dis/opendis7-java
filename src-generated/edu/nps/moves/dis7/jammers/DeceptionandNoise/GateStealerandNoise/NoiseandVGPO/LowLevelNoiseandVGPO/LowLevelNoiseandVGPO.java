package edu.nps.moves.dis7.jammers.DeceptionandNoise.GateStealerandNoise.NoiseandVGPO.LowLevelNoiseandVGPO;

import edu.nps.moves.dis7.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v25, 2018-08-29
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
