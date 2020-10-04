package edu.nps.moves.dis7.jammers.DeceptionandNoise.AngleandSpot.InverseGainandLowLevelNoise;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 *
 * Jamming technique uid: 284
 */
public class InverseGainandLowLevelNoise extends JammingTechnique
{
    public InverseGainandLowLevelNoise()
    {
        setKind((byte)3); // Deception and Noise
        setCategory((byte)20); // Angle and Spot
        setSubCategory((byte)5); // Inverse Gain and Low Level Noise
    }
}
