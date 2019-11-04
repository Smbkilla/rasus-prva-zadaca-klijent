package hr.fer.prvazadcaklijent.service;

import hr.fer.prvazadcaklijent.model.SensorReading;

import java.util.List;

public interface CsvService {

    List<SensorReading> getAllReadings();

    SensorReading getCurrentReading(long startTime);
}
