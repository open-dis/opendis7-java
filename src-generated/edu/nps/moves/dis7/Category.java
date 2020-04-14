/**
 * Copyright (c) 2008-2019, MOVES Institute, Naval Postgraduate School. All rights reserved.
 * This work is provided under a BSD open-source license, see project license.html and license.txt
 */

package edu.nps.moves.dis7;

/**
 * Category.java created on May 7, 2019
 * Marker interface to polymorphize category field in Pdus
 */
public interface Category
{
    int getValue();
    String getDescription();
}
