package Laundry;

import java.util.ArrayList;

public class Admin extends User {
    private ArrayList<String> adminName = new ArrayList<String>();
    private ArrayList<String> adminAddress = new ArrayList<String>();
    private ArrayList<String> adminPhoneNumber = new ArrayList<String>();
    private ArrayList<String> adminEmail = new ArrayList<String>();

    public Admin() {
        this.adminName.add("Admin");
        this.adminAddress.add("Localhost");
        this.adminPhoneNumber.add("0878782342");
        this.adminEmail.add("admin@mail.com");
    }


    public void setName(String name) {
        this.adminName.add(name);
    }

    public void setAddress(String address) {
        this.adminAddress.add(address);
    }

    public void setPhoneNumber(String phoneNumber) {
        this.adminPhoneNumber.add(phoneNumber);
    }

    public void setEmail(String email){
        this.adminEmail.add(email);
    }

    public String getName(Integer id){
        return this.adminName.get(id);
    }

    public String getAddress(Integer id){
        return this.adminAddress.get(id);
    }

    public String getPhoneNumber(Integer id){
        return this.adminPhoneNumber.get(id);
    }

    public String getEmail(Integer id){
        return this.adminEmail.get(id);
    }

    public Integer getAdminsLength() {
        return this.adminName.size();
    }

    public void showAdmins() {
        System.out.println("\nTabel Admin");
        System.out.printf("| %-2s | %-12s | %-12s | %-12s | %-12s |\n", "Id", "Nama", "Alamat", "Nomor HP", "Email");
        for (int i = 0; i < getAdminsLength(); i++) {
            System.out.printf("| %-2s | %-12s | %-12s | %-12s | %-12s |\n", i, getName(i), getAddress(i), getPhoneNumber(i), getEmail(i));
        }
    }
}
