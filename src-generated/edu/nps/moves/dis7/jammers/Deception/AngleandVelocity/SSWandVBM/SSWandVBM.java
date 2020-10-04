package edu.nps.moves.dis7.jammers.Deception.AngleandVelocity.SSWandVBM;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 *
 * Jamming technique uid: 284
 */
public class SSWandVBM extends JammingTechnique
{
    public SSWandVBM()
    {
        setKind((byte)2); // Deception
        setCategory((byte)30); // Angle and Velocity
        setSubCategory((byte)10); // SSW and VBM
    }
}
