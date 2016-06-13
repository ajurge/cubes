package com.bipinet.cubes.cube;


import com.bipinet.cubes.exceptions.CubeNotSolvedException;
import com.bipinet.cubes.pieces.Piece;
import com.bipinet.cubes.sides.Sides;
import com.bipinet.cubes.solver.CubeSolver;

import java.util.ArrayList;
import java.util.List;


/**
 * Abstract implementation of the {@link Cube} that should be extended by the concrete implementations.
 */
public abstract class AbstractCube implements Cube {
    /**
     * List with {@link Piece} that will composed the solved cube.
     */
    private final List<Piece> pieces = new ArrayList<>();

    /**
     * {@link Sides} representing concrete implementation for {@link Piece} matching.
     */
    private final Sides sides;

    /**
     * {@link CubeSolver} implementing an algorithm to solve the cube.
     */
    private final CubeSolver cubeSolver;


    /**
     * Constructor to instantiate {@link AbstractCube} with a reference to {@link Sides} and {@link CubeSolver}.
     * 
     * @param sides reference to the implementation of the cube {@link Sides}. Cannot be null.
     * @param cubeSolver reference to the implementation of the cube {@link CubeSolver}. Cannot be null.
     */
    protected AbstractCube(Sides sides, CubeSolver cubeSolver) {
        if (sides == null){
            throw new IllegalArgumentException(String.format("sides in %s cannot be null.",
                    AbstractCube.class.getName()));
        }
        if (cubeSolver == null){
            throw new IllegalArgumentException(String.format("cubeSolver in %s cannot be null.",
                    AbstractCube.class.getName()));
        }
        this.sides = sides;
        this.cubeSolver = cubeSolver;
    }

    @Override
    public List<Piece> getPieces() {
        return pieces;
    }

    @Override
    public Sides getSides() {
        return sides;
    }

    public CubeSolver getCubeSolver() {
        return cubeSolver;
    }

    @Override
    public Cube solve() throws CubeNotSolvedException {
        if (!this.getCubeSolver().solveCube(this))
            throw new CubeNotSolvedException("Cube could not be solved.");
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AbstractCube that = (AbstractCube) o;

        if (!pieces.equals(that.pieces)) return false;
        return cubeSolver.equals(that.cubeSolver);

    }

    @Override
    public int hashCode() {
        int result = pieces.hashCode();
        result = 31 * result + cubeSolver.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "AbstractCube{" +
                "pieces=" + pieces +
                ", cubeSolver=" + cubeSolver +
                '}';
    }
}
