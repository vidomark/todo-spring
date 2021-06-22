package com.codecool.todo.model;

import javax.persistence.Embeddable;

@Embeddable
public enum Status {
    ACTIVE,
    COMPLETE
}
