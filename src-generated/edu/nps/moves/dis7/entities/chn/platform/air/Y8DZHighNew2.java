/**
 * Copyright (c) 2008-2023, MOVES Institute, Naval Postgraduate School (NPS). All rights reserved.
 * This work is provided under a BSD-style open-source license, see project
 * <a href="https://savage.nps.edu/opendis7-java/license.html" target="_blank">license.html</a> and <a href="https://savage.nps.edu/opendis7-java/license.txt" target="_blank">license.txt</a>
 */
// header autogenerated using string template dis7javalicense.txt

// autogenerated using string template entitytypecommon.txt

package edu.nps.moves.dis7.entities.chn.platform.air;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * <p> Entity class <b><code>Y8DZHighNew2</code></b> collects multiple enumeration values together to uniquely define this entity. </p>
 * <p> <i>Usage:</i> create an instance of this class with <code>Y8DZHighNew2.createInstance()</code> or <code>new Y8DZHighNew2()</code>. </p>
 * <ul>
 *     <li> Country: China, People's Republic of (CHN) = <code>45</code>; </li>
 *     <li> Entity kind: PlatformDomain = <code>AIR</code>; </li>
 *     <li> Domain: Platform = <code>1</code>; </li>
 *     <li> Category: Electronic Warfare (EW) = <code>6</code>; </li>
 *     <li> SubCategory: Y8EW  = <code>3</code>; </li>
 *     <li> Specific: Y8DZHighNew2  = <code>3</code>; </li>
 *     <li> Entity type uid: 35126; </li>
 *     <li> Online document reference: <a href="https://gitlab.nps.edu/Savage/NetworkedGraphicsMV3500/-/blob/master/specifications/README.md" target="_blank">SISO-REF-010-v33-DRAFT-20231217-d10 (2023-12-17)</a>. </li>
 * </ul>
 * <p> Full name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@1dde4cb2. </p>
 * @see Country#CHINA_PEOPLES_REPUBLIC_OF_CHN
 * @see EntityKind#PLATFORM
 * @see Domain
 * @see PlatformDomain
 * @see Category
 * @see ElectronicWarfareEW
 * @see SubCategory

 */
public final class Y8DZHighNew2 extends EntityType
{
    /** Default constructor */
    public Y8DZHighNew2()
    {
        setCountry(Country.CHINA_PEOPLES_REPUBLIC_OF_CHN);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.AIR));

        setCategory((byte)6); // uid 34550, Electronic Warfare (EW)
        setSubCategory((byte)3); // uid 35123, Y-8 EW
        setSpecific((byte)3); // uid 35126, Y-8DZ (High New 2)
    }
    /** Create a new instance of this final (unmodifiable) class
      * @return copy of class for use as data */
    public static Y8DZHighNew2 createInstance()
    {
            return new Y8DZHighNew2();
    }
}
