package edu.nps.moves.dis7.utilities.stream;

public interface PduReceiver
{
  void receivePdu(byte[] buff, int len);
}
