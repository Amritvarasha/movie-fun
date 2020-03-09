package org.superbiz.moviefun.blobstore;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.S3Object;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;

import java.io.IOException;

import static java.lang.String.format;

public class S3Store implements BlobStore {
    @Autowired
    private ServiceCredentials serviceCredentials;
    private AmazonS3Client s3Client;
    private String photoStorageBucket;
    public S3Store(AmazonS3Client s3Client, String photoStorageBucket) {
        this.s3Client=s3Client;
        this.photoStorageBucket=photoStorageBucket;

    }

    @Override
    public void put(Blob blob) throws IOException {
        System.out.println("The Blob is "+blob);
        s3Client.putObject(photoStorageBucket,blob.name,blob.inputStream,new ObjectMetadata());
    }

    @Override
    public Blob get(String name) throws IOException {
        S3Object s3Object=s3Client.getObject(photoStorageBucket,name);
        Blob blob = new Blob(s3Object.getKey(),s3Object.getObjectContent(), s3Object.getObjectMetadata().getContentType());
        return blob;

    }

    @Override
    public void deleteAll() {
        //s3Client.
    }


}
