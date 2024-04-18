package com.nanshuo.apiclientsdk.utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SignUtilsTest {

    @Test
    void genSign() {
        //3b066feefd87f19a613440489f53bdc698bd39a9a208caa5c0cdaba72332be46
        String body = "{\"username\":\"nanshuo\"}";
        String secretKey = "7e6a97d8ec22f2e036f4e9232af874c4";
        String sign = SignUtils.genSign(body, secretKey);
        System.out.println(sign);
    }
}