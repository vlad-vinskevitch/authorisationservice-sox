package com.sitionyx.repository;

import com.sitionyx.domain.Student;
import com.sitionyx.repository.jpa.JPARepository;
import com.sitionyx.repository.usecases.GetStudentRepositoryUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class GetStudentRepositoryUseCaseImpl implements GetStudentRepositoryUseCase {

    private final JPARepository jpaRepository;

    @Override
    public Student execute(final Long id) {
        return jpaRepository.getReferenceById(id);
    }
}
