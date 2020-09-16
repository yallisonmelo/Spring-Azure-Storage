package br.com.yfsmsystem.azurestorage.controller;

import br.com.yfsmsystem.azurestorage.service.BlobContainerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/storage",produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class StorageController {

    private final BlobContainerService blobContainerService;

    @GetMapping()
    public ResponseEntity uploadFile(){
        return ResponseEntity.ok("OK");
    }

    @GetMapping("/list")
    public ResponseEntity listAllStorage(){

        return ResponseEntity.ok().body(blobContainerService.listBlobsInContainer());
    }
}
