package edu.nps.moves.dis7.jammers.Deception.AngleandFalseTarget.AngleandVelocityFalseTargetsVFT.SSWandVFT;

import edu.nps.moves.dis7.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 *
 * Jamming technique uid: 284
 */
public class SSWandVFT extends JammingTechnique
{
    public SSWandVFT()
    {
        setKind((byte)2); // Deception
        setCategory((byte)20); // Angle and False Target
        setSubCategory((byte)5); // Angle and Velocity False Targets (VFT)
        setSpecific((byte)10); // SSW and VFT
    }
}
