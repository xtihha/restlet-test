package com.xtihha.study.restlet.resource.filter;

import org.restlet.Request;
import org.restlet.Response;
import org.restlet.routing.Filter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * User: zhangxiaohu
 * Date: 13-8-4
 * Time: 下午7:46
 */
public class UserFilter extends Filter {

    private static final Logger logger = LoggerFactory.getLogger(UserFilter.class);

    @Override
    public int beforeHandle(Request request, Response response) {
        super.beforeHandle(request, response);
        String userId = (String) request.getAttributes().get("id");
        logger.info("user id = {}", userId);

        return CONTINUE;
    }

    @Override
    public void afterHandle(Request request, Response response) {
        super.afterHandle(request, response);
    }
}
