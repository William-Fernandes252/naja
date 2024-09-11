package com.example.naja.restapi.services;

import java.io.InputStream;

import com.example.naja.restapi.Enums.SupportedLanguages;

public interface NajaCompilerServiceInterface {
    String generateTarget(InputStream inputStream, SupportedLanguages language);
}
