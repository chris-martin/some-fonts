package org.codeswarm.somefonts;

public final class FontStyleName {

    private final String name;

    public FontStyleName(String name) {
        if (name.length() == 0) throw new IllegalArgumentException();
        this.name = name;
    }

    public String asString() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FontStyleName that = (FontStyleName) o;
        return name.equals(that.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    @Override
    public String toString() {
        return "FontStyleName{" + name + "}";
    }

}
