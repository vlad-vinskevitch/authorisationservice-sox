package com.sitionix.athssox.domain;

import lombok.*;
import org.springframework.stereotype.Component;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Component
public class User {

    private Long id;

    private String userName;

    private String password;

}
