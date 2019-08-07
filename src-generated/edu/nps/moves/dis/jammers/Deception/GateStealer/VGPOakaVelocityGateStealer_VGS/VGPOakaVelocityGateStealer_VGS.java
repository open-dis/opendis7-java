package edu.nps.moves.dis.jammers.Deception.GateStealer.VGPOakaVelocityGateStealer_VGS;

import edu.nps.moves.dis.*;
import edu.nps.moves.dis.enumerations.*;

/**
 * SISO-REF-010-v25, 2018-08-29
 *
 * Jamming technique uid: 284
 */
public class VGPOakaVelocityGateStealer_VGS extends JammingTechnique
{
    public VGPOakaVelocityGateStealer_VGS()
    {
        setKind((byte)2); // Deception
        setCategory((byte)75); // Gate Stealer
        setSubCategory((byte)20); // VGPO (aka Velocity Gate Stealer, VGS)
    }
}
