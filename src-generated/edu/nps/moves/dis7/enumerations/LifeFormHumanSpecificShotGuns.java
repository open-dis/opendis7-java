package edu.nps.moves.dis7.enumerations;

import java.nio.ByteBuffer;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import edu.nps.moves.dis7.pdus.*;

/**
 * Generated from XML, <br>
 * UID 511 marshal size 8<br>
 * LifeFormHumanSpecificShotGuns
 */
public enum LifeFormHumanSpecificShotGuns 
{
    /** Other */
    OTHER (0, "Other"),
    /** Browning Superposed O/U */
    BROWNING_SUPERPOSED_O_U (20, "Browning Superposed O/U"),
    /** Browning Cynergy */
    BROWNING_CYNERGY (21, "Browning Cynergy"),
    /** Browning Auto-5 */
    BROWNING_AUTO_5 (22, "Browning Auto-5"),
    /** 18.5mm Browning Citori O/U 12 Gauge */
    _185MM_BROWNING_CITORI_O_U_12_GAUGE (23, "18.5mm Browning Citori O/U 12 Gauge"),
    /** 16.8mm Browning Citori O/U 16 Gauge */
    _168MM_BROWNING_CITORI_O_U_16_GAUGE (24, "16.8mm Browning Citori O/U 16 Gauge"),
    /** 15.6mm Browning Citori O/U 20 Gauge */
    _156MM_BROWNING_CITORI_O_U_20_GAUGE (25, "15.6mm Browning Citori O/U 20 Gauge"),
    /** 14mm Browning Citori O/U 28 Gauge */
    _14MM_BROWNING_CITORI_O_U_28_GAUGE (26, "14mm Browning Citori O/U 28 Gauge"),
    /** 10.4mm Browning Citori O/U .410 Bore */
    _104MM_BROWNING_CITORI_O_U_410_BORE (27, "10.4mm Browning Citori O/U .410 Bore"),
    /** 18.5mm Browning Double Automatic 12 Gauge */
    IDENTIFICATION_FRIEND_OR_FOE (28, "18.5mm Browning Double Automatic 12 Gauge"),
    /** 18.5mm Ithaca 37 12 Gauge */
    _185MM_ITHACA_37_12_GAUGE (29, "18.5mm Ithaca 37 12 Gauge"),
    /** 16.8mm Ithaca 37 16 Gauge */
    SUPPLEMENTAL_EMISSION_ENTITY_STATE (30, "16.8mm Ithaca 37 16 Gauge"),
    /** 15.6mm Ithaca 37 20 Gauge */
    _156MM_ITHACA_37_20_GAUGE (31, "15.6mm Ithaca 37 20 Gauge"),
    /** 14mm Ithaca 37 28 Gauge */
    _14MM_ITHACA_37_28_GAUGE (32, "14mm Ithaca 37 28 Gauge"),
    /** 19.7mm Ithaca Mag-10 SA 10 Gauge */
    _197MM_ITHACA_MAG_10_SA_10_GAUGE (33, "19.7mm Ithaca Mag-10 SA 10 Gauge"),
    /** 19.7mm Marlin Model 55 10 Gauge */
    _197MM_MARLIN_MODEL_55_10_GAUGE (34, "19.7mm Marlin Model 55 10 Gauge"),
    /** 18.5mm Marlin Model 55 12 Gauge */
    _185MM_MARLIN_MODEL_55_12_GAUGE (35, "18.5mm Marlin Model 55 12 Gauge"),
    /** 16.8mm Marlin Model 55 16 Gauge */
    _168MM_MARLIN_MODEL_55_16_GAUGE (36, "16.8mm Marlin Model 55 16 Gauge"),
    /** 15.6mm Marlin Model 55 20 Gauge */
    _156MM_MARLIN_MODEL_55_20_GAUGE (37, "15.6mm Marlin Model 55 20 Gauge"),
    /** 18.5mm Mossberg 500 12 Gauge */
    _185MM_MOSSBERG_500_12_GAUGE (38, "18.5mm Mossberg 500 12 Gauge"),
    /** 15.6mm Mossberg 500 20 Gauge */
    _156MM_MOSSBERG_500_20_GAUGE (39, "15.6mm Mossberg 500 20 Gauge"),
    /** 10.4mm Mossberg 500 .410 Bore */
    _104MM_MOSSBERG_500_410_BORE (40, "10.4mm Mossberg 500 .410 Bore"),
    /** 18.5mm Mossberg 590 12 Gauge */
    _185MM_MOSSBERG_590_12_GAUGE (41, "18.5mm Mossberg 590 12 Gauge"),
    /** 15.6mm Mossberg 590 20 Gauge */
    _156MM_MOSSBERG_590_20_GAUGE (42, "15.6mm Mossberg 590 20 Gauge"),
    /** 10.4mm Mossberg 590 .410 Bore */
    _104MM_MOSSBERG_590_410_BORE (43, "10.4mm Mossberg 590 .410 Bore"),
    /** 18.5mm Mossberg 930 SA 12 Gauge */
    _185MM_MOSSBERG_930_SA_12_GAUGE (44, "18.5mm Mossberg 930 SA 12 Gauge"),
    /** Remington Model 11 SA */
    REMINGTON_MODEL_11_SA (45, "Remington Model 11 SA"),
    /** Remington Model 10 12 Gauge */
    TIME_SPACE_POSITION_INFORMATION (46, "Remington Model 10 12 Gauge"),
    /** 15.6mm Remington Model 17 20 Gauge */
    _156MM_REMINGTON_MODEL_17_20_GAUGE (47, "15.6mm Remington Model 17 20 Gauge"),
    /** Remington Model 31 */
    REMINGTON_MODEL_31 (48, "Remington Model 31"),
    /** Remington Model 11-48 SA */
    LIVE_ENTITY_FIRE (49, "Remington Model 11-48 SA"),
    /** 18.5mm Remington 870 12 Gauge */
    LIVE_ENTITY_DETONATION (50, "18.5mm Remington 870 12 Gauge"),
    /** 16.8mm Remington 870 16 Gauge */
    CREATE_ENTITY_RELIABLE (51, "16.8mm Remington 870 16 Gauge"),
    /** 15.6mm Remington 870 20 Gauge */
    REMOVE_ENTITY_RELIABLE (52, "15.6mm Remington 870 20 Gauge"),
    /** 14mm Remington 870 28 Gauge */
    START_RESUME_RELIABLE (53, "14mm Remington 870 28 Gauge"),
    /** 10.4mm Remington 870 .410 Bore */
    STOP_FREEZE_RELIABLE (54, "10.4mm Remington 870 .410 Bore"),
    /** Remington Model 58 SA */
    ACKNOWLEDGE_RELIABLE (55, "Remington Model 58 SA"),
    /** 18.5mm Remington 878 SA 12 Gauge */
    ACTION_REQUEST_RELIABLE (56, "18.5mm Remington 878 SA 12 Gauge"),
    /** 18.5mm Remington Model 1100 SA 12 Gauge */
    ACTION_RESPONSE_RELIABLE (57, "18.5mm Remington Model 1100 SA 12 Gauge"),
    /** 16.8mm Remington Model 1100 SA 16 Gauge */
    DATA_QUERY_RELIABLE (58, "16.8mm Remington Model 1100 SA 16 Gauge"),
    /** 15.6mm Remington Model 1100 SA 20 Gauge */
    SET_DATA_RELIABLE (59, "15.6mm Remington Model 1100 SA 20 Gauge"),
    /** 14mm Remington Model 1100 SA 28 Gauge */
    DATA_RELIABLE (60, "14mm Remington Model 1100 SA 28 Gauge"),
    /** 10.4mm Remington Model 1100 SA .410 Bore */
    EVENT_REPORT_RELIABLE (61, "10.4mm Remington Model 1100 SA .410 Bore"),
    /** 18.5mm Remington 11-87 SA 12 Gauge */
    COMMENT_RELIABLE (62, "18.5mm Remington 11-87 SA 12 Gauge"),
    /** 15.6mm Remington 11-87 SA 20 Gauge */
    RECORD_RELIABLE (63, "15.6mm Remington 11-87 SA 20 Gauge"),
    /** 19.7mm Remington Model SP-10 SA 10 Gauge */
    SET_RECORD_RELIABLE	 (64, "19.7mm Remington Model SP-10 SA 10 Gauge"),
    /** 18.5mm Remington 887 12 Gauge */
    RECORD_QUERY_RELIABLE (65, "18.5mm Remington 887 12 Gauge"),
    /** 18.5mm Remington Sparta 100 SxS 12 Gauge */
    _185MM_REMINGTON_SPARTA_100_SXS_12_GAUGE (70, "18.5mm Remington Sparta 100 SxS 12 Gauge"),
    /** 15.6mm Remington Sparta 100 SxS 20 Gauge */
    _156MM_REMINGTON_SPARTA_100_SXS_20_GAUGE (71, "15.6mm Remington Sparta 100 SxS 20 Gauge"),
    /** 10.4mm Remington Sparta 100 SxS .410 Bore */
    _104MM_REMINGTON_SPARTA_100_SXS_410_BORE (72, "10.4mm Remington Sparta 100 SxS .410 Bore"),
    /** 18.5mm Remington Spartan 310 O/U 12 Gauge */
    _185MM_REMINGTON_SPARTAN_310_O_U_12_GAUGE (73, "18.5mm Remington Spartan 310 O/U 12 Gauge"),
    /** 15.6mm Remington Spartan 310 O/U 20 Gauge */
    _156MM_REMINGTON_SPARTAN_310_O_U_20_GAUGE (74, "15.6mm Remington Spartan 310 O/U 20 Gauge"),
    /** 14mm Remington Spartan 310 O/U 28 Gauge */
    _14MM_REMINGTON_SPARTAN_310_O_U_28_GAUGE (75, "14mm Remington Spartan 310 O/U 28 Gauge"),
    /** 10.4mm Remington Spartan 310 O/U .410 Bore */
    _104MM_REMINGTON_SPARTAN_310_O_U_410_BORE (76, "10.4mm Remington Spartan 310 O/U .410 Bore"),
    /** 18.5mm Remington Spartan 453 SA 12 Gauge */
    _185MM_REMINGTON_SPARTAN_453_SA_12_GAUGE (77, "18.5mm Remington Spartan 453 SA 12 Gauge"),
    /** 18.5mm Winchester Model 1200 12 Gauge */
    _185MM_WINCHESTER_MODEL_1200_12_GAUGE (80, "18.5mm Winchester Model 1200 12 Gauge"),
    /** 16.8mm Winchester Model 1200 16 Gauge */
    _168MM_WINCHESTER_MODEL_1200_16_GAUGE (81, "16.8mm Winchester Model 1200 16 Gauge"),
    /** 15.6mm Winchester Model 1200 20 Gauge */
    _156MM_WINCHESTER_MODEL_1200_20_GAUGE (82, "15.6mm Winchester Model 1200 20 Gauge"),
    /** Winchester Model 1887/1901 */
    WINCHESTER_MODEL_1887_1901 (83, "Winchester Model 1887/1901"),
    /** Winchester Model 1897 */
    WINCHESTER_MODEL_1897 (84, "Winchester Model 1897"),
    /** Winchester Model 1912 */
    WINCHESTER_MODEL_1912 (85, "Winchester Model 1912"),
    /** Winchester Model 21 SxS */
    WINCHESTER_MODEL_21_SXS (86, "Winchester Model 21 SxS"),
    /** Winchester Model 37 SxS */
    WINCHESTER_MODEL_37_SXS (87, "Winchester Model 37 SxS"),
    /** 18.5mm HR Ultraslug SxS 12 Gauge */
    _185MM_HR_ULTRASLUG_SXS_12_GAUGE (88, "18.5mm HR Ultraslug SxS 12 Gauge"),
    /** 15.6mm HR Ultraslug SxS 20 Gauge */
    _156MM_HR_ULTRASLUG_SXS_20_GAUGE (89, "15.6mm HR Ultraslug SxS 20 Gauge"),
    /** 18.5mm Ciener Ultimate O/U 12 Gauge */
    _185MM_CIENER_ULTIMATE_O_U_12_GAUGE (90, "18.5mm Ciener Ultimate O/U 12 Gauge"),
    /** 18.5mm Coach Gun SxS Double Barrel 12 Gauge */
    _185MM_COACH_GUN_SXS_DOUBLE_BARREL_12_GAUGE (91, "18.5mm Coach Gun SxS Double Barrel 12 Gauge"),
    /** 18.5mm Ruger Gold Label SxS 12 Gauge */
    _185MM_RUGER_GOLD_LABEL_SXS_12_GAUGE (92, "18.5mm Ruger Gold Label SxS 12 Gauge"),
    /** 18.5mm High Standard Model 10 SA 12 Gauge */
    _185MM_HIGH_STANDARD_MODEL_10_SA_12_GAUGE (93, "18.5mm High Standard Model 10 SA 12 Gauge"),
    /** 18.5mm Kel-Tex KSG 12 Gauge */
    _185MM_KEL_TEX_KSG_12_GAUGE (94, "18.5mm Kel-Tex KSG 12 Gauge"),
    /** 18.5 KAC Masterkey 12 Gauge */
    _185_KAC_MASTERKEY_12_GAUGE (95, "18.5 KAC Masterkey 12 Gauge"),
    /** 18.5mm M26 M.A.S.S. 12 Gauge */
    _185MM_M26_MASS_12_GAUGE (96, "18.5mm M26 M.A.S.S. 12 Gauge"),
    /** 18.5mm SRM Arms M1216 SA 12 Gauge */
    _185MM_SRM_ARMS_M1216_SA_12_GAUGE (97, "18.5mm SRM Arms M1216 SA 12 Gauge"),
    /** 18.5mm AA-12 FA Atchisson Assault */
    _185MM_AA_12_FA_ATCHISSON_ASSAULT (98, "18.5mm AA-12 FA Atchisson Assault"),
    /** 18.5mm Pancor Jackhammer FA 12 Gauge */
    _185MM_PANCOR_JACKHAMMER_FA_12_GAUGE (99, "18.5mm Pancor Jackhammer FA 12 Gauge"),
    /** 18.5mm USAS-12 FA 12 Gauge */
    _185MM_USAS_12_FA_12_GAUGE (110, "18.5mm USAS-12 FA 12 Gauge"),
    /** 18.5mm MAUL SA 12 Gauge */
    _185MM_MAUL_SA_12_GAUGE (111, "18.5mm MAUL SA 12 Gauge"),
    /** 18.5mm FN SLP SA 12 Gauge */
    _185MM_FN_SLP_SA_12_GAUGE (112, "18.5mm FN SLP SA 12 Gauge"),
    /** 18.5mm FN TPS 12 Gauge */
    _185MM_FN_TPS_12_GAUGE (113, "18.5mm FN TPS 12 Gauge"),
    /** 18.5mm ENARM Pentagun SA 12 Gauge */
    _185MM_ENARM_PENTAGUN_SA_12_GAUGE (115, "18.5mm ENARM Pentagun SA 12 Gauge"),
    /** Stevens Model 520/620 */
    STEVENS_MODEL_520_620 (116, "Stevens Model 520/620"),
    /** Stoeger Coach Gun SxS */
    STOEGER_COACH_GUN_SXS (117, "Stoeger Coach Gun SxS"),
    /** Stoeger Condor O/U */
    STOEGER_CONDOR_O_U (118, "Stoeger Condor O/U"),
    /** 18.5mm Armscor Model 30 SA 12 Gauge */
    _185MM_ARMSCOR_MODEL_30_SA_12_GAUGE (120, "18.5mm Armscor Model 30 SA 12 Gauge"),
    /** Weatherby SA-08 SA */
    WEATHERBY_SA_08_SA (121, "Weatherby SA-08 SA"),
    /** 18.5mm Fabarm SDASS Tactical 12 Gauge */
    _185MM_FABARM_SDASS_TACTICAL_12_GAUGE (122, "18.5mm Fabarm SDASS Tactical 12 Gauge"),
    /** 18.5mm MAG-7 12 Gauge */
    _185MM_MAG_7_12_GAUGE (123, "18.5mm MAG-7 12 Gauge"),
    /** 18.5mm Neostead 12 Gauge */
    _185MM_NEOSTEAD_12_GAUGE (124, "18.5mm Neostead 12 Gauge"),
    /** 18.5mm Armsel Striker SA 12 Gauge */
    _185MM_ARMSEL_STRIKER_SA_12_GAUGE (125, "18.5mm Armsel Striker SA 12 Gauge"),
    /** 18.5mm Parker Hale Rogun SA 12 Gauge */
    _185MM_PARKER_HALE_ROGUN_SA_12_GAUGE (127, "18.5mm Parker Hale Rogun SA 12 Gauge"),
    /** 26mm RGA-86 Revolver */
    _26MM_RGA_86_REVOLVER (130, "26mm RGA-86 Revolver"),
    /** 18.5mm Sjorgren SA 12 Gauge */
    _185MM_SJORGREN_SA_12_GAUGE (131, "18.5mm Sjorgren SA 12 Gauge"),
    /** 18.5mm Akdal MKA 1919 SA 12 Gauge */
    _185MM_AKDAL_MKA_1919_SA_12_GAUGE (132, "18.5mm Akdal MKA 1919 SA 12 Gauge"),
    /** 18.5mm Retay Masai Mara SA 12 Gauge */
    _185MM_RETAY_MASAI_MARA_SA_12_GAUGE (133, "18.5mm Retay Masai Mara SA 12 Gauge"),
    /** 18.5mm Safir T-14 SA 12 Gauge */
    _185MM_SAFIR_T_14_SA_12_GAUGE (134, "18.5mm Safir T-14 SA 12 Gauge"),
    /** 18.5mm Benelli M1 Super 90 SA 12 Gauge */
    _185MM_BENELLI_M1_SUPER_90_SA_12_GAUGE (150, "18.5mm Benelli M1 Super 90 SA 12 Gauge"),
    /** 15.6mm Benelli M1 Super 90 SA 20 Gauge */
    _156MM_BENELLI_M1_SUPER_90_SA_20_GAUGE (151, "15.6mm Benelli M1 Super 90 SA 20 Gauge"),
    /** 18.5mm Benelli M3 Super 90 SA 12 Gauge */
    _185MM_BENELLI_M3_SUPER_90_SA_12_GAUGE (152, "18.5mm Benelli M3 Super 90 SA 12 Gauge"),
    /** 15.6mm Benelli M3 Super 90 SA 20 Gauge */
    _156MM_BENELLI_M3_SUPER_90_SA_20_GAUGE (153, "15.6mm Benelli M3 Super 90 SA 20 Gauge"),
    /** 18.5mm Benelli M4 Super 90 SA 12 Gauge */
    _185MM_BENELLI_M4_SUPER_90_SA_12_GAUGE (154, "18.5mm Benelli M4 Super 90 SA 12 Gauge"),
    /** 18.5mm Benelli Nova 12 Gauge */
    _185MM_BENELLI_NOVA_12_GAUGE (155, "18.5mm Benelli Nova 12 Gauge"),
    /** 15.6mm Benelli Nove 20 Gauge */
    _156MM_BENELLI_NOVE_20_GAUGE (156, "15.6mm Benelli Nove 20 Gauge"),
    /** 18.5mm Benelli Raffaello SA 12 Gauge */
    _185MM_BENELLI_RAFFAELLO_SA_12_GAUGE (157, "18.5mm Benelli Raffaello SA 12 Gauge"),
    /** 18.5mm Benelli Supernova 12 Gauge */
    _185MM_BENELLI_SUPERNOVA_12_GAUGE (158, "18.5mm Benelli Supernova 12 Gauge"),
    /** 18.5mm Benelli Vinci SA 12 Gauge */
    _185MM_BENELLI_VINCI_SA_12_GAUGE (159, "18.5mm Benelli Vinci SA 12 Gauge"),
    /** 18.5mm Beretta 1201FP SA 12 Gauge */
    _185MM_BERETTA_1201FP_SA_12_GAUGE (160, "18.5mm Beretta 1201FP SA 12 Gauge"),
    /** 18.5mm Beretta 682 O/U 12 Gauge */
    _185MM_BERETTA_682_O_U_12_GAUGE (161, "18.5mm Beretta 682 O/U 12 Gauge"),
    /** 15.6mm Beretta 682 O/U 20 Gauge */
    _156MM_BERETTA_682_O_U_20_GAUGE (162, "15.6mm Beretta 682 O/U 20 Gauge"),
    /** 14mm Beretta 682 O/U 28 Gauge */
    _14MM_BERETTA_682_O_U_28_GAUGE (163, "14mm Beretta 682 O/U 28 Gauge"),
    /** 10.4mm Beretta 682 O/U .410 Bore */
    _104MM_BERETTA_682_O_U_410_BORE (164, "10.4mm Beretta 682 O/U .410 Bore"),
    /** 18.5mm Beretta A303 SA 12 Gauge */
    _185MM_BERETTA_A303_SA_12_GAUGE (165, "18.5mm Beretta A303 SA 12 Gauge"),
    /** 18.5mm Beretta AL391 SA 12 Gauge */
    _185MM_BERETTA_AL391_SA_12_GAUGE (166, "18.5mm Beretta AL391 SA 12 Gauge"),
    /** 15.6mm Beretta AL391 SA 20 Gauge */
    _156MM_BERETTA_AL391_SA_20_GAUGE (167, "15.6mm Beretta AL391 SA 20 Gauge"),
    /** 18.5mm Beretta DT-10 O/U 12 Gauge */
    _185MM_BERETTA_DT_10_O_U_12_GAUGE (168, "18.5mm Beretta DT-10 O/U 12 Gauge"),
    /** Beretta Silver Pigeon O/U */
    BERETTA_SILVER_PIGEON_O_U (169, "Beretta Silver Pigeon O/U"),
    /** 18.5mm Beretta Xtrema 2 SA 12 Gauge */
    _185MM_BERETTA_XTREMA_2_SA_12_GAUGE (170, "18.5mm Beretta Xtrema 2 SA 12 Gauge"),
    /** 15.6mm Franchi AL-48 SA 20 Gauge */
    _156MM_FRANCHI_AL_48_SA_20_GAUGE (171, "15.6mm Franchi AL-48 SA 20 Gauge"),
    /** 14mm Franchi AL-48 SA 28 Gauge */
    _14MM_FRANCHI_AL_48_SA_28_GAUGE (172, "14mm Franchi AL-48 SA 28 Gauge"),
    /** 10.4mm Franchi mod .410 FA .410 Bore */
    _104MM_FRANCHI_MOD_410_FA_410_BORE (173, "10.4mm Franchi mod .410 FA .410 Bore"),
    /** 18.5mm Franchi SPAS-12 SA 12 Gauge */
    _185MM_FRANCHI_SPAS_12_SA_12_GAUGE (174, "18.5mm Franchi SPAS-12 SA 12 Gauge"),
    /** 18.5mm Franchi SPAS-15 SA 12 Gauge */
    _185MM_FRANCHI_SPAS_15_SA_12_GAUGE (175, "18.5mm Franchi SPAS-15 SA 12 Gauge"),
    /** 18.5mm Valtro PM-5/PM-5-350 12 Gauge */
    _185MM_VALTRO_PM_5_PM_5_350_12_GAUGE (176, "18.5mm Valtro PM-5/PM-5-350 12 Gauge"),
    /** Blazer F3 O/U */
    BLAZER_F3_O_U (180, "Blazer F3 O/U"),
    /** 18.5mm HK FABARM FP6 12 Gauge */
    _185MM_HK_FABARM_FP6_12_GAUGE (181, "18.5mm HK FABARM FP6 12 Gauge"),
    /** 18.5mm HK CAWS FA 12 Gauge */
    _185MM_HK_CAWS_FA_12_GAUGE (182, "18.5mm HK CAWS FA 12 Gauge"),
    /** 18.5mm Baikal MP-153 SA 12 Gauge */
    _185MM_BAIKAL_MP_153_SA_12_GAUGE (200, "18.5mm Baikal MP-153 SA 12 Gauge"),
    /** 18.5mm Bandayevsky RB-12 12 Gauge */
    _185MM_BANDAYEVSKY_RB_12_12_GAUGE (201, "18.5mm Bandayevsky RB-12 12 Gauge"),
    /** 18.5mm Molot Bekas-M 12 Gauge */
    _185MM_MOLOT_BEKAS_M_12_GAUGE (202, "18.5mm Molot Bekas-M 12 Gauge"),
    /** 16.8mm Molot Bekas-M 16 Gauge */
    _168MM_MOLOT_BEKAS_M_16_GAUGE (203, "16.8mm Molot Bekas-M 16 Gauge"),
    /** 18.5mm TOZ-194 12 Gauge */
    _185MM_TOZ_194_12_GAUGE (204, "18.5mm TOZ-194 12 Gauge"),
    /** 23mm KS-23 */
    _23MM_KS_23 (205, "23mm KS-23"),
    /** MTs-255 Revoler 12 Gauge */
    MTS_255_REVOLER_12_GAUGE (206, "MTs-255 Revoler 12 Gauge"),
    /** 18.5mm RMB-93 12 Gauge */
    _185MM_RMB_93_12_GAUGE (207, "18.5mm RMB-93 12 Gauge"),
    /** 18.5mm Saiga-12 SA 12 Gauge */
    _185MM_SAIGA_12_SA_12_GAUGE (208, "18.5mm Saiga-12 SA 12 Gauge"),
    /** 15.6mm Saiga-12 SA 20 Gauge */
    _156MM_SAIGA_12_SA_20_GAUGE (209, "15.6mm Saiga-12 SA 20 Gauge"),
    /** 10.4mm Saiga-12 SA .410 Bore */
    _104MM_SAIGA_12_SA_410_BORE (210, "10.4mm Saiga-12 SA .410 Bore"),
    /** 18.5mm Vepr-12 SA 12 Gauge */
    _185MM_VEPR_12_SA_12_GAUGE (211, "18.5mm Vepr-12 SA 12 Gauge"),
    /** 18.5mm Fort 500 12 Gauge */
    _185MM_FORT_500_12_GAUGE (212, "18.5mm Fort 500 12 Gauge"),
    /** 18.5mm Norinco HP9-1 12 Gauge */
    _185MM_NORINCO_HP9_1_12_GAUGE (220, "18.5mm Norinco HP9-1 12 Gauge");

    private int value;
    private final String description;

    /** Constructor */
    LifeFormHumanSpecificShotGuns(int value, String description)
    {
        this.value = value;
        this.description = description;
    }
    /** Provide enumeration value
      * @return integer value */
    public int getValue()
    {
        return value;
    }

    /** Provide enumeration description
     * @return description
     */
    public String getDescription()
    {
        return description;
    }

    /** bit width for this enumeration
     * @return number of bits wide
     */
    public static int getEnumBitWidth()
    {
      return 8;
    }

    /** provide enumeration for a given value
     * @param i integer value of interest
     * @return enumeration corresponding to numeric value
     */
    public static LifeFormHumanSpecificShotGuns getEnumForValue(int i)
    {
       for(LifeFormHumanSpecificShotGuns val: LifeFormHumanSpecificShotGuns.values()) {
          if(val.getValue()==i)
              return val;
       }
       System.out.flush(); // ensure contiguous console outputs
       System.err.println("No enumeration found for value " + i + " of enumeration LifeFormHumanSpecificShotGuns");
       System.err.flush(); // ensure contiguous console outputs
       return null;
    }

    /** Marshal value to DataOutputStream
     * @see <a href="https://en.wikipedia.org/wiki/Marshalling_(computer_science)" target="_blank">https://en.wikipedia.org/wiki/Marshalling_(computer_science)</a>
     * @param dos DataOutputStream for output
     * @throws IOException input-output error */
    public void marshal(DataOutputStream dos) throws IOException
    {
        dos.writeByte(getValue());
    }
    
    /** Marshal value to ByteBuffer
     * @see <a href="https://en.wikipedia.org/wiki/Marshalling_(computer_science)" target="_blank">https://en.wikipedia.org/wiki/Marshalling_(computer_science)</a>
     * @param byteBuffer ByteBuffer for output
     * @throws IOException input-output error */
    public void marshal(ByteBuffer byteBuffer) throws Exception
    {
        byteBuffer.put((byte)getValue());
    }

    /** Unmarshal value to DataInputStream
     * @see <a href="https://en.wikipedia.org/wiki/Marshalling_(computer_science)" target="_blank">https://en.wikipedia.org/wiki/Marshalling_(computer_science)</a>
     * @param dis DataInputStream for input
     * @throws Exception unmarshalling input-output error
     * @return enumeration of interest */
    public static LifeFormHumanSpecificShotGuns unmarshalEnum (DataInputStream dis) throws Exception
    {
       /* try {
            value = dis.readUnsignedByte();
        }
        catch(IOException ex) {
            showError(ex);
        } */
        
        return getEnumForValue(dis.readByte());
    } 

    /** Unmarshal enumeration value to ByteBuffer
     * @see <a href="https://en.wikipedia.org/wiki/Marshalling_(computer_science)" target="_blank">https://en.wikipedia.org/wiki/Marshalling_(computer_science)</a>
     * @param byteBuffer ByteBuffer for input
     * @throws Exception unmarshalling input-output error
     * @return enumeration of interest */
    public static LifeFormHumanSpecificShotGuns unmarshalEnum(ByteBuffer byteBuffer) throws Exception
    {
        /*
        try {
            value = (int)byteBuffer.get();
        }
        catch(Exception ex) {
            showError(ex);
        }
        */
        return getEnumForValue(byteBuffer.get());
    }

  /**
   * Returns size of this serialized (marshalled) object in bytes
   * @see <a href="https://en.wikipedia.org/wiki/Marshalling_(computer_science)" target="_blank">https://en.wikipedia.org/wiki/Marshalling_(computer_science)</a>
   * @return serialized size in bytes
   */
    public int getMarshalledSize()
    {
        return 1; // 8 bits
    }
    
  /**
   * Provide simple identifier
   * @return ID number and name
   */
    @Override
    public String toString()
    {
        String padding = new String();
        if (name().equalsIgnoreCase("DISPDUType") && getValue() < 10)
            padding = "0"; // leading zero for column spacing
        return "LifeFormHumanSpecificShotGuns " + padding + getValue() + " " + name();
    }
}
