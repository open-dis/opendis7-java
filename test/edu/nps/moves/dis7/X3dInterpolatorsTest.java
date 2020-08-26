/**
 * Copyright (c) 2008-2020, MOVES Institute, Naval Postgraduate School (NPS). All rights reserved.
 * This work is provided under a BSD open-source license, see project license.html and license.txt
 */
package edu.nps.moves.dis7;

import edu.nps.moves.dis7.utilities.DisThreadedNetIF;
import edu.nps.moves.dis7.utilities.PduFactory;
import edu.nps.moves.dis7.utilities.stream.PduPlayer;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.concurrent.Semaphore;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
 
/**
 *
 * @author &lt;a href="mailto:tdnorbra@nps.edu?subject=edu.nps.moves.dis7.X3dInterpolatorsTest"&gt;Terry Norbraten, NPS MOVES&lt;/a&gt;
 */
public class X3dInterpolatorsTest {
    
    Semaphore mutex;
    PduFactory pduFac;
    
    @BeforeAll
    public static void setUpClass() throws IOException {
        System.out.println("X3dInterpolatorsTest");
    }
    
    @BeforeEach
    public void setUp() throws IOException {
        
        File file = new File("./pduLog");
        
        for (File subFile : file.listFiles()) {
            subFile.delete();
        }
        
        Path from = Path.of("src/edu/nps/moves/dis7/utilities/logs", "PdusaveGAZ69PatrolingPlainText.dislog");
        Path to = Path.of(file.getPath(), "Pdusave.dislog");
        Files.copy(from, to, StandardCopyOption.REPLACE_EXISTING);
        
        pduFac = new PduFactory();
        mutex = new Semaphore(1);
    }
    
    @AfterEach
    public void tearDown() throws InterruptedException {
        mutex.acquire();
    }

    @Test
    public void testInterpolators() throws IOException, InterruptedException {   
        System.out.println("testInterpolators");
        
        mutex.acquire();
        Path path = Path.of("./pduLog");
        
        // Note: the player will playback all log files in the given path
        PduPlayer player = new PduPlayer(DisThreadedNetIF.DEFAULT_MULTICAST_ADDRESS, DisThreadedNetIF.DEFAULT_DIS_PORT, path, true);
        player.addRawListener(ba -> {
            if (ba == null) {
                player.end();
                mutex.release();
            }   
        });
    }
    public static void main(String[] args) throws IOException, InterruptedException {
        
        setUpClass();
        
        X3dInterpolatorsTest xit = new X3dInterpolatorsTest();
        xit.setUp();
        xit.testInterpolators();
        xit.tearDown();
    }

}