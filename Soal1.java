import java.util.Scanner;

abstract class Harga {
    public static final int HARGA_AVANZA = 40000;
    public static final int HARGA_INOVA = 60000;
    public static final int HARGA_ALPHARD = 130000;
}

class Salesmen {
    public int inovaTerjual;
    public int avanzaTerjual;
    public int alphardTerjual;

    private double totalKomisi;
    private double komisiInova;
    private double komisiAvanza;
    private double komisiAlphard;

    public void hitungKomisi() {
        this.komisiInova = (this.inovaTerjual * Harga.HARGA_INOVA) * 0.03;
        this.komisiAvanza = (this.avanzaTerjual * Harga.HARGA_AVANZA) * 0.03;
        this.komisiAlphard = (this.alphardTerjual * Harga.HARGA_ALPHARD) * 0.03;

        this.totalKomisi = komisiAlphard + komisiAvanza + komisiInova;
    }

    public double getTotalKomisi() {
      return totalKomisi;
    }
}


public class Soal1 {
    public static void main(String[] args) {
        // inisialisasi variable
        Scanner sc = new Scanner(System.in);
        Salesmen agus = new Salesmen();

        // menerima input jumlah avanza yang terjual
        System.out.print("Berapa Jumlah Avanza Yang Terjual: ");
        agus.avanzaTerjual = sc.nextInt();
        
        // menerima input jumlah avanza yang terjual
        System.out.print("Berapa Jumlah Inova Yang Terjual: ");
        agus.inovaTerjual = sc.nextInt();
        
        // menerima input jumlah avanza yang terjual
        System.out.print("Berapa Jumlah Alphard Yang Terjual: ");
        agus.alphardTerjual = sc.nextInt();

        // ketika user sudah memasukkan semua jumlah mobil yang terjual
        agus.hitungKomisi();
        System.out.println("Komisi yang diterima Bapak Agus adalah Rp." + agus.getTotalKomisi());
        sc.close();
    }
}
