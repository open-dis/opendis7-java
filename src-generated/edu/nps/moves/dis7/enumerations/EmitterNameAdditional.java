package edu.nps.moves.dis7.enumerations;

import java.nio.ByteBuffer;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import edu.nps.moves.dis7.pdus.*;

/**
 * Generated from XML, <br>
 * UID 75 marshal size 16<br>
 * EmitterName
 */
public enum EmitterNameAdditional 
{
    /** COMMID_SMA SPN 751 */
    COMMID_SMA_SPN_751 (29745, "COMMID_SMA SPN 751"),
    /** COMMID_SMA SPOS 748 */
    COMMID_SMA_SPOS_748 (29790, "COMMID_SMA SPOS 748"),
    /** COMMID_SMA SPQ 2 */
    COMMID_SMA_SPQ_2 (29835, "COMMID_SMA SPQ 2"),
    /** COMMID_SMA SPQ 2D */
    COMMID_SMA_SPQ_2D (29880, "COMMID_SMA SPQ 2D"),
    /** COMMID_SMA SPQ 701 */
    COMMID_SMA_SPQ_701 (29925, "COMMID_SMA SPQ 701"),
    /** COMMID_SMA SPS 702 UPX */
    COMMID_SMA_SPS_702_UPX (29970, "COMMID_SMA SPS 702 UPX"),
    /** COMMID_SMA ST 2 OTOMAT II MH */
    COMMID_SMA_ST_2_OTOMAT_II_MH (30015, "COMMID_SMA ST 2 OTOMAT II MH"),
    /** SR-47A */
    SR_47A (30016, "SR-47A"),
    /** COMMID_SMA 718 Beacon */
    COMMID_SMA_718_BEACON (30060, "COMMID_SMA 718 Beacon"),
    /** NATOID_Small Fred */
    NATOID_SMALL_FRED (30065, "NATOID_Small Fred"),
    /** SMART-S */
    SMART_S (30068, "SMART-S"),
    /** SMART-S Mk2 */
    SMART_S_MK2 (30069, "SMART-S Mk2"),
    /** SMART-L */
    SMART_L (30070, "SMART-L"),
    /** SM-932 */
    SM_932 (30072, "SM-932"),
    /** NATOID_Smog Lamp */
    NATOID_SMOG_LAMP (30075, "NATOID_Smog Lamp"),
    /** NATOID_Snap Shot */
    NATOID_SNAP_SHOT (30080, "NATOID_Snap Shot"),
    /** NATOID_Snoop Drift */
    NATOID_SNOOP_DRIFT (30105, "NATOID_Snoop Drift"),
    /** NATOID_Snoop Half */
    NATOID_SNOOP_HALF (30140, "NATOID_Snoop Half"),
    /** NATOID_Snoop Head */
    NATOID_SNOOP_HEAD (30150, "NATOID_Snoop Head"),
    /** NATOID_Snoop Pair */
    NATOID_SNOOP_PAIR (30195, "NATOID_Snoop Pair"),
    /** NATOID_Snoop Ping */
    NATOID_SNOOP_PING (30200, "NATOID_Snoop Ping"),
    /** NATOID_Snoop Plate */
    NATOID_SNOOP_PLATE (30240, "NATOID_Snoop Plate"),
    /** NATOID_Snoop Ping */
    NATOID_SNOOP_PING_2 (30255, "NATOID_Snoop Ping"),
    /** NATOID_Snoop Slab */
    NATOID_SNOOP_SLAB (30285, "NATOID_Snoop Slab"),
    /** NATOID_Snoop Tray */
    NATOID_SNOOP_TRAY (30330, "NATOID_Snoop Tray"),
    /** NATOID_Snoop Tray 1 */
    NATOID_SNOOP_TRAY_1 (30375, "NATOID_Snoop Tray 1"),
    /** NATOID_Snoop Tray 2 */
    NATOID_SNOOP_TRAY_2 (30420, "NATOID_Snoop Tray 2"),
    /** NATOID_SNOOP TRAY 3 */
    NATOID_SNOOP_TRAY_3 (30421, "NATOID_SNOOP TRAY 3"),
    /** NATOID_Snoop Watch */
    NATOID_SNOOP_WATCH (30465, "NATOID_Snoop Watch"),
    /** 9S18M1 */
    _9S18M1 (30470, "9S18M1"),
    /** SPB-7 */
    SPB_7 (30475, "SPB-7"),
    /** NATOID_Snow Drop */
    NATOID_SNOW_DROP (30480, "NATOID_Snow Drop"),
    /** SNW-10 */
    SNW_10 (30490, "SNW-10"),
    /** SO-1 */
    SO_1 (30510, "SO-1"),
    /** SO-12 */
    SO_12 (30520, "SO-12"),
    /** SO A Communist */
    SO_A_COMMUNIST (30555, "SO A Communist"),
    /** SO-69 */
    SO_69 (30580, "SO-69"),
    /** NATOID_Sock Eye */
    NATOID_SOCK_EYE (30600, "NATOID_Sock Eye"),
    /** SOM 64 */
    SOM_64 (30645, "SOM 64"),
    /** NATOID_Sorbsiya */
    NATOID_SORBSIYA (30660, "NATOID_Sorbsiya"),
    /** SPADA SIR */
    SPADA_SIR (30665, "SPADA SIR"),
    /** NATOID_SPADA TT */
    NATOID_SPADA_TT (30670, "NATOID_SPADA TT"),
    /** Sparrow (AIM/RIM-7) ILL */
    SPARROW_AIM_RIM_7_ILL (30690, "Sparrow (AIM/RIM-7) ILL"),
    /** SPERRY RASCAR */
    SPERRY_RASCAR (30691, "SPERRY RASCAR"),
    /** SPECTRA */
    SPECTRA (30692, "SPECTRA"),
    /** COMMID_Sperry M-3 */
    COMMID_SPERRY_M_3 (30700, "COMMID_Sperry M-3"),
    /** COMMID_SPERRY VISIONMASTER FT */
    COMMID_SPERRY_VISIONMASTER_FT (30701, "COMMID_SPERRY VISIONMASTER FT"),
    /** SPEXER 2000 */
    SPEXER_2000 (30710, "SPEXER 2000"),
    /** SPG 53F */
    SPG_53F (30735, "SPG 53F"),
    /** SPG 70 (RTN 10X) */
    SPG_70_RTN_10X (30780, "SPG 70 (RTN 10X)"),
    /** SPG 74 (RTN 20X) */
    SPG_74_RTN_20X (30825, "SPG 74 (RTN 20X)"),
    /** SPG 75 (RTN 30X) */
    SPG_75_RTN_30X (30870, "SPG 75 (RTN 30X)"),
    /** SPG 76 (RTN 30X) */
    SPG_76_RTN_30X (30915, "SPG 76 (RTN 30X)"),
    /** NATOID_Spin Scan A */
    NATOID_SPIN_SCAN_A (30960, "NATOID_Spin Scan A"),
    /** NATOID_Spin Scan B */
    NATOID_SPIN_SCAN_B (31005, "NATOID_Spin Scan B"),
    /** NATOID_Spin Trough */
    NATOID_SPIN_TROUGH (31050, "NATOID_Spin Trough"),
    /** SPINO DADDA WTR */
    SPINO_DADDA_WTR (31070, "SPINO DADDA WTR"),
    /** NATOID_Splash Drop */
    NATOID_SPLASH_DROP (31095, "NATOID_Splash Drop"),
    /** SPN-2 */
    SPN_2 (31096, "SPN-2"),
    /** SPN-4 */
    SPN_4 (31097, "SPN-4"),
    /** SPN-30 */
    SPN_30 (31100, "SPN-30"),
    /** SPN 35A */
    SPN_35A (31140, "SPN 35A"),
    /** SPN 41 */
    SPN_41 (31185, "SPN 41"),
    /** SPN 42 */
    SPN_42 (31230, "SPN 42"),
    /** SPN 43A */
    SPN_43A (31275, "SPN 43A"),
    /** SPN 43B */
    SPN_43B (31320, "SPN 43B"),
    /** SPN 44 */
    SPN_44 (31365, "SPN 44"),
    /** SPN 46 */
    SPN_46 (31410, "SPN 46"),
    /** SPN 703 */
    SPN_703 (31455, "SPN 703"),
    /** SPN 720 */
    SPN_720 (31475, "SPN 720"),
    /** SPN 728 (V) 1 */
    SPN_728_V_1 (31500, "SPN 728 (V) 1"),
    /** SPN 748 */
    SPN_748 (31545, "SPN 748"),
    /** SPN 750 */
    SPN_750 (31590, "SPN 750"),
    /** SPO-8 */
    SPO_8 (31592, "SPO-8"),
    /** SPN 753G */
    SPN_753G (31593, "SPN 753G"),
    /** NATOID_Sponge Cake */
    NATOID_SPONGE_CAKE (31635, "NATOID_Sponge Cake"),
    /** P-12 */
    P_12 (31680, "P-12"),
    /** P-18 */
    P_18 (31681, "P-18"),
    /** P-18 */
    P_18_3 (31682, "P-18"),
    /** P-18 */
    P_18_4 (31684, "P-18"),
    /** NATOID_Spork Rest */
    NATOID_SPORK_REST (31700, "NATOID_Spork Rest"),
    /** SPQ 712 (RAN 12 L/X) */
    SPQ_712_RAN_12_L_X (31725, "SPQ 712 (RAN 12 L/X)"),
    /** SPR-51 */
    SPR_51 (31740, "SPR-51"),
    /** SPS 6C */
    SPS_6C (31770, "SPS 6C"),
    /** SPS 10F */
    SPS_10F (31815, "SPS 10F"),
    /** SPS 12 */
    SPS_12 (31860, "SPS 12"),
    /** SPS 58 */
    SPS_58 (31905, "SPS 58"),
    /** SPS-62 */
    SPS_62 (31925, "SPS-62"),
    /** SPS 64 */
    SPS_64 (31950, "SPS 64"),
    /** SPS-141 */
    SPS_141 (31951, "SPS-141"),
    /** SPS-142 */
    SPS_142 (31952, "SPS-142"),
    /** SPS-143 */
    SPS_143 (31953, "SPS-143"),
    /** SPS-161 */
    SPS_161 (31960, "SPS-161"),
    /** SPS 768 (RAN EL) */
    SPS_768_RAN_EL (31995, "SPS 768 (RAN EL)"),
    /** SPS-550K MF */
    SPS_550K_MF (32020, "SPS-550K MF"),
    /** SPS 774 (RAN 10S) */
    SPS_774_RAN_10S (32040, "SPS 774 (RAN 10S)"),
    /** SPY 790 */
    SPY_790 (32085, "SPY 790"),
    /** NATOID_Square Head */
    NATOID_SQUARE_HEAD (32130, "NATOID_Square Head"),
    /** NATOID_Square Pair */
    NATOID_SQUARE_PAIR (32175, "NATOID_Square Pair"),
    /** NATOID_Square Slot */
    NATOID_SQUARE_SLOT (32220, "NATOID_Square Slot"),
    /** NATOID_Square Tie */
    NATOID_SQUARE_TIE (32265, "NATOID_Square Tie"),
    /** Shmel, Add SHMEL National Nomenclature for clarity */
    SHMEL (32310, "Shmel"),
    /** P-15M */
    P_15M (32330, "P-15M"),
    /** NATOID_Squint Eye */
    NATOID_SQUINT_EYE (32355, "NATOID_Squint Eye"),
    /** SQUIRE */
    SQUIRE (32365, "SQUIRE"),
    /** SR2410C */
    SR2410C (32373, "SR2410C"),
    /** SR47B-G */
    SR47B_G (32375, "SR47B-G"),
    /** SRE-M5 */
    SRE_M5 (32385, "SRE-M5"),
    /** SRN 6 */
    SRN_6 (32400, "SRN 6"),
    /** SRN 15 */
    SRN_15 (32445, "SRN 15"),
    /** SRN 206 */
    SRN_206 (32455, "SRN 206"),
    /** SRN 745 */
    SRN_745 (32490, "SRN 745"),
    /** SRO 1 */
    SRO_1 (32535, "SRO 1"),
    /** SRO 2 */
    SRO_2 (32580, "SRO 2"),
    /** NATOID_SS C 2B Samlet MG */
    NATOID_SS_C_2B_SAMLET_MG (32625, "NATOID_SS C 2B Samlet MG"),
    /** NATOID_SS N 2A B CSSC */
    NATOID_SS_N_2A_B_CSSC (32670, "NATOID_SS N 2A B CSSC"),
    /** NATOID_SS N 2A B CSSC 2A 3A2 MH */
    NATOID_SS_N_2A_B_CSSC_2A_3A2_MH (32715, "NATOID_SS N 2A B CSSC 2A 3A2 MH"),
    /** NATOID_SS N 2C Seeker */
    NATOID_SS_N_2C_SEEKER (32760, "NATOID_SS N 2C Seeker"),
    /** NATOID_SS N 2C D Styx */
    NATOID_SS_N_2C_D_STYX (32805, "NATOID_SS N 2C D Styx"),
    /** NATOID_SS N 2C D Styx C D MH */
    NATOID_SS_N_2C_D_STYX_C_D_MH (32850, "NATOID_SS N 2C D Styx C D MH"),
    /** NATOID_SS-N-2C Styx AL */
    NATOID_SS_N_2C_STYX_AL (32851, "NATOID_SS-N-2C Styx AL"),
    /** NATOID_SS-N-2D Styx AL */
    NATOID_SS_N_2D_STYX_AL (32852, "NATOID_SS-N-2D Styx AL"),
    /** NATOID_SS N 3 SSC SS C 18 BN */
    NATOID_SS_N_3_SSC_SS_C_18_BN (32895, "NATOID_SS N 3 SSC SS C 18 BN"),
    /** NATOID_SS N 3B Sepal AL */
    NATOID_SS_N_3B_SEPAL_AL (32940, "NATOID_SS N 3B Sepal AL"),
    /** NATOID_SS N 3B Sepal MH */
    NATOID_SS_N_3B_SEPAL_MH (32985, "NATOID_SS N 3B Sepal MH"),
    /** NATOID_SS-N-7 Starbright */
    NATOID_SS_N_7_STARBRIGHT (33025, "NATOID_SS-N-7 Starbright"),
    /** NATOID_SS N 9 Siren */
    NATOID_SS_N_9_SIREN (33030, "NATOID_SS N 9 Siren"),
    /** NATOID_SS N 9 Siren AL */
    NATOID_SS_N_9_SIREN_AL (33075, "NATOID_SS N 9 Siren AL"),
    /** NATOID_SS N 9 Siren MH */
    NATOID_SS_N_9_SIREN_MH (33120, "NATOID_SS N 9 Siren MH"),
    /** SS-N-10A FL-10 mmW MH */
    SS_N_10A_FL_10_MMW_MH (33125, "SS-N-10A FL-10 mmW MH"),
    /** SS-N-11 Nasr-1 mmW MH */
    SS_N_11_NASR_1_MMW_MH (33140, "SS-N-11 Nasr-1 mmW MH"),
    /** NATOID_SS N 12 Sandbox AL */
    NATOID_SS_N_12_SANDBOX_AL (33165, "NATOID_SS N 12 Sandbox AL"),
    /** SS-N-12 YJ-83J mmW MH */
    SS_N_12_YJ_83J_MMW_MH (33166, "SS-N-12 YJ-83J mmW MH"),
    /** NATOID_SS N 12 Sandbox MH */
    NATOID_SS_N_12_SANDBOX_MH (33210, "NATOID_SS N 12 Sandbox MH"),
    /** NATOID_SS-NX-13 Shredder */
    NATOID_SS_NX_13_SHREDDER (33230, "NATOID_SS-NX-13 Shredder"),
    /** NATOID_SS-N-14B Silex AL */
    NATOID_SS_N_14B_SILEX_AL (33231, "NATOID_SS-N-14B Silex AL"),
    /** NATOID_SS N 19 Shipwreck */
    NATOID_SS_N_19_SHIPWRECK (33255, "NATOID_SS N 19 Shipwreck"),
    /** NATOID_SS N 19 Shipwreck AL */
    NATOID_SS_N_19_SHIPWRECK_AL (33300, "NATOID_SS N 19 Shipwreck AL"),
    /** NATOID_SS N 19 Shipwreck MH */
    NATOID_SS_N_19_SHIPWRECK_MH (33345, "NATOID_SS N 19 Shipwreck MH"),
    /** NATOID_SS N 21 AL */
    NATOID_SS_N_21_AL (33390, "NATOID_SS N 21 AL"),
    /** NATOID_SS N 22 Sunburn */
    NATOID_SS_N_22_SUNBURN (33435, "NATOID_SS N 22 Sunburn"),
    /** NATOID_SS N 22 Sunburn MH */
    NATOID_SS_N_22_SUNBURN_MH (33480, "NATOID_SS N 22 Sunburn MH"),
    /** NATOID_SS-N-22 Sunburn AL */
    NATOID_SS_N_22_SUNBURN_AL (33481, "NATOID_SS-N-22 Sunburn AL"),
    /** NATOID_SS-N-25 Switchblade MH */
    NATOID_SS_N_25_SWITCHBLADE_MH (33483, "NATOID_SS-N-25 Switchblade MH"),
    /** SS-N-26 Strobile MMW MH */
    SS_N_26_STROBILE_MMW_MH (33484, "SS-N-26 Strobile MMW MH"),
    /** NATOID_SS-N-27 Sizzler MH */
    NATOID_SS_N_27_SIZZLER_MH (33485, "NATOID_SS-N-27 Sizzler MH"),
    /** NATOID_SS-N-27A Sizzler AL */
    NATOID_SS_N_27A_SIZZLER_AL (33486, "NATOID_SS-N-27A Sizzler AL"),
    /** COMMID_STING EO Mk2 */
    COMMID_STING_EO_MK2 (33505, "COMMID_STING EO Mk2"),
    /** COMMID_STIR 1.2 EO Mk2 */
    COMMID_STIR_12_EO_MK2 (33510, "COMMID_STIR 1.2 EO Mk2"),
    /** COMMID_STIR 2.4 HP Mk2 */
    COMMID_STIR_24_HP_MK2 (33511, "COMMID_STIR 2.4 HP Mk2"),
    /** NATOID_Stone Cake */
    NATOID_STONE_CAKE (33525, "NATOID_Stone Cake"),
    /** STR 41 */
    STR_41 (33570, "STR 41"),
    /** ST-858 */
    ST_858 (33580, "ST-858"),
    /** START-1M */
    START_1M (33582, "START-1M"),
    /** STENTOR */
    STENTOR (33584, "STENTOR"),
    /** STRAIGHT FLUSH */
    STRAIGHT_FLUSH (33586, "STRAIGHT FLUSH"),
    /** NATOID_Straight Flush TA */
    NATOID_STRAIGHT_FLUSH_TA (33590, "NATOID_Straight Flush TA"),
    /** NATOID_Straight Flush TT */
    NATOID_STRAIGHT_FLUSH_TT (33595, "NATOID_Straight Flush TT"),
    /** NATOID_Straight Flush ILL */
    NATOID_STRAIGHT_FLUSH_ILL (33600, "NATOID_Straight Flush ILL"),
    /** NATOID_Strike Out */
    NATOID_STRIKE_OUT (33615, "NATOID_Strike Out"),
    /** NATOID_Strut Curve */
    NATOID_STRUT_CURVE (33660, "NATOID_Strut Curve"),
    /** NATOID_Strut Pair */
    NATOID_STRUT_PAIR (33705, "NATOID_Strut Pair"),
    /** NATOID_Strut Pair 1 */
    NATOID_STRUT_PAIR_1 (33750, "NATOID_Strut Pair 1"),
    /** NATOID_Strut Pair 2 */
    NATOID_STRUT_PAIR_2 (33795, "NATOID_Strut Pair 2"),
    /** NATOID_Sun Visor */
    NATOID_SUN_VISOR (33840, "NATOID_Sun Visor"),
    /** SUPERDARN */
    SUPERDARN (33850, "SUPERDARN"),
    /** Superfledermaus */
    SUPERFLEDERMAUS (33860, "Superfledermaus"),
    /** Supersearcher */
    SUPERSEARCHER (33870, "Supersearcher"),
    /** NATOID_Swift Rod 1 */
    NATOID_SWIFT_ROD_1 (33885, "NATOID_Swift Rod 1"),
    /** NATOID_Swift Rod 2 */
    NATOID_SWIFT_ROD_2 (33930, "NATOID_Swift Rod 2"),
    /** SYMPHONY */
    SYMPHONY (33933, "SYMPHONY"),
    /** SYNAPSIS Mk2 */
    SYNAPSIS_MK2 (33935, "SYNAPSIS Mk2"),
    /** NATOID_T1166 */
    NATOID_T1166 (33975, "NATOID_T1166"),
    /** NATOID_T1171 */
    NATOID_T1171 (34020, "NATOID_T1171"),
    /** NATOID_T1202 */
    NATOID_T1202 (34040, "NATOID_T1202"),
    /** NATOID_T6004 */
    NATOID_T6004 (34065, "NATOID_T6004"),
    /** NATOID_T6031 */
    NATOID_T6031 (34110, "NATOID_T6031"),
    /** NATOID_T8067 */
    NATOID_T8067 (34155, "NATOID_T8067"),
    /** NATOID_T8068 */
    NATOID_T8068 (34200, "NATOID_T8068"),
    /** NATOID_T8124 */
    NATOID_T8124 (34245, "NATOID_T8124"),
    /** NATOID_T8408 */
    NATOID_T8408 (34290, "NATOID_T8408"),
    /** NATOID_T8911 */
    NATOID_T8911 (34335, "NATOID_T8911"),
    /** NATOID_T8937 */
    NATOID_T8937 (34380, "NATOID_T8937"),
    /** NATOID_T8944 */
    NATOID_T8944 (34425, "NATOID_T8944"),
    /** NATOID_T8987 */
    NATOID_T8987 (34470, "NATOID_T8987"),
    /** TA-10K */
    TA_10K (34480, "TA-10K"),
    /** JY-11B */
    JY_11B (34500, "JY-11B"),
    /** TACAN/SURF */
    TACAN_SURF (34505, "TACAN/SURF"),
    /** P-14 */
    P_14_2 (34515, "P-14"),
    /** NATOID_TALL KING B */
    NATOID_TALL_KING_B (34516, "NATOID_TALL KING B"),
    /** NATOID_TALL KING C */
    NATOID_TALL_KING_C (34517, "NATOID_TALL KING C"),
    /** NATOID_Tall Mike */
    NATOID_TALL_MIKE (34560, "NATOID_Tall Mike"),
    /** NATOID_Tall Path */
    NATOID_TALL_PATH (34605, "NATOID_Tall Path"),
    /** TDR-94 (MODE S) */
    TDR_94_MODE_S (34607, "TDR-94 (MODE S)"),
    /** NATOID_Tea Spoon */
    NATOID_TEA_SPOON (34610, "NATOID_Tea Spoon"),
    /** NATOID_Team Play */
    NATOID_TEAM_PLAY (34620, "NATOID_Team Play"),
    /** TALISMAN */
    TALISMAN (34624, "TALISMAN"),
    /** NATOID_Team Work */
    NATOID_TEAM_WORK (34625, "NATOID_Team Work"),
    /** T1135 */
    T1135 (34626, "T1135"),
    /** TANCAN/SURF */
    TANCAN_SURF (34627, "TANCAN/SURF"),
    /** TECSAR */
    TECSAR (34628, "TECSAR"),
    /** TERRASAR-X */
    TERRASAR_X (34629, "TERRASAR-X"),
    /** TESAR */
    TESAR (34630, "TESAR"),
    /** THAAD GBR */
    THAAD_GBR (34640, "THAAD GBR"),
    /** Thales Nederland Signaal APAR */
    THALES_NEDERLAND_SIGNAAL_APAR (34645, "Thales Nederland Signaal APAR"),
    /** Thales Variant */
    THALES_VARIANT (34647, "Thales Variant"),
    /** THD 225 */
    THD_225 (34650, "THD 225"),
    /** THD 1012 */
    THD_1012 (34655, "THD 1012"),
    /** THD 1098 */
    THD_1098 (34660, "THD 1098"),
    /** THD 1213 */
    THD_1213 (34665, "THD 1213"),
    /** THD 1940 */
    THD_1940 (34670, "THD 1940"),
    /** THD-1955 Palmier */
    THD_1955_PALMIER (34680, "THD-1955 Palmier"),
    /** THD 5500 */
    THD_5500 (34695, "THD 5500"),
    /** NATOID_Thin Path */
    NATOID_THIN_PATH (34740, "NATOID_Thin Path"),
    /** PRV-9 */
    PRV_9 (34785, "PRV-9"),
    /** PRV-16 */
    PRV_16 (34786, "PRV-16"),
    /** COMMID_Thompson CSF TA-10 */
    COMMID_THOMPSON_CSF_TA_10 (34795, "COMMID_Thompson CSF TA-10"),
    /** COMMID_Thompson CSF TH D 1040 Neptune */
    COMMID_THOMPSON_CSF_TH_D_1040_NEPTUNE (34830, "COMMID_Thompson CSF TH D 1040 Neptune"),
    /** COMMID_Thompson CSF Calypso */
    COMMID_THOMPSON_CSF_CALYPSO (34875, "COMMID_Thompson CSF Calypso"),
    /** COMMID_Thompson CSF CASTOR */
    COMMID_THOMPSON_CSF_CASTOR (34920, "COMMID_Thompson CSF CASTOR"),
    /** COMMID_Thompson CSF Castor II */
    COMMID_THOMPSON_CSF_CASTOR_II (34965, "COMMID_Thompson CSF Castor II"),
    /** COMMID_Thompson CSF DRBC 32A */
    COMMID_THOMPSON_CSF_DRBC_32A (35010, "COMMID_Thompson CSF DRBC 32A"),
    /** COMMID_Thompson CSF DRBJ 11 DE */
    COMMID_THOMPSON_CSF_DRBJ_11_DE (35055, "COMMID_Thompson CSF DRBJ 11 DE"),
    /** COMMID_Thompson CSF DRBV 15A */
    COMMID_THOMPSON_CSF_DRBV_15A (35100, "COMMID_Thompson CSF DRBV 15A"),
    /** COMMID_Thompson CSF DRBV 15C */
    COMMID_THOMPSON_CSF_DRBV_15C (35145, "COMMID_Thompson CSF DRBV 15C"),
    /** COMMID_Thompson CSF DRBV 22D */
    COMMID_THOMPSON_CSF_DRBV_22D (35190, "COMMID_Thompson CSF DRBV 22D"),
    /** COMMID_Thompson CSF DRBV 23B */
    COMMID_THOMPSON_CSF_DRBV_23B (35235, "COMMID_Thompson CSF DRBV 23B"),
    /** COMMID_Thompson CSF DRUA 33 */
    COMMID_THOMPSON_CSF_DRUA_33 (35280, "COMMID_Thompson CSF DRUA 33"),
    /** COMMID_Thompson CSF Mars DRBV 21A */
    COMMID_THOMPSON_CSF_MARS_DRBV_21A (35325, "COMMID_Thompson CSF Mars DRBV 21A"),
    /** COMMID_Thompson CSF Sea Tiger */
    COMMID_THOMPSON_CSF_SEA_TIGER (35370, "COMMID_Thompson CSF Sea Tiger"),
    /** COMMID_Thompson CSF Triton */
    COMMID_THOMPSON_CSF_TRITON (35415, "COMMID_Thompson CSF Triton"),
    /** COMMID_Thompson CSF Vega with DRBC 32E */
    COMMID_THOMPSON_CSF_VEGA_WITH_DRBC_32E (35460, "COMMID_Thompson CSF Vega with DRBC 32E"),
    /** Thomson ENR (European Navy Radar) */
    THOMSON_ENR_EUROPEAN_NAVY_RADAR (35470, "Thomson ENR (European Navy Radar)"),
    /** Thomson RDI */
    THOMSON_RDI (35475, "Thomson RDI"),
    /** Tier II Plus */
    TIER_II_PLUS (35477, "Tier II Plus"),
    /** TPS-755 */
    TPS_755 (35478, "TPS-755"),
    /** TPS-830K */
    TPS_830K (35479, "TPS-830K"),
    /** TRS-2105 */
    TRS_2105 (35480, "TRS-2105"),
    /** TR-23K */
    TR_23K (35481, "TR-23K"),
    /** TR-23MR */
    TR_23MR (35482, "TR-23MR"),
    /** TRAC-2100 */
    TRAC_2100 (35483, "TRAC-2100"),
    /** TRAC-2300 */
    TRAC_2300 (35484, "TRAC-2300"),
    /** HT-223 */
    HT_223 (35485, "HT-223"),
    /** TRADEX */
    TRADEX (35486, "TRADEX"),
    /** TRAIL XI */
    TRAIL_XI (35487, "TRAIL XI"),
    /** TRD-1211 */
    TRD_1211 (35488, "TRD-1211"),
    /** TRD-1235 */
    TRD_1235 (35489, "TRD-1235"),
    /** TRS-2100 */
    TRS_2100 (35490, "TRS-2100"),
    /** TRAC NG */
    TRAC_NG (35491, "TRAC NG"),
    /** NATOID_Tie Rods */
    NATOID_TIE_RODS (35505, "NATOID_Tie Rods"),
    /** 36D6 */
    _36D6 (35550, "36D6"),
    /** NATOID_Tin Trap */
    NATOID_TIN_TRAP (35570, "NATOID_Tin Trap"),
    /** TIRSPONDER */
    TIRSPONDER (35580, "TIRSPONDER"),
    /** TK-25E-5 */
    TK_25E_5 (35583, "TK-25E-5"),
    /** TMK Mk2 */
    TMK_MK2 (35585, "TMK Mk2"),
    /** TMX Mk2 */
    TMX_MK2 (35586, "TMX Mk2"),
    /** NATOID_Toad Stool 1 */
    NATOID_TOAD_STOOL_1 (35595, "NATOID_Toad Stool 1"),
    /** NATOID_Toad Stool 2 */
    NATOID_TOAD_STOOL_2 (35640, "NATOID_Toad Stool 2"),
    /** NATOID_Toad Stool 3 */
    NATOID_TOAD_STOOL_3 (35685, "NATOID_Toad Stool 3"),
    /** NATOID_Toad Stool 4 */
    NATOID_TOAD_STOOL_4 (35730, "NATOID_Toad Stool 4"),
    /** NATOID_Toad Stool 5 */
    NATOID_TOAD_STOOL_5 (35775, "NATOID_Toad Stool 5"),
    /** Token B */
    TOKEN_B (35785, "Token B"),
    /** NATOID_Tomb Stone */
    NATOID_TOMB_STONE (35800, "NATOID_Tomb Stone"),
    /** Tonson */
    TONSON (35810, "Tonson"),
    /** NATOID_Top Bow */
    NATOID_TOP_BOW (35820, "NATOID_Top Bow"),
    /** NATOID_Top Dome */
    NATOID_TOP_DOME (35865, "NATOID_Top Dome"),
    /** NATOID_Top Knot */
    NATOID_TOP_KNOT (35910, "NATOID_Top Knot"),
    /** NATOID_Top Mesh */
    NATOID_TOP_MESH (35955, "NATOID_Top Mesh"),
    /** NATOID_Top Pair */
    NATOID_TOP_PAIR (36000, "NATOID_Top Pair"),
    /** NATOID_Top Plate */
    NATOID_TOP_PLATE (36045, "NATOID_Top Plate"),
    /** NATOID_Top Plate B */
    NATOID_TOP_PLATE_B (36046, "NATOID_Top Plate B"),
    /** NATOID_Top Sail */
    NATOID_TOP_SAIL (36090, "NATOID_Top Sail"),
    /** TYPE-208 */
    TYPE_208 (36120, "TYPE-208"),
    /** NATOID_Top Steer */
    NATOID_TOP_STEER (36135, "NATOID_Top Steer"),
    /** NATOID_Top Trough */
    NATOID_TOP_TROUGH (36180, "NATOID_Top Trough"),
    /** Tornado GMR */
    TORNADO_GMR (36200, "Tornado GMR"),
    /** Tornado TFR */
    TORNADO_TFR (36201, "Tornado TFR"),
    /** NATOID_Scrum Half TA */
    NATOID_SCRUM_HALF_TA (36220, "NATOID_Scrum Half TA"),
    /** NATOID_Scrum Half TT */
    NATOID_SCRUM_HALF_TT (36225, "NATOID_Scrum Half TT"),
    /** TOR-M2 TER */
    TOR_M2_TER (36226, "TOR-M2 TER"),
    /** NATOID_Scrum Half MG */
    NATOID_SCRUM_HALF_MG (36230, "NATOID_Scrum Half MG"),
    /** NATOID_Track Dish */
    NATOID_TRACK_DISH (36270, "NATOID_Track Dish"),
    /** TORSO M */
    TORSO_M (36315, "TORSO M"),
    /** TQN-2 */
    TQN_2 (36320, "TQN-2"),
    /** NATOID_Trap Door */
    NATOID_TRAP_DOOR (36360, "NATOID_Trap Door"),
    /** TRD-1500 */
    TRD_1500 (36365, "TRD-1500"),
    /** NATOID_Trick Shot TAR */
    NATOID_TRICK_SHOT_TAR (36370, "NATOID_Trick Shot TAR"),
    /** NATOID_Trick Shot TER */
    NATOID_TRICK_SHOT_TER (36371, "NATOID_Trick Shot TER"),
    /** TRISPONDE */
    TRISPONDE (36380, "TRISPONDE"),
    /** TRML */
    TRML (36381, "TRML"),
    /** TRML-3D */
    TRML_3D (36383, "TRML-3D"),
    /** TRM-S */
    TRM_S (36384, "TRM-S"),
    /** TRS-2056 */
    TRS_2056 (36385, "TRS-2056"),
    /** TRS 3010 */
    TRS_3010 (36386, "TRS 3010"),
    /** TRS-2060 */
    TRS_2060 (36387, "TRS-2060"),
    /** TRS-2245 */
    TRS_2245 (36388, "TRS-2245"),
    /** TRS-2310 */
    TRS_2310 (36389, "TRS-2310"),
    /** Triton G */
    TRITON_G (36390, "Triton G"),
    /** TRS-22XX */
    TRS_22XX (36391, "TRS-22XX"),
    /** TRS 3030 */
    TRS_3030 (36400, "TRS 3030"),
    /** TRS 3033 */
    TRS_3033 (36405, "TRS 3033"),
    /** TRS 3203 */
    TRS_3203 (36417, "TRS 3203"),
    /** TRS 3405 */
    TRS_3405 (36420, "TRS 3405"),
    /** TRS 3410 */
    TRS_3410 (36425, "TRS 3410"),
    /** TRS 3415 */
    TRS_3415 (36430, "TRS 3415"),
    /** TRS-3D */
    TRS_3D (36440, "TRS-3D"),
    /** TRS-3D/16 */
    TRS_3D_16 (36441, "TRS-3D/16"),
    /** TRS-3D/16-ES */
    TRS_3D_16_ES (36442, "TRS-3D/16-ES"),
    /** TRS-3D/32 */
    TRS_3D_32 (36443, "TRS-3D/32"),
    /** TRS-4D */
    TRS_4D (36446, "TRS-4D"),
    /** TRS-C */
    TRS_C (36447, "TRS-C"),
    /** TRS-N */
    TRS_N (36450, "TRS-N"),
    /** TS-4478A */
    TS_4478A (36460, "TS-4478A"),
    /** TSE 5000 */
    TSE_5000 (36495, "TSE 5000"),
    /** TSR 333 */
    TSR_333 (36540, "TSR 333"),
    /** TSR 793 */
    TSR_793 (36550, "TSR 793"),
    /** NATOID_Tub Brick */
    NATOID_TUB_BRICK (36563, "NATOID_Tub Brick"),
    /** NATOID_Tube Arm */
    NATOID_TUBE_ARM (36585, "NATOID_Tube Arm"),
    /** TW 1374 */
    TW_1374 (36590, "TW 1374"),
    /** TW 1378 */
    TW_1378 (36595, "TW 1378"),
    /** TW 1446 */
    TW_1446 (36600, "TW 1446"),
    /** NATOID_Twin Eyes */
    NATOID_TWIN_EYES (36630, "NATOID_Twin Eyes"),
    /** NATOID_Twin Pill */
    NATOID_TWIN_PILL (36675, "NATOID_Twin Pill"),
    /** NATOID_Twin Scan */
    NATOID_TWIN_SCAN (36720, "NATOID_Twin Scan"),
    /** NATOID_Twin Scan Ro */
    NATOID_TWIN_SCAN_RO (36765, "NATOID_Twin Scan Ro"),
    /** NATOID_Two Spot */
    NATOID_TWO_SPOT (36810, "NATOID_Two Spot"),
    /** Type 2-12 J/A */
    TYPE_2_12_J_A (36827, "Type 2-12 J/A"),
    /** Type 2-21 J/A */
    TYPE_2_21_J_A (36830, "Type 2-21 J/A"),
    /** Type 2-23 */
    TYPE_2_23 (36835, "Type 2-23"),
    /** Type 80/ASM-1 */
    TYPE_80_ASM_1 (36836, "Type 80/ASM-1"),
    /** Type 208 */
    TYPE_208_2 (36840, "Type 208"),
    /** Type 222 */
    TYPE_222 (36843, "Type 222"),
    /** Type 226 */
    TYPE_226 (36846, "Type 226"),
    /** Type 232H */
    TYPE_232H (36850, "Type 232H"),
    /** TYPE 245 */
    TYPE_245 (36853, "TYPE 245"),
    /** TYPE 262 */
    TYPE_262 (36855, "TYPE 262"),
    /** TYPE 275 */
    TYPE_275 (36900, "TYPE 275"),
    /** TYPE 278 */
    TYPE_278 (36905, "TYPE 278"),
    /** TYPE 293 */
    TYPE_293 (36945, "TYPE 293"),
    /** Type 341 */
    TYPE_341 (36946, "Type 341"),
    /** TYPE 313 */
    TYPE_313 (36947, "TYPE 313"),
    /** Type 334 */
    TYPE_334 (36960, "Type 334"),
    /** Type 342 */
    TYPE_342 (36985, "Type 342"),
    /** TYPE 343 SUN VISOR B */
    TYPE_343_SUN_VISOR_B (36990, "TYPE 343 SUN VISOR B"),
    /** Type 344 */
    TYPE_344 (36992, "Type 344"),
    /** Type 345 */
    TYPE_345 (37010, "Type 345"),
    /** TYPE 347B */
    TYPE_347B (37035, "TYPE 347B"),
    /** Type 347G */
    TYPE_347G (37038, "Type 347G"),
    /** Type 359 */
    TYPE_359 (37039, "Type 359"),
    /** Type 352 */
    TYPE_352 (37040, "Type 352"),
    /** Type 360 */
    TYPE_360 (37041, "Type 360"),
    /** Type 362 ESR-1 SR-47B */
    TYPE_362_ESR_1_SR_47B (37043, "Type 362 ESR-1 SR-47B"),
    /** Type 354 */
    TYPE_354 (37045, "Type 354"),
    /** Type 363 */
    TYPE_363 (37048, "Type 363"),
    /** Type 364 */
    TYPE_364 (37049, "Type 364"),
    /** Type-404A(CH) */
    TYPE_404ACH (37050, "Type-404A(CH)"),
    /** Type 405 */
    TYPE_405 (37052, "Type 405"),
    /** TYPE 405J */
    TYPE_405J (37053, "TYPE 405J"),
    /** Type 408D */
    TYPE_408D (37058, "Type 408D"),
    /** Type 517B */
    TYPE_517B (37059, "Type 517B"),
    /** Type 518 (Hai Ying, God Eye, REL-2) */
    TYPE_518_HAI_YING_GOD_EYE_REL_2 (37060, "Type 518 (Hai Ying, God Eye, REL-2)"),
    /** Type 589 */
    TYPE_589 (37070, "Type 589"),
    /** TYPE 651 */
    TYPE_651 (37073, "TYPE 651"),
    /** Type 753 */
    TYPE_753 (37075, "Type 753"),
    /** Type 702 */
    TYPE_702 (37077, "Type 702"),
    /** Type 704 */
    TYPE_704 (37078, "Type 704"),
    /** Type 753 */
    TYPE_753_2 (37079, "Type 753"),
    /** Type 756 */
    TYPE_756 (37080, "Type 756"),
    /** TYPE 713 */
    TYPE_713 (37081, "TYPE 713"),
    /** TYPE 714 */
    TYPE_714 (37082, "TYPE 714"),
    /** TYPE 702-D */
    TYPE_702_D (37083, "TYPE 702-D"),
    /** Type 815 */
    TYPE_815 (37090, "Type 815"),
    /** Type 793 */
    TYPE_793 (37095, "Type 793"),
    /** Type 8A-813 */
    TYPE_8A_813 (37100, "Type 8A-813"),
    /** TYPE 901M */
    TYPE_901M (37105, "TYPE 901M"),
    /** TYPE 902 */
    TYPE_902 (37110, "TYPE 902"),
    /** Type 902B */
    TYPE_902B (37124, "Type 902B"),
    /** TYPE 903 */
    TYPE_903 (37125, "TYPE 903"),
    /** TYPE 909 TI */
    TYPE_909_TI (37170, "TYPE 909 TI"),
    /** TYPE 909 TT */
    TYPE_909_TT (37215, "TYPE 909 TT"),
    /** TYPE 910 */
    TYPE_910 (37260, "TYPE 910"),
    /** TYPE-931(CH) */
    TYPE_931CH (37265, "TYPE-931(CH)"),
    /** TYPE 965 */
    TYPE_965 (37305, "TYPE 965"),
    /** TYPE 967 */
    TYPE_967 (37350, "TYPE 967"),
    /** TYPE 968 */
    TYPE_968 (37395, "TYPE 968"),
    /** TYPE 974 */
    TYPE_974 (37440, "TYPE 974"),
    /** TYPE 975 */
    TYPE_975 (37485, "TYPE 975"),
    /** TYPE 978 */
    TYPE_978 (37530, "TYPE 978"),
    /** Type 981 */
    TYPE_981 (37534, "Type 981"),
    /** TYPE 982 */
    TYPE_982 (37540, "TYPE 982"),
    /** TYPE 992 */
    TYPE_992 (37575, "TYPE 992"),
    /** TYPE 993 */
    TYPE_993 (37620, "TYPE 993"),
    /** TYPE 994 */
    TYPE_994 (37665, "TYPE 994"),
    /** Type 996 */
    TYPE_996 (37670, "Type 996"),
    /** Type 997 Artisan */
    TYPE_997_ARTISAN (37675, "Type 997 Artisan"),
    /** TYPE 1006(1) */
    TYPE_10061 (37710, "TYPE 1006(1)"),
    /** TYPE 1006(2) */
    TYPE_10062 (37755, "TYPE 1006(2)"),
    /** TYPE 1022 */
    TYPE_1022 (37800, "TYPE 1022"),
    /** Type 1047 */
    TYPE_1047 (37810, "Type 1047"),
    /** Type 1048 */
    TYPE_1048 (37815, "Type 1048"),
    /** ULTRA */
    ULTRA (37840, "ULTRA"),
    /** UK MK 10 */
    UK_MK_10 (37845, "UK MK 10"),
    /** UPS-220C */
    UPS_220C (37850, "UPS-220C"),
    /** UPX 1 10 */
    UPX_1_10 (37890, "UPX 1 10"),
    /** UPX 27 */
    UPX_27 (37935, "UPX 27"),
    /** URN 20 */
    URN_20 (37980, "URN 20"),
    /** UTES-A */
    UTES_A (37985, "UTES-A"),
    /** UTES-T */
    UTES_T (37990, "UTES-T"),
    /** URN 25 */
    URN_25 (38025, "URN 25"),
    /** VIGILANT */
    VIGILANT (38035, "VIGILANT"),
    /** VOLEX III/IV */
    VOLEX_III_IV (38045, "VOLEX III/IV"),
    /** VOLGA */
    VOLGA (38046, "VOLGA"),
    /** VORONEZH-DM */
    VORONEZH_DM (38047, "VORONEZH-DM"),
    /** VOSTOK */
    VOSTOK (38048, "VOSTOK"),
    /** VOSTOK-E */
    VOSTOK_E (38049, "VOSTOK-E"),
    /** VSR */
    VSR (38050, "VSR"),
    /** VSTAR-PT */
    VSTAR_PT (38055, "VSTAR-PT"),
    /** W-160 */
    W_160 (38058, "W-160"),
    /** W1028 */
    W1028 (38060, "W1028"),
    /** W8818 */
    W8818 (38070, "W8818"),
    /** W8838 */
    W8838 (38115, "W8838"),
    /** W8852 */
    W8852 (38120, "W8852"),
    /** NATOID_WALL BOARD */
    NATOID_WALL_BOARD (38140, "NATOID_WALL BOARD"),
    /** NATOID_Wall Rust */
    NATOID_WALL_RUST (38150, "NATOID_Wall Rust"),
    /** WAS-74S */
    WAS_74S (38160, "WAS-74S"),
    /** NATOID_Wasp Head */
    NATOID_WASP_HEAD (38205, "NATOID_Wasp Head"),
    /** WATCHDOG */
    WATCHDOG (38210, "WATCHDOG"),
    /** NATOID_Watch Guard */
    NATOID_WATCH_GUARD (38250, "NATOID_Watch Guard"),
    /** Watchman */
    WATCHMAN (38260, "Watchman"),
    /** WATCHMAN-S */
    WATCHMAN_S (38275, "WATCHMAN-S"),
    /** WATCHMAN-T */
    WATCHMAN_T (38276, "WATCHMAN-T"),
    /** WEATHER SCOUT 2 */
    WEATHER_SCOUT_2 (38280, "WEATHER SCOUT 2"),
    /** COMMID_Western Electric MK 10 */
    COMMID_WESTERN_ELECTRIC_MK_10 (38295, "COMMID_Western Electric MK 10"),
    /** COMMID_Westinghouse ADR-4 LRSR */
    COMMID_WESTINGHOUSE_ADR_4_LRSR (38320, "COMMID_Westinghouse ADR-4 LRSR"),
    /** COMMID_Westinghouse Electric SPG 50 */
    COMMID_WESTINGHOUSE_ELECTRIC_SPG_50 (38340, "COMMID_Westinghouse Electric SPG 50"),
    /** COMMID_Westinghouse Electric W 120 */
    COMMID_WESTINGHOUSE_ELECTRIC_W_120 (38385, "COMMID_Westinghouse Electric W 120"),
    /** COMMID_Westinghouse SPS 29C */
    COMMID_WESTINGHOUSE_SPS_29C (38430, "COMMID_Westinghouse SPS 29C"),
    /** COMMID_Westinghouse SPS 37 */
    COMMID_WESTINGHOUSE_SPS_37 (38475, "COMMID_Westinghouse SPS 37"),
    /** Wet Eye */
    WET_EYE (38520, "Wet Eye"),
    /** Wet Eye 2 */
    WET_EYE_2 (38525, "Wet Eye 2"),
    /** Wet Eye Mod */
    WET_EYE_MOD (38565, "Wet Eye Mod"),
    /** WF44S */
    WF44S (38568, "WF44S"),
    /** WGU-41/B */
    WGU_41_B (38570, "WGU-41/B"),
    /** WGU-44/B */
    WGU_44_B (38572, "WGU-44/B"),
    /** NATOID_Whiff */
    NATOID_WHIFF (38610, "NATOID_Whiff"),
    /** NATOID_Whiff Brick */
    NATOID_WHIFF_BRICK (38655, "NATOID_Whiff Brick"),
    /** NATOID_Whiff Fire */
    NATOID_WHIFF_FIRE (38700, "NATOID_Whiff Fire"),
    /** NATOID_WHITE HOUSE */
    NATOID_WHITE_HOUSE (38715, "NATOID_WHITE HOUSE"),
    /** NATOID_Wide Mat */
    NATOID_WIDE_MAT (38730, "NATOID_Wide Mat"),
    /** Wild Card */
    WILD_CARD (38745, "Wild Card"),
    /** WILDCAT */
    WILDCAT (38748, "WILDCAT"),
    /** NATOID_Witch Eight */
    NATOID_WITCH_EIGHT (38790, "NATOID_Witch Eight"),
    /** NATOID_Witch Five */
    NATOID_WITCH_FIVE (38835, "NATOID_Witch Five"),
    /** WLR */
    WLR (38840, "WLR"),
    /** WM2X Series */
    WM2X_SERIES (38880, "WM2X Series"),
    /** WM2X Series CAS */
    WM2X_SERIES_CAS (38925, "WM2X Series CAS"),
    /** WR-10X */
    WR_10X (38930, "WR-10X"),
    /** WSR-74C */
    WSR_74C (38950, "WSR-74C"),
    /** WSR-74S */
    WSR_74S (38955, "WSR-74S"),
    /** WSR-81 */
    WSR_81 (38957, "WSR-81"),
    /** WXR-700C */
    WXR_700C (38960, "WXR-700C"),
    /** NATOID_Wood Gage */
    NATOID_WOOD_GAGE (38970, "NATOID_Wood Gage"),
    /** X-TAR25 */
    X_TAR25 (38990, "X-TAR25"),
    /** YAOGAN 3 */
    YAOGAN_3 (39000, "YAOGAN 3"),
    /** Yaogan-29 */
    YAOGAN_29 (39014, "Yaogan-29"),
    /** NATOID_Yard Rake */
    NATOID_YARD_RAKE (39015, "NATOID_Yard Rake"),
    /** NATOID_Yew Loop */
    NATOID_YEW_LOOP (39060, "NATOID_Yew Loop"),
    /** YITIAN ADS */
    YITIAN_ADS (39061, "YITIAN ADS"),
    /** YD-3 */
    YD_3 (39062, "YD-3"),
    /** YJ-12 MH */
    YJ_12_MH (39063, "YJ-12 MH"),
    /** YJ-62 MH */
    YJ_62_MH (39065, "YJ-62 MH"),
    /** YJ-82 MH */
    YJ_82_MH (39066, "YJ-82 MH"),
    /** YJ-83 MH */
    YJ_83_MH (39067, "YJ-83 MH"),
    /** YLC-2 */
    YLC_2 (39070, "YLC-2"),
    /** YLC-2A */
    YLC_2A (39071, "YLC-2A"),
    /** YLC-4 */
    YLC_4 (39073, "YLC-4"),
    /** YLC-6 */
    YLC_6 (39074, "YLC-6"),
    /** YLC-6M */
    YLC_6M (39075, "YLC-6M"),
    /** YLC-8 */
    YLC_8 (39080, "YLC-8"),
    /** YLC-8B */
    YLC_8B (39081, "YLC-8B"),
    /** YLC-18 */
    YLC_18 (39085, "YLC-18"),
    /** NATOID_Yo-Yo */
    NATOID_YO_YO (39105, "NATOID_Yo-Yo"),
    /** Zoo Park 1 */
    ZOO_PARK_1 (39125, "Zoo Park 1"),
    /** ZPS-6 */
    ZPS_6 (39126, "ZPS-6"),
    /** ZD-12 */
    ZD_12 (39131, "ZD-12"),
    /** ZW-06 */
    ZW_06 (39150, "ZW-06"),
    /** AN/ALQ-136(V)1 */
    AN_ALQ_136V1 (39200, "AN/ALQ-136(V)1"),
    /** AN/ALQ-136(V)2 */
    AN_ALQ_136V2 (39201, "AN/ALQ-136(V)2"),
    /** AN/ALQ-136(V)3 */
    AN_ALQ_136V3 (39202, "AN/ALQ-136(V)3"),
    /** AN/ALQ-136(V)4 */
    AN_ALQ_136V4 (39203, "AN/ALQ-136(V)4"),
    /** AN/ALQ-136(V)5 */
    AN_ALQ_136V5 (39204, "AN/ALQ-136(V)5"),
    /** AN/ALQ-162(V)2, See also 1638 */
    AN_ALQ_162V2 (39210, "AN/ALQ-162(V)2"),
    /** AN/ALQ-162(V)3 */
    AN_ALQ_162V3 (39211, "AN/ALQ-162(V)3"),
    /** AN/ALQ-162(V)4 */
    AN_ALQ_162V4 (39212, "AN/ALQ-162(V)4"),
    /** Zhuk-M */
    ZHUK_M (45300, "Zhuk-M"),
    /** ZHUK-MAE */
    ZHUK_MAE (45303, "ZHUK-MAE"),
    /** ZHUK-MME */
    ZHUK_MME (45305, "ZHUK-MME"); /*here*/

    private int value;
    private final String description;

    /** Constructor */
    EmitterNameAdditional(int value, String description)
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
      return 16;
    }

    /** provide enumeration for a given value
     * @param i integer value of interest
     * @return enumeration corresponding to numeric value
     */
    public static EmitterNameAdditional getEnumForValue(int i)
    {
       for(EmitterNameAdditional val: EmitterNameAdditional.values()) {
          if(val.getValue()==i)
              return val;
       }
       System.err.println("No enumeration found for value " + i + " of enumeration EmitterNameAdditional");
       return null;
    }

    /** Marshal value to DataOutputStream
     * See <a href="https://en.wikipedia.org/wiki/Marshalling_(computer_science)" target="_blank">https://en.wikipedia.org/wiki/Marshalling_(computer_science)</a>
     * @param dos DataOutputStream for output
     * @throws IOException input-output error */
    public void marshal(DataOutputStream dos) throws IOException
    {
        dos.writeShort(getValue());
    }

    /** Marshal value to ByteBuffer
     * See <a href="https://en.wikipedia.org/wiki/Marshalling_(computer_science)" target="_blank">https://en.wikipedia.org/wiki/Marshalling_(computer_science)</a>
     * @param byteBuffer ByteBuffer for output
     * @throws IOException input-output error */
    public void marshal(ByteBuffer byteBuffer) throws Exception
    {
        byteBuffer.putShort((short)getValue());
    }
    /** Unmarshal value to DataInputStream
     * See <a href="https://en.wikipedia.org/wiki/Marshalling_(computer_science)" target="_blank">https://en.wikipedia.org/wiki/Marshalling_(computer_science)</a>
     * @param dis DataInputStream for input
     * @throws Exception unmarshalling input-output error
     * @return enumeration of interest */
    public static EmitterNameAdditional unmarshalEnum (DataInputStream dis) throws Exception
    {
        return getEnumForValue(dis.readUnsignedShort());
    } 

    /** Unmarshal enumeration value to ByteBuffer
     * See <a href="https://en.wikipedia.org/wiki/Marshalling_(computer_science)" target="_blank">https://en.wikipedia.org/wiki/Marshalling_(computer_science)</a>
     * @param byteBuffer ByteBuffer for input
     * @throws Exception unmarshalling input-output error
     * @return enumeration of interest */
    public static EmitterNameAdditional unmarshalEnum (ByteBuffer byteBuffer) throws Exception
    {
        return getEnumForValue(byteBuffer.getShort());
    }   

  /**
   * Returns size of this serialized (marshalled) object in bytes
   * See <a href="https://en.wikipedia.org/wiki/Marshalling_(computer_science)" target="_blank">https://en.wikipedia.org/wiki/Marshalling_(computer_science)</a>
   * @return serialized size in bytes
   */
    public int getMarshalledSize()
    {
        return 2; // 16 bits
    }
    
  /**
   * Provide simple identifier
   * @return ID number and name
   */
    @Override
    public String toString()
    {
        return "EmitterNameAdditional " + getValue() + " " + name(); 
    }
}
