class Sepatu {
  private String nama;
  private double harga;
  private int size;

  public Sepatu(String _nama, double _harga, int size) {
    nama = _nama;
    
    // khusus untuk size 43
    harga = size == 43 ? (_harga * ( _harga * 0.05)) : _harga;
  }

  public String getNama() {
    return nama;
  }

  public double getHarga() {
    return harga;
  }

  public int getSize() {
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

  public void beli() {
    qty -= 1;
  }

  public int getQty() {
    return qty;
  }

  public void setQty(int qty) {
    this.qty = qty;
  }

  public Sepatu getSepatu() {
    return sepatu;
  }
}

class Toko {
  private final int SIZE_DEFAULT = 40; 
  Stok[] stokNike = new Stok[5];
  Stok[] stokAdidas = new Stok[5];
  Stok[] stokVans = new Stok[5];

  public Toko() {
    initData();
  }

  private void initData() {
    for (int i = 0; i < 5; i++) {
      stokNike[i] = new Stok(new Sepatu("Nike", 300, SIZE_DEFAULT + i), 5);
      stokAdidas[i] = new Stok(new Sepatu("Adidas", 250, SIZE_DEFAULT + i), 5);
      stokVans[i] = new Stok(new Sepatu("Vans", 200, SIZE_DEFAULT + i), 5);
    }    
  }

  public int getStokSepatu(Stok stok[], String nama, int size) {
    int qty = 0;

    for (int i = 0; i < stok.length; i++) {
      if (stok[i].getSepatu().getNama().equals(nama) &&
          stok[i].getSepatu().getSize() == size
      ) {
        qty = stok[i].getQty();
      }
    }

    return qty;
  }

  public void reduceStok(Stok stok[], String nama, int size) {
    for (Stok item : stok) {
     if (item.getSepatu().getNama().equals(nama) &&
         item.getSepatu().getSize() == size
      ) {
        item.setQty(item.getQty() - 1);
      } 
    }
  }

}

public class Soal5 {
  public static void main(String[] args) {
    Toko toko = new Toko();

    for (Stok stok : toko.stokAdidas) {
      System.out.println(stok.getSepatu().getSize());
    }
    // while (true) {
    // }    
  }
}
