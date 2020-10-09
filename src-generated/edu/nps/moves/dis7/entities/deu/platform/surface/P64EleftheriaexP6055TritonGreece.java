package edu.nps.moves.dis7.entities.deu.platform.surface;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@7efaad5a
 * Country: Germany (DEU)
 * Entity kind: Platform
 * Domain: SURFACE
 *
 * Entity type uid: 16755
 */
public class P64EleftheriaexP6055TritonGreece extends EntityType
{
    public P64EleftheriaexP6055TritonGreece()
    {
        setCountry(Country.GERMANY_DEU);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.SURFACE));

        setCategory((byte)50); // uid 16751, Frigate
        setSubCategory((byte)1); // uid 16752, Thetis Class (Type 420)
        setSpecific((byte)3); // uid 16755, P64 Eleftheria (ex P 6055 Triton) (Greece)
    }
}
