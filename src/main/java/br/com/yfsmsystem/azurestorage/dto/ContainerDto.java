package br.com.yfsmsystem.azurestorage.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ContainerDto {
    private String name;
    private Boolean prefix;
}
