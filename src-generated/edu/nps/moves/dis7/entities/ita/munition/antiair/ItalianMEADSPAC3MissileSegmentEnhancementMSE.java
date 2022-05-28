// autogenerated using string template entitytypecommon.txt

package edu.nps.moves.dis7.entities.ita.munition.antiair;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * <p> Entity class <b><code>ItalianMEADSPAC3MissileSegmentEnhancementMSE</code></b> collects multiple enumeration values together to uniquely define this entity. </p>
 * <p> <i>Usage:</i> create an instance of this class with <code>ItalianMEADSPAC3MissileSegmentEnhancementMSE.createInstance()</code> or <code>new ItalianMEADSPAC3MissileSegmentEnhancementMSE()</code>. </p>
 * <ul>
 *     <li> Country: Italy (ITA) = <code>106</code>; </li>
 *     <li> Entity kind: MunitionDomain = <code>ANTI_AIR</code>; </li>
 *     <li> Domain: Munition = <code>2</code>; </li>
 *     <li> Category: Guided = <code>1</code>; </li>
 *     <li> SubCategory: ItalianMIM104Patriot  = <code>3</code>; </li>
 *     <li> Specific: ItalianMEADSPAC3MissileSegmentEnhancementMSE  = <code>1</code>; </li>
 *     <li> Entity type uid: 34527; </li>
 *     <li> Online document reference: <a href="https://gitlab.nps.edu/Savage/NetworkedGraphicsMV3500/-/blob/master/specifications/README.md" target="_blank">SISO-REF-010-v30-DRAFT-20220129-d11 (2022-01-29)</a>. </li>
 * </ul>
 * <p> Full name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@7d64a960. </p>
 * @see Country#ITALY_ITA
 * @see EntityKind#MUNITION
 * @see Domain
 * @see MunitionDomain
 * @see Category
 * @see Guided
 * @see SubCategory

 */
public final class ItalianMEADSPAC3MissileSegmentEnhancementMSE extends EntityType
{
    /** Default constructor */
    public ItalianMEADSPAC3MissileSegmentEnhancementMSE()
    {
        setCountry(Country.ITALY_ITA);
        setEntityKind(EntityKind.MUNITION);
        setDomain(Domain.inst(MunitionDomain.ANTI_AIR));

        setCategory((byte)1); // uid 21662, Guided
        setSubCategory((byte)3); // uid 34526, Italian MIM-104 Patriot
        setSpecific((byte)1); // uid 34527, Italian MEADS PAC-3 Missile Segment Enhancement (MSE)
    }
    /** Create a new instance of this final (unmodifiable) class
      * @return copy of class for use as data */
    public static ItalianMEADSPAC3MissileSegmentEnhancementMSE createInstance()
    {
            return new ItalianMEADSPAC3MissileSegmentEnhancementMSE();
    }
}