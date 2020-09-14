package com.ivanskodje.springaop.web;

import com.ivanskodje.springaop.aop.Stopwatch;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class HelloController {

    @Stopwatch(name = "My Hello Method")
    @GetMapping("/hello")
    public ResponseEntity<Object> hello() {
        return ResponseEntity.ok("Hello");
    }

    @Stopwatch(name = "throwInternalProblem()")
    @GetMapping("/error")
    public ResponseEntity<Object> throwInternalProblem() throws Exception {
        throw new Exception("This exception should be wrapped in a 500 Internal Server Problem by the @Stopwatch AOP");
    }
}
