# open-dis7-java
Type-safe java implementation of the DIS Protocol v. 7, IEE 1278.1-2012

**IMPORTANT!**  This project is not complete and is in a testing phase.  Until this notice is removed, use the DIS libraries under the **open-dis-java** and **Enumerations** projects.

<H2>Building the release</H2>
This source is organized as a Netbeans Ant project.  It includes the necessary support files required by Netbeans, specifically, the `netbproject` directory and `build.xml`.

After downloading or cloning the project from the Git repository, a simple `Run->Build Project` from the Netbeans menu should compile the source, as well as produce `open-dis7-java.jar` in then `dist` directory.

The other two artifacts of the build are produced by running two special targets in `build.xml`.  Run each target by right-clicking `build.xml`, then selecting `Run Target->Other Targets->targetname`.  The two targets to run, in no particular order are `jar-javadoc` and `jar-source`.

The completed build should produce the following files in the `dist` directory:

1. `open-dis7-java.jar`
2. `open-dis7-javadoc.jar`
3. `open-dis7-source.jar`

<H2>DIS Entities</H2>
The SISO specification, which is the foundation for much of the DIS library, enumerates values for a myriad of entity types, which are each descendant from the DIS class, `edu.nps.moves.dis7.EntityType`.  Instances of this class are used in several DIS pdus, most notably `edu.nps.moves.dis7.EntityStatePdu`.  The entities described by SISO are hierarchically organized by country, kind, domain, category, subcategory and extra values.  They cover vehicles, munitions, radios, and sensors, and include entities from air, surface, subsurface, land and space domains.

Not all entities are of value to specific DIS applications.  Since the number of classes is large, the spectrum of SISO entities has been partitioned into the following jars, contained in the `entityjars` directory:

1. `open-dis7-entities-usa-air.jar`
2. `open-dis7-entities-usa-land.jar`
3. `open-dis7-entities-usa-munitions.jar`
4. `open-dis7-entities-usa-surface.jar`
5. `open-dis7-entities-usa-all.jar`
6. `open-dis7-entities-chn.jar`
7. `open-dis7-entities-deu.jar`
8. `open-dis7-entities-nato.jar`
9. `open-dis7-entities-rus.jar`
10. `open-dis7-entities-all.jar`

Jar number 10 includes all entities from all countrys.

`open-dis7-entities-javadoc.jar` is javadoc describing all entities from all countries.




