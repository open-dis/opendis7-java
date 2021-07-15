package edu.nps.moves.dis7.jammers.Special.SuperJam;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28 (2020-05-07)
 *
 * Jamming technique uid: 284
 */
public class SuperJam extends JammingTechnique
{
    /** Default constructor */
    public SuperJam()
    {
        setKind((byte)4); // Special
        setCategory((byte)1); // Super Jam
    }
}
