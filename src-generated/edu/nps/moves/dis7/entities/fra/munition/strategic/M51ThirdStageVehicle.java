package edu.nps.moves.dis7.entities.fra.munition.strategic;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@477523ba
 * Country: France (FRA)
 * Entity kind: Munition
 * Domain: STRATEGIC
 *
 * Entity type uid: 32468
 */
public class M51ThirdStageVehicle extends EntityType
{
    public M51ThirdStageVehicle()
    {
        setCountry(Country.FRANCE_FRA);
        setEntityKind(EntityKind.MUNITION);
        setDomain(Domain.inst(MunitionDomain.STRATEGIC));

        setCategory((byte)1); // uid 21195, Guided
        setSubCategory((byte)6); // uid 29002, M51 SLBM
        setSpecific((byte)2); // uid 32468, M51 Third Stage Vehicle
    }
}
