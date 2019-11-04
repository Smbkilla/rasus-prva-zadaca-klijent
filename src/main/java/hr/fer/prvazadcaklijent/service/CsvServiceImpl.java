package hr.fer.prvazadcaklijent.service;

import com.opencsv.bean.CsvToBeanBuilder;
import hr.fer.prvazadcaklijent.model.SensorReading;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

public class CsvServiceImpl implements CsvService {
    private List<SensorReading> readings;

    public CsvServiceImpl() {
        try {
            readings = new CsvToBeanBuilder(new FileReader("src/main/resources/data/mjerenja.csv")).withType(SensorReading.class).build().parse();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public List<SensorReading> getAllReadings() {
        return readings;
    }

    public SensorReading getCurrentReading(long startTime) {
        int readingNumber = Math.toIntExact(((System.currentTimeMillis() - startTime) % 100) + 2);
        return readings.get(readingNumber);
    }
}
