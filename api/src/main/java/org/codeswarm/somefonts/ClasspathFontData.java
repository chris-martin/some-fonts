package org.codeswarm.somefonts;

import java.io.InputStream;

public final class ClasspathFontData implements FontData {

    private final Class<?> cls;
    private final String path;

    public ClasspathFontData(Class<?> cls, String path) {

        if (cls == null) throw new NullPointerException();
        if (path == null) throw new NullPointerException();

        this.cls = cls;
        this.path = path;

    }

    @Override
    public InputStream getFontInputStream() {
        InputStream in = cls.getResourceAsStream(path);
        if (in == null) {
            throw new RuntimeException("Missing: " + path);
        }
        return in;
    }

}
