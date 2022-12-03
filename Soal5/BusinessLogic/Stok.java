package BusinessLogic;

public class Stok {
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
