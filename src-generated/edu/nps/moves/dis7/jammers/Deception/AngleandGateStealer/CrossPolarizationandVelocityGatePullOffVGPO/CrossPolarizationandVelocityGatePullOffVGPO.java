package edu.nps.moves.dis7.jammers.Deception.AngleandGateStealer.CrossPolarizationandVelocityGatePullOffVGPO;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 *
 * Jamming technique uid: 284
 */
public class CrossPolarizationandVelocityGatePullOffVGPO extends JammingTechnique
{
    public CrossPolarizationandVelocityGatePullOffVGPO()
    {
        setKind((byte)2); // Deception
        setCategory((byte)15); // Angle and Gate Stealer
        setSubCategory((byte)10); // Cross-Polarization and Velocity Gate Pull-Off (VGPO)
    }
}
