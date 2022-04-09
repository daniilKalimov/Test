package com.example.demo.wrapper;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;

@Getter
@Schema(description = "Класс обертка")
public class Wrapper<T> {

    @Schema(description = "Индикатор успешности операции", example = "true")
    private final boolean success;

    @Schema(description = "Результат операции", example = "3")
    private final T result;

    @Schema(description = "Ошибка при оперции, если success = false", example = "java.lang.ArithmeticException: Division by zero")
    private final String error;

        public Wrapper(T result){
            this.success = true;
            this.result = result;
            this.error = null;
        }

        public Wrapper(Throwable cause, Class<T> intended) {
            this.success = false;
            this.result = null;
            this.error = cause.getMessage();
        }

}
