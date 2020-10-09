package edu.nps.moves.dis7.objectTypes.PointObject.Tacticalsmoke.TacticalSmokeCanister;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 *
 * ObjectType uid: 226
 */
public class M18Violet extends ObjectType
{
    public M18Violet()
    {
        setDomain(PlatformDomain.getEnumForValue(0));
        setObjectKind(ObjectKind.getEnumForValue(5)); // Tactical smoke
        setCategory((byte)3); // Tactical Smoke, Canister
        setSubCategory((byte)3); // M18, Violet
    }
}
