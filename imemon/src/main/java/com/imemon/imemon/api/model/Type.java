package com.imemon.imemon.api.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "type")
public class Type {
    @Id
    @Column(name = "id")
    private long id;

    @Column(name = "name")
    private String name;
}
