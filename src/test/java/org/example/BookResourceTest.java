package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.model.Subject;
import org.example.resource.BookResource;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.io.IOException;
import java.net.http.HttpClient;
import java.net.http.HttpResponse;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class BookResourceTest {

    @Mock
    private HttpClient httpClient;

    private final ObjectMapper mapper = new ObjectMapper();
    private Subject mockResponse;

    @Before
    public void setUp() throws IOException {
        MockitoAnnotations.openMocks(this);
        mockResponse = mapper.readValue(getClass().getResource("/response_example.json"), Subject.class);
    }

    @Test
    public void testGetBooksBySubject() throws IOException, InterruptedException {
        HttpResponse response = mock(HttpResponse.class);

        when(response.statusCode()).thenReturn(200);

        ObjectMapper objectMapper = new ObjectMapper();
        String subjectString = objectMapper.writeValueAsString(mockResponse);
        when(response.body()).thenReturn(subjectString);

        BookResource bookResource = new BookResource(httpClient);

        when(httpClient.send(any(), any())).thenReturn(response);
        Subject booksBySubject = bookResource.getBooksBySubject();
        Assertions.assertNotNull(booksBySubject);
    }
}
