package edu.nps.moves.dis7.entities.arg.platform.surface;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@71dac704
 * Country: Argentina (ARG)
 * Entity kind: Platform
 * Domain: SURFACE
 *
 * Entity type uid: 31272
 */
public class P86Indomita extends EntityType
{
    public P86Indomita()
    {
        setCountry(Country.ARGENTINA_ARG);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.SURFACE));

        setCategory((byte)64); // uid 31269, Fast Attack Craft
        setSubCategory((byte)1); // uid 31270, Intrepida Class (TNC 45)
        setSpecific((byte)2); // uid 31272, P 86 Indomita
    }
}
