package edu.nps.moves.dis7.jammers.Noise.BarrageNoise.Click;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28 (2020-05-07)
 *
 * Jamming technique uid: 284
 */
public class Click extends JammingTechnique
{
    /** Default constructor */
    public Click()
    {
        setKind((byte)1); // Noise
        setCategory((byte)10); // Barrage Noise
        setSubCategory((byte)5); // Click
    }
}
