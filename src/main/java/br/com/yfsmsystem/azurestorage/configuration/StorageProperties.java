package br.com.yfsmsystem.azurestorage.configuration;

import lombok.Getter;
import lombok.Setter;
import org.springframework.validation.annotation.Validated;
import org.springframework.boot.context.properties.ConfigurationProperties;

import javax.validation.constraints.NotEmpty;

@Validated
@ConfigurationProperties("azure.storage")
@Getter
@Setter
public class StorageProperties {

    @NotEmpty
    private String accountName;
    @NotEmpty
    private String accountKey;
    private boolean useEmulator = false;
    private String emulatorBlobHost;
    private String containerName;
    private boolean enableHttps = false;

}