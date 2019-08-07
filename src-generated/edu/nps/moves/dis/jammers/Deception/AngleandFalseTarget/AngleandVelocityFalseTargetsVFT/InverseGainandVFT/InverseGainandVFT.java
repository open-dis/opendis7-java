package edu.nps.moves.dis.jammers.Deception.AngleandFalseTarget.AngleandVelocityFalseTargetsVFT.InverseGainandVFT;

import edu.nps.moves.dis.*;
import edu.nps.moves.dis.enumerations.*;

/**
 * SISO-REF-010-v25, 2018-08-29
 *
 * Jamming technique uid: 284
 */
public class InverseGainandVFT extends JammingTechnique
{
    public InverseGainandVFT()
    {
        setKind((byte)2); // Deception
        setCategory((byte)20); // Angle and False Target
        setSubCategory((byte)5); // Angle and Velocity False Targets (VFT)
        setSpecific((byte)5); // Inverse Gain and VFT
    }
}
