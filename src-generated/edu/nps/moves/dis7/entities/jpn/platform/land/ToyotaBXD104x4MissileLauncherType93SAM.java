/**
 * Copyright (c) 2008-2023, MOVES Institute, Naval Postgraduate School (NPS). All rights reserved.
 * This work is provided under a BSD-style open-source license, see project
 * <a href="https://savage.nps.edu/opendis7-java/license.html" target="_blank">license.html</a> and <a href="https://savage.nps.edu/opendis7-java/license.txt" target="_blank">license.txt</a>
 */
// header autogenerated using string template dis7javalicense.txt

// autogenerated using string template entitytypecommon.txt

package edu.nps.moves.dis7.entities.jpn.platform.land;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * <p> Entity class <b><code>ToyotaBXD104x4MissileLauncherType93SAM</code></b> collects multiple enumeration values together to uniquely define this entity. </p>
 * <p> <i>Usage:</i> create an instance of this class with <code>ToyotaBXD104x4MissileLauncherType93SAM.createInstance()</code> or <code>new ToyotaBXD104x4MissileLauncherType93SAM()</code>. </p>
 * <ul>
 *     <li> Country: Japan (JPN) = <code>110</code>; </li>
 *     <li> Entity kind: PlatformDomain = <code>LAND</code>; </li>
 *     <li> Domain: Platform = <code>1</code>; </li>
 *     <li> Category: Small Wheeled Utility Vehicle = <code>6</code>; </li>
 *     <li> SubCategory: ToyotaMegaCruiser4x4  = <code>4</code>; </li>
 *     <li> Specific: ToyotaBXD104x4MissileLauncherType93SAM  = <code>2</code>; </li>
 *     <li> Entity type uid: 35809; </li>
 *     <li> Online document reference: <a href="https://gitlab.nps.edu/Savage/NetworkedGraphicsMV3500/-/blob/master/specifications/README.md" target="_blank">SISO-REF-010-v33-DRAFT-20231217-d10 (2023-12-17)</a>. </li>
 * </ul>
 * <p> Full name: edu.nps.moves.dis7.source.generator.entityTypes.GenerateEntityTypes$SpecificElem@56bc3fac. </p>
 * @see Country#JAPAN_JPN
 * @see EntityKind#PLATFORM
 * @see Domain
 * @see PlatformDomain
 * @see Category
 * @see SmallWheeledUtilityVehicle
 * @see SubCategory

 */
public final class ToyotaBXD104x4MissileLauncherType93SAM extends EntityType
{
    /** Default constructor */
    public ToyotaBXD104x4MissileLauncherType93SAM()
    {
        setCountry(Country.JAPAN_JPN);
        setEntityKind(EntityKind.PLATFORM);
        setDomain(Domain.inst(PlatformDomain.LAND));

        setCategory((byte)6); // uid 33601, Small Wheeled Utility Vehicle
        setSubCategory((byte)4); // uid 35807, Toyota Mega Cruiser 4x4
        setSpecific((byte)2); // uid 35809, Toyota BXD10 4x4 Missile Launcher (Type 93 SAM)
    }
    /** Create a new instance of this final (unmodifiable) class
      * @return copy of class for use as data */
    public static ToyotaBXD104x4MissileLauncherType93SAM createInstance()
    {
            return new ToyotaBXD104x4MissileLauncherType93SAM();
    }
}