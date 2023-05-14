import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        RentalApp rentalApp = new RentalApp();

        int choice = 0;
        do {
            System.out.println("===== Aplikasi Penyewaan Sepeda =====");
            System.out.println("1. Daftar Sepeda yang Tersedia");
            System.out.println("2. Sewa Sepeda");
            System.out.println("3. Kembalikan Sepeda");
            System.out.println("4. Daftar Penyewa Sepeda");
            System.out.println("5. Keluar");
            System.out.print("Pilih menu: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    rentalApp.displayAvailableBikes();
                    break;
                case 2:
                    rentalApp.rentBike();
                    break;
                case 3:
                    rentalApp.returnBike();
                    break;
                case 4:
                    rentalApp.displayRentedBikes();
                    break;
                case 5:
                    System.out.println("Terima kasih telah menggunakan aplikasi ini!");
                    break;
                default:
                    System.out.println("Pilihan tidak valid. Silakan pilih menu yang benar.");
            }
        } while (choice != 5);
        scanner.close();
        System.out.close();
    }
}
