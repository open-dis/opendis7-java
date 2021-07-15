package edu.nps.moves.dis7.jammers.DeceptionandNoise.AngleandFMbyNoise.FMbyNoiseandInverseGain;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28 (2020-05-07)
 *
 * Jamming technique uid: 284
 */
public class FMbyNoiseandInverseGain extends JammingTechnique
{
    /** Default constructor */
    public FMbyNoiseandInverseGain()
    {
        setKind((byte)3); // Deception and Noise
        setCategory((byte)10); // Angle and FM by Noise
        setSubCategory((byte)5); // FM by Noise and Inverse Gain
    }
}
