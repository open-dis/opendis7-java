package edu.nps.moves.dis7.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import edu.nps.moves.dis7.enumerations.IFFSystemType;
import edu.nps.moves.dis7.enumerations.Mode5Reply;
import edu.nps.moves.dis7.pdus.FundamentalOperationalData;
import edu.nps.moves.dis7.pdus.IFFPdu;
import edu.nps.moves.dis7.pdus.IFFPduLayer3TransponderFormatData;
import edu.nps.moves.dis7.pdus.IFFPduLayer4TransponderFormatData;
import edu.nps.moves.dis7.pdus.LayerHeader;
import edu.nps.moves.dis7.pdus.Mode5TransponderBasicData;
import edu.nps.moves.dis7.pdus.Pdu;
import edu.nps.moves.dis7.pdus.SystemIdentifier;

@DisplayName("IFFPduTest")
public class IFFPduTest extends PduTest{

	/** preparation **/
    @BeforeAll
    public static void setUpClass()
    {   
        if (isVerbose())
            System.out.println("*** IFFPduTest setUpClass()");
    }
    
    @Test
	@Override
	public void testMultiplePdus() {
    	
		if (isVerbose())
            System.out.println("*** IFFPduTest testMultiplePdus()");
		
		IFFPdu iffPdu = pduFactory.makeIffPdu();
		SystemIdentifier systemID = new SystemIdentifier();
		systemID.setSystemType(IFFSystemType.MARK_X_XII_ATCRBS_TRANSPONDER);
		iffPdu.setSystemID(systemID);
		FundamentalOperationalData operationData = new FundamentalOperationalData();
		operationData.setInformationLayers(25);
		iffPdu.setFundamentalParameters(operationData);
		
		// Lets create layer 3 mode 5
		IFFPduLayer3TransponderFormatData layer3 = new IFFPduLayer3TransponderFormatData();
		LayerHeader layerHeader3 = new LayerHeader();
		layerHeader3.setLayerNumber(3);
		
		layer3.setLayerHeader(layerHeader3);
		layer3.setSiteNumber(iffPdu.getEmittingEntityId().getSiteID());
		layer3.setApplicationNumber(iffPdu.getEmittingEntityId().getApplicationID());
		
		Mode5TransponderBasicData mode5TransponderBasicData = new Mode5TransponderBasicData();
		
		IFFMode5StatusRecord.Builder builder = new IFFMode5StatusRecord.Builder();
		builder.setOnOffStatusBit(true);
		builder.setMode5Reply(Mode5Reply.INVALID);
		IFFMode5StatusRecord mode5StatusRecord = builder.build();
		
		mode5TransponderBasicData.setMode5Status(mode5StatusRecord.getAsShort());
		
		layer3.setMode5TransponderBasicData(mode5TransponderBasicData);
		iffPdu.setIFFPduLayer3TransponderFormatData(layer3);
		
		// Lets create layer 4 mode S
		IFFPduLayer4TransponderFormatData layer4 = new IFFPduLayer4TransponderFormatData();
		LayerHeader layerHeader4 = new LayerHeader();
		layerHeader4.setLayerNumber(4);
		
		layer4.setLayerHeader(layerHeader4);
		layer4.setSiteNumber(iffPdu.getEmittingEntityId().getSiteID());
		layer4.setApplicationNumber(iffPdu.getEmittingEntityId().getApplicationID());
		
		iffPdu.setIFFPduLayer4TransponderFormatData(layer4);
		
		
		testOnePdu(iffPdu);
		
		
	}

	@Override
	protected void testOnePdu(Pdu createdPdu) {
		testPduSendReceiveHeaderMatch (createdPdu); // shared tests in superclass
	     
	     // can cast PDUs at this point since PduType matched
		
		IFFPdu  createdIffPdu = (IFFPdu) createdPdu;
		IFFPdu receivedIffPdu = (IFFPdu) receivedPdus.get(0); // TODO might be more than one on receivedPdus list
		
		assertEquals (createdIffPdu.getEmittingEntityId(), receivedIffPdu.getEmittingEntityId(),"mismatched EmittingEntityId");
		assertEquals (createdIffPdu.getIFFPduLayer3TransponderFormatData(), receivedIffPdu.getIFFPduLayer3TransponderFormatData(),"mismatched IFFPduLayer3TransponderFormatData()");
		assertEquals (createdIffPdu.getIFFPduLayer4TransponderFormatData(), receivedIffPdu.getIFFPduLayer4TransponderFormatData(),"mismatched IFFPduLayer4TransponderFormatData()");
		
		IFFMode5StatusRecord mode5StatusRecordReceivedIffPdu = new IFFMode5StatusRecord.Builder(receivedIffPdu.getIFFPduLayer3TransponderFormatData().getMode5TransponderBasicData().getMode5Status()).build();
		
		assertEquals (mode5StatusRecordReceivedIffPdu.getOnOffStatusBit(), true, "mismatched mode5StatusRecord OnOffStatus bit");
		assertEquals (mode5StatusRecordReceivedIffPdu.getDamageStatusBit(), false, "mismatched mode5StatusRecord DamageStatus bit");
		assertEquals (mode5StatusRecordReceivedIffPdu.getMode5Reply(), Mode5Reply.INVALID, "mismatched mode5StatusRecord mode5Reply bits");
	}

}
