package edu.nps.moves.dis7.entities.nor.munition.antiarmor;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28 (2020-05-07)
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@62cf6a84;
 * Country: Norway (NOR);
 * Entity kind: Munition;
 * Domain: ANTI_ARMOR;
 *
 * Entity type uid: 28838
 */
public class _30mmx173MPTSDNM222 extends EntityType
{
    /** Default constructor */
    public _30mmx173MPTSDNM222()
    {
        setCountry(Country.NORWAY_NOR);
        setEntityKind(EntityKind.MUNITION);
        setDomain(Domain.inst(MunitionDomain.ANTI_ARMOR));

        setCategory((byte)2); // uid 27325, Ballistic
        setSubCategory((byte)2); // uid 28836, 30mm x173
        setSpecific((byte)2); // uid 28838, 30mm x173 MP-T/SD NM222
    }
}
