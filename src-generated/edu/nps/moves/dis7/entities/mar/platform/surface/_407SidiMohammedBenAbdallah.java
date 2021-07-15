package edu.nps.moves.dis7.entities.mar.platform.surface;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28 (2020-05-07)
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@5b800468;
 * Country: Morocco (MAR);
 * Entity kind: Platform;
 * Domain: SURFACE;
 *
 * Entity type uid: 27720
 */
public class _407SidiMohammedBenAbdallah extends EntityType
{
    /** Default constructor */
    public _407SidiMohammedBenAbdallah()
    {
        setCountry(Country.MOROCCO_MAR);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.SURFACE));

        setCategory((byte)10); // uid 27718, Tank Landing Ship
        setSubCategory((byte)1); // uid 27719, Newport Class
        setSpecific((byte)1); // uid 27720, 407 Sidi Mohammed Ben Abdallah
    }
}
