package Laundry;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class Transaction {
    private Scanner scan = new Scanner(System.in);

    // Data transaksi (masih dalam bentuk list paralel)
    private ArrayList<Integer> transactionId = new ArrayList<>();
    private ArrayList<Integer> userId = new ArrayList<>();
    private ArrayList<Integer> laundryWeight = new ArrayList<>();
    private ArrayList<Integer> laundryPrice = new ArrayList<>();
    private ArrayList<Integer> laundryId = new ArrayList<>();
    private ArrayList<LocalDateTime> createdAt = new ArrayList<>();
    private ArrayList<Integer> totalPrice = new ArrayList<>();

    private int transactionCounter = 1; // auto increment ID

    public void setTransaction(Integer userId, Integer laundryId, Integer laundryPrice, Integer laundryWeight){
        this.transactionId.add(transactionCounter++);
        this.userId.add(userId);
        this.laundryId.add(laundryId);
        this.laundryWeight.add(laundryWeight);
        this.laundryPrice.add(laundryPrice);
        this.totalPrice.add(laundryWeight * laundryPrice);
        this.createdAt.add(LocalDateTime.now());
    }

    /**
     * TODO:
     * - Create CRUD Laundry Type and User
     * - Create Logic if user multiple laundry
     * - Create Logic if user balance not enaf and after transaction
     */
    public void interact(Admin admin, Customer customer, Type type) {
        System.out.println("=== Selamat Di Kasir ===");

        processTransaction(customer, type);
    }

    public void processTransaction(Customer customer, Type type) {
        customer.showCustomer();
        System.out.print("\nMasukan Id Pembeli: ");
        int inputUserId = scan.nextInt();

        if(inputUserId >= customer.getCustomersLength()) {
            System.out.println("Pembeli tidak ditemukan!");
            return;
        }

        System.out.println("Atas nama " + customer.getName(inputUserId));
        System.out.println("Silahkan pilih jenis laundry: ");
        type.showLaundryTypes();

        System.out.print("Pilih jenis laundry: ");
        int inputLaundryId = scan.nextInt();

        if(inputLaundryId >= type.getLaundrysLength()){
            System.out.println("Jenis Laundry tidak ditemukan!");
            return;
        }

        System.out.print("Masukan berat laundry (kg): ");
        int inputWeight = scan.nextInt();
        int pricePerKg = type.getLaundryPrice(inputLaundryId);

        setTransaction(inputUserId, inputLaundryId, pricePerKg, inputWeight);
        checkoutTransaction(customer, type);
    }

    void checkoutTransaction(Customer customer, Type type){
        System.out.println("\n=== Struk Transaksi ===");

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        for (int i = 0; i < transactionId.size(); i++) {
            int uid = userId.get(i);

            System.out.println("ID Transaksi : " + transactionId.get(i));
            System.out.println("Tanggal      : " + createdAt.get(i).format(formatter));
            System.out.println("Pelanggan    : " + customer.getName(uid));
            System.out.println("Alamat       : " + customer.getAddress(uid));
            System.out.println("Telp/Email   : " + customer.getPhoneNumber(uid) + " / " + customer.getEmail(uid));
            System.out.println("Laundry      : " + type.getLaundryType(laundryId.get(i)));
            System.out.println("Berat        : " + laundryWeight.get(i) + " kg");
            System.out.println("Harga/kg     : RP " + laundryPrice.get(i));
            System.out.println("Total Bayar  : Rp " + totalPrice.get(i));
            System.out.println("------------------------------");
        }
    }
}
