package edu.nps.moves.dis7.entities.hrv.platform.surface;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@799f10e1
 * Country: Croatia (HRV)
 * Entity kind: Platform
 * Domain: SURFACE
 *
 * Entity type uid: 19334
 */
public class RTOP21Sibenik extends EntityType
{
    public RTOP21Sibenik()
    {
        setCountry(Country.CROATIA_HRV);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.SURFACE));

        setCategory((byte)7); // uid 19332, Light/Patrol Craft
        setSubCategory((byte)1); // uid 19333, Koncar (Type R-02) Class (Fast Attack Craft-Missile) (PCFG)
        setSpecific((byte)1); // uid 19334, RTOP 21 Sibenik
    }
}
