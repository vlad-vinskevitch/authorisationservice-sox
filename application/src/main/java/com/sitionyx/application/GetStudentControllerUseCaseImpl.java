package com.sitionyx.application;

import com.sitionyx.domain.Student;
import com.sitionyx.application.usecases.GetStudentControllerUseCase;
import com.sitionyx.repository.usecases.GetStudentRepositoryUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GetStudentControllerUseCaseImpl implements GetStudentControllerUseCase {

    private final GetStudentRepositoryUseCase studentRepositoryUseCase;

    @Override
    public Student execute(Long id) {
        return studentRepositoryUseCase.execute(id);
    }
}
