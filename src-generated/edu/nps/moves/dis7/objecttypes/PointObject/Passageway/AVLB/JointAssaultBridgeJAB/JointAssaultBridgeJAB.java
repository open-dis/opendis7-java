package edu.nps.moves.dis7.objecttypes.PointObject.Passageway.AVLB.JointAssaultBridgeJAB;

import edu.nps.moves.dis7.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v25, 2018-08-29
 *
 * ObjectType uid: 226
 */
public class JointAssaultBridgeJAB extends ObjectType
{
    public JointAssaultBridgeJAB()
    {
        setDomain(PlatformDomain.getEnumForValue(1));
        setObjectKind(ObjectKind.getEnumForValue(4)); // Passageway
        setCategory((byte)2); // AVLB
        setSubCategory((byte)3); // Joint Assault Bridge (JAB)
    }
}
