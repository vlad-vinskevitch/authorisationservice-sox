package com.sitionix.athssox.athssox;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    int sum(int a, int b)  {
        return a+b;
    }
}
