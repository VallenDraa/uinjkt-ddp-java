import java.util.Scanner;

import BusinessLogic.Mahasiswa;

public class Soal6 {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    Mahasiswa[] mahasiswa = new Mahasiswa[2];
    
    // menerima data dari user
    for (int i = 0; i < mahasiswa.length; i++) {
      mahasiswa[i] = new Mahasiswa();
      System.out.println("Data Mahasiswa Ke - " + (i + 1));

      System.out.print("Masukkan Nama Mahasiswa: ");
      mahasiswa[i].nama = sc.nextLine();
      
      System.out.printf("Masukkan NIM milik %s: ", mahasiswa[i].nama);
      mahasiswa[i].NIM = sc.nextLine();

      System.out.printf("Masukkan Nilai Formatif Milik %s: ", mahasiswa[i].nama);
      mahasiswa[i].nilaiFormatif = sc.nextDouble();
      sc.nextLine();
      
      System.out.printf("Masukkan Nilai UTS Milik %s: ", mahasiswa[i].nama);
      mahasiswa[i].nilaiUTS = sc.nextDouble();
      sc.nextLine();
      
      System.out.printf("Masukkan Nilai UAS Milik %s: ", mahasiswa[i].nama);
      mahasiswa[i].nilaiUAS = sc.nextDouble();
      sc.nextLine();
    
      // menghitung nilai akhir dan mutu bagi masing-masig mahasiswa
      mahasiswa[i].hitungNilaiAkhir();
      mahasiswa[i].hitungNilaiMutu();
    }
    
    // menampilkan nilai akhir masing masing mahasiswa
    System.out.println("List Nilai Akhir Mahasiswa");
    System.out.println("---------------------------");
    for (Mahasiswa mhs : mahasiswa) {
      System.out.printf("%s - %s: %.2f / %c\n", mhs.NIM, mhs.nama, mhs.nilaiAkhir, mhs.nilaiMutu);
    }


    sc.close();
  }
}
