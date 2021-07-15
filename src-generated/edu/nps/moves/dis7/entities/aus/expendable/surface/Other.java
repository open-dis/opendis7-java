package edu.nps.moves.dis7.entities.aus.expendable.surface;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28 (2020-05-07)
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$CategoryElem@1308ef19;
 * Country: Australia (AUS);
 * Entity kind: Expendable;
 * Domain: SURFACE;
 *
 * Entity type uid: 22312
 */
public class Other extends EntityType
{
    /** Default constructor */
    public Other()
    {
        setCountry(Country.AUSTRALIA_AUS);
        setEntityKind(EntityKind.EXPENDABLE);
        setDomain(Domain.inst(PlatformDomain.SURFACE));

        setCategory((byte)0); // uid 22312, Other
    }
}
