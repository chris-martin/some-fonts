Some Fonts
==========

You may find this project convenient if:
- You're using Maven and a JVM.
- You need a few free average-looking fonts.
- You're not picky about which fonts you get.

Example usage
-------------

```java
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
```

```java
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
```

Download
--------

Some Fonts is available from Maven Central.
The latest version is 1.0.

`some-fonts-all` will get you everything.
This includes a total of 6 TTF font families:
2 serif, 2 sans, and 2 monospace.
There are 22 TTF files in total.

```xml
<dependency>
  <groupId>org.codeswarm</groupId>
  <artifactId>some-fonts-all</artifactId>
  <version>1.0</version>
</dependency>
```

The projects are also divided by license.
If you are concerned about that sort of thing,
you can grab them individually.

```xml
<dependency>
  <groupId>org.codeswarm</groupId>
  <artifactId>some-fonts-ttf-apache-2.0</artifactId>
  <version>1.0</version>
</dependency>
<dependency>
  <groupId>org.codeswarm</groupId>
  <artifactId>some-fonts-ttf-ofl-1.1</artifactId>
  <version>1.0</version>
</dependency>
```

