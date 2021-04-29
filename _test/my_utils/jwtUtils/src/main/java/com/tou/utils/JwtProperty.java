package com.tou.utils;

import lombok.Data;

@Data
public class JwtProperty {
    private final String SECRET;

    public JwtProperty(String secret) {
        this.SECRET = secret;
    }
}
