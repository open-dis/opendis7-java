package edu.nps.moves.dis7.objecttypes.PointObject.Culturalfeature.Tree_Evergreen.Tree_Evergreen_Small;

import edu.nps.moves.dis7.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v25, 2018-08-29
 *
 * ObjectType uid: 226
 */
public class Tree_Evergreen_Small extends ObjectType
{
    public Tree_Evergreen_Small()
    {
        setDomain(PlatformDomain.getEnumForValue(1));
        setObjectKind(ObjectKind.getEnumForValue(3)); // Cultural feature
        setCategory((byte)11); // Tree, Evergreen
        setSubCategory((byte)1); // Tree, Evergreen, Small
    }
}
