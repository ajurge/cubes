package com.bipinet.cubes.cube;


import com.bipinet.cubes.corners.HappyCubeCorners;
import com.bipinet.cubes.exceptions.CubeNotSolvedException;
import com.bipinet.cubes.helpers.TestHelpers;
import com.bipinet.cubes.parameters.Parameters;
import com.bipinet.cubes.pieces.Piece;
import com.bipinet.cubes.sides.HappyCubeSides;
import com.bipinet.cubes.solver.HappyCubeSolver;
import org.junit.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static junit.framework.TestCase.assertFalse;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class HappyCubeTest {
    private static final String LINE_SEPARATOR = System.lineSeparator();

    /**
     * Expected pieces that should be loaded from blue_cube_not_solved.txt.
     */
    private static final List<String> EXPECTED_PIECES =
            Collections.unmodifiableList(new ArrayList<String>() {{
                add(new String(
                                "  o  " + LINE_SEPARATOR +
                                " ooo " + LINE_SEPARATOR +
                                "ooooo" + LINE_SEPARATOR +
                                " ooo " + LINE_SEPARATOR +
                                "  o  " + LINE_SEPARATOR
                ));
                add(new String(
                                "o o o" + LINE_SEPARATOR +
                                "ooooo" + LINE_SEPARATOR +
                                " ooo " + LINE_SEPARATOR +
                                "ooooo" + LINE_SEPARATOR +
                                "o o o" + LINE_SEPARATOR
                ));
                add(new String(
                                "  o  " + LINE_SEPARATOR +
                                " oooo" + LINE_SEPARATOR +
                                "oooo " + LINE_SEPARATOR +
                                " oooo" + LINE_SEPARATOR +
                                "  o  " + LINE_SEPARATOR
                ));
                add(new String(
                                " o o " + LINE_SEPARATOR +
                                "oooo " + LINE_SEPARATOR +
                                " oooo" + LINE_SEPARATOR +
                                "oooo " + LINE_SEPARATOR +
                                "oo o " + LINE_SEPARATOR
                ));
                add(new String(
                                " o o " + LINE_SEPARATOR +
                                "ooooo" + LINE_SEPARATOR +
                                " ooo " + LINE_SEPARATOR +
                                "ooooo" + LINE_SEPARATOR +
                                "o o  " + LINE_SEPARATOR
                ));
                add(new String(
                                " o o " + LINE_SEPARATOR +
                                " oooo" + LINE_SEPARATOR +
                                "oooo " + LINE_SEPARATOR +
                                " oooo" + LINE_SEPARATOR +
                                "oo oo" + LINE_SEPARATOR
                ));
            }});

    /**
     * Expected printed pieces in unfolded form that should be loaded from blue_cube_not_solved_test.txt.
     */
    private static final String EXPECTED_PIECES_PRINTED_UNFOLDED = new String(
                                                    "  o  o o o o o " + LINE_SEPARATOR +
                                                    " ooo ooooo oooo" + LINE_SEPARATOR +
                                                    "ooooo ooo oooo " + LINE_SEPARATOR +
                                                    " ooo ooooo oooo" + LINE_SEPARATOR +
                                                    "  o  o o ooo oo" + LINE_SEPARATOR +

                    Parameters.HAPPY_CUBE_PIECE_OFFSET + "  o  " + LINE_SEPARATOR +
                    Parameters.HAPPY_CUBE_PIECE_OFFSET + " oooo" + LINE_SEPARATOR +
                    Parameters.HAPPY_CUBE_PIECE_OFFSET + "oooo " + LINE_SEPARATOR +
                    Parameters.HAPPY_CUBE_PIECE_OFFSET + " oooo" + LINE_SEPARATOR +
                    Parameters.HAPPY_CUBE_PIECE_OFFSET + "  o  " + LINE_SEPARATOR +                                                           
                                                            
                    Parameters.HAPPY_CUBE_PIECE_OFFSET + " o o " + LINE_SEPARATOR +
                    Parameters.HAPPY_CUBE_PIECE_OFFSET + "oooo " + LINE_SEPARATOR +
                    Parameters.HAPPY_CUBE_PIECE_OFFSET + " oooo" + LINE_SEPARATOR +
                    Parameters.HAPPY_CUBE_PIECE_OFFSET + "oooo " + LINE_SEPARATOR +
                    Parameters.HAPPY_CUBE_PIECE_OFFSET + "oo o " + LINE_SEPARATOR +
                                                            
                    Parameters.HAPPY_CUBE_PIECE_OFFSET + " o o " + LINE_SEPARATOR +
                    Parameters.HAPPY_CUBE_PIECE_OFFSET + "ooooo" + LINE_SEPARATOR +
                    Parameters.HAPPY_CUBE_PIECE_OFFSET + " ooo " + LINE_SEPARATOR +
                    Parameters.HAPPY_CUBE_PIECE_OFFSET + "ooooo" + LINE_SEPARATOR +
                    Parameters.HAPPY_CUBE_PIECE_OFFSET + "o o  " + LINE_SEPARATOR
    );

    /**
     * Expected solved blue cube printed pieces in unfolded form that should be loaded from blue_cube_solved_test_2_rows.txt.
     */
    private static final String EXPECTED_SOLVED_BLUE_CUBE_PRINTED_UNFOLDED = new String(
                                                    "  o    o o o o " + LINE_SEPARATOR +
                                                    " ooo ooooo ooo " + LINE_SEPARATOR +
                                                    "ooooo ooo ooooo" + LINE_SEPARATOR +
                                                    " ooo ooooo ooo " + LINE_SEPARATOR +
                                                    "  o   o oo  o  " + LINE_SEPARATOR +

                    Parameters.HAPPY_CUBE_PIECE_OFFSET + "o o  " + LINE_SEPARATOR +
                    Parameters.HAPPY_CUBE_PIECE_OFFSET + "ooooo" + LINE_SEPARATOR +
                    Parameters.HAPPY_CUBE_PIECE_OFFSET + " ooo " + LINE_SEPARATOR +
                    Parameters.HAPPY_CUBE_PIECE_OFFSET + "ooooo" + LINE_SEPARATOR +
                    Parameters.HAPPY_CUBE_PIECE_OFFSET + " o o " + LINE_SEPARATOR +

                    Parameters.HAPPY_CUBE_PIECE_OFFSET + "o o o" + LINE_SEPARATOR +
                    Parameters.HAPPY_CUBE_PIECE_OFFSET + "ooooo" + LINE_SEPARATOR +
                    Parameters.HAPPY_CUBE_PIECE_OFFSET + " ooo " + LINE_SEPARATOR +
                    Parameters.HAPPY_CUBE_PIECE_OFFSET + "ooooo" + LINE_SEPARATOR +
                    Parameters.HAPPY_CUBE_PIECE_OFFSET + "o o o" + LINE_SEPARATOR +

                    Parameters.HAPPY_CUBE_PIECE_OFFSET + " o o " + LINE_SEPARATOR +
                    Parameters.HAPPY_CUBE_PIECE_OFFSET + "oooo " + LINE_SEPARATOR +
                    Parameters.HAPPY_CUBE_PIECE_OFFSET + " oooo" + LINE_SEPARATOR +
                    Parameters.HAPPY_CUBE_PIECE_OFFSET + "oooo " + LINE_SEPARATOR +
                    Parameters.HAPPY_CUBE_PIECE_OFFSET + "oo o " + LINE_SEPARATOR
    );

    /**
     * Expected solved red cube printed pieces in unfolded form that should be loaded from red_cube_solved_test_2_rows.txt.
     */
    private static final String EXPECTED_SOLVED_RED_CUBE_PRINTED_UNFOLDED = new String(
                                                    "  o o   oo  o  " + LINE_SEPARATOR +
                                                    "ooooo ooo oooo " + LINE_SEPARATOR +
                                                    "oooo ooooo ooo " + LINE_SEPARATOR +
                                                    " oooo ooo ooooo" + LINE_SEPARATOR +
                                                    "  o o o oo o o " + LINE_SEPARATOR +

                    Parameters.HAPPY_CUBE_PIECE_OFFSET + "  o  " + LINE_SEPARATOR +
                    Parameters.HAPPY_CUBE_PIECE_OFFSET + "oooo " + LINE_SEPARATOR +
                    Parameters.HAPPY_CUBE_PIECE_OFFSET + " oooo" + LINE_SEPARATOR +
                    Parameters.HAPPY_CUBE_PIECE_OFFSET + "oooo " + LINE_SEPARATOR +
                    Parameters.HAPPY_CUBE_PIECE_OFFSET + "  o  " + LINE_SEPARATOR +

                    Parameters.HAPPY_CUBE_PIECE_OFFSET + "oo oo" + LINE_SEPARATOR +
                    Parameters.HAPPY_CUBE_PIECE_OFFSET + "oooo " + LINE_SEPARATOR +
                    Parameters.HAPPY_CUBE_PIECE_OFFSET + " oooo" + LINE_SEPARATOR +
                    Parameters.HAPPY_CUBE_PIECE_OFFSET + " oooo" + LINE_SEPARATOR +
                    Parameters.HAPPY_CUBE_PIECE_OFFSET + "oo o " + LINE_SEPARATOR +

                    Parameters.HAPPY_CUBE_PIECE_OFFSET + "  o o" + LINE_SEPARATOR +
                    Parameters.HAPPY_CUBE_PIECE_OFFSET + "ooooo" + LINE_SEPARATOR +
                    Parameters.HAPPY_CUBE_PIECE_OFFSET + " ooo " + LINE_SEPARATOR +
                    Parameters.HAPPY_CUBE_PIECE_OFFSET + "ooooo" + LINE_SEPARATOR +
                    Parameters.HAPPY_CUBE_PIECE_OFFSET + " oo  " + LINE_SEPARATOR
    );
    

    /**
     * File reference to the resources directory.
     */
    private static final File RESOURCES_DIRECTORY = new File(
            "src" + File.separator + "test" + File.separator + "resources");


    @Test
    public void testSolveBlueCube() throws CubeNotSolvedException {
        final String blueCubeSolvedFile = RESOURCES_DIRECTORY.getAbsolutePath() + File.separator +
                "blue_cube_solved_test_2_rows.txt";
        //Prove the file exists!
        TestHelpers.testFileExists(blueCubeSolvedFile);
        HappyCube happyCube = new HappyCube(new HappyCubeSides(new HappyCubeCorners()), new HappyCubeSolver());
        happyCube.readPiecesFromFile(blueCubeSolvedFile);
        //Rotate and flip some of the pieces
        happyCube.getPieces().get(4).flip();
        happyCube.getPieces().get(4).rotate();
        happyCube.getPieces().get(5).flip();
        happyCube.getPieces().get(5).rotate();
        happyCube.solve();
        assertEquals("Blue cube printed pieces in unfolded form must be equal.",
                EXPECTED_SOLVED_BLUE_CUBE_PRINTED_UNFOLDED, happyCube.printUnfolded());
        
    }

    @Test
    public void testSolveRedCube() throws CubeNotSolvedException {
        final String redCubeSolvedFile = RESOURCES_DIRECTORY.getAbsolutePath() + File.separator +
                "red_cube_solved_test_2_rows.txt";
        //Prove the file exists!
        TestHelpers.testFileExists(redCubeSolvedFile);
        HappyCube happyCube = new HappyCube(new HappyCubeSides(new HappyCubeCorners()), new HappyCubeSolver());
        happyCube.readPiecesFromFile(redCubeSolvedFile);
        //Rotate and flip some of the pieces
        happyCube.getPieces().get(4).flip();
        happyCube.getPieces().get(4).rotate();
        happyCube.getPieces().get(5).flip();
        happyCube.getPieces().get(5).rotate();
        happyCube.solve();
        assertEquals("Red cube printed pieces in unfolded form must be equal.",
                EXPECTED_SOLVED_RED_CUBE_PRINTED_UNFOLDED, happyCube.printUnfolded());
    }
    
    
    @Test
    public void testWritePiecesToFile(){
        final String blueCubeNotSolvedFile = RESOURCES_DIRECTORY.getAbsolutePath() + File.separator +
                "blue_cube_not_solved_test.txt";
        final String blueCubeSolvedFile = "blue_cube_solved_test.txt";
        //Prove the file exists!
        TestHelpers.testFileExists(blueCubeNotSolvedFile);
        //Prove the solved cube file does not exist!
        TestHelpers.testFileNotExist(blueCubeSolvedFile);
        HappyCube happyCube = new HappyCube(new HappyCubeSides(new HappyCubeCorners()), new HappyCubeSolver());
        happyCube.readPiecesFromFile(blueCubeNotSolvedFile);
        happyCube.writePiecesToFile(blueCubeSolvedFile);
        //Prove the file exists!
        TestHelpers.testFileExists(blueCubeSolvedFile);
        //Remove the file ad prove it does not exist.
        new File(blueCubeSolvedFile).delete();
        TestHelpers.testFileNotExist(blueCubeSolvedFile);
    }

    @Test
    public void testPrintUnfolded(){
        String blueCubeNotSolvedFile = RESOURCES_DIRECTORY.getAbsolutePath() + File.separator +
                "blue_cube_not_solved_test.txt";
        //Prove the file exists!
        TestHelpers.testFileExists(blueCubeNotSolvedFile);
        HappyCube happyCube = new HappyCube(new HappyCubeSides(new HappyCubeCorners()), new HappyCubeSolver());
        happyCube.readPiecesFromFile(blueCubeNotSolvedFile);
        assertEquals("Printed pieces in unfolded form must be equal.",
                EXPECTED_PIECES_PRINTED_UNFOLDED, happyCube.printUnfolded());
    }


    @Test
    public void testReadPiecesFromFile(){
        String blueCubeNotSolvedFile = RESOURCES_DIRECTORY.getAbsolutePath() + File.separator +
                "blue_cube_not_solved_test.txt";
        //Prove the file exists!
        TestHelpers.testFileExists(blueCubeNotSolvedFile);
        HappyCube happyCube = new HappyCube(new HappyCubeSides(new HappyCubeCorners()), new HappyCubeSolver());
        assertTrue("Blue happy cube pieces must be loaded successfully.",
                happyCube.readPiecesFromFile(blueCubeNotSolvedFile));
        assertThat("There must be 6 pieces loaded.", happyCube.getPieces().size(), is(6));
        final List<Piece> actualHappyCubePieces = happyCube.getPieces();
        for (int i = 0; i < actualHappyCubePieces.size(); i++){
            final String actualPrintedHappyCubePiece = actualHappyCubePieces.get(i).print();
            assertEquals(String.format("Current piece must be equal to %s %s",
                    LINE_SEPARATOR, actualPrintedHappyCubePiece),
                    actualPrintedHappyCubePiece, EXPECTED_PIECES.get(i));
        }
    }

    @Test
    public void testValidateLine(){
        //Test invalid lines
        final String [] validLines = new String[]{
                "ooooo  ooooooo ",
                "o              ",
                "oooooooooooooo ",
                "oooooooooooooo ",
                "oooooooooooooo "
        };
        //Test invalid lines
        final String [] invalidLines = new String[]{
                "ooooo  o1      ",
                "o           %^&",
                "ooooooooodf?(( ",
                "aebvqeb ",
                "1 ",
                "aaa123aa ooooo  "
        };
        HappyCube happyCube = new HappyCube(new HappyCubeSides(new HappyCubeCorners()), new HappyCubeSolver());
        int validLineNumber = 0;
        for (String validLine : validLines){
            assertTrue(String.format("Line %s with length %s must be valid!", validLine, validLine.length()),
                    happyCube.isLineValid(validLine, validLineNumber));
            validLineNumber++;
        }
        int invalidLineNumber = 0;
        for (String invalidLine : invalidLines){
            assertFalse(String.format("Line %s with length %s must be invalid!", invalidLine, invalidLine.length()),
                    happyCube.isLineValid(invalidLine, invalidLineNumber));
            invalidLineNumber++;
        }
    }

    @Test
    public void testValidateLineCount(){
        HappyCube happyCube = new HappyCube(new HappyCubeSides(new HappyCubeCorners()), new HappyCubeSolver());
        final int validLineCount = 10;
        final int[] invalidLineCounts = new int[]{0, 1, 2, 4, 11, 12, 55, 100, 5555};
        assertTrue(String.format("Line count %s must be valid!", validLineCount),
                    happyCube.isLineCountValid(validLineCount));

        for (int invalidLineCount : invalidLineCounts){
            assertFalse(String.format("Line count %s must be invalid!", invalidLineCount),
                    happyCube.isLineCountValid(invalidLineCount));
        }
    }
}
