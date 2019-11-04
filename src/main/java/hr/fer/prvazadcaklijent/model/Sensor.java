package hr.fer.prvazadcaklijent.model;

public class Sensor {
    private String username;
    private double latitude;
    private double longitude;
    private String ipAddress;
    private int port;
    private Integer temperature;
    private Integer pressure;
    private Integer humidity;
    private Integer CO;
    private Integer NO2;
    private Integer SO2;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
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
        return "Sensor{" +
                " username='" + username + '\'' +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                ", ipAddress='" + ipAddress + '\'' +
                ", port=" + port +
                ", temperature=" + temperature +
                ", pressure=" + pressure +
                ", humidity=" + humidity +
                ", CO=" + CO +
                ", NO2=" + NO2 +
                ", SO2=" + SO2 +
                '}';
    }
}
