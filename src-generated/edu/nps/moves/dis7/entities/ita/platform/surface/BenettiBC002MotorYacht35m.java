package edu.nps.moves.dis7.entities.ita.platform.surface;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28 (2020-05-07)
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@5ed731d0;
 * Country: Italy (ITA);
 * Entity kind: Platform;
 * Domain: SURFACE;
 *
 * Entity type uid: 26944
 */
public class BenettiBC002MotorYacht35m extends EntityType
{
    /** Default constructor */
    public BenettiBC002MotorYacht35m()
    {
        setCountry(Country.ITALY_ITA);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.SURFACE));

        setCategory((byte)84); // uid 26942, Private Motorboat
        setSubCategory((byte)4); // uid 26943, Very Large Motorboat (greater than 65ft/19.8m)
        setSpecific((byte)1); // uid 26944, Benetti BC 002 Motor Yacht (35m)
    }
}
