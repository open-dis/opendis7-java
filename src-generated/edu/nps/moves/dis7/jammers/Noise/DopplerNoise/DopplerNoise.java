package edu.nps.moves.dis7.jammers.Noise.DopplerNoise;

import edu.nps.moves.dis7.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 *
 * Jamming technique uid: 284
 */
public class DopplerNoise extends JammingTechnique
{
    public DopplerNoise()
    {
        setKind((byte)1); // Noise
        setCategory((byte)30); // Doppler Noise
    }
}
