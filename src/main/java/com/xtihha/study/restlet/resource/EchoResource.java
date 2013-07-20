package com.xtihha.study.restlet.resource;

import org.restlet.data.Form;
import org.restlet.ext.json.JsonRepresentation;
import org.restlet.representation.Representation;
import org.restlet.representation.StringRepresentation;
import org.restlet.resource.Get;
import org.restlet.resource.Put;
import org.restlet.resource.ServerResource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

/**
 * User: zhangxiaohu
 * Date: 13-7-20
 * Time: 上午10:10
 */
public class EchoResource extends ServerResource {
    private static final Logger logger = LoggerFactory.getLogger(EchoResource.class);

    @Put
    public Representation post(Representation entity) {
        Form form = new Form(entity);
        StringBuilder sb = new StringBuilder().append("{\"data\":{");
        Map<String, String> params = form.getValuesMap();

        int size = params.size();
        int index = 0;
        for (String key : params.keySet()) {
            sb.append("\"").append(key).append("\"").append(":").
                    append("\"").append(params.get(key)).append("\"");

            index++;
            if (index != size)
                sb.append(", ");
        }

        sb.append("}").append("}");
        String retValue = sb.toString();
        logger.info(retValue);

        return new JsonRepresentation(retValue);
    }

    @Get
    public Representation get() {
        return new StringRepresentation("get success");
    }
}
