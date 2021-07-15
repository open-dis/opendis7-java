package edu.nps.moves.dis7.entities.deu.platform.surface;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28 (2020-05-07)
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@30c93896;
 * Country: Germany (DEU);
 * Entity kind: Platform;
 * Domain: SURFACE;
 *
 * Entity type uid: 30390
 */
public class GRE22FriedaLuise extends EntityType
{
    /** Default constructor */
    public GRE22FriedaLuise()
    {
        setCountry(Country.GERMANY_DEU);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.SURFACE));

        setCategory((byte)86); // uid 27584, Fishing Vessel
        setSubCategory((byte)2); // uid 30387, Medium Fishing Vessel (up to 65ft/19.8m)
        setSpecific((byte)3); // uid 30390, GRE 22 Frieda Luise
    }
}
