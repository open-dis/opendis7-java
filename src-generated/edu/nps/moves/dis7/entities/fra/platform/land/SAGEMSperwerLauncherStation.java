package edu.nps.moves.dis7.entities.fra.platform.land;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@c333c60
 * Country: France (FRA)
 * Entity kind: Platform
 * Domain: LAND
 *
 * Entity type uid: 27999
 */
public class SAGEMSperwerLauncherStation extends EntityType
{
    public SAGEMSperwerLauncherStation()
    {
        setCountry(Country.FRANCE_FRA);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.LAND));

        setCategory((byte)29); // uid 27996, Command, Control, Communications, and Intelligence (C3I) System
        setSubCategory((byte)1); // uid 27997, SAGEM Sperwer UAV System
        setSpecific((byte)2); // uid 27999, SAGEM Sperwer Launcher Station
    }
}
