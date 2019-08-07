package edu.nps.moves.dis.jammers.Deception.Angle.TerrainBounce;

import edu.nps.moves.dis.*;
import edu.nps.moves.dis.enumerations.*;

/**
 * SISO-REF-010-v25, 2018-08-29
 *
 * Jamming technique uid: 284
 */
public class TerrainBounce extends JammingTechnique
{
    public TerrainBounce()
    {
        setKind((byte)2); // Deception
        setCategory((byte)10); // Angle
        setSubCategory((byte)45); // Terrain Bounce
    }
}
