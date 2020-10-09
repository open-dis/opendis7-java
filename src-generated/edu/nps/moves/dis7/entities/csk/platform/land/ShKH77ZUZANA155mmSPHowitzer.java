package edu.nps.moves.dis7.entities.csk.platform.land;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@41d477ed
 * Country: Czechoslovakia (CSK)
 * Entity kind: Platform
 * Domain: LAND
 *
 * Entity type uid: 22832
 */
public class ShKH77ZUZANA155mmSPHowitzer extends EntityType
{
    public ShKH77ZUZANA155mmSPHowitzer()
    {
        setCountry(Country.CZECHOSLOVAKIA_CSK);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.LAND));

        setCategory((byte)4); // uid 22829, Self-Propelled Artillery
        setSubCategory((byte)1); // uid 22830, Tatra T815 8x8 SP Howitzer
        setSpecific((byte)2); // uid 22832, ShKH-77 ZUZANA 155 mm SP Howitzer
    }
}
