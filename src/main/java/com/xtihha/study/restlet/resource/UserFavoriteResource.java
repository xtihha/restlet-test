package com.xtihha.study.restlet.resource;

import org.restlet.representation.Representation;
import org.restlet.representation.StringRepresentation;
import org.restlet.representation.WriterRepresentation;
import org.restlet.resource.Get;
import org.restlet.resource.ServerResource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.Writer;
import java.util.Map;

/**
 * User: zhangxiaohu
 * Date: 13-8-4
 * Time: 下午7:50
 */
public class UserFavoriteResource extends ServerResource {

    private static final Logger logger = LoggerFactory.getLogger(UserFavoriteResource.class);

    @Get
    public Representation getFavorite() {
        Map<String, Object> attrs = getRequest().getAttributes();
        String userId = (String) attrs.get("id");
        String favoriteId = (String) attrs.get("favoriteId");
        final String ret = "user id is " + userId + ", favorite id is " + favoriteId;
        logger.info(ret);

        StringRepresentation rep = new StringRepresentation(ret);
        return rep;
    }

}
