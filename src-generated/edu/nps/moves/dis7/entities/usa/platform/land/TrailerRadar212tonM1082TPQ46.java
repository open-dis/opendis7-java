// autogenerated using string template entitytypecommon.txt

package edu.nps.moves.dis7.entities.usa.platform.land;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * <p> Entity class <b><code>TrailerRadar212tonM1082TPQ46</code></b> collects multiple enumeration values together to uniquely define this entity. </p>
 * <p> <i>Usage:</i> create an instance of this class with <code>TrailerRadar212tonM1082TPQ46.createInstance()</code> or <code>new TrailerRadar212tonM1082TPQ46()</code>. </p>
 * <ul>
 *     <li> Country: United States of America (USA) = <code>225</code>; </li>
 *     <li> Entity kind: PlatformDomain = <code>LAND</code>; </li>
 *     <li> Domain: Platform = <code>1</code>; </li>
 *     <li> Category: Cargo Trailer = <code>14</code>; </li>
 *     <li> SubCategory: _2015ton  = <code>3</code>; </li>
 *     <li> Specific: Trailercargo_212tonM1082  = <code>1</code>; </li>
 *     <li> Entity type uid: 33461; </li>
 *     <li> Online document reference: <a href="https://gitlab.nps.edu/Savage/NetworkedGraphicsMV3500/-/blob/master/specifications/README.md" target="_blank">SISO-REF-010-v30-DRAFT-20220129-d11 (2022-01-29)</a>. </li>
 * </ul>
 * <p> Full name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$ExtraElem@415a3f6a. </p>
 * @see Country#UNITED_STATES_OF_AMERICA_USA
 * @see EntityKind#PLATFORM
 * @see Domain
 * @see PlatformDomain
 * @see Category
 * @see CargoTrailer
 * @see SubCategory

 */
public final class TrailerRadar212tonM1082TPQ46 extends EntityType
{
    /** Default constructor */
    public TrailerRadar212tonM1082TPQ46()
    {
        setCountry(Country.UNITED_STATES_OF_AMERICA_USA);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.LAND));

        setCategory((byte)14); // uid 10616, Cargo Trailer
        setSubCategory((byte)3); // uid 10620, 2.01 - 5 ton
        setSpecific((byte)1); // uid 10621, Trailer, cargo; 2 1/2 ton, M1082
        setExtra((byte)2); // uid 33461, Trailer, Radar; 2 1/2 ton, M1082, TPQ-46
    }
    /** Create a new instance of this final (unmodifiable) class
      * @return copy of class for use as data */
    public static TrailerRadar212tonM1082TPQ46 createInstance()
    {
            return new TrailerRadar212tonM1082TPQ46();
    }
}