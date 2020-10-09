package edu.nps.moves.dis7.jammers.Deception.AngleandGateStealer.InverseGainandRGPOandVGPO;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 *
 * Jamming technique uid: 284
 */
public class InverseGainandRGPOandVGPO extends JammingTechnique
{
    public InverseGainandRGPOandVGPO()
    {
        setKind((byte)2); // Deception
        setCategory((byte)15); // Angle and Gate Stealer
        setSubCategory((byte)25); // Inverse Gain and RGPO and VGPO
    }
}
