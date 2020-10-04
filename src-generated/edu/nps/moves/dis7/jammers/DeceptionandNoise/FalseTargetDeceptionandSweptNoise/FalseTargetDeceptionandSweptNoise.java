package edu.nps.moves.dis7.jammers.DeceptionandNoise.FalseTargetDeceptionandSweptNoise;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 *
 * Jamming technique uid: 284
 */
public class FalseTargetDeceptionandSweptNoise extends JammingTechnique
{
    public FalseTargetDeceptionandSweptNoise()
    {
        setKind((byte)3); // Deception and Noise
        setCategory((byte)30); // False Target Deception and Swept Noise
    }
}
