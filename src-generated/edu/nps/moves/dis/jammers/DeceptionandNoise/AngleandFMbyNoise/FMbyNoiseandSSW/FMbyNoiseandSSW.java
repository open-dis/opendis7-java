package edu.nps.moves.dis.jammers.DeceptionandNoise.AngleandFMbyNoise.FMbyNoiseandSSW;

import edu.nps.moves.dis.*;
import edu.nps.moves.dis.enumerations.*;

/**
 * SISO-REF-010-v25, 2018-08-29
 *
 * Jamming technique uid: 284
 */
public class FMbyNoiseandSSW extends JammingTechnique
{
    public FMbyNoiseandSSW()
    {
        setKind((byte)3); // Deception and Noise
        setCategory((byte)10); // Angle and FM by Noise
        setSubCategory((byte)10); // FM by Noise and SSW
    }
}
