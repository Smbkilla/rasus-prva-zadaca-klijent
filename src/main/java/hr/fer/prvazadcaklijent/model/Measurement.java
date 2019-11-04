package hr.fer.prvazadcaklijent.model;

public class Measurement {
    private String username;
    private String parameter;
    private float averageValue;

    public Measurement() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getParameter() {
        return parameter;
    }

    public void setParameter(String parameter) {
        this.parameter = parameter;
    }

    public float getAverageValue() {
        return averageValue;
    }

    public void setAverageValue(float averageValue) {
        this.averageValue = averageValue;
    }

    @Override
    public String toString() {
        return "Measurement{" +
                "username='" + username + '\'' +
                ", parameter='" + parameter + '\'' +
                ", averageValue=" + averageValue +
                '}';
    }
}
