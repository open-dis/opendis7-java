package edu.nps.moves.dis7.entities.oth.supply.class3petroleumoilslubricants;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@30228de7
 * Country: Other
 * Entity kind: Supply
 * Domain: CLASS_3_PETROLEUM_OILS_LUBRICANTS
 *
 * Entity type uid: 30686
 */
public class MultiSpectralFogOil extends EntityType
{
    public MultiSpectralFogOil()
    {
        setCountry(Country.OTHER);
        setEntityKind(EntityKind.SUPPLY);
        setDomain(Domain.inst(SupplyDomain.CLASS_3_PETROLEUM_OILS_LUBRICANTS));

        setCategory((byte)4); // uid 30683, P - Packaged POL
        setSubCategory((byte)2); // uid 30685, Fog oil
        setSpecific((byte)1); // uid 30686, Multi-Spectral Fog Oil
    }
}
