package com.sitionix.athssox.util;

import com.fasterxml.jackson.core.type.TypeReference;
import org.springframework.stereotype.Component;

@Component
public class GivenRequestResource extends ResourceLoader {

    private static final String REQUEST_FILE_PATH = "/request/%s";

    @Override
    protected String getResourcesPath() {
        return REQUEST_FILE_PATH;
    }

    public String request(final String fileName) {
        return super.getFromFile(fileName);
    }

    public <T> T request(final String fileName, final Class<T> tClass) {
        return super.getFromFile(fileName, tClass);
    }

    public <T> T request(final String fileName, final TypeReference<T> typeReference) {
        return super.getFromFile(fileName, typeReference);
    }
}
