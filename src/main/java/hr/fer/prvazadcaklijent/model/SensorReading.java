package hr.fer.prvazadcaklijent.model;

public class SensorReading {
    private Integer temperature;
    private Integer pressure;
    private Integer humidity;
    private Integer CO;
    private Integer NO2;
    private Integer SO2;

    public SensorReading() {
    }

    public Integer getTemperature() {
        return temperature;
    }

    public void setTemperature(Integer temperature) {
        this.temperature = temperature;
    }

    public Integer getPressure() {
        return pressure;
    }

    public void setPressure(Integer pressure) {
        this.pressure = pressure;
    }

    public Integer getHumidity() {
        return humidity;
    }

    public void setHumidity(Integer humidity) {
        this.humidity = humidity;
    }

    public Integer getCO() {
        return CO;
    }

    public void setCO(Integer CO) {
        this.CO = CO;
    }

    public Integer getNO2() {
        return NO2;
    }

    public void setNO2(Integer NO2) {
        this.NO2 = NO2;
    }

    public Integer getSO2() {
        return SO2;
    }

    public void setSO2(Integer SO2) {
        this.SO2 = SO2;
    }

    @Override
    public String toString() {
        return "SensorReading{" +
                "temperature=" + temperature +
                ", pressure=" + pressure +
                ", humidity=" + humidity +
                ", CO=" + CO +
                ", NO2=" + NO2 +
                ", SO2=" + SO2 +
                '}';
    }
}
