package edu.nps.moves.dis7.jammers.Noise.VelocityBinMaskingVBM;

import edu.nps.moves.dis7.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v25, 2018-08-29
 *
 * Jamming technique uid: 284
 */
public class VelocityBinMaskingVBM extends JammingTechnique
{
    public VelocityBinMaskingVBM()
    {
        setKind((byte)1); // Noise
        setCategory((byte)85); // Velocity Bin Masking (VBM)
    }
}
