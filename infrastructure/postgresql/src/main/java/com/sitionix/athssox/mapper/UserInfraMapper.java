package com.sitionix.athssox.mapper;

import com.sitionix.athssox.domain.User;
import com.sitionix.athssox.domain.UserRegistration;
import com.sitionix.athssox.entity.UserEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserInfraMapper {

    UserEntity asUserEntity(final User user);

    User asUser(final UserEntity userEntity);

    UserEntity fromUserRegistrationToEntity (final UserRegistration userRegistration); // TODO перезагрузка метода
}
