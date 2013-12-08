package com.xtihha.study.restlet.service;

import com.xtihha.study.restlet.domain.People;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * User: zhangxiaohu
 * Date: 13-12-8
 * Time: 下午6:29
 *
 * <code>
 *  curl http://127.0.0.1:8080/restlet-test/mvc/mapping/mapping1
 *  curl http://127.0.0.1:8080/restlet-test/mvc/mapping/mapping2
 * </code>
 */
@Controller
@RequestMapping("/mapping")
public class RequestMappingController {

    @ResponseBody
    @RequestMapping(method = RequestMethod.GET, value = "/mapping1")
    public Object mapping1() {
        People p = new People();
        p.setName("z1");
        p.setGender("male");
        p.setAge(30);

        return p;
    }

    @RequestMapping(value = "/mapping2", method = RequestMethod.GET)
    public void help(HttpServletRequest req, HttpServletResponse res) throws IOException {
        StringBuilder sb = new StringBuilder();
        sb.append("/mapping2").append("\t").append("request mapping controller").append("\n");

        res.getWriter().write(sb.toString());
    }
}
