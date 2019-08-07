package edu.nps.moves.dis.jammers.Deception.GateStealer;

import edu.nps.moves.dis.*;
import edu.nps.moves.dis.enumerations.*;

/**
 * SISO-REF-010-v25, 2018-08-29
 *
 * Jamming technique uid: 284
 */
public class GateStealer extends JammingTechnique
{
    public GateStealer()
    {
        setKind((byte)2); // Deception
        setCategory((byte)75); // Gate Stealer
    }
}
