package BusinessLogic;

public class Sepatu {
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