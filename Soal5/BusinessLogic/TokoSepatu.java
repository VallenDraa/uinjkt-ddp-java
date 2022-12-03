package BusinessLogic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class TokoSepatu {
  // data terkait stok yang toko sediakan
  public final static ArrayList<Integer> SIZE_TERSEDIA = new ArrayList<>(Arrays.asList(40, 41, 42, 43, 44, 45)); 
  private final static int QTY_STOK = 5;
  private final static int QTY_VARIAN_SIZE = 6;

  // inisialisasi data merek tersedia
  public final static ArrayList<Merek> merekTersedia = new ArrayList<>(
    Arrays.asList(new Merek("nike", 300), new Merek("adidas", 250), new Merek("vans", 200))
  );

  // data keuangan toko
  private double profit = 0;
  public HashMap<String, Stok[]> stok = new HashMap<>();
  
  public TokoSepatu() {
    initDataStok();
  }
  
  private void initDataStok() {
    merekTersedia.forEach((merek) -> {
      // inisialisasi array pada hashmap
      stok.put(merek.nama, new Stok[QTY_VARIAN_SIZE]);

      // inisialisasi sepatu pada array stok
      for (int i = 0; i < QTY_VARIAN_SIZE; i++) {
        Sepatu entrySepatuBaru = new Sepatu(merek.nama, merek.hargaDefault, SIZE_TERSEDIA.get(i));
        stok.get(merek.nama)[i] = new Stok(entrySepatuBaru, QTY_STOK);
      }    
    });
  }

  public int getStokSepatu(String nama, int size) {
    int qty = 0;

    for (int i = 0; i < stok.get(nama).length; i++) {
      if (stok.get(nama)[i].getSepatu().getSize() == size) {
        qty = stok.get(nama)[i].getQty();
        break;
      }
    }

    return qty;
  }

  public void kurangiStok(String nama, int size) {
   for (int i = 0; i < stok.get(nama).length; i++) {
      if (stok.get(nama)[i].getSepatu().getSize() == size) {
        stok.get(nama)[i].kurangiQty();
        break;
      }
    }
  }

  public double getProfit() {
    return profit;
  }

  public void setProfit(double _profit) {
    profit = _profit;
  }

  public void tambahProfit(double _uang) {
    profit += _uang;
  }
}
