package restTemplate;

import model.Measurement;
import model.SensorDescription;
import model.UserAddress;

public interface RestInterface {
	String register(SensorDescription sensorDescription);

	UserAddress searchNeighbor(String username);

	void storeMeasurements(String username, Measurement measurement);
}
