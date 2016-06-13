package com.bipinet.cubes.cube;


import com.bipinet.cubes.exceptions.CubeNotSolvedException;
import com.bipinet.cubes.pieces.Piece;
import com.bipinet.cubes.sides.Sides;
import com.bipinet.cubes.solver.CubeSolver;

import java.util.List;


/**
 * Interface providing contract methods the {@link Cube} implementations.
 */
public interface Cube {
    
    /**
     * Read {@link Piece}s from the specified file.
     * @param filePath path to the file with {@link Piece}s.
     * @return true if the file was successfully read, false otherwise.
     */
    boolean readPiecesFromFile(String filePath);

    /**
     * Write {@link Piece}s to the specified file.
     * @param filePath path to the destination file for {@link Piece}s.
     * @return true if the file was successfully written, false otherwise.
     */
    boolean writePiecesToFile(String filePath);

    /**
     * Get all pieces of the cube.
     * @return list with {@link Piece}s.
     */
    List<Piece> getPieces();

    /**
     * Get all sides of the cube.
     * @return list with {@link Sides}.
     */
    Sides getSides();

    /**
     * Solve the cube.
     * @return solved cube.
     * @throws CubeNotSolvedException if the cube cannot be solved throw an exception.
     */
    Cube solve() throws CubeNotSolvedException;

    /**
     * Print {@link Piece}s in unfolded form.
     * @return String representing the cube in unfolded form.
     */
    String printUnfolded();

    /**
     * Get {@link CubeSolver} to be used for solving the cube.
     * @return reference to the {@link CubeSolver}.
     */
    CubeSolver getCubeSolver();
}
