package edu.nps.moves.dis7.objectTypes.PointObject;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 *
 * ObjectType uid: 226
 */
public class PointObject extends ObjectType
{
    public PointObject()
    {
        setDomain(PlatformDomain.getEnumForValue(1));
    }
}
