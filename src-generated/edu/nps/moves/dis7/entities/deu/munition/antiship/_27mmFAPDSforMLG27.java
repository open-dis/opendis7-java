package edu.nps.moves.dis7.entities.deu.munition.antiship;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28 (2020-05-07)
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@284990de;
 * Country: Germany (DEU);
 * Entity kind: Munition;
 * Domain: ANTI_SHIP;
 *
 * Entity type uid: 25736
 */
public class _27mmFAPDSforMLG27 extends EntityType
{
    /** Default constructor */
    public _27mmFAPDSforMLG27()
    {
        setCountry(Country.GERMANY_DEU);
        setEntityKind(EntityKind.MUNITION);
        setDomain(Domain.inst(MunitionDomain.ANTI_SHIP));

        setCategory((byte)2); // uid 25734, Ballistic
        setSubCategory((byte)1); // uid 25735, 27 mm
        setSpecific((byte)1); // uid 25736, 27 mm FAPDS for MLG 27
    }
}
