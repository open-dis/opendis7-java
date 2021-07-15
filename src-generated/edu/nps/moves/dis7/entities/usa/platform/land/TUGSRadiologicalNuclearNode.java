package edu.nps.moves.dis7.entities.usa.platform.land;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28 (2020-05-07)
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@233db8e9;
 * Country: United States of America (USA);
 * Entity kind: Platform;
 * Domain: LAND;
 *
 * Entity type uid: 22885
 */
public class TUGSRadiologicalNuclearNode extends EntityType
{
    /** Default constructor */
    public TUGSRadiologicalNuclearNode()
    {
        setCountry(Country.UNITED_STATES_OF_AMERICA_USA);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.LAND));

        setCategory((byte)23); // uid 10653, Warning System
        setSubCategory((byte)5); // uid 10658, Tactical Unattended Ground Sensor (T-UGS)
        setSpecific((byte)3); // uid 22885, T-UGS Radiological Nuclear Node
    }
}
