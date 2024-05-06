package com.ing.store.exception;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

@Getter
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class EntityNotFoundException extends RuntimeException {

    public static final String ENTITY_WITH_GIVEN_ID_NOT_FOUND = "Entity with given id not found.";
    String clazz;
    Integer id;

    public EntityNotFoundException() {
        super(ENTITY_WITH_GIVEN_ID_NOT_FOUND);
    }

    @Override
    public String getMessage() {
        return (clazz != null && id != null) ? String.format("Entity of type %s  with id %d was not found.", clazz, id) : ENTITY_WITH_GIVEN_ID_NOT_FOUND;
    }
}