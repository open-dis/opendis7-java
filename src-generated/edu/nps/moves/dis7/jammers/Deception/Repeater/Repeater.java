package edu.nps.moves.dis7.jammers.Deception.Repeater;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 *
 * Jamming technique uid: 284
 */
public class Repeater extends JammingTechnique
{
    public Repeater()
    {
        setKind((byte)2); // Deception
        setCategory((byte)130); // Repeater
    }
}
