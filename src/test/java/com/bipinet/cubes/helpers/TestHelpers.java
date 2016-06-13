package com.bipinet.cubes.helpers;


import java.io.File;

import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.assertTrue;

public class TestHelpers {

    /**
     * Helper method for testing if the specified file exists.
     * @param fullPathToFile full path to the file to be tested.
     */
    public static void testFileExists(String fullPathToFile){
        File file = new File(fullPathToFile);
        //Prove that the file exists!
        assertTrue(String.format("File %s must exist!", file.getAbsolutePath()), file.exists());
    }

    /**
     * Helper method for testing if the specified file does not exist.
     * @param fullPathToFile full path to the file to be tested.
     */
    public static void testFileNotExist(String fullPathToFile){
        File file = new File(fullPathToFile);
        //Prove that the file does not exist!
        assertFalse(String.format("File %s must NOT exist!", file.getAbsolutePath()), file.exists());
    }
}
