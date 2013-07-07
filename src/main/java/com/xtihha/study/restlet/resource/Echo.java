package com.xtihha.study.restlet.resource;

import org.restlet.representation.Representation;
import org.restlet.representation.StringRepresentation;
import org.restlet.resource.Get;
import org.restlet.resource.ServerResource;

@Deprecated
public class Echo extends ServerResource{
    static{
        System.out.println("echo be initialized");
    }

    
    @Get
    public Representation get(){
        System.out.println("in get method");
        return new StringRepresentation("string representation\n");
    }
    
    
}
