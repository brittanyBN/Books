package org.example.resource;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.model.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Path("/subjects")
@Produces(MediaType.APPLICATION_JSON)public class BookResource {
    private static final String OPEN_LIBRARY_URL = "http://openlibrary.org/subjects/scary.json";
    private static final Logger LOG = LoggerFactory.getLogger(BookResource.class);
    private final HttpClient httpClient;
    private static final ObjectMapper objectMapper = new ObjectMapper();

    public BookResource() {
        this.httpClient = HttpClient.newHttpClient();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Subject getBooksBySubject() throws IOException, InterruptedException {
        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(OPEN_LIBRARY_URL))
                    .GET()
                    .build();
            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            if(response.statusCode() == 200) {
                Subject subject = objectMapper.readValue(response.body(), Subject.class);
                LOG.debug("Returns response: {}", subject != null);
                return subject;
            } else {
                return null;
            }
        } catch (Exception e) {
            LOG.error("Exception found while getting Martian Weather", e);
            throw e;
        }
    }
}
