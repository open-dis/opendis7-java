package edu.nps.moves.dis7.objecttypes.LinearObject.Obstacle.ChainLinkFence;

import edu.nps.moves.dis7.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v25, 2018-08-29
 *
 * ObjectType uid: 227
 */
public class ChainLinkFence extends ObjectType
{
    public ChainLinkFence()
    {
        setDomain(PlatformDomain.getEnumForValue(1));
        setObjectKind(ObjectKind.getEnumForValue(1)); // Obstacle
        setCategory((byte)9); // Chain Link Fence
    }
}
