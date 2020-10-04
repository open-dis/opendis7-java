package edu.nps.moves.dis7.entities.ita.munition.antiguidedweapon;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@56cfe6be
 * Country: Italy (ITA)
 * Entity kind: Munition
 * Domain: ANTI_GUIDED_WEAPON
 *
 * Entity type uid: 21668
 */
public class BREDASCLAR105mm extends EntityType
{
    public BREDASCLAR105mm()
    {
        setCountry(Country.ITALY_ITA);
        setEntityKind(EntityKind.MUNITION);
        setDomain(Domain.inst(MunitionDomain.ANTI_GUIDED_WEAPON));

        setCategory((byte)1); // uid 21666, Guided
        setSubCategory((byte)1); // uid 21667, Decoy
        setSpecific((byte)1); // uid 21668, BREDA SCLAR 105 mm
    }
}
