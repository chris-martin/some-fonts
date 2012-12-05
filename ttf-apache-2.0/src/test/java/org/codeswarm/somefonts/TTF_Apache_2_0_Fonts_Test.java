package org.codeswarm.somefonts;

import java.io.InputStream;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;
import static org.testng.Assert.assertNotNull;

public class TTF_Apache_2_0_Fonts_Test {

    @Test
    public void testFamilyCount() throws Exception {
        assertEquals(TTF_Apache_2_0_Fonts.getFontCollection().getFamilies().size(), 4);
    }

    @Test
    public void testStyleCount() throws Exception {
        assertEquals(TTF_Apache_2_0_Fonts.getFontCollection().getFamilyStyles().size(), 17);
    }

    @Test
    public void testData() throws Exception {
        for (FontFamilyStyle familyStyle : TTF_Apache_2_0_Fonts.getFontCollection().getFamilyStyles()) {
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
