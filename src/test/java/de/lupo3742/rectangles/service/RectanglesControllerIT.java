package de.lupo3742.rectangles.service;

import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import de.lupo3742.rectangles.RectanglesApplication;

/**
 * Integration tests for verifying the REST interface
 * 
 * @author Lupo3742
 *
 */
@SpringBootTest(classes = RectanglesApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class RectanglesControllerIT {
    
    private static final String JSON_REQUEST_BODY_ONE_RECTANGLE = 
            "{" + 
            "    \"points\": [" + 
            "        {\"x\": 1, \"y\": 1}," + 
            "        {\"x\": 1, \"y\": 2}," + 
            "        {\"x\": 2, \"y\": 1}," + 
            "        {\"x\": 2, \"y\": 2}" + 
            "    ]" + 
            "}";
    
    @LocalServerPort
    private int port;

    private final TestRestTemplate restTemplate = new TestRestTemplate();

    @Test
    public void shouldFindOneRectangle() throws JSONException {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> entity = new HttpEntity<>(JSON_REQUEST_BODY_ONE_RECTANGLE, headers);

        ResponseEntity<String> response = restTemplate.exchange(
                createURLWithPort("/rectangles"),
                HttpMethod.POST, 
                entity, 
                String.class);

        // result should indicate one rectangle
        String expectedResponse = "{\"numberRectangles\": 1}";

        JSONAssert.assertEquals(expectedResponse, response.getBody(), false);
    }

    private String createURLWithPort(String uri) {
        return "http://localhost:" + port + uri;
    }
}
