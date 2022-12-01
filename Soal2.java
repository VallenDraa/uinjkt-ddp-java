import java.util.Scanner;

class Toko {
  private final double DISKON_300 = 0.05;
  private final double DISKON_500 = 0.1;
  
  private Double diskon = 0.0;
  private Double hargaAwal = 0.0;
  private Double hargaAkhir = 0.0;

  // harga awal
  public Double getHargaAwal() {
    return hargaAwal;
  }
  public void setHargaAwal(Double hargaAwal) {
    this.hargaAwal = hargaAwal;
  }

  // diskon
  public Double getDiskon() {
    return diskon;
  }
  public void hitungDiskon() {
    if (hargaAwal >= 300000 && hargaAwal < 500000) {
      this.diskon = this.hargaAwal * this.DISKON_300;
    } else if (hargaAwal >= 500000) {
      this.diskon = this.hargaAwal * this.DISKON_500;
    } else {
      this.diskon = 0.0;
    }
    this.hargaAkhir = this.hargaAwal - this.diskon;
  }

  // harga akhir
  public Double getHargaAkhir() {
    return hargaAkhir;
  }
}

public class Soal2 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    Toko ABC = new Toko();

    // meminta user untuk memasukkan total belanjaan
    System.out.println("Jika harga belanja >= Rp.300000, anda akan mendapatkan diskon 5%");
    System.out.println("Jika harga belanja >= Rp.500000, anda akan mendapatkan diskon 10%");
    System.out.print("Masukkan total belanjaan anda: Rp.");
    ABC.setHargaAwal(sc.nextDouble());

    // mencetak struk pembelian
    ABC.hitungDiskon();
    System.out.printf("Harga awal anda adalah Rp.%.2f\n", ABC.getHargaAwal());
    System.out.printf("Diskon yang anda dapatkan Rp.%.2f\n", ABC.getDiskon()); 
    System.out.printf("Harga akhir anda adalah Rp.%.2f\n", ABC.getHargaAkhir());
    
    sc.close();
  }  
}
