package com.bipinet.cubes.solver;


import com.bipinet.cubes.cube.Cube;

/**
 * Interface for {@link Cube} solver implementations.
 */
public interface CubeSolver {
    /**
     * Solve the passed in {@link Cube}.
     * @param cube {@link Cube} to be solved.
     * @return true if solution was found, false otherwise.
     */
    boolean solveCube(Cube cube);
}
