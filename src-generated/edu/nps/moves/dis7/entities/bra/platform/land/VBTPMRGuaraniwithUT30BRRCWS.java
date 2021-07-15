package edu.nps.moves.dis7.entities.bra.platform.land;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28 (2020-05-07)
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@2344fc66;
 * Country: Brazil (BRA);
 * Entity kind: Platform;
 * Domain: LAND;
 *
 * Entity type uid: 32020
 */
public class VBTPMRGuaraniwithUT30BRRCWS extends EntityType
{
    /** Default constructor */
    public VBTPMRGuaraniwithUT30BRRCWS()
    {
        setCountry(Country.BRAZIL_BRA);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.LAND));

        setCategory((byte)2); // uid 25690, Armored Fighting Vehicle
        setSubCategory((byte)5); // uid 32017, VBTP-MR Guarani
        setSpecific((byte)3); // uid 32020, VBTP-MR Guarani with UT30BR RCWS
    }
}
