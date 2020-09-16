package br.com.yfsmsystem.azurestorage.service;

import com.azure.storage.blob.BlobContainerAsyncClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;

@Service
@RequiredArgsConstructor
public class ApplicationService {

//    private static final String SOURCE_FILE = "storageTestFile.txt";
//
//    private final BlobContainerAsyncClient blobContainerAsyncClient;
//
//
//
//    public void run() throws IOException {
//        final URL resource = this.getClass().getClassLoader().getResource(SOURCE_FILE);
//        if (resource == null) {
//            throw new FileNotFoundException("Please add the file [" + SOURCE_FILE + "] to the classpath");
//        }
//
//        final File sourceFile = new File(resource.getFile());
//        final File downloadToFile = Files.createTempFile("azure-storage-test", null).toFile();
//
//        BlobContainerService containerService = new BlobContainerService(blobContainerAsyncClient);
//        BlobService blobService = new BlobService(blobContainerAsyncClient.getBlobAsyncClient(SOURCE_FILE));
//
//        containerService.createContainerIfNotExists();
//
//    }
}
