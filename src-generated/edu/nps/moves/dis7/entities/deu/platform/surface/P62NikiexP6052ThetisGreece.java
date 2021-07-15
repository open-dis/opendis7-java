package edu.nps.moves.dis7.entities.deu.platform.surface;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28 (2020-05-07)
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@1984b1f;
 * Country: Germany (DEU);
 * Entity kind: Platform;
 * Domain: SURFACE;
 *
 * Entity type uid: 16753
 */
public class P62NikiexP6052ThetisGreece extends EntityType
{
    /** Default constructor */
    public P62NikiexP6052ThetisGreece()
    {
        setCountry(Country.GERMANY_DEU);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.SURFACE));

        setCategory((byte)50); // uid 16751, Frigate
        setSubCategory((byte)1); // uid 16752, Thetis Class (Type 420)
        setSpecific((byte)1); // uid 16753, P62 Niki (ex P 6052 Thetis) (Greece)
    }
}
