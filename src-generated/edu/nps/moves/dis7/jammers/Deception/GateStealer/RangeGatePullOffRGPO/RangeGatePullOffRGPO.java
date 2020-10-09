package edu.nps.moves.dis7.jammers.Deception.GateStealer.RangeGatePullOffRGPO;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 *
 * Jamming technique uid: 284
 */
public class RangeGatePullOffRGPO extends JammingTechnique
{
    public RangeGatePullOffRGPO()
    {
        setKind((byte)2); // Deception
        setCategory((byte)75); // Gate Stealer
        setSubCategory((byte)10); // Range Gate Pull-Off (RGPO)
    }
}
