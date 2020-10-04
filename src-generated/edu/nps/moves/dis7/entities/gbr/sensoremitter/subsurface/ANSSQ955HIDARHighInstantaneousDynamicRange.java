package edu.nps.moves.dis7.entities.gbr.sensoremitter.subsurface;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@47b4ac83
 * Country: United Kingdom of Great Britain and Northern Ireland (GBR)
 * Entity kind: Sensor/Emitter
 * Domain: SUBSURFACE
 *
 * Entity type uid: 22474
 */
public class ANSSQ955HIDARHighInstantaneousDynamicRange extends EntityType
{
    public ANSSQ955HIDARHighInstantaneousDynamicRange()
    {
        setCountry(Country.UNITED_KINGDOM_OF_GREAT_BRITAIN_AND_NORTHERN_IRELAND_GBR);
        setEntityKind(EntityKind.SENSOR_EMITTER);
        setDomain(Domain.inst(PlatformDomain.SUBSURFACE));

        setCategory((byte)11); // uid 22472, Acoustic, Passive
        setSubCategory((byte)77); // uid 22473, Sonobuoy
        setSpecific((byte)1); // uid 22474, AN/SSQ-955 HIDAR (High Instantaneous Dynamic Range)
    }
}
