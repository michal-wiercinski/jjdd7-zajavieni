package com.isa.zajavieni.rest;

import com.isa.zajavieni.service.UserService;

import javax.ejb.EJB;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import java.util.Optional;

@Path("/user")
public class UserController {

    @EJB
    UserService userService;

    @GET
    @Path("/isLogged")
    public Response isLogged(@Context HttpServletRequest req){
        Optional<String> email = Optional.ofNullable
                (req.getSession().getAttribute("email"));

        if(userService.ifExist(String.valueOf(Optional.of(email))) == null){
            return Response.status(Response.Status.UNAUTHORIZED).build();
        }else {
            return Response.ok().build();
        }
    }


}
