package org.codeswarm.somefonts.example;

import java.io.*;
import org.codeswarm.somefonts.SomeFonts;

public class DumpAllExample {

    public static void main(String[] args) throws IOException {

        // Create a new directory and print its path.
        File dir = createTemporaryDirectory();
        System.out.println(dir.getAbsolutePath());

        // Write all of the font files into the directory.
        SomeFonts.getFontCollection().writeStylesIntoDirectory(dir);
    }

    private static File createTemporaryDirectory() throws IOException {
        File dir = File.createTempFile("somefonts", null);
        if (!dir.delete()) throw new IOException();
        if (!dir.mkdir()) throw new IOException();
        return dir;
    }

}
