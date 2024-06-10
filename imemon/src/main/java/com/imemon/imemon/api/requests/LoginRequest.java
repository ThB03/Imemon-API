package com.imemon.imemon.api.requests;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.engine.jdbc.SerializableBlobProxy;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
public class LoginRequest {
    private String email;
    private String password;
}
