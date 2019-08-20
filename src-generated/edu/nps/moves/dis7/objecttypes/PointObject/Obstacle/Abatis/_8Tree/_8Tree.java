package edu.nps.moves.dis7.objecttypes.PointObject.Obstacle.Abatis._8Tree;

import edu.nps.moves.dis7.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v25, 2018-08-29
 *
 * ObjectType uid: 226
 */
public class _8Tree extends ObjectType
{
    public _8Tree()
    {
        setDomain(PlatformDomain.getEnumForValue(1));
        setObjectKind(ObjectKind.getEnumForValue(1)); // Obstacle
        setCategory((byte)1); // Abatis
        setSubCategory((byte)1); // 8 Tree
    }
}
