/*
 * BSD License. Copyright MOVES Institute 2005-2014.
 */
package DisShooting;

import edu.nps.moves.dis7.pdus.*;

/**
 * Interface for things that may be notified of the receipt of a PDU
 * 
 * @author DMcG
 */
public interface PduListener 
{
    /** Allows for protocol data unit processing once received from the net 
     * 
     * @param aPdu the PDU to process
     */
    void pduReceived(Pdu aPdu);
}
