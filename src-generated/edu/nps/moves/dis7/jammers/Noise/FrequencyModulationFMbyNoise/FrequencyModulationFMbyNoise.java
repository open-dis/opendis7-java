package edu.nps.moves.dis7.jammers.Noise.FrequencyModulationFMbyNoise;

import edu.nps.moves.dis7.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v25, 2018-08-29
 *
 * Jamming technique uid: 284
 */
public class FrequencyModulationFMbyNoise extends JammingTechnique
{
    public FrequencyModulationFMbyNoise()
    {
        setKind((byte)1); // Noise
        setCategory((byte)35); // Frequency Modulation (FM) by Noise
    }
}
