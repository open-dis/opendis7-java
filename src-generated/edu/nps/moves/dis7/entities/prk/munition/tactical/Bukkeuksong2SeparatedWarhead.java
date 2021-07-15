package edu.nps.moves.dis7.entities.prk.munition.tactical;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28 (2020-05-07)
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@6d6cd1e0;
 * Country: Korea (Democratic Peoples Republic of) (PRK);
 * Entity kind: Munition;
 * Domain: TACTICAL;
 *
 * Entity type uid: 32516
 */
public class Bukkeuksong2SeparatedWarhead extends EntityType
{
    /** Default constructor */
    public Bukkeuksong2SeparatedWarhead()
    {
        setCountry(Country.KOREA_DEMOCRATIC_PEOPLES_REPUBLIC_OF_PRK);
        setEntityKind(EntityKind.MUNITION);
        setDomain(Domain.inst(MunitionDomain.TACTICAL));

        setCategory((byte)1); // uid 32499, Guided
        setSubCategory((byte)63); // uid 32514, Bukkeuksong-2
        setSpecific((byte)2); // uid 32516, Bukkeuksong-2 Separated Warhead
    }
}