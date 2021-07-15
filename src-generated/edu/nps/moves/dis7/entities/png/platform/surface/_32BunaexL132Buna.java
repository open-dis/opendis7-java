package edu.nps.moves.dis7.entities.png.platform.surface;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28 (2020-05-07)
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@3c4bc9fc;
 * Country: Papua New Guinea (PNG);
 * Entity kind: Platform;
 * Domain: SURFACE;
 *
 * Entity type uid: 31147
 */
public class _32BunaexL132Buna extends EntityType
{
    /** Default constructor */
    public _32BunaexL132Buna()
    {
        setCountry(Country.PAPUA_NEW_GUINEA_PNG);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.SURFACE));

        setCategory((byte)11); // uid 31144, Landing Craft
        setSubCategory((byte)1); // uid 31145, Balikpapan Class
        setSpecific((byte)2); // uid 31147, 32 Buna (ex L 132 Buna)
    }
}
