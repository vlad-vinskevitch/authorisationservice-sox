package com.sitionix.athssox.jpa;

import com.sitionix.athssox.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface UserJpaRepository extends JpaRepository<UserEntity, Long> {
}
