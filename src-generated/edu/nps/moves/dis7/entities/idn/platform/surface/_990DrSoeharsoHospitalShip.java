package edu.nps.moves.dis7.entities.idn.platform.surface;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28 (2020-05-07)
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@6fe1b4fb;
 * Country: Indonesia (IDN);
 * Entity kind: Platform;
 * Domain: SURFACE;
 *
 * Entity type uid: 31676
 */
public class _990DrSoeharsoHospitalShip extends EntityType
{
    /** Default constructor */
    public _990DrSoeharsoHospitalShip()
    {
        setCountry(Country.INDONESIA_IDN);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.SURFACE));

        setCategory((byte)16); // uid 31674, Auxiliary
        setSubCategory((byte)1); // uid 31675, Tanjung Dalpele Class
        setSpecific((byte)1); // uid 31676, 990 Dr Soeharso (Hospital Ship)
    }
}
