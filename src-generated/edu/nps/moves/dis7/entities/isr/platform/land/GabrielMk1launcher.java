package edu.nps.moves.dis7.entities.isr.platform.land;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SubCategoryElem@14dda234
 * Country: Israel (ISR)
 * Entity kind: Platform
 * Domain: LAND
 *
 * Entity type uid: 18175
 */
public class GabrielMk1launcher extends EntityType
{
    public GabrielMk1launcher()
    {
        setCountry(Country.ISRAEL_ISR);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.LAND));

        setCategory((byte)4); // uid 18174, Self-Propelled Artillery
        setSubCategory((byte)1); // uid 18175, Gabriel Mk 1 launcher
    }
}
