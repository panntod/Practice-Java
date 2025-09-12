import java.math.BigDecimal;

public class Test {
    /**
     * Disini saya mencoba untuk menambahkan dua bilangan desimal yang hasil nya tidak pas menurut pemikiran manusia,
     * hal ini bisa terjadi karena komputer berhitung menggunakan base-2 sedangkan manusia terbiasa menggunakan base-10,
     * karena perbedaan ini lah bisa terjadi perhitungan yang tidak ada henti nya, dalam kasus komputer seperti 0.1 + 0.2
     * maka hasil nya adalah 0.300004 dan dalam kasus manusia 3/ 10
     */
    public static void main(String[] args) {
        double _a = 0.1;
        double _b = 0.2;

        System.out.println(_a + _b);
        System.out.println(_a + _a);
        System.out.println(_b + _b);

        BigDecimal a = new BigDecimal("0.1");
        BigDecimal b = new BigDecimal("0.2");
        System.out.println(a.add(b));
    }
}
