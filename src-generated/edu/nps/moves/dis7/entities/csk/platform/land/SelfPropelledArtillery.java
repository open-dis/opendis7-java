package edu.nps.moves.dis7.entities.csk.platform.land;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28 (2020-05-07)
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$CategoryElem@59662a0b;
 * Country: Czechoslovakia (CSK);
 * Entity kind: Platform;
 * Domain: LAND;
 *
 * Entity type uid: 22829
 */
public class SelfPropelledArtillery extends EntityType
{
    /** Default constructor */
    public SelfPropelledArtillery()
    {
        setCountry(Country.ACTION_REQUEST_RELIABLE);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.LAND));

        setCategory((byte)4); // uid 22829, Self-Propelled Artillery
    }
}
