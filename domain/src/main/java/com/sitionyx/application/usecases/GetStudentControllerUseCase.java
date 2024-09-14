package com.sitionyx.application.usecases;

import com.sitionyx.domain.Student;

public interface GetStudentControllerUseCase {
    public Student execute(Long id);
}
