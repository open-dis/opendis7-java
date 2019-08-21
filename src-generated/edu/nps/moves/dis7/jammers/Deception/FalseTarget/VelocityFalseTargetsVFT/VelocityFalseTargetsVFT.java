package edu.nps.moves.dis7.jammers.Deception.FalseTarget.VelocityFalseTargetsVFT;

import edu.nps.moves.dis7.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v25, 2018-08-29
 *
 * Jamming technique uid: 284
 */
public class VelocityFalseTargetsVFT extends JammingTechnique
{
    public VelocityFalseTargetsVFT()
    {
        setKind((byte)2); // Deception
        setCategory((byte)65); // False Target
        setSubCategory((byte)30); // Velocity False Targets (VFT)
    }
}