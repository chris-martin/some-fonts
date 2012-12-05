package org.codeswarm.somefonts;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Nullable;

public final class FontFamily {

    private final FontFamilyName name;
    private final Map<FontStyleName, FontFamilyStyle> styleByName;

    public FontFamily(FontFamilyName name, FontFamilyStyle ... styles) {
        this(name, Arrays.asList(styles));
    }

    public FontFamily(FontFamilyName name, Collection<FontFamilyStyle> styles) {

        if (name == null) throw new NullPointerException();
        if (styles == null) throw new NullPointerException();

        this.name = name;

        Map<FontStyleName, FontFamilyStyle> styleByName =
            new HashMap<FontStyleName, FontFamilyStyle>();

        for (FontFamilyStyle style : styles) {
            FontFamilyName styleFamilyName = style.getFamilyName();
            if (!styleFamilyName.equals(name)) {
                throw new IllegalArgumentException(String.format(
                    "Mismatch: family name is \"%s\", but style's family name is \"%s\"",
                    name.asString(), styleFamilyName.asString()));
            }
            styleByName.put(style.getName(), style);
        }

        this.styleByName = Collections.unmodifiableMap(styleByName);

    }

    public FontFamilyName getFamilyName() {
        return name;
    }

    public Collection<FontFamilyStyle> getStyles() {
        return styleByName.values();
    }

    public Map<FontStyleName, FontFamilyStyle> asStyleNameMap() {
        return styleByName;
    }

    @Nullable
    public FontFamilyStyle getFamilyStyle(FontStyleName styleName) {
        return styleByName.get(styleName);
    }

    public void writeStylesIntoDirectory(File directory) throws IOException {
        for (FontFamilyStyle style : styleByName.values()) {
            style.writeIntoDirectory(directory);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FontFamily that = (FontFamily) o;
        return name.equals(that.name) && styleByName.equals(that.styleByName);
    }

    @Override
    public int hashCode() {
        return 31 * name.hashCode() + styleByName.hashCode();
    }

    @Override
    public String toString() {
        return "FontFamily{" + name + ", styles=" + styleByName + "}";
    }

}
