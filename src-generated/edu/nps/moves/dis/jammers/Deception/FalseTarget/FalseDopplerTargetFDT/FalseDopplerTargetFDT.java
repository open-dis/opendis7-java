package edu.nps.moves.dis.jammers.Deception.FalseTarget.FalseDopplerTargetFDT;

import edu.nps.moves.dis.*;
import edu.nps.moves.dis.enumerations.*;

/**
 * SISO-REF-010-v25, 2018-08-29
 *
 * Jamming technique uid: 284
 */
public class FalseDopplerTargetFDT extends JammingTechnique
{
    public FalseDopplerTargetFDT()
    {
        setKind((byte)2); // Deception
        setCategory((byte)65); // False Target
        setSubCategory((byte)10); // False Doppler Target (FDT)
    }
}
