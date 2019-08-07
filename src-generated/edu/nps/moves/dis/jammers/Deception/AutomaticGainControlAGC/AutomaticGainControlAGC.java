package edu.nps.moves.dis.jammers.Deception.AutomaticGainControlAGC;

import edu.nps.moves.dis.*;
import edu.nps.moves.dis.enumerations.*;

/**
 * SISO-REF-010-v25, 2018-08-29
 *
 * Jamming technique uid: 284
 */
public class AutomaticGainControlAGC extends JammingTechnique
{
    public AutomaticGainControlAGC()
    {
        setKind((byte)2); // Deception
        setCategory((byte)35); // Automatic Gain Control (AGC)
    }
}
