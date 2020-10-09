package edu.nps.moves.dis7.entities.qat.platform.surface;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@433e536f
 * Country: Qatar (QAT)
 * Entity kind: Platform
 * Domain: SURFACE
 *
 * Entity type uid: 17831
 */
public class Q02ALGhariyah extends EntityType
{
    public Q02ALGhariyah()
    {
        setCountry(Country.QATAR_QAT);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.SURFACE));

        setCategory((byte)7); // uid 17828, Light/Patrol Craft
        setSubCategory((byte)1); // uid 17829, Damsah (Combattante III M) Class (fast attack craft-missile)
        setSpecific((byte)2); // uid 17831, Q02 AL Ghariyah
    }
}
