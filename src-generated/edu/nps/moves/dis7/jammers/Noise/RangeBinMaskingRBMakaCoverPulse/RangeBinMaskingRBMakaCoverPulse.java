package edu.nps.moves.dis7.jammers.Noise.RangeBinMaskingRBMakaCoverPulse;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 *
 * Jamming technique uid: 284
 */
public class RangeBinMaskingRBMakaCoverPulse extends JammingTechnique
{
    public RangeBinMaskingRBMakaCoverPulse()
    {
        setKind((byte)1); // Noise
        setCategory((byte)65); // Range Bin Masking (RBM) (aka Cover Pulse)
    }
}
