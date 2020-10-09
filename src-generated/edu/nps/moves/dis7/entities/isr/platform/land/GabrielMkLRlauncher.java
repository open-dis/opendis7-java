package edu.nps.moves.dis7.entities.isr.platform.land;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SubCategoryElem@5a411614
 * Country: Israel (ISR)
 * Entity kind: Platform
 * Domain: LAND
 *
 * Entity type uid: 18178
 */
public class GabrielMkLRlauncher extends EntityType
{
    public GabrielMkLRlauncher()
    {
        setCountry(Country.ISRAEL_ISR);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.LAND));

        setCategory((byte)4); // uid 18174, Self-Propelled Artillery
        setSubCategory((byte)4); // uid 18178, Gabriel Mk LR launcher
    }
}
