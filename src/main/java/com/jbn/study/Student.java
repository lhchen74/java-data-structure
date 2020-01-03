package com.jbn.study;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Student
 */
@Data
@AllArgsConstructor
public class Student {
    private String name;
    private int score;
}