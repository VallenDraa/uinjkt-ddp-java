import java.util.Scanner;

class Matriks {
  private String name;
  private static int BARIS = 4;
  private static int KOLOM = 4;
  private Double[][] arr; 

  public Matriks(String _name) {
    name = _name;
    arr = new Double[BARIS][KOLOM];
    initData();
  }

  public void initData() {
    Scanner sc = new Scanner(System.in);

    System.out.println("Inisialisasi Matriks " + name );
    for (int i = 0; i < BARIS; i++) {
      for (int j = 0; j < KOLOM; j++) {
        System.out.printf("Nilai Baris %d - Kolom %d: ", i + 1, j + 1);
        arr[i][j] = sc.nextDouble();
        sc.nextLine();
      }
    }

    sc.close();
  }
  
  public void tambahDuaMatriks(Matriks matriks) {
    for (int i = 0; i < Matriks.BARIS; i++) {
      for (int j = 0; j < Matriks.KOLOM; j++) {
        arr[i][j] = matriks.getArr()[i][j];        
      }
    }
  }

  public Double[][] getArr() {
    return arr;
  } 

  public void cetakMatriks() {
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
    Matriks matriks1 = new Matriks("Matriks 1");
    Matriks matriks2 = new Matriks("Matriks 2");
  
    matriks1.tambahDuaMatriks(matriks2);
    matriks1.cetakMatriks();
  }
}
