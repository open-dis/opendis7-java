package edu.nps.moves.dis7.jammers.Deception.FalseTarget.CoherentFalseTargets;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28 (2020-05-07)
 *
 * Jamming technique uid: 284
 */
public class CoherentFalseTargets extends JammingTechnique
{
    /** Default constructor */
    public CoherentFalseTargets()
    {
        setKind((byte)2); // Deception
        setCategory((byte)65); // False Target
        setSubCategory((byte)5); // Coherent False Targets
    }
}
