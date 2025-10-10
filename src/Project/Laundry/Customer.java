package Project.Laundry;

import java.util.ArrayList;
import java.util.Scanner;

public class Customer implements IUser {
    Scanner scan = new Scanner(System.in);

    private ArrayList<String> customerName = new ArrayList<String>();
    private ArrayList<String> customerAddress = new ArrayList<String>();
    private ArrayList<String> customerPhoneNumber = new ArrayList<String>();
    private ArrayList<String> customerEmail = new ArrayList<String>();
    private ArrayList<Integer> customerBalance = new ArrayList<Integer>();

    public Customer() {
        this.customerName.add("Pandhu Arya");
        this.customerAddress.add("Ponorogo");
        this.customerPhoneNumber.add("0878748358");
        this.customerEmail.add("pandhu@gmail.com");
        this.customerBalance.add(0);

        this.customerName.add("Asfina Andini");
        this.customerAddress.add("Kepanjen");
        this.customerPhoneNumber.add("0878748352342");
        this.customerEmail.add("asfina@gmail.com");
        this.customerBalance.add(900000);
    }

    @Override
    public void setName(String name) {
        this.customerName.add(name);
    }

    @Override
    public void setAddress(String address) {
        this.customerAddress.add(address);
    }

    @Override
    public void setPhoneNumber(String phoneNumber) {
        this.customerPhoneNumber.add(phoneNumber);
    }

    @Override
    public void setEmail(String email) {
        this.customerEmail.add(email);
    }

    public String getName(Integer id) {
        return this.customerName.get(id);
    }

    public String getAddress(Integer id) {
        return this.customerAddress.get(id);
    }

    public String getPhoneNumber(Integer id) {
        return this.customerPhoneNumber.get(id);
    }

    public String getEmail(Integer id) {
        return this.customerEmail.get(id);
    }

    public Integer getBalance(Integer id) {
        return this.customerBalance.get(id);
    }

    public Integer getCustomersLength() {
        return this.customerName.size();
    }

    public void setCustomerBalance(Integer userId, Integer newBalance) {
        this.customerBalance.set(userId, newBalance);
    }

    // ========================= CRUD =========================

    // Read
    public void showCustomer() {
        System.out.println("\nTabel Nama User");
        System.out.printf("| %-2s | %-20s | %-22s | %-22s | %-28s |  %-12s |\n",
                "Id", "Nama", "Alamat", "Nomor HP", "Email", "Saldo");
        for (int i = 0; i < getCustomersLength(); i++) {
            System.out.printf("| %-2s | %-20s | %-22s | %-22s | %-28s |  %-12s |\n",
                    i, getName(i), getAddress(i), getPhoneNumber(i), getEmail(i), getBalance(i));
        }
    }

    // Create
    public void createNewCustomer() {
        System.out.print("Masukan nama user: ");
        this.customerName.add(scan.nextLine());

        System.out.print("Masukan alamat: ");
        this.customerAddress.add(scan.nextLine());

        System.out.print("Masukan nomor HP: ");
        this.customerPhoneNumber.add(scan.nextLine());

        System.out.print("Masukan email: ");
        this.customerEmail.add(scan.nextLine());

        System.out.print("Masukan saldo awal: ");
        this.customerBalance.add(scan.nextInt());
        scan.nextLine(); // buang newline

        System.out.println("Customer berhasil dibuat ");
    }

    // Update
    public void updateCustomer(int id) {
        if (id < 0 || id >= getCustomersLength()) {
            System.out.println("Id tidak valid!");
            return;
        }

        System.out.println("Update data untuk Id: " + id);
        System.out.print("Nama baru (" + getName(id) + "): ");
        this.customerName.set(id, scan.nextLine());

        System.out.print("Alamat baru (" + getAddress(id) + "): ");
        this.customerAddress.set(id, scan.nextLine());

        System.out.print("Nomor HP baru (" + getPhoneNumber(id) + "): ");
        this.customerPhoneNumber.set(id, scan.nextLine());

        System.out.print("Email baru (" + getEmail(id) + "): ");
        this.customerEmail.set(id, scan.nextLine());

        System.out.print("Saldo baru (" + getBalance(id) + "): ");
        this.customerBalance.set(id, scan.nextInt());
        scan.nextLine();

        System.out.println("Customer berhasil diperbarui!");
    }

    // Delete
    public void deleteCustomer(int id) {
        if (id < 0 || id >= getCustomersLength()) {
            System.out.println("Id tidak valid!");
            return;
        }

        System.out.println("Menghapus customer: " + getName(id));
        this.customerName.remove(id);
        this.customerAddress.remove(id);
        this.customerPhoneNumber.remove(id);
        this.customerEmail.remove(id);
        this.customerBalance.remove(id);

        System.out.println("Customer berhasil dihapus!");
    }
}
