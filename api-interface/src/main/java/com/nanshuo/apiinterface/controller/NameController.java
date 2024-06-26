package com.nanshuo.apiinterface.controller;

import com.nanshuo.apiinterface.model.User;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * 名称 API
 *
 * @author nanshuo
 * @date 2024/04/12 21:54:16
 */
@RestController
@RequestMapping("/name")
public class NameController {

    @GetMapping("/get")
    public String getNameByGet(String name, HttpServletRequest request) {
        System.out.println(request.getHeader("nanshuo"));
        return "GET 你的名字是" + name;
    }

    @PostMapping("/post")
    public String getNameByPost(@RequestParam String name) {
        return "POST 你的名字是" + name;
    }

    @PostMapping("/user")
    public String getUsernameByPost(@RequestBody User user, HttpServletRequest request) {
        //String accessKey = request.getHeader("accessKey");
        //String nonce = request.getHeader("nonce");
        //String timestamp = request.getHeader("timestamp");
        //String sign = request.getHeader("sign");
        //String body = request.getHeader("body");
//        // todo 实际情况应该是去数据库中查是否已分配给用户
//        if (!accessKey.equals("nanshuo")) {
//            throw new RuntimeException("无权限");
//        }
//        if (Long.parseLong(nonce) > 10000) {
//            trow new RuntimeException("无权限");
//        }
        // todo 时间和当前时间不能超过 5 分钟
//        if (timestamp) {
//
//        }
        // todo 实际情况中是从数据库中查出 secretKey
        //String serverSign = SignUtils.genSign(body, "nanshuo");
        //if (!sign.equals(serverSign)) {
        //    throw new RuntimeException("无权限");
        //}
        // todo 调用次数 + 1 invokeCount
        return "POST 用户名字是" + user.getUsername();
    }
}
