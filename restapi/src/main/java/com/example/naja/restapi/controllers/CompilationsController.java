package com.example.naja.restapi.controllers;

import com.example.naja.restapi.Enums.SupportedLanguages;
import com.example.naja.restapi.services.NajaCompilerServiceInterface;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.util.Objects;

@RestController
public class CompilationsController {
    private final NajaCompilerServiceInterface najaCompilerService;
    
    private CompilationsController(NajaCompilerServiceInterface najaCompilerService) {
        this.najaCompilerService = najaCompilerService;
    }

    @PostMapping("/compile")
    public ResponseEntity<String> compileToJava(@RequestParam("file") MultipartFile file,
            @RequestParam(value = "lang", defaultValue = "java") String lang) {
        if (!Objects.equals(file.getContentType(), "text/plain")) {
            return new ResponseEntity<String>("Invalid file type. Only text/plain files are allowed.",
                    HttpStatus.BAD_REQUEST);
        }
        if (lang != "python" || lang != "java") {
            return new ResponseEntity<String>("Supported languages: java, python", HttpStatus.BAD_REQUEST);
        }
        try {
            String compiledCode = this.najaCompilerService.generateTarget(file.getInputStream(), SupportedLanguages.JAVA);
            return new ResponseEntity<String>(compiledCode, HttpStatus.OK);    
        }
        catch (Exception e){
            return new ResponseEntity<String>("Server internal error", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        
    }
}
