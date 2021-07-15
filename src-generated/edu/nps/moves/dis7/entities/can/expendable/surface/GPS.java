package edu.nps.moves.dis7.entities.can.expendable.surface;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28 (2020-05-07)
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SubCategoryElem@4fbe486c;
 * Country: Canada (CAN);
 * Entity kind: Expendable;
 * Domain: SURFACE;
 *
 * Entity type uid: 32659
 */
public class GPS extends EntityType
{
    /** Default constructor */
    public GPS()
    {
        setCountry(Country.CANADA_CAN);
        setEntityKind(EntityKind.EXPENDABLE);
        setDomain(Domain.inst(PlatformDomain.SURFACE));

        setCategory((byte)14); // uid 32658, SAR Buoy
        setSubCategory((byte)1); // uid 32659, GPS
    }
}
