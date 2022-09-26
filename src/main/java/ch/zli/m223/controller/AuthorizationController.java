package ch.zli.m223.controller;


import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import ch.zli.m223.dto.LoginData;
import ch.zli.m223.model.User;
import ch.zli.m223.service.AuthorizationService;



@Path("/auth")
public class AuthorizationController {
    @Inject
    AuthorizationService authorizationService;

    @POST
    @Produces(MediaType.TEXT_PLAIN) 
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/login")
    public String login(LoginData LoginData) {
        User user = authorizationService.getUserByUsername(LoginData.getUsername());
        if (user.getPassword().equals(LoginData.getPassword())) {
            return "Login successful";
        } else {
            return "Login failed";
        }
    }

}
