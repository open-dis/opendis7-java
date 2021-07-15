package edu.nps.moves.dis7.jammers.Deception.Angle.CrossEye;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28 (2020-05-07)
 *
 * Jamming technique uid: 284
 */
public class CrossEye extends JammingTechnique
{
    /** Default constructor */
    public CrossEye()
    {
        setKind((byte)2); // Deception
        setCategory((byte)10); // Angle
        setSubCategory((byte)15); // Cross-Eye
    }
}
