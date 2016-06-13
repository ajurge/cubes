package com.bipinet.cubes.utils;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

/**
 * Implements different methods for file handling.
 */
public final class FileUtils {
    /**
     * {@link FileUtils} class cannot be instantiated or extended.
     */
    private FileUtils() {
    }


    /**
     * Copies specified file from the JAR file to the directory outside the JAR file.
     * @param sourceFileName name of the file to be copied.
     * @return copied {@link File}.
     */
    public static final File copyFileFromClassPath(String sourceFileName) {
        File sourceFileOutsideJar;
        try {
            //Copy the files from the classpath to the working directory (outside JAR).
            String fullPathToCurrentWorkingDir = new File(FileUtils.class.getProtectionDomain().
                    getCodeSource().getLocation().toURI().getPath()).getParent();
            sourceFileOutsideJar = new File(fullPathToCurrentWorkingDir, sourceFileName);
            Files.copy(FileUtils.class.getClass().getResourceAsStream("/" + sourceFileName),
                    sourceFileOutsideJar.getAbsoluteFile().toPath(),
                    StandardCopyOption.REPLACE_EXISTING);
        } catch (URISyntaxException e) {
            e.printStackTrace();
            return null;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        return sourceFileOutsideJar;
    }
}
