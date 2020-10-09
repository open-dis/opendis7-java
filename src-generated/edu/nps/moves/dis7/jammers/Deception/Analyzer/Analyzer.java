package edu.nps.moves.dis7.jammers.Deception.Analyzer;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 *
 * Jamming technique uid: 284
 */
public class Analyzer extends JammingTechnique
{
    public Analyzer()
    {
        setKind((byte)2); // Deception
        setCategory((byte)5); // Analyzer
    }
}
