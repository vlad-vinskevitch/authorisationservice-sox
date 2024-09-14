package com.sitionyx.domain;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Student {

    private final Long id;

    private final String name;

    private final String second_name;

    private final Integer age;

    private final Integer course;

}
