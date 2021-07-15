package edu.nps.moves.dis7.entities.oth.lifeform.land;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28 (2020-05-07)
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$ExtraElem@1a0d313;
 * Country: Other;
 * Entity kind: Life form;
 * Domain: LAND;
 *
 * Entity type uid: 32749
 */
public class HispanicCivilianwLaserDesignator extends EntityType
{
    /** Default constructor */
    public HispanicCivilianwLaserDesignator()
    {
        setCountry(Country.OTHER);
        setEntityKind(EntityKind.LIFE_FORM);
        setDomain(Domain.inst(PlatformDomain.LAND));

        setCategory((byte)130); // uid 32731, Civilian
        setSubCategory((byte)153); // uid 32743, Lasers
        setSpecific((byte)1); // uid 32744, Civilian w/ Laser Designator
        setExtra((byte)5); // uid 32749, Hispanic Civilian w/ Laser Designator
    }
}
