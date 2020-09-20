package br.com.yfsmsystem.azurestorage.controller;

import br.com.yfsmsystem.azurestorage.service.BlobService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping(value = "/storage",produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
@Slf4j
public class StorageController {

    private final BlobService blobService;

    @GetMapping("/")
    public ResponseEntity blobitemst() {
        return ResponseEntity.ok().body(blobService.listFiles());
    }


    @GetMapping("/download/{filename}")
    public byte[] download(@PathVariable String filename) {
        log.info("download blobitem: {}", filename);
        return blobService.downloadFile(filename).toByteArray();
    }
    @PostMapping("/upload")
    public String uploadFile(MultipartFile file) throws IOException {
        log.info("Filename :" + file.getOriginalFilename());
        log.info("Size:" + file.getSize());
        log.info("Contenttype:" + file.getContentType());
        blobService.storeFile(file.getOriginalFilename(),file.getInputStream(), file.getSize());
        return file.getOriginalFilename() + " Has been saved as a blob-item!!!";

    }
}
