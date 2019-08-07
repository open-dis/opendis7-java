package edu.nps.moves.dis.jammers.Deception.JitteredPulseWidth;

import edu.nps.moves.dis.*;
import edu.nps.moves.dis.enumerations.*;

/**
 * SISO-REF-010-v25, 2018-08-29
 *
 * Jamming technique uid: 284
 */
public class JitteredPulseWidth extends JammingTechnique
{
    public JitteredPulseWidth()
    {
        setKind((byte)2); // Deception
        setCategory((byte)100); // Jittered Pulse Width
    }
}
