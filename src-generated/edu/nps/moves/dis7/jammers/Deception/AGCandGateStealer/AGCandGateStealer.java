package edu.nps.moves.dis7.jammers.Deception.AGCandGateStealer;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28 (2020-05-07)
 *
 * Jamming technique uid: 284
 */
public class AGCandGateStealer extends JammingTechnique
{
    /** Default constructor */
    public AGCandGateStealer()
    {
        setKind((byte)2); // Deception
        setCategory((byte)40); // AGC and Gate Stealer
    }
}
