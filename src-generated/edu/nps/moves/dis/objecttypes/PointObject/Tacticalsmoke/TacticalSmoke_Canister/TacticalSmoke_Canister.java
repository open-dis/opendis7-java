package edu.nps.moves.dis.objecttypes.PointObject.Tacticalsmoke.TacticalSmoke_Canister;

import edu.nps.moves.dis.*;
import edu.nps.moves.dis.enumerations.*;

/**
 * SISO-REF-010-v25, 2018-08-29
 *
 * ObjectType uid: 226
 */
public class TacticalSmoke_Canister extends ObjectType
{
    public TacticalSmoke_Canister()
    {
        setDomain(PlatformDomain.getEnumForValue(0));
        setObjectKind(ObjectKind.getEnumForValue(5)); // Tactical smoke
        setCategory((byte)3); // Tactical Smoke, Canister
    }
}
