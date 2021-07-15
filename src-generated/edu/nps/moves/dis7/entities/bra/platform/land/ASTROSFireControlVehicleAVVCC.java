package edu.nps.moves.dis7.entities.bra.platform.land;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28 (2020-05-07)
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SubCategoryElem@36d4b5c;
 * Country: Brazil (BRA);
 * Entity kind: Platform;
 * Domain: LAND;
 *
 * Entity type uid: 24392
 */
public class ASTROSFireControlVehicleAVVCC extends EntityType
{
    /** Default constructor */
    public ASTROSFireControlVehicleAVVCC()
    {
        setCountry(Country.BRAZIL_BRA);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.LAND));

        setCategory((byte)37); // uid 24391, Fire Control Facility
        setSubCategory((byte)1); // uid 24392, ASTROS Fire Control Vehicle AV-VCC
    }
}
