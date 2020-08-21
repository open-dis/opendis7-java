package edu.nps.moves.dis7.objecttypes.LinearObject.Obstaclebreach;

import edu.nps.moves.dis7.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 *
 * ObjectType uid: 227
 */
public class Obstaclebreach extends ObjectType
{
    public Obstaclebreach()
    {
        setDomain(PlatformDomain.getEnumForValue(1));
        setObjectKind(ObjectKind.getEnumForValue(7)); // Obstacle breach
    }
}
