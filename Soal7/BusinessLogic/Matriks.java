package BusinessLogic;


public class Matriks {
  public static final int BARIS = 4;
  public static final int KOLOM = 4;
  private Double[][] arr; 

  public Matriks() {
    arr = new Double[BARIS][KOLOM];
  }
  
  public static Double[][] tambahDuaMatriks(Matriks matriks1, Matriks matriks2) {
    Double[][] temp = new Double[BARIS][KOLOM];

    for (int i = 0; i < Matriks.BARIS; i++) {
      for (int j = 0; j < Matriks.KOLOM; j++) {
        temp[i][j] = matriks1.getArr()[i][j] + matriks2.getArr()[i][j];        
      }
    }

    return temp;
  }

  public static Double[][] kurangDuaMatriks(Matriks matriks1, Matriks matriks2) {
    Double[][] temp = new Double[BARIS][KOLOM];

    for (int i = 0; i < Matriks.BARIS; i++) {
      for (int j = 0; j < Matriks.KOLOM; j++) {
        temp[i][j] = matriks1.getArr()[i][j] + matriks2.getArr()[i][j];        
      }
    }

    return temp;
  }

  public Double[][] getArr() {
    return arr;
  } 
  public void setArr(Double[][] _arr) {
    for (int i = 0; i < Matriks.BARIS; i++) {
      for (int j = 0; j < Matriks.KOLOM; j++) {
        arr[i][j] = _arr[i][j];        
      }
    }
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
