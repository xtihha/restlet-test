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
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 尝试了四种方法
 * <li>直接返回view，在spring-mvc-config.xml文件需要定义view的解析</li>
 * <li>路径携带参数，类似xxx?p=v，依然寻找view返回</li>
 * <li>rest风格路径，依然寻找view返回</li>
 * <li>rest风格路径，直接调用Response相关返回写会，不寻找view</li>
 * <p/>
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
    public void help(HttpServletRequest req, HttpServletResponse res) throws IOException {
        StringBuilder sb = new StringBuilder();
        sb.append("/demo1").append("\t").append("resolve by viewResolver").append("\n");
        sb.append("/demo2?id=xx").append("\t").append("resolve by viewResolver").append("\n");
        sb.append("/demo3/{id}").append("\t").append("resolve by viewResolver").append("\n");
        sb.append("/demo4/{id}").append("\t").append("directly write through").append("\n");

        res.getWriter().write(sb.toString());
    }

    @RequestMapping(value = "/demo1", method = RequestMethod.GET)
    public String printHello(ModelMap model) {
        logger.info("demo controller with spring-mvc annotation");
        model.addAttribute("message", "hello spring mvc annotation");

        mgr.hello();
        mgr2.hello2();

        //ViewResolver会自动解析文件路径，增补为${prefix}folder/demo2${suffix}
        // 其中一般prefix定义为/WEB-INF/jsp, suffix定义为.jsp
        return "folder/demo2"; //demo2.jsp
    }

    @RequestMapping(value = "/demo2", method = RequestMethod.GET)
    public String demoWithParam2(@RequestParam("id") String demoId, ModelMap model) {
        String ret = "get param2, id=" + demoId;
        model.addAttribute("message", ret);
        return "folder/demo2";
    }

    @RequestMapping(value = "/demo3/{id}", method = RequestMethod.GET)
    public String demoWithParam3(@PathVariable("id") String demoId, ModelMap model) {
        String ret = "get param3 with rest, id=" + demoId;
        model.addAttribute("message", ret);
        return "folder/demo2";
    }

    @RequestMapping(value = "/demo4/{id}", method = RequestMethod.GET)
    public void demoWithParam4(@PathVariable("id") String demoId,
                               HttpServletRequest request,
                               HttpServletResponse response) throws IOException {
        String ret = "get param4 with rest, id=" + demoId;
        response.getWriter().write(ret);
    }

}
