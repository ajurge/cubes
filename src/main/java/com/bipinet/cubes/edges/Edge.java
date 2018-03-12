package com.bipinet.cubes.edges;


import com.bipinet.cubes.cube.Cube;
import com.bipinet.cubes.pieces.Piece;

/**
 * Interface providing contract methods for the edge forming a {@link Piece} which in turn is part of the {@link Cube}.
 */
public interface Edge {
    /**
     * Reverse the edge 180 degrees.
     */
    void reverse();

    /**
     * Get the string representation of the edge pattern.
     * @return string
     */
    String getPattern();

    /**
     * Match with the passed in edge.
     * @param edge reference to the {@link Edge} that will be matched.
     * @return true if both edges match, false otherwise.
     */
    boolean matchesTo(Edge edge);

}
