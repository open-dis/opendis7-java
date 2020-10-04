package edu.nps.moves.dis7.jammers.Deception.AngleandRandomRangeProgramsRANRAP.RANRAPandSSW;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 *
 * Jamming technique uid: 284
 */
public class RANRAPandSSW extends JammingTechnique
{
    public RANRAPandSSW()
    {
        setKind((byte)2); // Deception
        setCategory((byte)25); // Angle and Random Range Programs (RANRAP)
        setSubCategory((byte)5); // RANRAP and SSW
    }
}
