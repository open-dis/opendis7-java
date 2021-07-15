package edu.nps.moves.dis7.entities.afg.lifeform.land;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28 (2020-05-07)
 * name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$ExtraElem@36238b12;
 * Country: Afghanistan (AFG);
 * Entity kind: Life form;
 * Domain: LAND;
 *
 * Entity type uid: 32215
 */
public class CivilianTeenagerMalewCellPhone extends EntityType
{
    /** Default constructor */
    public CivilianTeenagerMalewCellPhone()
    {
        setCountry(Country.AFGHANISTAN_AFG);
        setEntityKind(EntityKind.LIFE_FORM);
        setDomain(Domain.inst(PlatformDomain.LAND));

        setCategory((byte)130); // uid 32211, Civilian
        setSubCategory((byte)171); // uid 32212, Personal Electronics
        setSpecific((byte)1); // uid 32213, Cell Phone
        setExtra((byte)50); // uid 32215, Civilian Teenager, Male w/ Cell Phone
    }
}