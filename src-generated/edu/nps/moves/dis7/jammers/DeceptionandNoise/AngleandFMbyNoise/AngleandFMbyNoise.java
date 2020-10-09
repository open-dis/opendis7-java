package edu.nps.moves.dis7.jammers.DeceptionandNoise.AngleandFMbyNoise;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 *
 * Jamming technique uid: 284
 */
public class AngleandFMbyNoise extends JammingTechnique
{
    public AngleandFMbyNoise()
    {
        setKind((byte)3); // Deception and Noise
        setCategory((byte)10); // Angle and FM by Noise
    }
}
