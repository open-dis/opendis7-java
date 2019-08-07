package edu.nps.moves.dis.jammers.Deception.AGCandGateStealer.AGCandRGPO;

import edu.nps.moves.dis.*;
import edu.nps.moves.dis.enumerations.*;

/**
 * SISO-REF-010-v25, 2018-08-29
 *
 * Jamming technique uid: 284
 */
public class AGCandRGPO extends JammingTechnique
{
    public AGCandRGPO()
    {
        setKind((byte)2); // Deception
        setCategory((byte)40); // AGC and Gate Stealer
        setSubCategory((byte)5); // AGC and RGPO
    }
}
