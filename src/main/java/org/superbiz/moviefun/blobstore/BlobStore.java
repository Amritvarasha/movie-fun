package org.superbiz.moviefun.blobstore;

import java.io.IOException;

public interface BlobStore {

    void put(Blob blob) throws IOException;

    Blob get(String name) throws IOException;

    void deleteAll();
}