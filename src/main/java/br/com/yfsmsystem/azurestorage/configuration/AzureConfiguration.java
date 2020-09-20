package br.com.yfsmsystem.azurestorage.configuration;

import com.azure.storage.blob.BlobContainerClient;
import com.azure.storage.blob.BlobServiceClient;
import com.azure.storage.blob.BlobServiceClientBuilder;
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
                .connectionString(azureProperties.getConnectionString()).buildClient();
        return  serviceClient.getBlobContainerClient(azureProperties.getContainer());
    }
}
