package com.tou.utils;

import lombok.Data;

@Data
public class TokenProperty {

    private static String SECRET = "my_df_sc";

    private String secret;

    private String token;

    public static void setSECRET(String secret) {
        SECRET = secret;
    }

    public static String getSECRET() {
        return SECRET;
    }

    public String getSecret() {
        if (secret == null) return SECRET;
        return secret;
    }

    public TokenProperty(String secret) {
        this.secret = secret;
    }

    public TokenProperty(String token, String secret) {
        this.secret = secret;
        this.token = token;
    }
}
