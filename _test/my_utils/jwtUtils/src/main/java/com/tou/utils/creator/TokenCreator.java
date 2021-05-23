package com.tou.utils.creator;

import com.tou.utils.JwtService;
import com.tou.utils.TokenProperty;
import com.tou.utils.handler.IJwtCreateMapHandler;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class TokenCreator {

    public static String create(IJwtCreateMapHandler createMapHandler, int calendar, int count) {
        HashMap<String, String> map = new HashMap<>();
        createMapHandler.setMap(map);
        return toCreate(map, calendar, count);
    }

    public static String create(int calendar, int count) {
        return toCreate(null, calendar, count);
    }

    private static String toCreate(Map<String, String> map, int calendar, int count) {
        Calendar instance = Calendar.getInstance();
        if (map != null) instance.add(calendar, count);
        return JwtService.getToken(map, instance.getTime(), TokenProperty.getSECRET());
    }

}
