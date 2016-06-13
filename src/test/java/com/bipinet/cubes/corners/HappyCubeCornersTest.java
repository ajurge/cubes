package com.bipinet.cubes.corners;

import com.bipinet.cubes.cube.HappyCube;
import com.bipinet.cubes.helpers.TestHelpers;
import com.bipinet.cubes.pieces.Piece;
import com.bipinet.cubes.sides.HappyCubeSides;
import com.bipinet.cubes.solver.HappyCubeSolver;
import org.junit.Test;

import java.io.File;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class HappyCubeCornersTest {
    /**
     * File reference to the resources directory.
     */
    private static final File RESOURCES_DIRECTORY = new File(
            "src" + File.separator + "test" + File.separator + "resources");

    private static final List<Piece> MATCHED_BLUE_CUBE_PIECES;
    
    static {
        final String blueCubeSolvedFileTwoRows = RESOURCES_DIRECTORY.getAbsolutePath() + File.separator +
                "blue_cube_solved_test_2_rows.txt";
        //Prove the file exists!
        TestHelpers.testFileExists(blueCubeSolvedFileTwoRows);
        HappyCube happyCube = new HappyCube(new HappyCubeSides(new HappyCubeCorners()), new HappyCubeSolver());
        happyCube.readPiecesFromFile(blueCubeSolvedFileTwoRows);
        MATCHED_BLUE_CUBE_PIECES = Collections.unmodifiableList(happyCube.getPieces());
    }
    
    @Test
    public void testMatchBottomFrontLeft(){
        assertTrue("Corners must match!", new HappyCubeCorners().matchBottomFrontLeft(MATCHED_BLUE_CUBE_PIECES));        
    }

    @Test
    public void testMatchBottomFrontRight(){
        assertTrue("Corners must match!", new HappyCubeCorners().matchBottomFrontRight(MATCHED_BLUE_CUBE_PIECES));
    }

    @Test
    public void testMatchBottomBackLeft(){
        assertTrue("Corners must match!", new HappyCubeCorners().matchBottomBackLeft(MATCHED_BLUE_CUBE_PIECES));
    }

    @Test
    public void testMatchBottomBackRight(){
        assertTrue("Corners must match!", new HappyCubeCorners().matchBottomBackRight(MATCHED_BLUE_CUBE_PIECES));
    }

    @Test
    public void testMatchTopFrontLeft(){
        assertTrue("Corners must match!", new HappyCubeCorners().matchTopFrontLeft(MATCHED_BLUE_CUBE_PIECES));
    }

    @Test
    public void testMatchTopFrontRight(){
        assertTrue("Corners must match!", new HappyCubeCorners().matchTopFrontRight(MATCHED_BLUE_CUBE_PIECES));
    }

    @Test
    public void testMatchTopBackLeft(){
        assertTrue("Corners must match!", new HappyCubeCorners().matchTopBackLeft(MATCHED_BLUE_CUBE_PIECES));
    }

    @Test
    public void testMatchTopBackRight(){
        assertTrue("Corners must match!", new HappyCubeCorners(). matchTopBackRight(MATCHED_BLUE_CUBE_PIECES));
    }

   


    


    


    


    
    
}