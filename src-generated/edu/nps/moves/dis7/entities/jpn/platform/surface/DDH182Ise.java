package edu.nps.moves.dis7.entities.jpn.platform.surface;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28 (2020-05-07)
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@6722db6e;
 * Country: Japan (JPN);
 * Entity kind: Platform;
 * Domain: SURFACE;
 *
 * Entity type uid: 28701
 */
public class DDH182Ise extends EntityType
{
    /** Default constructor */
    public DDH182Ise()
    {
        setCountry(Country.JAPAN_JPN);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.SURFACE));

        setCategory((byte)13); // uid 28698, Cruiser/Helicopter Carrier
        setSubCategory((byte)1); // uid 28699, Hyuga Class Helicopter Destroyer
        setSpecific((byte)2); // uid 28701, DDH-182 Ise
    }
}
