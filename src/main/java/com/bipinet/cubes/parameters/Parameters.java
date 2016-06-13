package com.bipinet.cubes.parameters;


import java.util.Map;
import java.util.TreeMap;

/**
 * Final class storing static application parameters that are immutable at runtime.
 *
 *
 * <p> Happy Cube side marking:
 * <pre>
 *     0 - LEFT
 *     1 - BOTTOM
 *     2 - FRONT
 *     3 - TOP
 *     4 - BACK
 *     5 - RIGHT
 </pre> 

 * <p> Happy Cube pieces in input files.
 *  <pre>                 
 *         ooooo ooooo ooooo
 *         o   o o   o o   o
 *         o 0 o o 1 o o 2 o  
 *         o   o o   o o   o
 *         ooooo ooooo ooooo   
 *         
 *         ooooo ooooo ooooo
 *         o   o o   o o   o
 *         o 2 o o 4 o o 5 o  
 *         o   o o   o o   o
 *         ooooo ooooo ooooo 
 </pre>
 
 *
 * <p> Solved Happy Cube in unfolded representation.  
 *
 <pre>                 
 *         ooooo ooooo ooooo
 *         o   o o   o o   o
 *         o 0 o o 1 o o 5 o  
 *         o   o o   o o   o
 *         ooooo ooooo ooooo 
 *
 *                ooooo
 *                o   o
 *                o 2 o
 *                o   o
 *                ooooo
 *
 *                ooooo
 *                o   o
 *                o 3 o
 *                o   o
 *                ooooo
 *
 *                ooooo
 *                o   o
 *                o 4 o
 *                o   o
 *                ooooo
 </pre>          
 *
 <p> Happy Cube edge marking.   
 <pre>  
 *                 TOP
 *                ooooo
 *                o   o
 *          LEFT  o   o  RIGHT
 *                o   o
 *                ooooo
 *
 *                BOTTOM
 </pre>
 * 
 */
public final class Parameters {

    /**
     * Size of the each happy cube's piece. Integer value of 1 corresponds to a single square.
     * E.g. in 5x5x5 cube each edge of the piece will consist of 5 irregularly cut squares.
     */
    public static final int HAPPY_CUBE_SIZE = 5;

    /**
     * Sets number of pieces composing the happy cube.
     * Happy cube has 6 faces, each of them with 4 edges with irregularly cut pattern of squares.
     * All the 6 pieces must match the faces of the cube on each edge to form a solved cube.
     *
     */
    public static final int HAPPY_CUBE_NUMBER_OF_PIECES = 6;

    /**
     * Number of lines in the unsolved cube file. This cannot be different, as the input will be invalid.
     */
    public static final int NUMBER_OF_LINES_IN_INPUT_FILE = 10;
    /**
     * Number of characters in each line of the unsolved cube file.
     * This cannot be different, as the input will be invalid.
     */
    public static final int NUMBER_OF_CHARACTERS_PER_LINE_INPUT_FILE = 15;
    /**
     * Regular expression with allowed characters in the input file.
     * Lowercase letters 'o' and spaces ' ' and the length must be equal to 15.
     */
    public static final String LINE_VALIDATION_REGEX = String.format("^(?=.*o)(?=.*\\s)[o\\s]{%s}$",
            NUMBER_OF_CHARACTERS_PER_LINE_INPUT_FILE);

    /**
     * Number of pieces in each row in the file;
     */
    public static final int PIECES_IN_ROW = 3;
    /**
     * Number of rows in the file;
     */
    public static final int NUMBER_OF_ROWS = 2;

    /**
     * Cube inner part is filled in with 3x3 symbols.
     * So this line should be repeated 3 times to fully fill the inner part of the cube.
     */
    public static final String HAPPY_CUBE_INNER_SYMBOLS = "ooo";

    /**
     * Offset string by which a piece will be offset form the initial position.
     */
    public static final String HAPPY_CUBE_PIECE_OFFSET = "     ";

    /**
     * Names of the cube not solved source and solved destination files.
     */
    public static final Map<String, String> HAPPY_CUBE_FILE_NAMES = new TreeMap<String, String>(){{
        put("blue_cube_not_solved.txt", "blue_cube_solved.txt");
        put("red_cube_not_solved.txt", "red_cube_solved.txt");
        put("violet_cube_not_solved.txt", "violet_cube_solved.txt");
        put("yellow_cube_not_solved.txt", "yellow_cube_solved.txt");
    }};

    /**
     * {@link Parameters} class cannot be instantiated or extended.
     */
    private Parameters() {
    }
}
