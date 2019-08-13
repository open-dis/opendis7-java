package edu.nps.moves.dis7.jammers.Deception.Angle.Cross_Polarization;

import edu.nps.moves.dis7.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v25, 2018-08-29
 *
 * Jamming technique uid: 284
 */
public class Cross_Polarization extends JammingTechnique
{
    public Cross_Polarization()
    {
        setKind((byte)2); // Deception
        setCategory((byte)10); // Angle
        setSubCategory((byte)20); // Cross-Polarization
    }
}
