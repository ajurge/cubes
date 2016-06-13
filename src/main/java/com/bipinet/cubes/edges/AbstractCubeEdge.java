package com.bipinet.cubes.edges;

/**
 * 
 */
public abstract class AbstractCubeEdge implements Edge {
    /**
     * String with symbols forming the edge.
     */
    protected String pattern;

    /**
     * Constructor to instantiate {@link AbstractCubeEdge} with a pattern.
     */
    public AbstractCubeEdge(String pattern) {
        this.pattern = pattern;
    }

    public String getPattern() {
        return pattern;
    }

    public void setPattern(String pattern) {
        this.pattern = pattern;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AbstractCubeEdge that = (AbstractCubeEdge) o;

        return pattern.equals(that.pattern);

    }

    @Override
    public int hashCode() {
        return pattern.hashCode();
    }

    @Override
    public String toString() {
        return "AbstractCubeEdge{" +
                "pattern='" + pattern + '\'' +
                '}';
    }
}
