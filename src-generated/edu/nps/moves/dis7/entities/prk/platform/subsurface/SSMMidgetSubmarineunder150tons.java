package edu.nps.moves.dis7.entities.prk.platform.subsurface;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$CategoryElem@64bc21ac
 * Country: Korea (Democratic Peoples Republic of) (PRK)
 * Entity kind: Platform
 * Domain: SUBSURFACE
 *
 * Entity type uid: 30884
 */
public class SSMMidgetSubmarineunder150tons extends EntityType
{
    public SSMMidgetSubmarineunder150tons()
    {
        setCountry(Country.KOREA_DEMOCRATIC_PEOPLES_REPUBLIC_OF_PRK);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.SUBSURFACE));

        setCategory((byte)12); // uid 30884, SSM (Midget Submarine, under 150 tons)
    }
}
