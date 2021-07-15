package edu.nps.moves.dis7.entities.idn.platform.surface;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28 (2020-05-07)
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@46268f08;
 * Country: Indonesia (IDN);
 * Entity kind: Platform;
 * Domain: SURFACE;
 *
 * Entity type uid: 31455
 */
public class _519TelukKupang extends EntityType
{
    /** Default constructor */
    public _519TelukKupang()
    {
        setCountry(Country.INDONESIA_IDN);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.SURFACE));

        setCategory((byte)10); // uid 31090, Tank Landing Ship
        setSubCategory((byte)4); // uid 31453, Teluk Bintuni Class
        setSpecific((byte)2); // uid 31455, 519 Teluk Kupang
    }
}