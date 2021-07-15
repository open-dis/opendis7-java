package edu.nps.moves.dis7.entities.ind.platform.surface;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28 (2020-05-07)
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@40238dd0;
 * Country: India (IND);
 * Entity kind: Platform;
 * Domain: SURFACE;
 *
 * Entity type uid: 18846
 */
public class M83Mahe extends EntityType
{
    /** Default constructor */
    public M83Mahe()
    {
        setCountry(Country.INDIA_IND);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.SURFACE));

        setCategory((byte)8); // uid 18844, Mine Countermeasure Ship/Craft
        setSubCategory((byte)1); // uid 18845, Mahe (Yevgenya) Class (Type 1258)
        setSpecific((byte)1); // uid 18846, M83 Mahe
    }
}
