package com.bipinet.cubes.sides;


import com.bipinet.cubes.corners.Corners;
import com.bipinet.cubes.cube.Cube;

/**
 * Abstract implementation of the {@link Sides} that should be extended by the concrete implementations.
 */
public abstract class AbstractSides implements Sides {
    /**
     * {@link Corners} of the {@link Cube} that must be initialized at construction time. 
     */
    private Corners corners;

    /**
     * {@link Sides} constructor to instantiate {@link Sides} with a reference to {@link Corners}.
     * @param corners not null reference to {@link Corners}. 
     */
    public AbstractSides(Corners corners) {
        if (corners == null){
            throw new IllegalArgumentException(String.format("corners in %s cannot be null.",
                    AbstractSides.class.getName()));
        }
        this.corners = corners;
    }

    public Corners getCorners() {
        return corners;
    }
}
