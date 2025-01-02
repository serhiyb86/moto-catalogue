package org.acme.moto.controller;

import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.acme.moto.data.Spare;
import org.acme.moto.data.repository.SpareRepository;

import java.util.List;

@Path("/spares")
public class SpareController {

    @Inject
    private SpareRepository spareRepository;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public List<Spare> list() {
        return spareRepository.listAll();
    }
}
