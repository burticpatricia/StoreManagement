package com.ing.store.exception;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

@Getter
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class EntityNotFoundException extends RuntimeException {

    String clazz;
    Integer id;

    @Override
    public String getMessage() {
        return String.format("Entity of type %s  with id %d was found.", clazz, id);
    }
}