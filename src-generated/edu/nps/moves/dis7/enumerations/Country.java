package edu.nps.moves.dis7.enumerations;

import java.nio.ByteBuffer;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import edu.nps.moves.dis7.pdus.*;

/**
 * Generated from XML, SISO-REF-010-v28, 2020-05-07<br>
 * UID 29 marshal size 16<br>
 * Country
 */
public enum Country 
{
    /** Other */
    OTHER (0, "Other"),
    /** Afghanistan (AFG) */
    AFGHANISTAN_AFG (1, "Afghanistan (AFG)"),
    /** Albania (ALB) */
    ALBANIA_ALB (2, "Albania (ALB)"),
    /** Algeria (DZA) */
    ALGERIA_DZA (3, "Algeria (DZA)"),
    /** American Samoa (ASM) */
    AMERICAN_SAMOA_ASM (4, "American Samoa (ASM)"),
    /** Andorra (AND) */
    ANDORRA_AND (5, "Andorra (AND)"),
    /** Angola (AGO) */
    ANGOLA_AGO (6, "Angola (AGO)"),
    /** Anguilla (AIA) */
    ANGUILLA_AIA (7, "Anguilla (AIA)"),
    /** Antarctica (ATA) */
    ANTARCTICA_ATA (8, "Antarctica (ATA)"),
    /** Antigua and Barbuda (ATG) */
    ANTIGUA_AND_BARBUDA_ATG (9, "Antigua and Barbuda (ATG)"),
    /** Argentina (ARG) */
    ARGENTINA_ARG (10, "Argentina (ARG)"),
    /** Aruba (ABW) */
    ARUBA_ABW (11, "Aruba (ABW)"),
    /** Ashmore and Cartier Islands (Australia), Use Australia */
    ASHMORE_AND_CARTIER_ISLANDS_AUSTRALIA (12, "Ashmore and Cartier Islands (Australia)"),
    /** Australia (AUS) */
    AUSTRALIA_AUS (13, "Australia (AUS)"),
    /** Austria (AUT) */
    AUSTRIA_AUT (14, "Austria (AUT)"),
    /** Bahamas (BHS) */
    BAHAMAS_BHS (15, "Bahamas (BHS)"),
    /** Bahrain (BHR) */
    BAHRAIN_BHR (16, "Bahrain (BHR)"),
    /** Baker Island (United States), Use United States Minor Outlying Islands */
    BAKER_ISLAND_UNITED_STATES (17, "Baker Island (United States)"),
    /** Bangladesh (BGD) */
    BANGLADESH_BGD (18, "Bangladesh (BGD)"),
    /** Barbados (BRB) */
    BARBADOS_BRB (19, "Barbados (BRB)"),
    /** Bassas da India (France), Use French Southern Territories */
    BASSAS_DA_INDIA_FRANCE (20, "Bassas da India (France)"),
    /** Belgium (BEL) */
    BELGIUM_BEL (21, "Belgium (BEL)"),
    /** Belize (BLZ) */
    BELIZE_BLZ (22, "Belize (BLZ)"),
    /** Benin (BEN) */
    BENIN_BEN (23, "Benin (BEN)"),
    /** Bermuda (BMU) */
    BERMUDA_BMU (24, "Bermuda (BMU)"),
    /** Bhutan (BTN) */
    BHUTAN_BTN (25, "Bhutan (BTN)"),
    /** Bolivia (Plurinational State of) (BOL) */
    BOLIVIA_PLURINATIONAL_STATE_OF_BOL (26, "Bolivia (Plurinational State of) (BOL)"),
    /** Botswana (BWA) */
    BOTSWANA_BWA (27, "Botswana (BWA)"),
    /** Bouvet Island (BVT) */
    BOUVET_ISLAND_BVT (28, "Bouvet Island (BVT)"),
    /** Brazil (BRA) */
    BRAZIL_BRA (29, "Brazil (BRA)"),
    /** British Indian Ocean Territory (IOT) */
    BRITISH_INDIAN_OCEAN_TERRITORY_IOT (30, "British Indian Ocean Territory (IOT)"),
    /** Virgin Islands (British) (VGB) */
    VIRGIN_ISLANDS_BRITISH_VGB (31, "Virgin Islands (British) (VGB)"),
    /** Brunei Darussalam (BRN) */
    BRUNEI_DARUSSALAM_BRN (32, "Brunei Darussalam (BRN)"),
    /** Bulgaria (BGR) */
    BULGARIA_BGR (33, "Bulgaria (BGR)"),
    /** Burkina Faso (BFA) */
    BURKINA_FASO_BFA (34, "Burkina Faso (BFA)"),
    /** Myanmar (MMR) */
    MYANMAR_MMR (35, "Myanmar (MMR)"),
    /** Burundi (BDI) */
    BURUNDI_BDI (36, "Burundi (BDI)"),
    /** Cambodia (KHM) */
    CAMBODIA_KHM (37, "Cambodia (KHM)"),
    /** Cameroon (CMR) */
    CAMEROON_CMR (38, "Cameroon (CMR)"),
    /** Canada (CAN) */
    CANADA_CAN (39, "Canada (CAN)"),
    /** Cabo Verde (CPV) */
    CABO_VERDE_CPV (40, "Cabo Verde (CPV)"),
    /** Cayman Islands (CYM) */
    CAYMAN_ISLANDS_CYM (41, "Cayman Islands (CYM)"),
    /** Central African Republic (CAF) */
    CENTRAL_AFRICAN_REPUBLIC_CAF (42, "Central African Republic (CAF)"),
    /** Chad (TCD) */
    CHAD_TCD (43, "Chad (TCD)"),
    /** Chile (CHL) */
    CHILE_CHL (44, "Chile (CHL)"),
    /** China, Peoples Republic of (CHN) */
    CHINA_PEOPLES_REPUBLIC_OF_CHN (45, "China, Peoples Republic of (CHN)"),
    /** Christmas Island (CXR) */
    CHRISTMAS_ISLAND_CXR (46, "Christmas Island (CXR)"),
    /** Cocos (Keeling) Islands (CCK) */
    COCOS_KEELING_ISLANDS_CCK (47, "Cocos (Keeling) Islands (CCK)"),
    /** Colombia (COL) */
    COLOMBIA_COL (48, "Colombia (COL)"),
    /** Comoros (COM) */
    COMOROS_COM (49, "Comoros (COM)"),
    /** Congo (COG), Not to be confused with the neighbouring Democratic Republic of the Congo */
    CONGO_COG (50, "Congo (COG)"),
    /** Cook Islands (COK) */
    COOK_ISLANDS_COK (51, "Cook Islands (COK)"),
    /** Coral Sea Islands (Australia), Use Australia */
    CORAL_SEA_ISLANDS_AUSTRALIA (52, "Coral Sea Islands (Australia)"),
    /** Costa Rica (CRI) */
    COSTA_RICA_CRI (53, "Costa Rica (CRI)"),
    /** Cuba (CUB) */
    CUBA_CUB (54, "Cuba (CUB)"),
    /** Cyprus (CYP) */
    CYPRUS_CYP (55, "Cyprus (CYP)"),
    /** Czechoslovakia (CSK), Now dissolved; succeeded by the Czech Republic and Slovakia */
    CZECHOSLOVAKIA_CSK (56, "Czechoslovakia (CSK)"),
    /** Denmark (DNK) */
    DENMARK_DNK (57, "Denmark (DNK)"),
    /** Djibouti (DJI) */
    DJIBOUTI_DJI (58, "Djibouti (DJI)"),
    /** Dominica (DMA) */
    DOMINICA_DMA (59, "Dominica (DMA)"),
    /** Dominican Republic (DOM) */
    DOMINICAN_REPUBLIC_DOM (60, "Dominican Republic (DOM)"),
    /** Ecuador (ECU) */
    ECUADOR_ECU (61, "Ecuador (ECU)"),
    /** Egypt (EGY) */
    EGYPT_EGY (62, "Egypt (EGY)"),
    /** El Salvador (SLV) */
    EL_SALVADOR_SLV (63, "El Salvador (SLV)"),
    /** Equatorial Guinea (GNQ) */
    EQUATORIAL_GUINEA_GNQ (64, "Equatorial Guinea (GNQ)"),
    /** Ethiopia (ETH) */
    ETHIOPIA_ETH (65, "Ethiopia (ETH)"),
    /** Europa Island (France), Use French Southern Territories */
    EUROPA_ISLAND_FRANCE (66, "Europa Island (France)"),
    /** Falkland Islands (Malvinas) (FLK) */
    FALKLAND_ISLANDS_MALVINAS_FLK (67, "Falkland Islands (Malvinas) (FLK)"),
    /** Faroe Islands (FRO) */
    FAROE_ISLANDS_FRO (68, "Faroe Islands (FRO)"),
    /** Fiji (FJI) */
    FIJI_FJI (69, "Fiji (FJI)"),
    /** Finland (FIN) */
    FINLAND_FIN (70, "Finland (FIN)"),
    /** France (FRA) */
    FRANCE_FRA (71, "France (FRA)"),
    /** French Guiana (GUF) */
    FRENCH_GUIANA_GUF (72, "French Guiana (GUF)"),
    /** French Polynesia (PYF) */
    FRENCH_POLYNESIA_PYF (73, "French Polynesia (PYF)"),
    /** French Southern Territories (ATF) */
    FRENCH_SOUTHERN_TERRITORIES_ATF (74, "French Southern Territories (ATF)"),
    /** Gabon (GAB) */
    GABON_GAB (75, "Gabon (GAB)"),
    /** Gambia, The (GMB) */
    GAMBIA_THE_GMB (76, "Gambia, The (GMB)"),
    /** Gaza Strip (Israel), Use Israel instead */
    GAZA_STRIP_ISRAEL (77, "Gaza Strip (Israel)"),
    /** Germany (DEU) */
    GERMANY_DEU (78, "Germany (DEU)"),
    /** Ghana (GHA) */
    GHANA_GHA (79, "Ghana (GHA)"),
    /** Gibraltar (GIB) */
    GIBRALTAR_GIB (80, "Gibraltar (GIB)"),
    /** Glorioso Islands (France), Use French Southern Territories */
    GLORIOSO_ISLANDS_FRANCE (81, "Glorioso Islands (France)"),
    /** Greece (GRC) */
    GREECE_GRC (82, "Greece (GRC)"),
    /** Greenland (GRL) */
    GREENLAND_GRL (83, "Greenland (GRL)"),
    /** Grenada (GRD) */
    GRENADA_GRD (84, "Grenada (GRD)"),
    /** Guadeloupe (GLP) */
    GUADELOUPE_GLP (85, "Guadeloupe (GLP)"),
    /** Guam (GUM) */
    GUAM_GUM (86, "Guam (GUM)"),
    /** Guatemala (GTM) */
    GUATEMALA_GTM (87, "Guatemala (GTM)"),
    /** Guernsey (GGY) */
    GUERNSEY_GGY (88, "Guernsey (GGY)"),
    /** Guinea (GIN) */
    GUINEA_GIN (89, "Guinea (GIN)"),
    /** Guinea-Bissau (GNB) */
    GUINEA_BISSAU_GNB (90, "Guinea-Bissau (GNB)"),
    /** Guyana (GUY) */
    GUYANA_GUY (91, "Guyana (GUY)"),
    /** Haiti (HTI) */
    HAITI_HTI (92, "Haiti (HTI)"),
    /** Heard Island and McDonald Islands (HMD) */
    HEARD_ISLAND_AND_MCDONALD_ISLANDS_HMD (93, "Heard Island and McDonald Islands (HMD)"),
    /** Honduras (HND) */
    HONDURAS_HND (94, "Honduras (HND)"),
    /** Hong Kong (HKG) */
    HONG_KONG_HKG (95, "Hong Kong (HKG)"),
    /** Howland Island (United States), Use United States Minor Outlying Islands */
    HOWLAND_ISLAND_UNITED_STATES (96, "Howland Island (United States)"),
    /** Hungary (HUN) */
    HUNGARY_HUN (97, "Hungary (HUN)"),
    /** Iceland (ISL) */
    ICELAND_ISL (98, "Iceland (ISL)"),
    /** India (IND) */
    INDIA_IND (99, "India (IND)"),
    /** Indonesia (IDN) */
    INDONESIA_IDN (100, "Indonesia (IDN)"),
    /** Iran (Islamic Republic of) (IRN) */
    IRAN_ISLAMIC_REPUBLIC_OF_IRN (101, "Iran (Islamic Republic of) (IRN)"),
    /** Iraq (IRQ) */
    IRAQ_IRQ (102, "Iraq (IRQ)"),
    /** Ireland (IRL) */
    IRELAND_IRL (104, "Ireland (IRL)"),
    /** Israel (ISR) */
    ISRAEL_ISR (105, "Israel (ISR)"),
    /** Italy (ITA) */
    ITALY_ITA (106, "Italy (ITA)"),
    /** Cote dIvoire (CIV) */
    COTE_DIVOIRE_CIV (107, "Cote dIvoire (CIV)"),
    /** Jamaica (JAM) */
    JAMAICA_JAM (108, "Jamaica (JAM)"),
    /** Jan Mayen (Norway), Use Svalbard and Jan Mayen */
    JAN_MAYEN_NORWAY (109, "Jan Mayen (Norway)"),
    /** Japan (JPN) */
    JAPAN_JPN (110, "Japan (JPN)"),
    /** Jarvis Island (United States), Use United States Minor Outlying Islands */
    JARVIS_ISLAND_UNITED_STATES (111, "Jarvis Island (United States)"),
    /** Jersey (JEY) */
    JERSEY_JEY (112, "Jersey (JEY)"),
    /** Johnston Atoll (United States), Island no longer occupied, removed from ISO 3166 country list */
    JOHNSTON_ATOLL_UNITED_STATES (113, "Johnston Atoll (United States)"),
    /** Jordan (JOR) */
    JORDAN_JOR (114, "Jordan (JOR)"),
    /** Juan de Nova Island, Use French Southern Territories */
    JUAN_DE_NOVA_ISLAND (115, "Juan de Nova Island"),
    /** Kenya (KEN) */
    KENYA_KEN (116, "Kenya (KEN)"),
    /** Kingman Reef (United States), Use United States Minor Outlying Islands */
    KINGMAN_REEF_UNITED_STATES (117, "Kingman Reef (United States)"),
    /** Kiribati (KIR) */
    KIRIBATI_KIR (118, "Kiribati (KIR)"),
    /** Korea (Democratic Peoples Republic of) (PRK) */
    KOREA_DEMOCRATIC_PEOPLES_REPUBLIC_OF_PRK (119, "Korea (Democratic Peoples Republic of) (PRK)"),
    /** Korea (Republic of) (KOR) */
    KOREA_REPUBLIC_OF_KOR (120, "Korea (Republic of) (KOR)"),
    /** Kuwait (KWT) */
    KUWAIT_KWT (121, "Kuwait (KWT)"),
    /** Lao Peoples Democratic Republic (LAO) */
    LAO_PEOPLES_DEMOCRATIC_REPUBLIC_LAO (122, "Lao Peoples Democratic Republic (LAO)"),
    /** Lebanon (LBN) */
    LEBANON_LBN (123, "Lebanon (LBN)"),
    /** Lesotho (LSO) */
    LESOTHO_LSO (124, "Lesotho (LSO)"),
    /** Liberia (LBR) */
    LIBERIA_LBR (125, "Liberia (LBR)"),
    /** Libya (LBY) */
    LIBYA_LBY (126, "Libya (LBY)"),
    /** Liechtenstein (LIE) */
    LIECHTENSTEIN_LIE (127, "Liechtenstein (LIE)"),
    /** Luxembourg (LUX) */
    LUXEMBOURG_LUX (128, "Luxembourg (LUX)"),
    /** Madagascar (MDG) */
    MADAGASCAR_MDG (129, "Madagascar (MDG)"),
    /** Macao (MAC) */
    MACAO_MAC (130, "Macao (MAC)"),
    /** Malawi (MWI) */
    MALAWI_MWI (131, "Malawi (MWI)"),
    /** Malaysia (MYS) */
    MALAYSIA_MYS (132, "Malaysia (MYS)"),
    /** Maldives (MDV) */
    MALDIVES_MDV (133, "Maldives (MDV)"),
    /** Mali (MLI) */
    MALI_MLI (134, "Mali (MLI)"),
    /** Malta (MLT) */
    MALTA_MLT (135, "Malta (MLT)"),
    /** Isle of Man (IMN) */
    ISLE_OF_MAN_IMN (136, "Isle of Man (IMN)"),
    /** Marshall Islands (MHL) */
    MARSHALL_ISLANDS_MHL (137, "Marshall Islands (MHL)"),
    /** Martinique (MTQ) */
    MARTINIQUE_MTQ (138, "Martinique (MTQ)"),
    /** Mauritania (MRT) */
    MAURITANIA_MRT (139, "Mauritania (MRT)"),
    /** Mauritius (MUS) */
    MAURITIUS_MUS (140, "Mauritius (MUS)"),
    /** Mayotte (MYT) */
    MAYOTTE_MYT (141, "Mayotte (MYT)"),
    /** Mexico (MEX) */
    MEXICO_MEX (142, "Mexico (MEX)"),
    /** Micronesia (Federated States of) (FSM) */
    MICRONESIA_FEDERATED_STATES_OF_FSM (143, "Micronesia (Federated States of) (FSM)"),
    /** Monaco (MCO) */
    MONACO_MCO (144, "Monaco (MCO)"),
    /** Mongolia (MNG) */
    MONGOLIA_MNG (145, "Mongolia (MNG)"),
    /** Montserrat (MSR) */
    MONTSERRAT_MSR (146, "Montserrat (MSR)"),
    /** Morocco (MAR) */
    MOROCCO_MAR (147, "Morocco (MAR)"),
    /** Mozambique (MOZ) */
    MOZAMBIQUE_MOZ (148, "Mozambique (MOZ)"),
    /** Namibia (NAM) */
    NAMIBIA_NAM (149, "Namibia (NAM)"),
    /** Nauru (NRU) */
    NAURU_NRU (150, "Nauru (NRU)"),
    /** Navassa Island (United States), Use United States Minor Outlying Islands */
    NAVASSA_ISLAND_UNITED_STATES (151, "Navassa Island (United States)"),
    /** Nepal (NPL) */
    NEPAL_NPL (152, "Nepal (NPL)"),
    /** Netherlands (NLD) */
    NETHERLANDS_NLD (153, "Netherlands (NLD)"),
    /** Netherlands Antilles (Curacao, Bonaire, Saba, Sint Maarten Sint Eustatius), Use Netherlands */
    NETHERLANDS_ANTILLES_CURACAO_BONAIRE_SABA_SINT_MAARTEN_SINT_EUSTATIUS (154, "Netherlands Antilles (Curacao, Bonaire, Saba, Sint Maarten Sint Eustatius)"),
    /** New Caledonia (NCL) */
    NEW_CALEDONIA_NCL (155, "New Caledonia (NCL)"),
    /** New Zealand (NZL) */
    NEW_ZEALAND_NZL (156, "New Zealand (NZL)"),
    /** Nicaragua (NIC) */
    NICARAGUA_NIC (157, "Nicaragua (NIC)"),
    /** Niger (NER) */
    NIGER_NER (158, "Niger (NER)"),
    /** Nigeria (NGA) */
    NIGERIA_NGA (159, "Nigeria (NGA)"),
    /** Niue (NIU) */
    NIUE_NIU (160, "Niue (NIU)"),
    /** Norfolk Island (NFK) */
    NORFOLK_ISLAND_NFK (161, "Norfolk Island (NFK)"),
    /** Northern Mariana Islands (MNP) */
    NORTHERN_MARIANA_ISLANDS_MNP (162, "Northern Mariana Islands (MNP)"),
    /** Norway (NOR) */
    NORWAY_NOR (163, "Norway (NOR)"),
    /** Oman (OMN) */
    OMAN_OMN (164, "Oman (OMN)"),
    /** Pakistan (PAK) */
    PAKISTAN_PAK (165, "Pakistan (PAK)"),
    /** Palmyra Atoll (United States), Use United States Minor Outlying Islands */
    PALMYRA_ATOLL_UNITED_STATES (166, "Palmyra Atoll (United States)"),
    /** Panama (PAN) */
    PANAMA_PAN (168, "Panama (PAN)"),
    /** Papua New Guinea (PNG) */
    PAPUA_NEW_GUINEA_PNG (169, "Papua New Guinea (PNG)"),
    /** Paracel Islands (International - Occupied by China, also claimed by Taiwan and Vietnam) */
    PARACEL_ISLANDS_INTERNATIONAL_OCCUPIED_BY_CHINA_ALSO_CLAIMED_BY_TAIWAN_AND_VIETNAM (170, "Paracel Islands (International - Occupied by China, also claimed by Taiwan and Vietnam)"),
    /** Paraguay (PRY) */
    PARAGUAY_PRY (171, "Paraguay (PRY)"),
    /** Peru (PER) */
    PERU_PER (172, "Peru (PER)"),
    /** Philippines (PHL) */
    PHILIPPINES_PHL (173, "Philippines (PHL)"),
    /** Pitcairn (PCN) */
    PITCAIRN_PCN (174, "Pitcairn (PCN)"),
    /** Poland (POL) */
    POLAND_POL (175, "Poland (POL)"),
    /** Portugal (PRT) */
    PORTUGAL_PRT (176, "Portugal (PRT)"),
    /** Puerto Rico (PRI) */
    PUERTO_RICO_PRI (177, "Puerto Rico (PRI)"),
    /** Qatar (QAT) */
    QATAR_QAT (178, "Qatar (QAT)"),
    /** Reunion (REU) */
    REUNION_REU (179, "Reunion (REU)"),
    /** Romania (ROU) */
    ROMANIA_ROU (180, "Romania (ROU)"),
    /** Rwanda (RWA) */
    RWANDA_RWA (181, "Rwanda (RWA)"),
    /** Saint Kitts and Nevis (KNA) */
    SAINT_KITTS_AND_NEVIS_KNA (182, "Saint Kitts and Nevis (KNA)"),
    /** Saint Helena, Ascension and Tristan da Cunha (SHN) */
    SAINT_HELENA_ASCENSION_AND_TRISTAN_DA_CUNHA_SHN (183, "Saint Helena, Ascension and Tristan da Cunha (SHN)"),
    /** Saint Lucia (LCA) */
    SAINT_LUCIA_LCA (184, "Saint Lucia (LCA)"),
    /** Saint Pierre and Miquelon (SPM) */
    SAINT_PIERRE_AND_MIQUELON_SPM (185, "Saint Pierre and Miquelon (SPM)"),
    /** Saint Vincent and the Grenadines (VCT) */
    SAINT_VINCENT_AND_THE_GRENADINES_VCT (186, "Saint Vincent and the Grenadines (VCT)"),
    /** San Marino (SMR) */
    SAN_MARINO_SMR (187, "San Marino (SMR)"),
    /** Sao Tome and Principe (STP) */
    SAO_TOME_AND_PRINCIPE_STP (188, "Sao Tome and Principe (STP)"),
    /** Saudi Arabia (SAU) */
    SAUDI_ARABIA_SAU (189, "Saudi Arabia (SAU)"),
    /** Senegal (SEN) */
    SENEGAL_SEN (190, "Senegal (SEN)"),
    /** Seychelles (SYC) */
    SEYCHELLES_SYC (191, "Seychelles (SYC)"),
    /** Sierra Leone (SLE) */
    SIERRA_LEONE_SLE (192, "Sierra Leone (SLE)"),
    /** Singapore (SGP) */
    SINGAPORE_SGP (193, "Singapore (SGP)"),
    /** Solomon Islands (SLB) */
    SOLOMON_ISLANDS_SLB (194, "Solomon Islands (SLB)"),
    /** Somalia (SOM) */
    SOMALIA_SOM (195, "Somalia (SOM)"),
    /** South Georgia and the South Sandwich Islands (SGS) */
    SOUTH_GEORGIA_AND_THE_SOUTH_SANDWICH_ISLANDS_SGS (196, "South Georgia and the South Sandwich Islands (SGS)"),
    /** South Africa (ZAF) */
    SOUTH_AFRICA_ZAF (197, "South Africa (ZAF)"),
    /** Spain (ESP) */
    SPAIN_ESP (198, "Spain (ESP)"),
    /** Spratly Islands (International - parts occupied and claimed by China,Malaysia, Philippines, Taiwan, Vietnam) */
    SPRATLY_ISLANDS_INTERNATIONAL_PARTS_OCCUPIED_AND_CLAIMED_BY_CHINA_MALAYSIA_PHILIPPINES_TAIWAN_VIETNAM (199, "Spratly Islands (International - parts occupied and claimed by China,Malaysia, Philippines, Taiwan, Vietnam)"),
    /** Sri Lanka (LKA) */
    SRI_LANKA_LKA (200, "Sri Lanka (LKA)"),
    /** Sudan (SDN) */
    SUDAN_SDN (201, "Sudan (SDN)"),
    /** Suriname (SUR) */
    SURINAME_SUR (202, "Suriname (SUR)"),
    /** Svalbard (Norway), Use Svalbard and Jan Mayen */
    SVALBARD_NORWAY (203, "Svalbard (Norway)"),
    /** Eswatini (SWZ) */
    ESWATINI_SWZ (204, "Eswatini (SWZ)"),
    /** Sweden (SWE) */
    SWEDEN_SWE (205, "Sweden (SWE)"),
    /** Switzerland (CHE) */
    SWITZERLAND_CHE (206, "Switzerland (CHE)"),
    /** Syrian Arab Republic (SYR) */
    SYRIAN_ARAB_REPUBLIC_SYR (207, "Syrian Arab Republic (SYR)"),
    /** Taiwan, Province of China (TWN) */
    TAIWAN_PROVINCE_OF_CHINA_TWN (208, "Taiwan, Province of China (TWN)"),
    /** Tanzania, United Republic of (TZA) */
    TANZANIA_UNITED_REPUBLIC_OF_TZA (209, "Tanzania, United Republic of (TZA)"),
    /** Thailand (THA) */
    THAILAND_THA (210, "Thailand (THA)"),
    /** Togo (TGO) */
    TOGO_TGO (211, "Togo (TGO)"),
    /** Tokelau (TKL) */
    TOKELAU_TKL (212, "Tokelau (TKL)"),
    /** Tonga (TON) */
    TONGA_TON (213, "Tonga (TON)"),
    /** Trinidad and Tobago (TTO) */
    TRINIDAD_AND_TOBAGO_TTO (214, "Trinidad and Tobago (TTO)"),
    /** Tromelin Island (France), Use French Southern Territories */
    TROMELIN_ISLAND_FRANCE (215, "Tromelin Island (France)"),
    /** Palau (PLW) */
    PALAU_PLW (216, "Palau (PLW)"),
    /** Tunisia (TUN) */
    TUNISIA_TUN (217, "Tunisia (TUN)"),
    /** Turkey (TUR) */
    TURKEY_TUR (218, "Turkey (TUR)"),
    /** Turks and Caicos Islands (TCA) */
    TURKS_AND_CAICOS_ISLANDS_TCA (219, "Turks and Caicos Islands (TCA)"),
    /** Tuvalu (TUV) */
    TUVALU_TUV (220, "Tuvalu (TUV)"),
    /** Uganda (UGA) */
    UGANDA_UGA (221, "Uganda (UGA)"),
    /** Russia (RUS), Includes CIS and USSR era types */
    RUSSIA_RUS (222, "Russia (RUS)"),
    /** United Arab Emirates (ARE) */
    UNITED_ARAB_EMIRATES_ARE (223, "United Arab Emirates (ARE)"),
    /** United Kingdom of Great Britain and Northern Ireland (GBR) */
    UNITED_KINGDOM_OF_GREAT_BRITAIN_AND_NORTHERN_IRELAND_GBR (224, "United Kingdom of Great Britain and Northern Ireland (GBR)"),
    /** United States of America (USA) */
    UNITED_STATES_OF_AMERICA_USA (225, "United States of America (USA)"),
    /** Uruguay (URY) */
    URUGUAY_URY (226, "Uruguay (URY)"),
    /** Vanuatu (VUT) */
    VANUATU_VUT (227, "Vanuatu (VUT)"),
    /** Holy See (VAT) */
    HOLY_SEE_VAT (228, "Holy See (VAT)"),
    /** Venezuela (Bolivarian Republic of) (VEN) */
    VENEZUELA_BOLIVARIAN_REPUBLIC_OF_VEN (229, "Venezuela (Bolivarian Republic of) (VEN)"),
    /** Viet Nam (VNM) */
    VIET_NAM_VNM (230, "Viet Nam (VNM)"),
    /** Virgin Islands (U.S.) (VIR) */
    VIRGIN_ISLANDS_US_VIR (231, "Virgin Islands (U.S.) (VIR)"),
    /** Wake Island (United States), Use United States Minor Outlying Islands */
    WAKE_ISLAND_UNITED_STATES (232, "Wake Island (United States)"),
    /** Wallis and Futuna (WLF) */
    WALLIS_AND_FUTUNA_WLF (233, "Wallis and Futuna (WLF)"),
    /** Western Sahara (ESH) */
    WESTERN_SAHARA_ESH (234, "Western Sahara (ESH)"),
    /** West Bank (Israel), Use Israel instead */
    WEST_BANK_ISRAEL (235, "West Bank (Israel)"),
    /** Samoa (WSM) */
    SAMOA_WSM (236, "Samoa (WSM)"),
    /** Yemen (YEM) */
    YEMEN_YEM (237, "Yemen (YEM)"),
    /** Serbia and Montenegro */
    SERBIA_AND_MONTENEGRO (240, "Serbia and Montenegro"),
    /** Zaire, Now Democratic Republic of the Congo */
    ZAIRE (241, "Zaire"),
    /** Zambia (ZMB) */
    ZAMBIA_ZMB (242, "Zambia (ZMB)"),
    /** Zimbabwe (ZWE) */
    ZIMBABWE_ZWE (243, "Zimbabwe (ZWE)"),
    /** Armenia (ARM) */
    ARMENIA_ARM (244, "Armenia (ARM)"),
    /** Azerbaijan (AZE) */
    AZERBAIJAN_AZE (245, "Azerbaijan (AZE)"),
    /** Belarus (BLR) */
    BELARUS_BLR (246, "Belarus (BLR)"),
    /** Bosnia and Herzegovina (BIH) */
    BOSNIA_AND_HERZEGOVINA_BIH (247, "Bosnia and Herzegovina (BIH)"),
    /** Clipperton Island (France), Use French Southern Territories */
    CLIPPERTON_ISLAND_FRANCE (248, "Clipperton Island (France)"),
    /** Croatia (HRV) */
    CROATIA_HRV (249, "Croatia (HRV)"),
    /** Estonia (EST) */
    ESTONIA_EST (250, "Estonia (EST)"),
    /** Georgia (GEO) */
    GEORGIA_GEO (251, "Georgia (GEO)"),
    /** Kazakhstan (KAZ) */
    KAZAKHSTAN_KAZ (252, "Kazakhstan (KAZ)"),
    /** Kyrgyzstan (KGZ) */
    KYRGYZSTAN_KGZ (253, "Kyrgyzstan (KGZ)"),
    /** Latvia (LVA) */
    LATVIA_LVA (254, "Latvia (LVA)"),
    /** Lithuania (LTU) */
    LITHUANIA_LTU (255, "Lithuania (LTU)"),
    /** North Macedonia (MKD) */
    NORTH_MACEDONIA_MKD (256, "North Macedonia (MKD)"),
    /** Midway Islands (United States), Use United States Minor Outlying Islands */
    MIDWAY_ISLANDS_UNITED_STATES (257, "Midway Islands (United States)"),
    /** Moldova (Republic of) (MDA) */
    MOLDOVA_REPUBLIC_OF_MDA (258, "Moldova (Republic of) (MDA)"),
    /** Montenegro (MNE) */
    MONTENEGRO_MNE (259, "Montenegro (MNE)"),
    /** Russia, Replaced by country code 222 */
    RUSSIA (260, "Russia"),
    /** Serbia and Montenegro (Montenegro to separate) */
    SERBIA_AND_MONTENEGRO_MONTENEGRO_TO_SEPARATE (261, "Serbia and Montenegro (Montenegro to separate)"),
    /** Slovenia (SVN) */
    SLOVENIA_SVN (262, "Slovenia (SVN)"),
    /** Tajikistan (TJK) */
    TAJIKISTAN_TJK (263, "Tajikistan (TJK)"),
    /** Turkmenistan (TKM) */
    TURKMENISTAN_TKM (264, "Turkmenistan (TKM)"),
    /** Ukraine (UKR) */
    UKRAINE_UKR (265, "Ukraine (UKR)"),
    /** Uzbekistan (UZB) */
    UZBEKISTAN_UZB (266, "Uzbekistan (UZB)"),
    /** Czech Republic (CZE) */
    CZECH_REPUBLIC_CZE (267, "Czech Republic (CZE)"),
    /** Slovakia (SVK) */
    SLOVAKIA_SVK (268, "Slovakia (SVK)"),
    /** Aaland Islands (ALA) */
    AALAND_ISLANDS_ALA (269, "Aaland Islands (ALA)"),
    /** Bonaire, Sint Eustatius and Saba (BES) */
    BONAIRE_SINT_EUSTATIUS_AND_SABA_BES (270, "Bonaire, Sint Eustatius and Saba (BES)"),
    /** Congo (Democratic Republic of the) (COD), Not to be confused with the neighbouring Republic of the Congo */
    CONGO_DEMOCRATIC_REPUBLIC_OF_THE_COD (271, "Congo (Democratic Republic of the) (COD)"),
    /** Curacao (CUW) */
    CURACAO_CUW (272, "Curacao (CUW)"),
    /** Eritrea (ERI) */
    ERITREA_ERI (273, "Eritrea (ERI)"),
    /** Saint Barthelemy (BLM) */
    SAINT_BARTHELEMY_BLM (274, "Saint Barthelemy (BLM)"),
    /** Saint Martin (French Part) (MAF) */
    SAINT_MARTIN_FRENCH_PART_MAF (275, "Saint Martin (French Part) (MAF)"),
    /** Serbia (SRB) */
    SERBIA_SRB (276, "Serbia (SRB)"),
    /** Sint Maarten (Dutch part) (SXM) */
    SINT_MAARTEN_DUTCH_PART_SXM (277, "Sint Maarten (Dutch part) (SXM)"),
    /** South Sudan (SSD) */
    SOUTH_SUDAN_SSD (278, "South Sudan (SSD)"),
    /** Svalbard and Jan Mayen (SJM) */
    SVALBARD_AND_JAN_MAYEN_SJM (279, "Svalbard and Jan Mayen (SJM)"),
    /** Timor-Leste (TLS) */
    TIMOR_LESTE_TLS (280, "Timor-Leste (TLS)"),
    /** United States Minor Outlying Islands (UMI) */
    UNITED_STATES_MINOR_OUTLYING_ISLANDS_UMI (281, "United States Minor Outlying Islands (UMI)"),
    /** Palestine, State of (PSE) */
    PALESTINE_STATE_OF_PSE (282, "Palestine, State of (PSE)");

    private int value;
    private final String description;

    Country(int value, String description)
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

    public static Country getEnumForValue(int i)
    {
       for(Country val: Country.values()) {
          if(val.getValue()==i)
              return val;
       }
       System.err.println("No enumeration found for value " + i + " of enumeration Country");
       return null;
    }

 
   public void marshal(DataOutputStream dos) throws IOException
    {
        dos.writeShort(getValue());
    }

    public void marshal(ByteBuffer byteBuffer) throws Exception
    {
        byteBuffer.putShort((short)getValue());
    }

    public static Country unmarshalEnum (DataInputStream dis) throws Exception
    {
        return getEnumForValue(dis.readUnsignedShort());
    } 

    public static Country unmarshalEnum (ByteBuffer byteBuffer) throws Exception
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
        return "Country " + getValue() + " " + name(); 
    }
}
