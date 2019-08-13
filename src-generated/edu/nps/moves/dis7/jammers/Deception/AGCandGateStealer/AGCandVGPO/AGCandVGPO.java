package edu.nps.moves.dis7.jammers.Deception.AGCandGateStealer.AGCandVGPO;

import edu.nps.moves.dis7.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v25, 2018-08-29
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
