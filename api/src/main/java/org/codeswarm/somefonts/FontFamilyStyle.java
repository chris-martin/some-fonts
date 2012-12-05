package org.codeswarm.somefonts;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.io.FileUtils;

public final class FontFamilyStyle {

    private final FontFamilyName familyName;
    private final FontStyleName styleName;
    private final FontFileType fileType;
    private final FontData fontData;

    public FontFamilyStyle(
            FontFamilyName familyName,
            FontStyleName styleName,
            FontFileType fileType,
            FontData fontData) {

        this.familyName = familyName;
        this.styleName = styleName;
        this.fileType = fileType;
        this.fontData = fontData;
    }

    public FontFamilyName getFamilyName() {
        return familyName;
    }

    public FontStyleName getName() {
        return styleName;
    }

    public FontFileType getFileType() {
        return fileType;
    }

    public FontData getFontData() {
        return fontData;
    }

    public InputStream getFontInputStream() {
        return fontData.getFontInputStream();
    }

    public String getFileName() {
        return String.format(
            "%s-%s.%s",
            familyName.asString().replaceAll(" ", "_"),
            styleName.asString(),
            fileType.getFileExtension()
        );
    }

    public void writeIntoDirectory(File directory) throws IOException {
        writeToFile(new File(directory, getFileName()));
    }

    public void writeToFile(File file) throws IOException {
        FileUtils.copyInputStreamToFile(fontData.getFontInputStream(), file);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FontFamilyStyle that = (FontFamilyStyle) o;
        return familyName.equals(that.familyName)
            && fontData.equals(that.fontData)
            && fileType.equals(that.fileType)
            && styleName.equals(that.styleName);
    }

    @Override
    public int hashCode() {
        return 31 * (
            31 * (
                31 * familyName.hashCode() + styleName.hashCode()
            ) + fileType.hashCode()
        ) + fontData.hashCode();
    }

    @Override
    public String toString() {
        return "FontFamilyStyle{" + familyName + ", " + styleName + "}";
    }

}
