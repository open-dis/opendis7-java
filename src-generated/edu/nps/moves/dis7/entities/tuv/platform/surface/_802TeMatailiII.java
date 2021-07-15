package edu.nps.moves.dis7.entities.tuv.platform.surface;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28 (2020-05-07)
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@3a66e67e;
 * Country: Tuvalu (TUV);
 * Entity kind: Platform;
 * Domain: SURFACE;
 *
 * Entity type uid: 32550
 */
public class _802TeMatailiII extends EntityType
{
    /** Default constructor */
    public _802TeMatailiII()
    {
        setCountry(Country.TUVALU_TUV);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.SURFACE));

        setCategory((byte)7); // uid 26723, Light/Patrol Craft
        setSubCategory((byte)2); // uid 32549, Guardian Class, Pacific Patrol Boats (PPB-R)
        setSpecific((byte)1); // uid 32550, 802 Te Mataili II
    }
}
