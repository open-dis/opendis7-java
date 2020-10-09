package edu.nps.moves.dis7.entities.rus.munition.antipersonnel;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@7e94e331
 * Country: Russia (RUS)
 * Entity kind: Munition
 * Domain: ANTI_PERSONNEL
 *
 * Entity type uid: 20643
 */
public class _762x38RNagantRevolveraka762mmSovietrevolverand762mmNagantgasseal extends EntityType
{
    public _762x38RNagantRevolveraka762mmSovietrevolverand762mmNagantgasseal()
    {
        setCountry(Country.RUSSIA_RUS);
        setEntityKind(EntityKind.MUNITION);
        setDomain(Domain.inst(MunitionDomain.ANTI_PERSONNEL));

        setCategory((byte)2); // uid 20637, Ballistic
        setSubCategory((byte)2); // uid 20641, 7.62 mm
        setSpecific((byte)2); // uid 20643, 7.62 x 38R Nagant Revolver (aka 7.62-mm Soviet revolver and 7.62-mm Nagant gas-seal)
    }
}
