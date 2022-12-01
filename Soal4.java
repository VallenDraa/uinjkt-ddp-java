import java.util.Scanner;

public class Soal4 {
  private static boolean isKabisat(int tahun) {
    return (tahun % 400 == 0) || (tahun % 100 != 0 && tahun %4 == 0);
  }

  public static void main(String[] args) {
    int tahun;

    Scanner sc = new Scanner(System.in);

    do {
      System.out.print("Masukkan sebuah tahun: ");
      tahun = sc.nextInt();
      sc.nextLine();
    } while (tahun < 1945 || tahun > 2022);

    if (isKabisat(tahun)) {
      System.out.println(tahun + " adalah tahun kabisat");
    } else {
      System.out.println(tahun + " bukan tahun kabisat");
    }

    sc.close();
  }
}
