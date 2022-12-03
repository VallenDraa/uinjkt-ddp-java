// program ini akan menjumlahkan dua matriks

import java.util.Scanner;

import BusinessLogic.Matriks;

public class Soal7 {
  static Scanner sc = new Scanner(System.in);
  static Matriks[] matriks = new Matriks[2];
  static Matriks matriksHasil = new Matriks();
  static int inputOperasi;

  static void initData(Scanner sc) {
    for (int i = 0; i < matriks.length; i++) {
      matriks[i] = new Matriks();

      System.out.println("Inisialisasi Matriks Ke - " + (i + 1));
      for (int j = 0; j < Matriks.BARIS; j++) {
        for (int k = 0; k < Matriks.KOLOM; k++) {
          System.out.printf("Nilai Baris %d - Kolom %d: ", j + 1, k + 1);
          matriks[i].getArr()[j][k] = sc.nextDouble();
          sc.nextLine();
        }
      }
    }
  }

  public static void main(String[] args) {
    // menerima input dari user
    initData(sc);

    // meminta user untuk memilih jenis operasi yang ingin dilakukan
    do {
      System.out.println("Masukkan pilihan operasi");
      System.out.println("1. Penjumlahan dua matriks");
      System.out.println("2. Pengurangan dua matriks");
      System.out.print("Input: ");
      inputOperasi = sc.nextInt();
      sc.nextLine();
    } while (inputOperasi != 1 && inputOperasi != 2);
    
    // perecabangan operasi
    if (inputOperasi == 1) {
      // proses menambahkan matriks dua ke matriks satu, dan penyetakannya
      matriksHasil.setArr(Matriks.tambahDuaMatriks(matriks[0], matriks[1]));
    } else {
      // proses pengurangan matriks dua ke matriks satu, dan penyetakannya
      matriksHasil.setArr(Matriks.kurangDuaMatriks(matriks[0], matriks[1]));
    } 

    // mencetak hasil operasi
    System.out.printf("Hasil %s antara dua matriks", inputOperasi == 1 ? "penjumlahan" : "pengurangan");
    matriksHasil.cetakMatriks();

    sc.close();
  }
}
