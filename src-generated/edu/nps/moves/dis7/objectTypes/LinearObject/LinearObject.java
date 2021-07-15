package edu.nps.moves.dis7.objectTypes.LinearObject;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28 (2020-05-07)
 *
 * ObjectType uid: 227
 */
public class LinearObject extends ObjectType
{
    /** Default constructor */
    public LinearObject()
    {
        setDomain(PlatformDomain.getEnumForValue(1));
    }
}
