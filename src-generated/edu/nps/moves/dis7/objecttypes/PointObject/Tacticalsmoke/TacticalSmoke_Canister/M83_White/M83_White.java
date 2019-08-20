package edu.nps.moves.dis7.objecttypes.PointObject.Tacticalsmoke.TacticalSmoke_Canister.M83_White;

import edu.nps.moves.dis7.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v25, 2018-08-29
 *
 * ObjectType uid: 226
 */
public class M83_White extends ObjectType
{
    public M83_White()
    {
        setDomain(PlatformDomain.getEnumForValue(0));
        setObjectKind(ObjectKind.getEnumForValue(5)); // Tactical smoke
        setCategory((byte)3); // Tactical Smoke, Canister
        setSubCategory((byte)1); // M83, White
    }
}
