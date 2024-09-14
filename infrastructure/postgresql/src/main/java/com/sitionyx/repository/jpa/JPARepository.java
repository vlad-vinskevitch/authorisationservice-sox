package com.sitionyx.repository.jpa;

import com.sitionyx.repository.entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JPARepository extends JpaRepository<StudentEntity, Long> {
}
