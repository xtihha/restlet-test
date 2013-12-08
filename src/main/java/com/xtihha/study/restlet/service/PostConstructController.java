package com.xtihha.study.restlet.service;

import com.xtihha.study.restlet.annotation.SG;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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

    @SG
    @RequestMapping
    @ResponseBody
    public Object post() {
        return "this is in response body for post construct";
    }

    @PostConstruct
    public void postConstruct() {
        System.out.println("this is in the post construct, you can initialize your context here");
    }

    /**
     * <code>
     * curl -X POST -d "param=1" http://127.0.0.1:8080/restlet-test/mvc/postconstruct/demo1
     * </code>
     *
     * @return
     */
    @RequestMapping(value = "/demo1", method = RequestMethod.POST)
    @ResponseBody
    public String demo1() {
        return "test with post";
    }

    @RequestMapping(value = "/demo2", headers = {"k1=v1", "k2=v2"}, method = RequestMethod.GET)
    @ResponseBody
    public String testWithHeaders() {
        return "test with headers";
    }
}
