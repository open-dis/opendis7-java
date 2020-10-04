package edu.nps.moves.dis7.entities.bhr.platform.surface;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SubCategoryElem@7921b0a2
 * Country: Bahrain (BHR)
 * Entity kind: Platform
 * Domain: SURFACE
 *
 * Entity type uid: 18678
 */
public class ALJarimFPB20Classfastattackcraftgun extends EntityType
{
    public ALJarimFPB20Classfastattackcraftgun()
    {
        setCountry(Country.BAHRAIN_BHR);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.SURFACE));

        setCategory((byte)7); // uid 18666, Light/Patrol Craft
        setSubCategory((byte)4); // uid 18678, AL Jarim (FPB 20) Class (fast attack craft-gun)
    }
}
