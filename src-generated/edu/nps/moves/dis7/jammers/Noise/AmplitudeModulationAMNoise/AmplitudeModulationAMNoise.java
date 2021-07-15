package edu.nps.moves.dis7.jammers.Noise.AmplitudeModulationAMNoise;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28 (2020-05-07)
 *
 * Jamming technique uid: 284
 */
public class AmplitudeModulationAMNoise extends JammingTechnique
{
    /** Default constructor */
    public AmplitudeModulationAMNoise()
    {
        setKind((byte)1); // Noise
        setCategory((byte)5); // Amplitude Modulation (AM) Noise
    }
}
