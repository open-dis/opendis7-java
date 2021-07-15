package edu.nps.moves.dis7.jammers.Noise.VelocityBinMaskingVBM;

import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28 (2020-05-07)
 *
 * Jamming technique uid: 284
 */
public class VelocityBinMaskingVBM extends JammingTechnique
{
    /** Default constructor */
    public VelocityBinMaskingVBM()
    {
        setKind((byte)1); // Noise
        setCategory((byte)85); // Velocity Bin Masking (VBM)
    }
}
