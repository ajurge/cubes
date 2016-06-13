package com.bipinet.cubes.utils;


import com.bipinet.cubes.utils.FileUtils;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertNotNull;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class FileUtilsTest {

    @Test
    public void testCopyFileFromClassPath() throws IOException, URISyntaxException {
        String testFile = "testFile.txt";
        String fullPathToCurrentWorkingDir = new File(FileUtils.class.getProtectionDomain().
                getCodeSource().getLocation().toURI().getPath()).getParent();
        File expectedCopiedFile = new File(fullPathToCurrentWorkingDir, testFile);
        //Delete if the copiedFile exists and prove it does not exist.
        if (expectedCopiedFile.exists()) expectedCopiedFile.delete();
        assertFalse(String.format("File %s must NOT exist!", expectedCopiedFile.getAbsolutePath()),
                expectedCopiedFile.exists());
        //Copy the new file and prove it exists.
        File actualCopiedFile = FileUtils.copyFileFromClassPath(testFile);
        assertNotNull(String.format("File %s must be copied successfully!", expectedCopiedFile.getAbsolutePath()),
                actualCopiedFile);
        assertThat("Copied files must be equal.", actualCopiedFile, is(expectedCopiedFile));
        assertTrue(String.format("File %s must exist!", expectedCopiedFile.getAbsolutePath()),
                expectedCopiedFile.exists());
        //Delete and prove it does not exist.
        expectedCopiedFile.delete();
        assertFalse(String.format("File %s must NOT exist!", expectedCopiedFile.getAbsolutePath()),
                expectedCopiedFile.exists());
    }
}
