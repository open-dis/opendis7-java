package edu.nps.moves.dis7.entities.deu.munition.antiarmor;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@54f6b629
 * Country: Germany (DEU)
 * Entity kind: Munition
 * Domain: ANTI_ARMOR
 *
 * Entity type uid: 28828
 */
public class CartridgeTank120mmAPFSDSTDM63A1 extends EntityType
{
    public CartridgeTank120mmAPFSDSTDM63A1()
    {
        setCountry(Country.GERMANY_DEU);
        setEntityKind(EntityKind.MUNITION);
        setDomain(Domain.inst(MunitionDomain.ANTI_ARMOR));

        setCategory((byte)2); // uid 21215, Ballistic
        setSubCategory((byte)11); // uid 25033, 120mm Tank Ammo
        setSpecific((byte)3); // uid 28828, Cartridge, Tank, 120mm, APFSDS-T, DM-63A1
    }
}
