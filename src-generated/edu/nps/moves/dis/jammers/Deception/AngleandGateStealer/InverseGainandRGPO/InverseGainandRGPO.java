package edu.nps.moves.dis.jammers.Deception.AngleandGateStealer.InverseGainandRGPO;

import edu.nps.moves.dis.*;
import edu.nps.moves.dis.enumerations.*;

/**
 * SISO-REF-010-v25, 2018-08-29
 *
 * Jamming technique uid: 284
 */
public class InverseGainandRGPO extends JammingTechnique
{
    public InverseGainandRGPO()
    {
        setKind((byte)2); // Deception
        setCategory((byte)15); // Angle and Gate Stealer
        setSubCategory((byte)20); // Inverse Gain and RGPO
    }
}
