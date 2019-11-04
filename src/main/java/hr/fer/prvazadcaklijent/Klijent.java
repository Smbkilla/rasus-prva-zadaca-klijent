package hr.fer.prvazadcaklijent;

import hr.fer.prvazadcaklijent.model.*;
import hr.fer.prvazadcaklijent.restTemplate.PosluziteljRestTemplate;
import hr.fer.prvazadcaklijent.restTemplate.PosluziteljRestTemplateImpl;
import hr.fer.prvazadcaklijent.tcp.MultithreadedServer;
import hr.fer.prvazadcaklijent.tcp.TCPClient;

import java.util.Scanner;

public class Klijent {
    public static void main(String[] args) {

        String url = "http://localhost:8080";
        long startTime = System.currentTimeMillis();
        PosluziteljRestTemplate posluziteljRestTemplate = new PosluziteljRestTemplateImpl(url);
        Sensor sensor = new Sensor();
        Scanner scanner = new Scanner(System.in);
        SensorDescription sensorDescription = registerSensor(posluziteljRestTemplate, args[0], args[1], Integer.parseInt(args[2]));

        sensor.setUsername(sensorDescription.getUsername());
        sensor.setLatitude(sensorDescription.getLatitude());
        sensor.setLongitude(sensorDescription.getLongitude());
        sensor.setIpAddress(sensorDescription.getIpAddress());
        sensor.setPort(sensorDescription.getPort());

        MultithreadedServer multithreadedServer = new MultithreadedServer(sensor.getPort(), startTime);
        multithreadedServer.startup();

        String nextCommand;

        while (scanner.hasNext()) {
            nextCommand = scanner.nextLine();
            if ("sused".equals(nextCommand)) {
                System.out.println("sused");

                searchNeighbor(posluziteljRestTemplate, sensor.getUsername());
            } else if ("uskladi".equals(nextCommand)) {
                System.out.println("uskladi");

                compareWithNeighbor(searchNeighbor(posluziteljRestTemplate, sensor.getUsername()), sensor);

                System.out.println("store new measurements");
                storeMeasurements(posluziteljRestTemplate, sensor);

            } else if ("shutdown".equals(nextCommand)) {
                System.out.println("shutdown");

                multithreadedServer.shutdown();

                break;
            } else if ("loop".equals(nextCommand)) {
                System.out.println("loops");

                multithreadedServer.loop();

                break;
            }
        }

    }

    private static SensorDescription registerSensor(PosluziteljRestTemplate posluziteljRestTemplate, String username, String ipAddress, int port) {
        SensorDescription sensor = new SensorDescription();

        sensor.setUsername(username);
        sensor.setLatitude(Math.random() * (15.87 - 16) + 15.87);
        sensor.setLongitude(Math.random() * (45.75 - 45.85) + 45.75);
        sensor.setIpAddress(ipAddress);
        sensor.setPort(port);

        System.out.println(posluziteljRestTemplate.register(sensor));
        return sensor;
    }

    private static UserAddress searchNeighbor(PosluziteljRestTemplate posluziteljRestTemplate, String username) {
        return posluziteljRestTemplate.searchNeighbor(username);
    }

    private static void storeMeasurements(PosluziteljRestTemplate posluziteljRestTemplate, Sensor sensor) {
        Measurement measurement = new Measurement();
        measurement.setUsername(sensor.getUsername());

        if (sensor.getTemperature() != null) {
            measurement.setParameter("Temperature");
            measurement.setAverageValue(sensor.getTemperature());
            posluziteljRestTemplate.storeMeasurements(measurement);
        }

        if (sensor.getPressure() != null) {
            measurement.setParameter("Pressure");
            measurement.setAverageValue(sensor.getPressure());
            posluziteljRestTemplate.storeMeasurements(measurement);
        }

        if (sensor.getHumidity() != null) {
            measurement.setParameter("Humidity");
            measurement.setAverageValue(sensor.getHumidity());
            posluziteljRestTemplate.storeMeasurements(measurement);
        }

        if (sensor.getCO() != null) {
            measurement.setParameter("CO");
            measurement.setAverageValue(sensor.getCO());
            posluziteljRestTemplate.storeMeasurements(measurement);
        }

        if (sensor.getNO2() != null) {
            measurement.setParameter("NO2");
            measurement.setAverageValue(sensor.getNO2());
            posluziteljRestTemplate.storeMeasurements(measurement);
        }

        if (sensor.getSO2() != null) {
            measurement.setParameter("SO2");
            measurement.setAverageValue(sensor.getSO2());
            posluziteljRestTemplate.storeMeasurements(measurement);
        }
    }

    private static void compareWithNeighbor(UserAddress neighborAddress, Sensor sensor) {
        TCPClient tcpClient = new TCPClient();

        SensorReading sensorReading = tcpClient.getNeighborData(neighborAddress.getIpAddress(), neighborAddress.getPort());

        if (sensorReading != null) {
            if (sensorReading.getTemperature() != null) {
                if (sensor.getTemperature() != null) {
                    sensor.setTemperature((sensor.getTemperature() + sensorReading.getTemperature()) / 2);
                } else {
                    sensor.setTemperature(sensorReading.getTemperature());
                }
            }

            if (sensorReading.getPressure() != null) {
                if (sensor.getPressure() != null) {
                    sensor.setPressure((sensor.getPressure() + sensorReading.getPressure()) / 2);
                } else {
                    sensor.setPressure(sensorReading.getPressure());
                }
            }

            if (sensorReading.getHumidity() != null) {
                if (sensor.getHumidity() != null) {
                    sensor.setHumidity((sensor.getHumidity() + sensorReading.getHumidity()) / 2);
                } else {
                    sensor.setHumidity(sensorReading.getHumidity());
                }
            }

            if (sensorReading.getCO() != null) {
                if (sensor.getCO() != null) {
                    sensor.setCO((sensor.getCO() + sensorReading.getCO()) / 2);
                } else {
                    sensor.setCO(sensorReading.getCO());
                }
            }

            if (sensorReading.getNO2() != null) {
                if (sensor.getNO2() != null) {
                    sensor.setNO2((sensor.getNO2() + sensorReading.getNO2()) / 2);
                } else {
                    sensor.setNO2(sensorReading.getNO2());
                }
            }

            if (sensorReading.getSO2() != null) {
                if (sensor.getSO2() != null) {
                    sensor.setSO2((sensor.getSO2() + sensorReading.getSO2()) / 2);
                } else {
                    sensor.setSO2(sensorReading.getSO2());
                }
            }
        }
    }
}
