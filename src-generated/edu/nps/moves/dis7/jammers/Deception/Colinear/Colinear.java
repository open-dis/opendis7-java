package edu.nps.moves.dis7.jammers.Deception.Colinear;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28 (2020-05-07)
 *
 * Jamming technique uid: 284
 */
public class Colinear extends JammingTechnique
{
    /** Default constructor */
    public Colinear()
    {
        setKind((byte)2); // Deception
        setCategory((byte)45); // Colinear
    }
}
