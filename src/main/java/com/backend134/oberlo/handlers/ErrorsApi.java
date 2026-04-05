package com.backend134.oberlo.handlers;


import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ErrorsApi<E> {
    private Integer code;
    private Exception<E> exception;
}
