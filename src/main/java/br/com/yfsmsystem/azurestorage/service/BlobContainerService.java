package br.com.yfsmsystem.azurestorage.service;

import br.com.yfsmsystem.azurestorage.dto.ContainerDto;
import com.azure.storage.blob.BlobServiceClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BlobContainerService {

    private final BlobServiceClient blobClient;


    public void createContainerIfNotExists() {
        if (blobClient()) {
            blobContainerAsyncClient.c();
        }
    }

    public void deleteContainer() {
        blobContainerAsyncClient.delete();
    }

    public List<ContainerDto> listBlobsInContainer() {
        List<ContainerDto> teste = new ArrayList<>();
         blobContainerAsyncClient.get().subscribe(
                blobItem -> teste.add(ContainerDto.builder()
                        .name(blobItem.getName())
                        .build())
        );
         return teste;
    }
}
