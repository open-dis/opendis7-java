package edu.nps.moves.dis7.entities.tur.platform.surface;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@7afc4db9
 * Country: Turkey (TUR)
 * Entity kind: Platform
 * Domain: SURFACE
 *
 * Entity type uid: 27482
 */
public class A577SokulluMehmetPasa extends EntityType
{
    public A577SokulluMehmetPasa()
    {
        setCountry(Country.TURKEY_TUR);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.SURFACE));

        setCategory((byte)16); // uid 27478, Auxiliary
        setSubCategory((byte)2); // uid 27481, Mosel Class (Type 402 Fast Minesweeper Tender)
        setSpecific((byte)1); // uid 27482, A-577 Sokullu Mehmet Pasa
    }
}
