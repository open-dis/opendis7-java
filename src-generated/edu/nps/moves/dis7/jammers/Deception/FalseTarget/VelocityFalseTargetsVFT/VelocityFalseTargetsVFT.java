package edu.nps.moves.dis7.jammers.Deception.FalseTarget.VelocityFalseTargetsVFT;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28 (2020-05-07)
 *
 * Jamming technique uid: 284
 */
public class VelocityFalseTargetsVFT extends JammingTechnique
{
    /** Default constructor */
    public VelocityFalseTargetsVFT()
    {
        setKind((byte)2); // Deception
        setCategory((byte)65); // False Target
        setSubCategory((byte)30); // Velocity False Targets (VFT)
    }
}
