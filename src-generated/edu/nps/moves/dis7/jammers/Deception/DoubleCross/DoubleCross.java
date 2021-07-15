package edu.nps.moves.dis7.jammers.Deception.DoubleCross;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28 (2020-05-07)
 *
 * Jamming technique uid: 284
 */
public class DoubleCross extends JammingTechnique
{
    /** Default constructor */
    public DoubleCross()
    {
        setKind((byte)2); // Deception
        setCategory((byte)55); // Double Cross
    }
}
