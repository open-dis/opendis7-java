/**
 * Copyright (c) 2008-2021, MOVES Institute, Naval Postgraduate School (NPS). All rights reserved.
 * This work is provided under a BSD open-source license, see project license.html and license.txt
 */
package edu.nps.moves.dis7;

import edu.nps.moves.dis7.enumerations.*;
import edu.nps.moves.dis7.pdus.DisBitSet;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@DisplayName("Marshal Enums Test")
public class MarshalEnumsTest
{
  @BeforeAll
  public static void setUpClass()
  {
    System.out.println("MarshalEnumsTest");
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

  @Test
  public void testGoodMarshall()
  {
    Throwable thr = null;
    try {
      marshalOne(APAParameterIndexAPAStatus.values()[0]);
      marshalOne(AcknowledgeAcknowledgeFlag.values()[0]);
      marshalOne(AcknowledgeResponseFlag.values()[0]);
      // this is a simple enum, never marshalled marshalOne(Acronyms.values()[0]);
      marshalOne(ActionRequestActionID.values()[0]);
      marshalOne(ActionResponseRequestStatus.values()[0]);
      marshalOne(AddSpecificDimensionEnumerationsforSubsurfaceAreaSize.values()[0]);
      marshalOne(AddVariantsforAirCategory201Insect.values()[0]);
      marshalOne(AddVariantsforLandCategory200Mammal.values()[0]);
      marshalOne(AddVariantsforSubsurfaceCategoriesFishMolluskCrustaceanandInsect.values()[0]);
      marshalOne(AggregateStateAggregateKind.values()[0]);
      marshalOne(AggregateStateAggregateState.values()[0]);
      marshalOne(AggregateStateFormation.values()[0]);
      marshalOne(AggregateStateSpecific.values()[0]);
      marshalOne(AggregateStateSubcategory.values()[0]);

      marshalOne(AircraftAddressSource.values()[0]);
      marshalOne(AircraftIdentificationType.values()[0]);
      marshalOne(AircraftPresentDomain.values()[0]);
      marshalOne(AircraftTypeWake.values()[0]);
      marshalOne(AnimalLifeformGroupSizeRangeEnumerationforallDomains.values()[0]);
      marshalOne(AntennaSelection.values()[0]);
      marshalOne(AntennaStatus.values()[0]);
      marshalOne(AppearanceAntiCollisionDayNight.values()[0]);
      marshalOne(AppearanceCamouflageType.values()[0]);
      marshalOne(AppearanceCanopy.values()[0]);
      marshalOne(AppearanceConcealedMovement.values()[0]);
      marshalOne(AppearanceConcealedPosition.values()[0]);
      marshalOne(AppearanceDamage.values()[0]);
      marshalOne(AppearanceEntityorObjectState.values()[0]);
      marshalOne(AppearanceEnvironmentalDensity.values()[0]);
      marshalOne(AppearanceHatch.values()[0]);
      marshalOne(AppearanceLauncherOperational.values()[0]);
      marshalOne(AppearanceLifeFormComplianceStatus.values()[0]);
      marshalOne(AppearanceLifeFormPosture.values()[0]);
      marshalOne(AppearanceLifeFormWeaponImplement.values()[0]);
      marshalOne(AppearanceLifeformHealth.values()[0]);
      marshalOne(AppearanceLinearObjectLaneMarkerVisible.values()[0]);
      marshalOne(AppearanceLinearObjectTankDitchBreach.values()[0]);
      marshalOne(AppearanceNVGMode.values()[0]);
      marshalOne(AppearanceNavigationPositionBrightness.values()[0]);
      marshalOne(AppearanceObjectGeneralDamage.values()[0]);
      marshalOne(AppearanceObjectGeneralIEDPresent.values()[0]);
      marshalOne(AppearanceObjectGeneralPredistributed.values()[0]);
      marshalOne(AppearanceObjectSpecificBreachState.values()[0]);
      marshalOne(AppearanceObjectSpecificChemicalType.values()[0]);
      marshalOne(AppearancePaintScheme.values()[0]);
      marshalOne(AppearanceSubsurfaceHatch.values()[0]);
      marshalOne(AppearanceSupplyDeployed.values()[0]);
      marshalOne(AppearanceTrailingEffects.values()[0]);

      marshalOne(ArticulatedPartsTypeClass.values()[0]);
      marshalOne(ArticulatedPartsTypeMetric.values()[0]);
      marshalOne(AttachedPartDetachedIndicator.values()[0]);
      marshalOne(AttachedParts.values()[0]);
      marshalOne(AustralianCategoryOverlay.values()[0]);
      marshalOne(BeamStatusBeamState.values()[0]);
      marshalOne(BuildingPaintScheme.values()[0]);
      marshalOne(CCTTSINCGARSClearChannel.values()[0]);
      marshalOne(CCTTSINCGARSStartofMessage.values()[0]);
      marshalOne(CIGIExtensionPacketID.values()[0]);
      marshalOne(CapabilityReport.values()[0]);
      marshalOne(Class10SupplyCategoryMaterialtoSupportNonMilitaryPrograms.values()[0]);
      marshalOne(Class11SupplyCategorySuppliesNonDoctrinal.values()[0]);
      marshalOne(Class12SupplyCategorySlingLoadsNonDoctrinal.values()[0]);
      marshalOne(Class1SupplyCategorySubsistence.values()[0]);
      marshalOne(Class2SupplyCategoryClothingIndividualEquipmentToolsAdminSupplies.values()[0]);
      marshalOne(Class3SupplyCategoryPetroleumOilsLubricants.values()[0]);
      marshalOne(Class4SupplyCategoryConstructionMaterials.values()[0]);
      marshalOne(Class6SupplyCategoryPersonnelDemandItems.values()[0]);
      marshalOne(Class7SupplyCategoryMajorItems.values()[0]);
      marshalOne(Class8SupplyCategoryMedicalMaterial.values()[0]);
      marshalOne(Class9SupplyCategoryRepairPartsandComponents.values()[0]);
      marshalOne(CollisionType.values()[0]);
      marshalOne(Color.values()[0]);
      marshalOne(ComponentVisualDamageStatusSmoke.values()[0]);
      marshalOne(ComponentVisualDamageStatusSurfaceDamage.values()[0]);
      marshalOne(Country.values()[0]);
      marshalOne(CoverShroudStatus.values()[0]);
      marshalOne(CryptoKeyIDCryptoMode.values()[0]);

      marshalOne(DEDamageDescriptionComponentDamageStatus.values()[0]);

      marshalOne(DEDamageDescriptionComponentVisualSmokeColor.values()[0]);

      marshalOne(DEFireFlagsStateUpdateFlag.values()[0]);
      marshalOne(DEFirePulseShape.values()[0]);
      marshalOne(DEPrecisionAimpointBeamSpotType.values()[0]);
      marshalOne(DISAttributeActionCode.values()[0]);
      marshalOne(DISLiveEntitySubprotocolNumber.values()[0]);
      marshalOne(DISPDUStatusActiveInterrogationIndicatorAII.values()[0]);
      marshalOne(DISPDUStatusCoupledExtensionIndicatorCEI.values()[0]);
      marshalOne(DISPDUStatusDetonationTypeIndicatorDTI.values()[0]);
      marshalOne(DISPDUStatusFireTypeIndicatorFTI.values()[0]);
      marshalOne(DISPDUStatusIFFSimulationModeISM.values()[0]);
      marshalOne(DISPDUStatusIntercomAttachedIndicatorIAI.values()[0]);
      marshalOne(DISPDUStatusLVCIndicatorLVC.values()[0]);
      marshalOne(DISPDUStatusRadioAttachedIndicatorRAI.values()[0]);
      marshalOne(DISPDUStatusTransferredEntityIndicatorTEI.values()[0]);
      marshalOne(DISPDUType.values()[0]);
      marshalOne(DISProtocolFamily.values()[0]);
      marshalOne(DISProtocolVersion.values()[0]);
      marshalOne(DRParametersType.values()[0]);
      marshalOne(DataCategory.values()[0]);
      marshalOne(DeadReckoningAlgorithm.values()[0]);
      marshalOne(DeltaMode5SAltitudePositiveNegativeIndicator.values()[0]);
      marshalOne(DesignatorDesignatorCode.values()[0]);
      marshalOne(DesignatorSystemName.values()[0]);
      marshalOne(DetonationResult.values()[0]);
      marshalOne(EEAttributeStateIndicator.values()[0]);
      marshalOne(ElectromagneticEmissionBeamFunction.values()[0]);
      marshalOne(ElectromagneticEmissionStateUpdateIndicator.values()[0]);
      marshalOne(EmitterName.values()[0]);
      marshalOne(EmitterSystemFunction.values()[0]);
      marshalOne(EntityAssociationAssociationStatus.values()[0]);
      marshalOne(EntityAssociationAssociationType.values()[0]);
      marshalOne(EntityAssociationGroupMemberType.values()[0]);
      marshalOne(EntityAssociationPhysicalAssociationType.values()[0]);
      marshalOne(EntityAssociationPhysicalConnectionType.values()[0]);
      marshalOne(EntityDamageStatusComponentIdentification.values()[0]);
      marshalOne(EntityKind.values()[0]);
      marshalOne(EntityMarkingCharacterSet.values()[0]);
      marshalOne(EntityVPRecordChangeIndicator.values()[0]);
      marshalOne(EnvironmentRecordTypeGroups.values()[0]);

      marshalOne(EnvironmentalProcessModelType.values()[0]);
      marshalOne(EnvironmentalProcessRecordType.values()[0]);
      marshalOne(EnvironmentalSubcategory.values()[0]);
      marshalOne(EventReportEventType.values()[0]);
      marshalOne(ExpendableAirCategory.values()[0]);

      marshalOne(ExpendableSubsurfaceCategory.values()[0]);
      marshalOne(ExpendableSurfaceCategory.values()[0]);
      marshalOne(ExplosiveMaterialCategories.values()[0]);
      marshalOne(ExplosiveMaterialGroups.values()[0]);
      marshalOne(FlareSmokeColor.values()[0]);
      marshalOne(FlareSmokeStatus.values()[0]);
      marshalOne(ForceID.values()[0]);
      marshalOne(FormatType.values()[0]);
      marshalOne(FuelLocation.values()[0]);
      marshalOne(FuelMeasurementUnits.values()[0]);
      marshalOne(GridAxisDescriptorAxisType.values()[0]);
      marshalOne(GriddedDataConstantGrid.values()[0]);
      marshalOne(GriddedDataCoordinateSystem.values()[0]);
      marshalOne(GriddedDataDataRepresentation.values()[0]);
      marshalOne(GriddedDataFieldNumber.values()[0]);
      marshalOne(GriddedDataSampleType.values()[0]);
      marshalOne(HighDensityTrackJam.values()[0]);
      marshalOne(HighFidelityHAVEQUICKTODTransmitIndicator.values()[0]);
      marshalOne(IFFAlternateMode4ChallengeReply.values()[0]);
      marshalOne(IFFApplicableModes.values()[0]);
      marshalOne(IFFDataRecordAvailable.values()[0]);
      marshalOne(IFFLayerSpecificInformation.values()[0]);
      marshalOne(IFFSimulationMode.values()[0]);
      marshalOne(IFFSystemMode.values()[0]);
      marshalOne(IFFSystemName.values()[0]);
      marshalOne(IFFSystemType.values()[0]);
      marshalOne(IFFSystemType1OperationalParameter1.values()[0]);
      marshalOne(IFFSystemType1OperationalParameter2.values()[0]);
      marshalOne(IOActionIOActionPhase.values()[0]);
      marshalOne(IOActionIOActionType.values()[0]);
      marshalOne(IOActionIOSimulationSource.values()[0]);
      marshalOne(IOActionIOWarfareType.values()[0]);
      marshalOne(IOCommsNodeRecordCommsNodeType.values()[0]);
      marshalOne(IOEffectsRecordIOEffect.values()[0]);
      marshalOne(IOEffectsRecordIOLinkType.values()[0]);
      marshalOne(IOEffectsRecordIOProcess.values()[0]);
      marshalOne(IOEffectsRecordIOStatus.values()[0]);
      marshalOne(IOReportIOReportType.values()[0]);
      marshalOne(ISLSAntennaType.values()[0]);
      marshalOne(IntercomControlCommand.values()[0]);
      marshalOne(IntercomControlCommunicationsClass.values()[0]);
      marshalOne(IntercomControlCommunicationsType.values()[0]);
      marshalOne(IntercomControlControlType.values()[0]);
      marshalOne(IntercomControlDestinationLineStateCommand.values()[0]);
      marshalOne(IntercomControlRecordType.values()[0]);
      marshalOne(IntercomControlTransmitLineState.values()[0]);
      marshalOne(IsGroupOfGroupedEntityCategory.values()[0]);
      marshalOne(IsGroupOfRestStatus.values()[0]);
      marshalOne(IsPartOfNature.values()[0]);
      marshalOne(IsPartOfPosition.values()[0]);
      marshalOne(IsPartOfStationName.values()[0]);
      marshalOne(IslandSubcategory.values()[0]);
      marshalOne(JTIDSMIDSModulationParametersSynchronizationState.values()[0]);
      marshalOne(JTIDSMIDSModulationParametersTransmittingTerminalPrimaryMode.values()[0]);
      marshalOne(JTIDSMIDSModulationParametersTransmittingTerminalSecondaryMode.values()[0]);

      marshalOne(LeafCoverage.values()[0]);
      marshalOne(Level2SquitterStatus.values()[0]);
      marshalOne(LifeFormAirCategories.values()[0]);
      marshalOne(LifeFormCategoriesUS.values()[0]);
      marshalOne(LifeFormExtraPersonalData.values()[0]);
      marshalOne(LifeFormHumanSpecificAntiMaterielRifles.values()[0]);
      marshalOne(LifeFormHumanSpecificAntiTankMissiles.values()[0]);
      marshalOne(LifeFormHumanSpecificAntiTankRockets.values()[0]);
      marshalOne(LifeFormHumanSpecificAssaultRifles.values()[0]);
      marshalOne(LifeFormHumanSpecificDroneGuns.values()[0]);
      marshalOne(LifeFormHumanSpecificEquipmentClass.values()[0]);
      marshalOne(LifeFormHumanSpecificFlameRockets.values()[0]);
      marshalOne(LifeFormHumanSpecificFlameThrowers.values()[0]);
      marshalOne(LifeFormHumanSpecificGrenadeLaunchers.values()[0]);
      marshalOne(LifeFormHumanSpecificGrenadeLaunchingMachineGun.values()[0]);
      marshalOne(LifeFormHumanSpecificHandGuns.values()[0]);
      marshalOne(LifeFormHumanSpecificHighPowerRifles.values()[0]);
      marshalOne(LifeFormHumanSpecificMachineGuns.values()[0]);
      marshalOne(LifeFormHumanSpecificManPortableAirDefenseSystem.values()[0]);
      marshalOne(LifeFormHumanSpecificMortars.values()[0]);
      marshalOne(LifeFormHumanSpecificRecoillessRifles.values()[0]);
      marshalOne(LifeFormHumanSpecificShotGuns.values()[0]);
      marshalOne(LifeFormHumanSpecificSniper.values()[0]);
      marshalOne(LifeFormHumanSpecificSubMachineGun.values()[0]);
      marshalOne(LifeFormHumanSpecificWeaponNonspecific.values()[0]);
      marshalOne(LifeFormHumanSubcategoryEquipmentClass.values()[0]);
      marshalOne(LifeFormLandCategories.values()[0]);
      marshalOne(LifeFormSubsurfaceCategories.values()[0]);

      marshalOne(LifeFormsSubcategoryCISWeapons.values()[0]);
      marshalOne(LifeFormsSubcategoryFrenchWeapons.values()[0]);
      marshalOne(LifeFormsSubcategoryGermanWeapons.values()[0]);
      marshalOne(LifeFormsSubcategoryIranianWeapons.values()[0]);
      marshalOne(LifeFormsSubcategoryUKWeapons.values()[0]);
      marshalOne(LifeFormsSubcategoryUSWeapons.values()[0]);
      marshalOne(LifeSavingEquipment.values()[0]);

      marshalOne(Link1111BDataTerminalSetIndicator.values()[0]);
      marshalOne(Link1111BFidelityLevel.values()[0]);
      marshalOne(Link1111BModeofOperation.values()[0]);
      marshalOne(Link1111BTerminalMode.values()[0]);
      marshalOne(Material.values()[0]);
      marshalOne(MinefieldAppearanceActiveStatus.values()[0]);
      marshalOne(MinefieldAppearanceLane.values()[0]);
      marshalOne(MinefieldAppearanceMinefieldType.values()[0]);
      marshalOne(MinefieldAppearanceState.values()[0]);

      marshalOne(MinefieldFusingFuseType.values()[0]);
      marshalOne(MinefieldPaintSchemeAlgae.values()[0]);
      marshalOne(MinefieldPaintSchemePaintScheme.values()[0]);
      marshalOne(MinefieldSensorTypes.values()[0]);
      marshalOne(MinefieldSensorTypesFLIR.values()[0]);
      marshalOne(MinefieldSensorTypesLaser.values()[0]);
      marshalOne(MinefieldSensorTypesMagnetic.values()[0]);
      marshalOne(MinefieldSensorTypesMultispectral.values()[0]);
      marshalOne(MinefieldSensorTypesOptical.values()[0]);
      marshalOne(MinefieldSensorTypesPhysical.values()[0]);
      marshalOne(MinefieldSensorTypesRADAR.values()[0]);
      marshalOne(MinefieldSensorTypesSONAR.values()[0]);

      marshalOne(MinefieldStateProtocolMode.values()[0]);
      marshalOne(Mode5IFFMission.values()[0]);
      marshalOne(Mode5LevelSelection.values()[0]);
      marshalOne(Mode5LocationErrors.values()[0]);
      marshalOne(Mode5MessageFormatsStatus.values()[0]);
      marshalOne(Mode5PlatformType.values()[0]);
      marshalOne(Mode5Reply.values()[0]);
      marshalOne(Mode5SAltitudeResolution.values()[0]);
      marshalOne(Mode5SquitterType.values()[0]);
      marshalOne(ModeCAltitudeIndicator.values()[0]);
      marshalOne(ModeSInterrogatorIdentifierICType.values()[0]);
      marshalOne(ModeSInterrogatorStatusTransmitState.values()[0]);
      marshalOne(ModeSSquitterRecordSource.values()[0]);
      marshalOne(ModeSSquitterType.values()[0]);

      marshalOne(MunitionCategory.values()[0]);
      marshalOne(MunitionDescriptorFuse.values()[0]);
      marshalOne(MunitionDescriptorWarhead.values()[0]);
      marshalOne(MunitionDomain.values()[0]);
      marshalOne(MunitionExpendableStatus.values()[0]);
      marshalOne(NETIDRecordFrequencyTable.values()[0]);
      marshalOne(NETIDRecordMode.values()[0]);
      marshalOne(NavigationSource.values()[0]);

      marshalOne(ObjectKind.values()[0]);

      marshalOne(OwnershipStatus.values()[0]);
      marshalOne(Parachute.values()[0]);
      marshalOne(PhysicalAssociationTypeGroups.values()[0]);
      marshalOne(PlatformAirCategory.values()[0]);
      marshalOne(PlatformAirCivilianFixedWingAircraftSubcategories.values()[0]);
      marshalOne(PlatformAirCivilianGliderSubcategories.values()[0]);
      marshalOne(PlatformAirCivilianHelicopterSubcategories.values()[0]);
      marshalOne(PlatformAirCivilianLighterthanAirAirshipSubcategories.values()[0]);
      marshalOne(PlatformAirCivilianLighterthanAirBalloonSubcategories.values()[0]);
      marshalOne(PlatformAirCivilianUltralightNonrigidWingAircraftSubcategories.values()[0]);
      marshalOne(PlatformAirCivilianUltralightRigidWingAircraftSubcategories.values()[0]);
      marshalOne(PlatformDomain.values()[0]);
      marshalOne(PlatformLandBusSubcategories.values()[0]);
      marshalOne(PlatformLandCarSubcategories.values()[0]);
      marshalOne(PlatformLandCategory.values()[0]);
      marshalOne(PlatformLandConstructionSpecialtyVehicleSubcategories.values()[0]);
      marshalOne(PlatformLandFarmSpecialtyVehicleSubcategories.values()[0]);
      marshalOne(PlatformLandMotorcycleSubcategories.values()[0]);
      marshalOne(PlatformLandMultipleUnitCargoTruckSubcategories.values()[0]);
      marshalOne(PlatformLandMultipleUnitUtilityEmergencyTruckSubcategories.values()[0]);
      marshalOne(PlatformLandNonmotorizedSubcategories.values()[0]);
      marshalOne(PlatformLandRecreationalSubcategories.values()[0]);
      marshalOne(PlatformLandSingleUnitCargoTruckSubcategories.values()[0]);
      marshalOne(PlatformLandSingleUnitUtilityEmergencyTruckSubcategories.values()[0]);
      marshalOne(PlatformLandTrailerSubcategories.values()[0]);
      marshalOne(PlatformLandTrainsSubcategories.values()[0]);
      marshalOne(PlatformLandUtilityEmergencyCarSubcategories.values()[0]);
      marshalOne(PlatformSpaceCategory.values()[0]);
      marshalOne(PlatformSubsurfaceCategory.values()[0]);
      marshalOne(PlatformSubsurfaceCivilianSemiSubmersiblesSubcategories.values()[0]);
      marshalOne(PlatformSubsurfaceCivilianSubmarineSubcategories.values()[0]);
      marshalOne(PlatformSubsurfaceCivilianSubmersibleSubcategories.values()[0]);
      marshalOne(PlatformSurfaceCategory.values()[0]);
      marshalOne(PlatformSurfaceDryCargoShipSubcategories.values()[0]);
      marshalOne(PlatformSurfaceFishingVesselSubcategories.values()[0]);
      marshalOne(PlatformSurfaceOtherVesselsSubcategories.values()[0]);
      marshalOne(PlatformSurfacePassengerVesselSubcategories.values()[0]);
      marshalOne(PlatformSurfacePrivateMotorboatSubcategories.values()[0]);
      marshalOne(PlatformSurfacePrivateSailboatSubcategories.values()[0]);
      marshalOne(PlatformSurfaceSupportVesselSubcategories.values()[0]);
      marshalOne(PlatformSurfaceTankerSubcategories.values()[0]);

      marshalOne(RadioCategory.values()[0]);
      marshalOne(RadioSubcategory.values()[0]);
      marshalOne(ReceiverReceiverState.values()[0]);
      marshalOne(RecordQueryREventType.values()[0]);
      marshalOne(RecordREventType.values()[0]);
      marshalOne(RepairCompleteRepair.values()[0]);
      marshalOne(RepairGroups.values()[0]);
      marshalOne(RepairResponseRepairResult.values()[0]);
      marshalOne(ReplyAmplification.values()[0]);
      marshalOne(RequiredReliabilityService.values()[0]);
      marshalOne(Season.values()[0]);

      marshalOne(SensorEmitterCategory.values()[0]);
      marshalOne(SensorOnOffStatus.values()[0]);
      marshalOne(SensorRecordSensorTypeOtherActiveSensors.values()[0]);
      marshalOne(SensorRecordSensorTypePassiveSensors.values()[0]);
      marshalOne(SensorTypeSource.values()[0]);
      marshalOne(SeparationVPPreEntityIndicator.values()[0]);
      marshalOne(SeparationVPReasonforSeparation.values()[0]);
      marshalOne(ServiceRequestServiceTypeRequested.values()[0]);
      marshalOne(SignalEncodingClass.values()[0]);
      marshalOne(SignalEncodingType.values()[0]);
      marshalOne(SignalTDLType.values()[0]);
      marshalOne(SignalUserProtocolIdentificationNumber.values()[0]);

      marshalOne(SpecificDimensionEnumerationsforAirAreaSize.values()[0]);
      marshalOne(SpecificDimensionEnumerationsforLandAreaSize.values()[0]);
      marshalOne(SpotChaffStatus.values()[0]);

      marshalOne(StopFreezeReason.values()[0]);
      marshalOne(SubcategoriesforAirCategory200Bird.values()[0]);
      marshalOne(SubcategoriesforAirCategory201Insect.values()[0]);
      marshalOne(SubcategoriesforAirCategory202Mammal.values()[0]);
      marshalOne(SubcategoriesforLandCategory200Mammal.values()[0]);
      marshalOne(SubcategoriesforLandCategory201Reptile.values()[0]);
      marshalOne(SubcategoriesforLandCategory202Amphibian.values()[0]);
      marshalOne(SubcategoriesforLandCategory203Insect.values()[0]);
      marshalOne(SubcategoriesforLandCategory204Arachnid.values()[0]);
      marshalOne(SubcategoriesforLandCategory205Mollusk.values()[0]);
      marshalOne(SubcategoriesforLandCategory206Marsupial.values()[0]);
      marshalOne(SubcategoriesforSubsurfaceCategory200Fish.values()[0]);
      marshalOne(SubcategoriesforSubsurfaceCategory201Mammal.values()[0]);
      marshalOne(SubcategoriesforSubsurfaceCategory202Mollusk.values()[0]);
      marshalOne(SubcategoriesforSubsurfaceCategory203Crustacean.values()[0]);
      marshalOne(SubcategoriesforSubsurfaceCategory204Insect.values()[0]);

      marshalOne(SupplyDomain.values()[0]);
      marshalOne(SupplyFuelType.values()[0]);

      marshalOne(SurveillanceStatus.values()[0]);
      marshalOne(TCASACASBasicAdvancedIndicator.values()[0]);
      marshalOne(TCASACASIndicator.values()[0]);
      marshalOne(TCASACASSoftwareVersion.values()[0]);
      marshalOne(TCASACASType.values()[0]);
      marshalOne(TCASIIIType.values()[0]);
      marshalOne(TILinkType.values()[0]);
      marshalOne(TimeTypeSource.values()[0]);
      marshalOne(TransferControlTransferType.values()[0]);
      marshalOne(TransmissionIndicator.values()[0]);
      marshalOne(TransmitterAntennaPatternReferenceSystem.values()[0]);
      marshalOne(TransmitterAntennaPatternType.values()[0]);
      marshalOne(TransmitterCryptoSystem.values()[0]);
      marshalOne(TransmitterDetailAmplitudeModulation.values()[0]);
      marshalOne(TransmitterDetailAmplitudeandAngleModulation.values()[0]);
      marshalOne(TransmitterDetailAnglemodulation.values()[0]);
      marshalOne(TransmitterDetailCarrierPhaseShiftModulation.values()[0]);
      marshalOne(TransmitterDetailCombinationModulation.values()[0]);
      marshalOne(TransmitterDetailPulseModulation.values()[0]);
      marshalOne(TransmitterDetailSATCOMModulation.values()[0]);
      marshalOne(TransmitterDetailUnmodulatedModulation.values()[0]);
      marshalOne(TransmitterInputSource.values()[0]);
      marshalOne(TransmitterMajorModulation.values()[0]);
      marshalOne(TransmitterModulationTypeSystem.values()[0]);
      marshalOne(TransmitterTransmitState.values()[0]);
      marshalOne(TransponderInterrogatorIndicator.values()[0]);
      marshalOne(TurnRateSource.values()[0]);
      marshalOne(UAAcousticEmitterSystemFunction.values()[0]);
      marshalOne(UAAcousticSystemName.values()[0]);
      marshalOne(UAActiveEmissionParameterIndex.values()[0]);
      marshalOne(UAAdditionalPassiveActivityParameterIndex.values()[0]);
      marshalOne(UAPassiveParameterIndex.values()[0]);

      marshalOne(UAPropulsionPlantConfigurationConfiguration.values()[0]);
      marshalOne(UAScanPattern.values()[0]);
      marshalOne(UAStateChangeUpdateIndicator.values()[0]);
      marshalOne(VariableParameterRecordType.values()[0]);
      marshalOne(VariableRecordType.values()[0]);
      marshalOne(VariantsforAirCategory200Bird.values()[0]);
      marshalOne(VariantsforLandCategoriesReptilesAmphibiansInsectsandArachnids.values()[0]);
      marshalOne(VariantsforSubsurfaceCategory201Mammal.values()[0]);

      //System.out.println("Testing BitSets");
      /* DisBitSets which were taken from the alphabetical list above where the spaces are */
      // Testing import of particular Bits class
      marshalOne(new AirPlatformAppearance(AirPlatformAppearance.AFTERBURNERON, 1), "17");

      marshalOne(new AirPlatformAppearance().set(AirPlatformAppearance.CANOPYTROOPDOOR, AppearanceCanopy.REAR_CANOPY_RIGHT_TROOP_DOOR_OPEN.getValue()), "9 3bitslen = 5");

      marshalOne(new ArealObjectAppearanceMinefield().set(ArealObjectAppearanceMinefield.BREACHSTATE, 1), "");
      marshalOne(new CulturalFeatureAppearance().set(CulturalFeatureAppearance.DAMAGE, 1), "");
      marshalOne(new CulturalFeatureCapabilities().set(CulturalFeatureCapabilities.IEDPRESENCEINDICATOR, 1), "");
      marshalOne(new DEDamageDescriptionComponentVisualDamageStatus().set(DEDamageDescriptionComponentVisualDamageStatus.ISFIREPRESENT, 1), "");
      marshalOne(new DEFireFlags().set(DEFireFlags.STATEUPDATEFLAG, 1), "");
      marshalOne(new EnvironmentalAppearance().set(EnvironmentalAppearance.DENSITY, 1), "");

      marshalOne(new EnvironmentalAppearance().set(EnvironmentalAppearance.DENSITY, 3).set(EnvironmentalAppearance.ISFROZEN, 1), "");

      marshalOne(new EnvironmentalCapabilities().set(EnvironmentalCapabilities.IEDPRESENCEINDICATOR, 1), "");
      marshalOne(new EnvironmentalProcessEnvironmentStatus().set(EnvironmentalProcessEnvironmentStatus.ISACTIVE, 1), "");
      marshalOne(new ExpendableAppearance().set(ExpendableAppearance.DAMAGE, 1), "");
      marshalOne(new ExpendableCapabilities().set(ExpendableCapabilities.RESERVED, 1), "");
      marshalOne(new LandPlatformAppearance().set(LandPlatformAppearance.BLACKOUTBRAKELIGHTSON, 1), "");
      marshalOne(new LandPlatformCapabilities().set(LandPlatformCapabilities.AMMUNITIONSUPPLY, 1), "");
      marshalOne(new LifeFormsAppearance().set(LifeFormsAppearance.CAMOUFLAGETYPE, 1), "");
      marshalOne(new LifeFormsCapabilities().set(LifeFormsCapabilities.AMMUNITIONSUPPLY, 1), "");
      marshalOne(new LinearObjectAppearanceExhaustSmoke().set(LinearObjectAppearanceExhaustSmoke.CHEMICALTYPE, 1), "");
      marshalOne(new LinearObjectAppearanceMinefieldLaneMarker().set(LinearObjectAppearanceMinefieldLaneMarker.VISIBLESIDE, 1), "");
      marshalOne(new LinearObjectAppearanceSpeedBump().set(LinearObjectAppearanceSpeedBump.COLOR, 1), "");
      marshalOne(new LinearObjectAppearanceTankDitchAndConcertinaWire().set(LinearObjectAppearanceTankDitchAndConcertinaWire.BREACHLENGTH, 1), "");
      marshalOne(new LinearObjectAppearanceWire().set(LinearObjectAppearanceWire.COLOR, 1), "");
      marshalOne(new MinefieldDataFusing().set(MinefieldDataFusing.HASANTIHANDLINGDEVICE, 1), "");
      marshalOne(new MinefieldDataPaintScheme().set(MinefieldDataPaintScheme.ALGAE, 1), "");
      marshalOne(new MinefieldStateAppearanceBitMap().set(MinefieldStateAppearanceBitMap.ACTIVESTATUS, 1), "");
      marshalOne(new MunitionAppearance().set(MunitionAppearance.COVERSHROUDSTATUS, 1), "");
      marshalOne(new MunitionCapabilities().set(MunitionCapabilities.IEDPRESENCEINDICATOR, 1), "");
      marshalOne(new NonHumanLifeFormsAppearance().set(NonHumanLifeFormsAppearance.HEALTH, 1), "");
      marshalOne(new ObjectStateAppearanceGeneral().set(ObjectStateAppearanceGeneral.DAMAGE, 1), "");
      marshalOne(new ObjectStateModificationArealObject().set(ObjectStateModificationArealObject.ISLOCATIONMODIFIED, 1), "");
      marshalOne(new ObjectStateModificationLinearObject().set(ObjectStateModificationLinearObject.ISLOCATIONMODIFIED, 1), "");
      marshalOne(new ObjectStateModificationPointObject().set(ObjectStateModificationPointObject.ISLOCATIONMODIFIED, 1), "");
      marshalOne(new PointObjectAppearanceAirGroundBurst().set(PointObjectAppearanceAirGroundBurst.CHEMICALTYPE, 1), "");
      marshalOne(new PointObjectAppearanceBuildingStructure().set(PointObjectAppearanceBuildingStructure.COLOR, 1), "");
      marshalOne(new PointObjectAppearanceCrater().set(PointObjectAppearanceCrater.BREACHSTATE, 1), "");
      marshalOne(new PointObjectAppearanceDisturbedEarthRoad().set(PointObjectAppearanceDisturbedEarthRoad.CONTRAST, 1), "");
      marshalOne(new PointObjectAppearanceLogCribAbatisEtAl().set(PointObjectAppearanceLogCribAbatisEtAl.BREACHSTATE, 1), "");
      marshalOne(new PointObjectAppearancePothole().set(PointObjectAppearancePothole.DEPTH, 1), "");
      marshalOne(new PointObjectAppearanceRibbonBridge().set(PointObjectAppearanceRibbonBridge.NUMBEROFSEGMENTS, 1), "");
      marshalOne(new PointObjectAppearanceTree().set(PointObjectAppearanceTree.LEAFCOVERAGE, 1), "");
      marshalOne(new RadioAppearance().set(RadioAppearance.ISFROZEN, 1), "");
      marshalOne(new RadioCapabilities().set(RadioCapabilities.RESERVED, 1), "");
      marshalOne(new SensorEmitterAppearance().set(SensorEmitterAppearance.ANTENNARAISED, 1), "");
      marshalOne(new SensorEmitterCapabilities().set(SensorEmitterCapabilities.IEDPRESENCEINDICATOR, 1), "");
      marshalOne(new SpacePlatformAppearance().set(SpacePlatformAppearance.DAMAGE, 1), "");
      marshalOne(new SpacePlatformCapabilities().set(SpacePlatformCapabilities.AMMUNITIONSUPPLY, 1), "");
      marshalOne(new StopFreezeFrozenBehavior().set(StopFreezeFrozenBehavior.PROCESSUPDATES, 1), "");
      marshalOne(new SubsurfacePlatformAppearance().set(SubsurfacePlatformAppearance.DAMAGE, 1), "");
      marshalOne(new SubsurfacePlatformCapabilities().set(SubsurfacePlatformCapabilities.AMMUNITIONSUPPLY, 1), "");
      marshalOne(new SupplyAppearance().set(SupplyAppearance.DAMAGE, 1), "");
      marshalOne(new SupplyCapabilities().set(SupplyCapabilities.AMMUNITIONSUPPLY, 1), "");
      marshalOne(new SurfacePlatformAppearance().set(SurfacePlatformAppearance.DAMAGE, 1), "");
      marshalOne(new SurfacePlatformCapabilities().set(SurfacePlatformCapabilities.AMMUNITIONSUPPLY, 1), "");
      marshalOne(new UAPropulsionPlantConfiguration().set(UAPropulsionPlantConfiguration.CONFIGURATION, 1), "");

      // classes with no enumerated bit positions
      marshalOne(new LinearObjectAppearanceBreach().set(0, 1, 1), "");
      marshalOne(new PointObjectAppearanceBuildingRubble().set(0, 1, 1), "");
      marshalOne(new PointObjectAppearanceStationaryBridgeAndAVLB().set(0, 1, 1), "");
    }
    catch (Throwable t) {
      thr = t;
    }
    if (thr != null)
      thr.printStackTrace(System.err);
    assertNull(thr, "Exception should be null if successful marshal");
    //System.out.println(""+count+" enums and disbitsets tested");
  }
  int count = 0;

  private void marshalOne(Enum en) throws Throwable
  {
    ByteBuffer byteBuffer = ByteBuffer.allocate(100);
    marshalIt(en, byteBuffer);
    int sz = getMarshalSize(en);
    assertEquals(sz, byteBuffer.position(), "Marshalled array should be " + sz + " bytes long");
    //  dump(en, sz, bb);

    count++;
  }

  private void marshalIt(Enum en, ByteBuffer byteBuffer) throws Throwable
  {
    Class<?> c = en.getClass();
    Method meth = c.getDeclaredMethod("marshal", new Class[]{ByteBuffer.class});
    meth.invoke(en, byteBuffer);
  }

  private int getMarshalSize(Enum en) throws Throwable
  {
    Class<?> c = en.getClass();
    Method meth = c.getDeclaredMethod("getMarshalledSize", (Class[]) null);
    return (Integer) meth.invoke(en, (Object[]) null);
  }

  private void marshalOne(DisBitSet bs, String s) throws Throwable
  {
    Throwable thr = null;
    try {
      Exception ex = null;
      ByteBuffer byteBuffer = ByteBuffer.allocate(100);
      bs.marshal(byteBuffer);
      int sz = bs.getMarshalledSize();
      assertEquals(sz, byteBuffer.position(), "Marshalled array should be " + sz + " bytes long");
      //System.out.print(s + " ");
      //   dump(bs, bb);
    }
    catch (Throwable t) {
      thr = t;
    }
    //tempassertNull(thr, "Exception should be null if successful marshal");
    count++;
  }

  private void dump(Enum en, int sz, ByteBuffer bb)
  {
    System.out.println(en.getClass().getSimpleName() + "(" + sz + "): ");
    dumpCommon(bb);
  }

  private void dump(DisBitSet bs, ByteBuffer bb)
  {
    System.out.println(bs.getClass().getSimpleName() + "(" + bs.getMarshalledSize() + "): ");
    dumpCommon(bb);
  }

  private void dumpCommon(ByteBuffer bb)
  {
    for (int i = 0; i < bb.position(); i++) {
      System.out.print(String.format("%02X ", bb.array()[i]));
    }
    System.out.println();
  }
  
  public static void main(String[] args)
  {
    new MarshalEnumsTest().testGoodMarshall();
  }

}
