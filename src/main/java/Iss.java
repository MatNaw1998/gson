public class Iss {
    private double longtiude;
    private double latitude;
    private double timestamp;

    public Iss(double longtiude, double latitude, double timestamp) {
        this.longtiude = longtiude;
        this.latitude = latitude;
        this.timestamp = timestamp;
    }

    public double getLongtiude() {
        return longtiude;
    }

    public void setLongtiude(double longtiude) {
        this.longtiude = longtiude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(double timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "Iss{" +
                "longtiude=" + longtiude +
                ", latitude=" + latitude +
                ", timestamp=" + timestamp +
                '}';
    }
}
