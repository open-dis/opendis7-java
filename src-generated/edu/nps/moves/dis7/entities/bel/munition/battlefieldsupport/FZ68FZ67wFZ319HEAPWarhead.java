package edu.nps.moves.dis7.entities.bel.munition.battlefieldsupport;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@4fb64e14
 * Country: Belgium (BEL)
 * Entity kind: Munition
 * Domain: BATTLEFIELD_SUPPORT
 *
 * Entity type uid: 30343
 */
public class FZ68FZ67wFZ319HEAPWarhead extends EntityType
{
    public FZ68FZ67wFZ319HEAPWarhead()
    {
        setCountry(Country.BELGIUM_BEL);
        setEntityKind(EntityKind.MUNITION);
        setDomain(Domain.inst(MunitionDomain.BATTLEFIELD_SUPPORT));

        setCategory((byte)2); // uid 30331, Ballistic
        setSubCategory((byte)2); // uid 30339, FZ FZ68/FZ67 FFAR (70 mm, 2.75 in)
        setSpecific((byte)4); // uid 30343, FZ68/FZ67 w/ FZ319 HEAP Warhead
    }
}
