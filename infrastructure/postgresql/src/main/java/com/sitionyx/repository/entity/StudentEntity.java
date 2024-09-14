package com.sitionyx.repository.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class StudentEntity {

    private final Long id;

    private final String name;

    private final String second_name;

    private final Integer age;

    private final Integer course;

}
