package Project.Laundry;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class Transaction {
    private Scanner scan = new Scanner(System.in);

    private ArrayList<Integer> transactionId = new ArrayList<>();
    private ArrayList<Integer> userId = new ArrayList<>();
    private ArrayList<Integer> laundryWeight = new ArrayList<>();
    private ArrayList<Integer> laundryPrice = new ArrayList<>();
    private ArrayList<Integer> laundryId = new ArrayList<>();
    private ArrayList<LocalDateTime> createdAt = new ArrayList<>();
    private ArrayList<Integer> totalPrice = new ArrayList<>();

    private int transactionCounter = 1; // auto increment ID

    public void setTransaction(Integer userId, Integer laundryId, Integer laundryPrice, Integer laundryWeight, Integer totalPrice){
        this.transactionId.add(transactionCounter++);
        this.userId.add(userId);
        this.laundryId.add(laundryId);
        this.laundryWeight.add(laundryWeight);
        this.laundryPrice.add(laundryPrice);
        this.totalPrice.add(totalPrice);
        this.createdAt.add(LocalDateTime.now());
    }

    public void interact(Admin admin, Customer customer, Type type) {
        System.out.println("\n========= Selamat Datang di Kasir =========");

        admin.showAdmins();

        System.out.print("\nMasukan Id Admin:");
        int adminId = scan.nextInt();

        if(adminId >= admin.getAdminsLength()) {
            System.out.println("Admin tidak ditemukan!");
            return;
        }

        System.out.println("Login sebagai: " + admin.getName(adminId));

        while(true){
            System.out.println("\n========= Menu Admin =========");
            System.out.println("[1] Lihat User");
            System.out.println("[2] Tambah User");
            System.out.println("[3] Edit User");
            System.out.println("[4] Hapus User");
            System.out.println("[5] Lihat Jenis Project.Laundry");
            System.out.println("[6] Tambah Jenis Project.Laundry");
            System.out.println("[7] Edit Jenis Project.Laundry");
            System.out.println("[8] Hapus Jenis Project.Laundry");
            System.out.println("[9] Proses Transaksi");
            System.out.println("[10] Laporan Transaksi");
            System.out.println("[0] Keluar");
            System.out.print("Pilih: ");

            int choice = scan.nextInt();
            scan.nextLine();

            switch (choice){
                case 1 -> customer.showCustomer();
                case 2 -> customer.createNewCustomer();
                case 3 -> {
                    System.out.print("Masukan id customer:");
                    int customerId = scan.nextInt();
                    scan.nextLine();

                    customer.updateCustomer(customerId);
                }
                case 4 -> {
                    System.out.print("Masukan id customer:");
                    int customerId = scan.nextInt();
                    scan.nextLine();

                    customer.deleteCustomer(customerId);
                }
                case 5 -> type.showLaundryTypes();
                case 6 -> type.createNewLaundryTypes();
                case 7 -> {
                    System.out.print("Masukan id jenis loundry:");
                    int typeId = scan.nextInt();
                    scan.nextLine();

                    type.updateLaundryTypes(typeId);
                }
                case 8 -> {
                    System.out.print("Masukan Id jenis loundry:");
                    int typeId = scan.nextInt();
                    scan.nextLine();

                    type.deleteLaundryTypes(typeId);
                }
                case 9 -> processTransaction(customer, type);
                case 10 -> showReportTransaction(customer, type);
                case 0 -> {
                    System.out.println("Terimakasih sudah menggunakan aplikasi");
                    scan.close();
                    System.exit(0);
                }
                default -> System.out.println("Pilihan tidak valid!");
            }
        }

    }

    public void processTransaction(Customer customer, Type type) {
        customer.showCustomer();
        System.out.print("\nMasukan Id Pembeli: ");
        int customerId = scan.nextInt();

        if(customerId >= customer.getCustomersLength()) {
            System.out.println("Pembeli tidak ditemukan!");
            return;
        }

        System.out.println("Atas nama " + customer.getName(customerId));
        System.out.println("Silahkan pilih jenis laundry: ");
        type.showLaundryTypes();

        System.out.print("Pilih jenis laundry: ");
        int inputLaundryId = scan.nextInt();

        if(inputLaundryId >= type.getLaundrysLength()){
            System.out.println("Jenis Project.Laundry tidak ditemukan!");
            return;
        }

        System.out.print("Masukan berat laundry (kg): ");
        int inputWeight = scan.nextInt();
        int pricePerKg = type.getLaundryPrice(inputLaundryId);
        int totalPrice = inputWeight * pricePerKg;

        int currentBalance = customer.getBalance(customerId);

        if (currentBalance < totalPrice) {
            System.out.println("Saldo tidak mencukupi. Saldo Anda: Rp " + currentBalance + ", Total: Rp " + totalPrice);
            System.out.print("Isi saldo tambahan: Rp ");
            int topUp = scan.nextInt();
            scan.nextLine();

            currentBalance += topUp;
            customer.setCustomerBalance(customerId, currentBalance);

            if (currentBalance < totalPrice) {
                System.out.println("Maaf, saldo masih kurang. Transaksi dibatalkan!");
                return;
            }
        }

        customer.setCustomerBalance(customerId, currentBalance - totalPrice);
        setTransaction(customerId, inputLaundryId, pricePerKg, inputWeight, totalPrice);
        checkoutTransaction(customer, type);
    }

    void checkoutTransaction(Customer customer, Type type){
        System.out.println("\n========= Struk Transaksi =========");

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        for (int i = 0; i < transactionId.size(); i++) {
            int userId = this.userId.get(i);

            System.out.println("ID Transaksi : " + transactionId.get(i));
            System.out.println("Tanggal      : " + createdAt.get(i).format(formatter));
            System.out.println("Pelanggan    : " + customer.getName(userId));
            System.out.println("Alamat       : " + customer.getAddress(userId));
            System.out.println("Telp/Email   : " + customer.getPhoneNumber(userId) + " / " + customer.getEmail(userId));
            System.out.println("Project.Laundry      : " + type.getLaundryType(laundryId.get(i)));
            System.out.println("Berat        : " + laundryWeight.get(i) + " kg");
            System.out.println("Harga/kg     : RP " + laundryPrice.get(i));
            System.out.println("Total Bayar  : Rp " + totalPrice.get(i));
            System.out.println("Sisa Saldo   : RP " + customer.getBalance(userId));
            System.out.println("===================================");
        }
    }

    public void showReportTransaction(Customer customer, Type type) {
        if (transactionId.isEmpty()) {
            System.out.println("\nBelum ada transaksi!");
            return;
        }

        System.out.println("\n========= Laporan Transaksi =========");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        System.out.printf("| %-3s | %-20s | %-15s | %-10s | %-8s | %-20s | %-20s | %-30s |\n",
                "ID", "Customer", "Laundry", "Harga/kg", "Berat", "Total", "Tanggal", "Kontak");

        for (int i = 0; i < transactionId.size(); i++) {
            int userId = this.userId.get(i);
            int laundryId = this.laundryId.get(i);

            System.out.printf("| %-3d | %-20s | %-15s | Rp %-7d | %-8d | Rp %-17d | %-20s | %-30s |\n",
                    transactionId.get(i),
                    customer.getName(userId),
                    type.getLaundryType(laundryId),
                    laundryPrice.get(i),
                    laundryWeight.get(i),
                    totalPrice.get(i),
                    createdAt.get(i).format(formatter),
                    customer.getPhoneNumber(userId) + "/" + customer.getEmail(userId)
            );
        }
    }
}
