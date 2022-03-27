package com.mrc.miniboot.utils;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class Utils {
    public static String get_url(String _url, String data) throws IOException {
        URL url = new URL(_url);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.setRequestProperty("data", data);
        return "";
    }
}
