package com.by.utils;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.util.StringUtils;

import java.util.Arrays;

public class RrHttpHeaderUtils {
    public static HttpHeaders getHttpHeaders(String token) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        if (StringUtils.hasLength(token)) {
            httpHeaders.add("Authorization", "Bearer " + token);
        }
        return httpHeaders;
    }
}
