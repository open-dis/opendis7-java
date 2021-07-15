package edu.nps.moves.dis7.jammers.Deception.AutomaticGainControlAGC;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28 (2020-05-07)
 *
 * Jamming technique uid: 284
 */
public class AutomaticGainControlAGC extends JammingTechnique
{
    /** Default constructor */
    public AutomaticGainControlAGC()
    {
        setKind((byte)2); // Deception
        setCategory((byte)35); // Automatic Gain Control (AGC)
    }
}
