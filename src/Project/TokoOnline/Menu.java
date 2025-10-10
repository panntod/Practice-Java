package Project.TokoOnline;

public class Menu {
    private String nama;
    private int harga;

    public static Menu[] daftarMenu = new Menu[100];
    public static int jumlahMenu = 0;

    public Menu(String nama, int harga) {
        this.nama = nama;
        this.harga = harga;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public int getHarga() {
        return harga;
    }

    public void setHarga(int harga) {
        this.harga = harga;
    }

    @Override
    public String toString() {
        return nama + " : Rp " + harga;
    }

    public static void tambahMenu(Menu m) {
        daftarMenu[jumlahMenu++] = m;
    }

    public static void tampilkanMenu() {
        System.out.println("\n========= Menu Customer =========");
        for (int i = 0; i < jumlahMenu; i++) {
            System.out.println((i + 1) + ". " + daftarMenu[i]);
        }
    }

    static {
        tambahMenu(new Menu("Ayam Mentah", 20000));
        tambahMenu(new Menu("Daging Mentah", 25000));
        tambahMenu(new Menu("Nugget", 19000));
        tambahMenu(new Menu("Sosis", 18000));
        tambahMenu(new Menu("Es Cincau kemasan", 6000));
        tambahMenu(new Menu("Es Teh Botol", 5000));
        tambahMenu(new Menu("Teh Tarik kemasan", 9000));
        tambahMenu(new Menu("Kopi Kemasan", 3000));
    }
}
