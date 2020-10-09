package edu.nps.moves.dis7.jammers.Deception.AngleandGateStealer.CrossPolarizationRGPOandVGPO;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 *
 * Jamming technique uid: 284
 */
public class CrossPolarizationRGPOandVGPO extends JammingTechnique
{
    public CrossPolarizationRGPOandVGPO()
    {
        setKind((byte)2); // Deception
        setCategory((byte)15); // Angle and Gate Stealer
        setSubCategory((byte)15); // Cross-Polarization, RGPO and VGPO
    }
}
