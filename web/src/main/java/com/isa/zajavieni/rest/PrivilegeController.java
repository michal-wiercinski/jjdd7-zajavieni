package com.isa.zajavieni.rest;

import com.isa.zajavieni.entity.User;
import com.isa.zajavieni.entity.UserType;
import com.isa.zajavieni.service.UserService;
import org.apache.commons.lang3.math.NumberUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.EJB;
import javax.ws.rs.PATCH;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

@Path("/admin")
public class PrivilegeController {

    @EJB
    UserService userService;

    private Logger logger = LoggerFactory.getLogger(getClass().getName());

    @PATCH
    @Path("/give/{id}")
    public Response givePermissions(@PathParam("id") String idParam) {

        if (idParam == null || idParam.isEmpty() || !NumberUtils.isDigits(idParam)) {
            return Response.status(Status.BAD_REQUEST).build();
        }
        Long id = Long.valueOf(idParam);

        if (userService.findUserById(id) == null) {
            logger.warn("User with id: {} not found", id);
            return Response.status(Status.NOT_FOUND).build();
        }

        User user = userService.findUserById(id);

        if (user.getUserType().equals(UserType.ADMIN) ||
                user.getUserType().equals(UserType.SUPER_ADMIN)) {
            return Response.status(Status.NOT_MODIFIED).build();
        }

        user.setUserType(UserType.ADMIN);
        userService.editUser(user);

        logger.info("User with id: {} received admin privileges", id);
        return Response.ok().build();

    }

    @PATCH
    @Path("/revoke/{id}")
    public Response revokePermissions(@PathParam("id") String idParam) {

        if (idParam == null || idParam.isEmpty() || !NumberUtils.isDigits(idParam)) {
            return Response.status(Status.BAD_REQUEST).build();
        }
        Long id = Long.valueOf(idParam);

        if (userService.findUserById(id) == null) {
            logger.warn("User with id: {} not found", id);
            return Response.status(Status.NOT_FOUND).build();
        }

        User user = userService.findUserById(id);

        if (user.getUserType().equals(UserType.USER) ||
                user.getUserType().equals(UserType.SUPER_ADMIN)) {
            return Response.status(Status.NOT_MODIFIED).build();
        }

        user.setUserType(UserType.USER);
        userService.editUser(user);

        logger.info("User with id: {} admin privileges revoked", id);
        return Response.ok().build();
    }


}
