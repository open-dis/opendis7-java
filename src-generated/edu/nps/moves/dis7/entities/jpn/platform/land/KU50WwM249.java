// autogenerated using string template entitytypecommon.txt

package edu.nps.moves.dis7.entities.jpn.platform.land;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * <p> Entity class <b><code>KU50WwM249</code></b> collects multiple enumeration values together to uniquely define this entity. </p>
 * <p> <i>Usage:</i> create an instance of this class with <code>KU50WwM249.createInstance()</code> or <code>new KU50WwM249()</code>. </p>
 * <ul>
 *     <li> Country: Japan (JPN) = <code>110</code>; </li>
 *     <li> Entity kind: PlatformDomain = <code>LAND</code>; </li>
 *     <li> Domain: Platform = <code>1</code>; </li>
 *     <li> Category: Small Wheeled Utility Vehicle = <code>6</code>; </li>
 *     <li> SubCategory: KomatsuLAV  = <code>2</code>; </li>
 *     <li> Specific: KU50WwM249  = <code>4</code>; </li>
 *     <li> Entity type uid: 33605; </li>
 *     <li> Online document reference: <a href="https://gitlab.nps.edu/Savage/NetworkedGraphicsMV3500/-/blob/master/specifications/README.md" target="_blank">SISO-REF-010-v30-DRAFT-20220129-d11 (2022-01-29)</a>. </li>
 * </ul>
 * <p> Full name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@2b46a8c1. </p>
 * @see Country#JAPAN_JPN
 * @see EntityKind#PLATFORM
 * @see Domain
 * @see PlatformDomain
 * @see Category
 * @see SmallWheeledUtilityVehicle
 * @see SubCategory

 */
public final class KU50WwM249 extends EntityType
{
    /** Default constructor */
    public KU50WwM249()
    {
        setCountry(Country.JAPAN_JPN);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.LAND));

        setCategory((byte)6); // uid 33601, Small Wheeled Utility Vehicle
        setSubCategory((byte)2); // uid 33603, Komatsu LAV
        setSpecific((byte)4); // uid 33605, KU-50W w/ M249
    }
    /** Create a new instance of this final (unmodifiable) class
      * @return copy of class for use as data */
    public static KU50WwM249 createInstance()
    {
            return new KU50WwM249();
    }
}