package org.codeswarm.somefonts.example;

import java.io.*;
import org.apache.commons.io.IOUtils;
import org.codeswarm.somefonts.*;

public class ReadOneExample {

    public static void main(String[] args) throws IOException {

        // Retrieve a font by family and style name.
        FontFamilyStyle font = SomeFonts.getFontCollection().getFamilyStyle(
            new FontFamilyName("Open Sans"), new FontStyleName("BoldItalic"));

        // Read the first handful of bytes and print their integer values. I have no
        // idea why you would ever want to do this, but whatever, this is example code.
        byte[] bytes = new byte[8];
        InputStream in = font.getFontInputStream();
        IOUtils.read(in, bytes);
        in.close();
        for (byte b : bytes) System.out.print(((int) b) + " ");
        System.out.println();
    }

}
