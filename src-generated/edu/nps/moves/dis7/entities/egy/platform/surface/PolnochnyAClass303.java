// autogenerated using string template entitytypecommon.txt

package edu.nps.moves.dis7.entities.egy.platform.surface;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * <p> Entity class <b><code>PolnochnyAClass303</code></b> collects multiple enumeration values together to uniquely define this entity. </p>
 * <p> <i>Usage:</i> create an instance of this class with <code>PolnochnyAClass303.createInstance()</code> or <code>new PolnochnyAClass303()</code>. </p>
 * <ul>
 *     <li> Country: Egypt (EGY) = <code>62</code>; </li>
 *     <li> Entity kind: PlatformDomain = <code>SURFACE</code>; </li>
 *     <li> Domain: Platform = <code>1</code>; </li>
 *     <li> Category: Tank Landing Ship = <code>10</code>; </li>
 *     <li> SubCategory: PolnochnyAClass  = <code>1</code>; </li>
 *     <li> Specific: _303  = <code>2</code>; </li>
 *     <li> Entity type uid: 33566; </li>
 *     <li> Online document reference: <a href="https://gitlab.nps.edu/Savage/NetworkedGraphicsMV3500/-/blob/master/specifications/README.md" target="_blank">SISO-REF-010-v30-DRAFT-20220129-d11 (2022-01-29)</a>. </li>
 * </ul>
 * <p> Full name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@c430e6c. </p>
 * @see Country#COMMENT_RELIABLE
 * @see EntityKind#PLATFORM
 * @see Domain
 * @see PlatformDomain
 * @see Category
 * @see TankLandingShip
 * @see SubCategory

 */
public final class PolnochnyAClass303 extends EntityType
{
    /** Default constructor */
    public PolnochnyAClass303()
    {
        setCountry(Country.COMMENT_RELIABLE);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.SURFACE));

        setCategory((byte)10); // uid 33563, Tank Landing Ship
        setSubCategory((byte)1); // uid 33564, Polnochny A Class
        setSpecific((byte)2); // uid 33566, 303
    }
    /** Create a new instance of this final (unmodifiable) class
      * @return copy of class for use as data */
    public static PolnochnyAClass303 createInstance()
    {
            return new PolnochnyAClass303();
    }
}