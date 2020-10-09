package edu.nps.moves.dis7.jammers.Deception.Repeater.MultipleFrequencyRepeaterMFR;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 *
 * Jamming technique uid: 284
 */
public class MultipleFrequencyRepeaterMFR extends JammingTechnique
{
    public MultipleFrequencyRepeaterMFR()
    {
        setKind((byte)2); // Deception
        setCategory((byte)130); // Repeater
        setSubCategory((byte)15); // Multiple Frequency Repeater (MFR)
    }
}
