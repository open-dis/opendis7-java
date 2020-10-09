package edu.nps.moves.dis7.jammers.Noise.CooperativeBlinkedNoiseCBN;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 *
 * Jamming technique uid: 284
 */
public class CooperativeBlinkedNoiseCBN extends JammingTechnique
{
    public CooperativeBlinkedNoiseCBN()
    {
        setKind((byte)1); // Noise
        setCategory((byte)25); // Cooperative Blinked Noise (CBN)
    }
}
