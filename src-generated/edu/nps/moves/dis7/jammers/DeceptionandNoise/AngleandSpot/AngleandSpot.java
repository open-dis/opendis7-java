package edu.nps.moves.dis7.jammers.DeceptionandNoise.AngleandSpot;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 *
 * Jamming technique uid: 284
 */
public class AngleandSpot extends JammingTechnique
{
    public AngleandSpot()
    {
        setKind((byte)3); // Deception and Noise
        setCategory((byte)20); // Angle and Spot
    }
}
