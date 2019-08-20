package edu.nps.moves.dis7.objecttypes.PointObject.Culturalfeature.Tree_Deciduous.Tree_Deciduous_Medium;

import edu.nps.moves.dis7.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v25, 2018-08-29
 *
 * ObjectType uid: 226
 */
public class Tree_Deciduous_Medium extends ObjectType
{
    public Tree_Deciduous_Medium()
    {
        setDomain(PlatformDomain.getEnumForValue(1));
        setObjectKind(ObjectKind.getEnumForValue(3)); // Cultural feature
        setCategory((byte)10); // Tree, Deciduous
        setSubCategory((byte)2); // Tree, Deciduous, Medium
    }
}
