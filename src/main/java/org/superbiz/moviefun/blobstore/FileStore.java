package org.superbiz.moviefun.blobstore;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileStore implements BlobStore {

    @Override
    public void put(Blob blob) throws IOException {

    }

    @Override
    public Blob get(String name) throws IOException {
        return null;
    }

    @Override
    public void deleteAll() {
        // ...
    }
    private void saveUploadToFile(@RequestParam("file") MultipartFile uploadedFile, File targetFile) throws IOException {
        targetFile.delete();
        targetFile.getParentFile().mkdirs();
        targetFile.createNewFile();

        try (FileOutputStream outputStream = new FileOutputStream(targetFile)) {
            outputStream.write(uploadedFile.getBytes());
        }
    }
}