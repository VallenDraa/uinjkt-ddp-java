package BusinessLogic;

// business logic Toko
public class Toko {
  private final double DISKON_300 = 0.05;
  private final double DISKON_500 = 0.1;
  
  private Double diskon = 0.0;
  private Double hargaAwal = 0.0;
  private Double hargaAkhir = 0.0;

  // harga awal
  public Double getHargaAwal() {
    return hargaAwal;
  }
  public void setHargaAwal(Double _hargaAwal) {
    hargaAwal = _hargaAwal;
  }

  // diskon
  public Double getDiskon() {
    return diskon;
  }
  public void hitungDiskon() {
    if (hargaAwal >= 300000 && hargaAwal < 500000) {
      diskon = hargaAwal * DISKON_300;
    } else if (hargaAwal >= 500000) {
      diskon = hargaAwal * DISKON_500;
    } else {
      diskon = 0.0;
    }
    hargaAkhir = hargaAwal - diskon;
  }

  // harga akhir
  public Double getHargaAkhir() {
    return hargaAkhir;
  }
}