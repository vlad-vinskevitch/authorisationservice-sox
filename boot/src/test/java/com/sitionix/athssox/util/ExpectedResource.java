package com.sitionix.athssox.util;

import com.fasterxml.jackson.core.type.TypeReference;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Component
public class ExpectedResource extends ResourceLoader {

    private static final String EXPECTED_RESPONSE_FILE_PATH = "/expected/response/%s";

    private static final String EXPECTED_RECORD_FILE_PATH = "/expected/record/%s";

    @Getter
    @Setter(AccessLevel.PRIVATE)
    private String actualPath;

    @Override
    protected String getResourcesPath() {
        return getActualPath();
    }

    public String response(final String fileName) {
        setActualPath(EXPECTED_RESPONSE_FILE_PATH);
        return super.getFromFile(fileName);
    }

    public <T> T response(final String fileName, final Class<T> tClass) {
        setActualPath(EXPECTED_RESPONSE_FILE_PATH);
        return super.getFromFile(fileName, tClass);
    }

    public <T> T response(final String fileName, final TypeReference<T> typeReference) {
        setActualPath(EXPECTED_RESPONSE_FILE_PATH);
        return super.getFromFile(fileName, typeReference);
    }

    public String record(final String fileName) {
        setActualPath(EXPECTED_RECORD_FILE_PATH);
        return super.getFromFile(fileName);
    }

    public <T> T record(final String fileName, final Class<T> tClass) {
        setActualPath(EXPECTED_RECORD_FILE_PATH);
        return super.getFromFile(fileName, tClass);
    }

    public <T> T record(final String fileName, final TypeReference<T> typeReference) {
        setActualPath(EXPECTED_RECORD_FILE_PATH);
        return super.getFromFile(fileName, typeReference);
    }

}
