package edu.nps.moves.dis7.entities.ser.munition.antiarmor;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@7b1a30e5
 * Country: Serbia and Montenegro
 * Entity kind: Munition
 * Domain: ANTI_ARMOR
 *
 * Entity type uid: 26965
 */
public class _82mmHEATTM79 extends EntityType
{
    public _82mmHEATTM79()
    {
        setCountry(Country.SERBIA_AND_MONTENEGRO);
        setEntityKind(EntityKind.MUNITION);
        setDomain(Domain.inst(MunitionDomain.ANTI_ARMOR));

        setCategory((byte)2); // uid 26963, Ballistic
        setSubCategory((byte)1); // uid 26964, 82mm Recoilless Ammunition
        setSpecific((byte)1); // uid 26965, 82mm HEAT-T M79
    }
}
