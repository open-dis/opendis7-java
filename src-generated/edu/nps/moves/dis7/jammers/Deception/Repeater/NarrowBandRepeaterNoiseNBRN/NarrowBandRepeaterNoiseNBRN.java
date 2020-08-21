package edu.nps.moves.dis7.jammers.Deception.Repeater.NarrowBandRepeaterNoiseNBRN;

import edu.nps.moves.dis7.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 *
 * Jamming technique uid: 284
 */
public class NarrowBandRepeaterNoiseNBRN extends JammingTechnique
{
    public NarrowBandRepeaterNoiseNBRN()
    {
        setKind((byte)2); // Deception
        setCategory((byte)130); // Repeater
        setSubCategory((byte)20); // Narrow Band Repeater Noise (NBRN)
    }
}
