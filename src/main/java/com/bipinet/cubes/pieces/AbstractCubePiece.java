package com.bipinet.cubes.pieces;

import com.bipinet.cubes.cube.Cube;
import com.bipinet.cubes.edges.Edge;

import java.util.List;

/**
 * Abstract implementation of the {@link Piece} that should be extended by the concrete implementations.
 */
public abstract class AbstractCubePiece implements Piece {
    /**
     * List with {@link Edge}s of the piece.
     */
    private final List<Edge> edges;

    /**
     * {@link AbstractCubePiece} of the {@link Cube} that must be initialized at construction time.
     * @param edges List with {@link Edge}s of the piece.
     */
    public AbstractCubePiece(final List<Edge> edges) {
        this.edges = edges;
    }

    public List<Edge> getEdges() {
        return edges;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AbstractCubePiece that = (AbstractCubePiece) o;

        return edges.equals(that.edges);

    }

    @Override
    public int hashCode() {
        return edges.hashCode();
    }

    @Override
    public String toString() {
        return "AbstractCubePiece{" +
                "edges=" + edges +
                '}';
    }
}
