package com.bipinet.cubes.pieces;

import com.bipinet.cubes.pieces.HappyCubePiece;
import com.bipinet.cubes.edges.Edge;
import com.bipinet.cubes.edges.EdgeType;
import com.bipinet.cubes.edges.HappyCubeEdge;
import com.bipinet.cubes.parameters.Parameters;
import org.junit.Before;
import org.junit.Test;

import java.util.*;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class HappyCubePieceTest {


    /**
     * Cube pieces ot be used in all the tests as input.
     */
    private static List<HappyCubePiece> HAPPY_CUBE_PIECES;
    private static final String LINE_SEPARATOR = System.lineSeparator();
    private static HappyCubePiece HAPPY_CUBE_PIECE;


    @Before
    public void initialize() {
        HAPPY_CUBE_PIECES = Collections.unmodifiableList(new ArrayList<HappyCubePiece>() {{
            add(new HappyCubePiece(
                    new HappyCubeEdge("  o  "),
                    new HappyCubeEdge(" oo  "),
                    new HappyCubeEdge("  oo "),
                    new HappyCubeEdge(" ooo "))
            );
            add(new HappyCubePiece(
                    new HappyCubeEdge(" ooo "),
                    new HappyCubeEdge(" oo o"),
                    new HappyCubeEdge("oo o "),
                    new HappyCubeEdge(" oo  "))
            );
        }});
        
        /*
        * Happy Cube piece for corner tests
        * 
        *  oooo
        *  oooo
        * ooooo
        *  oooo
        * oooo 
        * 
        * */
        HAPPY_CUBE_PIECE = new HappyCubePiece(
                new HappyCubeEdge("  o o"),
                new HappyCubeEdge(" oooo"),
                new HappyCubeEdge("oooo "),
                new HappyCubeEdge("oooo "));
        
    }
    
    @Test
    public void testGetNotRotatedEdgeCornerAtStart(){
        assertThat("Top edge start corner must be equal to ' '.",
                HAPPY_CUBE_PIECE.getEdgeCornerAtStart(EdgeType.TOP), is(' '));
        assertThat("Bottom edge start corner must be equal to 'o'.",
                HAPPY_CUBE_PIECE.getEdgeCornerAtStart(EdgeType.BOTTOM), is('o'));
        assertThat("Left edge start corner must be equal to ' '.",
                HAPPY_CUBE_PIECE.getEdgeCornerAtStart(EdgeType.LEFT), is(' '));
        assertThat("Right edge start corner must be equal to 'o'.",
                HAPPY_CUBE_PIECE.getEdgeCornerAtStart(EdgeType.RIGHT), is('o'));       
        
    }

    @Test
    public void testGetOnceRotatedEdgeCornerAtStart(){
        HAPPY_CUBE_PIECE.rotate();
        assertThat("Top edge start corner must be equal to 'o'.",
                HAPPY_CUBE_PIECE.getEdgeCornerAtStart(EdgeType.TOP), is('o'));
        assertThat("Bottom edge start corner must be equal to ' '.",
                HAPPY_CUBE_PIECE.getEdgeCornerAtStart(EdgeType.BOTTOM), is(' '));
        assertThat("Left edge start corner must be equal to 'o'.",
                HAPPY_CUBE_PIECE.getEdgeCornerAtStart(EdgeType.LEFT), is('o'));
        assertThat("Right edge start corner must be equal to ' '.",
                HAPPY_CUBE_PIECE.getEdgeCornerAtStart(EdgeType.RIGHT), is(' '));
    }

    @Test
    public void testGetTwiceRotatedEdgeCornerAtStart(){
        HAPPY_CUBE_PIECE.rotate();
        HAPPY_CUBE_PIECE.rotate();
        assertThat("Top edge start corner must be equal to ' '.",
                HAPPY_CUBE_PIECE.getEdgeCornerAtStart(EdgeType.TOP), is(' '));
        assertThat("Bottom edge start corner must be equal to 'o'.",
                HAPPY_CUBE_PIECE.getEdgeCornerAtStart(EdgeType.BOTTOM), is('o'));
        assertThat("Left edge start corner must be equal to ' '.",
                HAPPY_CUBE_PIECE.getEdgeCornerAtStart(EdgeType.LEFT), is(' '));
        assertThat("Right edge start corner must be equal to 'o'.",
                HAPPY_CUBE_PIECE.getEdgeCornerAtStart(EdgeType.RIGHT), is('o'));
    }

    @Test
    public void testGetThriceRotatedEdgeCornerAtStart(){
        HAPPY_CUBE_PIECE.rotate();
        HAPPY_CUBE_PIECE.rotate();
        HAPPY_CUBE_PIECE.rotate();
        assertThat("Top edge start corner must be equal to 'o'.",
                HAPPY_CUBE_PIECE.getEdgeCornerAtStart(EdgeType.TOP), is('o'));
        assertThat("Bottom edge start corner must be equal to ' '.",
                HAPPY_CUBE_PIECE.getEdgeCornerAtStart(EdgeType.BOTTOM), is(' '));
        assertThat("Left edge start corner must be equal to 'o'.",
                HAPPY_CUBE_PIECE.getEdgeCornerAtStart(EdgeType.LEFT), is('o'));
        assertThat("Right edge start corner must be equal to ' '.",
                HAPPY_CUBE_PIECE.getEdgeCornerAtStart(EdgeType.RIGHT), is(' '));
    }

    @Test
    public void testGetNotRotatedEdgeCornerAtEnd(){
        assertThat("Top edge end corner must be equal to 'o'.",
                HAPPY_CUBE_PIECE.getEdgeCornerAtEnd(EdgeType.TOP), is('o'));
        assertThat("Bottom edge end corner must be equal to ' '.",
                HAPPY_CUBE_PIECE.getEdgeCornerAtEnd(EdgeType.BOTTOM), is(' '));
        assertThat("Left edge end corner must be equal to 'o'.",
                HAPPY_CUBE_PIECE.getEdgeCornerAtEnd(EdgeType.LEFT), is('o'));
        assertThat("Right edge end corner must be equal to ' '.",
                HAPPY_CUBE_PIECE.getEdgeCornerAtEnd(EdgeType.RIGHT), is(' '));
    }

    @Test
    public void testGetOnceEdgeCornerAtEnd(){
        HAPPY_CUBE_PIECE.rotate();
        assertThat("Top edge end corner must be equal to ' '.",
                HAPPY_CUBE_PIECE.getEdgeCornerAtEnd(EdgeType.TOP), is(' '));
        assertThat("Bottom edge end corner must be equal to 'o'.",
                HAPPY_CUBE_PIECE.getEdgeCornerAtEnd(EdgeType.BOTTOM), is('o'));
        assertThat("Left edge end corner must be equal to ' '.",
                HAPPY_CUBE_PIECE.getEdgeCornerAtEnd(EdgeType.LEFT), is(' '));
        assertThat("Right edge end corner must be equal to 'o'.",
                HAPPY_CUBE_PIECE.getEdgeCornerAtEnd(EdgeType.RIGHT), is('o'));
    }

    @Test
    public void testGetTwiceEdgeCornerAtEnd(){
        HAPPY_CUBE_PIECE.rotate();
        HAPPY_CUBE_PIECE.rotate();
        assertThat("Top edge end corner must be equal to 'o'.",
                HAPPY_CUBE_PIECE.getEdgeCornerAtEnd(EdgeType.TOP), is('o'));
        assertThat("Bottom edge end corner must be equal to ' '.",
                HAPPY_CUBE_PIECE.getEdgeCornerAtEnd(EdgeType.BOTTOM), is(' '));
        assertThat("Left edge end corner must be equal to 'o'.",
                HAPPY_CUBE_PIECE.getEdgeCornerAtEnd(EdgeType.LEFT), is('o'));
        assertThat("Right edge end corner must be equal to ' '.",
                HAPPY_CUBE_PIECE.getEdgeCornerAtEnd(EdgeType.RIGHT), is(' '));
    }

    @Test
    public void testGetThriceEdgeCornerAtEnd(){
        HAPPY_CUBE_PIECE.rotate();
        HAPPY_CUBE_PIECE.rotate();
        HAPPY_CUBE_PIECE.rotate();
        assertThat("Top edge end corner must be equal to ' '.",
                HAPPY_CUBE_PIECE.getEdgeCornerAtEnd(EdgeType.TOP), is(' '));
        assertThat("Bottom edge end corner must be equal to 'o'.",
                HAPPY_CUBE_PIECE.getEdgeCornerAtEnd(EdgeType.BOTTOM), is('o'));
        assertThat("Left edge end corner must be equal to ' '.",
                HAPPY_CUBE_PIECE.getEdgeCornerAtEnd(EdgeType.LEFT), is(' '));
        assertThat("Right edge end corner must be equal to 'o'.",
                HAPPY_CUBE_PIECE.getEdgeCornerAtEnd(EdgeType.RIGHT), is('o'));
    }
    

    @Test
    public void testToStringArray(){
        List<String[]> expectedPiecesStringArrays =
                Collections.unmodifiableList(new ArrayList<String[]>() {{
                    add(new String[]{
                            " oo  ",
                            " ooo ",
                            "ooooo",
                            " oooo",
                            " ooo "
                    });
                    add(new String[]{
                            " oo o",
                            "ooooo",
                            "oooo ",
                            "ooooo",
                            " oo  "
                    });
                }});

        for (int i = 0; i < HAPPY_CUBE_PIECES.size(); i++){
            final HappyCubePiece actualHappyCubePiece = HAPPY_CUBE_PIECES.get(i);
            final String [] expectedPrintedHappyCubePiece = expectedPiecesStringArrays.get(i);
            assertThat("Piece string arrays must be equal.",
                    actualHappyCubePiece.toStringArray(),
                    is(expectedPrintedHappyCubePiece));

        }
    }

    @Test
    public void testPrintWithOffset(){
        List<String> expectedPrintedPieces =
                Collections.unmodifiableList(new ArrayList<String>() {{
                    add(new String(
                                    "      oo  " + LINE_SEPARATOR +
                                    "      ooo " + LINE_SEPARATOR +
                                    "     ooooo" + LINE_SEPARATOR +
                                    "      oooo" + LINE_SEPARATOR +
                                    "      ooo " + LINE_SEPARATOR
                    ));
                    add(new String(
                                    "      oo o" + LINE_SEPARATOR +
                                    "     ooooo" + LINE_SEPARATOR +
                                    "     oooo " + LINE_SEPARATOR +
                                    "     ooooo" + LINE_SEPARATOR +
                                    "      oo  " + LINE_SEPARATOR
                    ));
                }});
        for (int i = 0; i < HAPPY_CUBE_PIECES.size(); i++){
            final HappyCubePiece actualHappyCubePiece = HAPPY_CUBE_PIECES.get(i);
            final String expectedPrintedHappyCubePiece = expectedPrintedPieces.get(i);
            assertEquals(String.format("Printed piece must be equal to %s %s",
                    LINE_SEPARATOR, expectedPrintedHappyCubePiece),
                    actualHappyCubePiece.printWithOffset(Parameters.HAPPY_CUBE_PIECE_OFFSET),
                    expectedPrintedHappyCubePiece);

        }
    }

    @Test
    public void testPrint(){
        List<String> expectedPrintedPieces =
                Collections.unmodifiableList(new ArrayList<String>() {{
                    add(new String(
                                    " oo  " + LINE_SEPARATOR +
                                    " ooo " + LINE_SEPARATOR +
                                    "ooooo" + LINE_SEPARATOR +
                                    " oooo" + LINE_SEPARATOR +
                                    " ooo " + LINE_SEPARATOR
                    ));
                    add(new String(
                                    " oo o" + LINE_SEPARATOR +
                                    "ooooo" + LINE_SEPARATOR +
                                    "oooo " + LINE_SEPARATOR +
                                    "ooooo" + LINE_SEPARATOR +
                                    " oo  " + LINE_SEPARATOR
                    ));
                }});
        for (int i = 0; i < HAPPY_CUBE_PIECES.size(); i++){
            final HappyCubePiece actualHappyCubePiece = HAPPY_CUBE_PIECES.get(i);
            final String expectedPrintedHappyCubePiece = expectedPrintedPieces.get(i);
            assertEquals(String.format("Printed piece must be equal to %s %s",
                    LINE_SEPARATOR, expectedPrintedHappyCubePiece),
                    actualHappyCubePiece.print(), expectedPrintedHappyCubePiece);

        }
    }

    @Test
    public void testRotate(){
        List<List<HappyCubeEdge>> expectedRotatedEdges =
                Collections.unmodifiableList(new ArrayList<List<HappyCubeEdge>>() {{
                    add(Arrays.asList(new HappyCubeEdge(" ooo "), new HappyCubeEdge("  o  "),
                            new HappyCubeEdge(" oo  "), new HappyCubeEdge(" oo  ")));
                    add(Arrays.asList(new HappyCubeEdge(" oo  "), new HappyCubeEdge(" ooo "),
                            new HappyCubeEdge(" oo o"), new HappyCubeEdge(" o oo")));
                }});
        assertThat("Size of actual and expected lists must be equal.",
                HAPPY_CUBE_PIECES.size(), is(expectedRotatedEdges.size()));
        for (int i = 0; i < HAPPY_CUBE_PIECES.size(); i++){
            final HappyCubePiece actualHappyCubePiece = HAPPY_CUBE_PIECES.get(i);
            actualHappyCubePiece.rotate();
            testAllEdgesAreEqual(actualHappyCubePiece, expectedRotatedEdges.get(i));
        }
    }

    @Test
    public void testFlip(){
        List<List<HappyCubeEdge>> expectedFlippedEdges =
                Collections.unmodifiableList(new ArrayList<List<HappyCubeEdge>>() {{
                    add(Arrays.asList(new HappyCubeEdge("  o  "), new HappyCubeEdge(" ooo "),
                            new HappyCubeEdge(" oo  "), new HappyCubeEdge(" oo  ")));
                    add(Arrays.asList(new HappyCubeEdge(" ooo "), new HappyCubeEdge(" oo  "),
                            new HappyCubeEdge(" o oo"), new HappyCubeEdge(" oo o")));
                }});
        assertThat("Size of actual and expected lists must be equal.",
                HAPPY_CUBE_PIECES.size(), is(expectedFlippedEdges.size()));
        for (int i = 0; i < HAPPY_CUBE_PIECES.size(); i++){
            final HappyCubePiece actualHappyCubePiece = HAPPY_CUBE_PIECES.get(i);
            actualHappyCubePiece.flip();
            testAllEdgesAreEqual(actualHappyCubePiece, expectedFlippedEdges.get(i));
        }
    }

    @Test
    public void testGetLeftEdge(){
        List<HappyCubeEdge> expectedLeftEdges =
                Collections.unmodifiableList(new ArrayList<HappyCubeEdge>() {{
                    add(new HappyCubeEdge("  o  "));
                    add(new HappyCubeEdge(" ooo "));

                }});
        assertThat("Size of actual and expected lists must be equal.",
                HAPPY_CUBE_PIECES.size(), is(expectedLeftEdges.size()));
        for (int i = 0; i < HAPPY_CUBE_PIECES.size(); i++){
            final Edge actualHappyCubeEdge = HAPPY_CUBE_PIECES.get(i).getLeftEdge();
            final HappyCubeEdge expectedLeftHappyCubeEdge = expectedLeftEdges.get(i);
            assertEquals(String.format("Left edge must be %s", expectedLeftHappyCubeEdge.getPattern()),
                    actualHappyCubeEdge, expectedLeftHappyCubeEdge);
        }
    }

    @Test
    public void testGetTopEdge(){
        List<HappyCubeEdge> expectedTopEdges =
                Collections.unmodifiableList(new ArrayList<HappyCubeEdge>() {{
                    add(new HappyCubeEdge(" oo  "));
                    add(new HappyCubeEdge(" oo o"));

                }});
        assertThat("Size of actual and expected lists must be equal.",
                HAPPY_CUBE_PIECES.size(), is(expectedTopEdges.size()));
        for (int i = 0; i < HAPPY_CUBE_PIECES.size(); i++){
            final Edge actualHappyCubeEdge = HAPPY_CUBE_PIECES.get(i).getTopEdge();
            final HappyCubeEdge expectedHappyCubeEdge = expectedTopEdges.get(i);
            assertEquals(String.format("Top edge must be %s", expectedHappyCubeEdge.getPattern()),
                    actualHappyCubeEdge, expectedHappyCubeEdge);
        }
    }

    @Test
    public void testGetRightEdge(){
        List<HappyCubeEdge> expectedRightEdges =
                Collections.unmodifiableList(new ArrayList<HappyCubeEdge>() {{
                    add(new HappyCubeEdge("  oo "));
                    add(new HappyCubeEdge("oo o "));

                }});
        assertThat("Size of actual and expected lists must be equal.",
                HAPPY_CUBE_PIECES.size(), is(expectedRightEdges.size()));
        for (int i = 0; i < HAPPY_CUBE_PIECES.size(); i++){
            final Edge actualHappyCubeEdge = HAPPY_CUBE_PIECES.get(i).getRightEdge();
            final HappyCubeEdge expectedHappyCubeEdge = expectedRightEdges.get(i);
            assertEquals(String.format("Right edge must be %s", expectedHappyCubeEdge.getPattern()),
                    actualHappyCubeEdge, expectedHappyCubeEdge);
        }
    }

    @Test
    public void testGetBottomEdge(){
        List<HappyCubeEdge> expectedBottomEdges =
                Collections.unmodifiableList(new ArrayList<HappyCubeEdge>() {{
                    add(new HappyCubeEdge(" ooo "));
                    add(new HappyCubeEdge(" oo  "));

                }});
        assertThat("Size of actual and expected lists must be equal.",
                HAPPY_CUBE_PIECES.size(), is(expectedBottomEdges.size()));
        for (int i = 0; i < HAPPY_CUBE_PIECES.size(); i++){
            final Edge actualHappyCubeEdge = HAPPY_CUBE_PIECES.get(i).getBottomEdge();
            final HappyCubeEdge expectedHappyCubeEdge = expectedBottomEdges.get(i);
            assertEquals(String.format("Bottom edge must be %s", expectedHappyCubeEdge.getPattern()),
                    actualHappyCubeEdge, expectedHappyCubeEdge);
        }
    }

    /**
     * Test helper method to test that all edges in the actual cube are equal to the expected cube edges.
     * @param actualHappyCubePiece actual cube with all 4 edges.
     * @param expectedHappyCubeEdges list of expected cube edges, must be 4 in size.
     */
    private static void testAllEdgesAreEqual(final HappyCubePiece actualHappyCubePiece,
                                             final List<HappyCubeEdge> expectedHappyCubeEdges){
        //actual
        final Edge actualLeftHappyCubeEdge = actualHappyCubePiece.getLeftEdge();
        final Edge actualTopHappyCubeEdge = actualHappyCubePiece.getTopEdge();
        final Edge actualRightHappyCubeEdge = actualHappyCubePiece.getRightEdge();
        final Edge actualBottomHappyCubeEdge = actualHappyCubePiece.getBottomEdge();
        //expected
        final HappyCubeEdge expectedLeftHappyCubeEdge = expectedHappyCubeEdges.get(0);
        final HappyCubeEdge expectedTopHappyCubeEdge = expectedHappyCubeEdges.get(1);
        final HappyCubeEdge expectedRightHappyCubeEdge = expectedHappyCubeEdges.get(2);
        final HappyCubeEdge expectedBottomHappyCubeEdge = expectedHappyCubeEdges.get(3);
        //test
        assertEquals(String.format("Left edge must be %s", expectedLeftHappyCubeEdge.getPattern()),
                actualLeftHappyCubeEdge, expectedLeftHappyCubeEdge);
        assertEquals(String.format("Top edge must be %s", expectedTopHappyCubeEdge.getPattern()),
                actualTopHappyCubeEdge, expectedTopHappyCubeEdge);
        assertEquals(String.format("Right edge must be %s", expectedRightHappyCubeEdge.getPattern()),
                actualRightHappyCubeEdge, expectedRightHappyCubeEdge);
        assertEquals(String.format("Bottom edge must be %s", expectedBottomHappyCubeEdge.getPattern()),
                actualBottomHappyCubeEdge, expectedBottomHappyCubeEdge);
    }
}
