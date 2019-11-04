package hr.fer.prvazadcaklijent.model;

public class UserAddress {
    private String ipAddress;
    private int port;

    public UserAddress() {
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

    @Override
    public String toString() {
        return "UserAddress{" +
                "ipAddress='" + ipAddress + '\'' +
                ", port=" + port +
                '}';
    }
}
