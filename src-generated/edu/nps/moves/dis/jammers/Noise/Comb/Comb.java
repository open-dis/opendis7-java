package edu.nps.moves.dis.jammers.Noise.Comb;

import edu.nps.moves.dis.*;
import edu.nps.moves.dis.enumerations.*;

/**
 * SISO-REF-010-v25, 2018-08-29
 *
 * Jamming technique uid: 284
 */
public class Comb extends JammingTechnique
{
    public Comb()
    {
        setKind((byte)1); // Noise
        setCategory((byte)20); // Comb
    }
}
