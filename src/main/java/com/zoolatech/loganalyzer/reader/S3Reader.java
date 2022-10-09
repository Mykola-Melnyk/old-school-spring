package com.zoolatech.loganalyzer.reader;

import software.amazon.awssdk.core.ResponseInputStream;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.GetObjectRequest;
import software.amazon.awssdk.services.s3.model.GetObjectResponse;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class S3Reader implements Reader {

    private final Scanner sc;

    public S3Reader(String fileName) throws IOException {
        Region region = Region.EU_CENTRAL_1;
        S3Client s3client = S3Client.builder().region(region).build();

        String bucket = "melnyk-s3-demo";

        GetObjectRequest getObjectRequest = GetObjectRequest.builder()
                .bucket(bucket)
                .key(fileName)
                .build();

        ResponseInputStream<GetObjectResponse> object = s3client.getObject(getObjectRequest);
        if (object != null) {
            sc = new Scanner(object, StandardCharsets.UTF_8);
        } else {
            throw new IOException("File " + fileName + " not found.");
        }
    }

    @Override
    public String nextLine() {
        if (sc.hasNextLine())
            return sc.nextLine();
        return null;
    }

    @Override
    public void close() {
        sc.close();
    }
}
