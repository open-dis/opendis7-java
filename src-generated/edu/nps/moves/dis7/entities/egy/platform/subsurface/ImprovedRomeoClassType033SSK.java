package edu.nps.moves.dis7.entities.egy.platform.subsurface;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SubCategoryElem@687e99d8
 * Country: Egypt (EGY)
 * Entity kind: Platform
 * Domain: SUBSURFACE
 *
 * Entity type uid: 18815
 */
public class ImprovedRomeoClassType033SSK extends EntityType
{
    public ImprovedRomeoClassType033SSK()
    {
        setCountry(Country.EGYPT_EGY);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.SUBSURFACE));

        setCategory((byte)5); // uid 18814, SS (Conventional Attack-Torpedo Patrol)
        setSubCategory((byte)1); // uid 18815, Improved Romeo Class (Type 033) (SSK)
    }
}
