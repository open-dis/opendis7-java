/*
Copyright (c) 1995-2026 held by the author(s).  All rights reserved.

Redistribution and use in source and binary forms, with or without
modification, are permitted provided that the following conditions
are met:

    * Redistributions of source code must retain the above copyright
      notice, this list of conditions and the following disclaimer.
    * Redistributions in binary form must reproduce the above copyright
      notice, this list of conditions and the following disclaimer
      in the documentation and/or other materials provided with the
      distribution.
    * Neither the names of the Naval Postgraduate School (NPS)
      Modeling Virtual Environments and Simulation (MOVES) Institute
      https://www.nps.edu and https://www.nps.edu/web/moves
      nor the names of its contributors may be used to endorse or
      promote products derived from this software without specific
      prior written permission.

THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
"AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT
LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS
FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE
COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT,
INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING,
BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT
LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN
ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
POSSIBILITY OF SUCH DAMAGE.
*/
package edu.nps.moves.dis7.test;

import edu.nps.moves.dis7.enumerations.GriddedDataCoordinateSystem;
import edu.nps.moves.dis7.enumerations.GriddedDataConstantGrid;
import edu.nps.moves.dis7.pdus.EntityType;
import edu.nps.moves.dis7.pdus.GriddedDataPdu;
import edu.nps.moves.dis7.pdus.Pdu;
import edu.nps.moves.dis7.pdus.SimulationIdentifier;
import edu.nps.moves.dis7.pdus.SimulationAddress;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import edu.nps.moves.dis7.pdus.Domain;
import edu.nps.moves.dis7.enumerations.EntityKind;
import edu.nps.moves.dis7.enumerations.PlatformDomain;
import edu.nps.moves.dis7.enumerations.Country;

/**
 * Unit tests for satisfactory handling of Gridded Data PDU fields and values.
 */
@DisplayName("GriddedDataPduTest")
public class GriddedDataPduTest extends PduTest
{
    /** default constructor */
    public GriddedDataPduTest()
    {
        // initialization code here, but beware order dependencies with JUnit tests
    }

    /** preparation **/
    @BeforeAll
    public static void setUpClass()
    {
        if (isVerbose())
            System.out.println("*** GriddedDataPduTest setUpClass()");
    }

    /** Test PDU sending, receiving, marshalling (serialization) and unmarshalling (deserialization) */
    @Test
    @Override
    public void testMultiplePdus()
    {
        if (isVerbose())
            System.out.println("*** GriddedDataPduTest testMultiplePdus()");

        GriddedDataPdu gdPdu = pduFactory.makeGriddedDataPdu();

        gdPdu.setEnvironmentalSimulationApplicationID(new SimulationIdentifier().setSimulationAddress(new SimulationAddress().setSite(1).setApplication(2)));
        gdPdu.setFieldNumber((short) 1);
        gdPdu.setPduNumber((short) 1);
        gdPdu.setPduTotal((short) 1);
        gdPdu.setCoordinateSystem(GriddedDataCoordinateSystem.RIGHT_HANDED_CARTESIAN_LOCAL_TOPOGRAPHIC_PROJECTION_EAST_NORTH_UP);
        gdPdu.setConstantGrid(GriddedDataConstantGrid.CONSTANT_GRID);
        gdPdu.setEnvironmentType(new EntityType().setEntityKind(EntityKind.PLATFORM).setDomain(Domain.inst(PlatformDomain.LAND)).setCountry(Country.UNITED_STATES_OF_AMERICA_USA));
        testOnePdu(gdPdu);

        gdPdu.setFieldNumber((short) 2);
        gdPdu.setCoordinateSystem(GriddedDataCoordinateSystem.LATITUDE_LONGITUDE_HEIGHT);
        gdPdu.setConstantGrid(GriddedDataConstantGrid.UPDATED_GRID);
        testOnePdu(gdPdu);
    }

    @Override
    protected void testOnePdu(Pdu createdPdu)
    {
        testPduSendReceiveHeaderMatch(createdPdu);

        GriddedDataPdu  createdCast = (GriddedDataPdu) createdPdu;
        GriddedDataPdu receivedCast = (GriddedDataPdu) receivedPdus.get(0);

        assertEquals(createdCast.getEnvironmentalSimulationApplicationID(), receivedCast.getEnvironmentalSimulationApplicationID(), "mismatched EnvironmentalSimulationApplicationID");
        assertEquals(createdCast.getFieldNumber(),        receivedCast.getFieldNumber(),        "mismatched FieldNumber");
        assertEquals(createdCast.getPduNumber(),          receivedCast.getPduNumber(),          "mismatched PduNumber");
        assertEquals(createdCast.getPduTotal(),           receivedCast.getPduTotal(),           "mismatched PduTotal");
        assertEquals(createdCast.getCoordinateSystem(),   receivedCast.getCoordinateSystem(),   "mismatched CoordinateSystem");
        assertEquals(createdCast.getConstantGrid(),       receivedCast.getConstantGrid(),       "mismatched ConstantGrid");
        assertEquals(createdCast.getEnvironmentType(),    receivedCast.getEnvironmentType(),    "mismatched EnvironmentType");
        assertEquals(createdCast.getOrientation(),        receivedCast.getOrientation(),        "mismatched Orientation");
        assertEquals(createdCast.getSampleTime(),         receivedCast.getSampleTime(),         "mismatched SampleTime");
        assertEquals(createdCast.getTotalValues(),        receivedCast.getTotalValues(),        "mismatched TotalValues");
        assertEquals(createdCast.getVectorDimension(),    receivedCast.getVectorDimension(),    "mismatched VectorDimension");
        assertEquals(createdCast.getGridAxisDescriptors(), receivedCast.getGridAxisDescriptors(), "mismatched GridAxisDescriptors");
        assertEquals(createdCast.getGridDataRecords(),    receivedCast.getGridDataRecords(),    "mismatched GridDataRecords");

        testPduCommonFields(createdPdu);
    }

    /** Command-line invocation (CLI) of program, execution starts here
     * @param args command-line arguments
     */
    public static void main(String[] args)
    {
        PduTest test = new GriddedDataPduTest();
        test.setUp();
        test.testMultiplePdus();
        test.tearDown();
    }
}
