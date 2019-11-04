package hr.fer.prvazadcaklijent.restTemplate;

import hr.fer.prvazadcaklijent.model.Measurement;
import hr.fer.prvazadcaklijent.model.SensorDescription;
import hr.fer.prvazadcaklijent.model.UserAddress;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

public class PosluziteljRestTemplateImpl implements PosluziteljRestTemplate {
    private String baseURL;
    private RestTemplate restTemplate;

    public PosluziteljRestTemplateImpl(String url) {
        this.baseURL = url;

        restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
    }

    public String register(final SensorDescription sensorDescription) {
        ResponseEntity<String> response = restTemplate.postForEntity(baseURL + "/register", sensorDescription, String.class);
        return response.getBody();
    }

    public UserAddress searchNeighbor(final String username) {
        return restTemplate.getForObject(baseURL + "/sensor/" + username + "/searchNeighbor", UserAddress.class);
    }

    public String storeMeasurements(final Measurement measurement) {
        ResponseEntity<String> response = restTemplate.postForEntity(baseURL + "/storeMeasurements", measurement, String.class);
        return response.getBody();
    }
}
