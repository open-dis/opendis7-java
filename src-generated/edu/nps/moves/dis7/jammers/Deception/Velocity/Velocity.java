package edu.nps.moves.dis7.jammers.Deception.Velocity;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28 (2020-05-07)
 *
 * Jamming technique uid: 284
 */
public class Velocity extends JammingTechnique
{
    /** Default constructor */
    public Velocity()
    {
        setKind((byte)2); // Deception
        setCategory((byte)145); // Velocity
    }
}
