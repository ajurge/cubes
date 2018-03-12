package com.bipinet.cubes.edges;

/**
 * Happy Cube edge implementation of the {@link Edge}.
 *
 <p> Happy Cube edge marking and direction.   
 <pre>  
 *     
 *     Tail of the arrow marks the start corner {@code --->} head of the arrow marks the end corner
 *     
 *                     {@code --->}
 *
 *                    TOP (1)
 *                   ooooo         
 *       |           o   o            |
 *       |  LEFT(0)  o   o  RIGHT(2)  |
 *      \/           o   o           \/
 *                   ooooo         
 *
 *                   BOTTOM (3)
 *
 *                   {@code --->}
 *
 </pre>
 *
 * 
 */
public class HappyCubeEdge extends AbstractCubeEdge {

    public HappyCubeEdge(String pattern) {
        super(pattern);
    }

    @Override
    public final void reverse() {
        setPattern(new StringBuilder(super.pattern).reverse().toString());
    }

    public final boolean matchesTo(Edge edge) {
        if ((!super.pattern.contains("o")) && (!edge.getPattern().contains("o"))) return false;
        for (int i = 0; i < super.pattern.length(); i++){
            final char currentPatternSquare = super.pattern.charAt(i);
            if (currentPatternSquare == 'o'){
                if (currentPatternSquare == edge.getPattern().charAt(i)) return false;
            }   
        }
        return true;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }
}




