package edu.nps.moves.dis7.jammers.Noise.RepeaterNoise.WideBandRepeaterNoise;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 *
 * Jamming technique uid: 284
 */
public class WideBandRepeaterNoise extends JammingTechnique
{
    public WideBandRepeaterNoise()
    {
        setKind((byte)1); // Noise
        setCategory((byte)70); // Repeater Noise
        setSubCategory((byte)10); // Wide Band Repeater Noise
    }
}
