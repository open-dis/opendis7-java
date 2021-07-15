package edu.nps.moves.dis7.entities.deu.platform.land;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28 (2020-05-07)
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@20b2475a;
 * Country: Germany (DEU);
 * Entity kind: Platform;
 * Domain: LAND;
 *
 * Entity type uid: 22732
 */
public class Wiesel2lePzMrs120mmmortar extends EntityType
{
    /** Default constructor */
    public Wiesel2lePzMrs120mmmortar()
    {
        setCountry(Country.GERMANY_DEU);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.LAND));

        setCategory((byte)2); // uid 16250, Armored Fighting Vehicle
        setSubCategory((byte)11); // uid 22730, Wiesel 2 armoured weapons carrier
        setSpecific((byte)2); // uid 22732, Wiesel 2 lePzMrs 120 mm (mortar)
    }
}
