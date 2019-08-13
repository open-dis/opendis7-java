package edu.nps.moves.dis7.jammers.Noise.SweptNoiseakaSweptSpotNoise_Sweep.FrequencySwept;

import edu.nps.moves.dis7.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v25, 2018-08-29
 *
 * Jamming technique uid: 284
 */
public class FrequencySwept extends JammingTechnique
{
    public FrequencySwept()
    {
        setKind((byte)1); // Noise
        setCategory((byte)80); // Swept Noise (aka Swept Spot Noise, Sweep)
        setSubCategory((byte)5); // Frequency Swept
    }
}
