package edu.nps.moves.dis7.entities.aus.platform.land;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28 (2020-05-07)
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@4d591d15;
 * Country: Australia (AUS);
 * Entity kind: Platform;
 * Domain: LAND;
 *
 * Entity type uid: 29751
 */
public class MANHX81PrimeMoverHMDollyLowLoaderTrailerSemiMediumEqptTransporterPlant extends EntityType
{
    /** Default constructor */
    public MANHX81PrimeMoverHMDollyLowLoaderTrailerSemiMediumEqptTransporterPlant()
    {
        setCountry(Country.AUSTRALIA_AUS);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.LAND));

        setCategory((byte)7); // uid 29715, Large Wheeled Utility Vehicle
        setSubCategory((byte)4); // uid 29747, MAN HX81 - Prime Mover
        setSpecific((byte)4); // uid 29751, MAN HX81 Prime Mover, HM Dolly Low Loader, Trailer, Semi, Medium Eqpt Transporter, Plant
    }
}
