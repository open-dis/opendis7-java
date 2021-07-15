package edu.nps.moves.dis7.entities.deu.munition.antisubmarine;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28 (2020-05-07)
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SubCategoryElem@1c6a0103;
 * Country: Germany (DEU);
 * Entity kind: Munition;
 * Domain: ANTI_SUBMARINE;
 *
 * Entity type uid: 21245
 */
public class AEGSeeschlange533mmTorpedo extends EntityType
{
    /** Default constructor */
    public AEGSeeschlange533mmTorpedo()
    {
        setCountry(Country.GERMANY_DEU);
        setEntityKind(EntityKind.MUNITION);
        setDomain(Domain.inst(MunitionDomain.ANTI_SUBMARINE));

        setCategory((byte)1); // uid 21244, Guided
        setSubCategory((byte)1); // uid 21245, AEG Seeschlange 533 mm Torpedo
    }
}
