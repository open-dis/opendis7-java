package edu.nps.moves.dis7.jammers.Deception.Repeater.RandomDopplerRD;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
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
