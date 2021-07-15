package edu.nps.moves.dis7.jammers.DeceptionandNoise.AngleandPseudorandomAM.InverseGainandPseudorandomAM;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28 (2020-05-07)
 *
 * Jamming technique uid: 284
 */
public class InverseGainandPseudorandomAM extends JammingTechnique
{
    /** Default constructor */
    public InverseGainandPseudorandomAM()
    {
        setKind((byte)3); // Deception and Noise
        setCategory((byte)15); // Angle and Pseudorandom AM
        setSubCategory((byte)5); // Inverse Gain and Pseudorandom AM
    }
}
