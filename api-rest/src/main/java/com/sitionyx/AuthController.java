package com.sitionyx;

import com.sitionyx.application.usecases.GetStudentControllerUseCase;
import com.sitionyx.domain.Student;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    private final GetStudentControllerUseCase getStudentControllerUseCase;

    public AuthController(GetStudentControllerUseCase getStudentControllerUseCase) {
        this.getStudentControllerUseCase = getStudentControllerUseCase;
    }

    @GetMapping("/stu")
    public void getStudent() {

        final Long ids = 1L;
        final Student student = getStudentControllerUseCase.execute(ids);
    }

    @GetMapping("/student")
    public void helloWorld(){
        System.out.println("HELOOWRODL");
    }
}
