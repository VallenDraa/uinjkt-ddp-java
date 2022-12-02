package BusinessLogic;

// business logic salesmen
public class Salesmen {
  public int inovaTerjual;
  public int avanzaTerjual;
  public int alphardTerjual;

  private double totalKomisi;
  private double komisiInova;
  private double komisiAvanza;
  private double komisiAlphard;

  public void hitungKomisi() {
    this.komisiInova = (this.inovaTerjual * Harga.HARGA_INOVA) * 0.03;
    this.komisiAvanza = (this.avanzaTerjual * Harga.HARGA_AVANZA) * 0.03;
    this.komisiAlphard = (this.alphardTerjual * Harga.HARGA_ALPHARD) * 0.03;

    this.totalKomisi = komisiAlphard + komisiAvanza + komisiInova;
  }

  public double getTotalKomisi() {
    return totalKomisi;
  }
}