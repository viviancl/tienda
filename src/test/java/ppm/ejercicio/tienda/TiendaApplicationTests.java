package ppm.ejercicio.tienda;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import java.net.URI;
import java.util.Collections;

import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TiendaApplicationTests {

	@Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void exampleTest() {
        String url = "/api/tiendas";
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        RequestEntity<Void> requestEntity = new RequestEntity<>(headers, HttpMethod.GET, URI.create(url));
        ResponseEntity<String> responseEntity = restTemplate.exchange(requestEntity, String.class);
        HttpStatus statusCode = (HttpStatus) responseEntity.getStatusCode();
		
        // Realizar aserciones
        Assertions.assertEquals(HttpStatus.OK, statusCode);
        Assertions.assertEquals(MediaType.APPLICATION_JSON, responseEntity.getHeaders().getContentType());

        String responseBody = responseEntity.getBody();
        Assertions.assertNotNull(responseBody);
    }

}



