import model.Measurement;
import model.SensorDescription;
import model.UserAddress;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;
import restTemplate.RestInterface;

public class RestTemplateImplementation implements RestInterface {
	private String baseURL;
	private RestTemplate restTemplate;

	public RestTemplateImplementation(String url) {
		this.baseURL = url;

		restTemplate = new RestTemplate();
		restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
	}

	public String register(final SensorDescription sensorDescription) {
		ResponseEntity<String> response = restTemplate.postForEntity(baseURL + "/register", sensorDescription, String.class);
		return null;
	}

	public UserAddress searchNeighbor(final String username) {
		ResponseEntity<UserAddress> response = restTemplate.getForEntity(baseURL + "/sensor/" + username + "searchNeighbor", UserAddress.class);
		return null;
	}

	public void storeMeasurements(final String username, final Measurement measurement) {
		ResponseEntity<String> response = restTemplate.postForEntity(baseURL + "/storeMeasurements/" + username, measurement, String.class);
	}
}
