package edu.nps.moves.dis.jammers.Deception.Angle.InverseGainakaInverseAmplitude;

import edu.nps.moves.dis.*;
import edu.nps.moves.dis.enumerations.*;

/**
 * SISO-REF-010-v25, 2018-08-29
 *
 * Jamming technique uid: 284
 */
public class InverseGainakaInverseAmplitude extends JammingTechnique
{
    public InverseGainakaInverseAmplitude()
    {
        setKind((byte)2); // Deception
        setCategory((byte)10); // Angle
        setSubCategory((byte)30); // Inverse Gain (aka Inverse Amplitude)
    }
}
