package edu.nps.moves.dis7.entities.aus.expendable.air;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$CategoryElem@5f2b9da8
 * Country: Australia (AUS)
 * Entity kind: Expendable
 * Domain: AIR
 *
 * Entity type uid: 28598
 */
public class Activeemitter extends EntityType
{
    public Activeemitter()
    {
        setCountry(Country.AUSTRALIA_AUS);
        setEntityKind(EntityKind.EXPENDABLE);
        setDomain(Domain.inst(PlatformDomain.AIR));

        setCategory((byte)4); // uid 28598, Active emitter
    }
}
