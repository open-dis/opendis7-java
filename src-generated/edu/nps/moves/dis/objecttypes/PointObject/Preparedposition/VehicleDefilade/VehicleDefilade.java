package edu.nps.moves.dis.objecttypes.PointObject.Preparedposition.VehicleDefilade;

import edu.nps.moves.dis.*;
import edu.nps.moves.dis.enumerations.*;

/**
 * SISO-REF-010-v25, 2018-08-29
 *
 * ObjectType uid: 226
 */
public class VehicleDefilade extends ObjectType
{
    public VehicleDefilade()
    {
        setDomain(PlatformDomain.getEnumForValue(1));
        setObjectKind(ObjectKind.getEnumForValue(2)); // Prepared position
        setCategory((byte)1); // Vehicle Defilade
    }
}
