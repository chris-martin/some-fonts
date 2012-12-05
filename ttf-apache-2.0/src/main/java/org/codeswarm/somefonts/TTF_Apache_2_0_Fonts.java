package org.codeswarm.somefonts;

import java.util.ArrayList;
import java.util.List;

public final class TTF_Apache_2_0_Fonts {

    public static FontCollection getFontCollection() {
        return FONT_COLLECTION;
    }

    private static final FontCollection FONT_COLLECTION = new FontCollection(
        family("Droid Sans", "Bold", "Regular"),
        family("Droid Sans Mono", "Regular"),
        family("Droid Serif", "Bold", "BoldItalic", "Italic", "Regular"),
        family("Open Sans", "Bold", "BoldItalic", "ExtraBold", "ExtraBoldItalic",
            "Italic", "Light", "LightItalic", "Regular", "Semibold", "SemiboldItalic")
    );

    private static FontFamily family(
            String nameString,
            String ... styleStrings) {

        FontFamilyName familyName = new FontFamilyName(nameString);
        String filePrefix = nameString.replaceAll(" ", "_");

        List<FontFamilyStyle> styles = new ArrayList<FontFamilyStyle>();
        for (String styleString : styleStrings) {

            FontStyleName styleName = new FontStyleName(styleString);
            String fileName = String.format("%s-%s.ttf", filePrefix, styleString);
            FontData data = new ClasspathFontData(TTF_Apache_2_0_Fonts.class, fileName);
            styles.add(new FontFamilyStyle(familyName, styleName, FontFileType.TTF, data));
        }

        return new FontFamily(familyName, styles);
    }

    private TTF_Apache_2_0_Fonts() { }

}
