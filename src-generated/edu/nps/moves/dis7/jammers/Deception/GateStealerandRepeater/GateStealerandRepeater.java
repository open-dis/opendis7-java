package edu.nps.moves.dis7.jammers.Deception.GateStealerandRepeater;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 *
 * Jamming technique uid: 284
 */
public class GateStealerandRepeater extends JammingTechnique
{
    public GateStealerandRepeater()
    {
        setKind((byte)2); // Deception
        setCategory((byte)80); // Gate Stealer and Repeater
    }
}
