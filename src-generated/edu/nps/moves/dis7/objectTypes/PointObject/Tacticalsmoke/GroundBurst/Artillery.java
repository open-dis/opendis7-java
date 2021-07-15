package edu.nps.moves.dis7.objectTypes.PointObject.Tacticalsmoke.GroundBurst;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28 (2020-05-07)
 *
 * ObjectType uid: 226
 */
public class Artillery extends ObjectType
{
    /** Default constructor */
    public Artillery()
    {
        setDomain(PlatformDomain.getEnumForValue(0));
        setObjectKind(ObjectKind.getEnumForValue(5)); // Tactical smoke
        setCategory((byte)1); // Ground Burst
        setSubCategory((byte)1); // Artillery
    }
}
