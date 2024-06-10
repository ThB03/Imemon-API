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
@Table(name = "logged_users")
public class LoggedUsers {
    @Id
    @Column(name = "session")
    private String session;

    @Column(name = "username")
    private String username;
}