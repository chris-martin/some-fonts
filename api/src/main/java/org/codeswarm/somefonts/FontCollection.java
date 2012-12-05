package org.codeswarm.somefonts;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Nullable;

public final class FontCollection {

    private final Map<FontFamilyName, FontFamily> familyByName;

    public FontCollection(FontFamily ... families) {
        this(Arrays.asList(families));
    }

    public FontCollection(Iterable<FontFamily> families) {

        Map<FontFamilyName, FontFamily> familyByName =
            new HashMap<FontFamilyName, FontFamily>();

        for (FontFamily family : families) {
            familyByName.put(family.getFamilyName(), family);
        }

        this.familyByName = Collections.unmodifiableMap(familyByName);
    }

    public static FontCollection merge(FontCollection ... collections) {
        return merge(Arrays.asList(collections));
    }

    public static FontCollection merge(Iterable<FontCollection> collections) {
        List<FontFamily> families = new ArrayList<FontFamily>();
        for (FontCollection collection : collections) {
            families.addAll(collection.getFamilies());
        }
        return new FontCollection(families);
    }

    public Collection<FontFamily> getFamilies() {
        return familyByName.values();
    }

    public Map<FontFamilyName, FontFamily> asFamilyNameMap() {
        return familyByName;
    }

    @Nullable
    public FontFamily getFamily(FontFamilyName familyName) {
        return familyByName.get(familyName);
    }

    @Nullable
    public FontFamilyStyle getFamilyStyle(FontFamilyName familyName, FontStyleName styleName) {
        @Nullable FontFamily family = getFamily(familyName);
        return family == null ? null : family.getFamilyStyle(styleName);
    }

    public Collection<FontFamilyStyle> getFamilyStyles() {

        List<FontFamilyStyle> styles = new ArrayList<FontFamilyStyle>();

        for (FontFamily family : getFamilies()) {
            styles.addAll(family.getStyles());
        }

        return styles;
    }

    public void writeStylesIntoDirectory(File directory) throws IOException {
        for (FontFamily family : getFamilies()) {
            family.writeStylesIntoDirectory(directory);
        }
    }

}
