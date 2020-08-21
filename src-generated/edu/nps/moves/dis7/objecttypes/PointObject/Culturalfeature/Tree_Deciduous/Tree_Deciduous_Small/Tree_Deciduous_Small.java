package edu.nps.moves.dis7.objecttypes.PointObject.Culturalfeature.Tree_Deciduous.Tree_Deciduous_Small;

import edu.nps.moves.dis7.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 *
 * ObjectType uid: 226
 */
public class Tree_Deciduous_Small extends ObjectType
{
    public Tree_Deciduous_Small()
    {
        setDomain(PlatformDomain.getEnumForValue(1));
        setObjectKind(ObjectKind.getEnumForValue(3)); // Cultural feature
        setCategory((byte)10); // Tree, Deciduous
        setSubCategory((byte)1); // Tree, Deciduous, Small
    }
}
