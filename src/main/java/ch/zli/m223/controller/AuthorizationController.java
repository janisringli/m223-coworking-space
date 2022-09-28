package ch.zli.m223.controller;


import javax.inject.Inject;
import javax.persistence.NoResultException;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import ch.zli.m223.dto.LoginData;
import ch.zli.m223.model.User;
import ch.zli.m223.service.AuthorizationService;
import io.smallrye.jwt.build.Jwt;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;




@Path("/auth")
public class AuthorizationController {
    @Inject
    AuthorizationService authorizationService;

    @POST
    @Produces(MediaType.TEXT_PLAIN) 
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/login")
    public Response login(LoginData LoginData) {
        try{
            User user = authorizationService.getUserByUsername(LoginData.getUsername());
            if (user.getPassword().equals(LoginData.getPassword())) {
                String jwt = Jwt
                .issuer("https://example.com/issuer") 
                .upn("jdoe@quarkus.io") 
                .groups(user.getRoles().getRoleName()) 
                .claim(user.getFirstName(), user.getLastName()) 
                .sign();
           return Response.ok(jwt).build();
        }
            return Response.status(Response.Status.BAD_REQUEST).entity("Wrong credentials").build();
        } catch (NoResultException e) {
            return Response.status(Status.BAD_REQUEST).entity("Wrong credentials").build();
    }
    }
}