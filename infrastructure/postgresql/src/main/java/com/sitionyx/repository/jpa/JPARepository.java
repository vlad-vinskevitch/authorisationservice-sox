package com.sitionyx.repository.jpa;

import com.sitionyx.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JPARepository extends JpaRepository<Student, Long> {
}
