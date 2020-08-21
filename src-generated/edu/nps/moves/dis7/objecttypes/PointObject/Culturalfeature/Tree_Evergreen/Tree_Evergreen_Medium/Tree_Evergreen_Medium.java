package edu.nps.moves.dis7.objecttypes.PointObject.Culturalfeature.Tree_Evergreen.Tree_Evergreen_Medium;

import edu.nps.moves.dis7.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 *
 * ObjectType uid: 226
 */
public class Tree_Evergreen_Medium extends ObjectType
{
    public Tree_Evergreen_Medium()
    {
        setDomain(PlatformDomain.getEnumForValue(1));
        setObjectKind(ObjectKind.getEnumForValue(3)); // Cultural feature
        setCategory((byte)11); // Tree, Evergreen
        setSubCategory((byte)2); // Tree, Evergreen, Medium
    }
}
