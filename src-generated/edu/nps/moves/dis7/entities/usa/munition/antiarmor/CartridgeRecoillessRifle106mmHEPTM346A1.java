package edu.nps.moves.dis7.entities.usa.munition.antiarmor;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@e4ca109
 * Country: United States of America (USA)
 * Entity kind: Munition
 * Domain: ANTI_ARMOR
 *
 * Entity type uid: 23965
 */
public class CartridgeRecoillessRifle106mmHEPTM346A1 extends EntityType
{
    public CartridgeRecoillessRifle106mmHEPTM346A1()
    {
        setCountry(Country.UNITED_STATES_OF_AMERICA_USA);
        setEntityKind(EntityKind.MUNITION);
        setDomain(Domain.inst(MunitionDomain.ANTI_ARMOR));

        setCategory((byte)2); // uid 19553, Ballistic
        setSubCategory((byte)11); // uid 19617, 106 mm RCL40 (M40)
        setSpecific((byte)3); // uid 23965, Cartridge, Recoilless Rifle, 106mm, HEP-T, M346A1
    }
}
