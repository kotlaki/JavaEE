package ru.geekbrains.rest;

import ru.geekbrains.service.ProductDTO;

import javax.ejb.Local;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.sql.SQLException;
import java.util.List;

@Local
@Path("/product")
public interface ProductRestService {

    @POST
    @Path("/new")
    @Consumes(MediaType.APPLICATION_JSON)
    void insert(ProductDTO productDTO);

    @PUT
    @Path("/update")
    @Consumes(MediaType.APPLICATION_JSON)
    void update(ProductDTO productDTO);

    @DELETE
    @Path("/{id}/delete")
    @Consumes(MediaType.APPLICATION_JSON)
    void delete(@PathParam("id") long id) throws SQLException;

    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    List<ProductDTO> findAll();

    @GET
    @Path("/{id}/find")
    @Produces(MediaType.APPLICATION_JSON)
    ProductDTO findById(@PathParam("id") long id);

}
