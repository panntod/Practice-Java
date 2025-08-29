package TokoOnline;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        while (true) { // looping supaya bisa logout dan kembali lagi
            System.out.println("\n===== Selamat Datang di Toko Online =====");
            System.out.println("[1] Login sebagai Admin");
            System.out.println("[2] Login sebagai Customer");
            System.out.println("[3] Keluar Aplikasi");
            System.out.print("Pilih: ");
            int role = scan.nextInt();
            scan.nextLine();

            switch (role) {
                case 1 -> {
                    Admin admin = new Admin();
                    admin.interact();
                }
                case 2 -> {
                    Customer customer = new Customer();
                    customer.interact();
                }
                case 3 -> {
                    System.out.println("Terima kasih telah menggunakan aplikasi!");
                    scan.close();
                    System.exit(0);
                    return;
                }
                default -> System.out.println("Pilihan tidak valid!");
            }
        }
    }
}
