package edu.nps.moves.dis7.entities.ita.platform.surface;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@183e8023
 * Country: Italy (ITA)
 * Entity kind: Platform
 * Domain: SURFACE
 *
 * Entity type uid: 28667
 */
public class F595LuigiRizzo extends EntityType
{
    public F595LuigiRizzo()
    {
        setCountry(Country.ITALY_ITA);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.SURFACE));

        setCategory((byte)6); // uid 28660, Guided Missile Frigate (FFG)
        setSubCategory((byte)1); // uid 28661, Bergamini Class
        setSpecific((byte)6); // uid 28667, F595 Luigi Rizzo
    }
}
