package edu.nps.moves.dis7.entities.rus.platform.surface;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@7ae9a33a
 * Country: Russia (RUS)
 * Entity kind: Platform
 * Domain: SURFACE
 *
 * Entity type uid: 13816
 */
public class MagometGadzhievexMikhailTukhachevsky extends EntityType
{
    public MagometGadzhievexMikhailTukhachevsky()
    {
        setCountry(Country.RUSSIA_RUS);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.SURFACE));

        setCategory((byte)16); // uid 13805, Auxiliary
        setSubCategory((byte)2); // uid 13813, Don class (submarine depot ships)
        setSpecific((byte)3); // uid 13816, Magomet Gadzhiev (ex-Mikhail Tukhachevsky)
    }
}
