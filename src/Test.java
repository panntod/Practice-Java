import java.math.BigDecimal;

public class Test {
    /**
     * Disini saya mencoba untuk menambahkan dua bilangan desimal yang hasil nya tidak pas menurut pemikiran manusia,
     * hal ini bisa terjadi karena komputer berhitung menggunakan base-2 sedangkan manusia terbiasa menggunakan base-10,
     * karena perbedaan ini lah bisa terjadi perhitungan yang tidak ada henti nya, dalam kasus komputer seperti 0.1 + 0.2
     * maka hasil nya adalah 0.300004 dan dalam kasus manusia 3/ 10
     */

    /**
     * Saya juga mencoba mencari tahu apa perbedaan int dengan Integer dan juga char dengan String, ternyata inr dan char
     * adalah tipe data primitif yang biasa digunakan di java, sedangkan Integer dan String adalah tipe data objek, pedbedaan
     * ini ditandai dengan cara penamaan variabel diawali dengan huruf besar.
     */
    public static void main(String[] args) {
        double _a = 0.1;
        double _b = 0.2;

        System.out.println(_a + _b);
        System.out.println(_a + _a);
        System.out.println(_b + _b);
//        System.out.printf("%.20f%n", _a + _b);

        System.out.println("----------------");

        float _c = 0.1f;
        float _d = 0.2f;

        System.out.println(_c + _d);
        System.out.println(_c + _c);
        System.out.println(_d + _d);
        System.out.println(String.format("%.20f", _c + _d));
//        System.out.printf("%.20f%n", _c + _d);

        System.out.println("----------------");

        BigDecimal a = new BigDecimal("0.1");
        BigDecimal b = new BigDecimal("0.2");
        System.out.println(a.add(b));
//        System.out.printf("%.20f", a.add(b));

        char inisial = 'A';
        String namaLengkap = "Pandhu Arya Munjalindra";
        int umurInt = 10;
        Integer umurInteger = 10;
    }
}
