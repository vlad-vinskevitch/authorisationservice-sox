package com.sitionyx.repository.usecases;

import com.sitionyx.domain.Student;

public interface GetStudentRepositoryUseCase {
    public Student execute(Long id);
}
