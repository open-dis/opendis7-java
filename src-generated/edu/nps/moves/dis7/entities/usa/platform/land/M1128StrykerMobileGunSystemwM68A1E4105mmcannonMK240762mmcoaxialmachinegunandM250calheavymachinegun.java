package edu.nps.moves.dis7.entities.usa.platform.land;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@7e307087
 * Country: United States of America (USA)
 * Entity kind: Platform
 * Domain: LAND
 *
 * Entity type uid: 10137
 */
public class M1128StrykerMobileGunSystemwM68A1E4105mmcannonMK240762mmcoaxialmachinegunandM250calheavymachinegun extends EntityType
{
    public M1128StrykerMobileGunSystemwM68A1E4105mmcannonMK240762mmcoaxialmachinegunandM250calheavymachinegun()
    {
        setCountry(Country.UNITED_STATES_OF_AMERICA_USA);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.LAND));

        setCategory((byte)2); // uid 10067, Armored Fighting Vehicle
        setSubCategory((byte)5); // uid 10115, Light Armored Vehicle (LAV) Stryker
        setSpecific((byte)22); // uid 10137, M1128 Stryker Mobile Gun System w/M68A1E4 105-mm cannon, MK 240 7.62 mm co-axial machine gun, and M2 .50 cal heavy machine gun
    }
}
