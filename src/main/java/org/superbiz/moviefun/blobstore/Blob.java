package org.superbiz.moviefun.blobstore;

import java.io.InputStream;
import java.io.Serializable;

public class Blob implements Serializable{
    public final String name;
    public final InputStream inputStream;
    public final String contentType;

    public Blob(String name, InputStream inputStream, String contentType) {
        this.name = name;
        this.inputStream = inputStream;
        this.contentType = contentType;
    }
}
