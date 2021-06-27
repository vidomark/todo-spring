package com.codecool.todo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Todo {

    @Id
    @GeneratedValue
    private int id;

    private String title;

    @Enumerated(EnumType.STRING)
    private Status status;

    public boolean isCompleted() {return this.status.equals(Status.COMPLETE);}
}
