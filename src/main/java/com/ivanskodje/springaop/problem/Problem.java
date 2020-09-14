package com.ivanskodje.springaop.problem;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Data
@RequiredArgsConstructor
public class Problem extends RuntimeException {
    private final HttpStatus status;
    private final String message;
}
