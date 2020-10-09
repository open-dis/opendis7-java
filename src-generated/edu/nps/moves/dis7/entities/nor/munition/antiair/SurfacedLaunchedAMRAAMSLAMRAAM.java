package edu.nps.moves.dis7.entities.nor.munition.antiair;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SubCategoryElem@433ef204
 * Country: Norway (NOR)
 * Entity kind: Munition
 * Domain: ANTI_AIR
 *
 * Entity type uid: 27985
 */
public class SurfacedLaunchedAMRAAMSLAMRAAM extends EntityType
{
    public SurfacedLaunchedAMRAAMSLAMRAAM()
    {
        setCountry(Country.NORWAY_NOR);
        setEntityKind(EntityKind.MUNITION);
        setDomain(Domain.inst(MunitionDomain.ANTI_AIR));

        setCategory((byte)1); // uid 27984, Guided
        setSubCategory((byte)1); // uid 27985, Surfaced Launched AMRAAM (SL-AMRAAM)
    }
}
