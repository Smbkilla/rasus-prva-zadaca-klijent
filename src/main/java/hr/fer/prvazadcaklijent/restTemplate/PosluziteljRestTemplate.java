package hr.fer.prvazadcaklijent.restTemplate;

import hr.fer.prvazadcaklijent.model.Measurement;
import hr.fer.prvazadcaklijent.model.SensorDescription;
import hr.fer.prvazadcaklijent.model.UserAddress;

public interface PosluziteljRestTemplate {
	String register(SensorDescription sensorDescription);

	UserAddress searchNeighbor(String username);

	String storeMeasurements(Measurement measurement);
}
