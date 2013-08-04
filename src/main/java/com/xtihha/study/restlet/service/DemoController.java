package com.xtihha.study.restlet.service;

import com.xtihha.study.restlet.manager.annotation.Annotation2Manager;
import com.xtihha.study.restlet.manager.annotation.AnnotationManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;

/**
 * User: zhangxiaohu
 * Date: 13-8-3
 * Time: 下午2:39
 */
@Controller
public class DemoController {

    private static final Logger logger = LoggerFactory.getLogger(DemoController.class);
    /**
     * 使用annotation的方式注入，@Autowired根据类型匹配，可以加入@Qualifier进行名称限定
     */
    @Autowired
    @Qualifier("annotationManager")
    private AnnotationManager mgr;
    /**
     * 根据名称进行annotation注入
     */
    @Resource(name = "annotation2Manager")
    private Annotation2Manager mgr2;

    @RequestMapping(value = "/demo", method = RequestMethod.GET)
    public String printHello(ModelMap model) {
        logger.info("demo controller with spring-mvc annotation");
        model.addAttribute("message", "hello spring mvc annotation");

        mgr.hello();
        mgr2.hello2();

        return "demo"; //demo.jsp
    }

    @RequestMapping(value = "/demo2", method = RequestMethod.GET)
    public String demoWithParam(@RequestParam("id") String demoId, ModelMap model) {
        String ret = "get param, id=" + demoId;
        model.addAttribute("message", ret);
        return "demo";
    }

    @RequestMapping(value = "/demo3/{id}", method = RequestMethod.GET)
    public String demoWithParam2(@PathVariable("id") String demoId, ModelMap model){
        String ret = "get param with rest, id=" + demoId;
        model.addAttribute("message", ret);
        return "demo";
    }

}
