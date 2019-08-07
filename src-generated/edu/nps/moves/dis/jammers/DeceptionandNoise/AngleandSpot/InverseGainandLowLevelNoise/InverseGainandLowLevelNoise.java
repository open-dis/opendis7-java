package edu.nps.moves.dis.jammers.DeceptionandNoise.AngleandSpot.InverseGainandLowLevelNoise;

import edu.nps.moves.dis.*;
import edu.nps.moves.dis.enumerations.*;

/**
 * SISO-REF-010-v25, 2018-08-29
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
