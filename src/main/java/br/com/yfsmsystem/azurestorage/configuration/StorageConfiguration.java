package br.com.yfsmsystem.azurestorage.configuration;

import com.azure.storage.blob.BlobContainerAsyncClient;
import com.azure.storage.blob.BlobServiceAsyncClient;
import com.azure.storage.blob.BlobServiceClientBuilder;
import com.azure.storage.common.StorageSharedKeyCredential;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(StorageProperties.class)
@RequiredArgsConstructor
public class StorageConfiguration {

    private final StorageProperties properties;
    private static final String BLOB_URL = "http://%s.blob.core.windows.net";
    private static final String BLOB_HTTPS_URL = "https://%s.blob.core.windows.net";

    private String getEndpoint() {
        if (properties.isUseEmulator()) {
            return String.format("%s/%s", properties.getEmulatorBlobHost(), properties.getAccountName());
        }
        if (properties.isEnableHttps()) {
            return String.format(BLOB_HTTPS_URL, properties.getAccountName());
        }
        return String.format(BLOB_URL, properties.getAccountName());
    }

    @Bean
    public BlobContainerAsyncClient blobContainerAsyncClient() {
        final BlobServiceAsyncClient blobServiceAsyncClient = new BlobServiceClientBuilder()
                .endpoint(getEndpoint())
                .credential(new StorageSharedKeyCredential(properties.getAccountName(), properties.getAccountKey()))
                .buildAsyncClient();
        return blobServiceAsyncClient.getBlobContainerAsyncClient(properties.getContainerName());
    }
}
