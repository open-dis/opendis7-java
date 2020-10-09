package edu.nps.moves.dis7.jammers.Deception.FalseTarget.RangeFalseTargetsRFT;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 *
 * Jamming technique uid: 284
 */
public class RangeFalseTargetsRFT extends JammingTechnique
{
    public RangeFalseTargetsRFT()
    {
        setKind((byte)2); // Deception
        setCategory((byte)65); // False Target
        setSubCategory((byte)20); // Range False Targets (RFT)
    }
}
