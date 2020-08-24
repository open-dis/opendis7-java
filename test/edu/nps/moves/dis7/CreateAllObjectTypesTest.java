/**
 * Copyright (c) 2008-2020, MOVES Institute, Naval Postgraduate School (NPS). All rights reserved.
 * This work is provided under a BSD open-source license, see project license.html and license.txt
 */
package edu.nps.moves.dis7;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.assertNull;

/**
 * CreateAllObjectTypes created on May 20, 2019 MOVES Institute Naval Postgraduate School, Monterey, CA, USA www.nps.edu
 *
 * @author Mike Bailey, jmbailey@edu.nps.edu
 * @version $Id$
 */
@DisplayName("All Object Types Create")
public class CreateAllObjectTypesTest
{
  @BeforeAll
  public static void beforeAllTests()
  {
    System.out.println("CreateAllObjectTypesTest");
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
  public void testCreateAllObjectTypes()
  {
    Throwable ex = null;
    try 
    {
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.ArealObject.ArealObject());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.ArealObject.Obstacle.Obstacle());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.ArealObject.Obstacle.Minefield.Minefield());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.ArealObject.Obstacle.Minefield.Hasty());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.ArealObject.Obstacle.Minefield.Other());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.ArealObject.Obstacle.Minefield.Prepared());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.ArealObject.Obstacle.Minefield.Scattered());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.ArealObject.Obstacle.Minefield.Solitary());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.ArealObject.Obstacle.Other.Other());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.LinearObject.LinearObject());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.LinearObject.Culturalfeature.Culturalfeature());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.LinearObject.Culturalfeature.TracksTire.TracksTire());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.LinearObject.Culturalfeature.Wire.Wire());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.LinearObject.Culturalfeature.Wire.WireCrush());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.LinearObject.Obstacle.Obstacle());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.LinearObject.Obstacle.ChainLinkFence.ChainLinkFence());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.LinearObject.Obstacle.ConcertinaWire.ConcertinaWire());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.LinearObject.Obstacle.ConcertinaWire.Other());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.LinearObject.Obstacle.ConcertinaWire._2Roll());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.LinearObject.Obstacle.ConcertinaWire._3Roll());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.LinearObject.Obstacle.ConcreteBarrier.ConcreteBarrier());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.LinearObject.Obstacle.Other.Other());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.LinearObject.Obstacle.Rut.Rut());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.LinearObject.Obstacle.SpeedBump.SpeedBump());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.LinearObject.Obstacle.TankDitch.TankDitch());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.LinearObject.Obstacle.TankDitch.Other());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.LinearObject.Obstaclebreach.Obstaclebreach());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.LinearObject.Obstaclebreach.Breach.Breach());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.LinearObject.Obstaclebreach.Breach.Other());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.LinearObject.Obstaclebreach.Other.Other());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.LinearObject.Obstaclemarker.Obstaclemarker());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.LinearObject.Obstaclemarker.Obstaclemarker());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.LinearObject.Obstaclemarker.MinefieldLaneMarker.MinefieldLaneMarker());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.LinearObject.Obstaclemarker.MinefieldLaneMarker.Other());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.LinearObject.Obstaclemarker.Other.Other());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.LinearObject.Tacticalsmoke.Tacticalsmoke());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.LinearObject.Tacticalsmoke.ExhaustSmoke.ExhaustSmoke());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.LinearObject.Tacticalsmoke.ExhaustSmoke.Other());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.LinearObject.Tacticalsmoke.Tacticalsmoke());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.PointObject.PointObject());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.PointObject.Culturalfeature.Culturalfeature());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.PointObject.Culturalfeature.BuildingRubble.BuildingRubble());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.PointObject.Culturalfeature.BuildingRubble.Other());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.PointObject.Culturalfeature.BuildingStructure.BuildingStructure());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.PointObject.Culturalfeature.BuildingStructure.ApartmentBuilding());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.PointObject.Culturalfeature.BuildingStructure.Church());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.PointObject.Culturalfeature.BuildingStructure.FOBGuardTower());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.PointObject.Culturalfeature.BuildingStructure.FOBTrailerOffice());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.PointObject.Culturalfeature.BuildingStructure.GovernmentBuilding());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.PointObject.Culturalfeature.BuildingStructure.GuardHouse());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.PointObject.Culturalfeature.BuildingStructure.Hanger());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.PointObject.Culturalfeature.BuildingStructure.IndustrialBuilding());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.PointObject.Culturalfeature.BuildingStructure.MicrowaveTower());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.PointObject.Culturalfeature.BuildingStructure.Other());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.PointObject.Culturalfeature.BuildingStructure.PortaPotty());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.PointObject.Culturalfeature.BuildingStructure.PowerPylon());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.PointObject.Culturalfeature.BuildingStructure.RadioTower1000ft());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.PointObject.Culturalfeature.BuildingStructure.RadioTower100ft());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.PointObject.Culturalfeature.BuildingStructure.RadioTower500ft());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.PointObject.Culturalfeature.BuildingStructure.RadioTVTower());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.PointObject.Culturalfeature.BuildingStructure.School());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.PointObject.Culturalfeature.BuildingStructure.TransformerYard());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.PointObject.Culturalfeature.BuildingStructure.Windmill());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.PointObject.Culturalfeature.ContainerBasedBuilding.ContainerBasedBuilding());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.PointObject.Culturalfeature.ContainerBasedBuilding.ContainerBasedBuildingBridgeSingle());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.PointObject.Culturalfeature.ContainerBasedBuilding.ContainerBasedBuildingFOB());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.PointObject.Culturalfeature.ContainerBasedBuilding.ContainerBasedBuildingHouseDouble());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.PointObject.Culturalfeature.ContainerBasedBuilding.ContainerBasedBuildingHouseSingle());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.PointObject.Culturalfeature.ContainerBasedBuilding.ContainerBasedBuildingHouseSingleRailing());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.PointObject.Culturalfeature.ContainerBasedBuilding.ContainerBasedBuildingMosqueSingle());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.PointObject.Culturalfeature.ContainerBasedBuilding.ContainerBasedBuildingStoreSingle());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.PointObject.Culturalfeature.DisturbedEarth.DisturbedEarth());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.PointObject.Culturalfeature.DisturbedRoad.DisturbedRoad());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.PointObject.Culturalfeature.DisturbedRoad.DisturbedRoadAsphalt());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.PointObject.Culturalfeature.DisturbedRoad.DisturbedRoadConcrete());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.PointObject.Culturalfeature.DisturbedRoad.DisturbedRoadGravel());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.PointObject.Culturalfeature.IndustrialProcessingPlant.IndustrialProcessingPlant());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.PointObject.Culturalfeature.IndustrialProcessingPlant.OilRefinery());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.PointObject.Culturalfeature.MOUTBuilding.MOUTBuilding());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.PointObject.Culturalfeature.MOUTBuilding.MOUTBuildingApartment());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.PointObject.Culturalfeature.MOUTBuilding.MOUTBuildingChurch());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.PointObject.Culturalfeature.MOUTBuilding.MOUTBuildingControlTower());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.PointObject.Culturalfeature.MOUTBuilding.MOUTBuildingFarmHouse());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.PointObject.Culturalfeature.MOUTBuilding.MOUTBuildingFireStation());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.PointObject.Culturalfeature.MOUTBuilding.MOUTBuildingGasStation());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.PointObject.Culturalfeature.MOUTBuilding.MOUTBuildingHospital());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.PointObject.Culturalfeature.MOUTBuilding.MOUTBuildingHouse());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.PointObject.Culturalfeature.MOUTBuilding.MOUTBuildingMudbrickHouse());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.PointObject.Culturalfeature.MOUTBuilding.MOUTBuildingMudbrickStore());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.PointObject.Culturalfeature.MOUTBuilding.MOUTBuildingOfficeBuilding());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.PointObject.Culturalfeature.MOUTBuilding.MOUTBuildingPoliceStation());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.PointObject.Culturalfeature.MOUTBuilding.MOUTBuildingPowerStation());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.PointObject.Culturalfeature.MOUTBuilding.MOUTBuildingSchool());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.PointObject.Culturalfeature.MOUTBuilding.MOUTBuildingStore());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.PointObject.Culturalfeature.MOUTBuilding.MOUTBuildingWarehouse());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.PointObject.Culturalfeature.MOUTBuilding.MOUTBuildingWaterTower());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.PointObject.Culturalfeature.MaintenanceStructure.MaintenanceStructure());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.PointObject.Culturalfeature.MaintenanceStructure.LargeAreaMaintenanceShelterLAMSAviationMaintenanceAM());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.PointObject.Culturalfeature.MaintenanceStructure.LargeAreaMaintenanceShelterLAMSVehicleMaintenanceVM());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.PointObject.Culturalfeature.MaintenanceStructure.LightweightMaintenanceEnclosureLMEBradley());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.PointObject.Culturalfeature.MaintenanceStructure.LightweightMaintenanceEnclosureLMEM1());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.PointObject.Culturalfeature.Other.Other());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.PointObject.Culturalfeature.Pump.Pump());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.PointObject.Culturalfeature.Pump.PumpGas());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.PointObject.Culturalfeature.Tent.Tent());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.PointObject.Culturalfeature.Tent.TentArctic());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.PointObject.Culturalfeature.Tent.TentBedouin());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.PointObject.Culturalfeature.Tent.TentChemicallyandBiologicalProtectedShelterCBPS());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.PointObject.Culturalfeature.Tent.TentExpandableFrame());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.PointObject.Culturalfeature.Tent.TentFritsche());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.PointObject.Culturalfeature.Tent.TentKuchi());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.PointObject.Culturalfeature.Tent.TentLarge());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.PointObject.Culturalfeature.Tent.TentMedium());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.PointObject.Culturalfeature.Tent.TentModularGeneralPurposeTentSystemMGPTS());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.PointObject.Culturalfeature.Tent.TentSmall());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.PointObject.Culturalfeature.Tent.TentTEMPER());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.PointObject.Culturalfeature.TreeDeciduous.TreeDeciduous());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.PointObject.Culturalfeature.TreeDeciduous.TreeDeciduousLarge());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.PointObject.Culturalfeature.TreeDeciduous.TreeDeciduousMedium());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.PointObject.Culturalfeature.TreeDeciduous.TreeDeciduousSmall());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.PointObject.Culturalfeature.TreeEvergreen.TreeEvergreen());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.PointObject.Culturalfeature.TreeEvergreen.TreeEvergreenLarge());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.PointObject.Culturalfeature.TreeEvergreen.TreeEvergreenMedium());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.PointObject.Culturalfeature.TreeEvergreen.TreeEvergreenSmall());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.PointObject.Culturalfeature.UtilityPole.UtilityPole());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.PointObject.EnvironmentalObject.EnvironmentalObject());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.PointObject.EnvironmentalObject.Flood.Flood());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.PointObject.EnvironmentalObject.Flood.FloodLarge());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.PointObject.EnvironmentalObject.Flood.FloodMedium());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.PointObject.EnvironmentalObject.Flood.FloodSmall());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.PointObject.Obstacle.Obstacle());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.PointObject.Obstacle.Abatis.Abatis());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.PointObject.Obstacle.Abatis.Other());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.PointObject.Obstacle.Abatis._14Tree());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.PointObject.Obstacle.Abatis._8Tree());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.PointObject.Obstacle.Barrier.Barrier());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.PointObject.Obstacle.Barrier.BarrierConstruction());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.PointObject.Obstacle.Barrier.BarrierFenceChain6foot());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.PointObject.Obstacle.Barrier.BarrierFenceWood6foot());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.PointObject.Obstacle.Barrier.BarrierHESCOBasketDoubleStacked());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.PointObject.Obstacle.Barrier.BarrierHESCOBasketLarge());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.PointObject.Obstacle.Barrier.BarrierHESCOBasketMedium());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.PointObject.Obstacle.Barrier.BarrierHESCOBasketSmall());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.PointObject.Obstacle.Barrier.BarrierJerseyPlastic());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.PointObject.Obstacle.Barrier.BarrierTexas());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.PointObject.Obstacle.Barrier.DragonsTeeth());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.PointObject.Obstacle.Crater.Crater());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.PointObject.Obstacle.Crater.Large());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.PointObject.Obstacle.Crater.Medium());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.PointObject.Obstacle.Crater.Other());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.PointObject.Obstacle.Crater.Small());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.PointObject.Obstacle.LogCrib.LogCrib());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.PointObject.Obstacle.LogCrib.Other());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.PointObject.Obstacle.LogCrib.Rectangular());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.PointObject.Obstacle.LogCrib.Triangular());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.PointObject.Obstacle.Other.Other());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.PointObject.Obstacle.PotHole.PotHole());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.PointObject.Obstacle.RockDrop.RockDrop());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.PointObject.Obstacle.RockDrop.RockDropCovered());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.PointObject.Obstacle.RockDrop.RockDropUncovered());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.PointObject.Obstaclemarker.Obstaclemarker());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.PointObject.Obstaclemarker.NBCHazardMarker.NBCHazardMarker());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.PointObject.Passageway.Passageway());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.PointObject.Passageway.AVLB.AVLB());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.PointObject.Passageway.AVLB.JointAssaultBridgeJAB());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.PointObject.Passageway.AVLB.M60A1());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.PointObject.Passageway.AVLB.MTU20());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.PointObject.Passageway.AVLB.Other());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.PointObject.Passageway.Other.Other());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.PointObject.Passageway.Pier.Pier());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.PointObject.Passageway.RibbonBridge.RibbonBridge());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.PointObject.Passageway.RibbonBridge.Other());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.PointObject.Passageway.RibbonBridge._2Lane());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.PointObject.Passageway.RibbonBridge._4Lane());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.PointObject.Passageway.StationaryBridge.StationaryBridge());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.PointObject.Passageway.StationaryBridge.Other());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.PointObject.Passageway.StationaryBridge._2Lane());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.PointObject.Passageway.StationaryBridge._4Lane());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.PointObject.Preparedposition.Preparedposition());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.PointObject.Preparedposition.InfantryFightingPosition.CoveredMachineGunBunker());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.PointObject.Preparedposition.InfantryFightingPosition.HastyFightingPosition());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.PointObject.Preparedposition.InfantryFightingPosition.InfantryFightingPosition());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.PointObject.Preparedposition.InfantryFightingPosition.NonCoveredInfantryPosition());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.PointObject.Preparedposition.InfantryFightingPosition.NonCoveredMachineGunBunker());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.PointObject.Preparedposition.InfantryFightingPosition.Other());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.PointObject.Preparedposition.InfantryFightingPosition.OverheadCoveredInfantryPosition());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.PointObject.Preparedposition.Other.Other());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.PointObject.Preparedposition.VehicleDefilade.ArmoredVehicle());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.PointObject.Preparedposition.VehicleDefilade.FightingVehicle());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.PointObject.Preparedposition.VehicleDefilade.MortarCarrier());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.PointObject.Preparedposition.VehicleDefilade.Other());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.PointObject.Preparedposition.VehicleDefilade.Tank());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.PointObject.Preparedposition.VehicleDefilade.VehicleDefilade());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.PointObject.Tacticalsmoke.Tacticalsmoke());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.PointObject.Tacticalsmoke.AirBurst.AirBurst());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.PointObject.Tacticalsmoke.AirBurst.Grenade());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.PointObject.Tacticalsmoke.AirBurst.Other());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.PointObject.Tacticalsmoke.GroundBurst.GroundBurst());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.PointObject.Tacticalsmoke.GroundBurst.Artillery());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.PointObject.Tacticalsmoke.GroundBurst.Other());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.PointObject.Tacticalsmoke.Other.Other());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.PointObject.Tacticalsmoke.TacticalSmokeCanister.M18Green());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.PointObject.Tacticalsmoke.TacticalSmokeCanister.M18Red());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.PointObject.Tacticalsmoke.TacticalSmokeCanister.M18Violet());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.PointObject.Tacticalsmoke.TacticalSmokeCanister.M18Yellow());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.PointObject.Tacticalsmoke.TacticalSmokeCanister.M83White());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.PointObject.Tacticalsmoke.TacticalSmokeCanister.TacticalSmokeCanister());

    }
    catch (Throwable t) {
      ex = t;
    }

    assertNull(ex, "Exception should be null if successful creation of all objects");
  }

  String formatStr = "Name: %s\tDomain: %s\tKind: %s\tCategory: %s\tSubcategory: %s";

  private void dumpObjectType(ObjectType ot)
  {
    actualDumpObjectType(ot);
  }

  private void actualDumpObjectType(ObjectType ot)
  {
    String dom = ot.getDomain().toString();
    String kind = ot.getObjectKind().toString();
    String nm = ot.getClass().getName();
    //System.out.println(String.format(formatStr, nm, dom, kind, ot.getCategory(), ot.getSubCategory()));
  }

  public static void main(String[] args)
  {
    new CreateAllObjectTypesTest().testCreateAllObjectTypes();
  }
}
