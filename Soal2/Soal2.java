/*
 * Program ini akan menghitung diskon yang diterima user ketika berberlanja 
 */

import java.util.Scanner;

import BusinessLogic.Toko;


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
