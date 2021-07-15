package edu.nps.moves.dis7.entities.gbr.platform.land;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28 (2020-05-07)
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$ExtraElem@608fe01f;
 * Country: United Kingdom of Great Britain and Northern Ireland (GBR);
 * Entity kind: Platform;
 * Domain: LAND;
 *
 * Entity type uid: 24914
 */
public class LandRover4X4Early1980s extends EntityType
{
    /** Default constructor */
    public LandRover4X4Early1980s()
    {
        setCountry(Country.UNITED_KINGDOM_OF_GREAT_BRITAIN_AND_NORTHERN_IRELAND_GBR);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.LAND));

        setCategory((byte)81); // uid 24911, Car
        setSubCategory((byte)113); // uid 24912, Sports Utility Vehicle (SUV), Intermediate/Standard (Medium)
        setSpecific((byte)1); // uid 24913, Land Rover
        setExtra((byte)1); // uid 24914, Land Rover 4X4, Early 1980s
    }
}
