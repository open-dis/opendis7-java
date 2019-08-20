package edu.nps.moves.dis7;

/**
 *
 * @author Mike Bailey, jmbailey@edu.nps.edu
 * @version $Id$
 */

import edu.nps.moves.dis7.enumerations.Country;
import edu.nps.moves.dis7.util.PduFactory;
import java.util.Arrays;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.assertNull;

@DisplayName("PduFactory All Pdus Create")

public class TestPduFactory1
{
    @BeforeAll
    public static void beforeAllTests()
    {
    }

    @AfterAll
    public static void afterAllTests()
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

    @Test
    public void testCreateAllPdus()
    {
        Throwable ex = null;
        try {
            //Arrays.stream(PduFactory.class.getDeclaredMethods()).forEach(m->System.out.println(m.getName()));
            PduFactory fact = new PduFactory(Country.PHILIPPINES_PHL, (byte) 11, (byte) 22, (short) 33, true);

            fact.makeAcknowledgePdu();
            fact.makeAcknowledgeReliablePdu();
            fact.makeActionRequestPdu();
            fact.makeActionRequestReliablePdu();
            fact.makeActionResponsePdu();
            fact.makeActionResponseReliablePdu();
            fact.makeAggregateStatePdu();
            fact.makeAppearancePdu();
            fact.makeArealObjectStatePdu();
            fact.makeArticulatedPartsPdu();
            fact.makeAttributePdu();
            fact.makeCollisionElasticPdu();
            fact.makeCollisionPdu();
            fact.makeCommentPdu();
            fact.makeCommentReliablePdu();
            fact.makeCreateEntityPdu();
            fact.makeCreateEntityReliablePdu();
            fact.makeDataPdu();
            fact.makeDataQueryPdu();
            fact.makeDataQueryReliablePdu();
            fact.makeDataReliablePdu();
            fact.makeDesignatorPdu();
            fact.makeDetonationPdu();
            fact.makeDirectedEnergyFirePdu();
            fact.makeElectronicEmissionsPdu();
            fact.makeEntityDamageStatusPdu();
            fact.makeEntityStatePdu();
            fact.makeEntityStateUpdatePdu();
            fact.makeEnvironmentalProcessPdu();
            fact.makeEventReportPdu();
            fact.makeEventReportReliablePdu();
            fact.makeFirePdu();
            fact.makeGriddedDataPdu();
            fact.makeIffPdu();
            fact.makeInformationOperationsReportPdu();
            fact.makeInformationOperationsActionPdu();
            fact.makeIntercomControlPdu();
            fact.makeIntercomSignalPdu();
            fact.makeIsGroupOfPdu();
            fact.makeIsPartOfPdu();
            fact.makeLEDetonationPdu();
            fact.makeLEFirePdu();
            fact.makeLinearObjectStatePdu();
            fact.makeMinefieldDataPdu();
            fact.makeMinefieldQueryPdu();
            fact.makeMinefieldResponseNackPdu();
            fact.makeMinefieldStatePdu();
            fact.makePointObjectStatePdu();
            fact.makeReceiverPdu();
            fact.makeRecordQueryReliablePdu();
            fact.makeRecordReliablePdu();
            fact.makeRemoveEntityPdu();
            fact.makeRemoveEntityReliablePdu();
            fact.makeRepairCompletePdu();
            fact.makeRepairResponsePdu();
            fact.makeResupplyCancelPdu();
            fact.makeResupplyOfferPdu();
            fact.makeResupplyReceivedPdu();
            fact.makeSeesPdu();
            fact.makeServiceRequestPdu();
            fact.makeSetDataPdu();
            fact.makeSetDataReliablePdu();
            fact.makeSetRecordReliablePdu();
            fact.makeSignalPdu();
            fact.makeStartResumePdu();
            fact.makeStartResumeReliablePdu();
            fact.makeStopFreezePdu();
            fact.makeStopFreezeReliablePdu();
            fact.makeTransferOwnershipPdu();
            fact.makeTransmitterPdu();
            fact.makeTspiPdu();
            fact.makeUnderwaterAcousticPdu(); 
        }
        catch (Throwable t) {
            ex = t;
            System.out.println(t.getLocalizedMessage());
            t.printStackTrace();
        }

        assertNull(ex, "Exception should be null if successful creation of all objects");
    }

    String formatStr = "Name: %s\tDomain: %s\tKind: %s\tCategory: %s\tSubcategory: %s";

    private void dumpObjectType(ObjectType ot)
    {
    }

    private void actualDumpObjectType(ObjectType ot)
    {
        String dom = ot.getDomain().toString();
        String kind = ot.getObjectKind().toString();;
        String nm = ot.getClass().getName();
        System.out.println(String.format(formatStr, nm, dom, kind, ot.getCategory(), ot.getSubCategory()));
    }

}
