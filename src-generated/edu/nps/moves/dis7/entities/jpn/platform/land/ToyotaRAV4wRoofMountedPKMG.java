package edu.nps.moves.dis7.entities.jpn.platform.land;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28 (2020-05-07)
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$ExtraElem@56f6d40b;
 * Country: Japan (JPN);
 * Entity kind: Platform;
 * Domain: LAND;
 *
 * Entity type uid: 24872
 */
public class ToyotaRAV4wRoofMountedPKMG extends EntityType
{
    /** Default constructor */
    public ToyotaRAV4wRoofMountedPKMG()
    {
        setCountry(Country.JAPAN_JPN);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.LAND));

        setCategory((byte)81); // uid 24863, Car
        setSubCategory((byte)112); // uid 24870, Sports Utility Vehicle (SUV), Economy/Compact (Small)
        setSpecific((byte)1); // uid 24871, Toyota RAV-4
        setExtra((byte)1); // uid 24872, Toyota RAV-4 w/ Roof-Mounted PK MG
    }
}
