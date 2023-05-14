public class Bike {
    private String bikeId;
    private boolean isRented;
    private String renterName;

    public Bike(String bikeId) {
        this.bikeId = bikeId;
        this.isRented = false;
    }

    public String getBikeId() {
        return bikeId;
    }   
    
    public String getRenter() {
        return renterName;
    }

    public boolean isRented() {
        return isRented;
    }

    public void setRented(boolean rented) {
        isRented = rented;
    }

    public String getRenterName() {
        return renterName;
    }

    public void setRenterName(String renterName) {
        this.renterName = renterName;
    }
}
