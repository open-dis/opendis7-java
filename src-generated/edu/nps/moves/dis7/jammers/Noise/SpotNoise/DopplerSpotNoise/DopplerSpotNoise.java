package edu.nps.moves.dis7.jammers.Noise.SpotNoise.DopplerSpotNoise;

import edu.nps.moves.dis7.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 *
 * Jamming technique uid: 284
 */
public class DopplerSpotNoise extends JammingTechnique
{
    public DopplerSpotNoise()
    {
        setKind((byte)1); // Noise
        setCategory((byte)75); // Spot Noise
        setSubCategory((byte)20); // Doppler Spot Noise
    }
}
