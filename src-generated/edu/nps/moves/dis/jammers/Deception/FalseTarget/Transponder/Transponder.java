package edu.nps.moves.dis.jammers.Deception.FalseTarget.Transponder;

import edu.nps.moves.dis.*;
import edu.nps.moves.dis.enumerations.*;

/**
 * SISO-REF-010-v25, 2018-08-29
 *
 * Jamming technique uid: 284
 */
public class Transponder extends JammingTechnique
{
    public Transponder()
    {
        setKind((byte)2); // Deception
        setCategory((byte)65); // False Target
        setSubCategory((byte)25); // Transponder
    }
}
