package com.sitionix.athssox.mapper;

import com.sitionix.athssox.domain.User;
import com.sitionix.athssox.entity.UserEntity;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring",builder = @Builder(disableBuilder = true))
public interface UserInfraMapper {

    @Mapping(source = "id", target = "id")
    UserEntity asUserEntity(final User user);

    User asUser(final UserEntity userEntity);
}
