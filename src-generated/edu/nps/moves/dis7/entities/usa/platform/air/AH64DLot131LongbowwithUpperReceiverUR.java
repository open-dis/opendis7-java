package edu.nps.moves.dis7.entities.usa.platform.air;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28 (2020-05-07)
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$ExtraElem@17043b04;
 * Country: United States of America (USA);
 * Entity kind: Platform;
 * Domain: AIR;
 *
 * Entity type uid: 28995
 */
public class AH64DLot131LongbowwithUpperReceiverUR extends EntityType
{
    /** Default constructor */
    public AH64DLot131LongbowwithUpperReceiverUR()
    {
        setCountry(Country.UNITED_STATES_OF_AMERICA_USA);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.AIR));

        setCategory((byte)20); // uid 11056, Attack helicopter
        setSubCategory((byte)1); // uid 11057, McDonnell-Douglas AH-64 Apache
        setSpecific((byte)9); // uid 28993, AH-64D Lot 13.1 Longbow with Air-to-Air-to Ground (AAG)
        setExtra((byte)2); // uid 28995, AH-64D Lot 13.1 Longbow with Upper Receiver (UR)
    }
}
