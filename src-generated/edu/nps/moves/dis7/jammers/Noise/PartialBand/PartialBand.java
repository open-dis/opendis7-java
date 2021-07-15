package edu.nps.moves.dis7.jammers.Noise.PartialBand;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28 (2020-05-07)
 *
 * Jamming technique uid: 284
 */
public class PartialBand extends JammingTechnique
{
    /** Default constructor */
    public PartialBand()
    {
        setKind((byte)1); // Noise
        setCategory((byte)45); // Partial Band
    }
}
