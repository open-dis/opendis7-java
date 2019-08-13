package edu.nps.moves.dis7.jammers.Deception.GateStealer.ChirpGateStealerCGS;

import edu.nps.moves.dis7.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v25, 2018-08-29
 *
 * Jamming technique uid: 284
 */
public class ChirpGateStealerCGS extends JammingTechnique
{
    public ChirpGateStealerCGS()
    {
        setKind((byte)2); // Deception
        setCategory((byte)75); // Gate Stealer
        setSubCategory((byte)5); // Chirp Gate Stealer (CGS)
    }
}
