package edu.nps.moves.dis7.entities.oth.supply.class9repairpartsandcomponents;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28 (2020-05-07)
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@a047bdb;
 * Country: Other;
 * Entity kind: Supply;
 * Domain: CLASS_9_REPAIR_PARTS_AND_COMPONENTS;
 *
 * Entity type uid: 30802
 */
public class FerricChlorideAN1001LB extends EntityType
{
    /** Default constructor */
    public FerricChlorideAN1001LB()
    {
        setCountry(Country.OTHER);
        setEntityKind(EntityKind.SUPPLY);
        setDomain(Domain.inst(SupplyDomain.CLASS_9_REPAIR_PARTS_AND_COMPONENTS));

        setCategory((byte)1); // uid 30615, Other
        setSubCategory((byte)1); // uid 30800, Decontamination supplies
        setSpecific((byte)2); // uid 30802, Ferric Chloride AN 100 1 LB
    }
}
