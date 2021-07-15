package edu.nps.moves.dis7.entities.deu.platform.land;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28 (2020-05-07)
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@446a1e84;
 * Country: Germany (DEU);
 * Entity kind: Platform;
 * Domain: LAND;
 *
 * Entity type uid: 22738
 */
public class FennekFuERKDFZGPICombatEngineer extends EntityType
{
    /** Default constructor */
    public FennekFuERKDFZGPICombatEngineer()
    {
        setCountry(Country.GERMANY_DEU);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.LAND));

        setCategory((byte)2); // uid 16250, Armored Fighting Vehicle
        setSubCategory((byte)13); // uid 22735, Fennek light armoured reconnaissance vehicle
        setSpecific((byte)3); // uid 22738, Fennek Fu-/ERKDFZG PI (Combat Engineer)
    }
}
