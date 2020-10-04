package edu.nps.moves.dis7.jammers.Deception.Angle.SeaBounced;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 *
 * Jamming technique uid: 284
 */
public class SeaBounced extends JammingTechnique
{
    public SeaBounced()
    {
        setKind((byte)2); // Deception
        setCategory((byte)10); // Angle
        setSubCategory((byte)35); // Sea-Bounced
    }
}
