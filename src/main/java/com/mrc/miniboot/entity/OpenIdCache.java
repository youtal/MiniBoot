package com.mrc.miniboot.entity;

import java.sql.Time;
import java.util.HashMap;

public class OpenIdCache {
    public static HashMap<String, String> code2Id = new HashMap<String, String>();
    public static HashMap<String, Time> cacheTime = new HashMap<String, Time>();
    public static void add(String code, String id) {
        OpenIdCache.remove(code);
        code2Id.put(code, id);
        cacheTime.put(code, new Time(System.currentTimeMillis()));
    }
    public static String get(String code) {
        return code2Id.get(code);
    }

    public static void remove(String code) {
        code2Id.remove(code);
        cacheTime.remove(code);
    }

    public static void clear() {
        code2Id.clear();
        cacheTime.clear();
    }

    public static boolean contains(String code) {
        return code2Id.containsKey(code) && cacheTime.containsKey(code);
    }
}
