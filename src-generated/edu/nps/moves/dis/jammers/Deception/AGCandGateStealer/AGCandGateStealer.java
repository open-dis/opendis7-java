package edu.nps.moves.dis.jammers.Deception.AGCandGateStealer;

import edu.nps.moves.dis.*;
import edu.nps.moves.dis.enumerations.*;

/**
 * SISO-REF-010-v25, 2018-08-29
 *
 * Jamming technique uid: 284
 */
public class AGCandGateStealer extends JammingTechnique
{
    public AGCandGateStealer()
    {
        setKind((byte)2); // Deception
        setCategory((byte)40); // AGC and Gate Stealer
    }
}
