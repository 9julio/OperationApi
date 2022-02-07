package com.jafernandez.operations.dto;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public enum OperationType {
    SUM,
    SUBTRACTION;

    public static Set<OperationType> allTypes = Arrays.stream(OperationType.values()).collect(Collectors.toSet());

}
