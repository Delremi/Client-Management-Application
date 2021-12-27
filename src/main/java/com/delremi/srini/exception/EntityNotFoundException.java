package com.delremi.srini.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.BAD_REQUEST)
public class EntityNotFoundException extends Exception {

    public EntityNotFoundException(Class<?> entity, int id) {
        super(String.format("%s not found for the id %s", entity.getName(), id));
    }

    public EntityNotFoundException(Class<?> entity, String identificator) {
        super(String.format("%s not found for the identificator '%s'", entity.getName(), identificator));
    }
}
