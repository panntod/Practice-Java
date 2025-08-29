package Laundry;

import java.util.ArrayList;

public class Customer implements IUser {
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

    public void setBalance(Integer balance) {
        this.customerBalance.add(balance);
    }

    public void editBalance(Integer id, Integer newBalance) {
        this.customerBalance.set(id, newBalance);
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

    public void showCustomer() {
        System.out.println("\nTabel Nama User");
        System.out.printf("| %-2s | %-20s | %-22s | %-22s | %-28s |  %-12s |\n", "Id", "Nama", "Alamat", "Nomor HP", "Email", "Saldo");
        for (int i = 0; i < getCustomersLength(); i++) {
            System.out.printf("| %-2s | %-20s | %-22s | %-22s | %-28s |  %-12s |\n", i, getName(i), getAddress(i), getPhoneNumber(i), getEmail(i), getBalance(i));
        }
    }
}
