package com.bipinet.cubes.parameters;
import com.bipinet.cubes.parameters.Parameters;
import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ParametersTest {

    @Test
    public void testAllParametersClassFieldsAreFinal(){
        //Loop trough all the fields and prove they are declared as final.
        for(Field field : Parameters.class.getDeclaredFields()){
            assertTrue(String.format(
                    "%s class field %s must be declared as final!", Parameters.class.getSimpleName(), field.getName()),
                    Modifier.isFinal(field.getModifiers()));
        }
    }

    @Test
    public void testParametersValues(){
        final int expectedHappyCubeSize = 5;
        final int expectedHappyCubeNumberOfPieces = 6;
        assertThat(String.format("Happy cubes size must be %s.", expectedHappyCubeSize),
                Parameters.HAPPY_CUBE_SIZE, is(expectedHappyCubeSize));
        assertThat(String.format("Happy cubes must have %s pieces.", expectedHappyCubeNumberOfPieces),
                Parameters.HAPPY_CUBE_NUMBER_OF_PIECES, is(expectedHappyCubeNumberOfPieces));
    }




}
