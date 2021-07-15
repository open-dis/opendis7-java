package edu.nps.moves.dis7.objectTypes.PointObject.Preparedposition.VehicleDefilade;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28 (2020-05-07)
 *
 * ObjectType uid: 226
 */
public class MortarCarrier extends ObjectType
{
    /** Default constructor */
    public MortarCarrier()
    {
        setDomain(PlatformDomain.getEnumForValue(1));
        setObjectKind(ObjectKind.getEnumForValue(2)); // Prepared position
        setCategory((byte)1); // Vehicle Defilade
        setSubCategory((byte)3); // Mortar Carrier
    }
}
