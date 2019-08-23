package edu.nps.moves.dis7;

/**
 * CreateAllObjectTypes()); created on May 20, 2019 MOVES Institute Naval Postgraduate School, Monterey, CA, USA www.nps.edu
 *
 * @author Mike Bailey, jmbailey@edu.nps.edu
 * @version $Id$
 */
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.assertNull;

@DisplayName("All Object Types Create")

public class CreateAllObjectTypesTest
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
  public void testCreateAllObjectTypes()
  {
    Throwable ex = null;
    try {

      dumpObjectType(new edu.nps.moves.dis7.objecttypes.ArealObject.ArealObject());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.ArealObject.Obstacle.Obstacle());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.ArealObject.Obstacle.Minefield.Minefield());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.ArealObject.Obstacle.Minefield.Hasty.Hasty());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.ArealObject.Obstacle.Minefield.Other.Other());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.ArealObject.Obstacle.Minefield.Prepared.Prepared());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.ArealObject.Obstacle.Minefield.Scattered.Scattered());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.ArealObject.Obstacle.Minefield.Solitary.Solitary());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.ArealObject.Obstacle.Other.Other());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.LinearObject.LinearObject());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.LinearObject.Culturalfeature.Culturalfeature());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.LinearObject.Culturalfeature.Tracks_Tire.Tracks_Tire());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.LinearObject.Culturalfeature.Wire.Wire());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.LinearObject.Culturalfeature.Wire.Wire_Crush.Wire_Crush());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.LinearObject.Obstacle.Obstacle());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.LinearObject.Obstacle.ChainLinkFence.ChainLinkFence());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.LinearObject.Obstacle.ConcertinaWire.ConcertinaWire());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.LinearObject.Obstacle.ConcertinaWire.Other.Other());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.LinearObject.Obstacle.ConcertinaWire._2_Roll._2_Roll());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.LinearObject.Obstacle.ConcertinaWire._3_Roll._3_Roll());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.LinearObject.Obstacle.ConcreteBarrier.ConcreteBarrier());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.LinearObject.Obstacle.Other.Other());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.LinearObject.Obstacle.Rut.Rut());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.LinearObject.Obstacle.SpeedBump.SpeedBump());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.LinearObject.Obstacle.TankDitch.TankDitch());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.LinearObject.Obstacle.TankDitch.Other.Other());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.LinearObject.Obstaclebreach.Obstaclebreach());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.LinearObject.Obstaclebreach.Breach.Breach());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.LinearObject.Obstaclebreach.Breach.Other.Other());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.LinearObject.Obstaclebreach.Other.Other());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.LinearObject.Obstaclemarker.Obstaclemarker());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.LinearObject.Obstaclemarker.MinefieldLaneMarker.MinefieldLaneMarker());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.LinearObject.Obstaclemarker.MinefieldLaneMarker.Other.Other());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.LinearObject.Obstaclemarker.Other.Other());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.LinearObject.Tacticalsmoke.Tacticalsmoke());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.LinearObject.Tacticalsmoke.ExhaustSmoke.ExhaustSmoke());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.LinearObject.Tacticalsmoke.ExhaustSmoke.Other.Other());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.LinearObject.Tacticalsmoke.Other.Other());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.PointObject.PointObject());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.PointObject.Culturalfeature.Culturalfeature());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.PointObject.Culturalfeature.BuildingRubble.BuildingRubble());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.PointObject.Culturalfeature.BuildingRubble.Other.Other());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.PointObject.Culturalfeature.Building_Structure.Building_Structure());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.PointObject.Culturalfeature.Building_Structure.ApartmentBuilding.ApartmentBuilding());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.PointObject.Culturalfeature.Building_Structure.Church.Church());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.PointObject.Culturalfeature.Building_Structure.FOB_GuardTower.FOB_GuardTower());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.PointObject.Culturalfeature.Building_Structure.FOB_TrailerOffice.FOB_TrailerOffice());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.PointObject.Culturalfeature.Building_Structure.GovernmentBuilding.GovernmentBuilding());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.PointObject.Culturalfeature.Building_Structure.GuardHouse.GuardHouse());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.PointObject.Culturalfeature.Building_Structure.Hanger.Hanger());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.PointObject.Culturalfeature.Building_Structure.IndustrialBuilding.IndustrialBuilding());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.PointObject.Culturalfeature.Building_Structure.MicrowaveTower.MicrowaveTower());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.PointObject.Culturalfeature.Building_Structure.Other.Other());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.PointObject.Culturalfeature.Building_Structure.PortaPotty.PortaPotty());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.PointObject.Culturalfeature.Building_Structure.PowerPylon.PowerPylon());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.PointObject.Culturalfeature.Building_Structure.RadioTower_1000ft.RadioTower_1000ft());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.PointObject.Culturalfeature.Building_Structure.RadioTower_100ft.RadioTower_100ft());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.PointObject.Culturalfeature.Building_Structure.RadioTower_500ft.RadioTower_500ft());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.PointObject.Culturalfeature.Building_Structure.Radio_TVTower.Radio_TVTower());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.PointObject.Culturalfeature.Building_Structure.School.School());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.PointObject.Culturalfeature.Building_Structure.TransformerYard.TransformerYard());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.PointObject.Culturalfeature.Building_Structure.Windmill.Windmill());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.PointObject.Culturalfeature.Container_BasedBuilding.Container_BasedBuilding());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.PointObject.Culturalfeature.Container_BasedBuilding.Container_BasedBuilding_Bridge_Single.Container_BasedBuilding_Bridge_Single());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.PointObject.Culturalfeature.Container_BasedBuilding.Container_BasedBuilding_FOB.Container_BasedBuilding_FOB());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.PointObject.Culturalfeature.Container_BasedBuilding.Container_BasedBuilding_House_Double.Container_BasedBuilding_House_Double());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.PointObject.Culturalfeature.Container_BasedBuilding.Container_BasedBuilding_House_Single.Container_BasedBuilding_House_Single());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.PointObject.Culturalfeature.Container_BasedBuilding.Container_BasedBuilding_House_Single_Railing.Container_BasedBuilding_House_Single_Railing());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.PointObject.Culturalfeature.Container_BasedBuilding.Container_BasedBuilding_Mosque_Single.Container_BasedBuilding_Mosque_Single());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.PointObject.Culturalfeature.Container_BasedBuilding.Container_BasedBuilding_Store_Single.Container_BasedBuilding_Store_Single());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.PointObject.Culturalfeature.DisturbedEarth.DisturbedEarth());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.PointObject.Culturalfeature.DisturbedRoad.DisturbedRoad());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.PointObject.Culturalfeature.DisturbedRoad.DisturbedRoad_Asphalt.DisturbedRoad_Asphalt());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.PointObject.Culturalfeature.DisturbedRoad.DisturbedRoad_Concrete.DisturbedRoad_Concrete());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.PointObject.Culturalfeature.DisturbedRoad.DisturbedRoad_Gravel.DisturbedRoad_Gravel());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.PointObject.Culturalfeature.IndustrialProcessingPlant.IndustrialProcessingPlant());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.PointObject.Culturalfeature.IndustrialProcessingPlant.OilRefinery.OilRefinery());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.PointObject.Culturalfeature.MOUTBuilding.MOUTBuilding());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.PointObject.Culturalfeature.MOUTBuilding.MOUTBuilding_Apartment.MOUTBuilding_Apartment());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.PointObject.Culturalfeature.MOUTBuilding.MOUTBuilding_Church.MOUTBuilding_Church());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.PointObject.Culturalfeature.MOUTBuilding.MOUTBuilding_ControlTower.MOUTBuilding_ControlTower());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.PointObject.Culturalfeature.MOUTBuilding.MOUTBuilding_FarmHouse.MOUTBuilding_FarmHouse());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.PointObject.Culturalfeature.MOUTBuilding.MOUTBuilding_FireStation.MOUTBuilding_FireStation());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.PointObject.Culturalfeature.MOUTBuilding.MOUTBuilding_GasStation.MOUTBuilding_GasStation());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.PointObject.Culturalfeature.MOUTBuilding.MOUTBuilding_Hospital.MOUTBuilding_Hospital());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.PointObject.Culturalfeature.MOUTBuilding.MOUTBuilding_House.MOUTBuilding_House());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.PointObject.Culturalfeature.MOUTBuilding.MOUTBuilding_MudbrickHouse.MOUTBuilding_MudbrickHouse());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.PointObject.Culturalfeature.MOUTBuilding.MOUTBuilding_MudbrickStore.MOUTBuilding_MudbrickStore());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.PointObject.Culturalfeature.MOUTBuilding.MOUTBuilding_OfficeBuilding.MOUTBuilding_OfficeBuilding());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.PointObject.Culturalfeature.MOUTBuilding.MOUTBuilding_PoliceStation.MOUTBuilding_PoliceStation());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.PointObject.Culturalfeature.MOUTBuilding.MOUTBuilding_PowerStation.MOUTBuilding_PowerStation());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.PointObject.Culturalfeature.MOUTBuilding.MOUTBuilding_School.MOUTBuilding_School());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.PointObject.Culturalfeature.MOUTBuilding.MOUTBuilding_Store.MOUTBuilding_Store());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.PointObject.Culturalfeature.MOUTBuilding.MOUTBuilding_Warehouse.MOUTBuilding_Warehouse());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.PointObject.Culturalfeature.MOUTBuilding.MOUTBuilding_WaterTower.MOUTBuilding_WaterTower());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.PointObject.Culturalfeature.MaintenanceStructure.MaintenanceStructure());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.PointObject.Culturalfeature.MaintenanceStructure.LargeAreaMaintenanceShelterLAMSAviationMaintenanceAM.LargeAreaMaintenanceShelterLAMSAviationMaintenanceAM());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.PointObject.Culturalfeature.MaintenanceStructure.LargeAreaMaintenanceShelterLAMSVehicleMaintenanceVM.LargeAreaMaintenanceShelterLAMSVehicleMaintenanceVM());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.PointObject.Culturalfeature.MaintenanceStructure.LightweightMaintenanceEnclosureLME_Bradley.LightweightMaintenanceEnclosureLME_Bradley());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.PointObject.Culturalfeature.MaintenanceStructure.LightweightMaintenanceEnclosureLME_M1.LightweightMaintenanceEnclosureLME_M1());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.PointObject.Culturalfeature.Other.Other());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.PointObject.Culturalfeature.Pump.Pump());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.PointObject.Culturalfeature.Pump.Pump_Gas.Pump_Gas());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.PointObject.Culturalfeature.Tent.Tent());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.PointObject.Culturalfeature.Tent.Tent_Arctic.Tent_Arctic());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.PointObject.Culturalfeature.Tent.Tent_Bedouin.Tent_Bedouin());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.PointObject.Culturalfeature.Tent.Tent_ChemicallyandBiologicalProtectedShelterCBPS.Tent_ChemicallyandBiologicalProtectedShelterCBPS());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.PointObject.Culturalfeature.Tent.Tent_ExpandableFrame.Tent_ExpandableFrame());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.PointObject.Culturalfeature.Tent.Tent_Fritsche.Tent_Fritsche());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.PointObject.Culturalfeature.Tent.Tent_Kuchi.Tent_Kuchi());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.PointObject.Culturalfeature.Tent.Tent_Large.Tent_Large());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.PointObject.Culturalfeature.Tent.Tent_Medium.Tent_Medium());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.PointObject.Culturalfeature.Tent.Tent_ModularGeneralPurposeTentSystemMGPTS.Tent_ModularGeneralPurposeTentSystemMGPTS());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.PointObject.Culturalfeature.Tent.Tent_Small.Tent_Small());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.PointObject.Culturalfeature.Tent.Tent_TEMPER.Tent_TEMPER());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.PointObject.Culturalfeature.Tree_Deciduous.Tree_Deciduous());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.PointObject.Culturalfeature.Tree_Deciduous.Tree_Deciduous_Large.Tree_Deciduous_Large());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.PointObject.Culturalfeature.Tree_Deciduous.Tree_Deciduous_Medium.Tree_Deciduous_Medium());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.PointObject.Culturalfeature.Tree_Deciduous.Tree_Deciduous_Small.Tree_Deciduous_Small());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.PointObject.Culturalfeature.Tree_Evergreen.Tree_Evergreen());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.PointObject.Culturalfeature.Tree_Evergreen.Tree_Evergreen_Large.Tree_Evergreen_Large());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.PointObject.Culturalfeature.Tree_Evergreen.Tree_Evergreen_Medium.Tree_Evergreen_Medium());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.PointObject.Culturalfeature.Tree_Evergreen.Tree_Evergreen_Small.Tree_Evergreen_Small());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.PointObject.Culturalfeature.UtilityPole.UtilityPole());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.PointObject.EnvironmentalObject.EnvironmentalObject());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.PointObject.EnvironmentalObject.Flood.Flood());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.PointObject.EnvironmentalObject.Flood.Flood_Large.Flood_Large());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.PointObject.EnvironmentalObject.Flood.Flood_Medium.Flood_Medium());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.PointObject.EnvironmentalObject.Flood.Flood_Small.Flood_Small());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.PointObject.Obstacle.Obstacle());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.PointObject.Obstacle.Abatis.Abatis());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.PointObject.Obstacle.Abatis.Other.Other());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.PointObject.Obstacle.Abatis._14Tree._14Tree());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.PointObject.Obstacle.Abatis._8Tree._8Tree());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.PointObject.Obstacle.Barrier.Barrier());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.PointObject.Obstacle.Barrier.Barrier_Construction.Barrier_Construction());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.PointObject.Obstacle.Barrier.Barrier_Fence_Chain_6_foot.Barrier_Fence_Chain_6_foot());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.PointObject.Obstacle.Barrier.Barrier_Fence_Wood_6_foot.Barrier_Fence_Wood_6_foot());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.PointObject.Obstacle.Barrier.Barrier_HESCOBasket_Double_Stacked.Barrier_HESCOBasket_Double_Stacked());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.PointObject.Obstacle.Barrier.Barrier_HESCOBasket_Large.Barrier_HESCOBasket_Large());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.PointObject.Obstacle.Barrier.Barrier_HESCOBasket_Medium.Barrier_HESCOBasket_Medium());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.PointObject.Obstacle.Barrier.Barrier_HESCOBasket_Small.Barrier_HESCOBasket_Small());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.PointObject.Obstacle.Barrier.Barrier_Jersey_Plastic.Barrier_Jersey_Plastic());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.PointObject.Obstacle.Barrier.Barrier_Texas.Barrier_Texas());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.PointObject.Obstacle.Barrier.DragonsTeeth.DragonsTeeth());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.PointObject.Obstacle.Crater.Crater());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.PointObject.Obstacle.Crater.Large.Large());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.PointObject.Obstacle.Crater.Medium.Medium());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.PointObject.Obstacle.Crater.Other.Other());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.PointObject.Obstacle.Crater.Small.Small());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.PointObject.Obstacle.LogCrib.LogCrib());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.PointObject.Obstacle.LogCrib.Other.Other());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.PointObject.Obstacle.LogCrib.Rectangular.Rectangular());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.PointObject.Obstacle.LogCrib.Triangular.Triangular());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.PointObject.Obstacle.Other.Other());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.PointObject.Obstacle.PotHole.PotHole());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.PointObject.Obstacle.RockDrop.RockDrop());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.PointObject.Obstacle.RockDrop.RockDrop_Covered.RockDrop_Covered());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.PointObject.Obstacle.RockDrop.RockDrop_Uncovered.RockDrop_Uncovered());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.PointObject.Obstaclemarker.Obstaclemarker());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.PointObject.Obstaclemarker.NBCHazardMarker.NBCHazardMarker());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.PointObject.Passageway.Passageway());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.PointObject.Passageway.AVLB.AVLB());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.PointObject.Passageway.AVLB.JointAssaultBridgeJAB.JointAssaultBridgeJAB());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.PointObject.Passageway.AVLB.M60A1.M60A1());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.PointObject.Passageway.AVLB.MTU20.MTU20());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.PointObject.Passageway.AVLB.Other.Other());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.PointObject.Passageway.Other.Other());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.PointObject.Passageway.Pier.Pier());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.PointObject.Passageway.RibbonBridge.RibbonBridge());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.PointObject.Passageway.RibbonBridge.Other.Other());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.PointObject.Passageway.RibbonBridge._2_Lane._2_Lane());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.PointObject.Passageway.RibbonBridge._4_Lane._4_Lane());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.PointObject.Passageway.StationaryBridge.StationaryBridge());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.PointObject.Passageway.StationaryBridge.Other.Other());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.PointObject.Passageway.StationaryBridge._2_Lane._2_Lane());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.PointObject.Passageway.StationaryBridge._4_Lane._4_Lane());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.PointObject.Preparedposition.Preparedposition());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.PointObject.Preparedposition.InfantryFightingPosition.InfantryFightingPosition());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.PointObject.Preparedposition.InfantryFightingPosition.CoveredMachineGunBunker.CoveredMachineGunBunker());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.PointObject.Preparedposition.InfantryFightingPosition.HastyFightingPosition.HastyFightingPosition());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.PointObject.Preparedposition.InfantryFightingPosition.Non_CoveredInfantryPosition.Non_CoveredInfantryPosition());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.PointObject.Preparedposition.InfantryFightingPosition.Non_CoveredMachineGunBunker.Non_CoveredMachineGunBunker());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.PointObject.Preparedposition.InfantryFightingPosition.Other.Other());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.PointObject.Preparedposition.InfantryFightingPosition.OverheadCoveredInfantryPosition.OverheadCoveredInfantryPosition());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.PointObject.Preparedposition.Other.Other());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.PointObject.Preparedposition.VehicleDefilade.VehicleDefilade());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.PointObject.Preparedposition.VehicleDefilade.ArmoredVehicle.ArmoredVehicle());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.PointObject.Preparedposition.VehicleDefilade.FightingVehicle.FightingVehicle());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.PointObject.Preparedposition.VehicleDefilade.MortarCarrier.MortarCarrier());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.PointObject.Preparedposition.VehicleDefilade.Other.Other());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.PointObject.Preparedposition.VehicleDefilade.Tank.Tank());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.PointObject.Tacticalsmoke.Tacticalsmoke());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.PointObject.Tacticalsmoke.AirBurst.AirBurst());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.PointObject.Tacticalsmoke.AirBurst.Grenade.Grenade());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.PointObject.Tacticalsmoke.AirBurst.Other.Other());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.PointObject.Tacticalsmoke.GroundBurst.GroundBurst());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.PointObject.Tacticalsmoke.GroundBurst.Artillery.Artillery());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.PointObject.Tacticalsmoke.GroundBurst.Other.Other());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.PointObject.Tacticalsmoke.Other.Other());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.PointObject.Tacticalsmoke.TacticalSmoke_Canister.TacticalSmoke_Canister());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.PointObject.Tacticalsmoke.TacticalSmoke_Canister.M18_Green.M18_Green());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.PointObject.Tacticalsmoke.TacticalSmoke_Canister.M18_Red.M18_Red());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.PointObject.Tacticalsmoke.TacticalSmoke_Canister.M18_Violet.M18_Violet());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.PointObject.Tacticalsmoke.TacticalSmoke_Canister.M18_Yellow.M18_Yellow());
      dumpObjectType(new edu.nps.moves.dis7.objecttypes.PointObject.Tacticalsmoke.TacticalSmoke_Canister.M83_White.M83_White());

    }
    catch (Throwable t) {
      ex = t;
    }

    //temp assertNull(ex, "Exception should be null if successful creation of all objects");
  }

  String formatStr = "Name: %s\tDomain: %s\tKind: %s\tCategory: %s\tSubcategory: %s";

  private void dumpObjectType(ObjectType ot)
  {
    actualDumpObjectType(ot);
  }

  private void actualDumpObjectType(ObjectType ot)
  {
    String dom = ot.getDomain().toString();
    String kind = ot.getObjectKind().toString();;
    String nm = ot.getClass().getName();
    System.out.println(String.format(formatStr, nm, dom, kind, ot.getCategory(), ot.getSubCategory()));
  }

  public static void main(String[] args)
  {
    new CreateAllObjectTypesTest().testCreateAllObjectTypes();
  }
}
