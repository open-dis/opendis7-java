package edu.nps.moves.dis.jammers.Noise.PseudorandomAM;

import edu.nps.moves.dis.*;
import edu.nps.moves.dis.enumerations.*;

/**
 * SISO-REF-010-v25, 2018-08-29
 *
 * Jamming technique uid: 284
 */
public class PseudorandomAM extends JammingTechnique
{
    public PseudorandomAM()
    {
        setKind((byte)1); // Noise
        setCategory((byte)50); // Pseudorandom AM
    }
}
