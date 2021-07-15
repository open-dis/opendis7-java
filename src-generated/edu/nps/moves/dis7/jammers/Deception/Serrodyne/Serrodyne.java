package edu.nps.moves.dis7.jammers.Deception.Serrodyne;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28 (2020-05-07)
 *
 * Jamming technique uid: 284
 */
public class Serrodyne extends JammingTechnique
{
    /** Default constructor */
    public Serrodyne()
    {
        setKind((byte)2); // Deception
        setCategory((byte)140); // Serrodyne
    }
}
