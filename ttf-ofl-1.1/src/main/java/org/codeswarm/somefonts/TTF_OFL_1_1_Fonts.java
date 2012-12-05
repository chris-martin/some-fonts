package org.codeswarm.somefonts;

import java.util.ArrayList;
import java.util.List;

public final class TTF_OFL_1_1_Fonts {

    public static FontCollection getFontCollection() {
        return FONT_COLLECTION;
    }

    private static final FontCollection FONT_COLLECTION = new FontCollection(
        family("Cutive Mono", "Regular"),
        family("PT Serif", "Bold", "BoldItalic", "Italic", "Regular")
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
            FontData data = new ClasspathFontData(TTF_OFL_1_1_Fonts.class, fileName);
            styles.add(new FontFamilyStyle(familyName, styleName, FontFileType.TTF, data));
        }

        return new FontFamily(familyName, styles);
    }

    private TTF_OFL_1_1_Fonts() { }

}
