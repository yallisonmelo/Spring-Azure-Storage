package br.com.yfsmsystem.azurestorage.configuration;

import com.azure.storage.blob.*;
import com.azure.storage.common.StorageSharedKeyCredential;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(AzureProperties.class)
@RequiredArgsConstructor
public class AzureConfiguration {

    private final AzureProperties azureProperties;

    @Bean
    public BlobContainerClient blobContainerClient() {
        BlobServiceClient serviceClient = new BlobServiceClientBuilder()
                .sasToken("?sv=2019-12-12&ss=bfqt&srt=sco&sp=rwdlacupx&se=2020-09-19T09:33:18Z&st=2020-09-19T01:33:18Z&spr=https&sig=toIkHQKsX7evLGKj4hZG7DETYiK5pic%2FmXWMjbW1GVw%3D")
                .connectionString(azureProperties.getConnectionString()).buildClient();
        BlobContainerClient container = serviceClient.getBlobContainerClient(azureProperties.getContainer());
        return container;
    }
}
