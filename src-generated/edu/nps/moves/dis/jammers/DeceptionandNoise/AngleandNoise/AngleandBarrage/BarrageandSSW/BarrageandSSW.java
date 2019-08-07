package edu.nps.moves.dis.jammers.DeceptionandNoise.AngleandNoise.AngleandBarrage.BarrageandSSW;

import edu.nps.moves.dis.*;
import edu.nps.moves.dis.enumerations.*;

/**
 * SISO-REF-010-v25, 2018-08-29
 *
 * Jamming technique uid: 284
 */
public class BarrageandSSW extends JammingTechnique
{
    public BarrageandSSW()
    {
        setKind((byte)3); // Deception and Noise
        setCategory((byte)5); // Angle and Noise
        setSubCategory((byte)5); // Angle and Barrage
        setSpecific((byte)10); // Barrage and SSW
    }
}
