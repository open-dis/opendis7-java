package edu.nps.moves.dis7.jammers.Noise.Comb;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28 (2020-05-07)
 *
 * Jamming technique uid: 284
 */
public class Comb extends JammingTechnique
{
    /** Default constructor */
    public Comb()
    {
        setKind((byte)1); // Noise
        setCategory((byte)20); // Comb
    }
}
