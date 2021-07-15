package edu.nps.moves.dis7.entities.oth.supply.class9repairpartsandcomponents;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28 (2020-05-07)
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@2c08c787;
 * Country: Other;
 * Entity kind: Supply;
 * Domain: CLASS_9_REPAIR_PARTS_AND_COMPONENTS;
 *
 * Entity type uid: 30619
 */
public class ExtinguisherAgentFoam extends EntityType
{
    /** Default constructor */
    public ExtinguisherAgentFoam()
    {
        setCountry(Country.OTHER);
        setEntityKind(EntityKind.SUPPLY);
        setDomain(Domain.inst(SupplyDomain.CLASS_9_REPAIR_PARTS_AND_COMPONENTS));

        setCategory((byte)1); // uid 30615, Other
        setSubCategory((byte)2); // uid 30616, Extinguisher Agent
        setSpecific((byte)3); // uid 30619, Extinguisher Agent - Foam
    }
}
