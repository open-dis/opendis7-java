package edu.nps.moves.dis7.entities.can.expendable.air;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28 (2020-05-07)
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$CategoryElem@661db63e;
 * Country: Canada (CAN);
 * Entity kind: Expendable;
 * Domain: AIR;
 *
 * Entity type uid: 31913
 */
public class Chaff extends EntityType
{
    /** Default constructor */
    public Chaff()
    {
        setCountry(Country.CANADA_CAN);
        setEntityKind(EntityKind.EXPENDABLE);
        setDomain(Domain.inst(PlatformDomain.AIR));

        setCategory((byte)1); // uid 31913, Chaff
    }
}
