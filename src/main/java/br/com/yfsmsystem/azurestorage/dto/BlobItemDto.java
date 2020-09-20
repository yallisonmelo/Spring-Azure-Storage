package br.com.yfsmsystem.azurestorage.dto;

import lombok.Builder;
import lombok.Getter;

import java.time.OffsetDateTime;

@Builder
@Getter
public class BlobItemDto {

    private String name;
    private OffsetDateTime dateCreated;
}
