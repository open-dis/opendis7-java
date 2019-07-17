package edu.nps.moves.dis.enumerations;

import java.nio.ByteBuffer;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import edu.nps.moves.dis.*;

/**
 * Generated from XML, SISO-REF-010-v25, 2018-08-29<br>
 * UID 75 marshal size 16<br>
 * Emitter Name
 */
public enum EmitterName 
{
    /** 1245/6X */
    $1245_6X (2, "1245/6X"),
    /** 1L250 */
    $1L250 (5, "1L250"),
    /** 1RL138 */
    $1RL138 (10, "1RL138"),
    /** 5P-10 */
    $5P_10 (14, "5P-10"),
    /** 5P-10E */
    $5P_10E (15, "5P-10E"),
    /** 5P-10-01 */
    $5P_10_01 (16, "5P-10-01"),
    /** 5P-10-01E */
    $5P_10_01E (17, "5P-10-01E"),
    /** 5P-10-02 */
    $5P_10_02 (18, "5P-10-02"),
    /** 5P-10-02E */
    $5P_10_02E (19, "5P-10-02E"),
    /** 5P-10-03 */
    $5P_10_03 (20, "5P-10-03"),
    /** 5P-10-03E */
    $5P_10_03E (21, "5P-10-03E"),
    /** 5P-10E MOD */
    $5P_10E_MOD (22, "5P-10E MOD"),
    /** 1226 DECCA MIL */
    $1226_DECCA_MIL (45, "1226 DECCA MIL"),
    /** 9B-1348 */
    $9B_1348 (46, "9B-1348"),
    /** 3KM6 */
    $3KM6 (47, "3KM6"),
    /** 9KR400 */
    $9KR400 (48, "9KR400"),
    /** 9GR400 */
    $9GR400 (80, "9GR400"),
    /** 9GR600 */
    $9GR600 (90, "9GR600"),
    /** 9GR606 */
    $9GR606 (91, "9GR606"),
    /** 9LV 200 TA */
    $9LV_200_TA (135, "9LV 200 TA"),
    /** 9LV 200 TV */
    $9LV_200_TV (180, "9LV 200 TV"),
    /** 9LV 200 TT */
    $9LV_200_TT (181, "9LV 200 TT"),
    /** 9LV200 MK III */
    $9LV200_MK_III (183, "9LV200 MK III"),
    /** 9LV326 */
    $9LV326 (185, "9LV326"),
    /** 9M96E2 Seeker */
    $9M96E2_SEEKER (190, "9M96E2 Seeker"),
    /**  */
    undef (225, ""),
    /**  */
    undef_2 (270, ""),
    /**  */
    undef_3 (315, ""),
    /**  */
    undef_4 (360, ""),
    /**  */
    undef_5 (405, ""),
    /**  */
    undef_6 (450, ""),
    /**  */
    undef_7 (495, ""),
    /**  */
    undef_8 (540, ""),
    /**  */
    undef_9 (585, ""),
    /**  */
    undef_10 (630, ""),
    /**  */
    undef_11 (675, ""),
    /**  */
    undef_12 (720, ""),
    /**  */
    undef_13 (765, ""),
    /**  */
    undef_14 (810, ""),
    /**  */
    undef_15 (855, ""),
    /**  */
    undef_16 (900, ""),
    /**  */
    undef_17 (945, ""),
    /**  */
    undef_18 (990, ""),
    /**  */
    undef_19 (1035, ""),
    /**  */
    undef_20 (1080, ""),
    /** AA-13 Arrow Seeker */
    AA_13_ARROW_SEEKER (1085, "AA-13 Arrow Seeker"),
    /** AA-300 */
    AA_300 (1094, "AA-300"),
    /** AA-12 Seeker */
    AA_12_SEEKER (1095, "AA-12 Seeker"),
    /**  */
    undef_21 (1096, ""),
    /** ADES */
    ADES (1097, "ADES"),
    /** ADS-4 LRSR */
    ADS_4_LRSR (1098, "ADS-4 LRSR"),
    /** Agave */
    AGAVE (1100, "Agave"),
    /** ADAC MK 1 */
    ADAC_MK_1 (1110, "ADAC MK 1"),
    /** ADAC MK 2 */
    ADAC_MK_2 (1111, "ADAC MK 2"),
    /** AGRION 15 */
    AGRION_15 (1125, "AGRION 15"),
    /** AI MK 23 */
    AI_MK_23 (1170, "AI MK 23"),
    /** AIDA II */
    AIDA_II (1215, "AIDA II"),
    /** AIM-120A */
    AIM_120A (1216, "AIM-120A"),
    /** Albatros MK2 */
    ALBATROS_MK2 (1260, "Albatros MK2"),
    /** AM/APS-717 */
    AM_APS_717 (1265, "AM/APS-717"),
    /** WGU-16/B */
    WGU_16_B (1270, "WGU-16/B"),
    /** 1L13-3 (55G6) */
    $1L13_3_55G6 (1280, "1L13-3 (55G6)"),
    /** 1L13-3 (55G6) */
    $1L13_3_55G6_2 (1282, "1L13-3 (55G6)"),
    /** AMDR 3D */
    AMDR_3D (1288, "AMDR 3D"),
    /** ANA SPS 502 */
    ANA_SPS_502 (1305, "ANA SPS 502"),
    /**   */
    undef_22 (1306, " "),
    /** ANRITSU Electric AR-30A */
    ANRITSU_ELECTRIC_AR_30A (1350, "ANRITSU Electric AR-30A"),
    /** Antilope V */
    ANTILOPE_V (1395, "Antilope V"),
    /** AN/AAQ-24 */
    AN_AAQ_24 (1397, "AN/AAQ-24"),
    /** AN/ADM-160 */
    AN_ADM_160 (1398, "AN/ADM-160"),
    /** AN/ALE-50 */
    AN_ALE_50 (1400, "AN/ALE-50"),
    /** AN/ALQ-76 */
    AN_ALQ_76 (1410, "AN/ALQ-76"),
    /** AN/ALQ-99 */
    AN_ALQ_99 (1440, "AN/ALQ-99"),
    /** AN/ALQ-99 Band 4 */
    AN_ALQ_99_BAND_4 (1441, "AN/ALQ-99 Band 4"),
    /** AN/ALQ-99 LBT */
    AN_ALQ_99_LBT (1442, "AN/ALQ-99 LBT"),
    /** AN/ALQ-100 */
    AN_ALQ_100 (1485, "AN/ALQ-100"),
    /** AN/ALQ-101 */
    AN_ALQ_101 (1530, "AN/ALQ-101"),
    /** AN/ALQ-119 */
    AN_ALQ_119 (1575, "AN/ALQ-119"),
    /** AN/ALQ-122 */
    AN_ALQ_122 (1585, "AN/ALQ-122"),
    /** AN/ALQ-126A */
    AN_ALQ_126A (1620, "AN/ALQ-126A"),
    /** AN/ALQ-128 */
    AN_ALQ_128 (1621, "AN/ALQ-128"),
    /** AN/ALQ-126B */
    AN_ALQ_126B (1622, "AN/ALQ-126B"),
    /** AN/ALQ-131 */
    AN_ALQ_131 (1626, "AN/ALQ-131"),
    /** AN/ALQ-135C/D */
    AN_ALQ_135C_D (1628, "AN/ALQ-135C/D"),
    /** AN/ALQ-144A(V)3 */
    AN_ALQ_144AV3 (1630, "AN/ALQ-144A(V)3"),
    /** AN/ALQ-153 */
    AN_ALQ_153 (1632, "AN/ALQ-153"),
    /** AN/ALQ-155 */
    AN_ALQ_155 (1634, "AN/ALQ-155"),
    /** AN/ALQ-156 */
    AN_ALQ_156 (1635, "AN/ALQ-156"),
    /** AN/ALQ-161/A */
    AN_ALQ_161_A (1636, "AN/ALQ-161/A"),
    /** AN/ALQ-161 */
    AN_ALQ_161 (1637, "AN/ALQ-161"),
    /** AN/ALQ-162 */
    AN_ALQ_162 (1638, "AN/ALQ-162"),
    /** AN/ALQ-164 */
    AN_ALQ_164 (1639, "AN/ALQ-164"),
    /** AN/ALQ-165 */
    AN_ALQ_165 (1640, "AN/ALQ-165"),
    /** AN/ALQ-167 */
    AN_ALQ_167 (1642, "AN/ALQ-167"),
    /** AN/ALQ-172(V)1 */
    AN_ALQ_172V1 (1643, "AN/ALQ-172(V)1"),
    /** AN/ALQ-172(V)2 */
    AN_ALQ_172V2 (1644, "AN/ALQ-172(V)2"),
    /** AN/ALQ-172(V)3 */
    AN_ALQ_172V3 (1645, "AN/ALQ-172(V)3"),
    /** AN/ALQ-176 */
    AN_ALQ_176 (1646, "AN/ALQ-176"),
    /** AN/ALQ-178 */
    AN_ALQ_178 (1647, "AN/ALQ-178"),
    /** AN/ALQ-184 */
    AN_ALQ_184 (1648, "AN/ALQ-184"),
    /** AN/ALQ-184(V)9 */
    AN_ALQ_184V9 (1649, "AN/ALQ-184(V)9"),
    /** AN/ALQ-188 */
    AN_ALQ_188 (1650, "AN/ALQ-188"),
    /** AN/ALQ-214 */
    AN_ALQ_214 (1651, "AN/ALQ-214"),
    /** AN/ALR-56 */
    AN_ALR_56 (1652, "AN/ALR-56"),
    /** AN/ALQ-221 */
    AN_ALQ_221 (1653, "AN/ALQ-221"),
    /** AN/ALR-69 */
    AN_ALR_69 (1654, "AN/ALR-69"),
    /** AN/ALQ-211(V) */
    AN_ALQ_211V (1655, "AN/ALQ-211(V)"),
    /** AN/ALT-16A */
    AN_ALT_16A (1656, "AN/ALT-16A"),
    /** AN/ALT-28 */
    AN_ALT_28 (1658, "AN/ALT-28"),
    /** AN/ALT-32A */
    AN_ALT_32A (1660, "AN/ALT-32A"),
    /** AN/APD 10 */
    AN_APD_10 (1665, "AN/APD 10"),
    /** AN/APG-50 */
    AN_APG_50 (1700, "AN/APG-50"),
    /** AN/APG-53 */
    AN_APG_53 (1710, "AN/APG-53"),
    /** AN/APG-59 */
    AN_APG_59 (1755, "AN/APG-59"),
    /** AN/APG-63 */
    AN_APG_63 (1800, "AN/APG-63"),
    /** AN/APG-63(V)1 */
    AN_APG_63V1 (1805, "AN/APG-63(V)1"),
    /** AN/APG-63(V)2 */
    AN_APG_63V2 (1807, "AN/APG-63(V)2"),
    /** AN/APG-63(V)3 */
    AN_APG_63V3 (1809, "AN/APG-63(V)3"),
    /** AN/APG-65 */
    AN_APG_65 (1845, "AN/APG-65"),
    /** AN/APG-66 */
    AN_APG_66 (1870, "AN/APG-66"),
    /** AN/APG-66(V) */
    AN_APG_66V (1871, "AN/APG-66(V)"),
    /** AN/APG-66(V)2 */
    AN_APG_66V2 (1872, "AN/APG-66(V)2"),
    /** AN/APG-67 */
    AN_APG_67 (1880, "AN/APG-67"),
    /** AN/APG-68 */
    AN_APG_68 (1890, "AN/APG-68"),
    /** AN/APG-68(v)9 */
    AN_APG_68V9 (1895, "AN/APG-68(v)9"),
    /** AN/APG-70 */
    AN_APG_70 (1935, "AN/APG-70"),
    /** AN/APG-73 */
    AN_APG_73 (1945, "AN/APG-73"),
    /** AN/APG-77 */
    AN_APG_77 (1960, "AN/APG-77"),
    /** AN/APG-78 */
    AN_APG_78 (1970, "AN/APG-78"),
    /** AN/APG-79 */
    AN_APG_79 (1971, "AN/APG-79"),
    /** AN/APG-80 */
    AN_APG_80 (1972, "AN/APG-80"),
    /** AN/APG-81 */
    AN_APG_81 (1974, "AN/APG-81"),
    /** AN/APG-82(V)1 */
    AN_APG_82V1 (1975, "AN/APG-82(V)1"),
    /** AN/APG-502 */
    AN_APG_502 (1980, "AN/APG-502"),
    /** AN/APN-1 */
    AN_APN_1 (2025, "AN/APN-1"),
    /** AN/APN-22 */
    AN_APN_22 (2070, "AN/APN-22"),
    /** AN/APN-59 */
    AN_APN_59 (2115, "AN/APN-59"),
    /** AN/APN-69 */
    AN_APN_69 (2160, "AN/APN-69"),
    /** AN/APN-81 */
    AN_APN_81 (2205, "AN/APN-81"),
    /** AN/APN-117 */
    AN_APN_117 (2250, "AN/APN-117"),
    /** AN/APN-118 */
    AN_APN_118 (2295, "AN/APN-118"),
    /** AN/APN-122 */
    AN_APN_122 (2320, "AN/APN-122"),
    /** AN/APN-130 */
    AN_APN_130 (2340, "AN/APN-130"),
    /** AN/APN-131 */
    AN_APN_131 (2385, "AN/APN-131"),
    /** AN/APN-133 */
    AN_APN_133 (2430, "AN/APN-133"),
    /** AN/APN-134 */
    AN_APN_134 (2475, "AN/APN-134"),
    /** AN/APN-141(V) */
    AN_APN_141V (2476, "AN/APN-141(V)"),
    /** AN/APN-147 */
    AN_APN_147 (2520, "AN/APN-147"),
    /** AN/APN-150 */
    AN_APN_150 (2565, "AN/APN-150"),
    /** AN/APN-153 */
    AN_APN_153 (2610, "AN/APN-153"),
    /** AN/APN-154 */
    AN_APN_154 (2655, "AN/APN-154"),
    /** AN/APN-155 */
    AN_APN_155 (2700, "AN/APN-155"),
    /** AN/APN-159 */
    AN_APN_159 (2745, "AN/APN-159"),
    /** AN/APN-177 */
    AN_APN_177 (2746, "AN/APN-177"),
    /** AN/APN-169 */
    AN_APN_169 (2748, "AN/APN-169"),
    /** AN/APN-182 */
    AN_APN_182 (2790, "AN/APN-182"),
    /** AN/APN-187 */
    AN_APN_187 (2835, "AN/APN-187"),
    /** AN/APN-190 */
    AN_APN_190 (2880, "AN/APN-190"),
    /** AN/APN-194 */
    AN_APN_194 (2925, "AN/APN-194"),
    /** AN/APN-195 */
    AN_APN_195 (2970, "AN/APN-195"),
    /** AN/APN-198 */
    AN_APN_198 (3015, "AN/APN-198"),
    /** AN/APN-200 */
    AN_APN_200 (3060, "AN/APN-200"),
    /** AN/APN-202 */
    AN_APN_202 (3105, "AN/APN-202"),
    /** AN/APN-215 */
    AN_APN_215 (3106, "AN/APN-215"),
    /** AN/APN-209 */
    AN_APN_209 (3120, "AN/APN-209"),
    /** AN/APN-209D */
    AN_APN_209D (3121, "AN/APN-209D"),
    /** AN/APN-209A */
    AN_APN_209A (3122, "AN/APN-209A"),
    /** AN/APN-215 */
    AN_APN_215_2 (3148, "AN/APN-215"),
    /** AN/APN-217 */
    AN_APN_217 (3150, "AN/APN-217"),
    /** AN/APN-218 */
    AN_APN_218 (3152, "AN/APN-218"),
    /** AN/APN-224 */
    AN_APN_224 (3153, "AN/APN-224"),
    /** AN/APN-227 */
    AN_APN_227 (3154, "AN/APN-227"),
    /** AN/APN-230 */
    AN_APN_230 (3155, "AN/APN-230"),
    /** AN/APN-232 */
    AN_APN_232 (3156, "AN/APN-232"),
    /** AN/APN-237A */
    AN_APN_237A (3157, "AN/APN-237A"),
    /** AN/APN-234 */
    AN_APN_234 (3158, "AN/APN-234"),
    /** AN/APN-235 */
    AN_APN_235 (3159, "AN/APN-235"),
    /** AN/APN-238 */
    AN_APN_238 (3160, "AN/APN-238"),
    /** AN/APN-222 */
    AN_APN_222 (3161, "AN/APN-222"),
    /** AN/APN-239 */
    AN_APN_239 (3162, "AN/APN-239"),
    /** AN/APN-241 */
    AN_APN_241 (3164, "AN/APN-241"),
    /** AN/APN-242 */
    AN_APN_242 (3166, "AN/APN-242"),
    /** AN/APN-243 */
    AN_APN_243 (3170, "AN/APN-243"),
    /** AN/APN-506 */
    AN_APN_506 (3195, "AN/APN-506"),
    /** AN/APQ-72 */
    AN_APQ_72 (3240, "AN/APQ-72"),
    /** AN/APQ-99 */
    AN_APQ_99 (3285, "AN/APQ-99"),
    /** AN/APQ-100 */
    AN_APQ_100 (3330, "AN/APQ-100"),
    /** AN/APQ-102 */
    AN_APQ_102 (3375, "AN/APQ-102"),
    /** AN/APQ-107 */
    AN_APQ_107 (3376, "AN/APQ-107"),
    /** AN/APQ-109 */
    AN_APQ_109 (3420, "AN/APQ-109"),
    /** AN/APQ-113 */
    AN_APQ_113 (3465, "AN/APQ-113"),
    /** AN/APQ-120 */
    AN_APQ_120 (3510, "AN/APQ-120"),
    /** AN/APQ-122 */
    AN_APQ_122 (3512, "AN/APQ-122"),
    /** AN/APQ-126 */
    AN_APQ_126 (3555, "AN/APQ-126"),
    /** AN/APQ-128 */
    AN_APQ_128 (3600, "AN/APQ-128"),
    /** AN/APQ-129 */
    AN_APQ_129 (3645, "AN/APQ-129"),
    /** AN/APQ-148 */
    AN_APQ_148 (3690, "AN/APQ-148"),
    /** AN/APQ-150A */
    AN_APQ_150A (3700, "AN/APQ-150A"),
    /** AN/APQ-153 */
    AN_APQ_153 (3735, "AN/APQ-153"),
    /** AN/APQ-155 */
    AN_APQ_155 (3770, "AN/APQ-155"),
    /** AN/APQ-159 */
    AN_APQ_159 (3780, "AN/APQ-159"),
    /** AN/APQ-164 */
    AN_APQ_164 (3785, "AN/APQ-164"),
    /** AN/APQ-166 */
    AN_APQ_166 (3788, "AN/APQ-166"),
    /** AN/APQ-174 */
    AN_APQ_174 (3791, "AN/APQ-174"),
    /** AN/APQ-180 */
    AN_APQ_180 (3794, "AN/APQ-180"),
    /** AN/APQ-181 */
    AN_APQ_181 (3795, "AN/APQ-181"),
    /** AN/APS-15J */
    AN_APS_15J (3810, "AN/APS-15J"),
    /** AN/APS-16(V)2 */
    AN_APS_16V2 (3813, "AN/APS-16(V)2"),
    /** AN/APS-31 */
    AN_APS_31 (3820, "AN/APS-31"),
    /** AN/APS-42 */
    AN_APS_42 (3825, "AN/APS-42"),
    /** AN/APS-80 */
    AN_APS_80 (3870, "AN/APS-80"),
    /** AN/APS-88 */
    AN_APS_88 (3915, "AN/APS-88"),
    /** AN/APS-88A */
    AN_APS_88A (3916, "AN/APS-88A"),
    /** AN/APS-115 */
    AN_APS_115 (3960, "AN/APS-115"),
    /** AN/APS-116 */
    AN_APS_116 (4005, "AN/APS-116"),
    /** AN/APS-120 */
    AN_APS_120 (4050, "AN/APS-120"),
    /** AN/APS-121 */
    AN_APS_121 (4095, "AN/APS-121"),
    /** AN/APS-124 */
    AN_APS_124 (4140, "AN/APS-124"),
    /** AN/APS-125 */
    AN_APS_125 (4185, "AN/APS-125"),
    /** AN/APS-128 */
    AN_APS_128 (4230, "AN/APS-128"),
    /** AN/APS-130 */
    AN_APS_130 (4275, "AN/APS-130"),
    /** AN/APS-133 */
    AN_APS_133 (4320, "AN/APS-133"),
    /** AN/APS-134 */
    AN_APS_134 (4365, "AN/APS-134"),
    /** AN/APS-137 */
    AN_APS_137 (4410, "AN/APS-137"),
    /** AN/APS-137B */
    AN_APS_137B (4415, "AN/APS-137B"),
    /** AN/APS-137B(V)5 */
    AN_APS_137BV5 (4420, "AN/APS-137B(V)5"),
    /** AN/APS-138 */
    AN_APS_138 (4455, "AN/APS-138"),
    /** AN/APS-139 */
    AN_APS_139 (4460, "AN/APS-139"),
    /** AN/APS-143 (V) 1 */
    AN_APS_143_V_1 (4465, "AN/APS-143 (V) 1"),
    /** AN/APS-143B */
    AN_APS_143B (4466, "AN/APS-143B"),
    /** AN/APS-143(V)3 */
    AN_APS_143V3 (4467, "AN/APS-143(V)3"),
    /** AN/APS-143B(V)3 */
    AN_APS_143BV3 (4468, "AN/APS-143B(V)3"),
    /** AN/APS-153 */
    AN_APS_153 (4475, "AN/APS-153"),
    /** AN/APS-150 */
    AN_APS_150 (4480, "AN/APS-150"),
    /** AN/APS-145 */
    AN_APS_145 (4482, "AN/APS-145"),
    /** AN/APS-147 */
    AN_APS_147 (4485, "AN/APS-147"),
    /** AN/APS-149 */
    AN_APS_149 (4486, "AN/APS-149"),
    /** AN/APS-504 */
    AN_APS_504 (4490, "AN/APS-504"),
    /** AN/APS-705 */
    AN_APS_705 (4491, "AN/APS-705"),
    /** AN/APW-22 */
    AN_APW_22 (4500, "AN/APW-22"),
    /** AN/APW-23 */
    AN_APW_23 (4545, "AN/APW-23"),
    /** AN/APX-6 */
    AN_APX_6 (4590, "AN/APX-6"),
    /** AN/APX-7 */
    AN_APX_7 (4635, "AN/APX-7"),
    /** AN/APX-39 */
    AN_APX_39 (4680, "AN/APX-39"),
    /** AN/APX-64(V) */
    AN_APX_64V (4681, "AN/APX-64(V)"),
    /** AN/APX-72 */
    AN_APX_72 (4725, "AN/APX-72"),
    /** AN/APX-76 */
    AN_APX_76 (4770, "AN/APX-76"),
    /** AN/APX-78 */
    AN_APX_78 (4815, "AN/APX-78"),
    /** AN/APX-100 */
    AN_APX_100 (4816, "AN/APX-100"),
    /** AN/APX-101 */
    AN_APX_101 (4860, "AN/APX-101"),
    /** AN/APX-113 AIFF */
    AN_APX_113_AIFF (4870, "AN/APX-113 AIFF"),
    /** AN/APY-1 */
    AN_APY_1 (4900, "AN/APY-1"),
    /** AN/APY-2 */
    AN_APY_2 (4905, "AN/APY-2"),
    /** AN/APY-3 */
    AN_APY_3 (4950, "AN/APY-3"),
    /** AN/APY-7 */
    AN_APY_7 (4952, "AN/APY-7"),
    /** AN/APY-8 */
    AN_APY_8 (4953, "AN/APY-8"),
    /** AN/APY-9 */
    AN_APY_9 (4954, "AN/APY-9"),
    /** AN/APY-10 */
    AN_APY_10 (4955, "AN/APY-10"),
    /** AN/ARN-21 */
    AN_ARN_21 (4995, "AN/ARN-21"),
    /** AN/ARN-52 */
    AN_ARN_52 (5040, "AN/ARN-52"),
    /** AN/ARN-84 */
    AN_ARN_84 (5085, "AN/ARN-84"),
    /** AN/ARN-118 */
    AN_ARN_118 (5130, "AN/ARN-118"),
    /** AN/ARN-153(V) */
    AN_ARN_153V (5131, "AN/ARN-153(V)"),
    /** AN/ARN-153 */
    AN_ARN_153 (5165, "AN/ARN-153"),
    /** AN/ARW 73 */
    AN_ARW_73 (5175, "AN/ARW 73"),
    /** AN/ASB 1 */
    AN_ASB_1 (5220, "AN/ASB 1"),
    /** AN/ASG 21 */
    AN_ASG_21 (5265, "AN/ASG 21"),
    /** AN/ASN-137 */
    AN_ASN_137 (5266, "AN/ASN-137"),
    /** AN/ASN-128 */
    AN_ASN_128 (5270, "AN/ASN-128"),
    /** AN/ASQ-108 */
    AN_ASQ_108 (5280, "AN/ASQ-108"),
    /** AN/AWG 9 */
    AN_AWG_9 (5310, "AN/AWG 9"),
    /** AN/BRN-1 */
    AN_BRN_1 (5320, "AN/BRN-1"),
    /** AN/BPS-5 */
    AN_BPS_5 (5325, "AN/BPS-5"),
    /** AN/BPS-9 */
    AN_BPS_9 (5355, "AN/BPS-9"),
    /** AN/BPS 15 */
    AN_BPS_15 (5400, "AN/BPS 15"),
    /** AN/BPS-15 H */
    AN_BPS_15_H (5401, "AN/BPS-15 H"),
    /** AN/BPS-16 */
    AN_BPS_16 (5405, "AN/BPS-16"),
    /** AN/CRM-30 */
    AN_CRM_30 (5420, "AN/CRM-30"),
    /** AN/DPW-23 */
    AN_DPW_23 (5430, "AN/DPW-23"),
    /** AN/DSQ 26 Phoenix MH */
    AN_DSQ_26_PHOENIX_MH (5445, "AN/DSQ 26 Phoenix MH"),
    /** AN/DSQ 28 Harpoon MH */
    AN_DSQ_28_HARPOON_MH (5490, "AN/DSQ 28 Harpoon MH"),
    /** AN/FPN-40 */
    AN_FPN_40 (5495, "AN/FPN-40"),
    /** AN/FPN-62 */
    AN_FPN_62 (5500, "AN/FPN-62"),
    /** AN/FPS-16 */
    AN_FPS_16 (5505, "AN/FPS-16"),
    /** AN/FPS-18 */
    AN_FPS_18 (5507, "AN/FPS-18"),
    /** AN/FPS-89 */
    AN_FPS_89 (5508, "AN/FPS-89"),
    /** AN/FPS-117 */
    AN_FPS_117 (5510, "AN/FPS-117"),
    /** AN/FPS-20R */
    AN_FPS_20R (5515, "AN/FPS-20R"),
    /** AN/FPS-77 */
    AN_FPS_77 (5520, "AN/FPS-77"),
    /** AN/FPS-100A */
    AN_FPS_100A (5522, "AN/FPS-100A"),
    /** AN/FPS-103 */
    AN_FPS_103 (5525, "AN/FPS-103"),
    /** AN/FPS-108 */
    AN_FPS_108 (5526, "AN/FPS-108"),
    /** AN/GPN-12 */
    AN_GPN_12 (5527, "AN/GPN-12"),
    /** AN/GPX-6 */
    AN_GPX_6 (5530, "AN/GPX-6"),
    /** AN/GPX 8 */
    AN_GPX_8 (5535, "AN/GPX 8"),
    /** AN/GRN-12 */
    AN_GRN_12 (5537, "AN/GRN-12"),
    /** AN/MPN-14 */
    AN_MPN_14 (5539, "AN/MPN-14"),
    /** AN/MPQ-10 */
    AN_MPQ_10 (5540, "AN/MPQ-10"),
    /** AN/MPQ-33/39/46/57/61 (HPIR) ILL */
    AN_MPQ_33_39_46_57_61_HPIR_ILL (5545, "AN/MPQ-33/39/46/57/61 (HPIR) ILL"),
    /** AN/MPQ-34/48/55/62 (CWAR) TA */
    AN_MPQ_34_48_55_62_CWAR_TA (5550, "AN/MPQ-34/48/55/62 (CWAR) TA"),
    /** AN/MPQ-49 */
    AN_MPQ_49 (5551, "AN/MPQ-49"),
    /** AN/MPQ-35/50 (PAR) TA */
    AN_MPQ_35_50_PAR_TA (5555, "AN/MPQ-35/50 (PAR) TA"),
    /** AN/MPQ-50C */
    AN_MPQ_50C (5556, "AN/MPQ-50C"),
    /** AN/MPQ-37/51 (ROR) TT */
    AN_MPQ_37_51_ROR_TT (5560, "AN/MPQ-37/51 (ROR) TT"),
    /** AN/MPQ-53 */
    AN_MPQ_53 (5570, "AN/MPQ-53"),
    /** AN/MPQ-63 */
    AN_MPQ_63 (5571, "AN/MPQ-63"),
    /** AN/MPQ-64 */
    AN_MPQ_64 (5575, "AN/MPQ-64"),
    /** AN/SLQ-32 */
    AN_SLQ_32 (5576, "AN/SLQ-32"),
    /** AN/MPQ-65 */
    AN_MPQ_65 (5577, "AN/MPQ-65"),
    /** AN/SLQ-32(V)4 */
    AN_SLQ_32V4 (5578, "AN/SLQ-32(V)4"),
    /** AN/SLQ-32A */
    AN_SLQ_32A (5579, "AN/SLQ-32A"),
    /** AN/SPG-34 */
    AN_SPG_34 (5580, "AN/SPG-34"),
    /** AN/SPG-48/MK 25 MOD 3 */
    AN_SPG_48_MK_25_MOD_3 (5620, "AN/SPG-48/MK 25 MOD 3"),
    /** AN/SPG-50 */
    AN_SPG_50 (5625, "AN/SPG-50"),
    /** AN/SPG-51 */
    AN_SPG_51 (5670, "AN/SPG-51"),
    /** AN/PPS-15 */
    AN_PPS_15 (5700, "AN/PPS-15"),
    /** AN/PPS-5 */
    AN_PPS_5 (5705, "AN/PPS-5"),
    /** AN/SPG-51 CWI TI */
    AN_SPG_51_CWI_TI (5715, "AN/SPG-51 CWI TI"),
    /** AN/SPG-51 FC */
    AN_SPG_51_FC (5760, "AN/SPG-51 FC"),
    /** AN/SPG-51C/D */
    AN_SPG_51C_D (5761, "AN/SPG-51C/D"),
    /** AN/SPG-52 */
    AN_SPG_52 (5805, "AN/SPG-52"),
    /** AN/SPG-53 */
    AN_SPG_53 (5850, "AN/SPG-53"),
    /** AN/SPG-55B */
    AN_SPG_55B (5895, "AN/SPG-55B"),
    /** AN/SPG-60 */
    AN_SPG_60 (5940, "AN/SPG-60"),
    /** AN/SPG-62 */
    AN_SPG_62 (5985, "AN/SPG-62"),
    /** AN/SPG-503 */
    AN_SPG_503 (5995, "AN/SPG-503"),
    /** AN/SPN-11 */
    AN_SPN_11 (6025, "AN/SPN-11"),
    /** AN/SPN-35 */
    AN_SPN_35 (6030, "AN/SPN-35"),
    /** AN/SPN-41 */
    AN_SPN_41 (6050, "AN/SPN-41"),
    /** AN/SPN-43 */
    AN_SPN_43 (6075, "AN/SPN-43"),
    /** AN/SPN-43A */
    AN_SPN_43A (6076, "AN/SPN-43A"),
    /** AN/SPN-46 */
    AN_SPN_46 (6085, "AN/SPN-46"),
    /** AN/SPQ-2 */
    AN_SPQ_2 (6120, "AN/SPQ-2"),
    /** AN/SPQ-9A */
    AN_SPQ_9A (6165, "AN/SPQ-9A"),
    /** AN/SPQ-9B */
    AN_SPQ_9B (6166, "AN/SPQ-9B"),
    /** AN/SPQ-34 */
    AN_SPQ_34 (6190, "AN/SPQ-34"),
    /** AN/SPS-4 */
    AN_SPS_4 (6210, "AN/SPS-4"),
    /** AN/SPS-5 */
    AN_SPS_5 (6255, "AN/SPS-5"),
    /** AN/SPS-5C */
    AN_SPS_5C (6300, "AN/SPS-5C"),
    /** AN/SPS-6 */
    AN_SPS_6 (6345, "AN/SPS-6"),
    /** AN/SPS-10 */
    AN_SPS_10 (6390, "AN/SPS-10"),
    /** AN/SPS-21 */
    AN_SPS_21 (6435, "AN/SPS-21"),
    /** AN/SPS-28 */
    AN_SPS_28 (6480, "AN/SPS-28"),
    /** AN/SPS-37 */
    AN_SPS_37 (6525, "AN/SPS-37"),
    /** AN/SPS-39A */
    AN_SPS_39A (6570, "AN/SPS-39A"),
    /** AN/SPS-40 */
    AN_SPS_40 (6615, "AN/SPS-40"),
    /** AN/SPS-41 */
    AN_SPS_41 (6660, "AN/SPS-41"),
    /** AN/SPS-48 */
    AN_SPS_48 (6705, "AN/SPS-48"),
    /** AN/SPS-48C */
    AN_SPS_48C (6750, "AN/SPS-48C"),
    /** AN/SPS-48E */
    AN_SPS_48E (6752, "AN/SPS-48E"),
    /** AN/SPS-49 */
    AN_SPS_49 (6795, "AN/SPS-49"),
    /** AN/SPS-49(V)1 */
    AN_SPS_49V1 (6796, "AN/SPS-49(V)1"),
    /** AN/SPS-49(V)2 */
    AN_SPS_49V2 (6797, "AN/SPS-49(V)2"),
    /** AN/SPS-49(V)3 */
    AN_SPS_49V3 (6798, "AN/SPS-49(V)3"),
    /** AN/SPS-49(V)4 */
    AN_SPS_49V4 (6799, "AN/SPS-49(V)4"),
    /** AN/SPS-49(V)5 */
    AN_SPS_49V5 (6800, "AN/SPS-49(V)5"),
    /** AN/SPS-49(V)6 */
    AN_SPS_49V6 (6801, "AN/SPS-49(V)6"),
    /** AN/SPS-49(V)7 */
    AN_SPS_49V7 (6802, "AN/SPS-49(V)7"),
    /** AN/SPS-49(V)8 */
    AN_SPS_49V8 (6803, "AN/SPS-49(V)8"),
    /** AN/SPS-49A(V)1 */
    AN_SPS_49AV1 (6804, "AN/SPS-49A(V)1"),
    /** AN/SPS-52 */
    AN_SPS_52 (6840, "AN/SPS-52"),
    /** AN/SPS-53 */
    AN_SPS_53 (6885, "AN/SPS-53"),
    /** AN/SPS-55 */
    AN_SPS_55 (6930, "AN/SPS-55"),
    /** AN/SPS-52C */
    AN_SPS_52C (6945, "AN/SPS-52C"),
    /** AN/SPS-55 CS */
    AN_SPS_55_CS (6970, "AN/SPS-55 CS"),
    /** AN/SPS-55 SS */
    AN_SPS_55_SS (6975, "AN/SPS-55 SS"),
    /** AN/SPS-58 */
    AN_SPS_58 (7020, "AN/SPS-58"),
    /** AN/SPS-58C */
    AN_SPS_58C (7025, "AN/SPS-58C"),
    /** AN/SPS-59 */
    AN_SPS_59 (7065, "AN/SPS-59"),
    /** AN/SPS-64 */
    AN_SPS_64 (7110, "AN/SPS-64"),
    /** AN/SPS-64(V)9 */
    AN_SPS_64V9 (7119, "AN/SPS-64(V)9"),
    /** SPS64(V)12 */
    SPS64V12 (7120, "SPS64(V)12"),
    /** AN/SPS-65 */
    AN_SPS_65 (7155, "AN/SPS-65"),
    /** AN/SPS-66 */
    AN_SPS_66 (7175, "AN/SPS-66"),
    /** AN/SPS-67 */
    AN_SPS_67 (7200, "AN/SPS-67"),
    /** AN/SPS-73(I) */
    AN_SPS_73I (7201, "AN/SPS-73(I)"),
    /** AN/SPS-69 */
    AN_SPS_69 (7210, "AN/SPS-69"),
    /** AN/SPS-73 */
    AN_SPS_73 (7215, "AN/SPS-73"),
    /** AN/SPS-74 */
    AN_SPS_74 (7216, "AN/SPS-74"),
    /** AN/SPS-88 */
    AN_SPS_88 (7225, "AN/SPS-88"),
    /** AN/SPS-505 */
    AN_SPS_505 (7230, "AN/SPS-505"),
    /** AN/SPY-1 */
    AN_SPY_1 (7245, "AN/SPY-1"),
    /** AN/SPY-1A */
    AN_SPY_1A (7250, "AN/SPY-1A"),
    /** AN/SPY-1B */
    AN_SPY_1B (7252, "AN/SPY-1B"),
    /** AN/SPY-1B(V) */
    AN_SPY_1BV (7253, "AN/SPY-1B(V)"),
    /** AN/SPY-1D */
    AN_SPY_1D (7260, "AN/SPY-1D"),
    /** AN/SPY-1D(V) */
    AN_SPY_1DV (7261, "AN/SPY-1D(V)"),
    /** AN/SPY-1F */
    AN_SPY_1F (7265, "AN/SPY-1F"),
    /** AN/SPY-3 */
    AN_SPY_3 (7266, "AN/SPY-3"),
    /** AN/TPN-12 */
    AN_TPN_12 (7267, "AN/TPN-12"),
    /** AN/SPY-4 */
    AN_SPY_4 (7268, "AN/SPY-4"),
    /** AN/TLQ-32 ARM Decoy */
    AN_TLQ_32_ARM_DECOY (7269, "AN/TLQ-32 ARM Decoy"),
    /** AN/TPN-17 */
    AN_TPN_17 (7270, "AN/TPN-17"),
    /** AN/TPN-24 */
    AN_TPN_24 (7275, "AN/TPN-24"),
    /** AN/TPQ-18 */
    AN_TPQ_18 (7280, "AN/TPQ-18"),
    /** AN/TPQ-36 */
    AN_TPQ_36 (7295, "AN/TPQ-36"),
    /** AN/TPQ-37 */
    AN_TPQ_37 (7300, "AN/TPQ-37"),
    /** AN/TPQ-38 (V8) */
    AN_TPQ_38_V8 (7301, "AN/TPQ-38 (V8)"),
    /** AN/TPQ-47 */
    AN_TPQ_47 (7303, "AN/TPQ-47"),
    /** AN/TPS-43 */
    AN_TPS_43 (7305, "AN/TPS-43"),
    /** AN/TPS-43E */
    AN_TPS_43E (7310, "AN/TPS-43E"),
    /** AN/TPQ-48 */
    AN_TPQ_48 (7311, "AN/TPQ-48"),
    /** AN/TPQ-49 */
    AN_TPQ_49 (7312, "AN/TPQ-49"),
    /** AN/TPS-59 */
    AN_TPS_59 (7315, "AN/TPS-59"),
    /** AN/TPS-63 */
    AN_TPS_63 (7320, "AN/TPS-63"),
    /** AN/TPS-65 */
    AN_TPS_65 (7321, "AN/TPS-65"),
    /** AN/TPS-70 (V) 1 */
    AN_TPS_70_V_1 (7322, "AN/TPS-70 (V) 1"),
    /** AN/TPS-73 */
    AN_TPS_73 (7324, "AN/TPS-73"),
    /** AN/TPS-75 */
    AN_TPS_75 (7325, "AN/TPS-75"),
    /** AN/TSP-77 */
    AN_TSP_77 (7326, "AN/TSP-77"),
    /** AN/TPX-46(V)7 */
    AN_TPX_46V7 (7330, "AN/TPX-46(V)7"),
    /** AN/TPY-2 */
    AN_TPY_2 (7333, "AN/TPY-2"),
    /** AN/ULQ-6A */
    AN_ULQ_6A (7335, "AN/ULQ-6A"),
    /** AN/UPN 25 */
    AN_UPN_25 (7380, "AN/UPN 25"),
    /** AN/UPS 1 */
    AN_UPS_1 (7425, "AN/UPS 1"),
    /** AN/UPS-2 */
    AN_UPS_2 (7426, "AN/UPS-2"),
    /** AN/UPX 1 */
    AN_UPX_1 (7470, "AN/UPX 1"),
    /** AN/UPX 5 */
    AN_UPX_5 (7515, "AN/UPX 5"),
    /** AN/UPX 11 */
    AN_UPX_11 (7560, "AN/UPX 11"),
    /** AN/UPX 12 */
    AN_UPX_12 (7605, "AN/UPX 12"),
    /** AN/UPX 17 */
    AN_UPX_17 (7650, "AN/UPX 17"),
    /** AN/UPX 23 */
    AN_UPX_23 (7695, "AN/UPX 23"),
    /** AN/VPS 2 */
    AN_VPS_2 (7740, "AN/VPS 2"),
    /** AN/PLM-3 */
    AN_PLM_3 (7750, "AN/PLM-3"),
    /** AN/PLM-3A */
    AN_PLM_3A (7751, "AN/PLM-3A"),
    /** AN/PLM-4 */
    AN_PLM_4 (7752, "AN/PLM-4"),
    /** AN/ZPY-3 */
    AN_ZPY_3 (7755, "AN/ZPY-3"),
    /** APAR */
    APAR (7765, "APAR"),
    /** Aparna */
    APARNA (7770, "Aparna"),
    /**  */
    undef_23 (7785, ""),
    /** APG 71 */
    APG_71 (7830, "APG 71"),
    /** APN 148 */
    APN_148 (7875, "APN 148"),
    /** APN 227 */
    APN_227 (7920, "APN 227"),
    /** APQ 113 */
    APQ_113 (7965, "APQ 113"),
    /** APQ 120 */
    APQ_120 (8010, "APQ 120"),
    /** APQ 148 */
    APQ_148 (8055, "APQ 148"),
    /** APS 504 V3 */
    APS_504_V3 (8100, "APS 504 V3"),
    /** AR 3D */
    AR_3D (8105, "AR 3D"),
    /**  */
    undef_24 (8112, ""),
    /**   */
    undef_25 (8113, " "),
    /** AR 320 */
    AR_320 (8115, "AR 320"),
    /** AR 327 */
    AR_327 (8120, "AR 327"),
    /**   */
    undef_26 (8123, " "),
    /**   */
    undef_27 (8126, " "),
    /** ARGS-14E */
    ARGS_14E (8134, "ARGS-14E"),
    /** ARGS 31 */
    ARGS_31 (8135, "ARGS 31"),
    /** AR M31 */
    AR_M31 (8145, "AR M31"),
    /** ARED */
    ARED (8160, "ARED"),
    /** ARI 5954 */
    ARI_5954 (8190, "ARI 5954"),
    /** ARI 5955 */
    ARI_5955 (8235, "ARI 5955"),
    /** ARI 5979 */
    ARI_5979 (8280, "ARI 5979"),
    /** ARGSN-31 */
    ARGSN_31 (8281, "ARGSN-31"),
    /**  */
    undef_28 (8325, ""),
    /**  */
    undef_29 (8370, ""),
    /** ARK-1 */
    ARK_1 (8375, "ARK-1"),
    /**   */
    undef_30 (8378, " "),
    /** ARSR-3 */
    ARSR_3 (8380, "ARSR-3"),
    /** ARSR-18 */
    ARSR_18 (8390, "ARSR-18"),
    /**   */
    undef_31 (8395, " "),
    /**  */
    undef_32 (8415, ""),
    /**  */
    undef_33 (8460, ""),
    /** AS 3 YJ-83K mmW MH */
    AS_3_YJ_83K_MMW_MH (8470, "AS 3 YJ-83K mmW MH"),
    /** AS.34 Kormoran Seeker */
    AS34_KORMORAN_SEEKER (8480, "AS.34 Kormoran Seeker"),
    /**  */
    undef_34 (8505, ""),
    /**  */
    undef_35 (8550, ""),
    /**  */
    undef_36 (8595, ""),
    /**  */
    undef_37 (8640, ""),
    /**  */
    undef_38 (8685, ""),
    /**  */
    undef_39 (8730, ""),
    /**  */
    undef_40 (8735, ""),
    /**   */
    undef_41 (8736, " "),
    /**   */
    undef_42 (8737, " "),
    /**   */
    undef_43 (8750, " "),
    /** ASARS2 */
    ASARS2 (8755, "ASARS2"),
    /** Aspide AAM/SAM ILL */
    ASPIDE_AAM_SAM_ILL (8760, "Aspide AAM/SAM ILL"),
    /** ASR-4 */
    ASR_4 (8772, "ASR-4"),
    /** ASR-4D */
    ASR_4D (8773, "ASR-4D"),
    /** ASR O */
    ASR_O (8775, "ASR O"),
    /** ASR-5 */
    ASR_5 (8780, "ASR-5"),
    /** ASR-7 */
    ASR_7 (8782, "ASR-7"),
    /** ASR-8 */
    ASR_8 (8785, "ASR-8"),
    /** ASR-9 */
    ASR_9 (8790, "ASR-9"),
    /** ASR-11/DASR */
    ASR_11_DASR (8793, "ASR-11/DASR"),
    /** ASR-12 */
    ASR_12 (8795, "ASR-12"),
    /**  */
    undef_44 (8812, ""),
    /** ASR-23SS */
    ASR_23SS (8816, "ASR-23SS"),
    /** Arabel */
    ARABEL (8818, "Arabel"),
    /**   */
    undef_45 (8819, " "),
    /**  */
    undef_46 (8820, ""),
    /** ATCR-33 */
    ATCR_33 (8840, "ATCR-33"),
    /** ATCR 33 K/M */
    ATCR_33_K_M (8845, "ATCR 33 K/M"),
    /** ATCR-33S */
    ATCR_33S (8846, "ATCR-33S"),
    /**   */
    undef_47 (8850, " "),
    /**  */
    undef_48 (8865, ""),
    /** ATLAS-8600X */
    ATLAS_8600X (8866, "ATLAS-8600X"),
    /** Atlas-9600M */
    ATLAS_9600M (8867, "Atlas-9600M"),
    /** ATLAS-9600X */
    ATLAS_9600X (8868, "ATLAS-9600X"),
    /** ATLAS-9600S */
    ATLAS_9600S (8869, "ATLAS-9600S"),
    /** ATLAS-9740 VTS */
    ATLAS_9740_VTS (8870, "ATLAS-9740 VTS"),
    /** AVG 65 */
    AVG_65 (8910, "AVG 65"),
    /** AVH 7 */
    AVH_7 (8955, "AVH 7"),
    /**  */
    undef_49 (8990, ""),
    /**  */
    undef_50 (8995, ""),
    /** AVQ 20 */
    AVQ_20 (9000, "AVQ 20"),
    /** AVQ-21 */
    AVQ_21 (9005, "AVQ-21"),
    /** AVQ30X */
    AVQ30X (9045, "AVQ30X"),
    /** AVQ-50 (RCA) */
    AVQ_50_RCA (9075, "AVQ-50 (RCA)"),
    /** AVQ 70 */
    AVQ_70 (9090, "AVQ 70"),
    /** AWS 5 */
    AWS_5 (9135, "AWS 5"),
    /** AWS 6 */
    AWS_6 (9180, "AWS 6"),
    /** AWS-6B/300 */
    AWS_6B_300 (9185, "AWS-6B/300"),
    /** B597Z */
    B597Z (9200, "B597Z"),
    /** B636Z */
    B636Z (9205, "B636Z"),
    /**  */
    undef_51 (9215, ""),
    /**  */
    undef_52 (9225, ""),
    /**  */
    undef_53 (9270, ""),
    /**  */
    undef_54 (9280, ""),
    /** Balance Beam */
    BALANCE_BEAM (9285, "Balance Beam"),
    /** BALTYK */
    BALTYK (9310, "BALTYK"),
    /**  */
    undef_55 (9315, ""),
    /**  */
    undef_56 (9360, ""),
    /**  */
    undef_57 (9405, ""),
    /**   */
    undef_58 (9406, " "),
    /** P-35/37 ("A"); P-50 ("B") */
    P_35_37_A_P_50_B_ (9450, "P-35/37 ('A'); P-50 ('B')"),
    /** BASIR-110D */
    BASIR_110D (9485, "BASIR-110D"),
    /**  */
    undef_59 (9495, ""),
    /** Badger */
    BADGER (9505, "Badger"),
    /**  */
    undef_60 (9540, ""),
    /**  */
    undef_61 (9585, ""),
    /**  */
    undef_62 (9630, ""),
    /**  */
    undef_63 (9640, ""),
    /**  */
    undef_64 (9642, ""),
    /**  */
    undef_65 (9643, ""),
    /**  */
    undef_66 (9645, ""),
    /**  */
    undef_67 (9659, ""),
    /**  */
    undef_68 (9660, ""),
    /**  */
    undef_69 (9661, ""),
    /**  */
    undef_70 (9675, ""),
    /**  */
    undef_71 (9720, ""),
    /**  */
    undef_72 (9765, ""),
    /**   */
    undef_73 (9775, " "),
    /** SNAR-10 */
    SNAR_10 (9780, "SNAR-10"),
    /**   */
    undef_74 (9781, " "),
    /**  */
    undef_75 (9810, ""),
    /**  */
    undef_76 (9855, ""),
    /** 9S15MT */
    $9S15MT (9885, "9S15MT"),
    /**  */
    undef_77 (9900, ""),
    /** Blowpipe MG */
    BLOWPIPE_MG (9905, "Blowpipe MG"),
    /** Blue Fox */
    BLUE_FOX (9930, "Blue Fox"),
    /** Blue Kestrel */
    BLUE_KESTREL (9933, "Blue Kestrel"),
    /** Blue Vixen */
    BLUE_VIXEN (9935, "Blue Vixen"),
    /** Blue Silk */
    BLUE_SILK (9945, "Blue Silk"),
    /** Blue Parrot */
    BLUE_PARROT (9990, "Blue Parrot"),
    /** Blue Orchid */
    BLUE_ORCHID (10035, "Blue Orchid"),
    /** BM/DJG-8715 */
    BM_DJG_8715 (10057, "BM/DJG-8715"),
    /**  */
    undef_78 (10080, ""),
    /**  */
    undef_79 (10125, ""),
    /**  */
    undef_80 (10170, ""),
    /**  */
    undef_81 (10215, ""),
    /**  */
    undef_82 (10260, ""),
    /**  */
    undef_83 (10305, ""),
    /** BM/KG 8601/8605/8606 */
    BM_KG_8601_8605_8606 (10315, "BM/KG 8601/8605/8606"),
    /** BPS 11A */
    BPS_11A (10350, "BPS 11A"),
    /** BPS 14 */
    BPS_14 (10395, "BPS 14"),
    /** BPS 15A */
    BPS_15A (10440, "BPS 15A"),
    /** BR-15 Tokyo KEIKI */
    BR_15_TOKYO_KEIKI (10485, "BR-15 Tokyo KEIKI"),
    /** BrahMos */
    BRAHMOS (10500, "BrahMos"),
    /**   */
    undef_84 (10510, " "),
    /**   */
    undef_85 (10511, " "),
    /**   */
    undef_86 (10512, " "),
    /**   */
    undef_87 (10513, " "),
    /** Brimstone mmW MH */
    BRIMSTONE_MMW_MH (10520, "Brimstone mmW MH"),
    /**  */
    undef_88 (10530, ""),
    /** Asr */
    ASR (10540, "Asr"),
    /** BT 271 */
    BT_271 (10575, "BT 271"),
    /** BU-304 */
    BU_304 (10595, "BU-304"),
    /** BX 732 */
    BX_732 (10620, "BX 732"),
    /** Buran-D */
    BURAN_D (10642, "Buran-D"),
    /**  */
    undef_89 (10665, ""),
    /** C 5A Multi Mode Radar */
    C_5A_MULTI_MODE_RADAR (10710, "C 5A Multi Mode Radar"),
    /** C-802 AL */
    C_802_AL (10711, "C-802 AL"),
    /**   */
    undef_90 (10740, " "),
    /** Caiman */
    CAIMAN (10755, "Caiman"),
    /**  */
    undef_91 (10800, ""),
    /** Calypso C61 */
    CALYPSO_C61 (10845, "Calypso C61"),
    /** Calypso C63 */
    CALYPSO_C63 (10846, "Calypso C63"),
    /** Calypso Ii */
    CALYPSO_II (10890, "Calypso Ii"),
    /** Calypso III */
    CALYPSO_III (10891, "Calypso III"),
    /** Calypso IV */
    CALYPSO_IV (10892, "Calypso IV"),
    /**  */
    undef_92 (10895, ""),
    /** Castor Ii */
    CASTOR_II (10935, "Castor Ii"),
    /** Castor 2J TT (Crotale NG) */
    CASTOR_2J_TT_CROTALE_NG (10940, "Castor 2J TT (Crotale NG)"),
    /**  */
    undef_93 (10980, ""),
    /** CDR-431 */
    CDR_431 (10985, "CDR-431"),
    /** CEAFAR */
    CEAFAR (10987, "CEAFAR"),
    /** CEAMOUNT */
    CEAMOUNT (10988, "CEAMOUNT"),
    /** CEROS 200 */
    CEROS_200 (10990, "CEROS 200"),
    /** CEROS 200 CWI */
    CEROS_200_CWI (10991, "CEROS 200 CWI"),
    /** CH/SS-N-6 */
    CH_SS_N_6 (10995, "CH/SS-N-6"),
    /**  */
    undef_94 (11000, ""),
    /**  */
    undef_95 (11010, ""),
    /** LEMZ 96L6 */
    LEMZ_96L6 (11020, "LEMZ 96L6"),
    /**  */
    undef_96 (11025, ""),
    /**   */
    undef_97 (11030, " "),
    /** Clam Pipe */
    CLAM_PIPE (11070, "Clam Pipe"),
    /**  */
    undef_98 (11115, ""),
    /** Coastal Giraffe */
    COASTAL_GIRAFFE (11125, "Coastal Giraffe"),
    /** Colibri */
    COLIBRI (11137, "Colibri"),
    /**   */
    undef_99 (11155, " "),
    /**  */
    undef_100 (11160, ""),
    /**  */
    undef_101 (11205, ""),
    /**   */
    undef_102 (11230, " "),
    /**   */
    undef_103 (11240, " "),
    /**  */
    undef_104 (11250, ""),
    /**  */
    undef_105 (11260, ""),
    /** CR-105 RMCA */
    CR_105_RMCA (11270, "CR-105 RMCA"),
    /**  */
    undef_106 (11295, ""),
    /**  */
    undef_107 (11340, ""),
    /**  */
    undef_108 (11385, ""),
    /**  */
    undef_109 (11430, ""),
    /**  */
    undef_110 (11475, ""),
    /**  */
    undef_111 (11520, ""),
    /**  */
    undef_112 (11565, ""),
    /**  */
    undef_113 (11610, ""),
    /** Crotale Acquisition TA */
    CROTALE_ACQUISITION_TA (11655, "Crotale Acquisition TA"),
    /** Crotale NG TA */
    CROTALE_NG_TA (11660, "Crotale NG TA"),
    /** Crotale TT */
    CROTALE_TT (11665, "Crotale TT"),
    /** Crotale MGMissile System */
    CROTALE_MGMISSILE_SYSTEM (11700, "Crotale MGMissile System"),
    /** CS-10-TA */
    CS_10_TA (11715, "CS-10-TA"),
    /** CSF-Varan */
    CSF_VARAN (11725, "CSF-Varan"),
    /** CSS-N-4 MH */
    CSS_N_4_MH (11735, "CSS-N-4 MH"),
    /** CSS C 3C CAS 1M1 M2 MH */
    CSS_C_3C_CAS_1M1_M2_MH (11745, "CSS C 3C CAS 1M1 M2 MH"),
    /** CSS C 2B HY 1A MH */
    CSS_C_2B_HY_1A_MH (11790, "CSS C 2B HY 1A MH"),
    /** CSS-N-4 Sardine */
    CSS_N_4_SARDINE (11800, "CSS-N-4 Sardine"),
    /** CSS-N-8 Saccade */
    CSS_N_8_SACCADE (11810, "CSS-N-8 Saccade"),
    /**   */
    undef_114 (11825, " "),
    /** CWS 2 */
    CWS_2 (11835, "CWS 2"),
    /**  */
    undef_115 (11880, ""),
    /** Cymbeline */
    CYMBELINE (11902, "Cymbeline"),
    /** Cyrano II */
    CYRANO_II (11925, "Cyrano II"),
    /** Cyrano IV */
    CYRANO_IV (11970, "Cyrano IV"),
    /** Cyrano IV-M */
    CYRANO_IV_M (11975, "Cyrano IV-M"),
    /** DA-01/00 */
    DA_01_00 (12010, "DA-01/00"),
    /** DA 05 00 */
    DA_05_00 (12015, "DA 05 00"),
    /** DA-05/2 */
    DA_05_2 (12016, "DA-05/2"),
    /** DA.08 */
    DA08 (12018, "DA.08"),
    /**  */
    undef_116 (12060, ""),
    /**  */
    undef_117 (12105, ""),
    /**  */
    undef_118 (12110, ""),
    /**  */
    undef_119 (12111, ""),
    /**  */
    undef_120 (12150, ""),
    /**  */
    undef_121 (12195, ""),
    /**   */
    undef_122 (12196, " "),
    /**  */
    undef_123 (12240, ""),
    /**  */
    undef_124 (12285, ""),
    /**  */
    undef_125 (12292, ""),
    /**  */
    undef_126 (12330, ""),
    /**  */
    undef_127 (12375, ""),
    /**  */
    undef_128 (12420, ""),
    /**  */
    undef_129 (12430, ""),
    /**  */
    undef_130 (12465, ""),
    /**  */
    undef_131 (12510, ""),
    /**  */
    undef_132 (12555, ""),
    /**  */
    undef_133 (12600, ""),
    /**  */
    undef_134 (12610, ""),
    /**  */
    undef_135 (12615, ""),
    /**   */
    undef_136 (12616, " "),
    /**  */
    undef_137 (12645, ""),
    /**  */
    undef_138 (12655, ""),
    /**  */
    undef_139 (12690, ""),
    /**  */
    undef_140 (12691, ""),
    /**   */
    undef_141 (12694, " "),
    /**  */
    undef_142 (12735, ""),
    /**  */
    undef_143 (12780, ""),
    /**  */
    undef_144 (12782, ""),
    /**  */
    undef_145 (12785, ""),
    /**  */
    undef_146 (12787, ""),
    /**  */
    undef_147 (12800, ""),
    /**  */
    undef_148 (12805, ""),
    /**  */
    undef_149 (12825, ""),
    /** DECCA RM 970BT */
    DECCA_RM_970BT (12850, "DECCA RM 970BT"),
    /**  */
    undef_150 (12870, ""),
    /** DF-21D Seeker */
    DF_21D_SEEKER (12875, "DF-21D Seeker"),
    /**  */
    undef_151 (12915, ""),
    /**   */
    undef_152 (12916, " "),
    /**  */
    undef_153 (12960, ""),
    /** DISS 1 */
    DISS_1 (13005, "DISS 1"),
    /** DISS-7 */
    DISS_7 (13006, "DISS-7"),
    /** DISS-013 */
    DISS_013 (13007, "DISS-013"),
    /** DISS-15D */
    DISS_15D (13015, "DISS-15D"),
    /** Rapier TTDN 181 */
    RAPIER_TTDN_181 (13050, "Rapier TTDN 181"),
    /** Rapier 2000 TT */
    RAPIER_2000_TT (13055, "Rapier 2000 TT"),
    /**  */
    undef_154 (13095, ""),
    /**  */
    undef_155 (13140, ""),
    /** DM3 */
    DM3 (13141, "DM3"),
    /** DM-3B */
    DM_3B (13142, "DM-3B"),
    /** DM-5 */
    DM_5 (13143, "DM-5"),
    /** Don 2 */
    DON_2 (13185, "Don 2"),
    /**  */
    undef_156 (13230, ""),
    /**  */
    undef_157 (13275, ""),
    /**  */
    undef_158 (13320, ""),
    /** DRAA 2A */
    DRAA_2A (13365, "DRAA 2A"),
    /** DRAA 2B */
    DRAA_2B (13410, "DRAA 2B"),
    /** DRAA 9A */
    DRAA_9A (13415, "DRAA 9A"),
    /** DRAA 11A */
    DRAA_11A (13420, "DRAA 11A"),
    /** DRAC 37B */
    DRAC_37B (13450, "DRAC 37B"),
    /** DRAC 38 */
    DRAC_38 (13452, "DRAC 38"),
    /** DRAC 39 */
    DRAC_39 (13455, "DRAC 39"),
    /** DRAC 39A */
    DRAC_39A (13456, "DRAC 39A"),
    /** DRAC 43A */
    DRAC_43A (13460, "DRAC 43A"),
    /** DRAC 44A */
    DRAC_44A (13465, "DRAC 44A"),
    /**  */
    undef_159 (13477, ""),
    /**   */
    undef_160 (13480, " "),
    /**   */
    undef_161 (13481, " "),
    /**   */
    undef_162 (13485, " "),
    /** DRBC 30B */
    DRBC_30B (13500, "DRBC 30B"),
    /** DRBC 31A */
    DRBC_31A (13545, "DRBC 31A"),
    /** DRBC-32 */
    DRBC_32 (13585, "DRBC-32"),
    /** DRBC 32A */
    DRBC_32A (13590, "DRBC 32A"),
    /** DRBC 32D */
    DRBC_32D (13635, "DRBC 32D"),
    /** DRBC 33A */
    DRBC_33A (13680, "DRBC 33A"),
    /** DRBI 10 */
    DRBI_10 (13725, "DRBI 10"),
    /** DRBI 23 */
    DRBI_23 (13770, "DRBI 23"),
    /** DRBJ 11B */
    DRBJ_11B (13815, "DRBJ 11B"),
    /** DRBN 30 */
    DRBN_30 (13860, "DRBN 30"),
    /** DRBN 32 */
    DRBN_32 (13905, "DRBN 32"),
    /** DRBR 51 */
    DRBR_51 (13950, "DRBR 51"),
    /** DRBV 20B */
    DRBV_20B (13995, "DRBV 20B"),
    /** DRBV-21 Mars 05 */
    DRBV_21_MARS_05 (14020, "DRBV-21 Mars 05"),
    /** DRBV 22 */
    DRBV_22 (14040, "DRBV 22"),
    /** DRBV 26C */
    DRBV_26C (14085, "DRBV 26C"),
    /** DRBV 26D */
    DRBV_26D (14086, "DRBV 26D"),
    /** DRBV 30 */
    DRBV_30 (14130, "DRBV 30"),
    /** DRBV 50 */
    DRBV_50 (14175, "DRBV 50"),
    /** DRBV 51 */
    DRBV_51 (14220, "DRBV 51"),
    /** DRBV 51A */
    DRBV_51A (14265, "DRBV 51A"),
    /** DRBV 51B */
    DRBV_51B (14310, "DRBV 51B"),
    /** DRBV 51C */
    DRBV_51C (14355, "DRBV 51C"),
    /** Drop Kick */
    DROP_KICK (14400, "Drop Kick"),
    /** DRUA 31 */
    DRUA_31 (14445, "DRUA 31"),
    /**  */
    undef_163 (14490, ""),
    /**  */
    undef_164 (14535, ""),
    /**  */
    undef_165 (14545, ""),
    /** DRUN 30A */
    DRUN_30A (14560, "DRUN 30A"),
    /**  */
    undef_166 (14580, ""),
    /** EKCO E390 */
    EKCO_E390 (14590, "EKCO E390"),
    /** ECR-90 */
    ECR_90 (14600, "ECR-90"),
    /**  */
    undef_167 (14625, ""),
    /** EKCO E120 */
    EKCO_E120 (14660, "EKCO E120"),
    /** EKCO 190 */
    EKCO_190 (14670, "EKCO 190"),
    /** EL/L-8222 */
    EL_L_8222 (14710, "EL/L-8222"),
    /** EL M 2001B */
    EL_M_2001B (14715, "EL M 2001B"),
    /** EL/M-2022 */
    EL_M_2022 (14725, "EL/M-2022"),
    /** EL/M-2032 */
    EL_M_2032 (14726, "EL/M-2032"),
    /** EL/M-2055 */
    EL_M_2055 (14728, "EL/M-2055"),
    /** EL/M-2060 */
    EL_M_2060 (14730, "EL/M-2060"),
    /** EL/M-2075 */
    EL_M_2075 (14735, "EL/M-2075"),
    /** EL/M-2200 */
    EL_M_2200 (14750, "EL/M-2200"),
    /** EL M 2207 */
    EL_M_2207 (14760, "EL M 2207"),
    /**  */
    undef_168 (14770, ""),
    /** EL/M-2218S */
    EL_M_2218S (14775, "EL/M-2218S"),
    /** ELT-361 */
    ELT_361 (14776, "ELT-361"),
    /** ELT-558 */
    ELT_558 (14780, "ELT-558"),
    /** ELT-572 */
    ELT_572 (14785, "ELT-572"),
    /** ELTA EL/M 2221 GM STGR */
    ELTA_EL_M_2221_GM_STGR (14805, "ELTA EL/M 2221 GM STGR"),
    /** EL/M-2228S/3D */
    EL_M_2228S_3D (14806, "EL/M-2228S/3D"),
    /** EL/M-2705 */
    EL_M_2705 (14807, "EL/M-2705"),
    /** EL/M-2228X */
    EL_M_2228X (14809, "EL/M-2228X"),
    /** ELTA SIS */
    ELTA_SIS (14810, "ELTA SIS"),
    /** EL/M-2238 */
    EL_M_2238 (14811, "EL/M-2238"),
    /** EL/M-2248 */
    EL_M_2248 (14815, "EL/M-2248"),
    /**   */
    undef_169 (14830, " "),
    /** EMD 2900 */
    EMD_2900 (14850, "EMD 2900"),
    /** EMPAR */
    EMPAR (14851, "EMPAR"),
    /**  */
    undef_170 (14895, ""),
    /** Ericsson SLAR */
    ERICSSON_SLAR (14897, "Ericsson SLAR"),
    /** Erieye */
    ERIEYE (14898, "Erieye"),
    /** ESR 1 */
    ESR_1 (14900, "ESR 1"),
    /** ET-316 */
    ET_316 (14905, "ET-316"),
    /** Exocet Type */
    EXOCET_TYPE (14935, "Exocet Type"),
    /** Exocet AL */
    EXOCET_AL (14936, "Exocet AL"),
    /** Exocet 1 */
    EXOCET_1 (14940, "Exocet 1"),
    /** Exocet 1 MH */
    EXOCET_1_MH (14985, "Exocet 1 MH"),
    /** Exocet 2 */
    EXOCET_2 (15030, "Exocet 2"),
    /**  */
    undef_171 (15075, ""),
    /**  */
    undef_172 (15120, ""),
    /**  */
    undef_173 (15140, ""),
    /**  */
    undef_174 (15155, ""),
    /**  */
    undef_175 (15156, ""),
    /** FALCON */
    FALCON (15160, "FALCON"),
    /** FALCON-G */
    FALCON_G (15161, "FALCON-G"),
    /**   */
    undef_176 (15163, " "),
    /**  */
    undef_177 (15165, ""),
    /**  */
    undef_178 (15200, ""),
    /**  */
    undef_179 (15210, ""),
    /**  */
    undef_180 (15220, ""),
    /**  */
    undef_181 (15230, ""),
    /**  */
    undef_182 (15240, ""),
    /**  */
    undef_183 (15255, ""),
    /**  */
    undef_184 (15300, ""),
    /** FAR-2117 */
    FAR_2117 (15301, "FAR-2117"),
    /** FAR-2827 */
    FAR_2827 (15302, "FAR-2827"),
    /** FAR-2837S */
    FAR_2837S (15303, "FAR-2837S"),
    /** FB-7 Radar */
    FB_7_RADAR (15305, "FB-7 Radar"),
    /** FCR-1401 */
    FCR_1401 (15310, "FCR-1401"),
    /** FCS-2-12E */
    FCS_2_12E (15312, "FCS-2-12E"),
    /** FCS-2-12G */
    FCS_2_12G (15313, "FCS-2-12G"),
    /** FCS-2-21A */
    FCS_2_21A (15315, "FCS-2-21A"),
    /** FCS-2-21C */
    FCS_2_21C (15317, "FCS-2-21C"),
    /** FCS-2-31 */
    FCS_2_31 (15319, "FCS-2-31"),
    /** FCS-3 */
    FCS_3 (15320, "FCS-3"),
    /**  */
    undef_185 (15345, ""),
    /**  */
    undef_186 (15390, ""),
    /**  */
    undef_187 (15435, ""),
    /**  */
    undef_188 (15470, ""),
    /**  */
    undef_189 (15475, ""),
    /**  */
    undef_190 (15480, ""),
    /**  */
    undef_191 (15525, ""),
    /**  */
    undef_192 (15570, ""),
    /**  */
    undef_193 (15615, ""),
    /**  */
    undef_194 (15660, ""),
    /**  */
    undef_195 (15705, ""),
    /**  */
    undef_196 (15750, ""),
    /**  */
    undef_197 (15795, ""),
    /**   */
    undef_198 (15800, " "),
    /** P-15 */
    P_15 (15840, "P-15"),
    /**  */
    undef_199 (15842, ""),
    /**  */
    undef_200 (15885, ""),
    /**  */
    undef_201 (15930, ""),
    /**  */
    undef_202 (15975, ""),
    /** FL-400 */
    FL_400 (15980, "FL-400"),
    /** Fledermaus */
    FLEDERMAUS (16020, "Fledermaus"),
    /**  */
    undef_203 (16030, ""),
    /**  */
    undef_204 (16065, ""),
    /**  */
    undef_205 (16110, ""),
    /**  */
    undef_206 (16155, ""),
    /**  */
    undef_207 (16200, ""),
    /**  */
    undef_208 (16245, ""),
    /**  */
    undef_209 (16290, ""),
    /** FootBall */
    FOOTBALL (16300, "FootBall"),
    /** Fox Hunter */
    FOX_HUNTER (16335, "Fox Hunter"),
    /**  */
    undef_210 (16380, ""),
    /**  */
    undef_211 (16390, ""),
    /** FR-151A */
    FR_151A (16400, "FR-151A"),
    /**   */
    undef_212 (16405, " "),
    /** FR-1505 DA */
    FR_1505_DA (16410, "FR-1505 DA"),
    /** FR-1510DS */
    FR_1510DS (16412, "FR-1510DS"),
    /** FR-2000 */
    FR_2000 (16420, "FR-2000"),
    /** Furuno-2855W */
    FURUNO_2855W (16421, "Furuno-2855W"),
    /**   */
    undef_213 (16422, " "),
    /**   */
    undef_214 (16423, " "),
    /**   */
    undef_215 (16424, " "),
    /**  */
    undef_216 (16425, ""),
    /**  */
    undef_217 (16470, ""),
    /**  */
    undef_218 (16515, ""),
    /** Furby mmW MH */
    FURBY_MMW_MH (16520, "Furby mmW MH"),
    /**   */
    undef_219 (16550, " "),
    /** Furuno */
    FURUNO (16560, "Furuno"),
    /** Furuno 1721 */
    FURUNO_1721 (16561, "Furuno 1721"),
    /**   */
    undef_220 (16564, " "),
    /**   */
    undef_221 (16565, " "),
    /** Furuno 1730 */
    FURUNO_1730 (16580, "Furuno 1730"),
    /** Furuno 1832 */
    FURUNO_1832 (16585, "Furuno 1832"),
    /**   */
    undef_222 (16587, " "),
    /** Furuno 1932 */
    FURUNO_1932 (16590, "Furuno 1932"),
    /**   */
    undef_223 (16596, " "),
    /** Furuno 701 */
    FURUNO_701 (16605, "Furuno 701"),
    /** Furuno 1940 */
    FURUNO_1940 (16606, "Furuno 1940"),
    /** Furuno 711 2 */
    FURUNO_711_2 (16650, "Furuno 711 2"),
    /** Furuno FAR-2137S */
    FURUNO_FAR_2137S (16654, "Furuno FAR-2137S"),
    /** Furuno FAR-28X7 */
    FURUNO_FAR_28X7 (16655, "Furuno FAR-28X7"),
    /** FR-2110 */
    FR_2110 (16660, "FR-2110"),
    /** FR-2115 */
    FR_2115 (16662, "FR-2115"),
    /** FR-8062 */
    FR_8062 (16663, "FR-8062"),
    /** Furuno 2125 */
    FURUNO_2125 (16670, "Furuno 2125"),
    /** Furuno 240 */
    FURUNO_240 (16690, "Furuno 240"),
    /** Furuno 2400 */
    FURUNO_2400 (16695, "Furuno 2400"),
    /** Furuno 8051 */
    FURUNO_8051 (16730, "Furuno 8051"),
    /**   */
    undef_224 (16732, " "),
    /**   */
    undef_225 (16733, " "),
    /**   */
    undef_226 (16734, " "),
    /** G030A(APD-31) */
    G030AAPD_31 (16735, "G030A(APD-31)"),
    /** GA 01 00 */
    GA_01_00 (16740, "GA 01 00"),
    /**  */
    undef_227 (16785, ""),
    /**  */
    undef_228 (16800, ""),
    /**  */
    undef_229 (16830, ""),
    /**  */
    undef_230 (16833, ""),
    /** Garpun-Bal-E */
    GARPUN_BAL_E (16835, "Garpun-Bal-E"),
    /** GBS1 */
    GBS1 (16840, "GBS1"),
    /**   */
    undef_231 (16858, " "),
    /** GEM BX 132 */
    GEM_BX_132 (16875, "GEM BX 132"),
    /** GEM SC-2050X */
    GEM_SC_2050X (16876, "GEM SC-2050X"),
    /** MPDR-12 */
    MPDR_12 (16880, "MPDR-12"),
    /**  */
    undef_232 (16884, ""),
    /** GERAN-F */
    GERAN_F (16888, "GERAN-F"),
    /** GIRAFFE */
    GIRAFFE (16900, "GIRAFFE"),
    /** Giraffe-40 */
    GIRAFFE_40 (16905, "Giraffe-40"),
    /** Giraffe-50 AT */
    GIRAFFE_50_AT (16908, "Giraffe-50 AT"),
    /** Giraffe 75 */
    GIRAFFE_75 (16912, "Giraffe 75"),
    /**  */
    undef_233 (16915, ""),
    /** Gin Sling */
    GIN_SLING (16920, "Gin Sling"),
    /**  */
    undef_234 (16925, ""),
    /** Goal Keeper */
    GOAL_KEEPER (16930, "Goal Keeper"),
    /**  */
    undef_235 (16931, ""),
    /**  */
    undef_236 (16932, ""),
    /**  */
    undef_237 (16935, ""),
    /**  */
    undef_238 (16940, ""),
    /**   */
    undef_239 (16942, " "),
    /** GPN-22 */
    GPN_22 (16945, "GPN-22"),
    /** GPSJ-10 */
    GPSJ_10 (16946, "GPSJ-10"),
    /** GPSJ-25 */
    GPSJ_25 (16947, "GPSJ-25"),
    /** GPSJ-40 */
    GPSJ_40 (16948, "GPSJ-40"),
    /** GPSJ-50 */
    GPSJ_50 (16949, "GPSJ-50"),
    /** GRN-9 */
    GRN_9 (16950, "GRN-9"),
    /**  */
    undef_240 (16960, ""),
    /** Green Stain */
    GREEN_STAIN (16965, "Green Stain"),
    /**  */
    undef_241 (17010, ""),
    /** Grifo-F */
    GRIFO_F (17016, "Grifo-F"),
    /** 9S32 */
    $9S32 (17025, "9S32"),
    /** GT-4 */
    GT_4 (17031, "GT-4"),
    /** Guardsman */
    GUARDSMAN (17055, "Guardsman"),
    /** RPK-2 */
    RPK_2 (17070, "RPK-2"),
    /** HADR */
    HADR (17080, "HADR"),
    /**  */
    undef_242 (17100, ""),
    /**  */
    undef_243 (17145, ""),
    /**  */
    undef_244 (17190, ""),
    /** HARD */
    HARD (17220, "HARD"),
    /** Harpoon */
    HARPOON (17225, "Harpoon"),
    /**   */
    undef_245 (17230, " "),
    /**  */
    undef_246 (17235, ""),
    /**   */
    undef_247 (17250, " "),
    /**   */
    undef_248 (17255, " "),
    /**  */
    undef_249 (17280, ""),
    /**  */
    undef_250 (17325, ""),
    /**  */
    undef_251 (17370, ""),
    /**  */
    undef_252 (17415, ""),
    /**  */
    undef_253 (17460, ""),
    /**  */
    undef_254 (17505, ""),
    /**  */
    undef_255 (17550, ""),
    /**  */
    undef_256 (17572, ""),
    /** Hellfire mmW MH */
    HELLFIRE_MMW_MH (17590, "Hellfire mmW MH"),
    /**  */
    undef_257 (17595, ""),
    /**  */
    undef_258 (17640, ""),
    /**  */
    undef_259 (17685, ""),
    /**  */
    undef_260 (17730, ""),
    /**   */
    undef_261 (17732, " "),
    /** HF-2 MG */
    HF_2_MG (17735, "HF-2 MG"),
    /** HGR-105 */
    HGR_105 (17745, "HGR-105"),
    /**  */
    undef_262 (17775, ""),
    /**  */
    undef_263 (17820, ""),
    /**  */
    undef_264 (17842, ""),
    /**  */
    undef_265 (17865, ""),
    /**  */
    undef_266 (17910, ""),
    /**  */
    undef_267 (17955, ""),
    /**  */
    undef_268 (18000, ""),
    /**  */
    undef_269 (18045, ""),
    /**  */
    undef_270 (18090, ""),
    /**  */
    undef_271 (18135, ""),
    /** 9S19MT */
    $9S19MT (18150, "9S19MT"),
    /**  */
    undef_272 (18180, ""),
    /**   */
    undef_273 (18185, " "),
    /**  */
    undef_274 (18190, ""),
    /** HLJQ-520 */
    HLJQ_520 (18195, "HLJQ-520"),
    /** HN-503 */
    HN_503 (18200, "HN-503"),
    /** HN-C03-M */
    HN_C03_M (18201, "HN-C03-M"),
    /**  */
    undef_275 (18225, ""),
    /**  */
    undef_276 (18270, ""),
    /**  */
    undef_277 (18280, ""),
    /**  */
    undef_278 (18315, ""),
    /**   */
    undef_279 (18316, " "),
    /** IHS-6 */
    IHS_6 (18318, "IHS-6"),
    /** IRL144M */
    IRL144M (18320, "IRL144M"),
    /** IRL144M */
    IRL144M_2 (18325, "IRL144M"),
    /** IRL144M */
    IRL144M_3 (18330, "IRL144M"),
    /** HQ-9 MH */
    HQ_9_MH (18339, "HQ-9 MH"),
    /**   */
    undef_280 (18340, " "),
    /** HQ-61 */
    HQ_61 (18350, "HQ-61"),
    /** HRJS */
    HRJS (18351, "HRJS"),
    /** IFF MK XII AIMS UPX 29 */
    IFF_MK_XII_AIMS_UPX_29 (18360, "IFF MK XII AIMS UPX 29"),
    /** IFF MK XV */
    IFF_MK_XV (18405, "IFF MK XV"),
    /** IFF INT */
    IFF_INT (18406, "IFF INT"),
    /**  */
    undef_281 (18407, ""),
    /** IFF TRSP */
    IFF_TRSP (18408, "IFF TRSP"),
    /** Javelin MG */
    JAVELIN_MG (18410, "Javelin MG"),
    /**  */
    undef_282 (18450, ""),
    /** JH-10 */
    JH_10 (18452, "JH-10"),
    /** JL-7 */
    JL_7 (18454, "JL-7"),
    /** JL-10B */
    JL_10B (18455, "JL-10B"),
    /** JMA 1576 */
    JMA_1576 (18456, "JMA 1576"),
    /** JRC JMA-9252-6CA */
    JRC_JMA_9252_6CA (18457, "JRC JMA-9252-6CA"),
    /** JLP-40 */
    JLP_40 (18458, "JLP-40"),
    /** JRC JMR-9200 Series X */
    JRC_JMR_9200_SERIES_X (18459, "JRC JMR-9200 Series X"),
    /** JRC-NMD-401 */
    JRC_NMD_401 (18460, "JRC-NMD-401"),
    /** JRC JRM 310 MK2 */
    JRC_JRM_310_MK2 (18461, "JRC JRM 310 MK2"),
    /** JMA 1596 */
    JMA_1596 (18462, "JMA 1596"),
    /** JMA 7000 */
    JMA_7000 (18464, "JMA 7000"),
    /** JRC JMA 7700 */
    JRC_JMA_7700 (18465, "JRC JMA 7700"),
    /** JMA 5320 */
    JMA_5320 (18466, "JMA 5320"),
    /** JRC JMR-9210-6XC */
    JRC_JMR_9210_6XC (18467, "JRC JMR-9210-6XC"),
    /** JRC JMA-9900 series */
    JRC_JMA_9900_SERIES (18470, "JRC JMA-9900 series"),
    /** JRC JMA-5300 series */
    JRC_JMA_5300_SERIES (18475, "JRC JMA-5300 series"),
    /** Jupiter */
    JUPITER (18495, "Jupiter"),
    /** Jupiter II */
    JUPITER_II (18540, "Jupiter II"),
    /** JY-8 */
    JY_8 (18550, "JY-8"),
    /** JY-8A */
    JY_8A (18551, "JY-8A"),
    /** JY-9 */
    JY_9 (18555, "JY-9"),
    /** JY-9 Modified */
    JY_9_MODIFIED (18556, "JY-9 Modified"),
    /** JY-11 EW */
    JY_11_EW (18557, "JY-11 EW"),
    /** JY-14 */
    JY_14 (18560, "JY-14"),
    /** JY-14A */
    JY_14A (18561, "JY-14A"),
    /** JY-24 */
    JY_24 (18570, "JY-24"),
    /** J/APG-1 */
    J_APG_1 (18571, "J/APG-1"),
    /** J/APG-2 */
    J_APG_2 (18572, "J/APG-2"),
    /** JY-29 */
    JY_29 (18575, "JY-29"),
    /** JYL-1 */
    JYL_1 (18578, "JYL-1"),
    /** JYL-6 */
    JYL_6 (18580, "JYL-6"),
    /** JYL-6A */
    JYL_6A (18582, "JYL-6A"),
    /**  */
    undef_283 (18585, ""),
    /** Kaige */
    KAIGE (18600, "Kaige"),
    /**  */
    undef_284 (18630, ""),
    /**  */
    undef_285 (18675, ""),
    /**   */
    undef_286 (18700, " "),
    /**  */
    undef_287 (18720, ""),
    /**  */
    undef_288 (18765, ""),
    /**   */
    undef_289 (18770, " "),
    /**   */
    undef_290 (18774, " "),
    /**   */
    undef_291 (18775, " "),
    /**   */
    undef_292 (18776, " "),
    /**   */
    undef_293 (18777, " "),
    /** KH Family */
    KH_FAMILY (18780, "KH Family"),
    /**   */
    undef_294 (18781, " "),
    /** Kh-38MAE MH */
    KH_38MAE_MH (18782, "Kh-38MAE MH"),
    /** KG8605A */
    KG8605A (18784, "KG8605A"),
    /** KH-902M */
    KH_902M (18785, "KH-902M"),
    /** KHOROM-K */
    KHOROM_K (18786, "KHOROM-K"),
    /** KG300E */
    KG300E (18789, "KG300E"),
    /**   */
    undef_295 (18790, " "),
    /** KH 1700 */
    KH_1700 (18795, "KH 1700"),
    /**  */
    undef_296 (18797, ""),
    /** KG-300 */
    KG_300 (18805, "KG-300"),
    /**  */
    undef_297 (18810, ""),
    /**  */
    undef_298 (18855, ""),
    /**  */
    undef_299 (18900, ""),
    /**  */
    undef_300 (18945, ""),
    /** KLC-1 */
    KLC_1 (18947, "KLC-1"),
    /** KLJ-1 */
    KLJ_1 (18948, "KLJ-1"),
    /** KLJ-3 (Type 1473) */
    KLJ_3_TYPE_1473 (18950, "KLJ-3 (Type 1473)"),
    /** KLJ-4 */
    KLJ_4 (18951, "KLJ-4"),
    /** KLJ-4B */
    KLJ_4B (18952, "KLJ-4B"),
    /** KLJ-7 */
    KLJ_7 (18960, "KLJ-7"),
    /** KLJ-7B */
    KLJ_7B (18961, "KLJ-7B"),
    /**  */
    undef_301 (18990, ""),
    /** P-10 */
    P_10 (19035, "P-10"),
    /**  */
    undef_302 (19037, ""),
    /**   */
    undef_303 (19039, " "),
    /** KJ-2000 */
    KJ_2000 (19040, "KJ-2000"),
    /** KOPYO-I */
    KOPYO_I (19045, "KOPYO-I"),
    /** KR-75 */
    KR_75 (19050, "KR-75"),
    /** KRONOS */
    KRONOS (19051, "KRONOS"),
    /** KSA SRN */
    KSA_SRN (19080, "KSA SRN"),
    /** KSA TSR */
    KSA_TSR (19125, "KSA TSR"),
    /** KS418 */
    KS418 (19129, "KS418"),
    /** KZ100 */
    KZ100 (19131, "KZ100"),
    /** KZ900 */
    KZ900 (19132, "KZ900"),
    /**  */
    undef_304 (19170, ""),
    /**  */
    undef_305 (19215, ""),
    /**  */
    undef_306 (19260, ""),
    /**  */
    undef_307 (19305, ""),
    /** LAZUR */
    LAZUR (19306, "LAZUR"),
    /** Model 791-A */
    MODEL_791_A (19307, "Model 791-A"),
    /** LC-150 */
    LC_150 (19310, "LC-150"),
    /**   */
    undef_308 (19330, " "),
    /**  */
    undef_309 (19350, ""),
    /**  */
    undef_310 (19395, ""),
    /** LIROD 8 */
    LIROD_8 (19397, "LIROD 8"),
    /** LIROD MK II */
    LIROD_MK_II (19398, "LIROD MK II"),
    /** LMT NRAI-6A */
    LMT_NRAI_6A (19400, "LMT NRAI-6A"),
    /** LN 55 */
    LN_55 (19440, "LN 55"),
    /**  */
    undef_311 (19485, ""),
    /**   */
    undef_312 (19500, " "),
    /**   */
    undef_313 (19505, " "),
    /**  */
    undef_314 (19530, ""),
    /**  */
    undef_315 (19575, ""),
    /**  */
    undef_316 (19620, ""),
    /**  */
    undef_317 (19665, ""),
    /**  */
    undef_318 (19710, ""),
    /**  */
    undef_319 (19755, ""),
    /**  */
    undef_320 (19800, ""),
    /**  */
    undef_321 (19845, ""),
    /**  */
    undef_322 (19890, ""),
    /** LORAN */
    LORAN (19935, "LORAN"),
    /**  */
    undef_323 (19950, ""),
    /**  */
    undef_324 (19955, ""),
    /**  */
    undef_325 (19960, ""),
    /**   */
    undef_326 (19970, " "),
    /**   */
    undef_327 (19971, " "),
    /**  */
    undef_328 (19980, ""),
    /**  */
    undef_329 (20025, ""),
    /** LR66 */
    LR66 (20029, "LR66"),
    /** TRS-2050 */
    TRS_2050 (20040, "TRS-2050"),
    /** LW 08 */
    LW_08 (20070, "LW 08"),
    /**  */
    undef_330 (20090, ""),
    /** M22-40 */
    M22_40 (20115, "M22-40"),
    /** M44 */
    M44 (20160, "M44"),
    /**  */
    undef_331 (20205, ""),
    /**  */
    undef_332 (20250, ""),
    /**  */
    undef_333 (20295, ""),
    /** MA 1 IFF Portion */
    MA_1_IFF_PORTION (20340, "MA 1 IFF Portion"),
    /**  */
    undef_334 (20360, ""),
    /**  */
    undef_335 (20385, ""),
    /** MARC S-152 */
    MARC_S_152 (20420, "MARC S-152"),
    /**  */
    undef_336 (20430, ""),
    /**  */
    undef_337 (20475, ""),
    /**  */
    undef_338 (20495, ""),
    /**  */
    undef_339 (20520, ""),
    /**  */
    undef_340 (20530, ""),
    /**  */
    undef_341 (20565, ""),
    /**  */
    undef_342 (20585, ""),
    /**   */
    undef_343 (20590, " "),
    /**  */
    undef_344 (20610, ""),
    /**  */
    undef_345 (20655, ""),
    /**  */
    undef_346 (20700, ""),
    /**  */
    undef_347 (20745, ""),
    /**  */
    undef_348 (20790, ""),
    /**  */
    undef_349 (20835, ""),
    /**  */
    undef_350 (20880, ""),
    /** MELCO-3 */
    MELCO_3 (20915, "MELCO-3"),
    /**  */
    undef_351 (20920, ""),
    /**  */
    undef_352 (20925, ""),
    /** MFR */
    MFR (20935, "MFR"),
    /** MICA MH */
    MICA_MH (20942, "MICA MH"),
    /** Mineral-ME */
    MINERAL_ME (20945, "Mineral-ME"),
    /** Mirage ILL */
    MIRAGE_ILL (20950, "Mirage ILL"),
    /** MK 15 (Phalanx BLK 0) */
    MK_15_PHALANX_BLK_0 (20969, "MK 15 (Phalanx BLK 0)"),
    /**  */
    undef_353 (20970, ""),
    /** MK-23 */
    MK_23 (21015, "MK-23"),
    /** MK 23 TAS */
    MK_23_TAS (21060, "MK 23 TAS"),
    /** MK 25 */
    MK_25 (21105, "MK 25"),
    /** Mk-25 Mod-3 */
    MK_25_MOD_3 (21110, "Mk-25 Mod-3"),
    /** MK-35 M2 */
    MK_35_M2 (21150, "MK-35 M2"),
    /** MK 92 */
    MK_92 (21195, "MK 92"),
    /** MK-92 CAS */
    MK_92_CAS (21240, "MK-92 CAS"),
    /** MK-92 STIR */
    MK_92_STIR (21285, "MK-92 STIR"),
    /** MK 95 */
    MK_95 (21330, "MK 95"),
    /** MKS-818 */
    MKS_818 (21332, "MKS-818"),
    /** MLA-1 */
    MLA_1 (21340, "MLA-1"),
    /** MM/APQ-706 */
    MM_APQ_706 (21359, "MM/APQ-706"),
    /** MM 950 */
    MM_950 (21360, "MM 950"),
    /** MM APS 705 */
    MM_APS_705 (21375, "MM APS 705"),
    /** MM SPG 74 */
    MM_SPG_74 (21420, "MM SPG 74"),
    /** MM SPG 75 */
    MM_SPG_75 (21465, "MM SPG 75"),
    /** MM SPN 703 */
    MM_SPN_703 (21490, "MM SPN 703"),
    /** MM SPN-753B */
    MM_SPN_753B (21495, "MM SPN-753B"),
    /** MM SPS 702 */
    MM_SPS_702 (21510, "MM SPS 702"),
    /** MM SPS 768 */
    MM_SPS_768 (21555, "MM SPS 768"),
    /** MM SPS 774 */
    MM_SPS_774 (21600, "MM SPS 774"),
    /** MM SPS-794 (RAN-21S) */
    MM_SPS_794_RAN_21S (21615, "MM SPS-794 (RAN-21S)"),
    /** MM/SPS-798 (RAN-40L) */
    MM_SPS_798_RAN_40L (21620, "MM/SPS-798 (RAN-40L)"),
    /** Model-17C */
    MODEL_17C (21625, "Model-17C"),
    /** Moon 4 */
    MOON_4 (21645, "Moon 4"),
    /**  */
    undef_354 (21646, ""),
    /**   */
    undef_355 (21648, " "),
    /**  */
    undef_356 (21650, ""),
    /** Model 360 */
    MODEL_360 (21655, "Model 360"),
    /** Model 378 */
    MODEL_378 (21660, "Model 378"),
    /** Model-970 */
    MODEL_970 (21661, "Model-970"),
    /** Model 974 */
    MODEL_974 (21665, "Model 974"),
    /**   */
    undef_357 (21675, " "),
    /**   */
    undef_358 (21680, " "),
    /** MPDR 18 X */
    MPDR_18_X (21690, "MPDR 18 X"),
    /** MPR */
    MPR (21695, "MPR"),
    /**   */
    undef_359 (21699, " "),
    /** MR-1600 */
    MR_1600 (21700, "MR-1600"),
    /** MRR */
    MRR (21701, "MRR"),
    /** MT-305X */
    MT_305X (21710, "MT-305X"),
    /**  */
    undef_360 (21735, ""),
    /** Mushroom */
    MUSHROOM (21780, "Mushroom"),
    /** Mushroom 1 */
    MUSHROOM_1 (21825, "Mushroom 1"),
    /** Mushroom 2 */
    MUSHROOM_2 (21870, "Mushroom 2"),
    /**   */
    undef_361 (21871, " "),
    /** N-011M Bars */
    N_011M_BARS (21873, "N-011M Bars"),
    /** N-011M Bars-B */
    N_011M_BARS_B (21874, "N-011M Bars-B"),
    /** N-011M Bars-C */
    N_011M_BARS_C (21875, "N-011M Bars-C"),
    /** N-011M Bars-R */
    N_011M_BARS_R (21876, "N-011M Bars-R"),
    /** N035 Irbis-E */
    N035_IRBIS_E (21877, "N035 Irbis-E"),
    /** N036 Byelka */
    N036_BYELKA (21878, "N036 Byelka"),
    /** N920Z */
    N920Z (21880, "N920Z"),
    /** NACOS RADARPILOT Platinum */
    NACOS_RADARPILOT_PLATINUM (21884, "NACOS RADARPILOT Platinum"),
    /**   */
    undef_362 (21885, " "),
    /**  */
    undef_363 (21890, ""),
    /**  */
    undef_364 (21895, ""),
    /** Nayada */
    NAYADA (21915, "Nayada"),
    /** Nebo-SVU */
    NEBO_SVU (21920, "Nebo-SVU"),
    /** Neptun */
    NEPTUN (21960, "Neptun"),
    /**  */
    undef_365 (21980, ""),
    /** NJ-81E */
    NJ_81E (21983, "NJ-81E"),
    /** NRJ-6A */
    NRJ_6A (21985, "NRJ-6A"),
    /**  */
    undef_366 (21992, ""),
    /** NRBA 50 */
    NRBA_50 (22005, "NRBA 50"),
    /** NRBA 51 */
    NRBA_51 (22050, "NRBA 51"),
    /** NRBF 20A */
    NRBF_20A (22095, "NRBF 20A"),
    /** NRJ-5 */
    NRJ_5 (22110, "NRJ-5"),
    /**  */
    undef_367 (22140, ""),
    /**  */
    undef_368 (22185, ""),
    /**  */
    undef_369 (22230, ""),
    /**  */
    undef_370 (22275, ""),
    /**  */
    undef_371 (22320, ""),
    /** Ocean Master */
    OCEAN_MASTER (22335, "Ocean Master"),
    /**  */
    undef_372 (22345, ""),
    /**  */
    undef_373 (22365, ""),
    /**  */
    undef_374 (22410, ""),
    /**  */
    undef_375 (22411, ""),
    /**  */
    undef_376 (22455, ""),
    /** OKEAN */
    OKEAN (22500, "OKEAN"),
    /** OKEAN A */
    OKEAN_A (22505, "OKEAN A"),
    /** OKINXE 12C */
    OKINXE_12C (22545, "OKINXE 12C"),
    /** OKO */
    OKO (22560, "OKO"),
    /** OMEGA */
    OMEGA (22590, "OMEGA"),
    /** Omera ORB32 */
    OMERA_ORB32 (22635, "Omera ORB32"),
    /** OMUL */
    OMUL (22640, "OMUL"),
    /**  */
    undef_377 (22680, ""),
    /** OP-28 */
    OP_28 (22690, "OP-28"),
    /** OPS-9 */
    OPS_9 (22697, "OPS-9"),
    /** OPS-11 B/C */
    OPS_11_B_C (22700, "OPS-11 B/C"),
    /** OPS-14B */
    OPS_14B (22705, "OPS-14B"),
    /** OPS-14C */
    OPS_14C (22706, "OPS-14C"),
    /** OPS-16B */
    OPS_16B (22725, "OPS-16B"),
    /** OPS-18 */
    OPS_18 (22730, "OPS-18"),
    /** OPS-19 */
    OPS_19 (22732, "OPS-19"),
    /** OPS-20 */
    OPS_20 (22735, "OPS-20"),
    /** OPS-24 */
    OPS_24 (22737, "OPS-24"),
    /** OPS-28 */
    OPS_28 (22740, "OPS-28"),
    /** OPS-39 */
    OPS_39 (22750, "OPS-39"),
    /**  */
    undef_378 (22770, ""),
    /** ORB-31S */
    ORB_31S (22810, "ORB-31S"),
    /** ORB 32 */
    ORB_32 (22815, "ORB 32"),
    /** ORB-42 */
    ORB_42 (22830, "ORB-42"),
    /** Orion Rtn 10X */
    ORION_RTN_10X (22860, "Orion Rtn 10X"),
    /** Surface Wave (Over The Horizon) */
    SURFACE_WAVE_OVER_THE_HORIZON (22890, "Surface Wave (Over The Horizon)"),
    /** Otomat MK 1 */
    OTOMAT_MK_1 (22900, "Otomat MK 1"),
    /** Otomat MK II Teseo */
    OTOMAT_MK_II_TESEO (22905, "Otomat MK II Teseo"),
    /** Otomat Series AL */
    OTOMAT_SERIES_AL (22906, "Otomat Series AL"),
    /**  */
    undef_379 (22950, ""),
    /** P360Z */
    P360Z (22955, "P360Z"),
    /** PA-1660 */
    PA_1660 (22960, "PA-1660"),
    /**  */
    undef_380 (22977, ""),
    /**  */
    undef_381 (22995, ""),
    /**  */
    undef_382 (22998, ""),
    /**  */
    undef_383 (23040, ""),
    /**  */
    undef_384 (23085, ""),
    /**  */
    undef_385 (23095, ""),
    /**  */
    undef_386 (23130, ""),
    /**  */
    undef_387 (23175, ""),
    /** PBR 4 Rubin */
    PBR_4_RUBIN (23220, "PBR 4 Rubin"),
    /**  */
    undef_388 (23265, ""),
    /**  */
    undef_389 (23310, ""),
    /**  */
    undef_390 (23355, ""),
    /**  */
    undef_391 (23400, ""),
    /**  */
    undef_392 (23445, ""),
    /**  */
    undef_393 (23450, ""),
    /**  */
    undef_394 (23490, ""),
    /**   */
    undef_395 (23500, " "),
    /** Phalanx */
    PHALANX (23525, "Phalanx"),
    /**  */
    undef_396 (23535, ""),
    /**  */
    undef_397 (23580, ""),
    /**  */
    undef_398 (23625, ""),
    /**  */
    undef_399 (23670, ""),
    /**   */
    undef_400 (23685, " "),
    /**  */
    undef_401 (23690, ""),
    /**   */
    undef_402 (23695, " "),
    /** PL-11 */
    PL_11 (23700, "PL-11"),
    /** PL-12 */
    PL_12 (23701, "PL-12"),
    /**  */
    undef_403 (23710, ""),
    /**  */
    undef_404 (23715, ""),
    /**  */
    undef_405 (23760, ""),
    /**  */
    undef_406 (23805, ""),
    /**  */
    undef_407 (23850, ""),
    /**  */
    undef_408 (23895, ""),
    /**  */
    undef_409 (23925, ""),
    /**  */
    undef_410 (23940, ""),
    /**  */
    undef_411 (23985, ""),
    /**  */
    undef_412 (23990, ""),
    /**   */
    undef_413 (24020, " "),
    /**  */
    undef_414 (24030, ""),
    /** Plessey AWS 9 */
    PLESSEY_AWS_9 (24035, "Plessey AWS 9"),
    /**  */
    undef_415 (24075, ""),
    /**  */
    undef_416 (24095, ""),
    /** POHJANPALO */
    POHJANPALO (24100, "POHJANPALO"),
    /** Poliment-K */
    POLIMENT_K (24110, "Poliment-K"),
    /** POLLUX */
    POLLUX (24120, "POLLUX"),
    /**  */
    undef_417 (24165, ""),
    /**  */
    undef_418 (24210, ""),
    /**  */
    undef_419 (24255, ""),
    /**  */
    undef_420 (24300, ""),
    /**   */
    undef_421 (24320, " "),
    /**  */
    undef_422 (24345, ""),
    /** Positive ME */
    POSITIVE_ME (24385, "Positive ME"),
    /** Positive-ME1.2 */
    POSITIVE_ME12 (24386, "Positive-ME1.2"),
    /**  */
    undef_423 (24390, ""),
    /**  */
    undef_424 (24435, ""),
    /**  */
    undef_425 (24480, ""),
    /**  */
    undef_426 (24525, ""),
    /**  */
    undef_427 (24535, ""),
    /** Praetorian Countermeasures Suite */
    PRAETORIAN_COUNTERMEASURES_SUITE (24540, "Praetorian Countermeasures Suite"),
    /** PRIMUS 30A */
    PRIMUS_30A (24569, "PRIMUS 30A"),
    /** PRIMUS 40 WXD */
    PRIMUS_40_WXD (24570, "PRIMUS 40 WXD"),
    /** Primus 400 */
    PRIMUS_400 (24614, "Primus 400"),
    /** PRIMUS 300SL */
    PRIMUS_300SL (24615, "PRIMUS 300SL"),
    /** Primus 500 */
    PRIMUS_500 (24616, "Primus 500"),
    /** Primus 650 */
    PRIMUS_650 (24617, "Primus 650"),
    /** Primus 700 */
    PRIMUS_700 (24618, "Primus 700"),
    /**  */
    undef_428 (24620, ""),
    /** PRORA */
    PRORA (24630, "PRORA"),
    /** PRS-2 */
    PRS_2 (24631, "PRS-2"),
    /** PRORA PA-1660 */
    PRORA_PA_1660 (24635, "PRORA PA-1660"),
    /** PS-05A */
    PS_05A (24650, "PS-05A"),
    /** PS 46 A */
    PS_46_A (24660, "PS 46 A"),
    /** PS 70 R */
    PS_70_R (24705, "PS 70 R"),
    /** PS-860 */
    PS_860 (24707, "PS-860"),
    /** PS-870 */
    PS_870 (24709, "PS-870"),
    /** PS-890 */
    PS_890 (24710, "PS-890"),
    /**  */
    undef_429 (24750, ""),
    /** Quadradar VI */
    QUADRADAR_VI (24755, "Quadradar VI"),
    /** PVS-200 */
    PVS_200 (24760, "PVS-200"),
    /** PVS 2000 */
    PVS_2000 (24761, "PVS 2000"),
    /** R-76 */
    R_76 (24770, "R-76"),
    /** RA723 */
    RA723 (24774, "RA723"),
    /** R41XXX */
    R41XXX (24775, "R41XXX"),
    /**  */
    undef_430 (24780, ""),
    /**  */
    undef_431 (24795, ""),
    /** DECCA 1230 */
    DECCA_1230 (24800, "DECCA 1230"),
    /**  */
    undef_432 (24840, ""),
    /**  */
    undef_433 (24885, ""),
    /** Racal-DECCA 20V90/9 */
    RACAL_DECCA_20V90_9 (24890, "Racal-DECCA 20V90/9"),
    /**  */
    undef_434 (24930, ""),
    /**  */
    undef_435 (24975, ""),
    /**  */
    undef_436 (25020, ""),
    /**  */
    undef_437 (25065, ""),
    /**  */
    undef_438 (25110, ""),
    /**  */
    undef_439 (25155, ""),
    /**   */
    undef_440 (25170, " "),
    /**   */
    undef_441 (25171, " "),
    /** RAN 7S */
    RAN_7S (25200, "RAN 7S"),
    /** RAN 10S */
    RAN_10S (25205, "RAN 10S"),
    /** RAN 11 LX */
    RAN_11_LX (25245, "RAN 11 LX"),
    /** Rani */
    RANI (25250, "Rani"),
    /** Rapier TA */
    RAPIER_TA (25260, "Rapier TA"),
    /** Rapier 2000 TA */
    RAPIER_2000_TA (25265, "Rapier 2000 TA"),
    /** Rapier MG */
    RAPIER_MG (25270, "Rapier MG"),
    /** RASCAR 3400C */
    RASCAR_3400C (25273, "RASCAR 3400C"),
    /** Rashmi */
    RASHMI (25275, "Rashmi"),
    /** Rasit */
    RASIT (25276, "Rasit"),
    /** Rasit 3190B */
    RASIT_3190B (25277, "Rasit 3190B"),
    /** RAT-31 DL/M */
    RAT_31_DL_M (25278, "RAT-31 DL/M"),
    /** RAT-31S */
    RAT_31S (25280, "RAT-31S"),
    /** RATAC (LCT) */
    RATAC_LCT (25285, "RATAC (LCT)"),
    /** RAWL */
    RAWL (25286, "RAWL"),
    /**  */
    undef_442 (25287, ""),
    /** RAWS */
    RAWS (25288, "RAWS"),
    /** RAWL-02 */
    RAWL_02 (25289, "RAWL-02"),
    /**  */
    undef_443 (25290, ""),
    /** RAWS-03 */
    RAWS_03 (25291, "RAWS-03"),
    /**   */
    undef_444 (25292, " "),
    /**  */
    undef_445 (25300, ""),
    /**  */
    undef_446 (25335, ""),
    /**  */
    undef_447 (25380, ""),
    /**  */
    undef_448 (25425, ""),
    /**  */
    undef_449 (25470, ""),
    /**  */
    undef_450 (25515, ""),
    /**   */
    undef_451 (25540, " "),
    /**   */
    undef_452 (25550, " "),
    /**  */
    undef_453 (25560, ""),
    /**  */
    undef_454 (25605, ""),
    /** RAY-1220XR */
    RAY_1220XR (25630, "RAY-1220XR"),
    /**  */
    undef_455 (25635, ""),
    /**  */
    undef_456 (25650, ""),
    /**   */
    undef_457 (25694, " "),
    /**  */
    undef_458 (25695, ""),
    /** RBE2 */
    RBE2 (25735, "RBE2"),
    /** RCT-180 */
    RCT_180 (25739, "RCT-180"),
    /** RDM */
    RDM (25740, "RDM"),
    /** RDI */
    RDI (25750, "RDI"),
    /** RDY */
    RDY (25760, "RDY"),
    /** RDN 72 */
    RDN_72 (25785, "RDN 72"),
    /** RDR 1A */
    RDR_1A (25830, "RDR 1A"),
    /** RDR 1E */
    RDR_1E (25835, "RDR 1E"),
    /** RDR 4A */
    RDR_4A (25840, "RDR 4A"),
    /** RDR-160XD */
    RDR_160XD (25850, "RDR-160XD"),
    /** RDR 1100 */
    RDR_1100 (25855, "RDR 1100"),
    /** RDR 1200 */
    RDR_1200 (25875, "RDR 1200"),
    /** RDR 1400 */
    RDR_1400 (25885, "RDR 1400"),
    /** RDR 1400 C */
    RDR_1400_C (25890, "RDR 1400 C"),
    /** RDR 1500 */
    RDR_1500 (25895, "RDR 1500"),
    /**  */
    undef_459 (25896, ""),
    /** RDR 1600 */
    RDR_1600 (25897, "RDR 1600"),
    /** RDR 2000 */
    RDR_2000 (25898, "RDR 2000"),
    /** Remora */
    REMORA (25900, "Remora"),
    /** Rice Field */
    RICE_FIELD (25901, "Rice Field"),
    /**   */
    undef_460 (25907, " "),
    /** REL-6E */
    REL_6E (25908, "REL-6E"),
    /** REC-1 */
    REC_1 (25909, "REC-1"),
    /**  */
    undef_461 (25910, ""),
    /** Improved Reporter */
    IMPROVED_REPORTER (25911, "Improved Reporter"),
    /**   */
    undef_462 (25912, " "),
    /**   */
    undef_463 (25915, " "),
    /**  */
    undef_464 (25920, ""),
    /**  */
    undef_465 (25965, ""),
    /** RKL-526 */
    RKL_526 (25966, "RKL-526"),
    /** RKZ-764 */
    RKZ_764 (25967, "RKZ-764"),
    /** RKZ-766 */
    RKZ_766 (25968, "RKZ-766"),
    /** RKL-165 */
    RKL_165 (25969, "RKL-165"),
    /** RKL-609 */
    RKL_609 (25970, "RKL-609"),
    /** RKL-800 */
    RKL_800 (25971, "RKL-800"),
    /** RKZ-761 */
    RKZ_761 (25972, "RKZ-761"),
    /** RKZ-2000 */
    RKZ_2000 (25973, "RKZ-2000"),
    /**   */
    undef_466 (26008, " "),
    /**  */
    undef_467 (26010, ""),
    /**  */
    undef_468 (26011, ""),
    /** RM370BT */
    RM370BT (26015, "RM370BT"),
    /**  */
    undef_469 (26020, ""),
    /**   */
    undef_470 (26040, " "),
    /**   */
    undef_471 (26041, " "),
    /** ROLAND BN */
    ROLAND_BN (26055, "ROLAND BN"),
    /** ROLAND MG */
    ROLAND_MG (26100, "ROLAND MG"),
    /** ROLAND TA */
    ROLAND_TA (26145, "ROLAND TA"),
    /** ROLAND TT */
    ROLAND_TT (26190, "ROLAND TT"),
    /**  */
    undef_472 (26235, ""),
    /** RP-379D Tirada D */
    RP_379D_TIRADA_D (26236, "RP-379D Tirada D"),
    /**  */
    undef_473 (26280, ""),
    /**  */
    undef_474 (26325, ""),
    /** RPR-117 */
    RPR_117 (26326, "RPR-117"),
    /** RS-02/50 */
    RS_02_50 (26327, "RS-02/50"),
    /**   */
    undef_475 (26328, " "),
    /** RT-02/50 */
    RT_02_50 (26330, "RT-02/50"),
    /** RTN-1A */
    RTN_1A (26350, "RTN-1A"),
    /** RTN-25X */
    RTN_25X (26353, "RTN-25X"),
    /**   */
    undef_476 (26355, " "),
    /**  */
    undef_477 (26360, ""),
    /**   */
    undef_478 (26361, " "),
    /**   */
    undef_479 (26362, " "),
    /** RV2 */
    RV2 (26370, "RV2"),
    /** RV3 */
    RV3 (26415, "RV3"),
    /** RV5 */
    RV5 (26460, "RV5"),
    /** RV10 */
    RV10 (26505, "RV10"),
    /** RV-15M */
    RV_15M (26506, "RV-15M"),
    /** RV17 */
    RV17 (26550, "RV17"),
    /** RV18 */
    RV18 (26595, "RV18"),
    /** RV-21 */
    RV_21 (26596, "RV-21"),
    /** RV-21B */
    RV_21B (26597, "RV-21B"),
    /** RV-377 */
    RV_377 (26610, "RV-377"),
    /** RV UM */
    RV_UM (26640, "RV UM"),
    /**  */
    undef_480 (26660, ""),
    /**   */
    undef_481 (26665, " "),
    /** S-1810CD */
    S_1810CD (26670, "S-1810CD"),
    /** Sahab */
    SAHAB (26672, "Sahab"),
    /** Salamandre */
    SALAMANDRE (26673, "Salamandre"),
    /**   */
    undef_482 (26674, " "),
    /** S1850M */
    S1850M (26675, "S1850M"),
    /**  */
    undef_483 (26685, ""),
    /**  */
    undef_484 (26730, ""),
    /**  */
    undef_485 (26775, ""),
    /**  */
    undef_486 (26795, ""),
    /** Sampson */
    SAMPSON (26810, "Sampson"),
    /**  */
    undef_487 (26820, ""),
    /**  */
    undef_488 (26865, ""),
    /** Saccade MH */
    SACCADE_MH (26900, "Saccade MH"),
    /**  */
    undef_489 (26910, ""),
    /** SAP-14 */
    SAP_14 (26920, "SAP-14"),
    /** SAP-518 */
    SAP_518 (26925, "SAP-518"),
    /** SAP-518M */
    SAP_518M (26926, "SAP-518M"),
    /** Sand Bar */
    SAND_BAR (26930, "Sand Bar"),
    /** SA Pechora 2M TT */
    SA_PECHORA_2M_TT (26935, "SA Pechora 2M TT"),
    /** SAR (on UAVs) */
    SAR_ON_UAVS (26945, "SAR (on UAVs)"),
    /** SATURNE II */
    SATURNE_II (26955, "SATURNE II"),
    /**  */
    undef_490 (27000, ""),
    /**  */
    undef_491 (27045, ""),
    /**  */
    undef_492 (27090, ""),
    /**   */
    undef_493 (27100, " "),
    /**   */
    undef_494 (27101, " "),
    /**   */
    undef_495 (27102, " "),
    /**   */
    undef_496 (27110, " "),
    /**   */
    undef_497 (27115, " "),
    /**   */
    undef_498 (27116, " "),
    /**   */
    undef_499 (27125, " "),
    /**  */
    undef_500 (27135, ""),
    /** Scanter SMR */
    SCANTER_SMR (27139, "Scanter SMR"),
    /** SCANTER (CSR) */
    SCANTER_CSR (27140, "SCANTER (CSR)"),
    /** SCORADS */
    SCORADS (27141, "SCORADS"),
    /** STAR 2000 */
    STAR_2000 (27143, "STAR 2000"),
    /**  */
    undef_501 (27150, ""),
    /**  */
    undef_502 (27180, ""),
    /**   */
    undef_503 (27183, " "),
    /** SCR-584 */
    SCR_584 (27190, "SCR-584"),
    /** Sea Archer 2 */
    SEA_ARCHER_2 (27225, "Sea Archer 2"),
    /** Sea Based X-Band */
    SEA_BASED_X_BAND (27230, "Sea Based X-Band"),
    /** Sea Eagle (Type 381) */
    SEA_EAGLE_TYPE_381 (27239, "Sea Eagle (Type 381)"),
    /** Sea Eagle S/C (Type 382) */
    SEA_EAGLE_S_C_TYPE_382 (27240, "Sea Eagle S/C (Type 382)"),
    /**   */
    undef_504 (27248, " "),
    /**   */
    undef_505 (27251, " "),
    /** Sea Hunter 4 MG */
    SEA_HUNTER_4_MG (27270, "Sea Hunter 4 MG"),
    /** Sea Hunter 4 TA */
    SEA_HUNTER_4_TA (27315, "Sea Hunter 4 TA"),
    /** Sea Hunter 4 TT */
    SEA_HUNTER_4_TT (27360, "Sea Hunter 4 TT"),
    /**  */
    undef_506 (27405, ""),
    /**   */
    undef_507 (27430, " "),
    /**  */
    undef_508 (27450, ""),
    /** Sea Sparrow */
    SEA_SPARROW (27451, "Sea Sparrow"),
    /** Sea Spray */
    SEA_SPRAY (27495, "Sea Spray"),
    /** Sea Tiger */
    SEA_TIGER (27540, "Sea Tiger"),
    /** Sea Tiger M */
    SEA_TIGER_M (27550, "Sea Tiger M"),
    /** Seastar */
    SEASTAR (27560, "Seastar"),
    /** Searchwater */
    SEARCHWATER (27570, "Searchwater"),
    /** Searchwater 2000 */
    SEARCHWATER_2000 (27575, "Searchwater 2000"),
    /**   */
    undef_509 (27584, " "),
    /**  */
    undef_510 (27585, ""),
    /**  */
    undef_511 (27630, ""),
    /**  */
    undef_512 (27675, ""),
    /** Selenia RAN 20S */
    SELENIA_RAN_20S (27680, "Selenia RAN 20S"),
    /**  */
    undef_513 (27720, ""),
    /**  */
    undef_514 (27765, ""),
    /**   */
    undef_515 (27775, " "),
    /** SG */
    SG (27800, "SG"),
    /**   */
    undef_516 (27802, " "),
    /**   */
    undef_517 (27803, " "),
    /** SGR 102 00 */
    SGR_102_00 (27810, "SGR 102 00"),
    /** SGR 103/02 */
    SGR_103_02 (27855, "SGR 103/02"),
    /** SGR-104 */
    SGR_104 (27870, "SGR-104"),
    /**  */
    undef_518 (27900, ""),
    /**  */
    undef_519 (27945, ""),
    /**  */
    undef_520 (27990, ""),
    /**  */
    undef_521 (28035, ""),
    /** SGR 114 */
    SGR_114 (28080, "SGR 114"),
    /**  */
    undef_522 (28125, ""),
    /**  */
    undef_523 (28170, ""),
    /**  */
    undef_524 (28215, ""),
    /**  */
    undef_525 (28260, ""),
    /** PRV-11 */
    PRV_11 (28280, "PRV-11"),
    /**  */
    undef_526 (28305, ""),
    /**  */
    undef_527 (28350, ""),
    /**  */
    undef_528 (28395, ""),
    /**  */
    undef_529 (28440, ""),
    /**   */
    undef_530 (28445, " "),
    /**   */
    undef_531 (28480, " "),
    /**  */
    undef_532 (28485, ""),
    /**  */
    undef_533 (28530, ""),
    /**  */
    undef_534 (28575, ""),
    /**  */
    undef_535 (28620, ""),
    /**  */
    undef_536 (28665, ""),
    /**  */
    undef_537 (28710, ""),
    /**  */
    undef_538 (28755, ""),
    /**   */
    undef_539 (28760, " "),
    /**   */
    undef_540 (28770, " "),
    /**  */
    undef_541 (28800, ""),
    /**  */
    undef_542 (28845, ""),
    /**  */
    undef_543 (28890, ""),
    /**  */
    undef_544 (28935, ""),
    /**  */
    undef_545 (28980, ""),
    /**  */
    undef_546 (29025, ""),
    /**   */
    undef_547 (29030, " "),
    /**   */
    undef_548 (29035, " "),
    /**   */
    undef_549 (29050, " "),
    /**  */
    undef_550 (29070, ""),
    /**  */
    undef_551 (29115, ""),
    /**  */
    undef_552 (29160, ""),
    /** Sky Wave (Over The Horizon) */
    SKY_WAVE_OVER_THE_HORIZON (29175, "Sky Wave (Over The Horizon)"),
    /** Skyguard B */
    SKYGUARD_B (29180, "Skyguard B"),
    /** SKYGUARD TA */
    SKYGUARD_TA (29185, "SKYGUARD TA"),
    /** SKYGUARD TT */
    SKYGUARD_TT (29190, "SKYGUARD TT"),
    /** Skyguard LR */
    SKYGUARD_LR (29191, "Skyguard LR"),
    /** Skymaster */
    SKYMASTER (29200, "Skymaster"),
    /**  */
    undef_553 (29205, ""),
    /** Sky Ranger */
    SKY_RANGER (29210, "Sky Ranger"),
    /**  */
    undef_554 (29215, ""),
    /** SKYSHIELD TA */
    SKYSHIELD_TA (29220, "SKYSHIELD TA"),
    /** SL */
    SL (29250, "SL"),
    /** SL/ALQ-234 */
    SL_ALQ_234 (29270, "SL/ALQ-234"),
    /**  */
    undef_555 (29295, ""),
    /**   */
    undef_556 (29297, " "),
    /**  */
    undef_557 (29340, ""),
    /**  */
    undef_558 (29385, ""),
    /**  */
    undef_559 (29400, ""),
    /**  */
    undef_560 (29430, ""),
    /**  */
    undef_561 (29431, ""),
    /**  */
    undef_562 (29432, ""),
    /**   */
    undef_563 (29433, " "),
    /**   */
    undef_564 (29434, " "),
    /**  */
    undef_565 (29435, ""),
    /**  */
    undef_566 (29440, ""),
    /** SM-674A/UPM */
    SM_674A_UPM (29450, "SM-674A/UPM"),
    /**  */
    undef_567 (29475, ""),
    /**  */
    undef_568 (29520, ""),
    /**  */
    undef_569 (29565, ""),
    /**  */
    undef_570 (29610, ""),
    /**  */
    undef_571 (29655, ""),
    /**  */
    undef_572 (29700, ""),
    /**  */
    undef_573 (29745, ""),
    /**  */
    undef_574 (29790, ""),
    /**  */
    undef_575 (29835, ""),
    /**  */
    undef_576 (29880, ""),
    /**  */
    undef_577 (29925, ""),
    /**  */
    undef_578 (29970, ""),
    /**  */
    undef_579 (30015, ""),
    /** SR-47A */
    SR_47A (30016, "SR-47A"),
    /**  */
    undef_580 (30060, ""),
    /**   */
    undef_581 (30065, " "),
    /** SMART-S */
    SMART_S (30068, "SMART-S"),
    /** SMART-S Mk2 */
    SMART_S_MK2 (30069, "SMART-S Mk2"),
    /** SMART-L */
    SMART_L (30070, "SMART-L"),
    /** SM-932 */
    SM_932 (30072, "SM-932"),
    /**  */
    undef_582 (30075, ""),
    /**  */
    undef_583 (30080, ""),
    /**  */
    undef_584 (30105, ""),
    /**  */
    undef_585 (30140, ""),
    /**  */
    undef_586 (30150, ""),
    /**  */
    undef_587 (30195, ""),
    /**   */
    undef_588 (30200, " "),
    /**  */
    undef_589 (30240, ""),
    /**  */
    undef_590 (30255, ""),
    /**  */
    undef_591 (30285, ""),
    /**  */
    undef_592 (30330, ""),
    /**  */
    undef_593 (30375, ""),
    /**  */
    undef_594 (30420, ""),
    /**   */
    undef_595 (30421, " "),
    /**  */
    undef_596 (30465, ""),
    /** 9S18M1 */
    $9S18M1 (30470, "9S18M1"),
    /** SPB-7 */
    SPB_7 (30475, "SPB-7"),
    /**   */
    undef_597 (30480, " "),
    /** SO-1 */
    SO_1 (30510, "SO-1"),
    /** SO-12 */
    SO_12 (30520, "SO-12"),
    /** SO A Communist */
    SO_A_COMMUNIST (30555, "SO A Communist"),
    /** SO-69 */
    SO_69 (30580, "SO-69"),
    /**  */
    undef_598 (30600, ""),
    /** SOM 64 */
    SOM_64 (30645, "SOM 64"),
    /**  */
    undef_599 (30660, ""),
    /**  */
    undef_600 (30670, ""),
    /** Sparrow (AIM/RIM-7) ILL */
    SPARROW_AIM_RIM_7_ILL (30690, "Sparrow (AIM/RIM-7) ILL"),
    /** SPERRY RASCAR */
    SPERRY_RASCAR (30691, "SPERRY RASCAR"),
    /**  */
    undef_601 (30700, ""),
    /**   */
    undef_602 (30701, " "),
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
    /**  */
    undef_603 (30960, ""),
    /**  */
    undef_604 (31005, ""),
    /**  */
    undef_605 (31050, ""),
    /**  */
    undef_606 (31095, ""),
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
    /**  */
    undef_607 (31635, ""),
    /** P-12 */
    P_12 (31680, "P-12"),
    /** P-18 */
    P_18 (31681, "P-18"),
    /** P-18 */
    P_18_2 (31682, "P-18"),
    /** P-18 */
    P_18_3 (31684, "P-18"),
    /**   */
    undef_608 (31700, " "),
    /** SPQ 712 (RAN 12 L/X) */
    SPQ_712_RAN_12_L_X (31725, "SPQ 712 (RAN 12 L/X)"),
    /** SPS 6C */
    SPS_6C (31770, "SPS 6C"),
    /** SPS 10F */
    SPS_10F (31815, "SPS 10F"),
    /** SPS 12 */
    SPS_12 (31860, "SPS 12"),
    /** SPS 58 */
    SPS_58 (31905, "SPS 58"),
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
    /**  */
    undef_609 (32130, ""),
    /**  */
    undef_610 (32175, ""),
    /**  */
    undef_611 (32220, ""),
    /**  */
    undef_612 (32265, ""),
    /** Shmel, Add SHMEL National Nomenclature for clarity */
    SHMEL (32310, "Shmel"),
    /** P-15M */
    P_15M (32330, "P-15M"),
    /**  */
    undef_613 (32355, ""),
    /** SR47B-G */
    SR47B_G (32375, "SR47B-G"),
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
    /**  */
    undef_614 (32625, ""),
    /**  */
    undef_615 (32670, ""),
    /**  */
    undef_616 (32715, ""),
    /**  */
    undef_617 (32760, ""),
    /**  */
    undef_618 (32805, ""),
    /**  */
    undef_619 (32850, ""),
    /**   */
    undef_620 (32851, " "),
    /**   */
    undef_621 (32852, " "),
    /**  */
    undef_622 (32895, ""),
    /**  */
    undef_623 (32940, ""),
    /**  */
    undef_624 (32985, ""),
    /**   */
    undef_625 (33025, " "),
    /**  */
    undef_626 (33030, ""),
    /**  */
    undef_627 (33075, ""),
    /**  */
    undef_628 (33120, ""),
    /** SS-N-10A FL-10 mmW MH */
    SS_N_10A_FL_10_MMW_MH (33125, "SS-N-10A FL-10 mmW MH"),
    /** SS-N-11 Nasr-1 mmW MH */
    SS_N_11_NASR_1_MMW_MH (33140, "SS-N-11 Nasr-1 mmW MH"),
    /**  */
    undef_629 (33165, ""),
    /** SS-N-12 YJ-83J mmW MH */
    SS_N_12_YJ_83J_MMW_MH (33166, "SS-N-12 YJ-83J mmW MH"),
    /**  */
    undef_630 (33210, ""),
    /**   */
    undef_631 (33230, " "),
    /**   */
    undef_632 (33231, " "),
    /**  */
    undef_633 (33255, ""),
    /**  */
    undef_634 (33300, ""),
    /**  */
    undef_635 (33345, ""),
    /**  */
    undef_636 (33390, ""),
    /**  */
    undef_637 (33435, ""),
    /**  */
    undef_638 (33480, ""),
    /**   */
    undef_639 (33481, " "),
    /**   */
    undef_640 (33483, " "),
    /** SS-N-26 Strobile MMW MH */
    SS_N_26_STROBILE_MMW_MH (33484, "SS-N-26 Strobile MMW MH"),
    /**  */
    undef_641 (33485, ""),
    /**   */
    undef_642 (33486, " "),
    /**   */
    undef_643 (33505, " "),
    /**   */
    undef_644 (33510, " "),
    /**   */
    undef_645 (33511, " "),
    /**  */
    undef_646 (33525, ""),
    /** STR 41 */
    STR_41 (33570, "STR 41"),
    /**  */
    undef_647 (33590, ""),
    /**  */
    undef_648 (33595, ""),
    /**  */
    undef_649 (33600, ""),
    /**  */
    undef_650 (33615, ""),
    /**  */
    undef_651 (33660, ""),
    /**  */
    undef_652 (33705, ""),
    /**  */
    undef_653 (33750, ""),
    /**  */
    undef_654 (33795, ""),
    /**  */
    undef_655 (33840, ""),
    /** Superfledermaus */
    SUPERFLEDERMAUS (33860, "Superfledermaus"),
    /** Supersearcher */
    SUPERSEARCHER (33870, "Supersearcher"),
    /**  */
    undef_656 (33885, ""),
    /**  */
    undef_657 (33930, ""),
    /** SYNAPSIS Mk2 */
    SYNAPSIS_MK2 (33935, "SYNAPSIS Mk2"),
    /**  */
    undef_658 (33975, ""),
    /**  */
    undef_659 (34020, ""),
    /**  */
    undef_660 (34040, ""),
    /**  */
    undef_661 (34065, ""),
    /**  */
    undef_662 (34110, ""),
    /**  */
    undef_663 (34155, ""),
    /**  */
    undef_664 (34200, ""),
    /**  */
    undef_665 (34245, ""),
    /**  */
    undef_666 (34290, ""),
    /**  */
    undef_667 (34335, ""),
    /**  */
    undef_668 (34380, ""),
    /**  */
    undef_669 (34425, ""),
    /**  */
    undef_670 (34470, ""),
    /** JY-11B */
    JY_11B (34500, "JY-11B"),
    /** TACAN/SURF */
    TACAN_SURF (34505, "TACAN/SURF"),
    /** P-14 */
    P_14 (34515, "P-14"),
    /**  */
    undef_671 (34560, ""),
    /**  */
    undef_672 (34605, ""),
    /**   */
    undef_673 (34610, " "),
    /**   */
    undef_674 (34620, " "),
    /**  */
    undef_675 (34625, ""),
    /** T1135 */
    T1135 (34626, "T1135"),
    /** TANCAN/SURF */
    TANCAN_SURF (34627, "TANCAN/SURF"),
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
    /** THD 1940 */
    THD_1940 (34670, "THD 1940"),
    /** THD-1955 Palmier */
    THD_1955_PALMIER (34680, "THD-1955 Palmier"),
    /** THD 5500 */
    THD_5500 (34695, "THD 5500"),
    /**  */
    undef_676 (34740, ""),
    /** PRV-9 */
    PRV_9 (34785, "PRV-9"),
    /** PRV-16 */
    PRV_16 (34786, "PRV-16"),
    /**  */
    undef_677 (34795, ""),
    /**  */
    undef_678 (34830, ""),
    /**  */
    undef_679 (34875, ""),
    /**  */
    undef_680 (34920, ""),
    /**  */
    undef_681 (34965, ""),
    /**  */
    undef_682 (35010, ""),
    /**  */
    undef_683 (35055, ""),
    /**  */
    undef_684 (35100, ""),
    /**  */
    undef_685 (35145, ""),
    /**  */
    undef_686 (35190, ""),
    /**  */
    undef_687 (35235, ""),
    /**  */
    undef_688 (35280, ""),
    /**  */
    undef_689 (35325, ""),
    /**  */
    undef_690 (35370, ""),
    /**  */
    undef_691 (35415, ""),
    /**  */
    undef_692 (35460, ""),
    /** Thomson ENR (European Navy Radar) */
    THOMSON_ENR_EUROPEAN_NAVY_RADAR (35470, "Thomson ENR (European Navy Radar)"),
    /** Thomson RDI */
    THOMSON_RDI (35475, "Thomson RDI"),
    /** Tier II Plus */
    TIER_II_PLUS (35477, "Tier II Plus"),
    /** TRS-2105 */
    TRS_2105 (35480, "TRS-2105"),
    /** HT-223 */
    HT_223 (35485, "HT-223"),
    /** TRS-2100 */
    TRS_2100 (35490, "TRS-2100"),
    /**  */
    undef_693 (35505, ""),
    /** 36D6 */
    $36D6 (35550, "36D6"),
    /**  */
    undef_694 (35570, ""),
    /** TIRSPONDER */
    TIRSPONDER (35580, "TIRSPONDER"),
    /** TMK Mk2 */
    TMK_MK2 (35585, "TMK Mk2"),
    /** TMX Mk2 */
    TMX_MK2 (35586, "TMX Mk2"),
    /**  */
    undef_695 (35595, ""),
    /**  */
    undef_696 (35640, ""),
    /**  */
    undef_697 (35685, ""),
    /**  */
    undef_698 (35730, ""),
    /**  */
    undef_699 (35775, ""),
    /** Token B */
    TOKEN_B (35785, "Token B"),
    /**  */
    undef_700 (35800, ""),
    /** Tonson */
    TONSON (35810, "Tonson"),
    /**  */
    undef_701 (35820, ""),
    /**  */
    undef_702 (35865, ""),
    /**  */
    undef_703 (35910, ""),
    /**  */
    undef_704 (35955, ""),
    /**  */
    undef_705 (36000, ""),
    /**  */
    undef_706 (36045, ""),
    /**  */
    undef_707 (36046, ""),
    /**  */
    undef_708 (36090, ""),
    /** TYPE-208 */
    TYPE_208 (36120, "TYPE-208"),
    /**  */
    undef_709 (36135, ""),
    /**  */
    undef_710 (36180, ""),
    /** Tornado GMR */
    TORNADO_GMR (36200, "Tornado GMR"),
    /** Tornado TFR */
    TORNADO_TFR (36201, "Tornado TFR"),
    /**  */
    undef_711 (36220, ""),
    /**  */
    undef_712 (36225, ""),
    /**  */
    undef_713 (36230, ""),
    /**  */
    undef_714 (36270, ""),
    /** TORSO M */
    TORSO_M (36315, "TORSO M"),
    /** TQN-2 */
    TQN_2 (36320, "TQN-2"),
    /**  */
    undef_715 (36360, ""),
    /** TRD-1500 */
    TRD_1500 (36365, "TRD-1500"),
    /**   */
    undef_716 (36370, " "),
    /**   */
    undef_717 (36371, " "),
    /** TRISPONDE */
    TRISPONDE (36380, "TRISPONDE"),
    /** TRS 3010 */
    TRS_3010 (36386, "TRS 3010"),
    /** Triton G */
    TRITON_G (36390, "Triton G"),
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
    /**  */
    undef_718 (36563, ""),
    /**  */
    undef_719 (36585, ""),
    /**  */
    undef_720 (36630, ""),
    /**  */
    undef_721 (36675, ""),
    /**  */
    undef_722 (36720, ""),
    /**  */
    undef_723 (36765, ""),
    /**  */
    undef_724 (36810, ""),
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
    /** TYPE 293 */
    TYPE_293 (36945, "TYPE 293"),
    /** Type 341 */
    TYPE_341 (36946, "Type 341"),
    /** Type 334 */
    TYPE_334 (36960, "Type 334"),
    /** TYPE 343 SUN VISOR B */
    TYPE_343_SUN_VISOR_B (36990, "TYPE 343 SUN VISOR B"),
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
    /** Type 408D */
    TYPE_408D (37058, "Type 408D"),
    /** Type 518 (Hai Ying, God Eye, REL-2) */
    TYPE_518_HAI_YING_GOD_EYE_REL_2 (37060, "Type 518 (Hai Ying, God Eye, REL-2)"),
    /** Type 589 */
    TYPE_589 (37070, "Type 589"),
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
    /** Type 815 */
    TYPE_815 (37090, "Type 815"),
    /** Type 793 */
    TYPE_793 (37095, "Type 793"),
    /** Type 8A-813 */
    TYPE_8A_813 (37100, "Type 8A-813"),
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
    /** URN 25 */
    URN_25 (38025, "URN 25"),
    /** VOLEX III/IV */
    VOLEX_III_IV (38045, "VOLEX III/IV"),
    /** VSR */
    VSR (38050, "VSR"),
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
    /**   */
    undef_725 (38140, " "),
    /**  */
    undef_726 (38150, ""),
    /** WAS-74S */
    WAS_74S (38160, "WAS-74S"),
    /**  */
    undef_727 (38205, ""),
    /** WATCHDOG */
    WATCHDOG (38210, "WATCHDOG"),
    /**  */
    undef_728 (38250, ""),
    /** Watchman */
    WATCHMAN (38260, "Watchman"),
    /**  */
    undef_729 (38295, ""),
    /**  */
    undef_730 (38320, ""),
    /**  */
    undef_731 (38340, ""),
    /**  */
    undef_732 (38385, ""),
    /**  */
    undef_733 (38430, ""),
    /**  */
    undef_734 (38475, ""),
    /** Wet Eye */
    WET_EYE (38520, "Wet Eye"),
    /** Wet Eye 2 */
    WET_EYE_2 (38525, "Wet Eye 2"),
    /** Wet Eye Mod */
    WET_EYE_MOD (38565, "Wet Eye Mod"),
    /** WGU-41/B */
    WGU_41_B (38570, "WGU-41/B"),
    /** WGU-44/B */
    WGU_44_B (38572, "WGU-44/B"),
    /**  */
    undef_735 (38610, ""),
    /**  */
    undef_736 (38655, ""),
    /**  */
    undef_737 (38700, ""),
    /**  */
    undef_738 (38715, ""),
    /**   */
    undef_739 (38730, " "),
    /** Wild Card */
    WILD_CARD (38745, "Wild Card"),
    /**  */
    undef_740 (38790, ""),
    /**  */
    undef_741 (38835, ""),
    /** WM2X Series */
    WM2X_SERIES (38880, "WM2X Series"),
    /** WM2X Series CAS */
    WM2X_SERIES_CAS (38925, "WM2X Series CAS"),
    /** WSR-74C */
    WSR_74C (38950, "WSR-74C"),
    /** WSR-74S */
    WSR_74S (38955, "WSR-74S"),
    /** WXR-700C */
    WXR_700C (38960, "WXR-700C"),
    /**  */
    undef_742 (38970, ""),
    /**  */
    undef_743 (39015, ""),
    /**  */
    undef_744 (39060, ""),
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
    /** YLC-4 */
    YLC_4 (39073, "YLC-4"),
    /** YLC-6 */
    YLC_6 (39074, "YLC-6"),
    /** YLC-6M */
    YLC_6M (39075, "YLC-6M"),
    /** YLC-8 */
    YLC_8 (39080, "YLC-8"),
    /** YLC-18 */
    YLC_18 (39085, "YLC-18"),
    /**  */
    undef_745 (39105, ""),
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
    /** ZHUK-MME */
    ZHUK_MME (45305, "ZHUK-MME");

    private int value;
    private final String description;

    EmitterName(int value, String description)
    {
        this.value = value;
        this.description = description;
    }

    public int getValue()
    {
        return value;
    }

    public String getDescription()
    {
        return description;
    }
    
    public static int getEnumBitWidth()
    {
      return 16;
    }

    public static EmitterName getEnumForValue(int i)
    {
       for(EmitterName val: EmitterName.values()) {
          if(val.getValue()==i)
              return val;
       }
       System.err.println("No enumeration found for value " + i + " of enumeration EmitterName");
       return null;
    }


    public void marshal(DataOutputStream dos) throws IOException
    {
        dos.writeShort(getValue());
    }

    public void marshal(ByteBuffer buff) throws Exception
    {
        buff.putShort((short)getValue());
    }

    public static EmitterName unmarshalEnum (DataInputStream dis) throws Exception
    {
        return getEnumForValue((int)dis.readUnsignedShort());
    } 

    public static EmitterName unmarshalEnum (ByteBuffer buff) throws Exception
    {
        return getEnumForValue((int)buff.getShort());
    }   

    public int getMarshalledSize()
    {
        return 2; // 16 bits
    }
}
