package com.ivanskodje.springaop.problem;

import org.springframework.http.HttpStatus;

public class InternalServerProblem extends Problem {
    public InternalServerProblem(String message) {
        super(HttpStatus.INTERNAL_SERVER_ERROR, message);
    }
}
