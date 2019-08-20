package edu.nps.moves.dis7.objecttypes.PointObject.Culturalfeature.Tent.Tent_ExpandableFrame;

import edu.nps.moves.dis7.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v25, 2018-08-29
 *
 * ObjectType uid: 226
 */
public class Tent_ExpandableFrame extends ObjectType
{
    public Tent_ExpandableFrame()
    {
        setDomain(PlatformDomain.getEnumForValue(1));
        setObjectKind(ObjectKind.getEnumForValue(3)); // Cultural feature
        setCategory((byte)5); // Tent
        setSubCategory((byte)7); // Tent, Expandable Frame
    }
}
