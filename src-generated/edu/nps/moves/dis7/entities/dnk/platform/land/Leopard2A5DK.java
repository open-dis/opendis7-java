package edu.nps.moves.dis7.entities.dnk.platform.land;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28 (2020-05-07)
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SubCategoryElem@409bf450;
 * Country: Denmark (DNK);
 * Entity kind: Platform;
 * Domain: LAND;
 *
 * Entity type uid: 28833
 */
public class Leopard2A5DK extends EntityType
{
    /** Default constructor */
    public Leopard2A5DK()
    {
        setCountry(Country.ACTION_RESPONSE_RELIABLE);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.LAND));

        setCategory((byte)1); // uid 28832, Tank
        setSubCategory((byte)1); // uid 28833, Leopard 2A5DK
    }
}