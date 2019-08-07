package edu.nps.moves.dis.jammers.Noise.BistaticClutter;

import edu.nps.moves.dis.*;
import edu.nps.moves.dis.enumerations.*;

/**
 * SISO-REF-010-v25, 2018-08-29
 *
 * Jamming technique uid: 284
 */
public class BistaticClutter extends JammingTechnique
{
    public BistaticClutter()
    {
        setKind((byte)1); // Noise
        setCategory((byte)15); // Bistatic Clutter
    }
}
