package org.codeswarm.somefonts;

public final class SomeFonts {

    public static FontCollection getFontCollection() {
        return FONT_COLLECTION;
    }

    private static final FontCollection FONT_COLLECTION = FontCollection.merge(
        TTF_Apache_2_0_Fonts.getFontCollection(),
        TTF_OFL_1_1_Fonts.getFontCollection()
    );

    private SomeFonts() { }

}
