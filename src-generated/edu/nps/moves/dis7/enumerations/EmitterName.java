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
public enum EmitterName 
{
    /** 1245/6X */
    _1245_6X (2, "1245/6X"),
    /** 1L117 */
    _1L117 (3, "1L117"),
    /** 1L121E */
    _1L121E (4, "1L121E"),
    /** 1L250 */
    _1L250 (5, "1L250"),
    /** 1L220-U */
    _1L220_U (6, "1L220-U"),
    /** 1L122-1E */
    _1L122_1E (7, "1L122-1E"),
    /** 1RL138 */
    _1RL138 (10, "1RL138"),
    /** 5N20 */
    _5N20 (12, "5N20"),
    /** 5P-10 */
    _5P_10 (14, "5P-10"),
    /** 5P-10E */
    _5P_10E (15, "5P-10E"),
    /** 5P-10-01 */
    _5P_10_01 (16, "5P-10-01"),
    /** 5P-10-01E */
    _5P_10_01E (17, "5P-10-01E"),
    /** 5P-10-02 */
    _5P_10_02 (18, "5P-10-02"),
    /** 5P-10-02E */
    _5P_10_02E (19, "5P-10-02E"),
    /** 5P-10-03 */
    _5P_10_03 (20, "5P-10-03"),
    /** 5P-10-03E */
    _5P_10_03E (21, "5P-10-03E"),
    /** 5P-10E MOD */
    _5P_10E_MOD (22, "5P-10E MOD"),
    /** 621A-3 */
    _621A_3 (25, "621A-3"),
    /** COMMID_860F-1  AL-101 */
    COMMID_860F_1_AL_101 (40, "COMMID_860F-1  AL-101"),
    /** 1226 DECCA MIL */
    _1226_DECCA_MIL (45, "1226 DECCA MIL"),
    /** 9B-1348 */
    TIME_SPACE_POSITION_INFORMATION (46, "9B-1348"),
    /** 3KM6 */
    _3KM6 (47, "3KM6"),
    /** 9KR400 */
    _9KR400 (48, "9KR400"),
    /** 55G6-1 */
    LIVE_ENTITY_DETONATION (50, "55G6-1"),
    /** 59N6 */
    ACKNOWLEDGE_RELIABLE (55, "59N6"),
    /** 67N6 */
    DATA_RELIABLE (60, "67N6"),
    /** 76T6 */
    RECORD_RELIABLE (63, "76T6"),
    /** 80K6 */
    RECORD_QUERY_RELIABLE (65, "80K6"),
    /** 96L6E */
    _96L6E (70, "96L6E"),
    /** 9GR400 */
    _9GR400 (80, "9GR400"),
    /** 9 GR 400A */
    _9_GR_400A (81, "9 GR 400A"),
    /** 9GR600 */
    _9GR600 (90, "9GR600"),
    /** 9GR606 */
    _9GR606 (91, "9GR606"),
    /** 9 LV 100 */
    _9_LV_100 (125, "9 LV 100"),
    /** 9LV 200 TA */
    _9LV_200_TA (135, "9LV 200 TA"),
    /** 9LV 200 TV */
    _9LV_200_TV (180, "9LV 200 TV"),
    /** 9LV 200 TT */
    _9LV_200_TT (181, "9LV 200 TT"),
    /** 9LV200 MK III */
    _9LV200_MK_III (183, "9LV200 MK III"),
    /** 9LV326 */
    _9LV326 (185, "9LV326"),
    /** 9M96E2 Seeker */
    _9M96E2_SEEKER (190, "9M96E2 Seeker"),
    /** NATOID_A310Z */
    NATOID_A310Z (225, "NATOID_A310Z"),
    /** NATOID_A325A */
    NATOID_A325A (270, "NATOID_A325A"),
    /** NATOID_A346Z */
    NATOID_A346Z (315, "NATOID_A346Z"),
    /** NATOID_A353B */
    NATOID_A353B (360, "NATOID_A353B"),
    /** NATOID_A372A */
    NATOID_A372A (405, "NATOID_A372A"),
    /** NATOID_A372B */
    NATOID_A372B (450, "NATOID_A372B"),
    /** NATOID_A372C */
    NATOID_A372C (495, "NATOID_A372C"),
    /** NATOID_A377A */
    NATOID_A377A (540, "NATOID_A377A"),
    /** NATOID_A377B */
    NATOID_A377B (585, "NATOID_A377B"),
    /** NATOID_A380Z */
    NATOID_A380Z (630, "NATOID_A380Z"),
    /** NATOID_A381Z */
    NATOID_A381Z (675, "NATOID_A381Z"),
    /** NATOID_A398Z */
    NATOID_A398Z (720, "NATOID_A398Z"),
    /** NATOID_A403Z */
    NATOID_A403Z (765, "NATOID_A403Z"),
    /** NATOID_A409A */
    NATOID_A409A (810, "NATOID_A409A"),
    /** NATOID_A418A */
    NATOID_A418A (855, "NATOID_A418A"),
    /** NATOID_A419Z */
    NATOID_A419Z (900, "NATOID_A419Z"),
    /** NATOID_A429Z */
    NATOID_A429Z (945, "NATOID_A429Z"),
    /** NATOID_A432Z */
    NATOID_A432Z (990, "NATOID_A432Z"),
    /** NATOID_A434Z */
    NATOID_A434Z (1035, "NATOID_A434Z"),
    /** NATOID_A401A */
    NATOID_A401A (1080, "NATOID_A401A"),
    /** AA-13 Arrow Seeker */
    AA_13_ARROW_SEEKER (1085, "AA-13 Arrow Seeker"),
    /** AAM-4B MH */
    AAM_4B_MH (1090, "AAM-4B MH"),
    /** AA-300 */
    AA_300 (1094, "AA-300"),
    /** AA-12 Seeker */
    AA_12_SEEKER (1095, "AA-12 Seeker"),
    /** COMMID_AD4A */
    COMMID_AD4A (1096, "COMMID_AD4A"),
    /** ADES */
    ADES (1097, "ADES"),
    /** ADS-4 LRSR */
    ADS_4_LRSR (1098, "ADS-4 LRSR"),
    /** ACR-430 */
    ACR_430 (1099, "ACR-430"),
    /** Agave */
    AGAVE (1100, "Agave"),
    /** ACSOPRI-E */
    ACSOPRI_E (1101, "ACSOPRI-E"),
    /** ABD 2000 */
    ABD_2000 (1102, "ABD 2000"),
    /** ADAC MK 1 */
    ADAC_MK_1 (1110, "ADAC MK 1"),
    /** ADAC MK 2 */
    ADAC_MK_2 (1111, "ADAC MK 2"),
    /** ADAR */
    ADAR (1113, "ADAR"),
    /** ADOUR */
    ADOUR (1115, "ADOUR"),
    /** AGRION 15 */
    AGRION_15 (1125, "AGRION 15"),
    /** COMMID_AHV-7 */
    COMMID_AHV_7 (1130, "COMMID_AHV-7"),
    /** AHV-17 */
    AHV_17 (1150, "AHV-17"),
    /** AI MK 23 */
    AI_MK_23 (1170, "AI MK 23"),
    /** AIDA II */
    AIDA_II (1215, "AIDA II"),
    /** AIM-120A */
    AIM_120A (1216, "AIM-120A"),
    /** 1L271 */
    _1L271 (1230, "1L271"),
    /** ALA-51 */
    ALA_51 (1240, "ALA-51"),
    /** Albatros MK2 */
    ALBATROS_MK2 (1260, "Albatros MK2"),
    /** ALT-50 */
    ALT_50 (1263, "ALT-50"),
    /** ALTAIR */
    ALTAIR (1264, "ALTAIR"),
    /** AM/APS-717 */
    AM_APS_717 (1265, "AM/APS-717"),
    /** AMES 13 MK 1 */
    AMES_13_MK_1 (1268, "AMES 13 MK 1"),
    /** WGU-16/B */
    WGU_16_B (1270, "WGU-16/B"),
    /** 1L13-3 (55G6) */
    _1L13_3_55G6 (1280, "1L13-3 (55G6)"),
    /** 1L13-3 (55G6) */
    _1L13_3_55G6_2 (1282, "1L13-3 (55G6)"),
    /** AMDR 3D */
    AMDR_3D (1288, "AMDR 3D"),
    /** ANA SPS 502 */
    ANA_SPS_502 (1305, "ANA SPS 502"),
    /** COMMID_Anemone */
    COMMID_ANEMONE (1306, "COMMID_Anemone"),
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
    /** AN/ALQ-131 Blk II */
    AN_ALQ_131_BLK_II (1627, "AN/ALQ-131 Blk II"),
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
    /** AN/ALQ-173 */
    AN_ALQ_173 (1657, "AN/ALQ-173"),
    /** AN/ALT-28 */
    AN_ALT_28 (1658, "AN/ALT-28"),
    /** AN/ALT-32A */
    AN_ALT_32A (1660, "AN/ALT-32A"),
    /** AN/ALQ-196 */
    AN_ALQ_196 (1661, "AN/ALQ-196"),
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
    /** AN/APG-71 */
    AN_APG_71 (1940, "AN/APG-71"),
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
    /** AN/APN-102 */
    AN_APN_102 (2220, "AN/APN-102"),
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
    /** AN/APN-179 */
    AN_APN_179 (2747, "AN/APN-179"),
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
    /** AN/APQ-170 */
    AN_APQ_170 (3790, "AN/APQ-170"),
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
    /** AN/APS-94 */
    AN_APS_94 (3920, "AN/APS-94"),
    /** AN/APS-96 */
    AN_APS_96 (3922, "AN/APS-96"),
    /** AN/APS-113 */
    AN_APS_113 (3958, "AN/APS-113"),
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
    /** AN/APS-127 */
    AN_APS_127 (4190, "AN/APS-127"),
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
    /** AN/APS-137(V)5 */
    AN_APS_137V5 (4413, "AN/APS-137(V)5"),
    /** AN/APS-137B */
    AN_APS_137B (4415, "AN/APS-137B"),
    /** AN/APS-137B(V)5 */
    AN_APS_137BV5 (4420, "AN/APS-137B(V)5"),
    /** AN/APS-138 */
    AN_APS_138 (4455, "AN/APS-138"),
    /** AN/APS-139 */
    AN_APS_139 (4460, "AN/APS-139"),
    /** AN/APS-143 */
    AN_APS_143 (4464, "AN/APS-143"),
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
    /** AN/APS-154 */
    AN_APS_154 (4476, "AN/APS-154"),
    /** AN/APS-150 */
    AN_APS_150 (4480, "AN/APS-150"),
    /** AN/APS-145 */
    AN_APS_145 (4482, "AN/APS-145"),
    /** AN/APS-147 */
    AN_APS_147 (4485, "AN/APS-147"),
    /** AN/APS-149 */
    AN_APS_149 (4486, "AN/APS-149"),
    /** AN/APS-503 */
    AN_APS_503 (4489, "AN/APS-503"),
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
    /** AN/AST-502 */
    AN_AST_502 (5290, "AN/AST-502"),
    /** AN/AVQ-55 */
    AN_AVQ_55 (5300, "AN/AVQ-55"),
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
    /** AN/BPS-15J */
    AN_BPS_15J (5402, "AN/BPS-15J"),
    /** AN/BPS-16 */
    AN_BPS_16 (5405, "AN/BPS-16"),
    /** AN/BPS-16(V)2 */
    AN_BPS_16V2 (5406, "AN/BPS-16(V)2"),
    /** AN/CPN-4 */
    AN_CPN_4 (5410, "AN/CPN-4"),
    /** AN/CPN-18 */
    AN_CPN_18 (5415, "AN/CPN-18"),
    /** AN/CRM-30 */
    AN_CRM_30 (5420, "AN/CRM-30"),
    /** AN/DPW-23 */
    AN_DPW_23 (5430, "AN/DPW-23"),
    /** AN/DSQ 26 Phoenix MH */
    AN_DSQ_26_PHOENIX_MH (5445, "AN/DSQ 26 Phoenix MH"),
    /** AN/DSQ 28 Harpoon MH */
    AN_DSQ_28_HARPOON_MH (5490, "AN/DSQ 28 Harpoon MH"),
    /** AN/FPN-1 */
    AN_FPN_1 (5491, "AN/FPN-1"),
    /** AN/FPN-28 */
    AN_FPN_28 (5493, "AN/FPN-28"),
    /** AN/FPN-33 */
    AN_FPN_33 (5494, "AN/FPN-33"),
    /** AN/FPN-40 */
    AN_FPN_40 (5495, "AN/FPN-40"),
    /** AN/FPN-62 */
    AN_FPN_62 (5500, "AN/FPN-62"),
    /** AN/FPN-66 */
    AN_FPN_66 (5502, "AN/FPN-66"),
    /** AN/FPS-8 */
    AN_FPS_8 (5503, "AN/FPS-8"),
    /** AN/FPN-67 */
    AN_FPN_67 (5504, "AN/FPN-67"),
    /** AN/FPS-16 */
    AN_FPS_16 (5505, "AN/FPS-16"),
    /** AN/FPS-5 */
    AN_FPS_5 (5506, "AN/FPS-5"),
    /** AN/FPS-18 */
    AN_FPS_18 (5507, "AN/FPS-18"),
    /** AN/FPS-89 */
    AN_FPS_89 (5508, "AN/FPS-89"),
    /** AN/FPS-49 */
    AN_FPS_49 (5509, "AN/FPS-49"),
    /** AN/FPS-117 */
    AN_FPS_117 (5510, "AN/FPS-117"),
    /** AN/FPS-85 */
    AN_FPS_85 (5511, "AN/FPS-85"),
    /** AN/FPS-88 */
    AN_FPS_88 (5512, "AN/FPS-88"),
    /** AN/FPS-113 */
    AN_FPS_113 (5513, "AN/FPS-113"),
    /** AN/FPS-115 */
    AN_FPS_115 (5514, "AN/FPS-115"),
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
    /** AN/FPS-124(V) */
    AN_FPS_124V (5528, "AN/FPS-124(V)"),
    /** AN/FPS-129 */
    AN_FPS_129 (5529, "AN/FPS-129"),
    /** AN/GPX-6 */
    AN_GPX_6 (5530, "AN/GPX-6"),
    /** AN/GPX 8 */
    AN_GPX_8 (5535, "AN/GPX 8"),
    /** AN/GRN-12 */
    AN_GRN_12 (5537, "AN/GRN-12"),
    /** AN/MPN-14K */
    AN_MPN_14K (5538, "AN/MPN-14K"),
    /** AN/MPN-14 */
    AN_MPN_14 (5539, "AN/MPN-14"),
    /** AN/MPQ-10 */
    AN_MPQ_10 (5540, "AN/MPQ-10"),
    /** AN/MPN-17 */
    AN_MPN_17 (5541, "AN/MPN-17"),
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
    /** AN/MPQ-43 */
    AN_MPQ_43 (5565, "AN/MPQ-43"),
    /** AN/MPQ-50 */
    AN_MPQ_50 (5567, "AN/MPQ-50"),
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
    /** AN/MPS-36 */
    AN_MPS_36 (5583, "AN/MPS-36"),
    /** AN/SPG-48/MK 25 MOD 3 */
    AN_SPG_48_MK_25_MOD_3 (5620, "AN/SPG-48/MK 25 MOD 3"),
    /** AN/SPG-50 */
    AN_SPG_50 (5625, "AN/SPG-50"),
    /** AN/SPG-51 */
    AN_SPG_51 (5670, "AN/SPG-51"),
    /** AN/PPQ-2 */
    AN_PPQ_2 (5690, "AN/PPQ-2"),
    /** AN/PPS-15 */
    AN_PPS_15 (5700, "AN/PPS-15"),
    /** AN/PPS-5 */
    AN_PPS_5 (5705, "AN/PPS-5"),
    /** AN/PPS-5D */
    AN_PPS_5D (5710, "AN/PPS-5D"),
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
    /** AN/SPN-4 */
    AN_SPN_4 (6015, "AN/SPN-4"),
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
    /** AN/SPQ-5A */
    AN_SPQ_5A (6155, "AN/SPQ-5A"),
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
    /** AN/SPS-501 */
    AN_SPS_501 (7226, "AN/SPS-501"),
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
    /** AN/TPN-8 */
    AN_TPN_8 (7271, "AN/TPN-8"),
    /** AN/TPN-22 */
    AN_TPN_22 (7272, "AN/TPN-22"),
    /** AN/TLQ-17A */
    AN_TLQ_17A (7273, "AN/TLQ-17A"),
    /** AN/TMS-1 */
    AN_TMS_1 (7274, "AN/TMS-1"),
    /** AN/TPN-24 */
    AN_TPN_24 (7275, "AN/TPN-24"),
    /** AN/TPN-25 */
    AN_TPN_25 (7276, "AN/TPN-25"),
    /** AN/TMS-2 */
    AN_TMS_2 (7277, "AN/TMS-2"),
    /** AN/TPN-19 */
    AN_TPN_19 (7278, "AN/TPN-19"),
    /** AN/TPN-31 */
    AN_TPN_31 (7279, "AN/TPN-31"),
    /** AN/TPQ-18 */
    AN_TPQ_18 (7280, "AN/TPQ-18"),
    /** AN/SPY-6(V) */
    AN_SPY_6V (7281, "AN/SPY-6(V)"),
    /** AN/TPQ-36 */
    AN_TPQ_36 (7295, "AN/TPQ-36"),
    /** AN/TPQ-37 */
    AN_TPQ_37 (7300, "AN/TPQ-37"),
    /** AN/TPQ-38 (V8) */
    AN_TPQ_38_V8 (7301, "AN/TPQ-38 (V8)"),
    /** AN/TPQ-39(V) */
    AN_TPQ_39V (7302, "AN/TPQ-39(V)"),
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
    /** AN/TPQ-46A */
    AN_TPQ_46A (7313, "AN/TPQ-46A"),
    /** AN/TPS-34 */
    AN_TPS_34 (7314, "AN/TPS-34"),
    /** AN/TPS-59 */
    AN_TPS_59 (7315, "AN/TPS-59"),
    /** AN/TPS-44 */
    AN_TPS_44 (7316, "AN/TPS-44"),
    /** AN/TPS-63 */
    AN_TPS_63 (7320, "AN/TPS-63"),
    /** AN/TPS-65 */
    AN_TPS_65 (7321, "AN/TPS-65"),
    /** AN/TPS-70 (V) 1 */
    AN_TPS_70_V_1 (7322, "AN/TPS-70 (V) 1"),
    /** AN/TPS-63SS */
    AN_TPS_63SS (7323, "AN/TPS-63SS"),
    /** AN/TPS-73 */
    AN_TPS_73 (7324, "AN/TPS-73"),
    /** AN/TPS-75 */
    AN_TPS_75 (7325, "AN/TPS-75"),
    /** AN/TSP-77 */
    AN_TSP_77 (7326, "AN/TSP-77"),
    /** AN/TPS-78 */
    AN_TPS_78 (7327, "AN/TPS-78"),
    /** AN/TPS-79 */
    AN_TPS_79 (7328, "AN/TPS-79"),
    /** AN/TPS-703 */
    AN_TPS_703 (7329, "AN/TPS-703"),
    /** AN/TPX-46(V)7 */
    AN_TPX_46V7 (7330, "AN/TPX-46(V)7"),
    /** AN/TPY-2 */
    AN_TPY_2 (7333, "AN/TPY-2"),
    /** AN/ULQ-6A */
    AN_ULQ_6A (7335, "AN/ULQ-6A"),
    /** AN/ULQ-19 */
    AN_ULQ_19 (7340, "AN/ULQ-19"),
    /** AN/ULQ-21 */
    AN_ULQ_21 (7345, "AN/ULQ-21"),
    /** AN/UPN 25 */
    AN_UPN_25 (7380, "AN/UPN 25"),
    /** AN/UPS 1 */
    AN_UPS_1 (7425, "AN/UPS 1"),
    /** AN/UPS-2 */
    AN_UPS_2 (7426, "AN/UPS-2"),
    /** AN/UPS-3 */
    AN_UPS_3 (7427, "AN/UPS-3"),
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
    /** AN/USQ-113(V)3 */
    AN_USQ_113V3 (7700, "AN/USQ-113(V)3"),
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
    /** AORL-1AS */
    AORL_1AS (7761, "AORL-1AS"),
    /** AORL-85K/TK/MTA */
    AORL_85K_TK_MTA (7762, "AORL-85K/TK/MTA"),
    /** APAR */
    APAR (7765, "APAR"),
    /** Aparna */
    APARNA (7770, "Aparna"),
    /** COMMID_Apelco AD 7 7 */
    COMMID_APELCO_AD_7_7 (7785, "COMMID_Apelco AD 7 7"),
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
    /** AQUITAINE II */
    AQUITAINE_II (8102, "AQUITAINE II"),
    /** AR-1 */
    AR_1 (8103, "AR-1"),
    /** AR 3D */
    AR_3D (8105, "AR 3D"),
    /** COMMID_Plessey AR-5 */
    COMMID_PLESSEY_AR_5 (8112, "COMMID_Plessey AR-5"),
    /** COMMID_AR-15 */
    COMMID_AR_15 (8113, "COMMID_AR-15"),
    /** AR-15/2 */
    AR_15_2 (8114, "AR-15/2"),
    /** AR 320 */
    AR_320 (8115, "AR 320"),
    /** AR-325 */
    AR_325 (8118, "AR-325"),
    /** AR 327 */
    AR_327 (8120, "AR 327"),
    /** Arbalet-52 */
    ARBALET_52 (8121, "Arbalet-52"),
    /** ARBB-31 */
    ARBB_31 (8122, "ARBB-31"),
    /** COMMID_ARBB 33 */
    COMMID_ARBB_33 (8123, "COMMID_ARBB 33"),
    /** COMMID_ARIES */
    COMMID_ARIES (8126, "COMMID_ARIES"),
    /** ARGS-14E */
    ARGS_14E (8134, "ARGS-14E"),
    /** ARGS 31 */
    ARGS_31 (8135, "ARGS 31"),
    /** ARGUS */
    ARGUS (8140, "ARGUS"),
    /** AR M31 */
    AR_M31 (8145, "AR M31"),
    /** ARECIBO */
    ARECIBO (8150, "ARECIBO"),
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
    /** ARGOS-10 */
    ARGOS_10 (8282, "ARGOS-10"),
    /** ARGOS-800 */
    ARGOS_800 (8283, "ARGOS-800"),
    /** ARI 5983 */
    ARI_5983 (8284, "ARI 5983"),
    /** ARI 5991 */
    ARI_5991 (8285, "ARI 5991"),
    /** ARI 5995 */
    ARI_5995 (8290, "ARI 5995"),
    /** COMMID_ARINC 564 BNDXKING RDR 1E */
    COMMID_ARINC_564_BNDXKING_RDR_1E (8325, "COMMID_ARINC 564 BNDXKING RDR 1E"),
    /** COMMID_ARINC 700 BNDXKING RDR 1E */
    COMMID_ARINC_700_BNDXKING_RDR_1E (8370, "COMMID_ARINC 700 BNDXKING RDR 1E"),
    /** ARK-1 */
    ARK_1 (8375, "ARK-1"),
    /** COMMID_ARL-M MTI */
    COMMID_ARL_M_MTI (8378, "COMMID_ARL-M MTI"),
    /** ARMOR */
    ARMOR (8379, "ARMOR"),
    /** ARSR-3 */
    ARSR_3 (8380, "ARSR-3"),
    /** ARS-400 */
    ARS_400 (8381, "ARS-400"),
    /** ARSR-1 */
    ARSR_1 (8382, "ARSR-1"),
    /** ARSR-4 */
    ARSR_4 (8384, "ARSR-4"),
    /** ARSR-18 */
    ARSR_18 (8390, "ARSR-18"),
    /** COMMID_ARTHUR */
    COMMID_ARTHUR (8395, "COMMID_ARTHUR"),
    /** ARTHUR MOD B */
    ARTHUR_MOD_B (8400, "ARTHUR MOD B"),
    /** ARTHUR MOD C */
    ARTHUR_MOD_C (8405, "ARTHUR MOD C"),
    /** NATOID_AS 2 Kipper */
    NATOID_AS_2_KIPPER (8415, "NATOID_AS 2 Kipper"),
    /** NATOID_AS 2 Kipper MH */
    NATOID_AS_2_KIPPER_MH (8460, "NATOID_AS 2 Kipper MH"),
    /** AS 3 YJ-83K mmW MH */
    AS_3_YJ_83K_MMW_MH (8470, "AS 3 YJ-83K mmW MH"),
    /** AS.34 Kormoran Seeker */
    AS34_KORMORAN_SEEKER (8480, "AS.34 Kormoran Seeker"),
    /** NATOID_AS 4 Kitchen */
    NATOID_AS_4_KITCHEN (8505, "NATOID_AS 4 Kitchen"),
    /** NATOID_AS 4 Kitchen MH */
    NATOID_AS_4_KITCHEN_MH (8550, "NATOID_AS 4 Kitchen MH"),
    /** NATOID_AS 5 Kelt MH */
    NATOID_AS_5_KELT_MH (8595, "NATOID_AS 5 Kelt MH"),
    /** NATOID_AS 6 Kingfish MH */
    NATOID_AS_6_KINGFISH_MH (8640, "NATOID_AS 6 Kingfish MH"),
    /** NATOID_AS 7 Kerry */
    NATOID_AS_7_KERRY (8685, "NATOID_AS 7 Kerry"),
    /** NATOID_AS 7 Kerry MG */
    NATOID_AS_7_KERRY_MG (8730, "NATOID_AS 7 Kerry MG"),
    /** NATOID_AS 15 KENT altimeter */
    NATOID_AS_15_KENT_ALTIMETER (8735, "NATOID_AS 15 KENT altimeter"),
    /** NATOID_AS-17A Krypton Seeker */
    NATOID_AS_17A_KRYPTON_SEEKER (8736, "NATOID_AS-17A Krypton Seeker"),
    /** NATOID_AS-17B Krypton Seeker */
    NATOID_AS_17B_KRYPTON_SEEKER (8737, "NATOID_AS-17B Krypton Seeker"),
    /** COMMID_AS901 */
    COMMID_AS901 (8750, "COMMID_AS901"),
    /** AS901A */
    AS901A (8751, "AS901A"),
    /** ASARS2 */
    ASARS2 (8755, "ASARS2"),
    /** ASDE-KDD */
    ASDE_KDD (8756, "ASDE-KDD"),
    /** ASLESHA */
    ASLESHA (8757, "ASLESHA"),
    /** A-SMGCS */
    A_SMGCS (8758, "A-SMGCS"),
    /** ASMI-18X */
    ASMI_18X (8759, "ASMI-18X"),
    /** Aspide AAM/SAM ILL */
    ASPIDE_AAM_SAM_ILL (8760, "Aspide AAM/SAM ILL"),
    /** ASMI-3 */
    ASMI_3 (8761, "ASMI-3"),
    /** ASR-2000 */
    ASR_2000 (8771, "ASR-2000"),
    /** ASR-4 */
    ASR_4 (8772, "ASR-4"),
    /** ASR-4D */
    ASR_4D (8773, "ASR-4D"),
    /** ASR O */
    ASR_O (8775, "ASR O"),
    /** ASR-12 */
    ASR_12 (8776, "ASR-12"),
    /** ASR-22AL */
    ASR_22AL (8778, "ASR-22AL"),
    /** ASR-3 */
    ASR_3 (8779, "ASR-3"),
    /** ASR-5 */
    ASR_5 (8780, "ASR-5"),
    /** ASR-7 */
    ASR_7 (8782, "ASR-7"),
    /** ASR-8 */
    ASR_8 (8785, "ASR-8"),
    /** ASR-9 */
    ASR_9 (8790, "ASR-9"),
    /** ASR-9000 */
    ASR_9000 (8791, "ASR-9000"),
    /** ASTI */
    ASTI (8792, "ASTI"),
    /** ASR-11/DASR */
    ASR_11_DASR (8793, "ASR-11/DASR"),
    /** ASR-12 */
    ASR_12_2 (8795, "ASR-12"),
    /** COMMID_Raytheon ASR-10SS */
    COMMID_RAYTHEON_ASR_10SS (8812, "COMMID_Raytheon ASR-10SS"),
    /** ASR-23SS */
    ASR_23SS (8816, "ASR-23SS"),
    /** Arabel */
    ARABEL (8818, "Arabel"),
    /** COMMID_ASTRE */
    COMMID_ASTRE (8819, "COMMID_ASTRE"),
    /** NATOID_AT 2 Swatter MG */
    NATOID_AT_2_SWATTER_MG (8820, "NATOID_AT 2 Swatter MG"),
    /** 9K114 Shturm MG */
    _9K114_SHTURM_MG (8824, "9K114 Shturm MG"),
    /** ATCR-22 */
    ATCR_22 (8830, "ATCR-22"),
    /** ATCR-22 M */
    ATCR_22_M (8831, "ATCR-22 M"),
    /** ATCR-2T */
    ATCR_2T (8832, "ATCR-2T"),
    /** ATCR-33 */
    ATCR_33 (8840, "ATCR-33"),
    /** ATCR 33 K/M */
    ATCR_33_K_M (8845, "ATCR 33 K/M"),
    /** ATCR-33S */
    ATCR_33S (8846, "ATCR-33S"),
    /** ATCR-3T */
    ATCR_3T (8847, "ATCR-3T"),
    /** ATCR-44 */
    ATCR_44 (8848, "ATCR-44"),
    /** ATCR-44 K */
    ATCR_44_K (8849, "ATCR-44 K"),
    /** COMMID_Argos 73 */
    COMMID_ARGOS_73 (8850, "COMMID_Argos 73"),
    /** ATCR-44 M/S */
    ATCR_44_M_S (8851, "ATCR-44 M/S"),
    /** ATCR-4T */
    ATCR_4T (8852, "ATCR-4T"),
    /** COMMID_Atlas Elektronk TRS N */
    COMMID_ATLAS_ELEKTRONK_TRS_N (8865, "COMMID_Atlas Elektronk TRS N"),
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
    /** ATLASS */
    ATLASS (8871, "ATLASS"),
    /** ATR-500C */
    ATR_500C (8880, "ATR-500C"),
    /** AVG 65 */
    AVG_65 (8910, "AVG 65"),
    /** AVH 7 */
    AVH_7 (8955, "AVH 7"),
    /** AVIA CM */
    AVIA_CM (8980, "AVIA CM"),
    /** AVIA D */
    AVIA_D (8985, "AVIA D"),
    /** COMMID_Aviaconversia */
    COMMID_AVIACONVERSIA (8990, "COMMID_Aviaconversia"),
    /** COMMID_Aviaconversia II */
    COMMID_AVIACONVERSIA_II (8993, "COMMID_Aviaconversia II"),
    /** COMMID_Aviaconversia III */
    COMMID_AVIACONVERSIA_III (8995, "COMMID_Aviaconversia III"),
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
    /** NATOID_Back Board */
    NATOID_BACK_BOARD (9215, "NATOID_Back Board"),
    /** NATOID_Back Net A B */
    NATOID_BACK_NET_A_B (9225, "NATOID_Back Net A B"),
    /** NATOID_Back Trap */
    NATOID_BACK_TRAP (9270, "NATOID_Back Trap"),
    /** COMMID_BAE Systems RT-1805APN */
    COMMID_BAE_SYSTEMS_RT_1805APN (9280, "COMMID_BAE Systems RT-1805APN"),
    /** Balance Beam */
    BALANCE_BEAM (9285, "Balance Beam"),
    /** BALTIKA-B */
    BALTIKA_B (9300, "BALTIKA-B"),
    /** BALTYK */
    BALTYK (9310, "BALTYK"),
    /** NATOID_Ball End */
    NATOID_BALL_END (9315, "NATOID_Ball End"),
    /** NATOID_Ball Gun */
    NATOID_BALL_GUN (9360, "NATOID_Ball Gun"),
    /** NATOID_Band Stand */
    NATOID_BAND_STAND (9405, "NATOID_Band Stand"),
    /** COMMID_Band Stand 3 */
    COMMID_BAND_STAND_3 (9406, "COMMID_Band Stand 3"),
    /** P-35/37 (A); P-50 (B) */
    P_35_37_A_P_50_B (9450, "P-35/37 (A); P-50 (B)"),
    /** BARAX */
    BARAX (9475, "BARAX"),
    /** BASIR-110D */
    BASIR_110D (9485, "BASIR-110D"),
    /** NATOID_Bass Tilt */
    NATOID_BASS_TILT (9495, "NATOID_Bass Tilt"),
    /** Badger */
    BADGER (9505, "Badger"),
    /** NATOID_Beacon */
    NATOID_BEACON (9540, "NATOID_Beacon"),
    /** NATOID_Bean Sticks */
    NATOID_BEAN_STICKS (9585, "NATOID_Bean Sticks"),
    /** NATOID_Bee Hind */
    NATOID_BEE_HIND (9630, "NATOID_Bee Hind"),
    /** NATOID_Bell Crown A */
    NATOID_BELL_CROWN_A (9640, "NATOID_Bell Crown A"),
    /** NATOID_Bell Crown B */
    NATOID_BELL_CROWN_B (9642, "NATOID_Bell Crown B"),
    /** NATOID_Bell Squat */
    NATOID_BELL_SQUAT (9643, "NATOID_Bell Squat"),
    /** NATOID_BIG BACK */
    NATOID_BIG_BACK (9645, "NATOID_BIG BACK"),
    /** NATOID_Big Bird ABC */
    NATOID_BIG_BIRD_ABC (9659, "NATOID_Big Bird ABC"),
    /** NATOID_Big Bird D */
    NATOID_BIG_BIRD_D (9660, "NATOID_Big Bird D"),
    /** NATOID_Big Bird D Mod */
    NATOID_BIG_BIRD_D_MOD (9661, "NATOID_Big Bird D Mod"),
    /** NATOID_Big Bulge */
    NATOID_BIG_BULGE (9675, "NATOID_Big Bulge"),
    /** NATOID_Big Bulge A */
    NATOID_BIG_BULGE_A (9720, "NATOID_Big Bulge A"),
    /** NATOID_Big Bulge B */
    NATOID_BIG_BULGE_B (9765, "NATOID_Big Bulge B"),
    /** COMMID_BIG EYE */
    COMMID_BIG_EYE (9775, "COMMID_BIG EYE"),
    /** SNAR-10 */
    SNAR_10 (9780, "SNAR-10"),
    /** COMMID_BIG HEAD B */
    COMMID_BIG_HEAD_B (9781, "COMMID_BIG HEAD B"),
    /** NATOID_Big Mesh */
    NATOID_BIG_MESH (9810, "NATOID_Big Mesh"),
    /** NATOID_Big Net */
    NATOID_BIG_NET (9855, "NATOID_Big Net"),
    /** 9S15MT */
    _9S15MT (9885, "9S15MT"),
    /** NATOID_Bill Fold */
    NATOID_BILL_FOLD (9900, "NATOID_Bill Fold"),
    /** BLIGHTER 400 */
    BLIGHTER_400 (9903, "BLIGHTER 400"),
    /** Blowpipe MG */
    BLOWPIPE_MG (9905, "Blowpipe MG"),
    /** BLR */
    BLR (9920, "BLR"),
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
    /** NATOID_Boat Sail */
    NATOID_BOAT_SAIL (10080, "NATOID_Boat Sail"),
    /** BOR-A 550 */
    BOR_A_550 (10090, "BOR-A 550"),
    /** COMMID_Bofors Electronic 9LV 331 */
    COMMID_BOFORS_ELECTRONIC_9LV_331 (10125, "COMMID_Bofors Electronic 9LV 331"),
    /** COMMID_Bofors Ericsson Sea Giraffe 50 HC */
    COMMID_BOFORS_ERICSSON_SEA_GIRAFFE_50_HC (10170, "COMMID_Bofors Ericsson Sea Giraffe 50 HC"),
    /** NATOID_Bowl Mesh */
    NATOID_BOWL_MESH (10215, "NATOID_Bowl Mesh"),
    /** NATOID_Box Brick */
    NATOID_BOX_BRICK (10260, "NATOID_Box Brick"),
    /** NATOID_Box Tail */
    NATOID_BOX_TAIL (10305, "NATOID_Box Tail"),
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
    /** COMMID_BridgeMaster */
    COMMID_BRIDGEMASTER (10510, "COMMID_BridgeMaster"),
    /** COMMID_BridgeMaster E EPA */
    COMMID_BRIDGEMASTER_E_EPA (10511, "COMMID_BridgeMaster E EPA"),
    /** COMMID_BridgeMaster E ATA and ARPA */
    COMMID_BRIDGEMASTER_E_ATA_AND_ARPA (10512, "COMMID_BridgeMaster E ATA and ARPA"),
    /** COMMID_BridgeMaster E naval */
    COMMID_BRIDGEMASTER_E_NAVAL (10513, "COMMID_BridgeMaster E naval"),
    /** Brimstone mmW MH */
    BRIMSTONE_MMW_MH (10520, "Brimstone mmW MH"),
    /** NATOID_Bread Bin */
    NATOID_BREAD_BIN (10530, "NATOID_Bread Bin"),
    /** Asr */
    ASR (10540, "Asr"),
    /** BT 271 */
    BT_271 (10575, "BT 271"),
    /** BU-304 */
    BU_304 (10595, "BU-304"),
    /** BX 732 */
    BX_732 (10620, "BX 732"),
    /** BUK-MB */
    BUK_MB (10630, "BUK-MB"),
    /** Buran-D */
    BURAN_D (10642, "Buran-D"),
    /** BUREVISNYK-1 */
    BUREVISNYK_1 (10650, "BUREVISNYK-1"),
    /** NATOID_Buzz Stand */
    NATOID_BUZZ_STAND (10665, "NATOID_Buzz Stand"),
    /** C 5A Multi Mode Radar */
    C_5A_MULTI_MODE_RADAR (10710, "C 5A Multi Mode Radar"),
    /** C-802 AL */
    C_802_AL (10711, "C-802 AL"),
    /** COMMID_CAESAR */
    COMMID_CAESAR (10740, "COMMID_CAESAR"),
    /** Caiman */
    CAIMAN (10755, "Caiman"),
    /** NATOID_Cake Stand */
    NATOID_CAKE_STAND (10800, "NATOID_Cake Stand"),
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
    /** COMMID_Cardion Coastal */
    COMMID_CARDION_COASTAL (10895, "COMMID_Cardion Coastal"),
    /** Castor Ii */
    CASTOR_II (10935, "Castor Ii"),
    /** Castor 2J TT (Crotale NG) */
    CASTOR_2J_TT_CROTALE_NG (10940, "Castor 2J TT (Crotale NG)"),
    /** NATOID_Cat House */
    NATOID_CAT_HOUSE (10980, "NATOID_Cat House"),
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
    /** NATOID_Chair Back TT */
    NATOID_CHAIR_BACK_TT (11000, "NATOID_Chair Back TT"),
    /** NATOID_Chair Back ILL */
    NATOID_CHAIR_BACK_ILL (11010, "NATOID_Chair Back ILL"),
    /** LEMZ 96L6 */
    LEMZ_96L6 (11020, "LEMZ 96L6"),
    /** NATOID_Cheese Brick */
    NATOID_CHEESE_BRICK (11025, "NATOID_Cheese Brick"),
    /** NATOID_Cheese Cake */
    NATOID_CHEESE_CAKE (11030, "NATOID_Cheese Cake"),
    /** Clam Pipe */
    CLAM_PIPE (11070, "Clam Pipe"),
    /** NATOID_Clamshell */
    NATOID_CLAMSHELL (11115, "NATOID_Clamshell"),
    /** CLC-1 */
    CLC_1 (11117, "CLC-1"),
    /** CLC-2 */
    CLC_2 (11118, "CLC-2"),
    /** CLC-3 */
    CLC_3 (11119, "CLC-3"),
    /** CLR-155 */
    CLR_155 (11120, "CLR-155"),
    /** COAST WATCHER 100 */
    COAST_WATCHER_100 (11123, "COAST WATCHER 100"),
    /** Coastal Giraffe */
    COASTAL_GIRAFFE (11125, "Coastal Giraffe"),
    /** COBRA */
    COBRA (11130, "COBRA"),
    /** Cobra Shoe */
    COBRA_SHOE (11133, "Cobra Shoe"),
    /** Colibri */
    COLIBRI (11137, "Colibri"),
    /** COMMID_Collins WXR-300 */
    COMMID_COLLINS_WXR_300 (11155, "COMMID_Collins WXR-300"),
    /** COMMID_Collins WXR-700X */
    COMMID_COLLINS_WXR_700X (11160, "COMMID_Collins WXR-700X"),
    /** Collins TWR-850 */
    COLLINS_TWR_850 (11165, "Collins TWR-850"),
    /** COMMID_Collins DN 101 */
    COMMID_COLLINS_DN_101 (11205, "COMMID_Collins DN 101"),
    /** NATOID_COMET-1 */
    NATOID_COMET_1 (11230, "NATOID_COMET-1"),
    /** CONDOR MK 2 */
    CONDOR_MK_2 (11235, "CONDOR MK 2"),
    /** COMMID_Consilium Selesmar RTM 25 XIM */
    COMMID_CONSILIUM_SELESMAR_RTM_25_XIM (11240, "COMMID_Consilium Selesmar RTM 25 XIM"),
    /** COMMID_Contraves Sea Hunter MK 4 */
    COMMID_CONTRAVES_SEA_HUNTER_MK_4 (11250, "COMMID_Contraves Sea Hunter MK 4"),
    /** NATOID_Corn Can */
    NATOID_CORN_CAN (11260, "NATOID_Corn Can"),
    /** COSMO SKYMED-1 */
    COSMO_SKYMED_1 (11265, "COSMO SKYMED-1"),
    /** CR-105 RMCA */
    CR_105_RMCA (11270, "CR-105 RMCA"),
    /** CREW Duke 2 */
    CREW_DUKE_2 (11280, "CREW Duke 2"),
    /** CREW Duke 3 */
    CREW_DUKE_3 (11290, "CREW Duke 3"),
    /** NATOID_Cross Bird */
    NATOID_CROSS_BIRD (11295, "NATOID_Cross Bird"),
    /** NATOID_Cross Dome */
    NATOID_CROSS_DOME (11340, "NATOID_Cross Dome"),
    /** NATOID_Cross Legs */
    NATOID_CROSS_LEGS (11385, "NATOID_Cross Legs"),
    /** NATOID_Cross Out */
    NATOID_CROSS_OUT (11430, "NATOID_Cross Out"),
    /** NATOID_Cross Slot */
    NATOID_CROSS_SLOT (11475, "NATOID_Cross Slot"),
    /** NATOID_Cross Sword */
    NATOID_CROSS_SWORD (11520, "NATOID_Cross Sword"),
    /** NATOID_Cross Up */
    NATOID_CROSS_UP (11565, "NATOID_Cross Up"),
    /** NATOID_Cross Sword FC */
    NATOID_CROSS_SWORD_FC (11610, "NATOID_Cross Sword FC"),
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
    /** HY-2B MH */
    HY_2B_MH (11748, "HY-2B MH"),
    /** CSS C 2B HY 1A MH */
    CSS_C_2B_HY_1A_MH (11790, "CSS C 2B HY 1A MH"),
    /** CSS-N-4 Sardine */
    CSS_N_4_SARDINE (11800, "CSS-N-4 Sardine"),
    /** CSS-N-8 Saccade */
    CSS_N_8_SACCADE (11810, "CSS-N-8 Saccade"),
    /** NATOID_Curl Stone B */
    NATOID_CURL_STONE_B (11825, "NATOID_Curl Stone B"),
    /** CWS-1 */
    CWS_1 (11830, "CWS-1"),
    /** CWS 2 */
    CWS_2 (11835, "CWS 2"),
    /** CWS-3 */
    CWS_3 (11840, "CWS-3"),
    /** NATOID_Cylinder Head */
    NATOID_CYLINDER_HEAD (11880, "NATOID_Cylinder Head"),
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
    /** NATOID_Dawn */
    NATOID_DAWN (12060, "NATOID_Dawn"),
    /** DCR */
    DCR (12090, "DCR"),
    /** NATOID_Dead Duck */
    NATOID_DEAD_DUCK (12105, "NATOID_Dead Duck"),
    /** COMMID_DECCA-20 V909 */
    COMMID_DECCA_20_V909 (12110, "COMMID_DECCA-20 V909"),
    /** COMMID_DECCA-20 V90S */
    COMMID_DECCA_20_V90S (12111, "COMMID_DECCA-20 V90S"),
    /** COMMID_DECCA 45 */
    COMMID_DECCA_45 (12150, "COMMID_DECCA 45"),
    /** COMMID_DECCA 50 */
    COMMID_DECCA_50 (12195, "COMMID_DECCA 50"),
    /** COMMID_DECCA 71 */
    COMMID_DECCA_71 (12196, "COMMID_DECCA 71"),
    /** Decca 72 */
    DECCA_72 (12197, "Decca 72"),
    /** COMMID_DECCA 110 */
    COMMID_DECCA_110 (12240, "COMMID_DECCA 110"),
    /** COMMID_DECCA 170 */
    COMMID_DECCA_170 (12285, "COMMID_DECCA 170"),
    /** COMMID_DECCA HF 2 */
    COMMID_DECCA_HF_2 (12292, "COMMID_DECCA HF 2"),
    /** COMMID_DECCA 202 */
    COMMID_DECCA_202 (12330, "COMMID_DECCA 202"),
    /** COMMID_DECCA D202 */
    COMMID_DECCA_D202 (12375, "COMMID_DECCA D202"),
    /** COMMID_DECCA 303 */
    COMMID_DECCA_303 (12420, "COMMID_DECCA 303"),
    /** COMMID_DECCA 535 */
    COMMID_DECCA_535 (12430, "COMMID_DECCA 535"),
    /** COMMID_DECCA 626 */
    COMMID_DECCA_626 (12465, "COMMID_DECCA 626"),
    /** COMMID_DECCA 629 */
    COMMID_DECCA_629 (12510, "COMMID_DECCA 629"),
    /** COMMID_DECCA 914 */
    COMMID_DECCA_914 (12555, "COMMID_DECCA 914"),
    /** COMMID_DECCA 916 */
    COMMID_DECCA_916 (12600, "COMMID_DECCA 916"),
    /** COMMID_DECCA 926 */
    COMMID_DECCA_926 (12610, "COMMID_DECCA 926"),
    /** COMMID_DECCA 1070A */
    COMMID_DECCA_1070A (12615, "COMMID_DECCA 1070A"),
    /** COMMID_Decca 1008 */
    COMMID_DECCA_1008 (12616, "COMMID_Decca 1008"),
    /** COMMID_DECCA 1226 Commercial */
    COMMID_DECCA_1226_COMMERCIAL (12645, "COMMID_DECCA 1226 Commercial"),
    /** COMMID_DECCA 1290 */
    COMMID_DECCA_1290 (12655, "COMMID_DECCA 1290"),
    /** COMMID_DECCA 1626 */
    COMMID_DECCA_1626 (12690, "COMMID_DECCA 1626"),
    /** COMMID_DECCA 2070 */
    COMMID_DECCA_2070 (12691, "COMMID_DECCA 2070"),
    /** COMMID_Decca 1630 */
    COMMID_DECCA_1630 (12694, "COMMID_Decca 1630"),
    /** COMMID_DECCA 2459 */
    COMMID_DECCA_2459 (12735, "COMMID_DECCA 2459"),
    /** COMMID_DECCA AWS 1 */
    COMMID_DECCA_AWS_1 (12780, "COMMID_DECCA AWS 1"),
    /** COMMID_DECCA AWS 2 */
    COMMID_DECCA_AWS_2 (12782, "COMMID_DECCA AWS 2"),
    /** COMMID_DECCA AWS 4 */
    COMMID_DECCA_AWS_4 (12785, "COMMID_DECCA AWS 4"),
    /** COMMID_DECCA AWS-4 (2) */
    COMMID_DECCA_AWS_4_2 (12787, "COMMID_DECCA AWS-4 (2)"),
    /** COMMID_DECCA MAR */
    COMMID_DECCA_MAR (12800, "COMMID_DECCA MAR"),
    /** COMMID_DECCA RM 326 */
    COMMID_DECCA_RM_326 (12805, "COMMID_DECCA RM 326"),
    /** COMMID_DECCA RM 416 */
    COMMID_DECCA_RM_416 (12825, "COMMID_DECCA RM 416"),
    /** DECCA RM 970BT */
    DECCA_RM_970BT (12850, "DECCA RM 970BT"),
    /** COMMID_DECCA RM 914 */
    COMMID_DECCA_RM_914 (12870, "COMMID_DECCA RM 914"),
    /** DF-21D Seeker */
    DF_21D_SEEKER (12875, "DF-21D Seeker"),
    /** COMMID_DECCA RM 1690 */
    COMMID_DECCA_RM_1690 (12915, "COMMID_DECCA RM 1690"),
    /** COMMID_DECCA 1690 */
    COMMID_DECCA_1690 (12916, "COMMID_DECCA 1690"),
    /** COMMID_DECCA Super 101 MK 3 */
    COMMID_DECCA_SUPER_101_MK_3 (12960, "COMMID_DECCA Super 101 MK 3"),
    /** DISS 1 */
    DISS_1 (13005, "DISS 1"),
    /** DISS-7 */
    DISS_7 (13006, "DISS-7"),
    /** DISS-013 */
    DISS_013 (13007, "DISS-013"),
    /** DISS-15D */
    DISS_15D (13015, "DISS-15D"),
    /** DLD-100A */
    DLD_100A (13020, "DLD-100A"),
    /** Rapier TTDN 181 */
    RAPIER_TTDN_181 (13050, "Rapier TTDN 181"),
    /** Rapier 2000 TT */
    RAPIER_2000_TT (13055, "Rapier 2000 TT"),
    /** NATOID_Dog Ear */
    NATOID_DOG_EAR (13095, "NATOID_Dog Ear"),
    /** NATOID_Dog House */
    NATOID_DOG_HOUSE (13140, "NATOID_Dog House"),
    /** DM3 */
    DM3 (13141, "DM3"),
    /** DM-3B */
    DM_3B (13142, "DM-3B"),
    /** DM-5 */
    DM_5 (13143, "DM-5"),
    /** Don 2 */
    DON_2 (13185, "Don 2"),
    /** NATOID_Don AB2Kay */
    NATOID_DON_AB2KAY (13230, "NATOID_Don AB2Kay"),
    /** NATOID_Donets */
    NATOID_DONETS (13275, "NATOID_Donets"),
    /** COMMID_Doppler 90 Series */
    COMMID_DOPPLER_90_SERIES (13280, "COMMID_Doppler 90 Series"),
    /** NATOID_Down Beat */
    NATOID_DOWN_BEAT (13320, "NATOID_Down Beat"),
    /** DR-582 */
    DR_582 (13360, "DR-582"),
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
    /** NATOID_Dragon Eye */
    NATOID_DRAGON_EYE (13477, "NATOID_Dragon Eye"),
    /** NATOID_Dragon Eye 2 */
    NATOID_DRAGON_EYE_2 (13480, "NATOID_Dragon Eye 2"),
    /** NATOID_Dragon Eye 3 */
    NATOID_DRAGON_EYE_3 (13481, "NATOID_Dragon Eye 3"),
    /** NATOID_Dragon Eye 4 */
    NATOID_DRAGON_EYE_4 (13485, "NATOID_Dragon Eye 4"),
    /** DRBC 30B */
    DRBC_30B (13500, "DRBC 30B"),
    /** DRBC 31A */
    DRBC_31A (13545, "DRBC 31A"),
    /** DRBC-31D */
    DRBC_31D (13546, "DRBC-31D"),
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
    /** DRBN 34 */
    DRBN_34 (13915, "DRBN 34"),
    /** DRBR 51 */
    DRBR_51 (13950, "DRBR 51"),
    /** DRBV-20A */
    DRBV_20A (13994, "DRBV-20A"),
    /** DRBV 20B */
    DRBV_20B (13995, "DRBV 20B"),
    /** DRBV-21 Mars 05 */
    DRBV_21_MARS_05 (14020, "DRBV-21 Mars 05"),
    /** DRBV 22 */
    DRBV_22 (14040, "DRBV 22"),
    /** DRBV-23 */
    DRBV_23 (14041, "DRBV-23"),
    /** DRBV 26C */
    DRBV_26C (14085, "DRBV 26C"),
    /** DRBV 26D */
    DRBV_26D (14086, "DRBV 26D"),
    /** DRBV 30 */
    DRBV_30 (14130, "DRBV 30"),
    /** DRBV-31 */
    DRBV_31 (14131, "DRBV-31"),
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
    /** NATOID_Drum Tilt */
    NATOID_DRUM_TILT (14490, "NATOID_Drum Tilt"),
    /** NATOID_Drum Tilt A */
    NATOID_DRUM_TILT_A (14535, "NATOID_Drum Tilt A"),
    /** NATOID_Drum Tilt B */
    NATOID_DRUM_TILT_B (14545, "NATOID_Drum Tilt B"),
    /** DRUN 30A */
    DRUN_30A (14560, "DRUN 30A"),
    /** NATOID_Dumbo */
    NATOID_DUMBO (14580, "NATOID_Dumbo"),
    /** DWSR-92 */
    DWSR_92 (14583, "DWSR-92"),
    /** DWSR-93S */
    DWSR_93S (14585, "DWSR-93S"),
    /** EAGLE */
    EAGLE (14586, "EAGLE"),
    /** EAGLE Mk 1 */
    EAGLE_MK_1 (14587, "EAGLE Mk 1"),
    /** EKCO E390 */
    EKCO_E390 (14590, "EKCO E390"),
    /** ECR-90 */
    ECR_90 (14600, "ECR-90"),
    /** NATOID_Egg Cup AB */
    NATOID_EGG_CUP_AB (14625, "NATOID_Egg Cup AB"),
    /** EISCAT */
    EISCAT (14640, "EISCAT"),
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
    /** EL/M-2052 */
    EL_M_2052 (14727, "EL/M-2052"),
    /** EL/M-2055 */
    EL_M_2055 (14728, "EL/M-2055"),
    /** EL/M-2060 */
    EL_M_2060 (14730, "EL/M-2060"),
    /** EL/M-2075 */
    EL_M_2075 (14735, "EL/M-2075"),
    /** EL/M-2022U(V)3 */
    EL_M_2022UV3 (14736, "EL/M-2022U(V)3"),
    /** EL/M-2080 */
    EL_M_2080 (14737, "EL/M-2080"),
    /** EL/M-2080S */
    EL_M_2080S (14738, "EL/M-2080S"),
    /** EL/M-2085 */
    EL_M_2085 (14739, "EL/M-2085"),
    /** EL/M-2106 */
    EL_M_2106 (14740, "EL/M-2106"),
    /** EL/M-2106NG */
    EL_M_2106NG (14741, "EL/M-2106NG"),
    /** EL/M-2125 */
    EL_M_2125 (14742, "EL/M-2125"),
    /** EL/M-2129 */
    EL_M_2129 (14743, "EL/M-2129"),
    /** EL/M-2150 */
    EL_M_2150 (14744, "EL/M-2150"),
    /** EL/M-2083 */
    EL_M_2083 (14745, "EL/M-2083"),
    /** EL/M-2084 */
    EL_M_2084 (14746, "EL/M-2084"),
    /** EL/M-2160-V1 */
    EL_M_2160_V1 (14747, "EL/M-2160-V1"),
    /** EL/M-2084 MMR */
    EL_M_2084_MMR (14748, "EL/M-2084 MMR"),
    /** EL/M-2112 */
    EL_M_2112 (14749, "EL/M-2112"),
    /** EL/M-2200 */
    EL_M_2200 (14750, "EL/M-2200"),
    /** EL/M-2133 */
    EL_M_2133 (14751, "EL/M-2133"),
    /** EL/M-2205 */
    EL_M_2205 (14755, "EL/M-2205"),
    /** EL M 2207 */
    EL_M_2207 (14760, "EL M 2207"),
    /** EL/M-2215 */
    EL_M_2215 (14765, "EL/M-2215"),
    /** NATOID_ELM 2216(V) */
    NATOID_ELM_2216V (14770, "NATOID_ELM 2216(V)"),
    /** EL/M-2216XH */
    EL_M_2216XH (14772, "EL/M-2216XH"),
    /** EL/M-2218S */
    EL_M_2218S (14775, "EL/M-2218S"),
    /** ELT-361 */
    ELT_361 (14776, "ELT-361"),
    /** EL/M-2258 */
    EL_M_2258 (14777, "EL/M-2258"),
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
    /** EL/M-2226 */
    EL_M_2226 (14808, "EL/M-2226"),
    /** EL/M-2228X */
    EL_M_2228X (14809, "EL/M-2228X"),
    /** ELTA SIS */
    ELTA_SIS (14810, "ELTA SIS"),
    /** EL/M-2238 */
    EL_M_2238 (14811, "EL/M-2238"),
    /** EL/M-2248 */
    EL_M_2248 (14815, "EL/M-2248"),
    /** EL/M-2288 */
    EL_M_2288 (14820, "EL/M-2288"),
    /** EL/M-2311 */
    EL_M_2311 (14821, "EL/M-2311"),
    /** ELM-2026 */
    ELM_2026 (14822, "ELM-2026"),
    /** COMMID_ELNA 4007 */
    COMMID_ELNA_4007 (14830, "COMMID_ELNA 4007"),
    /** ELW-2090 */
    ELW_2090 (14835, "ELW-2090"),
    /** COMMID_Enhanced Meteor Detection Radar EMDR */
    COMMID_ENHANCED_METEOR_DETECTION_RADAR_EMDR (14845, "COMMID_Enhanced Meteor Detection Radar EMDR"),
    /** EMD 2900 */
    EMD_2900 (14850, "EMD 2900"),
    /** EMPAR */
    EMPAR (14851, "EMPAR"),
    /** NATOID_End Tray */
    NATOID_END_TRAY (14895, "NATOID_End Tray"),
    /** EQ-36 */
    EQ_36 (14896, "EQ-36"),
    /** Ericsson SLAR */
    ERICSSON_SLAR (14897, "Ericsson SLAR"),
    /** Erieye */
    ERIEYE (14898, "Erieye"),
    /** ESR 1 */
    ESR_1 (14900, "ESR 1"),
    /** ESR 220 */
    ESR_220 (14901, "ESR 220"),
    /** ESR380 */
    ESR380 (14902, "ESR380"),
    /** ESTEREL */
    ESTEREL (14903, "ESTEREL"),
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
    /** NATOID_Eye Bowl */
    NATOID_EYE_BOWL (15075, "NATOID_Eye Bowl"),
    /** NATOID_Eye Shield */
    NATOID_EYE_SHIELD (15120, "NATOID_Eye Shield"),
    /** NATOID_F332Z */
    NATOID_F332Z (15140, "NATOID_F332Z"),
    /** NATOID_Falcon Claw TI */
    NATOID_FALCON_CLAW_TI (15155, "NATOID_Falcon Claw TI"),
    /** NATOID_Falcon Claw TT */
    NATOID_FALCON_CLAW_TT (15156, "NATOID_Falcon Claw TT"),
    /** FALCON */
    FALCON (15160, "FALCON"),
    /** FALCON-G */
    FALCON_G (15161, "FALCON-G"),
    /** NATOID_Falcon Eye */
    NATOID_FALCON_EYE (15163, "NATOID_Falcon Eye"),
    /** NATOID_Fan Song A */
    NATOID_FAN_SONG_A (15165, "NATOID_Fan Song A"),
    /** NATOID_Fan Song BF TA */
    NATOID_FAN_SONG_BF_TA (15200, "NATOID_Fan Song BF TA"),
    /** NATOID_Fan Song BF TT */
    NATOID_FAN_SONG_BF_TT (15210, "NATOID_Fan Song BF TT"),
    /** NATOID_Fan Song CE TA */
    NATOID_FAN_SONG_CE_TA (15220, "NATOID_Fan Song CE TA"),
    /** NATOID_Fan Song CE TT */
    NATOID_FAN_SONG_CE_TT (15230, "NATOID_Fan Song CE TT"),
    /** NATOID_Fan Song CE MG */
    NATOID_FAN_SONG_CE_MG (15240, "NATOID_Fan Song CE MG"),
    /** NATOID_Fan Song BFF MG */
    NATOID_FAN_SONG_BFF_MG (15255, "NATOID_Fan Song BFF MG"),
    /** NATOID_Fan Tail */
    NATOID_FAN_TAIL (15300, "NATOID_Fan Tail"),
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
    /** FCS-2-22 */
    FCS_2_22 (15318, "FCS-2-22"),
    /** FCS-2-31 */
    FCS_2_31 (15319, "FCS-2-31"),
    /** FCS-3 */
    FCS_3 (15320, "FCS-3"),
    /** NATOID_Fin Curve */
    NATOID_FIN_CURVE (15345, "NATOID_Fin Curve"),
    /** NATOID_Fire Can */
    NATOID_FIRE_CAN (15390, "NATOID_Fire Can"),
    /** NATOID_Fire Dish */
    NATOID_FIRE_DISH (15435, "NATOID_Fire Dish"),
    /** NATOID_Fire Dome TA */
    NATOID_FIRE_DOME_TA (15470, "NATOID_Fire Dome TA"),
    /** NATOID_Fire Dome TT */
    NATOID_FIRE_DOME_TT (15475, "NATOID_Fire Dome TT"),
    /** NATOID_Fire Dome TI */
    NATOID_FIRE_DOME_TI (15480, "NATOID_Fire Dome TI"),
    /** NATOID_Fire Iron */
    NATOID_FIRE_IRON (15525, "NATOID_Fire Iron"),
    /** NATOID_Fire Wheel */
    NATOID_FIRE_WHEEL (15570, "NATOID_Fire Wheel"),
    /** NATOID_Fish Bowl */
    NATOID_FISH_BOWL (15615, "NATOID_Fish Bowl"),
    /** FLAIR */
    FLAIR (15650, "FLAIR"),
    /** NATOID_Flap Lid */
    NATOID_FLAP_LID (15660, "NATOID_Flap Lid"),
    /** NATOID_Flap Truck */
    NATOID_FLAP_TRUCK (15705, "NATOID_Flap Truck"),
    /** NATOID_Flap Wheel */
    NATOID_FLAP_WHEEL (15750, "NATOID_Flap Wheel"),
    /** NATOID_Flash Dance */
    NATOID_FLASH_DANCE (15795, "NATOID_Flash Dance"),
    /** NATOID_Flash Dance M */
    NATOID_FLASH_DANCE_M (15800, "NATOID_Flash Dance M"),
    /** P-15 */
    P_15 (15840, "P-15"),
    /** 35N6 */
    _35N6 (15842, "35N6"),
    /** NATOID_Flat Screen */
    NATOID_FLAT_SCREEN (15885, "NATOID_Flat Screen"),
    /** NATOID_Flat Spin */
    NATOID_FLAT_SPIN (15930, "NATOID_Flat Spin"),
    /** NATOID_Flat Twin */
    NATOID_FLAT_TWIN (15975, "NATOID_Flat Twin"),
    /** FL-400 */
    FL_400 (15980, "FL-400"),
    /** Fledermaus */
    FLEDERMAUS (16020, "Fledermaus"),
    /** NATOID_FLYCATCHER */
    NATOID_FLYCATCHER (16030, "NATOID_FLYCATCHER"),
    /** FLYCATCHER MK 2 */
    FLYCATCHER_MK_2 (16035, "FLYCATCHER MK 2"),
    /** NATOID_Fly Screen */
    NATOID_FLY_SCREEN (16065, "NATOID_Fly Screen"),
    /** NATOID_Fly Screen AandB */
    NATOID_FLY_SCREEN_AB (16110, "NATOID_Fly Screen A&B"),
    /** NATOID_Fly Trap B */
    NATOID_FLY_TRAP_B (16155, "NATOID_Fly Trap B"),
    /** FM-90 */
    FM_90 (16160, "FM-90"),
    /** NATOID_Fog Lamp MG */
    NATOID_FOG_LAMP_MG (16200, "NATOID_Fog Lamp MG"),
    /** NATOID_Fog Lamp TT */
    NATOID_FOG_LAMP_TT (16245, "NATOID_Fog Lamp TT"),
    /** NATOID_Foil Two */
    NATOID_FOIL_TWO (16290, "NATOID_Foil Two"),
    /** FootBall */
    FOOTBALL (16300, "FootBall"),
    /** Fox Hunter */
    FOX_HUNTER (16335, "Fox Hunter"),
    /** NATOID_Fox Fire AL */
    NATOID_FOX_FIRE_AL (16380, "NATOID_Fox Fire AL"),
    /** NATOID_Fox Fire ILL */
    NATOID_FOX_FIRE_ILL (16390, "NATOID_Fox Fire ILL"),
    /** FR-151A */
    FR_151A (16400, "FR-151A"),
    /** COMMID_Furuno FR-1500FR-1600 */
    COMMID_FURUNO_FR_1500FR_1600 (16405, "COMMID_Furuno FR-1500FR-1600"),
    /** FR-1505 DA */
    FR_1505_DA (16410, "FR-1505 DA"),
    /** FR-1510DS */
    FR_1510DS (16412, "FR-1510DS"),
    /** FR-2000 */
    FR_2000 (16420, "FR-2000"),
    /** Furuno-2855W */
    FURUNO_2855W (16421, "Furuno-2855W"),
    /** COMMID_Fregat MAE */
    COMMID_FREGAT_MAE (16422, "COMMID_Fregat MAE"),
    /** COMMID_Fregat N1 */
    COMMID_FREGAT_N1 (16423, "COMMID_Fregat N1"),
    /** COMMID_Fregat N2 */
    COMMID_FREGAT_N2 (16424, "COMMID_Fregat N2"),
    /** NATOID_Front Dome */
    NATOID_FRONT_DOME (16425, "NATOID_Front Dome"),
    /** NATOID_Front Door */
    NATOID_FRONT_DOOR (16470, "NATOID_Front Door"),
    /** NATOID_Front Piece */
    NATOID_FRONT_PIECE (16515, "NATOID_Front Piece"),
    /** Furby mmW MH */
    FURBY_MMW_MH (16520, "Furby mmW MH"),
    /** NATOID_Furke */
    NATOID_FURKE (16550, "NATOID_Furke"),
    /** Furke-4 */
    FURKE_4 (16554, "Furke-4"),
    /** Furuno */
    FURUNO (16560, "Furuno"),
    /** Furuno 1721 */
    FURUNO_1721 (16561, "Furuno 1721"),
    /** COMMID_Furuno 1934C */
    COMMID_FURUNO_1934C (16564, "COMMID_Furuno 1934C"),
    /** COMMID_Furuno 1715 */
    COMMID_FURUNO_1715 (16565, "COMMID_Furuno 1715"),
    /** Furuno 1730 */
    FURUNO_1730 (16580, "Furuno 1730"),
    /** Furuno 1832 */
    FURUNO_1832 (16585, "Furuno 1832"),
    /** COMMID_Furuno 1835 */
    COMMID_FURUNO_1835 (16587, "COMMID_Furuno 1835"),
    /** Furuno 1932 */
    FURUNO_1932 (16590, "Furuno 1932"),
    /** COMMID_Furuno 1935 */
    COMMID_FURUNO_1935 (16596, "COMMID_Furuno 1935"),
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
    /** FR-801D */
    FR_801D (16725, "FR-801D"),
    /** Furuno 8051 */
    FURUNO_8051 (16730, "Furuno 8051"),
    /** COMMID_Furuno DRS-2D */
    COMMID_FURUNO_DRS_2D (16732, "COMMID_Furuno DRS-2D"),
    /** COMMID_Furuno DRS-4D */
    COMMID_FURUNO_DRS_4D (16733, "COMMID_Furuno DRS-4D"),
    /** COMMID_Furuno DRS-4A */
    COMMID_FURUNO_DRS_4A (16734, "COMMID_Furuno DRS-4A"),
    /** G030A(APD-31) */
    G030AAPD_31 (16735, "G030A(APD-31)"),
    /** GA 01 00 */
    GA_01_00 (16740, "GA 01 00"),
    /** NATOID_Gage */
    NATOID_GAGE (16785, "NATOID_Gage"),
    /** Gaofen-3 */
    GAOFEN_3 (16787, "Gaofen-3"),
    /** GAP GATE */
    GAP_GATE (16790, "GAP GATE"),
    /** NATOID_Gardenia */
    NATOID_GARDENIA (16800, "NATOID_Gardenia"),
    /** NATOID_Garpin */
    NATOID_GARPIN (16830, "NATOID_Garpin"),
    /** NATOID_Gate Guard */
    NATOID_GATE_GUARD (16833, "NATOID_Gate Guard"),
    /** Garpun-Bal-E */
    GARPUN_BAL_E (16835, "Garpun-Bal-E"),
    /** GBS1 */
    GBS1 (16840, "GBS1"),
    /** GCA-2000 */
    GCA_2000 (16850, "GCA-2000"),
    /** COMMID_Furuno 18321921 Series */
    COMMID_FURUNO_18321921_SERIES (16858, "COMMID_Furuno 18321921 Series"),
    /** COMMID_GEMINI-DB */
    COMMID_GEMINI_DB (16870, "COMMID_GEMINI-DB"),
    /** GEM BX 132 */
    GEM_BX_132 (16875, "GEM BX 132"),
    /** GEM SC-2050X */
    GEM_SC_2050X (16876, "GEM SC-2050X"),
    /** COMMID_GEM Sea Eagle 200 N */
    COMMID_GEM_SEA_EAGLE_200_N (16877, "COMMID_GEM Sea Eagle 200 N"),
    /** MPDR-12 */
    MPDR_12 (16880, "MPDR-12"),
    /** GEN-X */
    GEN_X (16881, "GEN-X"),
    /** NATOID_Gepard TT */
    NATOID_GEPARD_TT (16884, "NATOID_Gepard TT"),
    /** GERAN-F */
    GERAN_F (16888, "GERAN-F"),
    /** GERFAUT */
    GERFAUT (16890, "GERFAUT"),
    /** GFE(L)1 */
    GFEL1 (16895, "GFE(L)1"),
    /** GIRAFFE */
    GIRAFFE (16900, "GIRAFFE"),
    /** Giraffe-40 */
    GIRAFFE_40 (16905, "Giraffe-40"),
    /** Giraffe-50 AT */
    GIRAFFE_50_AT (16908, "Giraffe-50 AT"),
    /** Giraffe 75 */
    GIRAFFE_75 (16912, "Giraffe 75"),
    /** NATOID_Gin Sling TA */
    NATOID_GIN_SLING_TA (16915, "NATOID_Gin Sling TA"),
    /** Gin Sling */
    GIN_SLING (16920, "Gin Sling"),
    /** NATOID_Gin Sling MG */
    NATOID_GIN_SLING_MG (16925, "NATOID_Gin Sling MG"),
    /** Goal Keeper */
    GOAL_KEEPER (16930, "Goal Keeper"),
    /** NATOID_Golden Dome */
    NATOID_GOLDEN_DOME (16935, "NATOID_Golden Dome"),
    /** NATOID_Golden Heart */
    NATOID_GOLDEN_HEART (16940, "NATOID_Golden Heart"),
    /** NATOID_Golden Rock */
    NATOID_GOLDEN_ROCK (16942, "NATOID_Golden Rock"),
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
    /** GRAN-K */
    GRAN_K (16951, "GRAN-K"),
    /** NATOID_Grave Stone */
    NATOID_GRAVE_STONE (16960, "NATOID_Grave Stone"),
    /** GRAVES */
    GRAVES (16963, "GRAVES"),
    /** Green Stain */
    GREEN_STAIN (16965, "Green Stain"),
    /** NATOID_Grid Bow */
    NATOID_GRID_BOW (17010, "NATOID_Grid Bow"),
    /** Grifo-F */
    GRIFO_F (17016, "Grifo-F"),
    /** 9S32 */
    _9S32 (17025, "9S32"),
    /** NATOID_GRILL SCREEN */
    NATOID_GRILL_SCREEN (17027, "NATOID_GRILL SCREEN"),
    /** GROUND MASTER 400 */
    GROUND_MASTER_400 (17030, "GROUND MASTER 400"),
    /** GT-4 */
    GT_4 (17031, "GT-4"),
    /** GRS 440 */
    GRS_440 (17032, "GRS 440"),
    /** GUARDIAN */
    GUARDIAN (17050, "GUARDIAN"),
    /** Guardsman */
    GUARDSMAN (17055, "Guardsman"),
    /** RPK-2 */
    RPK_2 (17070, "RPK-2"),
    /** HADR */
    HADR (17080, "HADR"),
    /** NATOID_Hair Net */
    NATOID_HAIR_NET (17100, "NATOID_Hair Net"),
    /** NATOID_Half Plate A */
    NATOID_HALF_PLATE_A (17145, "NATOID_Half Plate A"),
    /** NATOID_Half Plate B */
    NATOID_HALF_PLATE_B (17190, "NATOID_Half Plate B"),
    /** HARD */
    HARD (17220, "HARD"),
    /** Harpoon */
    HARPOON (17225, "Harpoon"),
    /** NATOID_Hat Box */
    NATOID_HAT_BOX (17230, "NATOID_Hat Box"),
    /** NATOID_Hawk Screech */
    NATOID_HAWK_SCREECH (17235, "NATOID_Hawk Screech"),
    /** NATOID_Hay Pole */
    NATOID_HAY_POLE (17250, "NATOID_Hay Pole"),
    /** NATOID_Hay Rick */
    NATOID_HAY_RICK (17255, "NATOID_Hay Rick"),
    /** NATOID_Head Light A */
    NATOID_HEAD_LIGHT_A (17280, "NATOID_Head Light A"),
    /** NATOID_Head Lights */
    NATOID_HEAD_LIGHTS (17325, "NATOID_Head Lights"),
    /** NATOID_Head Lights C */
    NATOID_HEAD_LIGHTS_C (17370, "NATOID_Head Lights C"),
    /** NATOID_Head Lights MG A */
    NATOID_HEAD_LIGHTS_MG_A (17415, "NATOID_Head Lights MG A"),
    /** NATOID_Head Lights MG B */
    NATOID_HEAD_LIGHTS_MG_B (17460, "NATOID_Head Lights MG B"),
    /** NATOID_Head Lights TT */
    NATOID_HEAD_LIGHTS_TT (17505, "NATOID_Head Lights TT"),
    /** NATOID_Head Net */
    NATOID_HEAD_NET (17550, "NATOID_Head Net"),
    /** NATOID_Heart Ache B */
    NATOID_HEART_ACHE_B (17572, "NATOID_Heart Ache B"),
    /** Hellfire mmW MH */
    HELLFIRE_MMW_MH (17590, "Hellfire mmW MH"),
    /** NATOID_Hen Egg */
    NATOID_HEN_EGG (17595, "NATOID_Hen Egg"),
    /** NATOID_Hen House */
    NATOID_HEN_HOUSE (17640, "NATOID_Hen House"),
    /** NATOID_Hen Nest */
    NATOID_HEN_NEST (17685, "NATOID_Hen Nest"),
    /** NATOID_Hen Roost */
    NATOID_HEN_ROOST (17730, "NATOID_Hen Roost"),
    /** COMMID_Herakles */
    COMMID_HERAKLES (17732, "COMMID_Herakles"),
    /** HF-2 MG */
    HF_2_MG (17735, "HF-2 MG"),
    /** HGR-105 */
    HGR_105 (17745, "HGR-105"),
    /** NATOID_High Brick */
    NATOID_HIGH_BRICK (17775, "NATOID_High Brick"),
    /** NATOID_High Fix */
    NATOID_HIGH_FIX (17820, "NATOID_High Fix"),
    /** NATOID_High Guard */
    NATOID_HIGH_GUARD (17842, "NATOID_High Guard"),
    /** NATOID_High Lark TI */
    NATOID_HIGH_LARK_TI (17865, "NATOID_High Lark TI"),
    /** NATOID_High Lark 1 */
    NATOID_HIGH_LARK_1 (17910, "NATOID_High Lark 1"),
    /** NATOID_High Lark 2 */
    NATOID_HIGH_LARK_2 (17955, "NATOID_High Lark 2"),
    /** NATOID_High Lark 4 */
    NATOID_HIGH_LARK_4 (18000, "NATOID_High Lark 4"),
    /** NATOID_High Lune */
    NATOID_HIGH_LUNE (18045, "NATOID_High Lune"),
    /** NATOID_High Pole AandB */
    NATOID_HIGH_POLE_AB (18090, "NATOID_High Pole A&B"),
    /** NATOID_High Scoop */
    NATOID_HIGH_SCOOP (18135, "NATOID_High Scoop"),
    /** 9S19MT */
    _9S19MT (18150, "9S19MT"),
    /** NATOID_High Sieve */
    NATOID_HIGH_SIEVE (18180, "NATOID_High Sieve"),
    /** NATOID_Hill Block */
    NATOID_HILL_BLOCK (18185, "NATOID_Hill Block"),
    /** COMMID_HG-9550 */
    COMMID_HG_9550 (18190, "COMMID_HG-9550"),
    /** HJ-6374 */
    HJ_6374 (18193, "HJ-6374"),
    /** HLJQ-520 */
    HLJQ_520 (18195, "HLJQ-520"),
    /** HN-503 */
    HN_503 (18200, "HN-503"),
    /** HN-C03-M */
    HN_C03_M (18201, "HN-C03-M"),
    /** NATOID_Home Talk */
    NATOID_HOME_TALK (18225, "NATOID_Home Talk"),
    /** NATOID_Horn Spoon */
    NATOID_HORN_SPOON (18270, "NATOID_Horn Spoon"),
    /** NATOID_Hot Brick */
    NATOID_HOT_BRICK (18280, "NATOID_Hot Brick"),
    /** NATOID_Hot Flash */
    NATOID_HOT_FLASH (18315, "NATOID_Hot Flash"),
    /** NATOID_Hot Flash 2 */
    NATOID_HOT_FLASH_2 (18316, "NATOID_Hot Flash 2"),
    /** IHS-6 */
    IHS_6 (18318, "IHS-6"),
    /** IRL144M */
    IRL144M (18320, "IRL144M"),
    /** IRL144M */
    IRL144M_2 (18325, "IRL144M"),
    /** IRL144M */
    IRL144M_3 (18330, "IRL144M"),
    /** HPS-106 */
    HPS_106 (18331, "HPS-106"),
    /** HPS-104 */
    HPS_104 (18332, "HPS-104"),
    /** HQ-9 MH */
    HQ_9_MH (18339, "HQ-9 MH"),
    /** COMMID_HSR-1128 */
    COMMID_HSR_1128 (18340, "COMMID_HSR-1128"),
    /** HQ-61 */
    HQ_61 (18350, "HQ-61"),
    /** HRJS */
    HRJS (18351, "HRJS"),
    /** IBIS-80 */
    IBIS_80 (18353, "IBIS-80"),
    /** IBIS-150 */
    IBIS_150 (18355, "IBIS-150"),
    /** IBIS-200 */
    IBIS_200 (18357, "IBIS-200"),
    /** IFF MK XII AIMS UPX 29 */
    IFF_MK_XII_AIMS_UPX_29 (18360, "IFF MK XII AIMS UPX 29"),
    /** IFF MK XV */
    IFF_MK_XV (18405, "IFF MK XV"),
    /** IFF INT */
    IFF_INT (18406, "IFF INT"),
    /** NATOID_Jack Knife */
    NATOID_JACK_KNIFE (18407, "NATOID_Jack Knife"),
    /** IFF TRSP */
    IFF_TRSP (18408, "IFF TRSP"),
    /** Javelin MG */
    JAVELIN_MG (18410, "Javelin MG"),
    /** NATOID_Jay Bird */
    NATOID_JAY_BIRD (18450, "NATOID_Jay Bird"),
    /** J/FPS-3 */
    J_FPS_3 (18451, "J/FPS-3"),
    /** JH-10 */
    JH_10 (18452, "JH-10"),
    /** J/MPQ-P7 */
    J_MPQ_P7 (18453, "J/MPQ-P7"),
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
    /** JERS-1 */
    JERS_1 (18468, "JERS-1"),
    /** JINDALEE */
    JINDALEE (18469, "JINDALEE"),
    /** JRC JMA-9900 series */
    JRC_JMA_9900_SERIES (18470, "JRC JMA-9900 series"),
    /** JLP-40D */
    JLP_40D (18471, "JLP-40D"),
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
    /** JY-16 */
    JY_16 (18565, "JY-16"),
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
    /** JZ/QF-612 */
    JZ_QF_612 (18583, "JZ/QF-612"),
    /** NATOID_K376Z */
    NATOID_K376Z (18585, "NATOID_K376Z"),
    /** Kaige */
    KAIGE (18600, "Kaige"),
    /** KALKAN */
    KALKAN (18610, "KALKAN"),
    /** COMMID_Kelvin Hughes 2A */
    COMMID_KELVIN_HUGHES_2A (18630, "COMMID_Kelvin Hughes 2A"),
    /** COMMID_Kelvin Hughes 149 */
    COMMID_KELVIN_HUGHES_149 (18675, "COMMID_Kelvin Hughes 149"),
    /** NATOID_Karpaty */
    NATOID_KARPATY (18700, "NATOID_Karpaty"),
    /** COMMID_Kelvin Hughes type 1006 */
    COMMID_KELVIN_HUGHES_TYPE_1006 (18720, "COMMID_Kelvin Hughes type 1006"),
    /** COMMID_Kelvin Hughes type 1007 */
    COMMID_KELVIN_HUGHES_TYPE_1007 (18765, "COMMID_Kelvin Hughes type 1007"),
    /** COMMID_Kelvin Hughes Type 1007 F Band */
    COMMID_KELVIN_HUGHES_TYPE_1007_F_BAND (18766, "COMMID_Kelvin Hughes Type 1007 F Band"),
    /** COMMID_Kelvin Hughes 2007 F Band */
    COMMID_KELVIN_HUGHES_2007_F_BAND (18767, "COMMID_Kelvin Hughes 2007 F Band"),
    /** COMMID_Kelvin Hughes 2007 I Band */
    COMMID_KELVIN_HUGHES_2007_I_BAND (18768, "COMMID_Kelvin Hughes 2007 I Band"),
    /** COMMID_KH Nucleus 5000 */
    COMMID_KH_NUCLEUS_5000 (18770, "COMMID_KH Nucleus 5000"),
    /** COMMID_KH MANTA */
    COMMID_KH_MANTA (18774, "COMMID_KH MANTA"),
    /** COMMID_KH NUCLEUS 2 6000 */
    COMMID_KH_NUCLEUS_2_6000 (18775, "COMMID_KH NUCLEUS 2 6000"),
    /** COMMID_KH NUCLEUS 3 5000 */
    COMMID_KH_NUCLEUS_3_5000 (18776, "COMMID_KH NUCLEUS 3 5000"),
    /** COMMID_KH NUCLEUS 3 6000A */
    COMMID_KH_NUCLEUS_3_6000A (18777, "COMMID_KH NUCLEUS 3 6000A"),
    /** KH Family */
    KH_FAMILY (18780, "KH Family"),
    /** COMMID_Kelvin Hughes 6000A */
    COMMID_KELVIN_HUGHES_6000A (18781, "COMMID_Kelvin Hughes 6000A"),
    /** Kh-38MAE MH */
    KH_38MAE_MH (18782, "Kh-38MAE MH"),
    /** KG8605A */
    KG8605A (18784, "KG8605A"),
    /** KH-902M */
    KH_902M (18785, "KH-902M"),
    /** KHOROM-K */
    KHOROM_K (18786, "KHOROM-K"),
    /** KHIBINY */
    KHIBINY (18787, "KHIBINY"),
    /** KG300E */
    KG300E (18789, "KG300E"),
    /** COMMID_KH SharpEye */
    COMMID_KH_SHARPEYE (18790, "COMMID_KH SharpEye"),
    /** COMMID_KH Sharp Eye B */
    COMMID_KH_SHARP_EYE_B (18791, "COMMID_KH Sharp Eye B"),
    /** COMMID_KH Sharp Eye C */
    COMMID_KH_SHARP_EYE_C (18792, "COMMID_KH Sharp Eye C"),
    /** KH 1700 */
    KH_1700 (18795, "KH 1700"),
    /** NATOID_King Pin */
    NATOID_KING_PIN (18797, "NATOID_King Pin"),
    /** KG-300 */
    KG_300 (18805, "KG-300"),
    /** NATOID_Kite Screech */
    NATOID_KITE_SCREECH (18810, "NATOID_Kite Screech"),
    /** NATOID_Kite Screech A */
    NATOID_KITE_SCREECH_A (18855, "NATOID_Kite Screech A"),
    /** NATOID_Kite Screech B */
    NATOID_KITE_SCREECH_B (18900, "NATOID_Kite Screech B"),
    /** NATOID_Kivach */
    NATOID_KIVACH (18945, "NATOID_Kivach"),
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
    /** NATOID_Knife Rest */
    NATOID_KNIFE_REST (18990, "NATOID_Knife Rest"),
    /** P-10 */
    P_10 (19035, "P-10"),
    /** NATOID_KNIFE REST C */
    NATOID_KNIFE_REST_C (19037, "NATOID_KNIFE REST C"),
    /** COMMID_Koden MD 3730 */
    COMMID_KODEN_MD_3730 (19039, "COMMID_Koden MD 3730"),
    /** KJ-2000 */
    KJ_2000 (19040, "KJ-2000"),
    /** KOPYO-I */
    KOPYO_I (19045, "KOPYO-I"),
    /** KR-75 */
    KR_75 (19050, "KR-75"),
    /** KRONOS */
    KRONOS (19051, "KRONOS"),
    /** KREDO-1E */
    KREDO_1E (19052, "KREDO-1E"),
    /** Krasukha-2 */
    KRASUKHA_2 (19053, "Krasukha-2"),
    /** KRONOS GRAND NAVAL */
    KRONOS_GRAND_NAVAL (19054, "KRONOS GRAND NAVAL"),
    /** KRM-66E */
    KRM_66E (19060, "KRM-66E"),
    /** KSA SRN */
    KSA_SRN (19080, "KSA SRN"),
    /** KSA TSR */
    KSA_TSR (19125, "KSA TSR"),
    /** KS-1A PHASED ARRAY */
    KS_1A_PHASED_ARRAY (19127, "KS-1A PHASED ARRAY"),
    /** KS418 */
    KS418 (19129, "KS418"),
    /** KS418E */
    KS418E (19130, "KS418E"),
    /** KZ100 */
    KZ100 (19131, "KZ100"),
    /** KZ900 */
    KZ900 (19132, "KZ900"),
    /** L175V */
    L175V (19140, "L175V"),
    /** L-415 */
    L_415 (19143, "L-415"),
    /** L-88 */
    L_88 (19145, "L-88"),
    /** LAADS */
    LAADS (19150, "LAADS"),
    /** NATOID_Land Fall */
    NATOID_LAND_FALL (19170, "NATOID_Land Fall"),
    /** NATOID_Land Roll MG */
    NATOID_LAND_ROLL_MG (19215, "NATOID_Land Roll MG"),
    /** NATOID_Land Roll TA */
    NATOID_LAND_ROLL_TA (19260, "NATOID_Land Roll TA"),
    /** NATOID_Land Roll TT */
    NATOID_LAND_ROLL_TT (19305, "NATOID_Land Roll TT"),
    /** LAZUR */
    LAZUR (19306, "LAZUR"),
    /** Model 791-A */
    MODEL_791_A (19307, "Model 791-A"),
    /** LAP-3000 */
    LAP_3000 (19309, "LAP-3000"),
    /** LC-150 */
    LC_150 (19310, "LC-150"),
    /** LEER-3 */
    LEER_3 (19320, "LEER-3"),
    /** NATOID_Leg Drive */
    NATOID_LEG_DRIVE (19330, "NATOID_Leg Drive"),
    /** NATOID_Leningraf */
    NATOID_LENINGRAF (19350, "NATOID_Leningraf"),
    /** LIANA */
    LIANA (19370, "LIANA"),
    /** NATOID_Light Bulb */
    NATOID_LIGHT_BULB (19395, "NATOID_Light Bulb"),
    /** LIRA-A10 */
    LIRA_A10 (19396, "LIRA-A10"),
    /** LIROD 8 */
    LIROD_8 (19397, "LIROD 8"),
    /** LIROD MK II */
    LIROD_MK_II (19398, "LIROD MK II"),
    /** LLX05K */
    LLX05K (19399, "LLX05K"),
    /** LMT NRAI-6A */
    LMT_NRAI_6A (19400, "LMT NRAI-6A"),
    /** LN 55 */
    LN_55 (19440, "LN 55"),
    /** NATOID_Ln 66 */
    NATOID_LN_66 (19485, "NATOID_Ln 66"),
    /** NATOID_Liman */
    NATOID_LIMAN (19500, "NATOID_Liman"),
    /** NATOID_Liman 2 */
    NATOID_LIMAN_2 (19505, "NATOID_Liman 2"),
    /** NATOID_Long Bow */
    NATOID_LONG_BOW (19530, "NATOID_Long Bow"),
    /** NATOID_Long Brick */
    NATOID_LONG_BRICK (19575, "NATOID_Long Brick"),
    /** NATOID_Long Bull */
    NATOID_LONG_BULL (19620, "NATOID_Long Bull"),
    /** NATOID_Long Eye */
    NATOID_LONG_EYE (19665, "NATOID_Long Eye"),
    /** NATOID_Long Head */
    NATOID_LONG_HEAD (19710, "NATOID_Long Head"),
    /** NATOID_Long Talk */
    NATOID_LONG_TALK (19755, "NATOID_Long Talk"),
    /** NATOID_Long Track */
    NATOID_LONG_TRACK (19800, "NATOID_Long Track"),
    /** NATOID_Long Trough */
    NATOID_LONG_TROUGH (19845, "NATOID_Long Trough"),
    /** NATOID_Look Two */
    NATOID_LOOK_TWO (19890, "NATOID_Look Two"),
    /** LOPAR */
    LOPAR (19920, "LOPAR"),
    /** LORAN */
    LORAN (19935, "LORAN"),
    /** NATOID_Low Blow TA */
    NATOID_LOW_BLOW_TA (19950, "NATOID_Low Blow TA"),
    /** NATOID_Low Blow TT */
    NATOID_LOW_BLOW_TT (19955, "NATOID_Low Blow TT"),
    /** NATOID_Low Blow MG */
    NATOID_LOW_BLOW_MG (19960, "NATOID_Low Blow MG"),
    /** NATOID_Low Jack TT */
    NATOID_LOW_JACK_TT (19970, "NATOID_Low Jack TT"),
    /** NATOID_Low Jack MG */
    NATOID_LOW_JACK_MG (19971, "NATOID_Low Jack MG"),
    /** NATOID_Low Sieve */
    NATOID_LOW_SIEVE (19980, "NATOID_Low Sieve"),
    /** NATOID_Low Trough */
    NATOID_LOW_TROUGH (20025, "NATOID_Low Trough"),
    /** LR66 */
    LR66 (20029, "LR66"),
    /** LRA-900 */
    LRA_900 (20030, "LRA-900"),
    /** TRS-2050 */
    TRS_2050 (20040, "TRS-2050"),
    /** LW 01 */
    LW_01 (20060, "LW 01"),
    /** LW 08, Use 28485 value. */
    LW_08 (20070, "LW 08"),
    /** NATOID_M-1983 FCR */
    NATOID_M_1983_FCR (20090, "NATOID_M-1983 FCR"),
    /** M22-40 */
    M22_40 (20115, "M22-40"),
    /** M44 */
    M44 (20160, "M44"),
    /** NATOID_M401Z */
    NATOID_M401Z (20205, "NATOID_M401Z"),
    /** NATOID_M585Z */
    NATOID_M585Z (20250, "NATOID_M585Z"),
    /** NATOID_M588Z */
    NATOID_M588Z (20295, "NATOID_M588Z"),
    /** MA 1 IFF Portion */
    MA_1_IFF_PORTION (20340, "MA 1 IFF Portion"),
    /** MAD HACK */
    MAD_HACK (20350, "MAD HACK"),
    /** NATOID_MARELD */
    NATOID_MARELD (20360, "NATOID_MARELD"),
    /** COMMID_MA Type 909# */
    COMMID_MA_TYPE_909 (20385, "COMMID_MA Type 909#"),
    /** MARC S-152 */
    MARC_S_152 (20420, "MARC S-152"),
    /** COMMID_Marconi 1810 */
    COMMID_MARCONI_1810 (20430, "COMMID_Marconi 1810"),
    /** COMMID_Marconi Canada HC 75 */
    COMMID_MARCONI_CANADA_HC_75 (20475, "COMMID_Marconi Canada HC 75"),
    /** COMMID_Marconi S 713 */
    COMMID_MARCONI_S_713 (20495, "COMMID_Marconi S 713"),
    /** COMMID_Marconi S 1802 */
    COMMID_MARCONI_S_1802 (20520, "COMMID_Marconi S 1802"),
    /** COMMID_Marconi S247 */
    COMMID_MARCONI_S247 (20530, "COMMID_Marconi S247"),
    /** COMMID_Marconi S 810 */
    COMMID_MARCONI_S_810 (20565, "COMMID_Marconi S 810"),
    /** COMMID_Marconi SA 10 */
    COMMID_MARCONI_SA_10 (20585, "COMMID_Marconi SA 10"),
    /** COMMID_Marconi ST805 */
    COMMID_MARCONI_ST805 (20590, "COMMID_Marconi ST805"),
    /** COMMID_Marconi type 967 */
    COMMID_MARCONI_TYPE_967 (20610, "COMMID_Marconi type 967"),
    /** COMMID_Marconi type 968 */
    COMMID_MARCONI_TYPE_968 (20655, "COMMID_Marconi type 968"),
    /** COMMID_Marconi type 992 */
    COMMID_MARCONI_TYPE_992 (20700, "COMMID_Marconi type 992"),
    /** COMMID_Marconisignaal type 1022 */
    COMMID_MARCONISIGNAAL_TYPE_1022 (20745, "COMMID_Marconisignaal type 1022"),
    /** COMMID_Marconisignaal type 910 */
    COMMID_MARCONISIGNAAL_TYPE_910 (20790, "COMMID_Marconisignaal type 910"),
    /** COMMID_Marconisignaal type 911 */
    COMMID_MARCONISIGNAAL_TYPE_911 (20835, "COMMID_Marconisignaal type 911"),
    /** COMMID_Marconisignaal type 992R */
    COMMID_MARCONISIGNAAL_TYPE_992R (20880, "COMMID_Marconisignaal type 992R"),
    /** MARTELLO 743D */
    MARTELLO_743D (20890, "MARTELLO 743D"),
    /** MARTELLO S-723A */
    MARTELLO_S_723A (20895, "MARTELLO S-723A"),
    /** MASTER-A */
    MASTER_A (20897, "MASTER-A"),
    /** MELCO-3 */
    MELCO_3 (20915, "MELCO-3"),
    /** MELODI */
    MELODI (20917, "MELODI"),
    /** MERLIN */
    MERLIN (20918, "MERLIN"),
    /** COMMID_Northrop Grumman MESA */
    COMMID_NORTHROP_GRUMMAN_MESA (20920, "COMMID_Northrop Grumman MESA"),
    /** NATOID_Mesh Brick */
    NATOID_MESH_BRICK (20925, "NATOID_Mesh Brick"),
    /** METEOR 1500S */
    METEOR_1500S (20927, "METEOR 1500S"),
    /** METEOR 200 */
    METEOR_200 (20929, "METEOR 200"),
    /** METEOR 50DX */
    METEOR_50DX (20930, "METEOR 50DX"),
    /** METEOR 300 */
    METEOR_300 (20931, "METEOR 300"),
    /** MFR */
    MFR (20935, "MFR"),
    /** MFSR 2100/45 */
    MFSR_2100_45 (20940, "MFSR 2100/45"),
    /** MICA MH */
    MICA_MH (20942, "MICA MH"),
    /** Mineral-ME */
    MINERAL_ME (20945, "Mineral-ME"),
    /** Mirage ILL */
    MIRAGE_ILL (20950, "Mirage ILL"),
    /** MK 15 (Phalanx BLK 0) */
    MK_15_PHALANX_BLK_0 (20969, "MK 15 (Phalanx BLK 0)"),
    /** COMMID_MK 15 CIWS */
    COMMID_MK_15_CIWS (20970, "COMMID_MK 15 CIWS"),
    /** MK-23 */
    MK_23 (21015, "MK-23"),
    /** MK 23 TAS */
    MK_23_TAS (21060, "MK 23 TAS"),
    /** MK 25 */
    MK_25 (21105, "MK 25"),
    /** Mk-25 Mod-3 */
    MK_25_MOD_3 (21110, "Mk-25 Mod-3"),
    /** Mk 25 Mod 7 */
    MK_25_MOD_7 (21130, "Mk 25 Mod 7"),
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
    /** MM/APS-784 */
    MM_APS_784 (21390, "MM/APS-784"),
    /** MM/SPG-73 (RTN-12X) */
    MM_SPG_73_RTN_12X (21419, "MM/SPG-73 (RTN-12X)"),
    /** MM SPG 74 */
    MM_SPG_74 (21420, "MM SPG 74"),
    /** MM SPG 75 */
    MM_SPG_75 (21465, "MM SPG 75"),
    /** MM SPN 703 */
    MM_SPN_703 (21490, "MM SPN 703"),
    /** MM SPN-753B */
    MM_SPN_753B (21495, "MM SPN-753B"),
    /** MM/SPQ-3 */
    MM_SPQ_3 (21500, "MM/SPQ-3"),
    /** MM SPS 702 */
    MM_SPS_702 (21510, "MM SPS 702"),
    /** MM SPS 768 */
    MM_SPS_768 (21555, "MM SPS 768"),
    /** MM SPS 774 */
    MM_SPS_774 (21600, "MM SPS 774"),
    /** MM/SPS-791 (RAN-30X) */
    MM_SPS_791_RAN_30X (21610, "MM/SPS-791 (RAN-30X)"),
    /** MM SPS-794 (RAN-21S) */
    MM_SPS_794_RAN_21S (21615, "MM SPS-794 (RAN-21S)"),
    /** MM/SPS-798 (RAN-40L) */
    MM_SPS_798_RAN_40L (21620, "MM/SPS-798 (RAN-40L)"),
    /** MMSR */
    MMSR (21623, "MMSR"),
    /** Model-17C */
    MODEL_17C (21625, "Model-17C"),
    /** Moon 4 */
    MOON_4 (21645, "Moon 4"),
    /** NATOID_Moon Pie */
    NATOID_MOON_PIE (21646, "NATOID_Moon Pie"),
    /** MOON CONE */
    MOON_CONE (21647, "MOON CONE"),
    /** NATOID_Moon Rack */
    NATOID_MOON_RACK (21648, "NATOID_Moon Rack"),
    /** MOON FACE */
    MOON_FACE (21649, "MOON FACE"),
    /** NATOID_MMRS */
    NATOID_MMRS (21650, "NATOID_MMRS"),
    /** Model 360 */
    MODEL_360 (21655, "Model 360"),
    /** Model 378 */
    MODEL_378 (21660, "Model 378"),
    /** Model-970 */
    MODEL_970 (21661, "Model-970"),
    /** Model 974 */
    MODEL_974 (21665, "Model 974"),
    /** NATOID_Monument */
    NATOID_MONUMENT (21675, "NATOID_Monument"),
    /** NATOID_Mouse */
    NATOID_MOUSE (21680, "NATOID_Mouse"),
    /** MPDR 18/S */
    MPDR_18_S (21685, "MPDR 18/S"),
    /** MPDR 18 X */
    MPDR_18_X (21690, "MPDR 18 X"),
    /** MPDR 45/E */
    MPDR_45_E (21692, "MPDR 45/E"),
    /** MPR */
    MPR (21695, "MPR"),
    /** MPS-1 */
    MPS_1 (21697, "MPS-1"),
    /** NATOID_MR-231 MOD */
    NATOID_MR_231_MOD (21699, "NATOID_MR-231 MOD"),
    /** MR-1600 */
    MR_1600 (21700, "MR-1600"),
    /** MRR */
    MRR (21701, "MRR"),
    /** MR35 */
    MR35 (21702, "MR35"),
    /** MR36 */
    MR36 (21703, "MR36"),
    /** MRL-1 */
    MRL_1 (21704, "MRL-1"),
    /** MRL-4 */
    MRL_4 (21705, "MRL-4"),
    /** MRL-5 */
    MRL_5 (21706, "MRL-5"),
    /** MSAM */
    MSAM (21707, "MSAM"),
    /** MR-36A */
    MR_36A (21708, "MR-36A"),
    /** MSTAR */
    MSTAR (21709, "MSTAR"),
    /** MT-305X */
    MT_305X (21710, "MT-305X"),
    /** MR-10M1E */
    MR_10M1E (21711, "MR-10M1E"),
    /** NATOID_Muff Cob */
    NATOID_MUFF_COB (21735, "NATOID_Muff Cob"),
    /** Mushroom */
    MUSHROOM (21780, "Mushroom"),
    /** Mushroom 1 */
    MUSHROOM_1 (21825, "Mushroom 1"),
    /** Mushroom 2 */
    MUSHROOM_2 (21870, "Mushroom 2"),
    /** NATOID_Mushroom 3 */
    NATOID_MUSHROOM_3 (21871, "NATOID_Mushroom 3"),
    /** N-23 */
    N_23 (21872, "N-23"),
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
    /** N-25 */
    N_25 (21879, "N-25"),
    /** N920Z */
    N920Z (21880, "N920Z"),
    /** N001V */
    N001V (21881, "N001V"),
    /** NACOS RADARPILOT Platinum */
    NACOS_RADARPILOT_PLATINUM (21884, "NACOS RADARPILOT Platinum"),
    /** NATOID_Nampo B */
    NATOID_NAMPO_B (21885, "NATOID_Nampo B"),
    /** NAGIRA */
    NAGIRA (21886, "NAGIRA"),
    /** NATOID_Nanjing B */
    NATOID_NANJING_B (21890, "NATOID_Nanjing B"),
    /** NATOID_Nanjing C */
    NATOID_NANJING_C (21895, "NATOID_Nanjing C"),
    /** Nayada */
    NAYADA (21915, "Nayada"),
    /** NAYADA-5M */
    NAYADA_5M (21917, "NAYADA-5M"),
    /** NAYADA-5PV */
    NAYADA_5PV (21918, "NAYADA-5PV"),
    /** NEBO-M */
    NEBO_M (21919, "NEBO-M"),
    /** Nebo-SVU */
    NEBO_SVU (21920, "Nebo-SVU"),
    /** Neptun */
    NEPTUN (21960, "Neptun"),
    /** NIKE HERCULES MTR */
    NIKE_HERCULES_MTR (21970, "NIKE HERCULES MTR"),
    /** NATOID_NIKE TT */
    NATOID_NIKE_TT (21980, "NATOID_NIKE TT"),
    /** NJ-81E */
    NJ_81E (21983, "NJ-81E"),
    /** Normandie */
    NORMANDIE (21984, "Normandie"),
    /** NRJ-6A */
    NRJ_6A (21985, "NRJ-6A"),
    /** NOSTRADAMUS */
    NOSTRADAMUS (21986, "NOSTRADAMUS"),
    /** NPG-1240 */
    NPG_1240 (21987, "NPG-1240"),
    /** NPG-1460 */
    NPG_1460 (21988, "NPG-1460"),
    /** NPG-434 */
    NPG_434 (21989, "NPG-434"),
    /** NPG-630 */
    NPG_630 (21990, "NPG-630"),
    /** NPM-510 */
    NPM_510 (21991, "NPM-510"),
    /** NATOID_Nut Can */
    NATOID_NUT_CAN (21992, "NATOID_Nut Can"),
    /** NRBA 50 */
    NRBA_50 (22005, "NRBA 50"),
    /** NRBA 51 */
    NRBA_51 (22050, "NRBA 51"),
    /** NRBF 20A */
    NRBF_20A (22095, "NRBF 20A"),
    /** NRJ-5 */
    NRJ_5 (22110, "NRJ-5"),
    /** NUR-31 */
    NUR_31 (22127, "NUR-31"),
    /** NWS-3 */
    NWS_3 (22130, "NWS-3"),
    /** NATOID_Nysa B */
    NATOID_NYSA_B (22140, "NATOID_Nysa B"),
    /** NATOID_O524A */
    NATOID_O524A (22185, "NATOID_O524A"),
    /** NATOID_O580B */
    NATOID_O580B (22230, "NATOID_O580B"),
    /** NATOID_O625Z */
    NATOID_O625Z (22275, "NATOID_O625Z"),
    /** NATOID_O626Z */
    NATOID_O626Z (22320, "NATOID_O626Z"),
    /** Ocean Master */
    OCEAN_MASTER (22335, "Ocean Master"),
    /** COMMID_Ocean Master 400 */
    COMMID_OCEAN_MASTER_400 (22340, "COMMID_Ocean Master 400"),
    /** NATOID_Odd Group */
    NATOID_ODD_GROUP (22345, "NATOID_Odd Group"),
    /** NATOID_Odd Lot */
    NATOID_ODD_LOT (22365, "NATOID_Odd Lot"),
    /** NATOID_Odd Pair */
    NATOID_ODD_PAIR (22410, "NATOID_Odd Pair"),
    /** NATOID_Odd Rods */
    NATOID_ODD_RODS (22411, "NATOID_Odd Rods"),
    /** NATOID_Oka */
    NATOID_OKA (22455, "NATOID_Oka"),
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
    /** NATOID_One Eye */
    NATOID_ONE_EYE (22680, "NATOID_One Eye"),
    /** OP-28 */
    OP_28 (22690, "OP-28"),
    /** OPRL-4 */
    OPRL_4 (22695, "OPRL-4"),
    /** OPRM-71 */
    OPRM_71 (22696, "OPRM-71"),
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
    /** OPS-22 */
    OPS_22 (22736, "OPS-22"),
    /** OPS-24 */
    OPS_24 (22737, "OPS-24"),
    /** OPS-28 */
    OPS_28 (22740, "OPS-28"),
    /** OPS-28C */
    OPS_28C (22745, "OPS-28C"),
    /** OPS-39 */
    OPS_39 (22750, "OPS-39"),
    /** OPTIMA 3.2 */
    OPTIMA_32 (22760, "OPTIMA 3.2"),
    /** NATOID_OR-2 */
    NATOID_OR_2 (22770, "NATOID_OR-2"),
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
    /** NATOID_Owl Screech */
    NATOID_OWL_SCREECH (22950, "NATOID_Owl Screech"),
    /** P360Z */
    P360Z (22955, "P360Z"),
    /** P-14 */
    P_14 (22956, "P-14"),
    /** P-180U */
    P_180U (22957, "P-180U"),
    /** P-18-2 */
    P_18_2 (22959, "P-18-2"),
    /** PA-1660 */
    PA_1660 (22960, "PA-1660"),
    /** P-18M */
    P_18M (22961, "P-18M"),
    /** P-190U */
    P_190U (22962, "P-190U"),
    /** P-30 */
    P_30 (22963, "P-30"),
    /** P-18 MOD */
    P_18_MOD (22964, "P-18 MOD"),
    /** PAGE */
    PAGE (22970, "PAGE"),
    /** NATOID_Paint Box */
    NATOID_PAINT_BOX (22977, "NATOID_Paint Box"),
    /** NATOID_Palm Frond */
    NATOID_PALM_FROND (22995, "NATOID_Palm Frond"),
    /** NATOID_Modified Paint Box */
    NATOID_MODIFIED_PAINT_BOX (22998, "NATOID_Modified Paint Box"),
    /** NATOID_Palm Frond AB */
    NATOID_PALM_FROND_AB (23040, "NATOID_Palm Frond AB"),
    /** PAR-2 */
    PAR_2 (23045, "PAR-2"),
    /** PAR-2000 */
    PAR_2000 (23050, "PAR-2000"),
    /** PAR-2090C */
    PAR_2090C (23053, "PAR-2090C"),
    /** PAR-80 */
    PAR_80 (23055, "PAR-80"),
    /** NATOID_Pat Hand TT */
    NATOID_PAT_HAND_TT (23085, "NATOID_Pat Hand TT"),
    /** NATOID_Pat Hand MG */
    NATOID_PAT_HAND_MG (23095, "NATOID_Pat Hand MG"),
    /** PATRIOT */
    PATRIOT (23100, "PATRIOT"),
    /** NATOID_Patty Cake */
    NATOID_PATTY_CAKE (23130, "NATOID_Patty Cake"),
    /** NATOID_Pawn Cake */
    NATOID_PAWN_CAKE (23175, "NATOID_Pawn Cake"),
    /** PBR 4 Rubin */
    PBR_4_RUBIN (23220, "PBR 4 Rubin"),
    /** PCS 514 */
    PCS_514 (23240, "PCS 514"),
    /** NATOID_Pea Sticks */
    NATOID_PEA_STICKS (23265, "NATOID_Pea Sticks"),
    /** Pechora SC */
    PECHORA_SC (23295, "Pechora SC"),
    /** NATOID_Peel Cone */
    NATOID_PEEL_CONE (23310, "NATOID_Peel Cone"),
    /** NATOID_Peel Group */
    NATOID_PEEL_GROUP (23355, "NATOID_Peel Group"),
    /** NATOID_Peel Group A */
    NATOID_PEEL_GROUP_A (23400, "NATOID_Peel Group A"),
    /** NATOID_Peel Group B */
    NATOID_PEEL_GROUP_B (23445, "NATOID_Peel Group B"),
    /** NATOID_Peel Group MG */
    NATOID_PEEL_GROUP_MG (23450, "NATOID_Peel Group MG"),
    /** NATOID_Peel Pair */
    NATOID_PEEL_PAIR (23490, "NATOID_Peel Pair"),
    /** NATOID_Pelena */
    NATOID_PELENA (23500, "NATOID_Pelena"),
    /** PGZ07 */
    PGZ07 (23515, "PGZ07"),
    /** Phalanx */
    PHALANX (23525, "Phalanx"),
    /** COMMID_Philips 9LV 200 */
    COMMID_PHILIPS_9LV_200 (23535, "COMMID_Philips 9LV 200"),
    /** COMMID_Philips 9LV 331 */
    COMMID_PHILIPS_9LV_331 (23580, "COMMID_Philips 9LV 331"),
    /** COMMID_Philips LV 223 */
    COMMID_PHILIPS_LV_223 (23625, "COMMID_Philips LV 223"),
    /** COMMID_Philips Sea Giraffe 50 HC */
    COMMID_PHILIPS_SEA_GIRAFFE_50_HC (23670, "COMMID_Philips Sea Giraffe 50 HC"),
    /** PICOSAR */
    PICOSAR (23680, "PICOSAR"),
    /** COMMID_PILOT MK2 */
    COMMID_PILOT_MK2 (23685, "COMMID_PILOT MK2"),
    /** NATOID_Pin Jib */
    NATOID_PIN_JIB (23690, "NATOID_Pin Jib"),
    /** NATOID_Pin Tip */
    NATOID_PIN_TIP (23695, "NATOID_Pin Tip"),
    /** PL-11 */
    PL_11 (23700, "PL-11"),
    /** PL-12 */
    PL_12 (23701, "PL-12"),
    /** NATOID_Plank Shad */
    NATOID_PLANK_SHAD (23710, "NATOID_Plank Shad"),
    /** NATOID_Plank Shave */
    NATOID_PLANK_SHAVE (23715, "NATOID_Plank Shave"),
    /** NATOID_Plank Shave A */
    NATOID_PLANK_SHAVE_A (23760, "NATOID_Plank Shave A"),
    /** NATOID_Plank Shave B */
    NATOID_PLANK_SHAVE_B (23805, "NATOID_Plank Shave B"),
    /** NATOID_Plate Steer */
    NATOID_PLATE_STEER (23850, "NATOID_Plate Steer"),
    /** COMMID_Plessey AWS 1 */
    COMMID_PLESSEY_AWS_1 (23895, "COMMID_Plessey AWS 1"),
    /** COMMID_Plessey AWS-2 */
    COMMID_PLESSEY_AWS_2 (23925, "COMMID_Plessey AWS-2"),
    /** COMMID_Plessey AWS 4 */
    COMMID_PLESSEY_AWS_4 (23940, "COMMID_Plessey AWS 4"),
    /** COMMID_Plessey AWS 6 */
    COMMID_PLESSEY_AWS_6 (23985, "COMMID_Plessey AWS 6"),
    /** COMMID_Plessey RJ */
    COMMID_PLESSEY_RJ (23990, "COMMID_Plessey RJ"),
    /** COMMID_Plessey Type 904 */
    COMMID_PLESSEY_TYPE_904 (24020, "COMMID_Plessey Type 904"),
    /** COMMID_Plessey type 996 */
    COMMID_PLESSEY_TYPE_996 (24030, "COMMID_Plessey type 996"),
    /** Plessey AWS 9 */
    PLESSEY_AWS_9 (24035, "Plessey AWS 9"),
    /** NATOID_Plinth Net */
    NATOID_PLINTH_NET (24075, "NATOID_Plinth Net"),
    /** NATOID_Pluto */
    NATOID_PLUTO (24095, "NATOID_Pluto"),
    /** POHJANPALO */
    POHJANPALO (24100, "POHJANPALO"),
    /** Poliment-K */
    POLIMENT_K (24110, "Poliment-K"),
    /** POLLUX */
    POLLUX (24120, "POLLUX"),
    /** NATOID_Pop Group */
    NATOID_POP_GROUP (24165, "NATOID_Pop Group"),
    /** NATOID_Pop Group MG */
    NATOID_POP_GROUP_MG (24210, "NATOID_Pop Group MG"),
    /** NATOID_Pop Group TA */
    NATOID_POP_GROUP_TA (24255, "NATOID_Pop Group TA"),
    /** NATOID_Pop Group TT */
    NATOID_POP_GROUP_TT (24300, "NATOID_Pop Group TT"),
    /** NATOID_Pork Fist */
    NATOID_PORK_FIST (24320, "NATOID_Pork Fist"),
    /** NATOID_Pork Trough */
    NATOID_PORK_TROUGH (24345, "NATOID_Pork Trough"),
    /** Positive ME */
    POSITIVE_ME (24385, "Positive ME"),
    /** Positive-ME1.2 */
    POSITIVE_ME12 (24386, "Positive-ME1.2"),
    /** NATOID_Post Bow */
    NATOID_POST_BOW (24390, "NATOID_Post Bow"),
    /** NATOID_Post Lamp */
    NATOID_POST_LAMP (24435, "NATOID_Post Lamp"),
    /** NATOID_Pot Drum */
    NATOID_POT_DRUM (24480, "NATOID_Pot Drum"),
    /** NATOID_Pot Head */
    NATOID_POT_HEAD (24525, "NATOID_Pot Head"),
    /** NATOID_Pot Shot */
    NATOID_POT_SHOT (24535, "NATOID_Pot Shot"),
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
    /** PRIMUS 800 */
    PRIMUS_800 (24619, "PRIMUS 800"),
    /** COMMID_Primus 3000 */
    COMMID_PRIMUS_3000 (24620, "COMMID_Primus 3000"),
    /** PRORA */
    PRORA (24630, "PRORA"),
    /** PRS-2 */
    PRS_2 (24631, "PRS-2"),
    /** PRORA PA-1660 */
    PRORA_PA_1660 (24635, "PRORA PA-1660"),
    /** PS-15 */
    PS_15 (24640, "PS-15"),
    /** PS-05A */
    PS_05A (24650, "PS-05A"),
    /** PS 46 A */
    PS_46_A (24660, "PS 46 A"),
    /** PS 70 R */
    PS_70_R (24705, "PS 70 R"),
    /** PS-171/R */
    PS_171_R (24706, "PS-171/R"),
    /** PS-860 */
    PS_860 (24707, "PS-860"),
    /** PS-870 */
    PS_870 (24709, "PS-870"),
    /** PS-890 */
    PS_890 (24710, "PS-890"),
    /** NATOID_Puff Ball */
    NATOID_PUFF_BALL (24750, "NATOID_Puff Ball"),
    /** Quadradar VI */
    QUADRADAR_VI (24755, "Quadradar VI"),
    /** QW-1A */
    QW_1A (24757, "QW-1A"),
    /** PVS-200 */
    PVS_200 (24760, "PVS-200"),
    /** PVS 2000 */
    PVS_2000 (24761, "PVS 2000"),
    /** R 045 */
    R_045 (24769, "R 045"),
    /** R-76 */
    R_76 (24770, "R-76"),
    /** R-934B */
    R_934B (24771, "R-934B"),
    /** RA-20 */
    RA_20 (24772, "RA-20"),
    /** RA723 */
    RA723 (24774, "RA723"),
    /** R41XXX */
    R41XXX (24775, "R41XXX"),
    /** RAC-3D */
    RAC_3D (24776, "RAC-3D"),
    /** COMMID_RAC-30 */
    COMMID_RAC_30 (24780, "COMMID_RAC-30"),
    /** COMMID_Racal 1229 */
    COMMID_RACAL_1229 (24795, "COMMID_Racal 1229"),
    /** DECCA 1230 */
    DECCA_1230 (24800, "DECCA 1230"),
    /** COMMID_Racal AC 2690 BT */
    COMMID_RACAL_AC_2690_BT (24840, "COMMID_Racal AC 2690 BT"),
    /** COMMID_Racal Decca 1216 */
    COMMID_RACAL_DECCA_1216 (24885, "COMMID_Racal Decca 1216"),
    /** Racal-DECCA 20V90/9 */
    RACAL_DECCA_20V90_9 (24890, "Racal-DECCA 20V90/9"),
    /** COMMID_Racal Decca 360 */
    COMMID_RACAL_DECCA_360 (24930, "COMMID_Racal Decca 360"),
    /** COMMID_Racal Decca AC 1290 */
    COMMID_RACAL_DECCA_AC_1290 (24975, "COMMID_Racal Decca AC 1290"),
    /** COMMID_Racal Decca TM 1229 */
    COMMID_RACAL_DECCA_TM_1229 (25020, "COMMID_Racal Decca TM 1229"),
    /** COMMID_Racal Decca TM 1626 */
    COMMID_RACAL_DECCA_TM_1626 (25065, "COMMID_Racal Decca TM 1626"),
    /** COMMID_Racal DRBN 34A */
    COMMID_RACAL_DRBN_34A (25110, "COMMID_Racal DRBN 34A"),
    /** RADA MHR */
    RADA_MHR (25150, "RADA MHR"),
    /** COMMID_Radar 24 */
    COMMID_RADAR_24 (25155, "COMMID_Radar 24"),
    /** COMMID_RADARPILOT 1000 */
    COMMID_RADARPILOT_1000 (25170, "COMMID_RADARPILOT 1000"),
    /** COMMID_RADARPILOT 1100 */
    COMMID_RADARPILOT_1100 (25171, "COMMID_RADARPILOT 1100"),
    /** RAJENDRA */
    RAJENDRA (25180, "RAJENDRA"),
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
    /** RAT-31 DL */
    RAT_31_DL (25279, "RAT-31 DL"),
    /** RAT-31S */
    RAT_31S (25280, "RAT-31S"),
    /** RAT-8 S */
    RAT_8_S (25281, "RAT-8 S"),
    /** RAT-31 SL */
    RAT_31_SL (25282, "RAT-31 SL"),
    /** RATAC (LCT) */
    RATAC_LCT (25285, "RATAC (LCT)"),
    /** RAWL */
    RAWL (25286, "RAWL"),
    /** NATOID_Rattler */
    NATOID_RATTLER (25287, "NATOID_Rattler"),
    /** RAWS */
    RAWS (25288, "RAWS"),
    /** RAWL-02 */
    RAWL_02 (25289, "RAWL-02"),
    /** COMMID_Raytheon 1220 */
    COMMID_RAYTHEON_1220 (25290, "COMMID_Raytheon 1220"),
    /** RAWS-03 */
    RAWS_03 (25291, "RAWS-03"),
    /** COMMID_Raytheon 1210xx */
    COMMID_RAYTHEON_1210XX (25292, "COMMID_Raytheon 1210xx"),
    /** COMMID_Raytheon 1302 */
    COMMID_RAYTHEON_1302 (25300, "COMMID_Raytheon 1302"),
    /** COMMID_Raytheon 1500 */
    COMMID_RAYTHEON_1500 (25335, "COMMID_Raytheon 1500"),
    /** COMMID_Raytheon 1645 */
    COMMID_RAYTHEON_1645 (25380, "COMMID_Raytheon 1645"),
    /** COMMID_Raytheon 1650 */
    COMMID_RAYTHEON_1650 (25425, "COMMID_Raytheon 1650"),
    /** COMMID_Raytheon 1900 */
    COMMID_RAYTHEON_1900 (25470, "COMMID_Raytheon 1900"),
    /** COMMID_Raytheon 2502 */
    COMMID_RAYTHEON_2502 (25515, "COMMID_Raytheon 2502"),
    /** Raytheon Anschutz NautoScan NX */
    RAYTHEON_ANSCHUTZ_NAUTOSCAN_NX (25530, "Raytheon Anschutz NautoScan NX"),
    /** COMMID_Raytheon R41 */
    COMMID_RAYTHEON_R41 (25540, "COMMID_Raytheon R41"),
    /** COMMID_Raytheon RM 1025 6X */
    COMMID_RAYTHEON_RM_1025_6X (25545, "COMMID_Raytheon RM 1025 6X"),
    /** COMMID_Raytheon SL 72 */
    COMMID_RAYTHEON_SL_72 (25550, "COMMID_Raytheon SL 72"),
    /** COMMID_Raytheon TM 16506X */
    COMMID_RAYTHEON_TM_16506X (25560, "COMMID_Raytheon TM 16506X"),
    /** COMMID_Raytheon TM 166012S */
    COMMID_RAYTHEON_TM_166012S (25605, "COMMID_Raytheon TM 166012S"),
    /** RAY-1220XR */
    RAY_1220XR (25630, "RAY-1220XR"),
    /** COMMID_RAY-1401 */
    COMMID_RAY_1401 (25635, "COMMID_RAY-1401"),
    /** COMMID_Ray 2900 */
    COMMID_RAY_2900 (25650, "COMMID_Ray 2900"),
    /** COMMID_Raymarine RD218 */
    COMMID_RAYMARINE_RD218 (25694, "COMMID_Raymarine RD218"),
    /** COMMID_Raypath */
    COMMID_RAYPATH (25695, "COMMID_Raypath"),
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
    /** RDY-3 */
    RDY_3 (25762, "RDY-3"),
    /** RDS-86 */
    RDS_86 (25770, "RDS-86"),
    /** RDN 72 */
    RDN_72 (25785, "RDN 72"),
    /** RDR 1A */
    RDR_1A (25830, "RDR 1A"),
    /** RDR 1E */
    RDR_1E (25835, "RDR 1E"),
    /** RDR 4A */
    RDR_4A (25840, "RDR 4A"),
    /** RDR-150 */
    RDR_150 (25845, "RDR-150"),
    /** RDR-160XD */
    RDR_160XD (25850, "RDR-160XD"),
    /** RDR-230 HP */
    RDR_230_HP (25853, "RDR-230 HP"),
    /** RDR 1100 */
    RDR_1100 (25855, "RDR 1100"),
    /** RDR-1150 */
    RDR_1150 (25860, "RDR-1150"),
    /** RDR 1200 */
    RDR_1200 (25875, "RDR 1200"),
    /** RDR 1400 */
    RDR_1400 (25885, "RDR 1400"),
    /** RDR 1400 C */
    RDR_1400_C (25890, "RDR 1400 C"),
    /** RDR 1500 */
    RDR_1500 (25895, "RDR 1500"),
    /** NATOID_Rice Cake */
    NATOID_RICE_CAKE (25896, "NATOID_Rice Cake"),
    /** RDR 1600 */
    RDR_1600 (25897, "RDR 1600"),
    /** RDR 2000 */
    RDR_2000 (25898, "RDR 2000"),
    /** RDR 1700B */
    RDR_1700B (25899, "RDR 1700B"),
    /** Remora */
    REMORA (25900, "Remora"),
    /** Rice Field */
    RICE_FIELD (25901, "Rice Field"),
    /** REC-1A */
    REC_1A (25902, "REC-1A"),
    /** REC-1B */
    REC_1B (25903, "REC-1B"),
    /** REC-1C */
    REC_1C (25904, "REC-1C"),
    /** Resolve EAS */
    RESOLVE_EAS (25906, "Resolve EAS"),
    /** NATOID_Rice Cup C */
    NATOID_RICE_CUP_C (25907, "NATOID_Rice Cup C"),
    /** REL-6E */
    REL_6E (25908, "REL-6E"),
    /** REC-1 */
    REC_1 (25909, "REC-1"),
    /** NATOID_Rice Bowl */
    NATOID_RICE_BOWL (25910, "NATOID_Rice Bowl"),
    /** Improved Reporter */
    IMPROVED_REPORTER (25911, "Improved Reporter"),
    /** NATOID_Rice Bug */
    NATOID_RICE_BUG (25912, "NATOID_Rice Bug"),
    /** NATOID_Rice Cup */
    NATOID_RICE_CUP (25915, "NATOID_Rice Cup"),
    /** NATOID_Rice Lamp */
    NATOID_RICE_LAMP (25920, "NATOID_Rice Lamp"),
    /** REZONANS */
    REZONANS (25950, "REZONANS"),
    /** NATOID_Rice Pad */
    NATOID_RICE_PAD (25965, "NATOID_Rice Pad"),
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
    /** RIS-4C/A */
    RIS_4C_A (25974, "RIS-4C/A"),
    /** RL-2000 */
    RL_2000 (25975, "RL-2000"),
    /** RL-41 */
    RL_41 (25976, "RL-41"),
    /** RIR 778 */
    RIR_778 (25977, "RIR 778"),
    /** RISAT */
    RISAT (25978, "RISAT"),
    /** NATOID_Rice Scoop */
    NATOID_RICE_SCOOP (26008, "NATOID_Rice Scoop"),
    /** NATOID_Rice Screen */
    NATOID_RICE_SCREEN (26010, "NATOID_Rice Screen"),
    /** COMMID_DECCA RM 1070A */
    COMMID_DECCA_RM_1070A (26011, "COMMID_DECCA RM 1070A"),
    /** RM370BT */
    RM370BT (26015, "RM370BT"),
    /** COMMID_Rockwell Collins FMR-200X */
    COMMID_ROCKWELL_COLLINS_FMR_200X (26020, "COMMID_Rockwell Collins FMR-200X"),
    /** NATOID_RM-231-2 */
    NATOID_RM_231_2 (26040, "NATOID_RM-231-2"),
    /** NATOID_RM-231-3 */
    NATOID_RM_231_3 (26041, "NATOID_RM-231-3"),
    /** RMT 0100A */
    RMT_0100A (26043, "RMT 0100A"),
    /** RN-222 */
    RN_222 (26045, "RN-222"),
    /** ROLAND 2 */
    ROLAND_2 (26053, "ROLAND 2"),
    /** ROLAND BN */
    ROLAND_BN (26055, "ROLAND BN"),
    /** ROLAND MG */
    ROLAND_MG (26100, "ROLAND MG"),
    /** ROLAND TA */
    ROLAND_TA (26145, "ROLAND TA"),
    /** ROLAND TT */
    ROLAND_TT (26190, "ROLAND TT"),
    /** NATOID_Round Ball */
    NATOID_ROUND_BALL (26235, "NATOID_Round Ball"),
    /** RP-379D Tirada D */
    RP_379D_TIRADA_D (26236, "RP-379D Tirada D"),
    /** RP-3 */
    RP_3 (26237, "RP-3"),
    /** RP-4G */
    RP_4G (26238, "RP-4G"),
    /** NATOID_Round House */
    NATOID_ROUND_HOUSE (26280, "NATOID_Round House"),
    /** NATOID_Round House B */
    NATOID_ROUND_HOUSE_B (26325, "NATOID_Round House B"),
    /** RPR-117 */
    RPR_117 (26326, "RPR-117"),
    /** RS-02/50 */
    RS_02_50 (26327, "RS-02/50"),
    /** COMMID_RSR 210N */
    COMMID_RSR_210N (26328, "COMMID_RSR 210N"),
    /** RT-02/50 */
    RT_02_50 (26330, "RT-02/50"),
    /** RTA-4100 */
    RTA_4100 (26340, "RTA-4100"),
    /** RTN-1A */
    RTN_1A (26350, "RTN-1A"),
    /** RTN-25X */
    RTN_25X (26353, "RTN-25X"),
    /** RTS-6400 */
    RTS_6400 (26354, "RTS-6400"),
    /** NATOID_Ruby Rake */
    NATOID_RUBY_RAKE (26355, "NATOID_Ruby Rake"),
    /** NATOID_Rum Sling */
    NATOID_RUM_SLING (26360, "NATOID_Rum Sling"),
    /** NATOID_Rum Sling RO */
    NATOID_RUM_SLING_RO (26361, "NATOID_Rum Sling RO"),
    /** NATOID_Rum Sling TT */
    NATOID_RUM_SLING_TT (26362, "NATOID_Rum Sling TT"),
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
    /** RV-25 */
    RV_25 (26600, "RV-25"),
    /** RV-377 */
    RV_377 (26610, "RV-377"),
    /** RV UM */
    RV_UM (26640, "RV UM"),
    /** COMMID_RXN 2-60 */
    COMMID_RXN_2_60 (26660, "COMMID_RXN 2-60"),
    /** NATOID_Rye House */
    NATOID_RYE_HOUSE (26665, "NATOID_Rye House"),
    /** S-1810CD */
    S_1810CD (26670, "S-1810CD"),
    /** Sahab */
    SAHAB (26672, "Sahab"),
    /** Salamandre */
    SALAMANDRE (26673, "Salamandre"),
    /** COMMID_Samyung SMR-7200 */
    COMMID_SAMYUNG_SMR_7200 (26674, "COMMID_Samyung SMR-7200"),
    /** S1850M */
    S1850M (26675, "S1850M"),
    /** S-511 */
    S_511 (26676, "S-511"),
    /** S-512 */
    S_512 (26677, "S-512"),
    /** S-600 */
    S_600 (26678, "S-600"),
    /** S-604 */
    S_604 (26679, "S-604"),
    /** S-613 */
    S_613 (26681, "S-613"),
    /** S-631 */
    S_631 (26682, "S-631"),
    /** S-654 */
    S_654 (26683, "S-654"),
    /** S-669 */
    S_669 (26684, "S-669"),
    /** NATOID_SA 2 Guideline */
    NATOID_SA_2_GUIDELINE (26685, "NATOID_SA 2 Guideline"),
    /** S-244 */
    S_244 (26686, "S-244"),
    /** S-711 */
    S_711 (26687, "S-711"),
    /** NATOID_SA 3 Goa */
    NATOID_SA_3_GOA (26730, "NATOID_SA 3 Goa"),
    /** NATOID_SA 8 Gecko DT */
    NATOID_SA_8_GECKO_DT (26775, "NATOID_SA 8 Gecko DT"),
    /** NATOID_SA-12 TELAR ILL */
    NATOID_SA_12_TELAR_ILL (26795, "NATOID_SA-12 TELAR ILL"),
    /** SABER-M60 */
    SABER_M60 (26799, "SABER-M60"),
    /** Samovar */
    SAMOVAR (26805, "Samovar"),
    /** Sampson */
    SAMPSON (26810, "Sampson"),
    /** NATOID_SA N 7 Gadfly TI */
    NATOID_SA_N_7_GADFLY_TI (26820, "NATOID_SA N 7 Gadfly TI"),
    /** NATOID_SA N 11 Cads 1 UN */
    NATOID_SA_N_11_CADS_1_UN (26865, "NATOID_SA N 11 Cads 1 UN"),
    /** Saccade MH */
    SACCADE_MH (26900, "Saccade MH"),
    /** NATOID_Salt Pot AandB */
    NATOID_SALT_POT_AB (26910, "NATOID_Salt Pot A&B"),
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
    /** SATRAPE */
    SATRAPE (26950, "SATRAPE"),
    /** SATURNE II */
    SATURNE_II (26955, "SATURNE II"),
    /** NATOID_Scan Can */
    NATOID_SCAN_CAN (27000, "NATOID_Scan Can"),
    /** NATOID_Scan Fix */
    NATOID_SCAN_FIX (27045, "NATOID_Scan Fix"),
    /** NATOID_Scan Odd */
    NATOID_SCAN_ODD (27090, "NATOID_Scan Odd"),
    /** SCANTER 1002 */
    SCANTER_1002 (27095, "SCANTER 1002"),
    /** COMMID_SCANTER 2001 */
    COMMID_SCANTER_2001 (27100, "COMMID_SCANTER 2001"),
    /** COMMID_SCANTER 2002 */
    COMMID_SCANTER_2002 (27101, "COMMID_SCANTER 2002"),
    /** COMMID_SCANTER 2100 */
    COMMID_SCANTER_2100 (27102, "COMMID_SCANTER 2100"),
    /** SCANTER 4002 */
    SCANTER_4002 (27109, "SCANTER 4002"),
    /** COMMID_SCANTER 4100 */
    COMMID_SCANTER_4100 (27110, "COMMID_SCANTER 4100"),
    /** SCANTER 5102 */
    SCANTER_5102 (27111, "SCANTER 5102"),
    /** SCANTER 5502 */
    SCANTER_5502 (27113, "SCANTER 5502"),
    /** COMMID_SCANTER 6000 */
    COMMID_SCANTER_6000 (27115, "COMMID_SCANTER 6000"),
    /** COMMID_SCANTER 6002 */
    COMMID_SCANTER_6002 (27116, "COMMID_SCANTER 6002"),
    /** COMMID_Scanter Mil 009 */
    COMMID_SCANTER_MIL_009 (27125, "COMMID_Scanter Mil 009"),
    /** NATOID_Scan Three */
    NATOID_SCAN_THREE (27135, "NATOID_Scan Three"),
    /** SCANTER MIL S */
    SCANTER_MIL_S (27137, "SCANTER MIL S"),
    /** Scanter SMR */
    SCANTER_SMR (27139, "Scanter SMR"),
    /** SCANTER (CSR) */
    SCANTER_CSR (27140, "SCANTER (CSR)"),
    /** SCORADS */
    SCORADS (27141, "SCORADS"),
    /** STAR 2000 */
    STAR_2000 (27143, "STAR 2000"),
    /** NATOID_SCOREBOARD */
    NATOID_SCOREBOARD (27150, "NATOID_SCOREBOARD"),
    /** NATOID_Scoup Plate */
    NATOID_SCOUP_PLATE (27180, "NATOID_Scoup Plate"),
    /** COMMID_SCOUT */
    COMMID_SCOUT (27183, "COMMID_SCOUT"),
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
    /** SEA FALCON */
    SEA_FALCON (27245, "SEA FALCON"),
    /** COMMID_Sea Giraffe AMB */
    COMMID_SEA_GIRAFFE_AMB (27248, "COMMID_Sea Giraffe AMB"),
    /** COMMID_Seaguard */
    COMMID_SEAGUARD (27251, "COMMID_Seaguard"),
    /** Sea Hunter 4 MG */
    SEA_HUNTER_4_MG (27270, "Sea Hunter 4 MG"),
    /** Sea Hunter 4 TA */
    SEA_HUNTER_4_TA (27315, "Sea Hunter 4 TA"),
    /** Sea Hunter 4 TT */
    SEA_HUNTER_4_TT (27360, "Sea Hunter 4 TT"),
    /** NATOID_Sea Gull */
    NATOID_SEA_GULL (27405, "NATOID_Sea Gull"),
    /** COMMID_Sea Master 400 */
    COMMID_SEA_MASTER_400 (27430, "COMMID_Sea Master 400"),
    /** NATOID_Sea Net */
    NATOID_SEA_NET (27450, "NATOID_Sea Net"),
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
    /** SEASONDE */
    SEASONDE (27580, "SEASONDE"),
    /** SEASPRAY 7000E */
    SEASPRAY_7000E (27582, "SEASPRAY 7000E"),
    /** SeaVue */
    SEAVUE (27583, "SeaVue"),
    /** COMMID_Seaspray Mk3 */
    COMMID_SEASPRAY_MK3 (27584, "COMMID_Seaspray Mk3"),
    /** COMMID_Selenia Orion 7 */
    COMMID_SELENIA_ORION_7 (27585, "COMMID_Selenia Orion 7"),
    /** COMMID_Selenia type 912 */
    COMMID_SELENIA_TYPE_912 (27630, "COMMID_Selenia type 912"),
    /** COMMID_Selennia RAN 12 LX */
    COMMID_SELENNIA_RAN_12_LX (27675, "COMMID_Selennia RAN 12 LX"),
    /** Selenia RAN 20S */
    SELENIA_RAN_20S (27680, "Selenia RAN 20S"),
    /** COMMID_Selennia RTN 10X */
    COMMID_SELENNIA_RTN_10X (27720, "COMMID_Selennia RTN 10X"),
    /** COMMID_Selinia ARP 1645 */
    COMMID_SELINIA_ARP_1645 (27765, "COMMID_Selinia ARP 1645"),
    /** SENTIR-M20 */
    SENTIR_M20 (27770, "SENTIR-M20"),
    /** SERHAT */
    SERHAT (27773, "SERHAT"),
    /** COMMID_Series 10 Compact Submarine Radar (CSR) */
    COMMID_SERIES_10_COMPACT_SUBMARINE_RADAR_CSR (27775, "COMMID_Series 10 Compact Submarine Radar (CSR)"),
    /** SERIES 52 */
    SERIES_52 (27780, "SERIES 52"),
    /** SERIES 320 */
    SERIES_320 (27790, "SERIES 320"),
    /** SG */
    SG (27800, "SG"),
    /** NATOID_SGJ-02 */
    NATOID_SGJ_02 (27802, "NATOID_SGJ-02"),
    /** NATOID_SGJ-03 */
    NATOID_SGJ_03 (27803, "NATOID_SGJ-03"),
    /** SGR 102 00 */
    SGR_102_00 (27810, "SGR 102 00"),
    /** SGR 103/02 */
    SGR_103_02 (27855, "SGR 103/02"),
    /** SGR-104 */
    SGR_104 (27870, "SGR-104"),
    /** SHAHINE */
    SHAHINE (27875, "SHAHINE"),
    /** NATOID_Sheet Bend */
    NATOID_SHEET_BEND (27900, "NATOID_Sheet Bend"),
    /** NATOID_Sheet Curve */
    NATOID_SHEET_CURVE (27945, "NATOID_Sheet Curve"),
    /** SHIKRA */
    SHIKRA (27980, "SHIKRA"),
    /** NATOID_Ship Globe */
    NATOID_SHIP_GLOBE (27990, "NATOID_Ship Globe"),
    /** NATOID_Ship Wheel */
    NATOID_SHIP_WHEEL (28035, "NATOID_Ship Wheel"),
    /** SGR 114 */
    SGR_114 (28080, "SGR 114"),
    /** NATOID_Shore Walk A */
    NATOID_SHORE_WALK_A (28125, "NATOID_Shore Walk A"),
    /** NATOID_Short Horn */
    NATOID_SHORT_HORN (28170, "NATOID_Short Horn"),
    /** NATOID_Shot Dome */
    NATOID_SHOT_DOME (28215, "NATOID_Shot Dome"),
    /** NATOID_Side Globe JN */
    NATOID_SIDE_GLOBE_JN (28260, "NATOID_Side Globe JN"),
    /** PRV-11 */
    PRV_11 (28280, "PRV-11"),
    /** NATOID_Side Walk A */
    NATOID_SIDE_WALK_A (28305, "NATOID_Side Walk A"),
    /** COMMID_Signaal DA 02 */
    COMMID_SIGNAAL_DA_02 (28350, "COMMID_Signaal DA 02"),
    /** COMMID_Signaal DA 05 */
    COMMID_SIGNAAL_DA_05 (28395, "COMMID_Signaal DA 05"),
    /** COMMID_Signaal DA 08 */
    COMMID_SIGNAAL_DA_08 (28440, "COMMID_Signaal DA 08"),
    /** COMMID_Signaal DA 082LS */
    COMMID_SIGNAAL_DA_082LS (28445, "COMMID_Signaal DA 082LS"),
    /** COMMID_Signaal LW 04 */
    COMMID_SIGNAAL_LW_04 (28480, "COMMID_Signaal LW 04"),
    /** COMMID_Signaal LW 08 */
    COMMID_SIGNAAL_LW_08 (28485, "COMMID_Signaal LW 08"),
    /** COMMID_Signaal LWOR */
    COMMID_SIGNAAL_LWOR (28530, "COMMID_Signaal LWOR"),
    /** COMMID_Signaal M45 */
    COMMID_SIGNAAL_M45 (28575, "COMMID_Signaal M45"),
    /** COMMID_Signaal MW 08 */
    COMMID_SIGNAAL_MW_08 (28620, "COMMID_Signaal MW 08"),
    /** COMMID_Signaal SMART */
    COMMID_SIGNAAL_SMART (28665, "COMMID_Signaal SMART"),
    /** COMMID_Signaal STING */
    COMMID_SIGNAAL_STING (28710, "COMMID_Signaal STING"),
    /** COMMID_Signaal STIR */
    COMMID_SIGNAAL_STIR (28755, "COMMID_Signaal STIR"),
    /** COMMID_Signaal STIR 1.8M */
    COMMID_SIGNAAL_STIR_18M (28760, "COMMID_Signaal STIR 1.8M"),
    /** COMMID_Signaal STIR 24M */
    COMMID_SIGNAAL_STIR_24M (28770, "COMMID_Signaal STIR 24M"),
    /** COMMID_Signaal WM 202 */
    COMMID_SIGNAAL_WM_202 (28800, "COMMID_Signaal WM 202"),
    /** COMMID_Signaal WM 25 */
    COMMID_SIGNAAL_WM_25 (28845, "COMMID_Signaal WM 25"),
    /** COMMID_Signaal WM 27 */
    COMMID_SIGNAAL_WM_27 (28890, "COMMID_Signaal WM 27"),
    /** COMMID_Signaal WM 28 */
    COMMID_SIGNAAL_WM_28 (28935, "COMMID_Signaal WM 28"),
    /** COMMID_Signaal ZW 01 */
    COMMID_SIGNAAL_ZW_01 (28980, "COMMID_Signaal ZW 01"),
    /** COMMID_Signaal ZW 06 */
    COMMID_SIGNAAL_ZW_06 (29025, "COMMID_Signaal ZW 06"),
    /** COMMID_Signaal ZW 07 */
    COMMID_SIGNAAL_ZW_07 (29030, "COMMID_Signaal ZW 07"),
    /** COMMID_Signaal ZW 0800 */
    COMMID_SIGNAAL_ZW_0800 (29035, "COMMID_Signaal ZW 0800"),
    /** SIMRAD 3G */
    SIMRAD_3G (29043, "SIMRAD 3G"),
    /** SIMRAD 4G */
    SIMRAD_4G (29045, "SIMRAD 4G"),
    /** COMMID_Simrad CA54 */
    COMMID_SIMRAD_CA54 (29050, "COMMID_Simrad CA54"),
    /** NATOID_Ski Pole */
    NATOID_SKI_POLE (29070, "NATOID_Ski Pole"),
    /** NATOID_Skin Head */
    NATOID_SKIN_HEAD (29115, "NATOID_Skin Head"),
    /** NATOID_Skip Spin */
    NATOID_SKIP_SPIN (29160, "NATOID_Skip Spin"),
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
    /** NATOID_Sky Watch */
    NATOID_SKY_WATCH (29205, "NATOID_Sky Watch"),
    /** Sky Ranger */
    SKY_RANGER (29210, "Sky Ranger"),
    /** COMMID_SKYSHADOW */
    COMMID_SKYSHADOW (29215, "COMMID_SKYSHADOW"),
    /** SKYSHIELD TA */
    SKYSHIELD_TA (29220, "SKYSHIELD TA"),
    /** SL */
    SL (29250, "SL"),
    /** SL/ALQ-234 */
    SL_ALQ_234 (29270, "SL/ALQ-234"),
    /** NATOID_Slap Shot */
    NATOID_SLAP_SHOT (29295, "NATOID_Slap Shot"),
    /** NATOID_Slap Shot G */
    NATOID_SLAP_SHOT_G (29297, "NATOID_Slap Shot G"),
    /** SLC-2 */
    SLC_2 (29300, "SLC-2"),
    /** SLC-4 */
    SLC_4 (29305, "SLC-4"),
    /** NATOID_Slim Net */
    NATOID_SLIM_NET (29340, "NATOID_Slim Net"),
    /** NATOID_Slot Back A */
    NATOID_SLOT_BACK_A (29385, "NATOID_Slot Back A"),
    /** NATOID_Slot Back ILL */
    NATOID_SLOT_BACK_ILL (29400, "NATOID_Slot Back ILL"),
    /** NATOID_Slot Back B */
    NATOID_SLOT_BACK_B (29430, "NATOID_Slot Back B"),
    /** NATOID_Slot Back IV */
    NATOID_SLOT_BACK_IV (29431, "NATOID_Slot Back IV"),
    /** NATOID_Slot Back B Topaz */
    NATOID_SLOT_BACK_B_TOPAZ (29432, "NATOID_Slot Back B Topaz"),
    /** NATOID_Slot Back E */
    NATOID_SLOT_BACK_E (29433, "NATOID_Slot Back E"),
    /** NATOID_Slot Back G */
    NATOID_SLOT_BACK_G (29434, "NATOID_Slot Back G"),
    /** NATOID_Slot Back VI */
    NATOID_SLOT_BACK_VI (29435, "NATOID_Slot Back VI"),
    /** NATOID_Slot Rest */
    NATOID_SLOT_REST (29440, "NATOID_Slot Rest"),
    /** SM-674A/UPM */
    SM_674A_UPM (29450, "SM-674A/UPM"),
    /** COMMID_SMA 3 RM */
    COMMID_SMA_3_RM (29475, "COMMID_SMA 3 RM"),
    /** COMMID_SMA 3 RM 20 */
    COMMID_SMA_3_RM_20 (29520, "COMMID_SMA 3 RM 20"),
    /** COMMID_SMA 3RM 20ASMG */
    COMMID_SMA_3RM_20ASMG (29565, "COMMID_SMA 3RM 20ASMG"),
    /** COMMID_SMA BPS 704 */
    COMMID_SMA_BPS_704 (29610, "COMMID_SMA BPS 704"),
    /** COMMID_SMA SPIN 749 (V) 2 */
    COMMID_SMA_SPIN_749_V_2 (29655, "COMMID_SMA SPIN 749 (V) 2"),
    /** COMMID_SMA SPN 703 */
    COMMID_SMA_SPN_703 (29700, "COMMID_SMA SPN 703");

    private int value;
    private final String description;

    /** Constructor */
    EmitterName(int value, String description)
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
    public static EmitterName getEnumForValue(int i)
    {
       for(EmitterName val: EmitterName.values()) {
          if(val.getValue()==i)
              return val;
       }
       System.out.flush(); // ensure contiguous console outputs
       System.err.println("No enumeration found for value " + i + " of enumeration EmitterName");
       System.err.flush(); // ensure contiguous console outputs
       return null;
    }

    /** Marshal value to DataOutputStream
     * @see <a href="https://en.wikipedia.org/wiki/Marshalling_(computer_science)" target="_blank">https://en.wikipedia.org/wiki/Marshalling_(computer_science)</a>
     * @param dos DataOutputStream for output
     * @throws IOException input-output error */
    public void marshal(DataOutputStream dos) throws IOException
    {
        dos.writeShort(getValue());
    }

    /** Marshal value to ByteBuffer
     * @see <a href="https://en.wikipedia.org/wiki/Marshalling_(computer_science)" target="_blank">https://en.wikipedia.org/wiki/Marshalling_(computer_science)</a>
     * @param byteBuffer ByteBuffer for output
     * @throws IOException input-output error */
    public void marshal(ByteBuffer byteBuffer) throws Exception
    {
        byteBuffer.putShort((short)getValue());
    }
    /** Unmarshal value to DataInputStream
     * @see <a href="https://en.wikipedia.org/wiki/Marshalling_(computer_science)" target="_blank">https://en.wikipedia.org/wiki/Marshalling_(computer_science)</a>
     * @param dis DataInputStream for input
     * @throws Exception unmarshalling input-output error
     * @return enumeration of interest */
    public static EmitterName unmarshalEnum (DataInputStream dis) throws Exception
    {
        return getEnumForValue(dis.readUnsignedShort());
    } 

    /** Unmarshal enumeration value to ByteBuffer
     * @see <a href="https://en.wikipedia.org/wiki/Marshalling_(computer_science)" target="_blank">https://en.wikipedia.org/wiki/Marshalling_(computer_science)</a>
     * @param byteBuffer ByteBuffer for input
     * @throws Exception unmarshalling input-output error
     * @return enumeration of interest */
    public static EmitterName unmarshalEnum (ByteBuffer byteBuffer) throws Exception
    {
        return getEnumForValue(byteBuffer.getShort());
    }   

  /**
   * Returns size of this serialized (marshalled) object in bytes
   * @see <a href="https://en.wikipedia.org/wiki/Marshalling_(computer_science)" target="_blank">https://en.wikipedia.org/wiki/Marshalling_(computer_science)</a>
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
        return "EmitterName " + getValue() + " " + name(); 
    }
}
