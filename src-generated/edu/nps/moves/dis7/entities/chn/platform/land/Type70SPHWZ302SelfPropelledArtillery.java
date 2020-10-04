package edu.nps.moves.dis7.entities.chn.platform.land;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@481a15ff
 * Country: China, Peoples Republic of (CHN)
 * Entity kind: Platform
 * Domain: LAND
 *
 * Entity type uid: 31233
 */
public class Type70SPHWZ302SelfPropelledArtillery extends EntityType
{
    public Type70SPHWZ302SelfPropelledArtillery()
    {
        setCountry(Country.CHINA_PEOPLES_REPUBLIC_OF_CHN);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.LAND));

        setCategory((byte)2); // uid 16876, Armored Fighting Vehicle
        setSubCategory((byte)1); // uid 16877, Type 63 (YW 531) Armored Personnel Carrier (APC)
        setSpecific((byte)3); // uid 31233, Type 70 SPH (WZ302) Self-Propelled Artillery
    }
}
