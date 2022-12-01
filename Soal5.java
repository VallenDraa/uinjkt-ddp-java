import java.util.*;

class Merek {
  String nama;
  double hargaDefault;

  Merek(String _nama, double _hargaDefault) {
    nama = _nama;
    hargaDefault = _hargaDefault;
  }
}

class Sepatu {
  private String nama;
  private double harga;
  private Integer size;

  public Sepatu(String _nama, double _harga, Integer _size) {
    nama = _nama;
    
    // khusus untuk size 43
    harga = _size == 43 ? (_harga + ( _harga * 0.05)) : _harga;
    size = _size;
  }

  public String getNama() {
    return nama;
  }

  public double getHarga() {
    return harga;
  }

  public Integer getSize() {
    return size;
  }
}

class Stok {
  private Sepatu sepatu;
  private int qty;
  
  public Stok(Sepatu _sepatu, int _qty) {
    sepatu = _sepatu;
    qty = _qty;
  }

  public int getQty() {
    return qty;
  }

  public void kurangiQty() {
    qty -= 1;
  }

  public Sepatu getSepatu() {
    return sepatu;
  }
}

class Toko {
  public final static ArrayList<Merek> merekTersedia = new ArrayList<>(
    Arrays.asList(new Merek("nike", 300), new Merek("adidas", 250), new Merek("vans", 200)));

  // data terkait stok yang toko sediakan
  public final static ArrayList<Integer> SIZE_TERSEDIA = new ArrayList<>(Arrays.asList(40, 41, 42, 43, 44, 45)); 
  private final static int QTY_STOK = 5;
  private final static int QTY_VARIAN_SIZE = 6;
  
  // data keuangan toko
  private double profit = 0;
  HashMap<String, Stok[]> stok = new HashMap<>();
  
  public Toko() {
    initData();
  }
  
  private void initData() {
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
    profit = profit + _uang;
  }
}

public class Soal5 {
  static Scanner sc = new Scanner(System.in);
  static Toko abc = new Toko();

  static void menuUtama() {
    int input = 0;

    while (true) {

      ClearScreen.run();
      System.out.println("Toko sepatu ABC");
      System.out.println("1. Beli Sepatu");
      System.out.println("2. Keluar Dari Program");
      System.out.println("Profit Sementara Toko: Rp." + abc.getProfit());
      System.out.print("\nInput: ");

      input = sc.nextInt();
      sc.nextLine();

      // router menu
      if (input == 1) {
        menuCatalogSepatu();
      } else if (input == 2) {
        break;
      }
    }
  }

  static void menuCatalogSepatu() {
    int input = 0;
    ClearScreen.run();

    for (int i = 0; i < Toko.merekTersedia.size(); i++) {
      System.out.printf("%d. %s\n", (i + 1), Toko.merekTersedia.get(i).nama);
    }

    while (true) {
      System.out.print("Masukkan merek sepatu yang ingin dibeli: ");
      input = sc.nextInt();
      sc.nextLine();
      
      if (input >= 1 && input <= Toko.merekTersedia.size()) {
        menuPembelian(Toko.merekTersedia.get(input - 1).nama, input - 1);
        break;
      }
    }
  }

  static void menuPembelian(String nama, int idxSepatu) {
    int input;
    ClearScreen.run();
    System.out.println("Data sepatu merek " + nama);

    // mencetak dan meminta user untuk memasukkan ukuran yang diinginkan
    for (int i = 0; i < abc.stok.get(nama).length; i++) {
      int size = abc.stok.get(nama)[i].getSepatu().getSize();
      double harga = abc.stok.get(nama)[i].getSepatu().getHarga();
      int qtySepatu = abc.getStokSepatu(nama, size);

      System.out.printf("%d. size[%d] & stok[%d]: Rp.%.2f\n", (i + 1), size, qtySepatu, harga);      
    }
    
    while (true) {      
      System.out.print("Masukkan ukuran sepatu yang ingin dibeli: ");
      input = sc.nextInt();
      sc.nextLine();

      if (input - 1 < Toko.SIZE_TERSEDIA.size()) {
        int size = Toko.SIZE_TERSEDIA.get(input - 1);

        if (abc.getStokSepatu(nama, size) > 0){
          abc.kurangiStok(nama, size);
          abc.tambahProfit(abc.stok.get(nama)[input - 1].getSepatu().getHarga());
     
          ClearScreen.run();
          System.out.print("Pembelian berhasil !");
          sc.nextLine();
          break;
        }
      }
    }
  }

  public static void main(String[] args) {
    menuUtama();
    sc.close();
  }
}
