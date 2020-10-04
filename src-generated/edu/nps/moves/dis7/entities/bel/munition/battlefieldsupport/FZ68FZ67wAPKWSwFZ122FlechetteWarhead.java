package edu.nps.moves.dis7.entities.bel.munition.battlefieldsupport;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@7971c2a9
 * Country: Belgium (BEL)
 * Entity kind: Munition
 * Domain: BATTLEFIELD_SUPPORT
 *
 * Entity type uid: 30323
 */
public class FZ68FZ67wAPKWSwFZ122FlechetteWarhead extends EntityType
{
    public FZ68FZ67wAPKWSwFZ122FlechetteWarhead()
    {
        setCountry(Country.BELGIUM_BEL);
        setEntityKind(EntityKind.MUNITION);
        setDomain(Domain.inst(MunitionDomain.BATTLEFIELD_SUPPORT));

        setCategory((byte)1); // uid 30309, Guided
        setSubCategory((byte)2); // uid 30317, FZ FZ68/FZ67 FFAR (70 mm, 2.75 in) w/APKWS
        setSpecific((byte)6); // uid 30323, FZ68/FZ67 w/APKWS w/ FZ122 Flechette Warhead
    }
}
