package edu.nps.moves.dis7.jammers.Deception.ConstantFalseAlarmRate;

import edu.nps.moves.dis7.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * SISO-REF-010-v28, 2020-05-07
 *
 * Jamming technique uid: 284
 */
public class ConstantFalseAlarmRate extends JammingTechnique
{
    public ConstantFalseAlarmRate()
    {
        setKind((byte)2); // Deception
        setCategory((byte)50); // Constant False Alarm Rate
    }
}
