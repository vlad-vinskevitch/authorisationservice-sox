package com.sitionix.athssox.util;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

import static com.sitionix.athssox.util.JsonLoader.getFile;

@Component
public abstract class ResourceLoader {

    @Autowired
    protected ObjectMapper objectMapper;

    protected abstract String getResourcesPath();

    private <T> T getResourceAsObject(final String jsonResource, final TypeReference<T> typeReference) {
        try {
            return this.objectMapper.readValue(jsonResource, typeReference);
        } catch (final IOException e) {
            throw new RuntimeException(String.format("Failed parse from json: %s", jsonResource), e);
        }
    }

    private <T> T getResourceAsObject(final String jsonResource, final Class<T> tClass) {
        try {
            return this.objectMapper.readValue(jsonResource, tClass);
        } catch (final IOException e) {
            throw new RuntimeException(String.format("Failed parse from json: %s", jsonResource), e);
        }
    }

    protected  <T> T getFromFile(final String fileName, final TypeReference<T> typeReference) {
        final String file = this.loadResource(fileName);
        return this.getResourceAsObject(file, typeReference);
    }

    protected  <T> T getFromFile(final String fileName, final Class<T> tClass) {
        final String file = this.loadResource(fileName);
        return this.getResourceAsObject(file, tClass);
    }

    protected String getFromFile(final String fileName) {
        return this.loadResource(fileName);
    }

    protected String loadResource(final String fileName) {
        final ClassLoader loader = JsonLoader.class.getClassLoader();
        return getFile(loader, this.getResourcesPath(), fileName);
    }
}
