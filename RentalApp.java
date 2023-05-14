import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RentalApp {
    private List<Bike> availableBikes;
    private List<Bike> rentedBikes;
    private Scanner scanner;

    public RentalApp() {
        System.out.print("\033[H\033[2J");  
        System.out.flush();  
        availableBikes = new ArrayList<>();
        rentedBikes = new ArrayList<>();
        scanner = new Scanner(System.in);

        // Inisialisasi sepeda yang tersedia
        availableBikes.add(new Bike("001"));
        availableBikes.add(new Bike("002"));
        availableBikes.add(new Bike("003"));
    }

    public void displayAvailableBikes() {
        System.out.print("\033[H\033[2J");  
        System.out.flush();  
        System.out.println("===== Daftar Sepeda Tersedia =====");
        for (Bike bike : availableBikes) {
            if (!bike.isRented()) {
                System.out.println("Sepeda ID: " + bike.getBikeId());
            }
        }
        System.out.println();
    }

    public void rentBike() {
        System.out.print("\033[H\033[2J");  
        System.out.flush();  
        System.out.println("===== Daftar Sepeda Tersedia =====");
        for (Bike bike : availableBikes) {
            if (!bike.isRented()) {
                System.out.println("Sepeda ID: " + bike.getBikeId());
            }
        }
        System.out.println();
        System.out.print("Masukkan ID Sepeda yang ingin disewa: ");
        String bikeId = scanner.next();

        Bike selectedBike = findBikeById(bikeId, availableBikes);
        if (selectedBike != null && !selectedBike.isRented()) {
            System.out.print("Masukkan Nama Penyewa: ");
            String renterName = scanner.next();

            selectedBike.setRented(true);
            selectedBike.setRenterName(renterName);
            rentedBikes.add(selectedBike);

            System.out.println("Sepeda dengan ID " + selectedBike.getBikeId() + " disewa oleh " + renterName);
        } else {
            System.out.println("Sepeda dengan ID " + bikeId + " tidak tersedia atau sudah disewa.");
        }
        System.out.println();
    }

    public void returnBike() {
        System.out.print("\033[H\033[2J");  
        System.out.flush();  
        System.out.print("Masukkan ID Sepeda/Nama Penyewa yang ingin dikembalikan: ");
        String bikeId = scanner.next();

        
        if (findBikeById(bikeId, rentedBikes) != null) {
            Bike selectedBike = findBikeById(bikeId, rentedBikes);
            selectedBike.setRented(false);
            rentedBikes.remove(selectedBike);

            System.out.println("Sepeda dengan ID " + selectedBike.getBikeId() + " telah dikembalikan.");
        } else {
            if (findBikeByRenter(bikeId, rentedBikes) != null) {
                Bike selectedBike = findBikeByRenter(bikeId, rentedBikes);
                selectedBike.setRented(false);
                rentedBikes.remove(selectedBike);

                System.out.println("Sepeda dengan ID " + selectedBike.getBikeId() + " telah dikembalikan.");
            } else {
                System.out.println("Sepeda dengan ID " + bikeId + " tidak ditemukan atau belum disewa.");
            }
        }
        System.out.println();
    }

    public void displayRentedBikes() {
        System.out.print("\033[H\033[2J");  
        System.out.flush();  
        System.out.println("===== Daftar Penyewa Sepeda =====");
        if (rentedBikes.isEmpty()) {
            System.out.println("Tidak ada sepeda yang sedang disewa.");
        } else {
            for (Bike bike : rentedBikes) {
                System.out.println("Sepeda ID: " + bike.getBikeId() + ", Penyewa: " + bike.getRenterName());
            }
        }
        System.out.println();
    }

    private Bike findBikeByRenter(String bikeId, List<Bike> bikeList) {
        for (Bike bike : bikeList) {
            if (bike.getRenter().equals(bikeId)) {
                return bike;
            }
        }
        return null;
    }

    private Bike findBikeById(String renter, List<Bike> bikeList) {
        for (Bike bike : bikeList) {
            if (bike.getBikeId().equals(renter)) {
                return bike;
            }
        }
        return null;
    }
}
