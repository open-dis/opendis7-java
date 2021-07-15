package edu.nps.moves.dis7.entities.can.expendable.surface;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28 (2020-05-07)
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$CategoryElem@dbc7e0a;
 * Country: Canada (CAN);
 * Entity kind: Expendable;
 * Domain: SURFACE;
 *
 * Entity type uid: 32658
 */
public class SARBuoy extends EntityType
{
    /** Default constructor */
    public SARBuoy()
    {
        setCountry(Country.CANADA_CAN);
        setEntityKind(EntityKind.EXPENDABLE);
        setDomain(Domain.inst(PlatformDomain.SURFACE));

        setCategory((byte)14); // uid 32658, SAR Buoy
    }
}
