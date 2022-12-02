import java.util.Scanner;

class Matriks {
  private String name;
  private static int BARIS = 4;
  private static int KOLOM = 4;
  private Double[][] arr; 

  public Matriks(Scanner sc, String _name) {
    name = _name;
    arr = new Double[BARIS][KOLOM];
    initData(sc);
  }

  public void initData(Scanner sc) {
    System.out.println("Inisialisasi Matriks " + name );
    for (int i = 0; i < BARIS; i++) {
      for (int j = 0; j < KOLOM; j++) {
        System.out.printf("Nilai Baris %d - Kolom %d: ", i + 1, j + 1);
        arr[i][j] = sc.nextDouble();
        sc.nextLine();
      }
    }
  }
  
  public void tambahDuaMatriks(Matriks matriks) {
    System.out.println("\nHasil Cetak " + name);

    for (int i = 0; i < Matriks.BARIS; i++) {
      for (int j = 0; j < Matriks.KOLOM; j++) {
        arr[i][j] = arr[i][j] + matriks.getArr()[i][j];        
      }
    }
  }

  public Double[][] getArr() {
    return arr;
  } 

  public void cetakMatriks() {
    System.out.println("");

    for (int i = 0; i < BARIS; i++) {
      for (int j = 0; j < KOLOM; j++) {
        System.out.print(arr[i][j] + " ");
      }

      System.out.println("");
    }
  }
}

public class Soal7 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    Matriks matriks1 = new Matriks(sc, "Matriks 1");
    Matriks matriks2 = new Matriks(sc, "Matriks 2");
  
    matriks1.tambahDuaMatriks(matriks2);
    
    System.out.print("\033[H\033[2J");  
    System.out.flush();  
    matriks1.cetakMatriks();

    sc.close();
  }
}
