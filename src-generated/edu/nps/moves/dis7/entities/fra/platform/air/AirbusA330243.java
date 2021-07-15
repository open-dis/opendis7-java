package edu.nps.moves.dis7.entities.fra.platform.air;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28 (2020-05-07)
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$ExtraElem@1b11171f;
 * Country: France (FRA);
 * Entity kind: Platform;
 * Domain: AIR;
 *
 * Entity type uid: 24257
 */
public class AirbusA330243 extends EntityType
{
    /** Default constructor */
    public AirbusA330243()
    {
        setCountry(Country.FRANCE_FRA);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.AIR));

        setCategory((byte)88); // uid 23844, Civilian Fixed Wing Aircraft, Heavy (above 255,000 lbs / 115,666 kg)
        setSubCategory((byte)32); // uid 23845, Twin Jet
        setSpecific((byte)3); // uid 23848, Airbus A330
        setExtra((byte)8); // uid 24257, Airbus A330-243
    }
}