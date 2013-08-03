package com.xtihha.study.restlet.servlet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * User: zhangxiaohu
 * Date: 13-8-3
 * Time: 下午2:39
 */
@Controller
public class DemoController {

    private static final Logger logger = LoggerFactory.getLogger(DemoController.class);

    @RequestMapping(value="/demo", method = RequestMethod.GET)
    public String printHello(ModelMap model){
        logger.info("demo controller with spring-mvc annotation");
        model.addAttribute("message", "hello spring mvc annotation");

        return "demo"; //demo.jsp
    }
}
