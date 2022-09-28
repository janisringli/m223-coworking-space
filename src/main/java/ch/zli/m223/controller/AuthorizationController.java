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
import io.smallrye.jwt.build.Jwt;



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
            String token =
           Jwt.issuer("https://example.com/issuer") 
             .upn("jdoe@quarkus.io") 
             .groups(user.getRoles().getRoleName()) 
             .claim(user.getFirstName(), user.getLastName()) 
           .sign();
        System.out.println(token);
            return token;
        } else {
            return "Login failed";
        }
    }

}
