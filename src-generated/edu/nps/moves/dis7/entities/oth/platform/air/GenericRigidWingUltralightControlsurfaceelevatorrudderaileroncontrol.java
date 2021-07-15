package edu.nps.moves.dis7.entities.oth.platform.air;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28 (2020-05-07)
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SubCategoryElem@15b986cd;
 * Country: Other;
 * Entity kind: Platform;
 * Domain: AIR;
 *
 * Entity type uid: 24687
 */
public class GenericRigidWingUltralightControlsurfaceelevatorrudderaileroncontrol extends EntityType
{
    /** Default constructor */
    public GenericRigidWingUltralightControlsurfaceelevatorrudderaileroncontrol()
    {
        setCountry(Country.OTHER);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.AIR));

        setCategory((byte)81); // uid 24685, Civilian Ultralight Aircraft, Rigid Wing
        setSubCategory((byte)2); // uid 24687, Generic Rigid Wing Ultralight, Control surface (elevator, rudder, aileron) control
    }
}
