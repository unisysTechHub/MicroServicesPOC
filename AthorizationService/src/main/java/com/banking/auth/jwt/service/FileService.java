package com.banking.auth.jwt.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;


@Service
public class FileService {

    @Autowired
    private ResourceLoader resourceLoader;

    public String readFileFromResources(String path) throws IOException {
        Resource resource = resourceLoader.getResource("classpath:" + path);

        try (InputStream inputStream = resource.getInputStream();
             BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {

            StringBuilder stringBuilder = new StringBuilder();
            String line;

            while ((line = reader.readLine()) != null) {
                stringBuilder.append(line).append("\n");  // preserve line breaks
            }
            return stringBuilder.toString();
        }
    }
}
