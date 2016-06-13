package com.bipinet.cubes.edges;

import com.bipinet.cubes.edges.HappyCubeEdge;
import org.junit.Test;

import java.util.*;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class HappyCubeEdgeTest {

    @Test
    public void testCreateEdge(){
        Map<String, String> inputToExpectedOutputMapping =
                Collections.unmodifiableMap(new HashMap<String, String>() {{
                    put("  o  ", "  o  ");
                    put("ooooo", "ooooo");
                    put("o o o", "o o o");
                    put("oo  o", "oo  o");
                    put("o  oo", "o  oo");
                    put("oooo ", "oooo ");
                    put(" oooo", " oooo");
                    put("    o", "    o");
                    put("o    ", "o    ");
                    put("ooo  ", "ooo  ");
                    put("  ooo", "  ooo");

                }});

        for (Map.Entry<String, String> entry : inputToExpectedOutputMapping.entrySet()){
            final String inputString = entry.getKey();
            final String expectedOutput = entry.getValue();
            assertThat(String.format("Input string %s must be converted to %s", inputString, expectedOutput),
                    new HappyCubeEdge(inputString).getPattern(), is(expectedOutput));

        }
    }

    @Test
    public void testReverse(){
        Map<String, String> inputToExpectedOutputMapping =
                Collections.unmodifiableMap(new HashMap<String, String>() {{
                    put("  o  ", "  o  ");
                    put("ooooo", "ooooo");
                    put("o o o", "o o o");
                    put("oo  o", "o  oo");
                    put("o  oo", "oo  o");
                    put("oooo ", " oooo");
                    put(" oooo", "oooo ");
                    put("    o", "o    ");
                    put("o    ", "    o");
                    put("ooo  ", "  ooo");
                    put("  ooo", "ooo  ");
                }});
        for (Map.Entry<String, String> entry : inputToExpectedOutputMapping.entrySet()){
            final String inputString = entry.getKey();
            final String expectedOutput = entry.getValue();
            final HappyCubeEdge happyCubeEdge = new HappyCubeEdge(inputString);
            happyCubeEdge.reverse();
            assertThat(String.format("Input string %s must be converted to %s", inputString, expectedOutput),
                    happyCubeEdge.getPattern(), is(expectedOutput));
        }
    }


    @Test
    public void testPrintPattern(){
        Set<String> inputAndExpectedOutputSet =
                Collections.unmodifiableSet(new HashSet<String>() {{
                    add("  o  ");
                    add("ooooo");
                    add("o o o");
                    add("oo  o");
                    add("o  oo");
                    add("oooo ");
                    add(" oooo");
                    add("    o");
                    add("o    ");
                    add("ooo  ");
                    add("  ooo");
                }});

        for (String inputAndExpectedOutput : inputAndExpectedOutputSet){
            final HappyCubeEdge happyCubeEdge = new HappyCubeEdge(inputAndExpectedOutput);
            assertThat(String.format("Printed string must be %s", inputAndExpectedOutput),
                    happyCubeEdge.getPattern(), is(inputAndExpectedOutput));
        }
    }

    @Test
    public void testCorrectMatchesTo(){
        Map<String, String> patternsToMatch =
                Collections.unmodifiableMap(new HashMap<String, String>() {{
                    put("  o  ", " o o ");
                    put("  o  ", "oo  o");
                    put("ooooo", "     ");
                    put("o o o", " o o ");
                    put("oo  o", "  oo ");
                    put("o  oo", " o   ");
                    put("oooo ", "    o");
                    put(" oooo", "o    ");
                    put("    o", "oooo ");
                    put("o    ", " oooo");
                    put("ooo  ", "   oo");
                    put("  ooo", "oo   ");
                }});
        for (Map.Entry<String, String> entry : patternsToMatch.entrySet()){
            final String inputPattern = entry.getKey();
            final String patternToMatch = entry.getValue();
            final HappyCubeEdge happyCubeEdge = new HappyCubeEdge(inputPattern);
            assertThat(String.format("Input pattern %s must match %s", inputPattern, patternToMatch),
                    happyCubeEdge.matchesTo(new HappyCubeEdge(patternToMatch)), is(true));
        }
    }

    @Test
    public void testIncorrectMatchesTo(){
        Map<String, String> patternsToMatch =
                Collections.unmodifiableMap(new HashMap<String, String>() {{
                    put("  o  ", "ooo o");
                    put("ooooo", "o    ");
                    put("ooooo", "ooooo");
                    put("     ", "     ");
                    put("o o o", " ooo ");
                    put("oo  o", "o oo ");
                    put("o  oo", " o  o");
                    put("oooo ", "  o o");
                    put(" oooo", "o  o ");
                    put("    o", " oooo");
                    put("o    ", "o ooo");
                    put("ooo  ", "oo oo");
                    put("  ooo", "ooo  ");
                }});
        for (Map.Entry<String, String> entry : patternsToMatch.entrySet()){
            final String inputPattern = entry.getKey();
            final String patternToMatch = entry.getValue();
            final HappyCubeEdge happyCubeEdge = new HappyCubeEdge(inputPattern);
            assertThat(String.format("Input pattern %s must NOT match %s", inputPattern, patternToMatch),
                    happyCubeEdge.matchesTo(new HappyCubeEdge(patternToMatch)), is(false));
        }
    }
}
