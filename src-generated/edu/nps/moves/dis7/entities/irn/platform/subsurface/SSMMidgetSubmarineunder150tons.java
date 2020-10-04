package edu.nps.moves.dis7.entities.irn.platform.subsurface;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$CategoryElem@5e01a982
 * Country: Iran (Islamic Republic of) (IRN)
 * Entity kind: Platform
 * Domain: SUBSURFACE
 *
 * Entity type uid: 30889
 */
public class SSMMidgetSubmarineunder150tons extends EntityType
{
    public SSMMidgetSubmarineunder150tons()
    {
        setCountry(Country.IRAN_ISLAMIC_REPUBLIC_OF_IRN);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.SUBSURFACE));

        setCategory((byte)12); // uid 30889, SSM (Midget Submarine, under 150 tons)
    }
}
