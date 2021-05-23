package com.tou.utils.verifier;

import com.tou.utils.TokenProperty;
import com.tou.utils.getter.StreamJwtGetter;

public class TokenVerifier {

    public static StreamJwtGetter setToken(String token) {
        return new StreamJwtGetter(new TokenProperty(token, TokenProperty.getSECRET()));
    }

}
