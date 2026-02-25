![Open-DIS Surfer Dude](https://raw.githubusercontent.com/open-dis/opendis7-java/master/images/OpenDisSurferDude.png)

# Distribution Products for opendis7-java Library

**Distributed Interactive Simulation (DIS)** is a set of IEEE standards for conducting real-time platform-level wargaming across multiple host computers and is used worldwide, especially by military organizations but also by other agencies such as those involved in space exploration and medicine.

This software library provides a complete, type-safe open-source Java implementation of the **IEEE Distributed Interactive Simulation (DIS) Protocol** version 7.  This Java codebase includes all Protocol Data Units (PDUs), entity enumerations, and supporting utilities.

**Release version v7.0.35** refers to IEEE DIS version 7.0 integrated together with SISO-REF-010 version 35.

## Downloads

| Assets (linked at bottom of page) | Description |
|:-------|:-------------|
| `opendis7-full.jar` | Complete library — PDUs, enumerations, utilities, and javadoc in one "fat jar" |
| `opendis7-pdus-classes.jar` | PDU compiled classes only |
| `opendis7-pdus-source.jar` | PDU Java source files |
| `opendis7-enumerations-classes.jar` | Enumeration compiled classes (from opendis7-source-generator) |
| `opendis7-enumerations-source.jar` | Enumeration Java source files |
| `opendis7-enumerations-javadoc.jar` | Enumeration javadoc archive |
| `opendis7-javadoc.zip` | Browseable javadoc (unzip, then open `index.html`) |
| `opendis7-release.zip` | Complete bundle of all JARs and license files in this release |

## Documentation and References

- [Javadoc (online)](https://savage.nps.edu/opendis7-java/javadoc) offers complete documentation for all library classes, methods, and values
- [IEEE DIS7 PDU Color Figures](https://gitlab.nps.edu/Savage/NetworkedGraphicsMV3500/-/blob/master/specifications/IeeeDisPduColorFigures.pdf) illustrates primary DIS Protocol Data Unit (PDU) data structures
- [DIS 101 Tutorial (IITSEC 2021)](https://gitlab.nps.edu/Savage/NetworkedGraphicsMV3500/-/blob/master/conferences/IITSEC2021/README.md) was given at Interservice Industry Training, Simulation Education Conference (IITSEC) in December 2021
- Prior release is found at [opendis7-java Library Distribution Products](https://savage.nps.edu/opendis7-java) at NPS (built with enumerations version 34)
- [Wikipedia: Distributed Interactive Simulation](https://en.wikipedia.org/wiki/Distributed_Interactive_Simulation) provides a good overview of DIS capabilities

## Source Code

- [opendis7-java](https://github.com/open-dis/opendis7-java) — Java library, PDUs, utilities, and tests
- [opendis7-source-generator](https://github.com/open-dis/opendis7-source-generator) — Source code generator for all PDU entity types, adding over 22,000 enumerations from SISO-REF-010 version 35 (27 April 2025)
- BSD-style non-viral [open-source license](https://github.com/open-dis/opendis7-java/blob/master/license.txt)

Codebase design and production:

- [Generating Distributed Interactive Simulation (DIS) Codebases using opendis7-source-generator](https://gitlab.nps.edu/Savage/NetworkedGraphicsMV3500/-/blob/master/conferences/SIW2022/README.md), Simulation Interoperability Workshop (SIW) February 2022
- Log files [build.all.out.txt](https://github.com/open-dis/opendis7-java/blob/master/build.all.out.txt) and [build.test.log.txt](https://github.com/open-dis/opendis7-java/blob/master/build.test.log.txt) show successful build results and comprehensive unit tests that include multicast streaming and file recording of DIS PDUs.  These logs are included in codebase version control, in order to facilitate efforts by other contributors and also detect changes as these software archives evolve

## Specifications

- [IEEE Standard 1278.1-2012, IEEE Standard for Distributed Interactive Simulation (DIS) — Application Protocols](https://ieeexplore.ieee.org/document/6387564) is the authoritative reference for all DIS version 7 efforts
- [SISO-REF-010 - Reference for Enumerations for Simulation Interoperability](https://www.sisostandards.org/page/ReferenceDocuments) (see bottom of that page) receives quarterly updates that are prepared and published by [Simulation Interoperability Standards Organization (SISO)](https://www.sisostandards.org)

## Course Materials and Implementation Application

- [MV3500 Distributed Simulation Fundamentals](https://gitlab.nps.edu/Savage/NetworkedGraphicsMV3500) — NPS course using this library
  - This NPS course is an introduction to distributed communications in simulation applications. Topics include introduction to the TCP/IP protocol stack, socket communications including TCP/UDP unicast/multicast and essential protocol design issues. Follow-on emphasis is Distributed Interactive Simulation (DIS) Protocol application programming, with side looks at High Level Architecture (HLA). Course activity focuses on creation and testing of network programming network code and web-browser applications.
- [X3D-Edit 4.0 Authoring Tool for Extensible 3D (X3D) Graphics](https://www.web3d.org/x3d/tools/X3D-Edit)
  -  X3D-Edit is a free, open-source Extensible 3D (X3D) Graphics authoring tool for simple high-quality authoring, editing, import/export, validation and viewing of X3D scenes.  A [flyer](https://www.web3d.org/x3d/tools/X3D-Edit/Open-DIS-flyer.pdf) describes support for the [Distributed Interactive Simulation (DIS) component](https://www.web3d.org/specifications/X3Dv4Draft/ISO-IEC19775-1v4.1-CD/Part01/components/dis.html) of the X3D Graphics International Standard.

## Current and Future Work

The IEEE DIS Protocol is a carefully defined set of binary messages.  Many further uses are possible.

- Work has resumed on completing the autogeneration of a corresponding opendis7-python library written in [Python](https://www.python.org)
- "A stream is a stream is a stream" means that a sequence of bits is usable in multiple ways. DIS PDU streams over the network (data in motion) can be captured as files (data at rest) and then edited, filtered, replayed, merged, etc.
- Preliminary support is provided for native binary PDUs as well as plain-text and DIS-XML encodings, with further development expected.

We have partially implemented an experimental XML encoding for DIS Protocol version 7, enabling opportunities for further [big data](https://en.wikipedia.org/wiki/Big_data) validation and conversion. Current work is testing and building upon these potential capabilities.

- DIS XML Schema [DIS_7_2012.autogenerated.xsd](https://github.com/open-dis/opendis7-source-generator/blob/master/xml/DIS_7_2012.autogenerated.xsd) and [DIS7 PDU XML Schema Documentation](https://savage.nps.edu/opendis7-java/xml/SchemaDocumentation/DIS_7_2012.autogenerated.html)
- These XML data structures are generated from original [XML for PDUs design templates](https://github.com/open-dis/opendis7-source-generator/tree/master/xml/dis_7_2012) by Don McGregor
- Also minimalist DIS: Rich Semantic Track (RST) XML Schema [DIS_7_2012.RichSemanticTrackSubset.xsd](https://github.com/open-dis/opendis7-source-generator/blob/master/xml/DIS_7_2012.RichSemanticTrackSubset.xsd) ([image](https://github.com/open-dis/opendis7-source-generator/blob/master/xml/DisSchemaSubsetRichSemanticTrack.png)) and [RST XML Schema Documentation](https://savage.nps.edu/opendis7-java/xml/SchemaDocumentationRST/DIS_7_2012.RichSemanticTrackSubset.html)

## Contact and Participation

- [Don Brutzman](https://relativemotion.info/) — Relative Motion Consulting (RMC)
- [open-dis GitHub Organization](https://github.com/open-dis) offers numerous additional implementations
