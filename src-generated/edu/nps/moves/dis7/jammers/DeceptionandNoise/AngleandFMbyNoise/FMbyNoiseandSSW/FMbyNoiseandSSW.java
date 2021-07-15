package edu.nps.moves.dis7.jammers.DeceptionandNoise.AngleandFMbyNoise.FMbyNoiseandSSW;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28 (2020-05-07)
 *
 * Jamming technique uid: 284
 */
public class FMbyNoiseandSSW extends JammingTechnique
{
    /** Default constructor */
    public FMbyNoiseandSSW()
    {
        setKind((byte)3); // Deception and Noise
        setCategory((byte)10); // Angle and FM by Noise
        setSubCategory((byte)10); // FM by Noise and SSW
    }
}
