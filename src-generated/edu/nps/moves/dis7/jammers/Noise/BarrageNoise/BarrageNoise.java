package edu.nps.moves.dis7.jammers.Noise.BarrageNoise;

import edu.nps.moves.dis7.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 *
 * Jamming technique uid: 284
 */
public class BarrageNoise extends JammingTechnique
{
    public BarrageNoise()
    {
        setKind((byte)1); // Noise
        setCategory((byte)10); // Barrage Noise
    }
}
