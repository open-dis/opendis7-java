package edu.nps.moves.dis7.jammers.Noise.CooperativeBlinkedNoiseCBN;

import edu.nps.moves.dis7.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v25, 2018-08-29
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
