// autogenerated using string template entitytypecommon.txt

package edu.nps.moves.dis7.entities.rus.platform.surface;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * <p> Entity class <b><code>Neptunclasssalvagerescueampmooring13</code></b> collects multiple enumeration values together to uniquely define this entity. </p>
 * <p> <i>Usage:</i> create an instance of this class with <code>Neptunclasssalvagerescueampmooring13.createInstance()</code> or <code>new Neptunclasssalvagerescueampmooring13()</code>. </p>
 * <ul>
 *     <li> Country: Russia (RUS) = <code>222</code>; </li>
 *     <li> Entity kind: PlatformDomain = <code>SURFACE</code>; </li>
 *     <li> Domain: Platform = <code>1</code>; </li>
 *     <li> Category: Auxiliary = <code>16</code>; </li>
 *     <li> SubCategory: Neptunclasssalvagerescueampmooring  = <code>77</code>; </li>
 *     <li> Specific: _13  = <code>6</code>; </li>
 *     <li> Entity type uid: 14305; </li>
 *     <li> Online document reference: <a href="https://gitlab.nps.edu/Savage/NetworkedGraphicsMV3500/-/blob/master/specifications/README.md" target="_blank">SISO-REF-010-v30-DRAFT-20220129-d11 (2022-01-29)</a>. </li>
 * </ul>
 * <p> Full name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@50850539. </p>
 * @see Country#RUSSIA_RUS
 * @see EntityKind#PLATFORM
 * @see Domain
 * @see PlatformDomain
 * @see Category
 * @see Auxiliary
 * @see SubCategory

 */
public final class Neptunclasssalvagerescueampmooring13 extends EntityType
{
    /** Default constructor */
    public Neptunclasssalvagerescueampmooring13()
    {
        setCountry(Country.RUSSIA_RUS);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.SURFACE));

        setCategory((byte)16); // uid 13805, Auxiliary
        setSubCategory((byte)77); // uid 14299, Neptun class (salvage, rescue &amp; mooring)
        setSpecific((byte)6); // uid 14305, 13
    }
    /** Create a new instance of this final (unmodifiable) class
      * @return copy of class for use as data */
    public static Neptunclasssalvagerescueampmooring13 createInstance()
    {
            return new Neptunclasssalvagerescueampmooring13();
    }
}