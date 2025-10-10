package Project;// SOAL GANJIL
import java.util.Scanner;

public class Quiz {
    public static void main(String[] args) {
     Scanner scan = new Scanner(System.in);

     System.out.println("Masukan jumlah pinjaman: ");
     int pinjaman = scan.nextInt();

     System.out.println("Masukan lama pinjaman (bulan): ");
     int lamaPinjaman = scan.nextInt();

     double bunga = pinjaman * 0.01 * lamaPinjaman;
     double totalPinjaman = pinjaman + bunga;
     double cicilan = totalPinjaman / lamaPinjaman;

     System.out.println("Cicilan per bulan: " + cicilan);
    }
}






