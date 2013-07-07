package com.xtihha.study.restlet.resource;

import org.restlet.ext.json.JsonRepresentation;
import org.restlet.representation.Representation;
import org.restlet.resource.Get;
import org.restlet.resource.ServerResource;

public class ItemResource extends ServerResource {

    @Get
    public Representation get() {
        String id = (String) getRequest().getAttributes().get("id");
        String value = new StringBuilder().append("{").append("\"data\":{").append("\"id\":")
                .append(id).append(",").append("\"hint\":")
                .append("\"what's hint about\"").append("}").append("}").toString();

        JsonRepresentation ret = new JsonRepresentation(value);
        return ret;
    }
}
