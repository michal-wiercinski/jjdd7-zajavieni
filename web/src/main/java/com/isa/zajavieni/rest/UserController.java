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
  public Response isLogged(@Context HttpServletRequest req) {
    String email = null;
    Optional<Object> emailParam = Optional.ofNullable(req.getSession().getAttribute("email"));
    if (emailParam.isPresent()) {
      email = String.valueOf(emailParam);
      if (userService.findByEmail(email).isPresent()) {
        return Response.status(Response.Status.UNAUTHORIZED).build();
      } else {
        return Response.ok().build();
      }
    }
    return Response.status(Response.Status.UNAUTHORIZED).build();
  }
}
