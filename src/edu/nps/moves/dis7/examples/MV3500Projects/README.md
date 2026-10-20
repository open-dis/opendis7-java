## README

These projects were originally developed for the NPS MV3500 Networked Graphics Simulation course
by Don McGregor.  Minimal changes have been made in order to run with an installed Tomcat 9.

Original versions are online at
- [gitlab.nps.edu/Savage/NetworkedGraphicsMV3500/examples/otherProjects](https://gitlab.nps.edu/Savage/NetworkedGraphicsMV3500/-/tree/master/examples/otherProjects)

Configuration:
- https://stackoverflow.com/questions/24832229/package-javax-servlet-annotation-does-not-exist
  In the project window, right-click <libraries>. Then click <Add Library>. then choose <Jakarta EE Web 9 API Library>

Add project library: Jakarta EE Web 9 API Library
Add project library directory/jar: add local path to opendis7-full.jar under Project properties for Libraries

For SavageWebServlet, must adjust property catalina.base in nbprojects/ and several private properties, see build.properties for details.
