/**
 * Copyright (c) 2008-2019, MOVES Institute, Naval Postgraduate School. All rights reserved.
 * This work is licensed under the BSD open source license, available at https://www.movesinstitute.org/licenses/bsd.html
 */

package edu.nps.moves.dis;

/**
 * Category.java created on May 7, 2019
 * Marker interface to polymorphize category field in Pdus
 */
public interface Category
{
    int getValue();
    String getDescription();
}
