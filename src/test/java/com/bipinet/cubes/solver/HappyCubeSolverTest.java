package com.bipinet.cubes.solver;

import com.bipinet.cubes.corners.HappyCubeCorners;
import com.bipinet.cubes.cube.Cube;
import com.bipinet.cubes.cube.HappyCube;
import com.bipinet.cubes.helpers.TestHelpers;
import com.bipinet.cubes.sides.HappyCubeSides;
import org.junit.Test;

import java.io.File;

import static org.junit.Assert.assertTrue;

public class HappyCubeSolverTest {

    /**
     * File reference to the resources directory.
     */
    private static final File RESOURCES_DIRECTORY = new File(
            "src" + File.separator + "test" + File.separator + "resources");

    private static final Cube SOLVED_BLUE_HAPPY_CUBE;
    private static final Cube SOLVED_RED_HAPPY_CUBE;

    static {
        //Blue cube
        final String blueCubeSolvedFileTwoRows = RESOURCES_DIRECTORY.getAbsolutePath() + File.separator +
                "blue_cube_solved_test_2_rows.txt";
        //Prove the file exists!
        TestHelpers.testFileExists(blueCubeSolvedFileTwoRows);
        //Red cube
        final String redCubeSolvedFileTwoRows = RESOURCES_DIRECTORY.getAbsolutePath() + File.separator +
                "red_cube_solved_test_2_rows.txt";
        //Prove the file exists!
        TestHelpers.testFileExists(redCubeSolvedFileTwoRows);
        //Load
        //Blue cube
        SOLVED_BLUE_HAPPY_CUBE = new HappyCube(new HappyCubeSides(new HappyCubeCorners()), new HappyCubeSolver());
        SOLVED_BLUE_HAPPY_CUBE.readPiecesFromFile(blueCubeSolvedFileTwoRows);
        //Red cube
        SOLVED_RED_HAPPY_CUBE = new HappyCube(new HappyCubeSides(new HappyCubeCorners()), new HappyCubeSolver());
        SOLVED_RED_HAPPY_CUBE.readPiecesFromFile(redCubeSolvedFileTwoRows);

    }
    
    @Test    
    public void testSolveCube(){
        //Rotate and flip the pieces
        for (int i = 0; i < 6; i++){
            SOLVED_RED_HAPPY_CUBE.getPieces().get(i).rotate();
            SOLVED_RED_HAPPY_CUBE.getPieces().get(i).flip();
            SOLVED_RED_HAPPY_CUBE.getPieces().get(i).rotate();
            SOLVED_BLUE_HAPPY_CUBE.getPieces().get(i).rotate();
            SOLVED_BLUE_HAPPY_CUBE.getPieces().get(i).flip();
            SOLVED_BLUE_HAPPY_CUBE.getPieces().get(i).rotate();
        }
        assertTrue("Blue cube must be solved!",
                new HappyCubeSolver().solveCube(SOLVED_BLUE_HAPPY_CUBE));

        assertTrue("Red cube must be solved!",
                new HappyCubeSolver().solveCube(SOLVED_RED_HAPPY_CUBE));
    }
   
}
