package com.bipinet.cubes.sides;


import com.bipinet.cubes.corners.HappyCubeCorners;
import com.bipinet.cubes.cube.HappyCube;
import com.bipinet.cubes.helpers.TestHelpers;
import com.bipinet.cubes.pieces.Piece;
import com.bipinet.cubes.solver.HappyCubeSolver;
import org.junit.Test;

import java.io.File;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class HappyCubeSidesTest {
    /**
     * File reference to the resources directory.
     */
    private static final File RESOURCES_DIRECTORY = new File(
            "src" + File.separator + "test" + File.separator + "resources");

    private static final List<Piece> MATCHED_BLUE_CUBE_PIECES;

    static {
        final String blueCubeSolvedFileTwoRows = RESOURCES_DIRECTORY.getAbsolutePath() + File.separator +
                "red_cube_solved_test_2_rows.txt";
        //Prove the file exists!
        TestHelpers.testFileExists(blueCubeSolvedFileTwoRows);
        HappyCube happyCube = new HappyCube(new HappyCubeSides(new HappyCubeCorners()), new HappyCubeSolver());
        happyCube.readPiecesFromFile(blueCubeSolvedFileTwoRows);
        MATCHED_BLUE_CUBE_PIECES = Collections.unmodifiableList(happyCube.getPieces()); 
    }
       
    @Test
    public void testMatchLeft(){
        //Rotate and flip the pieces used for matching the left side.
        MATCHED_BLUE_CUBE_PIECES.get(2).flip();
        MATCHED_BLUE_CUBE_PIECES.get(2).rotate();
        assertTrue("Pieces must match the left side of the happy cube!", 
                new HappyCubeSides(new HappyCubeCorners()).matchLeft(MATCHED_BLUE_CUBE_PIECES));
    }

    @Test
    public void testMatchBottom(){
        assertTrue("Pieces must match the bottom side of the happy cube!",
                new HappyCubeSides(new HappyCubeCorners()).matchBottom(MATCHED_BLUE_CUBE_PIECES));
    }

    @Test
    public void testMatchFront(){
        assertTrue("Pieces must match the front side of the happy cube!",
                new HappyCubeSides(new HappyCubeCorners()).matchFront(MATCHED_BLUE_CUBE_PIECES));
    }

    @Test
    public void testMatchTop(){
        //Rotate and flip the pieces used for matching the left side.
        MATCHED_BLUE_CUBE_PIECES.get(3).flip();
        MATCHED_BLUE_CUBE_PIECES.get(3).rotate();
        assertTrue("Pieces must match the top side of the happy cube!",
                new HappyCubeSides(new HappyCubeCorners()).matchTop(MATCHED_BLUE_CUBE_PIECES));
    }

    @Test
    public void testMatchBack(){
        //Rotate and flip the pieces used for matching the left side.
        MATCHED_BLUE_CUBE_PIECES.get(4).flip();
        MATCHED_BLUE_CUBE_PIECES.get(4).rotate();
        MATCHED_BLUE_CUBE_PIECES.get(4).flip();
        MATCHED_BLUE_CUBE_PIECES.get(4).rotate();
        MATCHED_BLUE_CUBE_PIECES.get(4).rotate();
        assertTrue("Pieces must match the back side of the happy cube!",
                new HappyCubeSides(new HappyCubeCorners()).matchBack(MATCHED_BLUE_CUBE_PIECES));
    }

    @Test
    public void testMatchRight(){
        //Rotate and flip the pieces used for matching the left side.
        MATCHED_BLUE_CUBE_PIECES.get(5).flip();
        MATCHED_BLUE_CUBE_PIECES.get(5).rotate();
        assertTrue("Pieces must match the right side of the happy cube!",
                new HappyCubeSides(new HappyCubeCorners()).matchRight(MATCHED_BLUE_CUBE_PIECES));
    }
}
