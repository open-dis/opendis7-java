package edu.nps.moves.dis7.jammers.Deception.GateStealer.RGPOandVGPO;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28 (2020-05-07)
 *
 * Jamming technique uid: 284
 */
public class RGPOandVGPO extends JammingTechnique
{
    /** Default constructor */
    public RGPOandVGPO()
    {
        setKind((byte)2); // Deception
        setCategory((byte)75); // Gate Stealer
        setSubCategory((byte)15); // RGPO and VGPO
    }
}
