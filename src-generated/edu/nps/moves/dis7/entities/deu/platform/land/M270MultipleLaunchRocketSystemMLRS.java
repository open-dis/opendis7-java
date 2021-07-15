package edu.nps.moves.dis7.entities.deu.platform.land;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28 (2020-05-07)
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SubCategoryElem@14bdbc74;
 * Country: Germany (DEU);
 * Entity kind: Platform;
 * Domain: LAND;
 *
 * Entity type uid: 22762
 */
public class M270MultipleLaunchRocketSystemMLRS extends EntityType
{
    /** Default constructor */
    public M270MultipleLaunchRocketSystemMLRS()
    {
        setCountry(Country.GERMANY_DEU);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.LAND));

        setCategory((byte)4); // uid 16273, Self-Propelled Artillery
        setSubCategory((byte)3); // uid 22762, M270 Multiple Launch Rocket System (MLRS)
    }
}
