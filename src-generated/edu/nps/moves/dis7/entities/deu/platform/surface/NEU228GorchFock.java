package edu.nps.moves.dis7.entities.deu.platform.surface;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28 (2020-05-07)
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@2421cc4;
 * Country: Germany (DEU);
 * Entity kind: Platform;
 * Domain: SURFACE;
 *
 * Entity type uid: 30389
 */
public class NEU228GorchFock extends EntityType
{
    /** Default constructor */
    public NEU228GorchFock()
    {
        setCountry(Country.GERMANY_DEU);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.SURFACE));

        setCategory((byte)86); // uid 27584, Fishing Vessel
        setSubCategory((byte)2); // uid 30387, Medium Fishing Vessel (up to 65ft/19.8m)
        setSpecific((byte)2); // uid 30389, NEU 228 Gorch Fock
    }
}
