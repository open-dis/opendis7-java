package edu.nps.moves.dis7.jammers.Deception.Angle.CooperativeAngleCAJ;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28 (2020-05-07)
 *
 * Jamming technique uid: 284
 */
public class CooperativeAngleCAJ extends JammingTechnique
{
    /** Default constructor */
    public CooperativeAngleCAJ()
    {
        setKind((byte)2); // Deception
        setCategory((byte)10); // Angle
        setSubCategory((byte)10); // Cooperative Angle (CAJ)
    }
}
