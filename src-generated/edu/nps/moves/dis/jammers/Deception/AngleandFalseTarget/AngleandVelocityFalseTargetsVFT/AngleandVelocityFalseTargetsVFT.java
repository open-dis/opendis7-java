package edu.nps.moves.dis.jammers.Deception.AngleandFalseTarget.AngleandVelocityFalseTargetsVFT;

import edu.nps.moves.dis.*;
import edu.nps.moves.dis.enumerations.*;

/**
 * SISO-REF-010-v25, 2018-08-29
 *
 * Jamming technique uid: 284
 */
public class AngleandVelocityFalseTargetsVFT extends JammingTechnique
{
    public AngleandVelocityFalseTargetsVFT()
    {
        setKind((byte)2); // Deception
        setCategory((byte)20); // Angle and False Target
        setSubCategory((byte)5); // Angle and Velocity False Targets (VFT)
    }
}
