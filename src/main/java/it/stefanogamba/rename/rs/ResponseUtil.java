package it.stefanogamba.rename.rs;

import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

public class ResponseUtil {

    public static Response ok(Object entity) {
        return Response.status(Response.Status.OK)
                .type(MediaType.APPLICATION_JSON)
                .entity(entity).build();
    }

    public static Response notFound(Object entity) {
        return Response.status(Response.Status.NOT_FOUND)
                .type(MediaType.APPLICATION_JSON)
                .entity(entity).build();
    }

    public static Response noContent() {
        return Response.status(Response.Status.NO_CONTENT).build();
    }

    public static Response serverError(Object entity) {
        return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                .type(MediaType.APPLICATION_JSON)
                .entity(entity).build();
    }

    public static Response badRequest(Object entity) {
        return Response.status(Response.Status.BAD_REQUEST)
                .type(MediaType.APPLICATION_JSON)
                .entity(entity).build();
    }
}
