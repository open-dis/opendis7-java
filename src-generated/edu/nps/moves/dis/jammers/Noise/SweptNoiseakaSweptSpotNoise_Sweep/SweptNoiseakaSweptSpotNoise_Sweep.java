package edu.nps.moves.dis.jammers.Noise.SweptNoiseakaSweptSpotNoise_Sweep;

import edu.nps.moves.dis.*;
import edu.nps.moves.dis.enumerations.*;

/**
 * SISO-REF-010-v25, 2018-08-29
 *
 * Jamming technique uid: 284
 */
public class SweptNoiseakaSweptSpotNoise_Sweep extends JammingTechnique
{
    public SweptNoiseakaSweptSpotNoise_Sweep()
    {
        setKind((byte)1); // Noise
        setCategory((byte)80); // Swept Noise (aka Swept Spot Noise, Sweep)
    }
}
