package TokoOnline;

import java.util.Scanner;

public class Admin extends User {
    private Scanner scan = new Scanner(System.in);

    public void interact() {
        while (true) {
            System.out.println("\n========= Menu Admin =========");
            System.out.println("[1] Lihat Menu");
            System.out.println("[2] Tambah Menu");
            System.out.println("[3] Edit Menu");
            System.out.println("[4] Hapus Menu");
            System.out.println("[5] Keluar");
            System.out.print("Pilih: ");
            int choice = scan.nextInt();
            scan.nextLine();

            switch (choice) {
                case 1 -> showMenu();
                case 2 -> addMenu();
                case 3 -> editMenu();
                case 4 -> deleteMenu();
                case 5 -> {
                    System.out.println("Keluar dari Admin.");
                    return;
                }
                default -> System.out.println("Pilihan tidak valid!");
            }
        }
    }

    private void showMenu() {
        System.out.println("\n========= Daftar Menu =========");
        Menu.tampilkanMenu();
    }

    private void addMenu() {
        System.out.print("Masukkan nama menu baru: ");
        String nama = scan.nextLine();
        System.out.print("Masukkan harga: ");
        int harga = scan.nextInt();
        scan.nextLine();

        Menu.tambahMenu(new Menu(nama, harga));
        System.out.println("Menu berhasil ditambahkan!");
    }

    private void editMenu() {
        showMenu();
        System.out.print("Pilih nomor menu yang ingin diedit: ");
        int idx = scan.nextInt();
        scan.nextLine();

        if (idx < 1 || idx > Menu.jumlahMenu) {
            System.out.println("Pilihan tidak valid!");
            return;
        }

        Menu m = Menu.daftarMenu[idx - 1];

        System.out.print("Nama baru (" + m.getNama() + "): ");
        String nama = scan.nextLine();
        if (!nama.isBlank()) m.setNama(nama);

        System.out.print("Harga baru (" + m.getHarga() + "): ");
        int harga = scan.nextInt();
        scan.nextLine();
        if (harga > 0) m.setHarga(harga);

        System.out.println("Menu berhasil diupdate!");
    }

    private void deleteMenu() {
        showMenu();
        System.out.print("Pilih nomor menu yang ingin dihapus: ");
        int idx = scan.nextInt();
        scan.nextLine();

        if (idx < 1 || idx > Menu.jumlahMenu) {
            System.out.println("Pilihan tidak valid!");
            return;
        }

        for (int i = idx - 1; i < Menu.jumlahMenu - 1; i++) {
            Menu.daftarMenu[i] = Menu.daftarMenu[i + 1];
        }
        Menu.daftarMenu[--Menu.jumlahMenu] = null;

        System.out.println("Menu berhasil dihapus!");
    }
}
