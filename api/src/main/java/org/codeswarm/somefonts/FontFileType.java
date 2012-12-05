package org.codeswarm.somefonts;

public final class FontFileType {

    public static final FontFileType TTF = new FontFileType("ttf");

    private final String fileExtension;

    public FontFileType(String fileExtension) {
        if (fileExtension.length() == 0) throw new IllegalArgumentException();
        this.fileExtension = fileExtension;
    }

    public String getFileExtension() {
        return fileExtension;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FontFileType that = (FontFileType) o;
        return fileExtension.equals(that.fileExtension);
    }

    @Override
    public int hashCode() {
        return fileExtension != null ? fileExtension.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "FontFileType{fileExtension='" + fileExtension + "\'}";
    }

}
