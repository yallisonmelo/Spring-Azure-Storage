package br.com.yfsmsystem.azurestorage.configuration;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;


@Validated
@ConfigurationProperties("azure.storage")
@Getter
@Setter
public class AzureProperties {


    private String connectionString;
    private String container;

}