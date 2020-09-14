package com.ivanskodje.springaop.problem.advice;

import com.ivanskodje.springaop.problem.Problem;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ProblemAdvice {

    @ExceptionHandler(Problem.class)
    public ResponseEntity<Problem> handleProblem(Problem problem) {
        return ResponseEntity.ok().build(); // TODO: Implement this
    }
}
