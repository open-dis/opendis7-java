package edu.nps.moves.dis7.entities.omn.platform.surface;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28 (2020-05-07)
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@50b8ae8d;
 * Country: Oman (OMN);
 * Entity kind: Platform;
 * Domain: SURFACE;
 *
 * Entity type uid: 17974
 */
public class L2NasarALBahr extends EntityType
{
    /** Default constructor */
    public L2NasarALBahr()
    {
        setCountry(Country.OMAN_OMN);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.SURFACE));

        setCategory((byte)55); // uid 17972, Amphibious Cargo Ship
        setSubCategory((byte)1); // uid 17973, Landing Ship-Logistic
        setSpecific((byte)1); // uid 17974, L2 Nasar AL Bahr
    }
}
