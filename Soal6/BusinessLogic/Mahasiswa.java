package BusinessLogic;

// Business logic mahasiswa
public class Mahasiswa {
  public static final double PERSENSI_FORMATIF = 0.4;
  public static final double PERSENSI_UTS = 0.3;
  public static final double PERSENSI_UAS = 0.3;

  public String NIM = "";
  public String nama = "";
  public double nilaiFormatif = 0;
  public double nilaiUTS = 0;
  public double nilaiUAS = 0;
  public double nilaiAkhir;
  public char nilaiMutu;

  // method terkait nilai akhir
  public void hitungNilaiAkhir() {
    nilaiAkhir = (nilaiFormatif * PERSENSI_FORMATIF) + 
                 (nilaiUAS * PERSENSI_UAS) + 
                 (nilaiUTS * PERSENSI_UTS);
  }
  public double getNilaiAkhir() {
    return nilaiAkhir;
  }

  // method terkait nilai mutu
  public void hitungNilaiMutu() {
    if (nilaiAkhir >= 80) {
      nilaiMutu = 'A';
    } else if (nilaiAkhir >= 70) {
      nilaiMutu = 'B';
    } else if (nilaiAkhir >= 60) {
      nilaiMutu = 'C';
    } else if (nilaiAkhir >= 50) {
      nilaiMutu = 'D';
    } else if (nilaiAkhir >= 40){
      nilaiMutu = 'E';
    } else {
      nilaiMutu = 'F';
    }
  }
  public char getNilaiMutu() {
    return nilaiMutu;
  }
}