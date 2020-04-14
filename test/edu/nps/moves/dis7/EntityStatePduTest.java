/**
 * Copyright (c) 2008-2020, MOVES Institute, Naval Postgraduate School (NPS). All rights reserved.
 * This work is provided under a BSD open-source license, see project license.html and license.txt
 */
package edu.nps.moves.dis7;

import edu.nps.moves.dis7.enumerations.LandPlatformCapabilities;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Entity State Pdu Test")
public class EntityStatePduTest
{
  @BeforeAll
  public static void setUpClass()
  {
    System.out.println("EntityStatePduTest");
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
  public void testEntityCapabilities()
  {
    Throwable thr = null;
    try {
      EntityStatePdu espdu = new EntityStatePdu();
      espdu.setCapabilities(new LandPlatformCapabilities());
    }
    catch (Throwable t) {
      thr = t;
    }
    assertNull(thr, "Exception indicates error creating EntityStatePdu");
  }
}
