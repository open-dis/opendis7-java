package edu.nps.moves.dis7.entities.bra.platform.land;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28 (2020-05-07)
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@548b7f67;
 * Country: Brazil (BRA);
 * Entity kind: Platform;
 * Domain: LAND;
 *
 * Entity type uid: 32042
 */
public class VTNEAM23075ton extends EntityType
{
    /** Default constructor */
    public VTNEAM23075ton()
    {
        setCountry(Country.BRAZIL_BRA);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.LAND));

        setCategory((byte)6); // uid 32039, Small Wheeled Utility Vehicle
        setSubCategory((byte)1); // uid 32040, Agrale Marrua
        setSpecific((byte)2); // uid 32042, VTNE - AM-23, 0.75 ton
    }
}
