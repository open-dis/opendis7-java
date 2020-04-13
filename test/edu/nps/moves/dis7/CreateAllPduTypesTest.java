/**
 * Copyright (c) 2008-2020, MOVES Institute, Naval Postgraduate School. All rights reserved.
 * This work is licensed under the BSD open source license, available at https://www.movesinstitute.org/licenses/bsd.html
 */
package edu.nps.moves.dis7;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.nio.ByteBuffer;
import java.util.HashSet;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CreateAllPduTypesTest
{
  public CreateAllPduTypesTest()
  {
  }

  @BeforeAll
  public static void setUpClass()
  {
    System.out.println("CreateAllPduTypesTest");
  }

  @AfterAll
  public static void tearDownClass()
  {
  }

  @BeforeEach
  public void setUp()
  {
  }

  @AfterEach
  public void tearDown()
  {
  }

  HashSet<Object> pdus = new HashSet<>();
  ByteBuffer buff = ByteBuffer.allocate(20000);
  DataOutputStream dos = new DataOutputStream(new ByteArrayOutputStream());

  private Throwable throwable;

  @Test
  public void testCreateAll()
  {
    try {
      Object o;
      //0 == "other"
      pdus.add(new EntityStatePdu()); //1
      pdus.add(new FirePdu()); //2
      pdus.add(new DetonationPdu()); //3
      pdus.add(new CollisionPdu()); //4
      pdus.add(new ServiceRequestPdu()); //5
      pdus.add(new ResupplyOfferPdu()); //6
      pdus.add(new ResupplyReceivedPdu()); //7
      pdus.add(new ResupplyCancelPdu()); //8
      pdus.add(new RepairCompletePdu()); //9

      pdus.add(new RepairResponsePdu()); //10       
      pdus.add(new CreateEntityPdu()); //11     
      pdus.add(new RemoveEntityPdu()); //12
      pdus.add(new StartResumePdu()); //13
      pdus.add(new StopFreezePdu()); //14
      pdus.add(new AcknowledgePdu()); //15
      pdus.add(new ActionRequestPdu()); //16
      pdus.add(new ActionResponsePdu()); //17
      pdus.add(new DataQueryPdu()); //18
      pdus.add(new SetDataPdu()); //19

      pdus.add(new DataPdu()); //20
      pdus.add(new EventReportPdu()); //21
      pdus.add(new CommentPdu()); //22
      pdus.add(new ElectromagneticEmissionPdu()); //23
      pdus.add(new DesignatorPdu()); //24   
      pdus.add(new TransmitterPdu()); //25 
      pdus.add(new SignalPdu()); //26
      pdus.add(new ReceiverPdu()); //27
      pdus.add(new IFFPdu()); //28
      pdus.add(new UnderwaterAcousticPdu()); //29

      pdus.add(new SEESPdu()); //30
      pdus.add(new IntercomSignalPdu()); //31
      pdus.add(new IntercomControlPdu()); //32
      pdus.add(new AggregateStatePdu()); //33
      pdus.add(new IsGroupOfPdu()); //34
      pdus.add(new TransferOwnershipPdu()); //35
      pdus.add(new IsPartOfPdu()); //36
      pdus.add(new MinefieldStatePdu()); //37
      pdus.add(new MinefieldQueryPdu()); //38      
      pdus.add(new MinefieldDataPdu()); //39 

      pdus.add(new MinefieldResponseNACKPdu()); //40
      pdus.add(new EnvironmentalProcessPdu()); //41
      pdus.add(new GriddedDataPdu()); //42
      pdus.add(new PointObjectStatePdu()); //43
      pdus.add(new LinearObjectStatePdu()); //44     
      pdus.add(new ArealObjectStatePdu()); //45       
      pdus.add(new TSPIPdu()); //46      
      pdus.add(new AppearancePdu()); //47      
      pdus.add(new ArticulatedPartsPdu()); //48
      pdus.add(new LEFirePdu()); //49

      pdus.add(new LEDetonationPdu()); //50
      pdus.add(new CreateEntityReliablePdu()); //51   
      pdus.add(new RemoveEntityReliablePdu()); //52   
      pdus.add(new StartResumeReliablePdu()); //53
      pdus.add(new StopFreezeReliablePdu()); //54
      pdus.add(new AcknowledgeReliablePdu()); //55      
      pdus.add(new ActionRequestReliablePdu()); //56       
      pdus.add(new ActionResponseReliablePdu()); //57       
      pdus.add(new DataQueryReliablePdu()); //58       
      pdus.add(new SetDataReliablePdu()); //59

      pdus.add(new DataReliablePdu()); //60
      pdus.add(new EventReportReliablePdu()); //61
      pdus.add(new CommentReliablePdu()); //62
      pdus.add(new RecordReliablePdu()); //63
      pdus.add(new SetRecordReliablePdu()); //64
      pdus.add(new RecordQueryReliablePdu()); //65
      pdus.add(new CollisionElasticPdu()); //66
      pdus.add(new EntityStateUpdatePdu()); //67
      pdus.add(new DirectedEnergyFirePdu()); //68
      pdus.add(new EntityDamageStatusPdu()); //69

      pdus.add(new InformationOperationsActionPdu()); //70   
      pdus.add(new InformationOperationsReportPdu()); //71
      pdus.add(new AttributePdu()); //72

      /* marshal all */
      pdus.stream().forEach(ob -> {
        try {
          ((Marshaller) ob).marshal(dos);
          //System.out.println("marshalled " + ob.getClass().getSimpleName());
        }
        catch (Throwable t) {
          throw new RuntimeException(t);
        }
      });
    }
    catch (Throwable t) {
      throwable = t;
      t.printStackTrace();
    }
    assertNull(throwable, "Exception should be null if successful marshal");
  }

  public static void main(String[] args)
  {
    new CreateAllPduTypesTest().testCreateAll();
  }
}
