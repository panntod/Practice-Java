package Laundry;

import java.util.ArrayList;

public class Type {
    private ArrayList<String> laundryType = new ArrayList<String>();
    private ArrayList<Integer> laundryPrice = new ArrayList<Integer>();

    public Type () {
        this.laundryType.add("Cuci Kering");
        this.laundryPrice.add(3000);

        this.laundryType.add("Cuci Setrika");
        this.laundryPrice.add(5000);
    }

    public void setLaundryType(String name){
        this.laundryType.add(name);
    }

    public void setLaundryPrice(Integer price){
        this.laundryPrice.add(price);
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

    public void showLaundryTypes(){
        System.out.println("\nTabel Jenis Laundry");
        System.out.printf("| %-2s | %-12s | %-5s |\n", "Id", "Nama Barang", "Harga");
        for(int i = 0; i < getLaundrysLength(); i++){
            System.out.printf("| %-2s | %-12s | %-5s |\n", i, getLaundryType(i), getLaundryPrice(i));
        }
    }
}
