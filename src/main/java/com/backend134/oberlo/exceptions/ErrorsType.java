package com.backend134.oberlo.exceptions;

import lombok.Getter;

@Getter
public enum ErrorsType {
    CANNOT_CREATED("1001","data yaradila bilmedi"),
    CANNOT_UPDATED("1002","Update oluna bilmedi"),
    CANNOT_DELETED("1003","Silme emeliyyati ugursuz oldu"),
    DATA_ALREADY_EXIST("1004","Bu melumat artiq movcuddur"),
    INVALID_DATA("1005","Daxil edilen melumatlar yanlisdir"),
    AUTH_NOT_FOUND("1006","Istifadeci tapilmadi"),
    NO_DATA_FOUND("1007","Hemin id-e uygun data tapilmadi"),
    UNIQUE_CONSTRAINT("1008","Unique constraint violated");

    private  String code;
    private  String message;

    ErrorsType(String code, String message) {
        this.code=code;
        this.message=message;
    }
}
