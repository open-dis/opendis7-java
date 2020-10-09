package edu.nps.moves.dis7.jammers.Deception.AGCandGateStealer.AGCandVGPO;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 *
 * Jamming technique uid: 284
 */
public class AGCandVGPO extends JammingTechnique
{
    public AGCandVGPO()
    {
        setKind((byte)2); // Deception
        setCategory((byte)40); // AGC and Gate Stealer
        setSubCategory((byte)10); // AGC and VGPO
    }
}
