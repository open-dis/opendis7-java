package edu.nps.moves.dis7.entities.gbr.munition.antiship;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SubCategoryElem@6df791a4
 * Country: United Kingdom of Great Britain and Northern Ireland (GBR)
 * Entity kind: Munition
 * Domain: ANTI_SHIP
 *
 * Entity type uid: 20998
 */
public class VosperThornyCroftExcaliburCoastDefenseMissileSystem extends EntityType
{
    public VosperThornyCroftExcaliburCoastDefenseMissileSystem()
    {
        setCountry(Country.UNITED_KINGDOM_OF_GREAT_BRITAIN_AND_NORTHERN_IRELAND_GBR);
        setEntityKind(EntityKind.MUNITION);
        setDomain(Domain.inst(MunitionDomain.ANTI_SHIP));

        setCategory((byte)1); // uid 20997, Guided
        setSubCategory((byte)1); // uid 20998, Vosper Thorny Croft Excalibur Coast Defense Missile System
    }
}
