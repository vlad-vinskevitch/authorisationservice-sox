package com.sitionix.athssox.util;

import com.sitionix.athssox.util.database.Database;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TestResourceManager {

    private static final String DEFAULT_FILE_PATH = "/given/default/%s";
    private static final String CUSTOM_FILE_PATH = "/given/custom/%s";

    private final GivenEntityResource entity;

    private final GivenRequestResource requestResource;

    private final ExpectedResource expectedResource;

    private final Database database;

    public GivenEntityResource givenEntity(final String fileName) {
        this.entity.setFilePath(CUSTOM_FILE_PATH);
        this.entity.setCustomResourceFile(fileName);
        return this.entity;
    }

    public GivenEntityResource givenEntity() {
        this.entity.setFilePath(DEFAULT_FILE_PATH);
        this.entity.setCustomResourceFile(null);
        return this.entity;
    }

    public GivenRequestResource givenRequest() {
        return this.requestResource;
    }

    public ExpectedResource expected() {
        return this.expectedResource;
    }

    public Database database() {
        return this.database;
    }
}
