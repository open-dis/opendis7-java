package edu.nps.moves.dis.jammers.Noise.AmplitudeModulationAMNoise;

import edu.nps.moves.dis.*;
import edu.nps.moves.dis.enumerations.*;

/**
 * SISO-REF-010-v25, 2018-08-29
 *
 * Jamming technique uid: 284
 */
public class AmplitudeModulationAMNoise extends JammingTechnique
{
    public AmplitudeModulationAMNoise()
    {
        setKind((byte)1); // Noise
        setCategory((byte)5); // Amplitude Modulation (AM) Noise
    }
}
