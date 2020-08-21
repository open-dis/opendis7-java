package edu.nps.moves.dis7.jammers.Deception.GateStealerandRepeater.RepeaterSweptAmplitudeModulationRSAMandVGPO;

import edu.nps.moves.dis7.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 *
 * Jamming technique uid: 284
 */
public class RepeaterSweptAmplitudeModulationRSAMandVGPO extends JammingTechnique
{
    public RepeaterSweptAmplitudeModulationRSAMandVGPO()
    {
        setKind((byte)2); // Deception
        setCategory((byte)80); // Gate Stealer and Repeater
        setSubCategory((byte)5); // Repeater Swept Amplitude Modulation (RSAM) and VGPO
    }
}
