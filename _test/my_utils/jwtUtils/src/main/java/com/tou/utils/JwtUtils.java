package com.tou.utils;

import com.tou.utils.getter.StreamJwtGetter;

public class JwtUtils {

    static JwtProperty property = null;

    public static void setProperty(JwtProperty property) {
        JwtUtils.property = property;
    }

    public static StreamJwtGetter setToken(String token) {
        return new StreamJwtGetter(token, property);
    }


}
