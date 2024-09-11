package com.example.naja.restapi.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class CompilationsController {
    @PostMapping("/compile")
    public ResponseEntity<String> compileToJava(@RequestParam("file") MultipartFile file,
            @RequestParam(value = "lang", defaultValue = "java") String lang) {
        if (file.getContentType() != "text/plain") {
            return new ResponseEntity<String>("Invalid file type. Only text/plain files are allowed.",
                    HttpStatus.BAD_REQUEST);
        }
        if (lang != "python" || lang != "java") {
            return new ResponseEntity<String>("Supported languages: java, python", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<String>(HttpStatus.OK);
    }
}
