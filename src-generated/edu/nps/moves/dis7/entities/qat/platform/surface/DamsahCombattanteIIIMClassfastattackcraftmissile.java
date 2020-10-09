package edu.nps.moves.dis7.entities.qat.platform.surface;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SubCategoryElem@faa3fed
 * Country: Qatar (QAT)
 * Entity kind: Platform
 * Domain: SURFACE
 *
 * Entity type uid: 17829
 */
public class DamsahCombattanteIIIMClassfastattackcraftmissile extends EntityType
{
    public DamsahCombattanteIIIMClassfastattackcraftmissile()
    {
        setCountry(Country.QATAR_QAT);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.SURFACE));

        setCategory((byte)7); // uid 17828, Light/Patrol Craft
        setSubCategory((byte)1); // uid 17829, Damsah (Combattante III M) Class (fast attack craft-missile)
    }
}
