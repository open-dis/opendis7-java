package edu.nps.moves.dis7.jammers.DeceptionandNoise.AngleandSpot.InverseGainandSpotNoise;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28 (2020-05-07)
 *
 * Jamming technique uid: 284
 */
public class InverseGainandSpotNoise extends JammingTechnique
{
    /** Default constructor */
    public InverseGainandSpotNoise()
    {
        setKind((byte)3); // Deception and Noise
        setCategory((byte)20); // Angle and Spot
        setSubCategory((byte)10); // Inverse Gain and Spot Noise
    }
}
