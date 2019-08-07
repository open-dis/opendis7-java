package edu.nps.moves.dis.jammers.Noise.PartialBand;

import edu.nps.moves.dis.*;
import edu.nps.moves.dis.enumerations.*;

/**
 * SISO-REF-010-v25, 2018-08-29
 *
 * Jamming technique uid: 284
 */
public class PartialBand extends JammingTechnique
{
    public PartialBand()
    {
        setKind((byte)1); // Noise
        setCategory((byte)45); // Partial Band
    }
}
