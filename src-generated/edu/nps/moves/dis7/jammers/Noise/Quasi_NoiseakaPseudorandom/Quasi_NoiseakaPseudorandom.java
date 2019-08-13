package edu.nps.moves.dis7.jammers.Noise.Quasi_NoiseakaPseudorandom;

import edu.nps.moves.dis7.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v25, 2018-08-29
 *
 * Jamming technique uid: 284
 */
public class Quasi_NoiseakaPseudorandom extends JammingTechnique
{
    public Quasi_NoiseakaPseudorandom()
    {
        setKind((byte)1); // Noise
        setCategory((byte)60); // Quasi-Noise (aka Pseudorandom)
    }
}
