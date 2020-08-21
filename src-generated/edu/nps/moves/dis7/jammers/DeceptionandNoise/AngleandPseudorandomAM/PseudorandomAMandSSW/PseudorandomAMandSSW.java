package edu.nps.moves.dis7.jammers.DeceptionandNoise.AngleandPseudorandomAM.PseudorandomAMandSSW;

import edu.nps.moves.dis7.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 *
 * Jamming technique uid: 284
 */
public class PseudorandomAMandSSW extends JammingTechnique
{
    public PseudorandomAMandSSW()
    {
        setKind((byte)3); // Deception and Noise
        setCategory((byte)15); // Angle and Pseudorandom AM
        setSubCategory((byte)10); // Pseudorandom AM and SSW
    }
}
