package it.gambastefano.template.rs;

import it.gambastefano.template.business.OggettoManager;
import it.gambastefano.template.dto.OggettoRequestDto;
import it.gambastefano.template.dto.OggettoResponseDto;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;

@Path("/oggetti")
public class OggettoResource {

    // CREATE
    @POST
    @Path("/")
    public Response createOggetto(OggettoRequestDto oggetto) {
        Integer id = OggettoManager.createOggetto(oggetto);
        if (id != null) {
            return ResponseUtil.ok("Oggetto salvato con successo con id: " + id.toString());
        }

        return ResponseUtil.badRequest("Errore nel salvataggio");
    }

    // READ
    @GET
    @Path("/{id}")
    public Response getOggetto(@PathParam("id") Integer id) {
        OggettoResponseDto oggetto = OggettoManager.getOggetto(id);
        if (oggetto == null) {
            return ResponseUtil.notFound("Il oggetto non esiste");
        }

        return ResponseUtil.ok(oggetto);
    }

    // UPDATE
    @PUT
    @Path("/{id}")
    public Response updateOggetto(@PathParam("id") Integer id, OggettoRequestDto oggetto) {
        boolean updated = OggettoManager.updateOggetto(id, oggetto);
        if (updated) {
            return ResponseUtil.ok("Oggetto " + id + " aggiornato con successo");
        }

        return ResponseUtil.badRequest("Errore nel salvataggio");
    }

    // DELETE
    @DELETE
    @Path("/{id}")
    public Response deleteOggetto(@PathParam("id") Integer id) {
        boolean deleted = OggettoManager.deleteOggetto(id);
        if (deleted) {
            return ResponseUtil.noContent();
        }

        return ResponseUtil.notFound("L'oggetto " + id + " non esiste");
    }
}
