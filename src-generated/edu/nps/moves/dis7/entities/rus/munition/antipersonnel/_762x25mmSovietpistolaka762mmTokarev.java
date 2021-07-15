package edu.nps.moves.dis7.entities.rus.munition.antipersonnel;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28 (2020-05-07)
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@6b16de91;
 * Country: Russia (RUS);
 * Entity kind: Munition;
 * Domain: ANTI_PERSONNEL;
 *
 * Entity type uid: 20642
 */
public class _762x25mmSovietpistolaka762mmTokarev extends EntityType
{
    /** Default constructor */
    public _762x25mmSovietpistolaka762mmTokarev()
    {
        setCountry(Country.RUSSIA_RUS);
        setEntityKind(EntityKind.MUNITION);
        setDomain(Domain.inst(MunitionDomain.ANTI_PERSONNEL));

        setCategory((byte)2); // uid 20637, Ballistic
        setSubCategory((byte)2); // uid 20641, 7.62 mm
        setSpecific((byte)1); // uid 20642, 7.62 x 25-mm Soviet pistol (aka 7.62-mm Tokarev)
    }
}
