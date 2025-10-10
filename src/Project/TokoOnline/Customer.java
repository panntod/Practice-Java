package Project.TokoOnline;

import java.util.ArrayList;
import java.util.Scanner;

public class Customer extends User {
    private int saldo;
    private ArrayList<Menu> orders = new ArrayList<>();
    private int total = 0;

    private Scanner scan = new Scanner(System.in);

    public void interact() {
        System.out.print("Masukkan Nama: ");
        setName(scan.nextLine());

        System.out.print("Masukkan Alamat: ");
        setAddress(scan.nextLine());

        System.out.print("Masukkan Nomor HP: ");
        setPhoneNumber(scan.nextLine());

        System.out.println("\n======== Selamat Datang ========");
        System.out.println("[1] Lihat Menu & Beli");
        System.out.println("[2] Keluar");
        System.out.print("Pilih: ");

        int select_menu = scan.nextInt();
        scan.nextLine();

        switch (select_menu) {
            case 1 -> {
                Menu.tampilkanMenu();
                purchase();
            }
            case 2 -> {
                System.out.println("Terima kasih, sampai jumpa!");
                return;
            }
            default -> System.out.println("Pilihan tidak valid!");
        }
    }

    private void purchase() {
        System.out.print("Masukkan nomor menu yang ingin dibeli: ");
        int nomor = scan.nextInt();
        scan.nextLine();

        if (nomor < 1 || nomor > Menu.jumlahMenu) {
            System.out.println("Pilihan tidak valid!");
            return;
        }

        Menu selected = Menu.daftarMenu[nomor - 1];
        orders.add(selected);
        total += selected.getHarga();

        System.out.println("Apakah ingin membeli lagi (y/n)? ");
        String decision = scan.nextLine();

        if (decision.equalsIgnoreCase("n")) {
            checkout();
        } else {
            Menu.tampilkanMenu();
            purchase();
        }
    }

    private void checkout() {
        System.out.println("\n========================");
        System.out.println("Total belanja kamu: Rp " + total);
        System.out.print("Masukkan saldo: ");
        saldo = scan.nextInt();

        if (saldo < total) {
            System.out.println("========================");
            System.out.println("Saldo kamu kurang!");
            System.out.println("========================");
            return;
        } else {
            System.out.println("========================");
            System.out.println("Atas nama: " + getName());
            System.out.println("Alamat: " + getAddress());
            System.out.println("Nomor HP: " + getPhoneNumber());
            System.out.print("Pesanan: ");
            for (Menu m : orders) {
                System.out.print(m.getNama() + " ");
            }
            System.out.println();
            System.out.println("Saldo: Rp " + saldo);
            System.out.println("Total biaya: Rp " + total);
            System.out.println("Kembalian: Rp " + (saldo - total));
            System.out.println("========================");
        }

        // Reset belanja
        orders.clear();
        total = 0;
    }
}
