package com.sitionix.athssox.util;

import com.sitionix.athssox.entity.UserEntity;
import com.sitionix.athssox.util.database.Database;
import lombok.Setter;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GivenEntityResource extends ResourceLoader{

    @Override
    protected String getResourcesPath() {
        return this.filePath;
    }

    @Setter
    private String filePath;

    @Setter
    private String customResourceFile;

    @Autowired
    private Database database;

    public UserEntity userEntity() {
        final UserEntity userEntity = this.getDefaultOrCustom("UserEntity.json", UserEntity.class);
        return this.database.getUsersTable().create(userEntity);
    }

    @SneakyThrows
    public <T> T getDefaultOrCustom(final String defaultResourceFile, final Class<T> tClass) {
        final String file = this.customResourceFile == null ? defaultResourceFile : this.customResourceFile;
        return this.objectMapper.readValue(this.loadResource(file), tClass);
    }
}
