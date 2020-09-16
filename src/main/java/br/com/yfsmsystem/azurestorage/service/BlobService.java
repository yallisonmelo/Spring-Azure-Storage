package br.com.yfsmsystem.azurestorage.service;

import com.azure.storage.blob.BlobAsyncClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.File;

@Service
@RequiredArgsConstructor
public class BlobService {

//    private final BlobAsyncClient blobAsyncClient;
//
//
//    public void uploadFile(File sourceFile){
//        blobAsyncClient.uploadFromFile(sourceFile.getPath());
//    }
//
//    public void download(File downloadFile){
//        blobAsyncClient.downloadToFile(downloadFile.getPath(),true);
//    }
}
