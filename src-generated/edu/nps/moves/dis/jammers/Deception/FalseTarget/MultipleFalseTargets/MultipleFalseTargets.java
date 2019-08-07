package edu.nps.moves.dis.jammers.Deception.FalseTarget.MultipleFalseTargets;

import edu.nps.moves.dis.*;
import edu.nps.moves.dis.enumerations.*;

/**
 * SISO-REF-010-v25, 2018-08-29
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
