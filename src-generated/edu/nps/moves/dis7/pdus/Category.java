/**
 * Copyright (c) 2008-2021, MOVES Institute, Naval Postgraduate School (NPS). All rights reserved.
 * This work is provided under a BSD open-source license, see project license.html and license.txt
 */

package edu.nps.moves.dis7.pdus;

/**
 * Category is a marker interface to polymorphize category field in Pdus.
 */
public interface Category
{
    /**
     * Value for this field
     * @return the value of this SubCategory
     */
    int getValue();
    
    /**
     * Description for this field
     * @return the description of this SubCategory
     */
    String getDescription();
}
