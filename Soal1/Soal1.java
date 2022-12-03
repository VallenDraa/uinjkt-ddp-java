/*
 *  Program ini adalah file I/O untuk menghitung komisi 
 *  yang seorang salesmen benrama bapak agus dapatkan
 */

import java.util.Scanner;

import BusinessLogic.Salesmen;

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
    
    // clear screen
    System.out.println("Komisi yang diterima Bapak Agus adalah Rp." + agus.getTotalKomisi());
    sc.close();
  }
}
