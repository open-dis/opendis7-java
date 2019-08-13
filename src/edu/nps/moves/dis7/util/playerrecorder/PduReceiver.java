package edu.nps.moves.dis7.util.playerrecorder;

public interface PduReceiver
{
  void receivePdu(byte[] buff, int len);
}
