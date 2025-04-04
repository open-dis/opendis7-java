/**
 * Copyright (c) 2008-2023, MOVES Institute, Naval Postgraduate School (NPS). All rights reserved.
 * This work is provided under a BSD-style open-source license, see project
 * <a href="https://savage.nps.edu/opendis7-java/license.html" target="_blank">license.html</a> and <a href="https://savage.nps.edu/opendis7-java/license.txt" target="_blank">license.txt</a>
 */
// header autogenerated using string template dis7javalicense.txt

// autogenerated using string template entitytypecommon.txt

package edu.nps.moves.dis7.entities.mhl.platform.surface;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * <p> Entity class <b><code>TankerGroup3Merchant</code></b> collects multiple enumeration values together to uniquely define this entity. </p>
 * <p> <i>Usage:</i> create an instance of this class with <code>TankerGroup3Merchant.createInstance()</code> or <code>new TankerGroup3Merchant()</code>. </p>
 * <ul>
 *     <li> Country: Marshall Islands (MHL) = <code>137</code>; </li>
 *     <li> Entity kind: PlatformDomain = <code>SURFACE</code>; </li>
 *     <li> Domain: Platform = <code>1</code>; </li>
 *     <li> Category: Tanker (Group 3 Merchant) = <code>82</code>; </li>
 *     <li> SubCategory: null <code>(none)</code>; </li>
 *     <li> Specific: null <code>(none)</code>; </li>
 *     <li> Entity type uid: 24572; </li>
 *     <li> Online document reference: <a href="https://gitlab.nps.edu/Savage/NetworkedGraphicsMV3500/-/blob/master/specifications/README.md" target="_blank">SISO-REF-010-v33-DRAFT-20231217-d10 (2023-12-17)</a>. </li>
 * </ul>
 * <p> Full name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$CategoryElem@43826ec. </p>
 * @see Country#MARSHALL_ISLANDS_MHL
 * @see EntityKind#PLATFORM
 * @see Domain
 * @see PlatformDomain
 * @see Category
 * @see TankerGroup3Merchant
null
 */
public final class TankerGroup3Merchant extends EntityType
{
    /** Default constructor */
    public TankerGroup3Merchant()
    {
        setCountry(Country.MARSHALL_ISLANDS_MHL);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.SURFACE));

        setCategory((byte)82); // uid 24572, Tanker (Group 3 Merchant)
    }
    /** Create a new instance of this final (unmodifiable) class
      * @return copy of class for use as data */
    public static TankerGroup3Merchant createInstance()
    {
            return new TankerGroup3Merchant();
    }
}
