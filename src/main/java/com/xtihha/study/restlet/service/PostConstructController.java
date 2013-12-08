package com.xtihha.study.restlet.service;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.PostConstruct;

/**
 * User: zhangxiaohu
 * Date: 13-12-8
 * Time: 下午8:01
 */
@Controller
@RequestMapping(value = "/postconstruct")
public class PostConstructController {
    @RequestMapping
    @ResponseBody
    public Object post() {
        return "this is in response body for post construct";
    }

    @PostConstruct
    public void postConstruct() {
        System.out.println("this is in the post construct, you can initialize your context here");
    }
}
