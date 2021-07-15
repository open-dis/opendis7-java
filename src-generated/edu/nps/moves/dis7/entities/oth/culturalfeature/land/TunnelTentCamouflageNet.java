package edu.nps.moves.dis7.entities.oth.culturalfeature.land;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28 (2020-05-07)
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$ExtraElem@4f7bb8df;
 * Country: Other;
 * Entity kind: Cultural feature;
 * Domain: LAND;
 *
 * Entity type uid: 28131
 */
public class TunnelTentCamouflageNet extends EntityType
{
    /** Default constructor */
    public TunnelTentCamouflageNet()
    {
        setCountry(Country.OTHER);
        setEntityKind(EntityKind.CULTURAL_FEATURE);
        setDomain(Domain.inst(PlatformDomain.LAND));

        setCategory((byte)30); // uid 28127, Temporary Building Structure
        setSubCategory((byte)1); // uid 28128, Tent
        setSpecific((byte)2); // uid 28130, Tent, Medium
        setExtra((byte)1); // uid 28131, Tunnel Tent, Camouflage Net
    }
}
