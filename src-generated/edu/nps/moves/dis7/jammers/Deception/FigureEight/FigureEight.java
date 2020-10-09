package edu.nps.moves.dis7.jammers.Deception.FigureEight;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 *
 * Jamming technique uid: 284
 */
public class FigureEight extends JammingTechnique
{
    public FigureEight()
    {
        setKind((byte)2); // Deception
        setCategory((byte)70); // Figure Eight
    }
}
