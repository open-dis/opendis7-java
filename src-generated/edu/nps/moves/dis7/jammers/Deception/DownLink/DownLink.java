package edu.nps.moves.dis7.jammers.Deception.DownLink;

import edu.nps.moves.dis7.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 *
 * Jamming technique uid: 284
 */
public class DownLink extends JammingTechnique
{
    public DownLink()
    {
        setKind((byte)2); // Deception
        setCategory((byte)60); // Down Link
    }
}
