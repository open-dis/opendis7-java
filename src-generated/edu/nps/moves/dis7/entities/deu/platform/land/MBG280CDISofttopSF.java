package edu.nps.moves.dis7.entities.deu.platform.land;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@2ad48653
 * Country: Germany (DEU)
 * Entity kind: Platform
 * Domain: LAND
 *
 * Entity type uid: 27924
 */
public class MBG280CDISofttopSF extends EntityType
{
    public MBG280CDISofttopSF()
    {
        setCountry(Country.GERMANY_DEU);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.LAND));

        setCategory((byte)6); // uid 16277, Small Wheeled Utility Vehicle (0 - 1.25 tons)
        setSubCategory((byte)1); // uid 16278, Wolf (Mercedes Benz G-Class 4x4)
        setSpecific((byte)10); // uid 27924, MB G 280 CDI Softtop SF
    }
}
