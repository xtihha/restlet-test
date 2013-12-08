package com.xtihha.study.restlet.interceptor;

import com.xtihha.study.restlet.annotation.SG;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

/**
 * User: zhangxiaohu
 * Date: 13-12-7
 * Time: 下午10:40
 */
@Component
public class SpanNameInterceptor extends HandlerInterceptorAdapter {
    ThreadLocal<String> spanName = new ThreadLocal<String>();

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        Method method = handlerMethod.getMethod();
        System.out.println(method.getDeclaringClass().getSimpleName() + "." + method.getName());

        for (Annotation annotation : method.getDeclaredAnnotations()) {
            System.out.println(annotation.getClass().getCanonicalName());
        }

        SG sg = method.getAnnotation(SG.class);
        if (sg == null)
            return true;

        if (spanName.get() == null) {
            spanName.set(method.getDeclaringClass().getName() + "." + method.getName());
        }

        System.out.println(spanName.get());
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        super.postHandle(request, response, handler, modelAndView);    //To change body of overridden methods use File | Settings | File Templates.
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        super.afterCompletion(request, response, handler, ex);    //To change body of overridden methods use File | Settings | File Templates.
    }
}
