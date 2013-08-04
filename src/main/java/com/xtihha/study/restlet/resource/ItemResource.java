package com.xtihha.study.restlet.resource;

import org.restlet.ext.json.JsonRepresentation;
import org.restlet.representation.Representation;
import org.restlet.resource.Get;
import org.restlet.resource.ServerResource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ItemResource extends ServerResource {
    private int counter = 0;
    private static final Logger logger = LoggerFactory.getLogger(ItemResource.class);

    @Get
    public Representation get() {
        String id = (String) getRequest().getAttributes().get("id");
        String value = new StringBuilder().append("{").append("\"data\":{").append("\"id\":")
                .append(id).append(",").append("\"hint\":").append("\"what's hint about\"")
                .append("}").append("}").toString();
        logger.info("value = " + value);

        JsonRepresentation ret = new JsonRepresentation(value);

        //scope为prototype，每次打印都为1
        logger.info("ItemResource counter = {}", ++counter);
        return ret;
    }
}
