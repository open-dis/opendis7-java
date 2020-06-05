package edu.nps.moves.dis7.utilities.stream;

import edu.nps.moves.dis7.enumerations.Country;
import edu.nps.moves.dis7.utilities.DisNetworking;
import edu.nps.moves.dis7.utilities.PduFactory;
import edu.nps.moves.dis7.*;
import java.io.File;
import java.nio.file.Path;

/**
 * ValidationPdusMakerV1.java created on Aug 14, 2019
 * MOVES Institute Naval Postgraduate School, Monterey, CA, USA www.nps.edu
 * <p>
 * This class produces and sends to the net a "standard" stream of Pdus, which may then be captured and
 * saved by an instance of @see edu.nps.moves.dis7.util.playerrecorder.Recorder. After future changes
 * to the DIS library, another run of this class may be done and an instance of @see edu.nps.moves.dis7.util.playerrecorder.LogCompare may
 * be used to detect differences.
 * <p>
 * The main method here takes 1. a directory name, and 2. a file name, in that order.  File type ".dislog" will be appended.
 * If run with an argument count different that 2, the default values of "validatorOut" and "validationLog.txt" are used.
 *
 * @author Mike Bailey, jmbailey@nps.edu
 * @version $Id$
 */
public class ValidationPdusMakerV1
{
  //@formatter:off
  public static final Country COUNTRY_V1 = Country.BARBADOS_BRB;
  public static final byte EXERCISEID_V1 = (byte) 0x11;
  public static final short SITEID_V1 = (short) 0x2222;
  public static final short APPLICATIONID_V1 = (short) 0x3333;
  public static final boolean USEABSOLUTETIME_V1 = true;
  //@formatter:on

  public ValidationPdusMakerV1()
  {
    throw new UnsupportedOperationException("Not supported yet.");
    // need to confirm usage with new Recorder
  }
  
  PduFactory factory;
  DisNetworking disnet;
  PduRecorder recorder;
  /**
   *
   * @param dir directory to save pdu log file
   * @param fn filename of log file, will append an integer to prevent overwriting
   * @return exit indicator ala @see java.lang.System#exit .
   * @throws java.lang.Exception from network write or pdu creation
   */
  public int run(String dir, String fn) throws Exception
  {
    File dirfile = new File(dir);
    dirfile.mkdirs();
    Path dirpath = dirfile.toPath();

    /* PduFactory is initialized with country, exerciseId, siteId, applicationId and a boolean specifying absolute DIS time use.
     Those values are automatically inserted by PduFactory into those created pdus which use them.  The time field of the DIS pdu
     is set to the time of creation of the instance.  All those may be overridden in the pdu object.  Also, multiple PduFactory instances
     may co-exist containing alternate defaults.
    
     The values here are used for creating the validation pdu log, and must also be used for future comparison
     */
    factory = new PduFactory(COUNTRY_V1, EXERCISEID_V1, SITEID_V1, APPLICATIONID_V1, USEABSOLUTETIME_V1);
    disnet = new DisNetworking();
    recorder = new PduRecorder(); //dirpath,fn);
    
     // Start a thread to receive and record pdus; this is a datagram socket and is non-interruptible; thread will go away on Sys exit
    /*Thread receiverThrd = new Thread(() -> {
      int count = 1;
      System.out.println("Packet reception count");
      while (true) {
        try {
          DisNetworking.BuffAndLength blen = disnet.receiveRawPdu();
          //System.out.println("" + count++ + " Got pdu from DisNetworking");
          recorder.receivePdu(blen.buff, blen.length);
          System.out.println("\r"+count++);
        }
        catch (IOException ex) {
          System.err.println("Exception receiving Pdu: " + ex.getLocalizedMessage());
        }
      }
    });
    receiverThrd.setPriority(Thread.NORM_PRIORITY);
    receiverThrd.setDaemon(true);
    receiverThrd.start();
    */
    /* The standard validation log consists of one of each defined pdu from 1, ENTITY_STATE, to 72, ATTRIBUTE.  There is no pdu of type 0.
     This sequence of statements unnecessarily creates 72 instance variables.  Those are intended to make it easy to customize the contents of
     the created pdus.  It would be advisable to fill out more content in the pdus to ensure the correctness of the pdu in the net packet.
    */
    EntityStatePdu pdu1 = factory.makeEntityStatePdu(); //1
    sendPdu(pdu1);
    FirePdu pdu2 = factory.makeFirePdu(); //2
    sendPdu(pdu2);
    DetonationPdu pdu3 = factory.makeDetonationPdu(); //3
    sendPdu(pdu3);
    CollisionPdu pdu4 = factory.makeCollisionPdu(); //4
    sendPdu(pdu4);
    ServiceRequestPdu pdu5 = factory.makeServiceRequestPdu(); //5
    sendPdu(pdu5);
    ResupplyOfferPdu pdu6 = factory.makeResupplyOfferPdu(); //6
    sendPdu(pdu6);
    ResupplyReceivedPdu pdu7 = factory.makeResupplyReceivedPdu(); //7
    sendPdu(pdu7);
    ResupplyCancelPdu pdu8 = factory.makeResupplyCancelPdu(); //8
    sendPdu(pdu8);
    RepairCompletePdu pdu9 = factory.makeRepairCompletePdu(); //9
    sendPdu(pdu9);
    RepairResponsePdu pdu10 = factory.makeRepairResponsePdu(); //10
    sendPdu(pdu10);

    CreateEntityPdu pdu11 = factory.makeCreateEntityPdu(); //11
    sendPdu(pdu11);
    RemoveEntityPdu pdu12 = factory.makeRemoveEntityPdu(); //12
    sendPdu(pdu12);
    StartResumePdu pdu13 = factory.makeStartResumePdu(); //13
    sendPdu(pdu13);
    StopFreezePdu pdu14 = factory.makeStopFreezePdu(); //14
    sendPdu(pdu14);
    AcknowledgePdu pdu15 = factory.makeAcknowledgePdu(); //15
    sendPdu(pdu15);
    ActionRequestPdu pdu16 = factory.makeActionRequestPdu(); //16
    sendPdu(pdu16);
    ActionResponsePdu pdu17 = factory.makeActionResponsePdu(); //17
    sendPdu(pdu17);
    DataQueryPdu pdu18 = factory.makeDataQueryPdu(); //18
    sendPdu(pdu18);
    SetDataPdu pdu19 = factory.makeSetDataPdu(); //19
    sendPdu(pdu19);
    DataPdu pdu20 = factory.makeDataPdu(); //20
    sendPdu(pdu20);

    EventReportPdu pdu21 = factory.makeEventReportPdu(); //21
    sendPdu(pdu21);
    CommentPdu pdu22 = factory.makeCommentPdu(); //22
    sendPdu(pdu22);
    ElectromagneticEmissionPdu pdu23 = factory.makeElectronicEmissionsPdu(); //23
    sendPdu(pdu23);
    DesignatorPdu pdu24 = factory.makeDesignatorPdu(); //24
    sendPdu(pdu24);
    TransmitterPdu pdu25 = factory.makeTransmitterPdu(); //25
    sendPdu(pdu25);
    SignalPdu pdu26 = factory.makeSignalPdu(); //26
    sendPdu(pdu26);
    ReceiverPdu pdu27 = factory.makeReceiverPdu(); //27
    sendPdu(pdu27);
    IFFPdu pdu28 = factory.makeIffPdu(); //28
    sendPdu(pdu28);
    UnderwaterAcousticPdu pdu29 = factory.makeUnderwaterAcousticPdu(); //29
    sendPdu(pdu29);
    SEESPdu pdu30 = factory.makeSeesPdu(); //30
    sendPdu(pdu30);

    IntercomSignalPdu pdu31 = factory.makeIntercomSignalPdu(); //31
    sendPdu(pdu31);
    IntercomControlPdu pdu32 = factory.makeIntercomControlPdu(); //32
    sendPdu(pdu32);
    AggregateStatePdu pdu33 = factory.makeAggregateStatePdu(); //33
    sendPdu(pdu33);
    IsGroupOfPdu pdu34 = factory.makeIsGroupOfPdu(); //34
    sendPdu(pdu34);
    TransferOwnershipPdu pdu35 = factory.makeTransferOwnershipPdu(); //35
    sendPdu(pdu35);
    IsPartOfPdu pdu36 = factory.makeIsPartOfPdu(); //36
    sendPdu(pdu36);
    MinefieldStatePdu pdu37 = factory.makeMinefieldStatePdu(); //37
    sendPdu(pdu37);
    MinefieldQueryPdu pdu38 = factory.makeMinefieldQueryPdu(); //38
    sendPdu(pdu38);
    MinefieldDataPdu pdu39 = factory.makeMinefieldDataPdu(); //39
    sendPdu(pdu39);
    MinefieldResponseNACKPdu pdu40 = factory.makeMinefieldResponseNackPdu(); //40
    sendPdu(pdu40);

    EnvironmentalProcessPdu pdu41 = factory.makeEnvironmentalProcessPdu(); //41
    sendPdu(pdu41);
    GriddedDataPdu pdu42 = factory.makeGriddedDataPdu(); //42
    sendPdu(pdu42);
    PointObjectStatePdu pdu43 = factory.makePointObjectStatePdu(); //43
    sendPdu(pdu43);
    LinearObjectStatePdu pdu44 = factory.makeLinearObjectStatePdu(); //44
    sendPdu(pdu44);
    ArealObjectStatePdu pdu45 = factory.makeArealObjectStatePdu(); //45
    sendPdu(pdu45);
    TSPIPdu pdu46 = factory.makeTspiPdu(); //46
    sendPdu(pdu46);
    AppearancePdu pdu47 = factory.makeAppearancePdu(); //47
    sendPdu(pdu47);
    ArticulatedPartsPdu pdu48 = factory.makeArticulatedPartsPdu(); //48
    sendPdu(pdu48);
    LEFirePdu pdu49 = factory.makeLEFirePdu(); //49
    sendPdu(pdu49);
    LEDetonationPdu pdu50 = factory.makeLEDetonationPdu(); //50
    sendPdu(pdu50);

    CreateEntityReliablePdu pdu51 = factory.makeCreateEntityReliablePdu(); //51
    sendPdu(pdu51);
    RemoveEntityReliablePdu pdu52 = factory.makeRemoveEntityReliablePdu(); //52
    sendPdu(pdu52);
    StartResumeReliablePdu pdu53 = factory.makeStartResumeReliablePdu(); //53
    sendPdu(pdu53);
    StopFreezeReliablePdu pdu54 = factory.makeStopFreezeReliablePdu(); //54
    sendPdu(pdu54);
    AcknowledgeReliablePdu pdu55 = factory.makeAcknowledgeReliablePdu(); //55
    sendPdu(pdu55);
    ActionRequestReliablePdu pdu56 = factory.makeActionRequestReliablePdu(); //56
    sendPdu(pdu56);
    ActionResponseReliablePdu pdu57 = factory.makeActionResponseReliablePdu(); //57
    sendPdu(pdu57);
    DataQueryReliablePdu pdu58 = factory.makeDataQueryReliablePdu(); //58
    sendPdu(pdu58);
    SetDataReliablePdu pdu59 = factory.makeSetDataReliablePdu(); //59
    sendPdu(pdu59);
    DataReliablePdu pdu60 = factory.makeDataReliablePdu(); //60
    sendPdu(pdu60);

    EventReportReliablePdu pdu61 = factory.makeEventReportReliablePdu(); //6
    sendPdu(pdu61);
    CommentReliablePdu pdu62 = factory.makeCommentReliablePdu(); //6
    sendPdu(pdu62);
    RecordReliablePdu pdu63 = factory.makeRecordReliablePdu(); //6
    sendPdu(pdu63);
    SetRecordReliablePdu pdu64 = factory.makeSetRecordReliablePdu(); //6
    sendPdu(pdu64);
    RecordQueryReliablePdu pdu65 = factory.makeRecordQueryReliablePdu(); //6
    sendPdu(pdu65);
    CollisionElasticPdu pdu66 = factory.makeCollisionElasticPdu(); //6
    sendPdu(pdu66);
    EntityStateUpdatePdu pdu67 = factory.makeEntityStateUpdatePdu(); //6
    sendPdu(pdu67);
    DirectedEnergyFirePdu pdu68 = factory.makeDirectedEnergyFirePdu(); //6
    sendPdu(pdu68);
    EntityDamageStatusPdu pdu69 = factory.makeEntityDamageStatusPdu(); //6
    sendPdu(pdu69);
    InformationOperationsActionPdu pdu70 = factory.makeInformationOperationsActionPdu(); //70
    sendPdu(pdu70);

    InformationOperationsReportPdu pdu71 = factory.makeInformationOperationsReportPdu(); //71
    sendPdu(pdu71);
    AttributePdu pdu72 = factory.makeAttributePdu(); //72
    sendPdu(pdu72);

    System.out.println();

    recorder.end();
    
    System.out.println("Successful run");
    System.out.println("Pdus logged to "+recorder.getLogFile());
    return 0; // no error
  }
  
  private void sendPdu(Pdu pdu) throws Exception
  {
    disnet.sendPdu(pdu);
    sleep(100L); // Necessary because reading is asynchronous from the writing and DisNetworking is inefficiently
    // making and closing a socket each time, potentially losing a packet or two.  Better performance from DisThreadedNetIF.
  }
    
  private void sleep(long ms)
  {
    try{Thread.sleep(ms);}catch(InterruptedException ex) {}
  }

  public static final String DEFAULT_DIR = "validatorOut";
  public static final String DEFAULT_NAME = "validationLog.txt";

  public static void main(String[] args)
  {
    try {
      if (args.length == 2)
        System.exit(new ValidationPdusMakerV1().run(args[0], args[1]));
      else
        System.exit(new ValidationPdusMakerV1().run(DEFAULT_DIR, DEFAULT_DIR));
    }
    catch (Exception ex) {
      System.err.println(ex.getClass().getSimpleName() + ": " + ex.getLocalizedMessage());
      System.exit(1); //error
    }
  }
}
