package com.bipinet.cubes.cube;

import com.bipinet.cubes.corners.HappyCubeCorners;
import com.bipinet.cubes.edges.HappyCubeEdge;
import com.bipinet.cubes.exceptions.CubeNotSolvedException;
import com.bipinet.cubes.parameters.Parameters;
import com.bipinet.cubes.pieces.HappyCubePiece;
import com.bipinet.cubes.pieces.Piece;
import com.bipinet.cubes.sides.HappyCubeSides;
import com.bipinet.cubes.sides.Sides;
import com.bipinet.cubes.solver.CubeSolver;
import com.bipinet.cubes.solver.HappyCubeSolver;
import com.bipinet.cubes.utils.FileUtils;

import java.io.*;
import java.util.*;
import java.util.regex.Pattern;


/**
 *
 *  Happy Cube implementation.
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
 */
public class HappyCube extends AbstractCube {
    public HappyCube(Sides sides, CubeSolver cubeSolver) {
        super(sides, cubeSolver);
    }

    @Override
    public boolean readPiecesFromFile(String filePath) {
        Scanner scanner = null;
        String[] inputPieces = new String[Parameters.NUMBER_OF_LINES_IN_INPUT_FILE];
        int lineCount = 0;
        try {
            scanner = new Scanner(new File(filePath));
            while (scanner.hasNextLine()) {
                lineCount++;
                inputPieces[lineCount-1] = scanner.nextLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return abort(String.format("Aborting! Cannot find file %s.", filePath));
        } finally {
            if (scanner != null) {
                scanner.close();
            }
            if (!isLineCountValid(lineCount)) {
                return false;
            }
        }
        createPieces(inputPieces, Parameters.NUMBER_OF_ROWS);
        return true;
    }

    @Override
    public boolean writePiecesToFile(String filePath) {
        PrintWriter out = null;
        try {
            out = new PrintWriter(filePath);
            out.println(this.printUnfolded());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return false;
        } finally{
            if (out != null){
                out.close();
            }
        }
        return true;
    }
    
    
    @Override
    public String printUnfolded() {
        final StringBuilder unfoldedCubeBuilder = new StringBuilder();
        final List<Piece> pieces = this.getPieces();
        List<String> concatenatedFirstThreePieces = new ArrayList<String>(Parameters.HAPPY_CUBE_SIZE);
        String[] firstPieceStringArray = pieces.get(0).toStringArray();
        String[] secondPieceStringArray = pieces.get(1).toStringArray();
        String[] thirdPieceStringArray = pieces.get(5).toStringArray();
        for (int i = 0; i < Parameters.HAPPY_CUBE_SIZE; i++){
            concatenatedFirstThreePieces.add(firstPieceStringArray[i] +
                    secondPieceStringArray[i] + thirdPieceStringArray[i]);
        }
        for (String concatString : concatenatedFirstThreePieces){
            unfoldedCubeBuilder.append(String.format("%s%s", concatString, System.lineSeparator()));
        }
        for (int i = 2; i < pieces.size() - 1; i++){
            unfoldedCubeBuilder.append(pieces.get(i).printWithOffset(Parameters.HAPPY_CUBE_PIECE_OFFSET));
        }
        return unfoldedCubeBuilder.toString();
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public String toString() {
        return super.toString();
    }

    /**
     * Prints a message to the System.out and return false.
     * @param message {@link String} containing the text ro be printed.
     * @return false;
     */
    private final boolean abort(String message){
        System.out.println(message);
        return false;
    }

    /**
     * Prints a message to the System.out and clears the {@link #pieces}.
     * @param message {@link String} containing the text ro be printed.
     * @return false;
     */
    private final boolean abortLoading(String message){
        System.err.println(message);
        if (getPieces() != null){
            getPieces().clear();
        }
        return false;    }

    /**
     * Validates if the line length is valid and that it contains only allowed characters.
     *
     * @param line {@link String} line to be validated.
     * @param lineNumber current number of the line in the file.
     * @return true if the validation passes, false otherwise.
     */
    final boolean isLineValid(String line, int lineNumber){
        if (lineNumber > Parameters.NUMBER_OF_LINES_IN_INPUT_FILE){
            return abortLoading(String.format(
                    "Aborting! File contains too many lines and exceeds the maximum allowed size %s.",
                    Parameters.NUMBER_OF_LINES_IN_INPUT_FILE));
        }
        //Check if length of the line does is equal to the max allowed and that it does contain only valid characters.
        if (!Pattern.compile(Parameters.LINE_VALIDATION_REGEX).matcher(line).matches()){
            return abortLoading(String.format(
                    "Aborting! Line %s either contains invalid characters or is not equal to the allowed length %s.",
                    line, Parameters.NUMBER_OF_CHARACTERS_PER_LINE_INPUT_FILE));
        }
        return true;
    }

    /**
     * Validates if the passed in line count is valid.
     * @param lineCount line count to be validated.
     * @return true if valid, false otherwise.
     */
    final boolean isLineCountValid(int lineCount){
        if ((lineCount > Parameters.NUMBER_OF_LINES_IN_INPUT_FILE) ||
                (lineCount < Parameters.NUMBER_OF_LINES_IN_INPUT_FILE)){
            return abortLoading(String.format(
                    "Aborting! Line count is not equal to %s.",
                    Parameters.NUMBER_OF_LINES_IN_INPUT_FILE));
        }
        return true;
    }

    /**
     * Recursively parses the passed in string array into a list of {@link Piece}.
     * @param inputPieces array representing pieces. 3 pieces are arranged
     *                    in a single row adjacent to each other each consisting of 5 consecutive elements. 
     *                    Total length of 15 elements for 3 pieces.
     * @param numberOfRows number of repetitions, corresponding to the number of rows with pieces to be parsed.
     */
    private final void createPieces(String[] inputPieces, int numberOfRows) {
        if (numberOfRows == 0) return;
        //Create 3 pieces in each row.
        for (int pieceStartIndex = 0;
             pieceStartIndex < Parameters.PIECES_IN_ROW * Parameters.HAPPY_CUBE_SIZE;
             pieceStartIndex+=Parameters.HAPPY_CUBE_SIZE) {
            StringBuilder leftEdgeBuilder = new StringBuilder(Parameters.HAPPY_CUBE_SIZE);
            StringBuilder topEdgeBuilder =  new StringBuilder(Parameters.HAPPY_CUBE_SIZE);
            StringBuilder rightEdgeBuilder =  new StringBuilder(Parameters.HAPPY_CUBE_SIZE);
            StringBuilder bottomEdgeBuilder =  new StringBuilder(Parameters.HAPPY_CUBE_SIZE);
            topEdgeBuilder.append(inputPieces[0].substring(
                    pieceStartIndex, pieceStartIndex + Parameters.HAPPY_CUBE_SIZE));
            bottomEdgeBuilder.append(inputPieces[4].substring(
                    pieceStartIndex, pieceStartIndex + Parameters.HAPPY_CUBE_SIZE));
            for (int lineNumber = 0; lineNumber <= 4; lineNumber++) {
                leftEdgeBuilder.append(inputPieces[lineNumber].substring(pieceStartIndex, pieceStartIndex + 1));
                rightEdgeBuilder.append(inputPieces[lineNumber].substring(
                        pieceStartIndex + Parameters.HAPPY_CUBE_SIZE - 1,
                        pieceStartIndex + Parameters.HAPPY_CUBE_SIZE));
            }
            this.getPieces().add(new HappyCubePiece(
                    new HappyCubeEdge(leftEdgeBuilder.toString()),
                    new HappyCubeEdge(topEdgeBuilder.toString()),
                    new HappyCubeEdge(rightEdgeBuilder.toString()),
                    new HappyCubeEdge(bottomEdgeBuilder.toString())
            ));
        }
        createPieces(Arrays.copyOfRange(inputPieces, Parameters.HAPPY_CUBE_SIZE, inputPieces.length), numberOfRows - 1);
    }

    /**
     * Main method to initialise the cube.
     * @param args
     */
    public static void main(String[] args) {
        for (Map.Entry<String, String> happyCubeFiles : Parameters.HAPPY_CUBE_FILE_NAMES.entrySet()){
            final String happyCubeNotSolvedFileName = happyCubeFiles.getKey();
            final String happyCubeSolvedFileName = happyCubeFiles.getValue();
            //Copy the not solved cube files from the classpath to the working directory (outside JAR).
            File happyCubeNotSolvedFileOutsideJar = FileUtils.copyFileFromClassPath(happyCubeNotSolvedFileName);
           if (happyCubeNotSolvedFileOutsideJar == null){
               System.err.println(String.format("An unexpected error occurred when copying %s to outside of %s.",
                       happyCubeNotSolvedFileName, new java.io.File(HappyCube.class.getProtectionDomain()
                               .getCodeSource().getLocation().getPath()).getName()));
               System.exit(1);
           }
            HappyCube happyCube = new HappyCube(new HappyCubeSides(new HappyCubeCorners()), new HappyCubeSolver());
            if (happyCubeNotSolvedFileOutsideJar == null || !happyCubeNotSolvedFileOutsideJar.exists()){
                System.err.println(String.format("File %s does not exist!",
                        happyCubeNotSolvedFileOutsideJar.getName()));
                System.exit(1);
            }
            //If something fails exit with error code 1.
            if (!happyCube.readPiecesFromFile(happyCubeNotSolvedFileOutsideJar.getAbsolutePath()))
                System.exit(1);
            try {
                long startTime = System.currentTimeMillis();               
                happyCube.solve();
                System.out.println(String.format("Finding solution for %s took %sms.",
                        happyCubeNotSolvedFileOutsideJar.getName(), (System.currentTimeMillis() - startTime)));
            } catch (CubeNotSolvedException e) {
                e.printStackTrace();
                System.exit(1);
            }
            if (!happyCube.writePiecesToFile(happyCubeSolvedFileName)){
                System.err.println(String.format("An unexpected error occurred when writing %s!",
                        happyCubeSolvedFileName));
                System.exit(1);
            }
            System.out.println(String.format("Solved happy cube file %s and successfully saved to %s.",
                    happyCubeNotSolvedFileOutsideJar.getName(), happyCubeSolvedFileName));
        }
    }
}
