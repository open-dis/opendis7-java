package edu.nps.moves.dis7.objecttypes.PointObject.Obstacle.Barrier.Barrier_HESCOBasket_Double_Stacked;

import edu.nps.moves.dis7.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 *
 * ObjectType uid: 226
 */
public class Barrier_HESCOBasket_Double_Stacked extends ObjectType
{
    public Barrier_HESCOBasket_Double_Stacked()
    {
        setDomain(PlatformDomain.getEnumForValue(1));
        setObjectKind(ObjectKind.getEnumForValue(1)); // Obstacle
        setCategory((byte)4); // Barrier
        setSubCategory((byte)5); // Barrier, HESCO Basket, Double-Stacked
    }
}
