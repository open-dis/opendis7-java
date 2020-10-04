package edu.nps.moves.dis7.entities.ita.platform.surface;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@7d3430a7
 * Country: Italy (ITA)
 * Entity kind: Platform
 * Domain: SURFACE
 *
 * Entity type uid: 18637
 */
public class L9892SanGiorgio extends EntityType
{
    public L9892SanGiorgio()
    {
        setCountry(Country.ITALY_ITA);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.SURFACE));

        setCategory((byte)56); // uid 18635, Amphibious Transport Dock
        setSubCategory((byte)1); // uid 18636, San Giorgio Class (LPDs)
        setSpecific((byte)1); // uid 18637, L9892 San Giorgio
    }
}
