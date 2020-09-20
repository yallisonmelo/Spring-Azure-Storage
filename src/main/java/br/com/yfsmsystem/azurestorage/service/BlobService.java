package br.com.yfsmsystem.azurestorage.service;

import br.com.yfsmsystem.azurestorage.configuration.AzureConfiguration;
import br.com.yfsmsystem.azurestorage.dto.BlobItemDto;
import com.azure.storage.blob.BlobClient;
import com.azure.storage.blob.BlobContainerClient;
import com.azure.storage.blob.models.BlobItem;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class BlobService {

    private final AzureConfiguration azureConfiguration;

    public List<BlobItemDto> listFiles() {
        BlobContainerClient container = azureConfiguration.blobContainerClient();
        val listBlobItemDtoOutput = new ArrayList<BlobItemDto>();
        for (BlobItem blobItem : container.listBlobs()) {
            listBlobItemDtoOutput.add(BlobItemDto.builder()
                    .dateCreated(blobItem.getProperties().getCreationTime())
                    .name(blobItem.getName())
                    .build());
        }
        return listBlobItemDtoOutput;
    }

    public ByteArrayOutputStream downloadFile(String blobitem) {
        BlobContainerClient containerClient = azureConfiguration.blobContainerClient();
        BlobClient blobClient = containerClient.getBlobClient(blobitem);
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        blobClient.download(os);
        return os;
    }

    public String storeFile(String filename, InputStream content, long length) {
        BlobClient client = azureConfiguration.blobContainerClient().getBlobClient(filename);
        if (!client.exists()) {
            client.upload(content, length);
        }
        return "File uploaded with success!";
    }

    public void deleteFile(String filename) {
        BlobClient client = azureConfiguration.blobContainerClient().getBlobClient(filename);
        if (client.exists()) {
            log.info("File exist");
            client.delete();
        }
    }
}
