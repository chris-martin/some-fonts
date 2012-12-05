package org.codeswarm.somefonts;

import java.io.InputStream;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;
import static org.testng.Assert.assertNotNull;

public class SomeFontsTest {

    @Test
    public void testFamilyCount() throws Exception {
        assertEquals(SomeFonts.getFontCollection().getFamilies().size(), 6);
    }

    @Test
    public void testStyleCount() throws Exception {
        assertEquals(SomeFonts.getFontCollection().getFamilyStyles().size(), 22);
    }

    @Test
    public void testData() throws Exception {
        for (FontFamilyStyle familyStyle : SomeFonts.getFontCollection().getFamilyStyles()) {
            InputStream in = familyStyle.getFontData().getFontInputStream();
            assertNotNull(in, familyStyle.toString());
            try {
                assertNotEquals(in.read(), -1, familyStyle.toString());
            } finally {
                in.close();
            }
        }
    }

}
