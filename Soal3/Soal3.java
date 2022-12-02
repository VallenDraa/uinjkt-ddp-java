// program ini akan menghitung besaran faktorial sesuai dengan input user

import java.util.Scanner;

public class Soal3 {
  public static void main(String[] args) {
    int input;
    int hasil = 1;
    Scanner sc = new Scanner(System.in);

    // meminta input user
    System.out.print("Masukkan jumlah faktorial: ");
    input = sc.nextInt();

    // algoritma menghitung
    for (int i = input; i > 1; i--) hasil = hasil * i;

    System.out.println("Hasil: " + hasil);
    sc.close();
  }  
}