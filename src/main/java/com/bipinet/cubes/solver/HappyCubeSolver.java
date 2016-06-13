package com.bipinet.cubes.solver;


import com.bipinet.cubes.cube.Cube;
import com.bipinet.cubes.cube.HappyCube;
import com.bipinet.cubes.pieces.Piece;
import com.bipinet.cubes.sides.Sides;

import java.util.*;

/**
 * Implementation of the {@link HappyCube} solver.
 */
public class HappyCubeSolver implements CubeSolver {
    
    @Override
    public boolean solveCube(Cube cube) {        
        return solveHappyCubeRecursively(cube.getPieces(), cube.getSides(), 1);       
    }

    /**
     * Recursive algorithm to solve the {@link HappyCube}. Recursively builds all the possible combinations of 
     * the passed in pieces and tries to match the {@link Sides} by rotating and flipping each {@link Piece} as 
     * defined in implementation of the side.
     * @param pieces {@link List} with {@link Piece}s to be matched.
     * @param sides reference to the {@link Sides} of the {@link HappyCube} that the pieces will be matched to.
     * @param start index of the {@link Piece} in the list to start from.
     * @return true if solution was found, false otherwise.
     */
    private final boolean solveHappyCubeRecursively(List<Piece> pieces, Sides sides, int start){       
        for (int i =  start; i< pieces.size(); i++){
            Collections.swap(pieces, i, start);
            if (solveHappyCubeRecursively(pieces, sides, start + 1) == true) return true;
            Collections.swap(pieces, start, i);
        }
        //Once a unique combination of the pieces is built rotatae and flip piece 0 and then try to match all 
        // the sides of the cube.
        if (start == pieces.size() - 1) {
            final Piece startPiece = pieces.get(0);
            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < 4; j++) {
                    if (sides.matchLeft(pieces) &&
                            sides.matchTop(pieces) &&
                            sides.matchBack(pieces) &&
                            sides.matchRight(pieces) &&
                            sides.matchBottom(pieces) &&
                            sides.matchFront(pieces)) return true;
                    startPiece.rotate();
                }
                startPiece.flip();
            }               
        }
        return false;
    }
}
