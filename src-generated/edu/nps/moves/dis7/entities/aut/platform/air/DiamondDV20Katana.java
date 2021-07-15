package edu.nps.moves.dis7.entities.aut.platform.air;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28 (2020-05-07)
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@edf4efb;
 * Country: Austria (AUT);
 * Entity kind: Platform;
 * Domain: AIR;
 *
 * Entity type uid: 29435
 */
public class DiamondDV20Katana extends EntityType
{
    /** Default constructor */
    public DiamondDV20Katana()
    {
        setCountry(Country.AUSTRIA_AUT);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.AIR));

        setCategory((byte)85); // uid 29433, Civilian Fixed Wing Aircraft, Small (up to 12,500 lbs / 5,670 kg)
        setSubCategory((byte)11); // uid 29434, Single Piston Engine
        setSpecific((byte)1); // uid 29435, Diamond DV20 Katana
    }
}
