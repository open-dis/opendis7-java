package edu.nps.moves.dis7.entities.chl.platform.surface;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@69b0fd6f
 * Country: Chile (CHL)
 * Entity kind: Platform
 * Domain: SURFACE
 *
 * Entity type uid: 28308
 */
public class FFG14AlmiranteLatorre extends EntityType
{
    public FFG14AlmiranteLatorre()
    {
        setCountry(Country.CHILE_CHL);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.SURFACE));

        setCategory((byte)6); // uid 27464, Guided Missile Frigate (FFG)
        setSubCategory((byte)2); // uid 28307, Type L Class (Jacob van Heemskerck Class)
        setSpecific((byte)1); // uid 28308, FFG-14 Almirante Latorre
    }
}
