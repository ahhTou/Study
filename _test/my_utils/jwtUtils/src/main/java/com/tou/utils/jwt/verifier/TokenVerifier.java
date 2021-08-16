package com.tou.utils.jwt.verifier;

import com.tou.utils.jwt.TokenProperty;
import com.tou.utils.jwt.getter.StreamJwtGetter;

public class TokenVerifier {

    public static StreamJwtGetter setToken(String token) {
        return new StreamJwtGetter(new TokenProperty(token, TokenProperty.getSECRET()));
    }

}
