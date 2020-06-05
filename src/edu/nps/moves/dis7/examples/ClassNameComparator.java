/**
 * Copyright (c) 2008-2020, MOVES Institute, Naval Postgraduate School (NPS). All rights reserved.
 * This work is provided under a BSD open-source license, see project license.html and license.txt
 */

package edu.nps.moves.dis7.examples;

import edu.nps.moves.dis7.Pdu;
import java.util.Comparator;

/**
 * A comparator that is used by the java util classes for sorting. This
 * sorts members of a collection by class name.
 * 
 * Used like so:
 * 
 * Collections.sort(aList, new ClassNameComparator());
 *
 * @author DMcG
 * @version $Id:$
 */
public class ClassNameComparator implements Comparator<Pdu> {

    /**
     * Returns a number less than, equal to, or greater than zero,
     * depending on whether the object is lexically less than, equal to,
     * or greater than the other object.
     * @param object1
     * @param object2
     */
    @Override
    public int compare(Pdu object1, Pdu object2) {
        return object1.getClass().getName().compareTo(object2.getClass().getName());
    }

    /**
     * Returns true if this comparator is the same class as the comparator passed in.
     * 
     * @param obj
     */
    @Override
    public boolean equals(Object obj) {
        return obj.getClass().equals(this.getClass());
    }

    @Override
    public int hashCode() {
        return 3;
    }
}