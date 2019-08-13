package edu.nps.moves.dis7.jammers.Noise.BarrageNoise.SourceNoise;

import edu.nps.moves.dis7.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v25, 2018-08-29
 *
 * Jamming technique uid: 284
 */
public class SourceNoise extends JammingTechnique
{
    public SourceNoise()
    {
        setKind((byte)1); // Noise
        setCategory((byte)10); // Barrage Noise
        setSubCategory((byte)10); // Source Noise
    }
}
