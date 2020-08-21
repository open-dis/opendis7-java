package edu.nps.moves.dis7.jammers.Deception.GateStealer.RangeGatePull_OffRGPO;

import edu.nps.moves.dis7.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 *
 * Jamming technique uid: 284
 */
public class RangeGatePull_OffRGPO extends JammingTechnique
{
    public RangeGatePull_OffRGPO()
    {
        setKind((byte)2); // Deception
        setCategory((byte)75); // Gate Stealer
        setSubCategory((byte)10); // Range Gate Pull-Off (RGPO)
    }
}
