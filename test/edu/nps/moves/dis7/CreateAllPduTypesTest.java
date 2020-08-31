/**
 * Copyright (c) 2008-2020, MOVES Institute, Naval Postgraduate School (NPS). All rights reserved.
 * This work is provided under a BSD open-source license, see project license.html and license.txt
 */
package edu.nps.moves.dis7;

import edu.nps.moves.dis7.pdus.AcknowledgePdu;
import edu.nps.moves.dis7.pdus.AcknowledgeReliablePdu;
import edu.nps.moves.dis7.pdus.ActionRequestPdu;
import edu.nps.moves.dis7.pdus.ActionRequestReliablePdu;
import edu.nps.moves.dis7.pdus.ActionResponsePdu;
import edu.nps.moves.dis7.pdus.ActionResponseReliablePdu;
import edu.nps.moves.dis7.pdus.AggregateStatePdu;
import edu.nps.moves.dis7.pdus.AppearancePdu;
import edu.nps.moves.dis7.pdus.ArealObjectStatePdu;
import edu.nps.moves.dis7.pdus.ArticulatedPartsPdu;
import edu.nps.moves.dis7.pdus.AttributePdu;
import edu.nps.moves.dis7.pdus.CollisionElasticPdu;
import edu.nps.moves.dis7.pdus.CollisionPdu;
import edu.nps.moves.dis7.pdus.CommentPdu;
import edu.nps.moves.dis7.pdus.CommentReliablePdu;
import edu.nps.moves.dis7.pdus.CreateEntityPdu;
import edu.nps.moves.dis7.pdus.CreateEntityReliablePdu;
import edu.nps.moves.dis7.pdus.DataPdu;
import edu.nps.moves.dis7.pdus.DataQueryPdu;
import edu.nps.moves.dis7.pdus.DataQueryReliablePdu;
import edu.nps.moves.dis7.pdus.DataReliablePdu;
import edu.nps.moves.dis7.pdus.DesignatorPdu;
import edu.nps.moves.dis7.pdus.DetonationPdu;
import edu.nps.moves.dis7.pdus.DirectedEnergyFirePdu;
import edu.nps.moves.dis7.pdus.ElectromagneticEmissionPdu;
import edu.nps.moves.dis7.pdus.EntityDamageStatusPdu;
import edu.nps.moves.dis7.pdus.EntityStatePdu;
import edu.nps.moves.dis7.pdus.EntityStateUpdatePdu;
import edu.nps.moves.dis7.pdus.EnvironmentalProcessPdu;
import edu.nps.moves.dis7.pdus.EventReportPdu;
import edu.nps.moves.dis7.pdus.EventReportReliablePdu;
import edu.nps.moves.dis7.pdus.FirePdu;
import edu.nps.moves.dis7.pdus.GriddedDataPdu;
import edu.nps.moves.dis7.pdus.IFFPdu;
import edu.nps.moves.dis7.pdus.InformationOperationsActionPdu;
import edu.nps.moves.dis7.pdus.InformationOperationsReportPdu;
import edu.nps.moves.dis7.pdus.IntercomControlPdu;
import edu.nps.moves.dis7.pdus.IntercomSignalPdu;
import edu.nps.moves.dis7.pdus.IsGroupOfPdu;
import edu.nps.moves.dis7.pdus.IsPartOfPdu;
import edu.nps.moves.dis7.pdus.LEDetonationPdu;
import edu.nps.moves.dis7.pdus.LEFirePdu;
import edu.nps.moves.dis7.pdus.LinearObjectStatePdu;
import edu.nps.moves.dis7.pdus.Marshaller;
import edu.nps.moves.dis7.pdus.MinefieldDataPdu;
import edu.nps.moves.dis7.pdus.MinefieldQueryPdu;
import edu.nps.moves.dis7.pdus.MinefieldResponseNACKPdu;
import edu.nps.moves.dis7.pdus.MinefieldStatePdu;
import edu.nps.moves.dis7.pdus.PointObjectStatePdu;
import edu.nps.moves.dis7.pdus.ReceiverPdu;
import edu.nps.moves.dis7.pdus.RecordQueryReliablePdu;
import edu.nps.moves.dis7.pdus.RecordReliablePdu;
import edu.nps.moves.dis7.pdus.RemoveEntityPdu;
import edu.nps.moves.dis7.pdus.RemoveEntityReliablePdu;
import edu.nps.moves.dis7.pdus.RepairCompletePdu;
import edu.nps.moves.dis7.pdus.RepairResponsePdu;
import edu.nps.moves.dis7.pdus.ResupplyCancelPdu;
import edu.nps.moves.dis7.pdus.ResupplyOfferPdu;
import edu.nps.moves.dis7.pdus.ResupplyReceivedPdu;
import edu.nps.moves.dis7.pdus.SEESPdu;
import edu.nps.moves.dis7.pdus.ServiceRequestPdu;
import edu.nps.moves.dis7.pdus.SetDataPdu;
import edu.nps.moves.dis7.pdus.SetDataReliablePdu;
import edu.nps.moves.dis7.pdus.SetRecordReliablePdu;
import edu.nps.moves.dis7.pdus.SignalPdu;
import edu.nps.moves.dis7.pdus.StartResumePdu;
import edu.nps.moves.dis7.pdus.StartResumeReliablePdu;
import edu.nps.moves.dis7.pdus.StopFreezePdu;
import edu.nps.moves.dis7.pdus.StopFreezeReliablePdu;
import edu.nps.moves.dis7.pdus.TSPIPdu;
import edu.nps.moves.dis7.pdus.TransferOwnershipPdu;
import edu.nps.moves.dis7.pdus.TransmitterPdu;
import edu.nps.moves.dis7.pdus.UnderwaterAcousticPdu;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.util.HashSet;
import java.util.Set;
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

  Set<Object> pdus = new HashSet<>();
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
        catch (Exception t) {
          throw new RuntimeException(t);
        }
      });
    }
    catch (Throwable t) {
      throwable = t;
      t.printStackTrace(System.err);
    }
    assertNull(throwable, "Exception should be null if successful marshal");
  }

  public static void main(String[] args)
  {
    new CreateAllPduTypesTest().testCreateAll();
  }
}
