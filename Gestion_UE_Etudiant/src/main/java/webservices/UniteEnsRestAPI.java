package webservices;
//JAX-RS

import entities.UniteEnseignement;
import metiers.UniteEnseignementBusiness;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.Response;
@Path("/ue")
public class UniteEnsRestAPI {
    UniteEnseignementBusiness helper=
            new UniteEnseignementBusiness();

    //getListUEs
    //web service to get the list of UE
    @Path("/list")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getListUe(){
        return Response.status(200)
                .entity(helper.getListeUE())
                .build();


    }
    @Path("/add")
    @POST
    @Consumes(MediaType.APPLICATION_JSON) //input of the web service
    @Produces(MediaType.TEXT_PLAIN)
    public Response addUniteEnseignement(UniteEnseignement ue){
        if(helper.addUniteEnseignement(ue)){
            return Response.status(201).entity("successful").build();
        }
        else{
            return Response.status(400).entity("Error").build();
        }

    }
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{code}")
    public Response getUEByCode(@PathParam("code") int code) {
        return Response.status(200)
                .entity(helper.getUEByCode(code))
                .build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/")
    public Response getUEBySemestre(@QueryParam("semestre") int semestre){
        return Response.status(200)
                .entity(helper.getUEBySemestre(semestre))
                .build();
    }


}
