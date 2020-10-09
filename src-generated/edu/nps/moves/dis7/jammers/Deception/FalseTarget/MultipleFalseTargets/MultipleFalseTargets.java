package edu.nps.moves.dis7.jammers.Deception.FalseTarget.MultipleFalseTargets;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 *
 * Jamming technique uid: 284
 */
public class MultipleFalseTargets extends JammingTechnique
{
    public MultipleFalseTargets()
    {
        setKind((byte)2); // Deception
        setCategory((byte)65); // False Target
        setSubCategory((byte)15); // Multiple False Targets
    }
}
