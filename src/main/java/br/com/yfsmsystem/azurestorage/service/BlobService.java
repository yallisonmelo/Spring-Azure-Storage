package br.com.yfsmsystem.azurestorage.service;

import br.com.yfsmsystem.azurestorage.configuration.AzureConfiguration;
import com.azure.storage.blob.BlobClient;
import com.azure.storage.blob.BlobContainerClient;
import com.azure.storage.blob.models.BlobItem;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.ArrayList;

@Service
@RequiredArgsConstructor
public class BlobService {

    private final AzureConfiguration azureConfiguration;

    public ArrayList<String> listFiles() {
        BlobContainerClient container = azureConfiguration.blobContainerClient();
        val list = new ArrayList<String>();
        for (BlobItem blobItem : container.listBlobs()) {
            list.add(blobItem.getName());
        }
        return list;
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

}
