package edu.nps.moves.dis7.jammers.DeceptionandNoise.AngleandNoise.AngleandBarrage.BarrageandSSW;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28 (2020-05-07)
 *
 * Jamming technique uid: 284
 */
public class BarrageandSSW extends JammingTechnique
{
    /** Default constructor */
    public BarrageandSSW()
    {
        setKind((byte)3); // Deception and Noise
        setCategory((byte)5); // Angle and Noise
        setSubCategory((byte)5); // Angle and Barrage
        setSpecific((byte)10); // Barrage and SSW
    }
}
