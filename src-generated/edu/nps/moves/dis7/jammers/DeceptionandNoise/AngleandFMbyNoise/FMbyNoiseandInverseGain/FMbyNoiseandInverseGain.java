package edu.nps.moves.dis7.jammers.DeceptionandNoise.AngleandFMbyNoise.FMbyNoiseandInverseGain;

import edu.nps.moves.dis7.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v25, 2018-08-29
 *
 * Jamming technique uid: 284
 */
public class FMbyNoiseandInverseGain extends JammingTechnique
{
    public FMbyNoiseandInverseGain()
    {
        setKind((byte)3); // Deception and Noise
        setCategory((byte)10); // Angle and FM by Noise
        setSubCategory((byte)5); // FM by Noise and Inverse Gain
    }
}
