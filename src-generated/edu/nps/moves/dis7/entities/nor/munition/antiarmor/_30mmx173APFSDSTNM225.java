package edu.nps.moves.dis7.entities.nor.munition.antiarmor;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28 (2020-05-07)
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@7cf8f45a;
 * Country: Norway (NOR);
 * Entity kind: Munition;
 * Domain: ANTI_ARMOR;
 *
 * Entity type uid: 28837
 */
public class _30mmx173APFSDSTNM225 extends EntityType
{
    /** Default constructor */
    public _30mmx173APFSDSTNM225()
    {
        setCountry(Country.NORWAY_NOR);
        setEntityKind(EntityKind.MUNITION);
        setDomain(Domain.inst(MunitionDomain.ANTI_ARMOR));

        setCategory((byte)2); // uid 27325, Ballistic
        setSubCategory((byte)2); // uid 28836, 30mm x173
        setSpecific((byte)1); // uid 28837, 30mm x173 APFSDS-T NM225
    }
}
