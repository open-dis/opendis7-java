package edu.nps.moves.dis.util.playerrecorder;

public interface PduReceiver
{
  void receivePdu(byte[] buff, int len);
}
