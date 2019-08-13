package edu.nps.moves.dis7.jammers.Noise.SpotNoise.AutomaticSpotNoiseASJ;

import edu.nps.moves.dis7.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v25, 2018-08-29
 *
 * Jamming technique uid: 284
 */
public class AutomaticSpotNoiseASJ extends JammingTechnique
{
    public AutomaticSpotNoiseASJ()
    {
        setKind((byte)1); // Noise
        setCategory((byte)75); // Spot Noise
        setSubCategory((byte)5); // Automatic Spot Noise (ASJ)
    }
}
