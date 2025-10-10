package Project.Laundry;

import java.util.ArrayList;
import java.util.Scanner;

public class Type {
    Scanner scan = new Scanner(System.in);

    private ArrayList<String> laundryType = new ArrayList<String>();
    private ArrayList<Integer> laundryPrice = new ArrayList<Integer>();

    public Type () {
        this.laundryType.add("Cuci Kering");
        this.laundryPrice.add(3000);

        this.laundryType.add("Cuci Setrika");
        this.laundryPrice.add(5000);
    }

    public String getLaundryType(Integer id){
        return this.laundryType.get(id);
    }

    public Integer getLaundryPrice(Integer id){
        return this.laundryPrice.get(id);
    }

    public Integer getLaundrysLength(){
        return this.laundryType.size();
    }

    // ========================= CRUD =========================

    // Read

    public void showLaundryTypes(){
        System.out.println("\nTabel Jenis Project.Laundry");
        System.out.printf("| %-2s | %-12s | %-5s |\n", "Id", "Nama Barang", "Harga");
        for(int i = 0; i < getLaundrysLength(); i++){
            System.out.printf("| %-2s | %-12s | %-5s |\n", i, getLaundryType(i), getLaundryPrice(i));
        }
    }

    // Create
    public void createNewLaundryTypes() {
        System.out.print("Masukan jenis loundry: ");
        this.laundryType.add(scan.nextLine());

        System.out.print("Masukan harga loundry: ");
        this.laundryPrice.add(scan.nextInt());
        scan.nextLine(); // buang newline

        System.out.println("Project.Laundry berhasil dibuat ");
    }

    // Update
    public void updateLaundryTypes(int id) {
        if (id < 0 || id >= getLaundrysLength()) {
            System.out.println("Id tidak valid!");
            return;
        }

        System.out.println("Update data untuk Id: " + id);
        System.out.print("Jenis loundry baru (" + getLaundryType(id) + "): ");
        this.laundryType.set(id, scan.nextLine());

        System.out.print("Harga loundry baru (" + getLaundryPrice(id) + "): ");
        this.laundryPrice.set(id, scan.nextInt());
        scan.nextLine();

        System.out.println("Project.Laundry berhasil diperbarui!");
    }

    // Delete
    public void deleteLaundryTypes(int id) {
        if (id < 0 || id >= getLaundrysLength()) {
            System.out.println("Id tidak valid!");
            return;
        }

        System.out.println("Menghapus jenis loundry: " + getLaundryType(id));
        this.laundryType.remove(id);
        this.laundryPrice.remove(id);

        System.out.println("Project.Laundry berhasil dihapus!");
    }
}
