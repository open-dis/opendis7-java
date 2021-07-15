package edu.nps.moves.dis7.entities.rus.munition.battlefieldsupport;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28 (2020-05-07)
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@2e45a357;
 * Country: Russia (RUS);
 * Entity kind: Munition;
 * Domain: BATTLEFIELD_SUPPORT;
 *
 * Entity type uid: 27443
 */
public class _120mmMortarCartridgeIncendiaryRAPPyogel extends EntityType
{
    /** Default constructor */
    public _120mmMortarCartridgeIncendiaryRAPPyogel()
    {
        setCountry(Country.RUSSIA_RUS);
        setEntityKind(EntityKind.MUNITION);
        setDomain(Domain.inst(MunitionDomain.BATTLEFIELD_SUPPORT));

        setCategory((byte)2); // uid 20785, Ballistic
        setSubCategory((byte)13); // uid 20809, 120 mm (mortar)
        setSpecific((byte)14); // uid 27443, 120mm Mortar Cartridge, Incendiary RAP, Pyogel
    }
}
