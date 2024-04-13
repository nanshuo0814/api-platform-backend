package com.nanshuo.apiclientsdk.utils;


import cn.hutool.crypto.digest.DigestAlgorithm;
import cn.hutool.crypto.digest.Digester;

/**
 * 签名工具
 *
 * @author nanshuo
 * @date 2024/04/13 14:41:10
 */
public class SignUtils {
    /**
     * 生成签名
     *
     * @param body      车身
     * @param secretKey 密钥
     * @return {@code String}
     */
    public static String genSign(String body, String secretKey) {
        Digester md5 = new Digester(DigestAlgorithm.SHA256);
        String content = body + "." + secretKey;
        return md5.digestHex(content);
    }
}
