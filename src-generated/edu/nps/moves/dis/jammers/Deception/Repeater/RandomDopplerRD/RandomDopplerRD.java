package edu.nps.moves.dis.jammers.Deception.Repeater.RandomDopplerRD;

import edu.nps.moves.dis.*;
import edu.nps.moves.dis.enumerations.*;

/**
 * SISO-REF-010-v25, 2018-08-29
 *
 * Jamming technique uid: 284
 */
public class RandomDopplerRD extends JammingTechnique
{
    public RandomDopplerRD()
    {
        setKind((byte)2); // Deception
        setCategory((byte)130); // Repeater
        setSubCategory((byte)25); // Random Doppler (RD)
    }
}
