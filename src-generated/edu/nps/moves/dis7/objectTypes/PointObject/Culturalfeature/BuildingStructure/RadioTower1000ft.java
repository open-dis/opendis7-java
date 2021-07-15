package edu.nps.moves.dis7.objectTypes.PointObject.Culturalfeature.BuildingStructure;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28 (2020-05-07)
 *
 * ObjectType uid: 226
 */
public class RadioTower1000ft extends ObjectType
{
    /** Default constructor */
    public RadioTower1000ft()
    {
        setDomain(PlatformDomain.getEnumForValue(1));
        setObjectKind(ObjectKind.getEnumForValue(3)); // Cultural feature
        setCategory((byte)1); // Building / Structure
        setSubCategory((byte)14); // Radio Tower, 1000ft
    }
}